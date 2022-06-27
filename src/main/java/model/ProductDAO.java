package model;

import java.util.List;

public interface ProductDAO {

	public abstract ProductBean select(Integer pid);

	public abstract List<ProductBean> select();

	public abstract ProductBean insert(ProductBean bean);

	public abstract ProductBean update(Integer pid, String picmain, String picfirst, String picsecond,
			String picthird, String picfourth,String productname, String productdesc, Integer cateid,
			String spec, String material, Integer price, String size, String weight);

	public abstract boolean delete(Integer pid);

}