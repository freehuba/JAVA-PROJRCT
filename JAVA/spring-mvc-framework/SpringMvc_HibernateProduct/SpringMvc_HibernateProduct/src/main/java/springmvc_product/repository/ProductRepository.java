package springmvc_product.repository;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import springmvc_product.model.Product;

@Repository
public class ProductRepository {

	public static Session getSession()
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();	
		return session;
		
	}

	//save
	public void saveProduct(Product pro1)
	{
		 Session ss=ProductRepository.getSession();
		 Transaction tx=ss.beginTransaction();
		 
		 ss.save(pro1);
		 
		 tx.commit();
		 ss.close();
		 
	}
	
	//display
	public List<Product> displayAll()
	{
		Session ss = ProductRepository.getSession();
		Transaction tx = ss.beginTransaction();
		
		Query<Product> query = ss.createQuery("from Product p");
		List<Product> list = query.list();
		return list;
	}
	
	//update
	public void updateProductById(int pId,String pName, int pPrice)
	{
		Session ss = ProductRepository.getSession();
		Transaction tx = ss.beginTransaction();
		
		Product product = ss.get(Product.class, pId);
		product.setProductId(pId);
		product.setProductName(pName);
		product.setProductPrice(pPrice);
		
		tx.commit();
	}
	
	//update
		public void deleteProductById(int pId)
		{
			Session ss = ProductRepository.getSession();
			Transaction tx = ss.beginTransaction();
			
			Product product = ss.get(Product.class, pId);
			ss.delete(product);
			tx.commit();
		}
	
}
