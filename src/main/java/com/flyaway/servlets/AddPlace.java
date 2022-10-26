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
import com.flyaway.Dao.PlacesDaoImpl;
import com.flyaway.entities.Airlines;
import com.flyaway.entities.Places;

/**
 * Servlet implementation class AddPlace
 */
@WebServlet("/AddPlace")
public class AddPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlace() {
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
		String placeCode=request.getParameter("code");
		String placeName=request.getParameter("name");
		PlacesDaoImpl PlacesDao = new PlacesDaoImpl();
		Places place = new Places();
		place.setPlaceCode(placeCode);
		place.setPlaceName(placeName);
		
		PlacesDao.insert(place);
		RequestDispatcher rd = request.getRequestDispatcher("AddPlace.html");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Place added successfully!!</h1>");
		
		rd.include(request, response);
	}

}
