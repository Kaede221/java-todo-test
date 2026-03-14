package com.todo.mapper;

import com.todo.pojo.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TaskMapper {
    @Select("select * from all_tasks where id = #{id}")
    Task getTaskById(@Param("id") int id);

    @Select("SELECT * from all_tasks")
    List<Task> getAllTasks();

    @Delete("DELETE from all_tasks where id = #{id}")
    void deleleTaskById(@Param("id") int id);

    @Insert("INSERT INTO all_tasks (title, content, done) values (#{title}, #{content}, false)")
    void addNewTask(@Param("title") String title, @Param("content") String content);

    @Update("UPDATE all_tasks SET title = #{title}, content = #{content}, done = #{done} WHERE id = #{id}")
    void editTaskById(@Param("id") int id, @Param("title") String title, @Param("content") String content, @Param("done") boolean done);
}
