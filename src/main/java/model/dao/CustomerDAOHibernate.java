package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CustomerBean;
import model.CustomerDAO;

@Repository
public class CustomerDAOHibernate implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public CustomerBean select(String custid) {
		if(custid!=null) {
			return this.getSession().get(CustomerBean.class, custid);
		}
		return null;
	}
	@Override
	public boolean update(String password, String email, java.util.Date birth, String custid) {
		if(custid!=null) {
			CustomerBean temp = this.getSession().get(CustomerBean.class, custid);
			if(temp!=null) {
				temp.setPassword(password);
				temp.setEmail(email);
				temp.setBirth(birth);
				return true;
			}
		}
		return false;
	}
}
