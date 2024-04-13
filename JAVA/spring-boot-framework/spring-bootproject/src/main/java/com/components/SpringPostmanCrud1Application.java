package com.components;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.components.model.Student;
import com.components.repository.StudentDao;
import com.components.service.impl.StudentServiceImpl;

@SpringBootApplication(scanBasePackages = "com.components")
public class SpringPostmanCrud1Application {

	public static void main(String[] args) 
	{
		ApplicationContext context = SpringApplication.run(SpringPostmanCrud1Application.class, args);
		StudentServiceImpl bean = context.getBean(StudentServiceImpl.class);
		
		Student s = new Student();
		s.setStudentId(1011);
		s.setStudentName("Hemanth");
		s.setStudentAddress("Banglore");
		
		bean.save(s);
		
		
	}

}
