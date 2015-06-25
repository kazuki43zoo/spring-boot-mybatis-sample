package sample.domain.repository;


import org.apache.ibatis.annotations.Select;
import sample.domain.model.Todo;

public interface TodoRepository {

    @Select("SELECT * FROM todo WHERE todo_id = #{todoId}")
    Todo findOne(String todoId);
}
