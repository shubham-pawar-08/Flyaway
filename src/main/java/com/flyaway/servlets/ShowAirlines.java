package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.Dao.AirlinesDaoImpl;
import com.flyaway.entities.Airlines;

/**
 * Servlet implementation class ShowAirlines
 */
@WebServlet("/ShowAirlines")
public class ShowAirlines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAirlines() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw =response.getWriter();
		List<Airlines> airlines=null;
		AirlinesDaoImpl airlineDao=new AirlinesDaoImpl();
		airlines=airlineDao.getAll();
		
		pw.println("<html><body>");
		pw.println("<table border=\"1\"><tr><th>Airline ID</th><th>Airline Code</th><th>Airline Name</th></tr>");
		
		for(Airlines a:airlines) {
			pw.println("<tr>");
			pw.println("<td>"+a.getAirlineId()+"</td>");
			pw.println("<td>"+a.getAirLineCode()+"</td>");
			pw.println("<td>"+a.getAirLineName()+"</td>");			
			pw.println("</tr>");
									
		}
		pw.println("<br><a href=\"AddAirlines.html\"> Click here to add airlines</a>");
		
		pw.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
