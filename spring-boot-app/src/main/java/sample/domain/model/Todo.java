package sample.domain.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class Todo {
    private String todoId;
    private String todoTitle;
    private boolean finished;
    private DateTime createdAt;
}
