package manager;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bean.Customer;

public class App {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		ApplicationContext ac=new FileSystemXmlApplicationContext("ApplicationContext.xml");  
        CustomerDao CD=ac.getBean("CDImpl",CustomerDao.class);
        Integer customer_id=1111;
        Integer store_id=1;
    	String first_name="f";
    	String last_name="l";
    	String email="e";
    	Integer address_id=22;
    	Date create_date=new Date();
        CD.saveCustomer(new Customer(customer_id, store_id, first_name, last_name, email, address_id, create_date));  
            

	}

}
