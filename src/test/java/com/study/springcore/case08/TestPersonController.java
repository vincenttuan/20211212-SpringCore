package com.study.springcore.case08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonController {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		PersonController personController = ctx.getBean("personController", PersonController.class);
		
		//personContolller.printAllPersons();
		//personContolller.addPerson("Bob", 2013, 12, 26);
		//personContolller.printAllPersons();
		
		System.out.println(personController.getPersonByName("Randy"));
		System.out.println(personController.getPersonByName("Tom"));
	}

}
