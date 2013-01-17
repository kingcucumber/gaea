package com.gaea.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gaea.business.Teacher_Manager;

public class EditTeacherServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = req.getSession();
		String id = req.getParameter("id");
		int ID = Integer.parseInt(id);
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String zhicheng = req.getParameter("zhicheng");
		String image = req.getParameter("image");
		String info = req.getParameter("info");
		Teacher_Manager.Edit_Teacher(name, sex, zhicheng, image, info, ID);
		RequestDispatcher rd = req.getRequestDispatcher("guanli/teacher/edit_success1.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
}
