package com.hibernate.HQL.Hibernate_HQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		//HQL:Hibernate Query Language
		
		//1.Select all products details
		Query<Product> query = session.createQuery("SELECT p from Product p");
		List<Product> products = query.list();
		for(Product product: products) {
			System.out.println(product);
		}
		
		//2. Select product name(Fetching Operatin)
		Query<String> query1 = session.createQuery("SELECT p.productName from Product p");
		List<String> products1 = query1.list();
		for(String product: products1) {
			System.out.println(product);
		}		
		
		//3. Update operation
		Query<String> query3 = session.createQuery("UPDATE Product p SET p.productPrice=9999 WHERE p.productId=1");
		int rowUpdated = query3.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println(rowUpdated + "data updated!!");
		}else {
			System.out.println("data not updated!!");
		}
		
		//4. Delete operation
		Query<String> query4 = session.createQuery("DELETE Product p  WHERE p.productId=4");
		int rowDeleted = query4.executeUpdate();
		if(rowDeleted > 0) {
			System.out.println(rowDeleted + " data deletd!!");
		}else {
			System.out.println("data not deleted!!");
		}
		
		tran.commit();
		session.close();
		sf.close();


    }
}
