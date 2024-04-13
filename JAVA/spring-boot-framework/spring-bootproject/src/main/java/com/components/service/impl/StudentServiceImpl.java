package com.components.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.components.model.Student;
import com.components.repository.StudentDao;
import com.components.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentDao studentDao;

	@Override
	public void save(Student student) 
	{	
		studentDao.save(student);

		
	}
}
