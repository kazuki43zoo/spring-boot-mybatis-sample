package sample; /**
 * Created by shimizukazuki on 2015/06/26.
 */

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.domain.model.Todo;
import sample.domain.repository.TodoRepository;

import javax.sql.DataSource;


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

//    @Bean
//    SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        return factoryBean;
//    }
//
//    @Bean
//    EmbeddedDatabaseFactoryBean dataSource() {
//        EmbeddedDatabaseFactoryBean factoryBean = new EmbeddedDatabaseFactoryBean();
//        factoryBean.setDatabaseType(EmbeddedDatabaseType.H2);
//        factoryBean.setDatabaseName("spring-boot-sample");
//        factoryBean.setDatabasePopulator(new ResourceDatabasePopulator(
//                new ClassPathResource("schema.sql"),
//                new ClassPathResource("data.sql")
//        ));
//        return factoryBean;
//    }

    public static void main(String[] arguments) {
        SpringApplication.run(Application.class, arguments);
    }


}
