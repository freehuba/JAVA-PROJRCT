package com.components.config;

import org.springframework.batch.item.ItemProcessor;

import com.components.model.User;

public class UserItemProcesser implements ItemProcessor<User, User>{

	@Override
	public User process(User user) throws Exception 
	{
		return user;
	}

}
