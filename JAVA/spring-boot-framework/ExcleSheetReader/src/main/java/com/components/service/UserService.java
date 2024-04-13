package com.components.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.components.helper.MyExcelHelper;
import com.components.model.User;
import com.components.repo.UserRepo;

@Service
public class UserService 
{
	@Autowired
	private UserRepo userRepo;
	
	
	public void save(MultipartFile file)
	{
		try 
		{
			List<User> user = MyExcelHelper.convertExcelToListOfUser((InputStream)file);
			this.userRepo.saveAll(user);
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	
	}
	
	
	public List<User> getAllUser()
	{
		return this.userRepo.findAll();
	}
	
}
