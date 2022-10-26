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

import com.flyaway.Dao.FlightsdaoImpl;
import com.flyaway.entities.Flights;

/**
 * Servlet implementation class SearchFlight
 */
@WebServlet("/SearchFlight")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlight() {
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
		
		String traveldate = request.getParameter("traveldate");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String persons = request.getParameter("persons");
		
		List<Flights> flights=null;
		FlightsdaoImpl flightsDao=new FlightsdaoImpl();
		flights = flightsDao.getFlight(source, destination);
		
		PrintWriter pw =response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("BookFlight.jsp");
				
		pw.println("<html><body>");
		pw.println("<br><table border=\"1\"><tr><th>FLIGHT ID</th><th>AIRLINE</th><th>ROUTE</th><th>PRICE</th><th>SOURCE</th><th>DESTINATION</th></tr>");
		
		for(Flights f:flights) {
			pw.println("<tr>");
			pw.println("<td>"+f.getFlightId()+"</td>");
			pw.println("<td>"+f.getAirline()+"</td>");
			pw.println("<td>"+f.getRoute()+"</td>");
			pw.println("<td>"+f.getPrice()+"</td>");
			pw.println("<td>"+f.getSource()+"</td>");
			pw.println("<td>"+f.getDestination()+"</td>");
			pw.println("</tr>");
									
		}
		
		
		pw.println("</body></html>");
		rd.include(request, response);
	}
	
	
	}


