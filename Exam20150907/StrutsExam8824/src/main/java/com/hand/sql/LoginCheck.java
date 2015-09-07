package com.hand.sql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LoginCheck extends HibernateDaoSupport {
	
	
	public boolean Check(String username,String password){
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM Customer WHERE first_name = :username AND last_name = :password";
	    Query query = session.createQuery(hql);
	    query.setParameter("username",username);
	    query.setParameter("password",password);
	    System.out.println(query.list().size());
	    List results = query.list();
		tx.commit(); 
		session.close();  
		getSessionFactory().close();
		if(results.size()>0){
			return true;
		}
		else{
			return false;
		}
	}

}
