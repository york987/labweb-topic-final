package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
	@RequestMapping(path = {"/"})
	public String handlerMethod1() {
		
		return "/index";
	}
	@RequestMapping(path = {"/secure/login.view"})
	public String handlerMethod2() {
		return "/secure/login";
	}
	@RequestMapping(path = {"/pages/product.view"})
	public String handlerMethod3() {
		return "/pages/product";
	}
	@RequestMapping(path = {"/pages/display.view"})
	public String handlerMethod4() {
		
		return "/pages/display";
	}
	@RequestMapping(path = {"/pages/staffdisplay.view"})
	public String handlerMethod5() {
		
		return "/pages/staffdisplay";
	}
	@RequestMapping(path = {"/backgroundsystem.view"})
	public String handlerMethod6() {
		
		return "/backgroundsystem";
	}
	@RequestMapping(path = {"/pages/staffinsert.view"})
	public String handlerMethod7() {
		
		return "/pages/staffinsert";
	}
	@RequestMapping(path = {"/pages/staff.view"})
	public String handlerMethod8() {
		
		return "/pages/staff";
	}
	@RequestMapping(path = {"/pages/productinsert.view"})
	public String handlerMethod9() {
		
		return "/pages/productinsert";
	}
	@RequestMapping(path = {"/pages/member.view"})
	public String handlerMethod10() {
		
		return "/pages/member";
	}
	@RequestMapping(path = {"/pages/memberdisplay.view"})
	public String handlerMethod11() {
		
		return "/pages/memberdisplay";
	}
	@RequestMapping(path = {"/pages/memberinsert.view"})
	public String handlerMethod12() {
		
		return "/pages/memberinsert";
	}
	@RequestMapping(path = {"/pages/ordersinsert.view"})
	public String handlerMethod13() {
		
		return "/pages/ordersinsert";
	}
	@RequestMapping(path = {"/pages/orders.view"})
	public String handlerMethod14() {
		
		return "/pages/orders";
	}
	@RequestMapping(path = {"/pages/ordersdisplay.view"})
	public String handlerMethod15() {
		
		return "/pages/ordersdisplay";
	}
	@RequestMapping(path = {"/pages/orderitemdisplay.view"})
	public String handlerMethod16() {
		
		return "/pages/orderitemdisplay";
	}
	@RequestMapping(path = {"/pages/orderitem.view"})
	public String handlerMethod17() {
		
		return "/pages/orderitem";
	}
	@RequestMapping(path = {"/pages/orderiteminsert.view"})
	public String handlerMethod18() {
		
		return "/pages/orderiteminsert";
	}
	@RequestMapping(path = {"/pages/productsnapshotdisplay.view"})
	public String handlerMethod19() {
		
		return "/pages/productsnapshotdisplay";
	}
	@RequestMapping(path = {"/pages/productsnapshotinsert.view"})
	public String handlerMethod20() {
		
		return "/pages/productsnapshotinsert";
	}
	@RequestMapping(path = {"/pages/productsnapshot.view"})
	public String handlerMethod21() {
		
		return "/pages/productsnapshot";
	}
}
