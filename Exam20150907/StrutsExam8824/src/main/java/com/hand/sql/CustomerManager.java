package com.hand.sql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.Insert;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hand.pojo.Customer;

public class CustomerManager extends HibernateDaoSupport {

	public void Insert(Customer customer){
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit(); 
		session.close();  
		getSessionFactory().close();
	}
}
