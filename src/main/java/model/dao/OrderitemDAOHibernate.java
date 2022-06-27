package model.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.OrderitemBean;
import model.OrderitemDAO;


@Repository
public class OrderitemDAOHibernate implements OrderitemDAO {
	@Autowired
	private SessionFactory sessionFactory = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public OrderitemBean select(Integer id) {
		if(id!=null) {
			return this.getSession().get(OrderitemBean.class, id);
		}
		return null;
	}
	
	@Override
	public List<OrderitemBean> select() {

		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<OrderitemBean> criteriaQuery = criteriaBuilder.createQuery(OrderitemBean.class);
		
		Root<OrderitemBean> root = criteriaQuery.from(OrderitemBean.class);
		
		TypedQuery<OrderitemBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<OrderitemBean> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			return result;
		}
		return null;
	}
	
	@Override
	public OrderitemBean insert(OrderitemBean bean) {
		if(bean!=null && bean.getId()!=null) {
			OrderitemBean temp = this.getSession().get(OrderitemBean.class, bean.getId());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	
	public OrderitemBean update(OrderitemBean bean) {
		if(bean!=null && bean.getId()!=null) {
			OrderitemBean temp = this.getSession().get(OrderitemBean.class, bean.getId());
			if(temp!=null) {
				return (OrderitemBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	
	@Override
	public OrderitemBean update(Integer id, Integer orderid,
			Integer pid, String picmain, String productname, 
			Integer price, Integer qty, Double discount) {
		if(id!=null) {
			OrderitemBean temp = this.getSession().get(OrderitemBean.class, id);
			if(temp!=null) {
				temp.setId(id);
				temp.setOrderid(orderid);
				temp.setPid(pid);
				temp.setPicmain(picmain);
				temp.setProductname(productname);
				temp.setPrice(price);
				temp.setQty(qty);
				temp.setDiscount(discount);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			OrderitemBean temp = this.getSession().get(OrderitemBean.class, id);
			if(temp!=null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public OrderitemBean show(Integer id) {
		if(id!=null) {
			return this.getSession().get(OrderitemBean.class, id);
		}
		return null;
	}
	
	@Override
	public List<OrderitemBean> show() {

		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<OrderitemBean> criteriaQuery = criteriaBuilder.createQuery(OrderitemBean.class);
		
		Root<OrderitemBean> root = criteriaQuery.from(OrderitemBean.class);
		
		TypedQuery<OrderitemBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<OrderitemBean> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			return result;
		}
		return null;
	}
}
