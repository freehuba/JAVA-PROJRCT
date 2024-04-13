package com.components.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.components.helper.MyExcelHelper;
import com.components.model.User;
import com.components.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user/upload")
	public ResponseEntity<?> uplode(@RequestParam("file") MultipartFile file)
	{
		if(MyExcelHelper.checkExcelFormat(file))
		{
			this.userService.save(file);
			return ResponseEntity.ok(Map.of("message","File uploded and data is saved successfully on db"));
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please uplode excel file");
	}
	
	@GetMapping("/display")
	public List<User> getAllUser()
	{
		return this.userService.getAllUser();
	}
}
