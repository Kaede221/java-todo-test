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

    @Test
    public void testGetTaskById() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskMapper taskMapper = context.getBean("taskMapper", TaskMapper.class);

        Task task = taskMapper.getTaskById(1);
        System.out.println(task);
    }

    @Test
    public void testAddTask() {
        String title = "New Task Title";
        String content = "New Task Content";

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskMapper taskMapper = context.getBean("taskMapper", TaskMapper.class);

        taskMapper.addNewTask(title, content);
        System.out.println("添加成功");

        List<Task> tasks = taskMapper.getAllTasks();
        System.out.println(tasks);
    }

    @Test
    public void testDeleteTaskById() {
        int id = 3;

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskMapper taskMapper = context.getBean("taskMapper", TaskMapper.class);

        taskMapper.deleleTaskById(id);
        System.out.println("删除成功");

        List<Task> tasks = taskMapper.getAllTasks();
        System.out.println(tasks);
    }

    @Test
    public void testEditTaskById() {
        int id = 1;

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskMapper taskMapper = context.getBean("taskMapper", TaskMapper.class);

        taskMapper.editTaskById(id, "New Title 2", "New Content 2", false);
        System.out.println("修改成功");

        List<Task> tasks = taskMapper.getAllTasks();
        System.out.println(tasks);
    }
}
