package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orderitem")
public class OrderitemBean {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "orderid")
	private Integer orderid;
	
	@Column(name = "pid")
	private Integer pid;
	
	@Column(name = "picmain")
	private String picmain;
	
	@Column(name = "productname")
	private String productname;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "qty")
	private Integer qty;
	
	@Column(name = "discount")
	private Double discount;
	@Override
	public String toString() {
		return "model.OrderitemBean ["+ id+ ","+ orderid+ ","+ picmain+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPicmain() {
		return picmain;
	}
	public void setPicmain(String picmain) {
		this.picmain = picmain;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
}
