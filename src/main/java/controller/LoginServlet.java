package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.AppConfigurationEntry;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import model.CustomerBean;
import model.CustomerService;
@WebServlet(
		urlPatterns={"/secure/login.controller"}		
)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService customerService;
	@Override
	public void init() throws ServletException {
//		customerService = new CustomerService();
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application.getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		customerService = context.getBean("customerService", CustomerService.class);
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//接收資料
		String log = request.getParameter("log");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//呼叫model
		CustomerBean bean = customerService.login(username, password);
//驗證資料
		if(log.equals("Login")) {
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("errors", errors);
			if(username==null || username.length()==0) {
				errors.put("username", "Please enter ID for login");
			}
			if(password==null || password.length()==0) {
				errors.put("password", "Please enter PWD for login");
			}
			
			if(errors!=null && !errors.isEmpty()) {
				request.getRequestDispatcher(
						"/secure/login.view").forward(request, response);
				return;
			}
			

			
	//根據model執行結果，導向view
			if(bean==null) {
				errors.put("password", "Login failed, please try again.");
				request.getRequestDispatcher(
						"/secure/login.view").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", bean);
				String path = request.getContextPath();
				response.sendRedirect(path+"/backgroundsystem.view");
			}
		}else {
			HttpSession session = request.getSession();
			
			if(session.getAttribute("user")!=null){
			  	session.removeAttribute("user");
			}
			
//			Cookie[] cookies = request.getCookies();
//		    if (cookies != null) {
//		        for (Cookie cookie : cookies) {
//		            cookie.setValue("");
//		            cookie.setPath("/");
//		            cookie.setMaxAge(0);
//		            response.addCookie(cookie);
//		        }
//		    }
			request.getRequestDispatcher(
					"/secure/login.view").forward(request, response);
//		    response.sendRedirect("/secure/login.view");
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
