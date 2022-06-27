package model;

import java.math.BigInteger;
import java.util.List;

public interface OrdersDAO {

	public abstract OrdersBean select(Integer ordersid);

	public abstract List<OrdersBean> select();

	public abstract OrdersBean insert(OrdersBean bean);

	public abstract OrdersBean update(Integer orderid, String uid,
			String ordername, String phone, java.util.Date orderdate,
			String code, String city, String address, Integer totalamount,
			Integer orderstatus);

	public abstract boolean delete(Integer id);

//	public abstract OrderitemBean selectitem(Integer ordersid);
//	
//	public abstract List<OrderitemBean> selectitem();
//	
//	public abstract OrderitemBean update(Integer id, Integer orderid,
//			String picmain, String productname, Integer price,
//			Integer qty, Double discount);
}