package springmvc_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_hibernate.model.User;
import springmvc_hibernate.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public void saveUser(User user) {

		userRepo.save(user);
	}
	
	public List<User> userList() {

		List<User> List = userRepo.findAll();
		return List;
		
	}
}
