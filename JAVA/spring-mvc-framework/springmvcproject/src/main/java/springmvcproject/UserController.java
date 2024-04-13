package springmvcproject;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController 
{
	//@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	@PostMapping("/saveUser")
	public void save(HttpServletRequest req, HttpServletResponse res)
	{
		int userId = Integer.parseInt(req.getParameter("userId"));
		String userName = req.getParameter("userName");
		String userPassword = req.getParameter("userPassword");
		
		
		User user= new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();	
		Transaction tx = ss.beginTransaction();	
		
		ss.save(user);
		tx.commit();
		
		ss.close();
		sf.close();
		
		System.out.println(userId+"  "+userName+"  "+userPassword);
		System.out.println("Thanks you==========================================");
		
	}
}
