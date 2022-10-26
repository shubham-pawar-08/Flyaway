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
import com.flyaway.Dao.FlightsdaoImpl;
import com.flyaway.entities.Airlines;
import com.flyaway.entities.Flights;

/**
 * Servlet implementation class ShowFlights
 */
@WebServlet("/ShowFlights")
public class ShowFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFlights() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw =response.getWriter();
		List<Flights> flights=null;
		FlightsdaoImpl flightDao=new FlightsdaoImpl();
		flights=flightDao.getAll();
		
		pw.println("<html><body>");
		pw.println("<table border=\"1\"><tr><th>FLIGHT ID</th><th>AIRLINE</th><th>ROUTE</th><th>PRICE</th><th>SOURCE</th><th>DESTINATION</th></tr>");
		
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
		pw.println("<br><a href=\"AddFlights\"> Click here to add Flights</a>");
		
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
