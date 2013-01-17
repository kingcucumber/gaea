package com.gaea.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gaea.business.Student_Manager;

public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = req.getSession();
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String image = req.getParameter("image");
		String grade = req.getParameter("grade");
		int grade_id = Integer.parseInt(grade);
		Student_Manager.Add_Student(name, grade_id, image, sex);
		RequestDispatcher rd = req.getRequestDispatcher("guanli/student/add_success1.jsp");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
}
