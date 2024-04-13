package springmvc_hibernate.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import springmvc_hibernate.model.User;

@Repository
public class UserRepo {
	// sava data
	public void save(User user) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();

		ss.save(user);
		tx.commit();

		ss.close();
		sf.close();
		System.out.println("Thanks you==========================================");
	}

	// list of users
	public List<User> findAll() {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();

		@SuppressWarnings("unchecked")
		Query<User> query = ss.createQuery("FROM User u");
		List<User> list = query.list();
		tx.commit();

		ss.close();
		sf.close();
		return list;

	}
}
