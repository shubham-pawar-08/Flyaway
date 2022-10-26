package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.Dao.UsersDaoImpl;
import com.flyaway.entities.Users;

/**
 * Servlet implementation class AdminValidation
 */
@WebServlet("/AdminValidation")
public class AdminValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("AdminLogin.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		String msg="";
		UsersDaoImpl user = new UsersDaoImpl();
		PrintWriter pw = response.getWriter();
		List<Users> usr = user.getUser(username);
		for(Users u:usr) {
			if(username.equals(u.getUserName())){
				if(password.equals(u.getPassword())) {
					RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.html");
					msg = "Login successfull!!";
					pw.println(msg);
					rd.forward(request, response);
					break;
				}else {
					msg = msg +"\nIncorrect password!!";
				}
				
			}else {
				msg = msg+"\n Username not valid!";
			}
		}
		
		pw.println(msg);
	}

}
