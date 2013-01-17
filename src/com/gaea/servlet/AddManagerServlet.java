package com.gaea.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gaea.business.Admin_Manager;

public class AddManagerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession  ses =req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		boolean tag = Admin_Manager.HasAdmin(username);
		if(tag){
			RequestDispatcher rd = req.getRequestDispatcher("guanli/manage/add_error.jsp");
			rd.forward(req, resp);
		}else{
			Admin_Manager.add_Admin(username, password);
			RequestDispatcher rd = req.getRequestDispatcher("guanli/manage/add_success.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
}
