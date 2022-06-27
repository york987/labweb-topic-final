package model;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Entity
@Table(name = "orders")
public class OrdersBean {
	@Id
	@Column(name = "orderid")
	private Integer orderid;
	
	@Column(name = "uid")
	private String uid;
	
	@Column(name = "ordername")
	private String ordername;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "orderdate")
	private java.util.Date orderdate;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "totalamount")
	private Integer totalamount;
	
	@Column(name = "orderstatus")
	private Integer orderstatus;
	
	@Override
	public String toString() {
		return "model.OrdersBean ["+ orderid+ ","+ uid+ ","+ ordername+ ","+ ordername+ "]";
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public java.util.Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(java.util.Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(Integer totalamount) {
		this.totalamount = totalamount;
	}
	public Integer getOrderstatus() {
		return orderid;
	}
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
}
