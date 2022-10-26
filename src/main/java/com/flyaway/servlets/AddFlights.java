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
import com.flyaway.Dao.PlacesDaoImpl;
import com.flyaway.entities.Airlines;
import com.flyaway.entities.Places;

/**
 * Servlet implementation class AddFlights
 */
@WebServlet("/AddFlights")
public class AddFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFlights() {
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
		PrintWriter pw = response.getWriter();
		List<Airlines> airlines = null;
		AirlinesDaoImpl airlineDao = new AirlinesDaoImpl();
		airlines = airlineDao.getAll();
		List<Places> places = null;
		PlacesDaoImpl placesDao = new PlacesDaoImpl();
		places = placesDao.getAll();
		pw.println("<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n" + "<title>Add Flights</title>\r\n"
				+ "</head>\r\n" + "<body>\r\n" + "<form action=\"AddFlightsAction\" method=\"post\">\r\n"
				+ "  <label for=\"airline\">Select Airline</label><br>\r\n");

		pw.println("<select id=\"airline\" name=\"airline\" ><br>\r\n" + "<option value=\"\">Select</option>");
		for (Airlines a : airlines) {
			
			pw.println("<option value=\"" + a.getAirLineName() + "\">" + a.getAirLineName() + "</option>");
			
		}
		pw.println("  </select><br>" 
				+ "	 <label for=\"price\">Enter Price:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"price\" name=\"price\"><br>\r\n"
				+ "  <label for=\"source\">Select Source</label><br>\r\n");
		pw.println("<select id=\"source\" name=\"source\" ><br>\r\n" 
					+ "<option value=\"\">Select</option>");
		for (Places p : places) {
			
			pw.println("<option value=\"" + p.getPlaceName() + "\">" + p.getPlaceName() + "</option>");
			
		}
		pw.println("  </select><br>" 
				+ "<label for=\"destination\">Select Destination</label><br>\r\n");
				pw.println("<select id=\"destination\" name=\"destination\" ><br>\r\n" 
						+ "<option value=\"\">Select</option>");
				for (Places p : places) {
					
					pw.println("<option value=\"" + p.getPlaceName() + "\">" + p.getPlaceName() + "</option>");
					
				}
		pw.println(" </select><br>" 
					+ "  <input type=\"submit\" value=\"Add Flight\">\r\n" 
					+"<br><a href=\"ShowFlights\">Show Flights</a>"
					+"<br><a href=\"Welcome.jsp\">Go Home</a>"
					+ "</body>\r\n" + "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
