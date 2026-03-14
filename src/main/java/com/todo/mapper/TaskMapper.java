package com.todo.mapper;

import com.todo.pojo.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TaskMapper {
    @Select("select * from all_tasks where id = #{id}")
    Task getTaskById(int id);

    @Select("SELECT * from all_tasks")
    List<Task> getAllTasks();

    @Delete("DELETE from all_tasks where id = #{id}")
    void deleleTaskById(int id);

    @Insert("INSERT INTO all_tasks (title, content, done) values (#{title}, #{content}, #{done})")
    void addNewTask(String title, String content, boolean done);
}
