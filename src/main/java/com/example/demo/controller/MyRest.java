package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.util.ResourceUtils;

import com.example.demo.DemoApplication;
import com.example.demo.dto.User;
import com.example.demo.mapper.UserMapper;


@Path("/permissions")
public class MyRest {
	private static SqlSessionFactory sqlSessionFactory = null;
	
	@GET
	@Path("/test")
	public String test() {

		try {
			if (sqlSessionFactory == null) {
				synchronized (MyRest.class) {
					if (sqlSessionFactory == null) {
						File file = ResourceUtils.getFile("classpath:mybatis-config.xml");
						InputStream inputStream = new FileInputStream(file);
						System.out.println(inputStream);
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
						
					}
				}
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.select1(69);
			System.out.println(user.getId());
			System.out.println(user.getName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		return "";
	}

//	@POST
//	@Path("/login")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public User getGoldPrice(User param1) {
//		System.out.println(param1.getUserName());
//		System.out.println(param1.getPassword());
//		User user = new User();
//		user.setUserName("Ricardo");
//		user.setPassword("password");
//		return user;
//	}
}