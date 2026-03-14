import com.todo.config.AppConfig;
import com.todo.mapper.TaskMapper;
import com.todo.pojo.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class MyTest {
    // 直接自动注入，并且放在这里
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testGetAllTasks() {
        List<Task> tasks = taskMapper.getAllTasks();
        System.out.println(tasks);
    }

    @Test
    public void testGetTaskById() {
        Task task = taskMapper.getTaskById(1);
        System.out.println(task);
    }

    @Test
    public void testAddTask() {
        String title = "New Task Title";
        String content = "New Task Content";

        taskMapper.addNewTask(title, content);
        System.out.println("添加成功");

        List<Task> tasks = taskMapper.getAllTasks();
        System.out.println(tasks);
    }

    @Test
    public void testDeleteTaskById() {
        int id = 3;

        taskMapper.deleleTaskById(id);
        System.out.println("删除成功");

        List<Task> tasks = taskMapper.getAllTasks();
        System.out.println(tasks);
    }

    @Test
    public void testEditTaskById() {
        int id = 1;

        taskMapper.editTaskById(id, "New Title 2", "New Content 2", false);
        System.out.println("修改成功");

        List<Task> tasks = taskMapper.getAllTasks();
        System.out.println(tasks);
    }
}
