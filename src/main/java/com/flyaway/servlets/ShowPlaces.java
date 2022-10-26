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
 * Servlet implementation class ShowPlaces
 */
@WebServlet("/ShowPlaces")
public class ShowPlaces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPlaces() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =response.getWriter();
		List<Places> places=null;
		PlacesDaoImpl placeDao=new PlacesDaoImpl();
		places=placeDao.getAll();
		
		pw.println("<html><body>");
		pw.println("<table border=\"1\"><tr><th>Place ID</th><th>Place Code</th><th>Place Name</th></tr>");
		
		for(Places a:places) {
			pw.println("<tr>");
			pw.println("<td>"+a.getPlaceId()+"</td>");
			pw.println("<td>"+a.getPlaceCode()+"</td>");
			pw.println("<td>"+a.getPlaceName()+"</td>");			
			pw.println("</tr>");
									
		}
		pw.println("<br><a href=\"AddPlace.html\"> Click here to add places</a>");
		
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
