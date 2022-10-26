package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.Dao.BookingsDao;
import com.flyaway.Dao.FlightsdaoImpl;
import com.flyaway.entities.Flights;

/**
 * Servlet implementation class BookingConfirmation
 */
@WebServlet("/BookingConfirmation")
public class BookingConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingConfirmation() {
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
		String passDetails = request.getParameter("passdetails");
		int payAmt = Integer.parseInt(request.getParameter("paymentAmount"));
		int noofpersons = Integer.parseInt(request.getParameter("persons"));
		String dateoftravel = request.getParameter("dtoftravel");
		int fid = Integer.parseInt(request.getParameter("flid"));
		int crdnum = Integer.parseInt(request.getParameter("cardnumber"));
		int cvv=Integer.parseInt(request.getParameter("cvv"));
		String expdate = request.getParameter("expiry");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		String currentDateTime = format.format(date);
		String[] passengers=passDetails.split(",");
		FlightsdaoImpl flightdao = new FlightsdaoImpl();
		Flights flight = flightdao.getById(fid);
		BookingsDao bookingDao=new BookingsDao();
		
		try {
		bookingDao.insert(fid, crdnum, expdate, cvv, passDetails, payAmt, noofpersons, dateoftravel, currentDateTime);
		}catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Flight Booking Confirmed!!!</h1>");
		pw.println("-------------------------------------------------------------------------------------");
		pw.println("<b><br>BOOKING DETAILS:</b>");
		pw.println("<br>Travel Date :" + dateoftravel);
		pw.println("<br>No. of persons :" + noofpersons);
		pw.println("<br><br><b>Flight details:</b>");
		pw.println("<br>Airline :"+flight.getAirline());
		pw.println("<br>Route :"+flight.getRoute());
		pw.println("<br>Boarding at :"+flight.getSource());
		pw.println("<br>Destination :"+flight.getDestination());
		pw.println("<br><br><b>Passenger details:</b>");
		int i=1;
		for(String s:passengers) {
			pw.println("<br>Passenger "+i+": "+s);
		}
		pw.println("<br><br><b>Payment details:</b>");
		pw.println("<br>Amount paid : <b>" + payAmt+" INR</b>");
		pw.println("<br>Card Number :" + crdnum);
		
		pw.println("<br><br><center>Thank you for choosing FlyAway as your trusted travel partner. Excited to serve u again!!</center>");
		pw.println("<html><body>");
		
	}

}
