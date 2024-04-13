package springmvc_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import springmvc_hibernate.model.Player;

@Repository
public class PlayerRepo {
	
	// sava data
	public void save(Player player) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		
		etx.begin();
		em.persist(player);
		
		etx.commit();
		em.close();
		emf.close();
	}

}
