package sample.infra.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

// (1)
public class DateTimeTypeHandler extends BaseTypeHandler<DateTime> {

    // (2)
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    DateTime parameter, JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(i, new Timestamp(parameter.getMillis()));
    }

    // (3)
    @Override
    public DateTime getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return toDateTime(rs.getTimestamp(columnName));
    }

    // (3)
    @Override
    public DateTime getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        return toDateTime(rs.getTimestamp(columnIndex));
    }

    // (3)
    @Override
    public DateTime getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return toDateTime(cs.getTimestamp(columnIndex));
    }

    private DateTime toDateTime(Timestamp timestamp) {
        // (4)
        if (timestamp == null) {
            return null;
        } else {
            return new DateTime(timestamp.getTime());
        }
    }

}
