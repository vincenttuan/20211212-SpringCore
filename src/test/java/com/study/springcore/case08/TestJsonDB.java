package com.study.springcore.case08;

import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJsonDB {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		JsonDB jsonDB = ctx.getBean("jsonDB", JsonDB.class);
		System.out.println(jsonDB.queryAll());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		boolean check = jsonDB.add(new Person("John", 0, sdf.parse("2000/1/1")));
		System.out.println(check);
		
		System.out.println(jsonDB.queryAll());
	}

}
