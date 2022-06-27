package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeinsertBean {
//	@Id
//	@Column(name = "empid")
//	private Integer id;
	@Id
	@Column(name = "engname")
	private String engname;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "position")
	private String position;
	
//	@Column(name = "password")
//	private String password;
	
	@Override
	public String toString() {
		return "model.StaffBean [ "+ name+ ","+ engname+ ","+ sex+ ","+ position+ "]";
	}
//	public Integer getid() {
//		return id;
//	}
//	public void setid(Integer id) {
//		this.id = id;
//	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getengname() {
		return engname;
	}
	public void setengname(String engname) {
		this.engname = engname;
	}
	public String getsex() {
		return sex;
	}
	public void setsex(String sex) {
		this.sex = sex;
	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public Integer getage() {
		return age;
	}
	public void setage(Integer age) {
		this.age = age;
	}
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	
	public String getposition() {
		return position;
	}
	public void setposition(String position) {
		this.position = position;
	}
}
