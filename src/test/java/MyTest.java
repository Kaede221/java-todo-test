import com.todo.config.AppConfig;
import com.todo.mapper.TaskMapper;
import com.todo.pojo.Task;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void testGetAllTasks() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskMapper taskMapper = context.getBean("taskMapper", TaskMapper.class);

        List<Task> tasks = taskMapper.getAllTasks();
        System.out.println(tasks);
    }
}
