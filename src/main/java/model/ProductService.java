package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductDAO productDao;

	public List<ProductBean> select(ProductBean bean) {
		List<ProductBean> result = null;
		if(bean!=null && bean.getPid()!=null && !bean.getPid().equals(0)) {
			ProductBean temp = productDao.select(bean.getPid());
			if(temp!=null) {
				result = new ArrayList<ProductBean>();
				result.add(temp);
			}
		} else {
			result = productDao.select(); 
		}
		return result;
	}
	public ProductBean insert(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null) {
			result = productDao.insert(bean);
		}
		return result;
	}
	public ProductBean update(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null && bean.getPid()!=null) {
			result = productDao.update(bean.getPid(), bean.getPicmain(), bean.getPicfirst(), bean.getPicsecond(),
					bean.getPicthird(), bean.getPicfourth(),bean.getProductname(), bean.getProductdesc(), 
					bean.getCateid(), bean.getSpec(), bean.getMaterial(), bean.getPrice(), bean.getSize()
					,bean.getWeight());
		}
		return result;
	}
	public boolean delete(ProductBean bean) {
		boolean result = false;
		if(bean!=null && bean.getPid()!=null) {
			result = productDao.delete(bean.getPid());
		}
		return result;
	}
}
