package com.hand.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.pojo.Customer;
import com.hand.sql.CustomerManager;
import com.hand.sql.LoginCheck;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	private Customer customer;

	public String insert(Customer customer){
		ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerManager cm=ac.getBean("loginCheck",CustomerManager.class);
		cm.Insert(customer);
		return null;
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
