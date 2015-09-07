package com.hand.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.sql.LoginCheck;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	String username;
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public void validate()
	   {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
	      if (username == null || username.trim().equals(""))
	      {
	                    //为指定的控件添加验证失败提示
			request.getSession().setAttribute("errorMessage", "用户名不能为空");
			addFieldError(username, "用户名不能为空");
	         
	      }
	      if (password == null || password.trim().equals(""))
	      {
	    	  request.getSession().setAttribute("errorMessage", "密码不能为空");
	    	  addFieldError(username, "密码不能为空");
	      }
	   }
	
	public String login(){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		LoginCheck login=ac.getBean("loginCheck",LoginCheck.class);
		if(login.Check(username, password)){
			return "login_success";
		}
		
		else{
			return "login_fail";
		}
	}

}
