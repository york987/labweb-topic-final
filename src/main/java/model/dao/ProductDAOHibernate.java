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

import model.ProductBean;
import model.ProductDAO;

@Repository
public class ProductDAOHibernate implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public ProductBean select(Integer pid) {
		if(pid!=null) {
			return this.getSession().get(ProductBean.class, pid);
		}
		return null;
	}
	
	@Override
	public List<ProductBean> select() {

		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<ProductBean> criteriaQuery = criteriaBuilder.createQuery(ProductBean.class);
		
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		
		TypedQuery<ProductBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<ProductBean> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			return result;
		}
		return null;
	}
	
	@Override
	public ProductBean insert(ProductBean bean) {
		if(bean!=null) {
			ProductBean temp = this.getSession().get(ProductBean.class, bean.getPid());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	
	public ProductBean update(ProductBean bean) {
		if(bean!=null && bean.getPid()!=null) {
			ProductBean temp = this.getSession().get(ProductBean.class, bean.getPid());
			if(temp!=null) {
				return (ProductBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	
	@Override
	public ProductBean update(Integer pid, String picmain, String picfirst, String picsecond,
			String picthird, String picfourth,String productname, String productdesc, Integer cateid,
			String spec, String material, Integer price, String size, String weight) {
		if(pid!=null) {
			ProductBean temp = this.getSession().get(ProductBean.class, pid);
			if(temp!=null) {
				temp.setPid(pid);
				temp.setPicmain(picmain);
				temp.setPicfirst(picfirst);
				temp.setPicsecond(picsecond);
				temp.setPicthird(picthird);
				temp.setPicfourth(picfourth);
				temp.setProductname(productname);
				temp.setProductdesc(productdesc);
				temp.setCateid(cateid);
				temp.setSpec(spec);
				temp.setMaterial(material);
				temp.setPrice(price);
				temp.setSize(size);
				temp.setWeight(weight);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer pid) {
		if(pid!=null) {
			ProductBean temp = this.getSession().get(ProductBean.class, pid);
			if(temp!=null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}
}
