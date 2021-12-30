package com.example.demo;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.MyRest;
import com.example.demo.dto.User;
import com.example.demo.mapper.UserMapper;

@SpringBootApplication
public class DemoApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
