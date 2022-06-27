package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductBean {
	@Id
	@Column(name = "pid")
	private Integer pid;
	
	@Column(name = "picmain")
	private String picmain;
	
	@Column(name = "picfirst")
	private String picfirst;
	
	@Column(name = "picsecond")
	private String picsecond;
	
	@Column(name = "picthird")
	private String picthird;
	
	@Column(name = "picfourth")
	private String picfourth;
	
	@Column(name = "productname")
	private String productname;
	
	@Column(name = "productdesc")
	private String productdesc;
	
	@Column(name = "cateid")
	private Integer cateid;
	
	@Column(name = "spec")
	private String spec;
	
	@Column(name = "material")
	private String material;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "weight")
	private String weight;
	
	@Override
	public String toString() {
		return "model.ProductBean ["+ pid+ ","+ picmain+ ","+ price+ ","+ productname+ ","+ cateid+ "]";
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
	public String getPicfirst() {
		return picfirst;
	}
	public void setPicfirst(String picfirst) {
		this.picfirst = picfirst;
	}
	public String getPicsecond() {
		return picsecond;
	}
	public void setPicsecond(String picsecond) {
		this.picsecond = picsecond;
	}
	public String getPicthird() {
		return picthird;
	}
	public void setPicthird(String picthird) {
		this.picthird = picthird;
	}
	public String getPicfourth() {
		return picfourth;
	}
	public void setPicfourth(String picfourth) {
		this.picfourth = picfourth;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public Integer getCateid() {
		return cateid;
	}
	public void setCateid(Integer cateid) {
		this.cateid = cateid;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
}
