package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.Dao.UsersDaoImpl;
import com.flyaway.entities.Users;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String oldpassword = request.getParameter("oldpass");
		String newPassword = request.getParameter("newpass");
		String newPassword1 = request.getParameter("newpass1");

		PrintWriter pw = response.getWriter();

		UsersDaoImpl userDao = new UsersDaoImpl();
		List<Users> usrs = userDao.getUser(username);
		if (usrs != null) {
			for (Users u : usrs) {
				String pass = u.getPassword();
				if (pass.equals(oldpassword)) {
					if (newPassword.equals(newPassword1)) {
						userDao.changePassword(username, newPassword1);
						pw.println("<html><body>");
						pw.println("Password successfully changed!!");
						pw.println("<br>");
						pw.println("<a href=\"Welcome.jsp\">Go to home</a>");
						pw.println("</html></body>");
						break;

					} else {
						pw.println("<html><body>");
						pw.println("Passwords doesn't match!!");
						pw.println("<br>");
						pw.println("<a href=\"ChangePassword.html\">Go back</a>");
						pw.println("</html></body>");
					}
				} else {
					pw.println("<html><body>");
					pw.println("Incorrect old password !!");
					pw.println("<br>");
					pw.println("<a href=\"ChangePassword.html\">Go back</a>");
					pw.println("</html></body>");
				}
			}
		} else {
			pw.println("<html><body>");
			pw.println("User not found exception!!");
			pw.println("<br>");
			pw.println("<a href=\"ChangePassword.html\">Go back</a>");
			pw.println("</html></body>");
		}
	}

}
