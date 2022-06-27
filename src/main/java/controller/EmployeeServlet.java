package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import model.EmployeeBean;
import model.EmployeeService;
import model.EmployeeinsertBean;

@WebServlet(
		urlPatterns={"/pages/staff.controller"}		
)
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	private EmployeeService employeeService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application.getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		employeeService = context.getBean("employeeService", EmployeeService.class);
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//接收資料
		String temp1 = request.getParameter("id");
		String temp2 = request.getParameter("engname");
		String name = request.getParameter("name");
		String temp3 = request.getParameter("sex");
		String temp4 = request.getParameter("age");
		String temp6 = request.getParameter("phone");
		String temp5 = request.getParameter("position");
		String staffction = request.getParameter("staffction");

		System.out.println(staffction);
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		
		if(staffction!=null) {
			if(staffction.equals("Update") || staffction.equals("Delete")) {
				if(temp1==null || temp1.length()==0) {
					errors.put("id", "Please enter Id for "+staffction);
				}
			}
		}
//轉換資料
		int id = 0;
		if(staffction.equals("Update") || staffction.equals("Delete")) {
			if(temp1!=null && temp1.length()!=0) {
				try {
					id = Integer.parseInt(temp1);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("id", "請輸入id");
				}
			}
		}
		String engname = "";
		if(temp2!=null && temp2.length()!=0) {
			try {
				engname = temp2;
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("engname", "請輸入英文姓名");
			}
		}
		String rname = "";
		if(name!=null && name.length()!=0) {
			try {
				rname = name;
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("name", "請輸入英文姓名");
			}
		}
		String sex = "";
		if(temp3!=null && temp3.length()!=0) {
			try {
				sex = temp3;
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("gender", "請輸入性別");
			}
		}
		int age = 0;
			if(temp4!=null && temp4.length()!=0) {
				try {
					age = Integer.parseInt(temp4);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("age", "請輸入id");
				}
			}
		String phone = "";
		if(temp6!=null && temp6.length()!=0) {
			try {
				phone = temp6;
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("phone", "請輸入英文姓名");
			}
		}
		String position = "";
		if(temp5!=null && temp5.length()!=0) {
			try {
				position = temp5;
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("position", "請輸入職位");
			}
		}
		
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/pages/staff.view").forward(request, response);
			return;
		}
		
		
//呼叫Model
		EmployeeBean bean = new EmployeeBean();
		EmployeeinsertBean bean2 = new EmployeeinsertBean();
		EmployeeBean bean3 = new EmployeeBean();
		if(staffction.equals("Insert")) {
			System.out.println("in");
			bean2.setname(rname);
			bean2.setengname(engname);
			bean2.setsex(sex);
			bean2.setage(age);
			bean2.setphone(phone);
			bean2.setposition(position);
		}else {
			bean.setid(id);
			bean.setname(rname);
			bean.setengname(engname);
			bean.setsex(sex);
			bean.setage(age);
			bean.setphone(phone);
			bean.setposition(position);
		}
		System.out.println("id="+id);
		System.out.println("rname="+rname);
		System.out.println("engname="+engname);
		System.out.println("sex="+sex);
		System.out.println("age="+age);
		System.out.println("phone="+phone);
		System.out.println("position="+position);
//根據Model執行結果導向View
		try {
			if( staffction.equals("Select")) {
				List<EmployeeBean> result = employeeService.select(bean);
				request.setAttribute("select", result);
				request.getRequestDispatcher(
						"/pages/staffdisplay.view").forward(request, response);
			} else if(staffction!=null && staffction.equals("Insert")) {
				EmployeeinsertBean result = employeeService.insert(bean2);
				if(result==null) {
					errors.put("action", "新增失敗");
				} else {
					List<EmployeeBean> result2 = employeeService.select(bean3);
					request.setAttribute("select", result2);
					request.getRequestDispatcher(
							"/pages/staffdisplay.view").forward(request, response);
				}
				request.getRequestDispatcher(
						"/pages/staffinsert.view").forward(request, response);
			} else if(staffction!=null && staffction.equals("Update")) {
				EmployeeBean result = employeeService.update(bean);
				if(result==null) {
					errors.put("action", "更新失敗");
				} else {
					List<EmployeeBean> result2 = employeeService.select(bean3);
					request.setAttribute("select", result2);
					request.getRequestDispatcher(
							"/pages/staffdisplay.view").forward(request, response);
				}
				request.getRequestDispatcher(
						"/pages/staff.view").forward(request, response);
			} else if(staffction!=null && staffction.equals("Delete")) {
				boolean result = employeeService.delete(bean);
				if(!result) {
					request.setAttribute("delete", 0);
				}else {
					List<EmployeeBean> result2 = employeeService.select(bean3);
					request.setAttribute("select", result2);
					request.getRequestDispatcher(
						"/pages/staffdisplay.view").forward(request, response);
					}
				request.getRequestDispatcher(
						"/pages/staff.view").forward(request, response);
			} else  {
				errors.put("action", "Unknown Action:"+staffction);
				List<EmployeeBean> result2 = employeeService.select(bean3);
				request.setAttribute("select", result2);
				request.getRequestDispatcher(
						"/pages/staffdisplay.view").forward(request, response);
			}
		}catch(Exception e) {
			request.getRequestDispatcher(
					"/pages/staffdisplay.view").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

