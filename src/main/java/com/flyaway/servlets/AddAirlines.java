package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.Dao.AirlinesDaoImpl;
import com.flyaway.entities.Airlines;

/**
 * Servlet implementation class AddAirlines
 */
@WebServlet("/AddAirlines")
public class AddAirlines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAirlines() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String airlineCode=request.getParameter("code");
		String airlineName=request.getParameter("name");
		AirlinesDaoImpl AirlinesDao = new AirlinesDaoImpl();
		Airlines airlines = new Airlines();
		airlines.setAirLineCode(airlineCode);
		airlines.setAirLineName(airlineName);
		
		AirlinesDao.insert(airlines);
		RequestDispatcher rd = request.getRequestDispatcher("AddAirlines.html");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Airline added successfully!!</h1>");
		
		rd.include(request, response);
	}

}
