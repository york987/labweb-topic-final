package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersService {
	@Autowired
	private OrdersDAO ordersDAO;
	private OrderitemDAO orderitemDAO;

	public List<OrdersBean> select(OrdersBean bean) {
		List<OrdersBean> result = null;
		if(bean!=null && bean.getOrderid()!=null && !bean.getOrderid().equals(0)) {
			OrdersBean temp = ordersDAO.select(bean.getOrderid());
			if(temp!=null) {
				result = new ArrayList<OrdersBean>();
				result.add(temp);
			}
		} else {
			result = ordersDAO.select(); 
		}
		return result;
	}
	public OrdersBean insert(OrdersBean bean) {
		OrdersBean result = null;
		if(bean!=null && bean.getOrderid()!=null) {
			result = ordersDAO.insert(bean);
		}
		return result;
	}
	public OrdersBean update(OrdersBean bean) {
		OrdersBean result = null;
		if(bean!=null && bean.getOrderid()!=null) {
			result = ordersDAO.update(bean.getOrderid(), bean.getUid(),
					bean.getOrdername(), bean.getPhone(), bean.getOrderdate(), bean.getCode()
					,bean.getCity(), bean.getAddress(), bean.getTotalamount()
					,bean.getOrderstatus());
		}
		return result;
	}
	public boolean delete(OrdersBean bean) {
		boolean result = false;
		if(bean!=null && bean.getOrderid()!=null) {
			result = ordersDAO.delete(bean.getOrderid());
		}
		return result;
	}
	
//	public OrderitemBean update(OrderitemBean bean) {
//		OrderitemBean result = null;
//		if(bean!=null && bean.getId()!=null) {
//			result = ordersDAO.update(bean.getId(), bean.getOrderid(),
//					bean.getPicmain(), bean.getProductname(), bean.getPrice(), bean.getQty()
//					,bean.getDiscount());
//		}
//		return result;
//	}
//	public List<OrderitemBean> selectitem(OrderitemBean bean) {
//		List<OrderitemBean> result = null;
//		if(bean!=null && bean.getOrderid()!=null && !bean.getOrderid().equals(0)) {
//			OrderitemBean temp = ordersDAO.selectitem(bean.getOrderid());
//			if(temp!=null) {
//				result = new ArrayList<OrderitemBean>();
//				result.add(temp);
//			}
//		}
//		return result;
//	}
}
