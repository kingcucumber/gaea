package com.gaea.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gaea.business.Admin_Manager;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset =gb2312");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>非法</title></head>");
		out.println("<body bgcolor=\"#ffffff\">");
		out.println("<p>服务器忙，请稍后再来!<p>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean tag = Admin_Manager.CheckAdmin(username, password);

		if (tag) {
			ses.setAttribute("username", username);
			RequestDispatcher requestDispatcher = req
					.getRequestDispatcher("guanli/login/success.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			ses.setAttribute("error", "error");
			RequestDispatcher requestDispatcher = req
					.getRequestDispatcher("guanli/login/failure.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
