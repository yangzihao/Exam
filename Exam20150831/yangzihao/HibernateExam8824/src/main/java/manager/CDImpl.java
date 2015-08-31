package manager;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bean.Customer;

public class CDImpl extends HibernateDaoSupport implements CustomerDao  {
	private HibernateTemplate hibernateTemplate;  
	

	@Override
	public void saveCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(customer);
		
	}


}
