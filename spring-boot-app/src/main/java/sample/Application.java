package sample; /**
 * Created by shimizukazuki on 2015/06/26.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.domain.model.Todo;
import sample.domain.repository.TodoRepository;


@MapperScan("sample.domain.repository")
@SpringBootApplication
public class Application {

    @RequestMapping("/todos")
    @RestController
    static class TodoController {
        @Autowired
        TodoRepository todoRepository;

        @RequestMapping("/{todoId}")
        public Todo getTodo(@PathVariable("todoId") String todoId) {
            return todoRepository.findOne(todoId);
        }
    }

    public static void main(String[] arguments) {
        SpringApplication.run(Application.class, arguments);
    }


}
