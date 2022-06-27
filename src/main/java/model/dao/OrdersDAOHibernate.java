package model.dao;

import java.math.BigInteger;
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
import model.OrdersBean;
import model.OrdersDAO;



@Repository
public class OrdersDAOHibernate implements OrdersDAO {
	@Autowired
	private SessionFactory sessionFactory = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public OrdersBean select(Integer orderid) {
		if(orderid!=null) {
			return this.getSession().get(OrdersBean.class, orderid);
		}
		return null;
	}
	
	@Override
	public List<OrdersBean> select() {

		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<OrdersBean> criteriaQuery = criteriaBuilder.createQuery(OrdersBean.class);
		
		Root<OrdersBean> root = criteriaQuery.from(OrdersBean.class);
		
		TypedQuery<OrdersBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<OrdersBean> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			return result;
		}
		return null;
	}
	
	@Override
	public OrdersBean insert(OrdersBean bean) {
		if(bean!=null && bean.getOrderid()!=null) {
			OrdersBean temp = this.getSession().get(OrdersBean.class, bean.getOrderid());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	
	public OrdersBean update(OrdersBean bean) {
		if(bean!=null && bean.getOrderid()!=null) {
			OrdersBean temp = this.getSession().get(OrdersBean.class, bean.getOrderid());
			if(temp!=null) {
				return (OrdersBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	
	@Override
	public OrdersBean update(Integer orderid, String uid,
			String ordername, String phone, java.util.Date orderdate,
			String code, String city, String address, Integer totalamount,
			Integer orderstatus) {
		if(orderid!=null) {
			OrdersBean temp = this.getSession().get(OrdersBean.class, orderid);
			if(temp!=null) {
				temp.setOrderid(orderid);
				temp.setUid(uid);
				temp.setOrdername(ordername);
				temp.setPhone(phone);
				temp.setOrderdate(orderdate);
				temp.setCode(code);
				temp.setCity(city);
				temp.setAddress(address);
				temp.setTotalamount(totalamount);
				temp.setOrderstatus(orderstatus);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer orderid) {
		if(orderid!=null) {
			OrdersBean temp = this.getSession().get(OrdersBean.class, orderid);
			if(temp!=null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}
	
////從屬連動更改
//	@Override
//	public OrderitemBean selectitem(Integer orderid) {
//		if(orderid!=null) {
//			return this.getSession().get(OrderitemBean.class, orderid);
//		}
//		return null;
//	}
//	@Override
//	public OrderitemBean update(Integer id, Integer orderid,
//			String picmain, String productname, Integer price,
//			Integer qty, Double discount) {
//		if(id!=null) {
//			OrderitemBean temp = this.getSession().get(OrderitemBean.class, id);
//			if(temp!=null) {
//				temp.setId(id);
//				temp.setOrderid(orderid);
//				temp.setPicmain(picmain);
//				temp.setProductname(productname);
//				temp.setPrice(price);
//				temp.setQty(qty);
//				temp.setDiscount(discount);
//				return temp;
//			}
//		}
//		return null;
//	}
//	@Override
//	public List<OrderitemBean> selectitem() {
//
//		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
//		CriteriaQuery<OrderitemBean> criteriaQuery = criteriaBuilder.createQuery(OrderitemBean.class);
//		
//		Root<OrderitemBean> root = criteriaQuery.from(OrderitemBean.class);
//		
//		TypedQuery<OrderitemBean> typedQuery = this.getSession().createQuery(criteriaQuery);
//		List<OrderitemBean> result = typedQuery.getResultList();
//		if(result!=null && !result.isEmpty()) {
//			return result;
//		}
//		return null;
//	}
}
