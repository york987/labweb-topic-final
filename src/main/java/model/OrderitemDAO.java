package model;

import java.util.List;

public interface OrderitemDAO {

	public abstract OrderitemBean select(Integer id);

	public abstract List<OrderitemBean> select();

	public abstract OrderitemBean insert(OrderitemBean bean);

	public abstract OrderitemBean update(Integer id, Integer orderid,
			Integer pid,String picmain, String productname, Integer price,
			Integer qty, Double discount);

	public abstract boolean delete(Integer id);
	
	public abstract OrderitemBean show(Integer id);
	
	public abstract List<OrderitemBean> show();
}