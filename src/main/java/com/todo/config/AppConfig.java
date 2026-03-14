package com.todo.config;

import com.todo.mapper.TaskMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class AppConfig {

    @Bean("sqlSession")
    public SqlSession sqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory.openSession();
    }

    @Bean("taskMapper")
    public TaskMapper taskMapper() throws IOException {
        SqlSession _sqlSession = sqlSession();
        return _sqlSession.getMapper(TaskMapper.class);
    }
}
