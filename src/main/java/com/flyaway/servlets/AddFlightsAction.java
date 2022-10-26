package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.Dao.FlightsdaoImpl;
import com.flyaway.Dao.PlacesDaoImpl;
import com.flyaway.entities.Flights;
import com.flyaway.entities.Places;

/**
 * Servlet implementation class AddFlightsAction
 */
@WebServlet("/AddFlightsAction")
public class AddFlightsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlightsAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String airline=request.getParameter("airline");
		String route=null;
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		int price=Integer.parseInt(request.getParameter("price"));
		
		System.out.println(airline+route+source+destination+price);
		
		PlacesDaoImpl placesdao=new PlacesDaoImpl();
		Places sourceObj = placesdao.get(source);
		Places destObj = placesdao.get(destination);
		route = sourceObj.getPlaceCode()+"-"+destObj.getPlaceCode();
		
		Flights flight = new Flights();
		flight.setAirline(airline);
		flight.setRoute(route);
		flight.setPrice(price);
		flight.setSource(source);
		flight.setDestination(destination);
		FlightsdaoImpl flightsDao = new FlightsdaoImpl();
		flightsDao.insert(flight);
		
		RequestDispatcher rd = request.getRequestDispatcher("AddFlights");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Flight inserted successfully</h1>");
		rd.include(request, response);
		
	}

}
