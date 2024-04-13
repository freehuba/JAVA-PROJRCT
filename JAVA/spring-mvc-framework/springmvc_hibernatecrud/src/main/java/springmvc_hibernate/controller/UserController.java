package springmvc_hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc_hibernate.model.User;
import springmvc_hibernate.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public void save(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String userName = req.getParameter("userName");
		String userPassword = req.getParameter("userPassword");

		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPassword(userPassword);

		userService.saveUser(user);

	}
	
	@RequestMapping("/displayAllUser")
	public void displayAllUsers(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		List<User> list = userService.userList();		
		req.setAttribute("user", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/display.jsp");
		requestDispatcher.forward(req, res);
		
	}
	
	
}
