package ar.com.cmierez.beer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.cmierez.beer.model.*;

/**
 * Servlet implementation class BeerController
 */
@WebServlet("/BeerController")
public class BeerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BeerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 String c = request.getParameter("color");
		
		 // Instantiating BeerExpert Model class and calls
		 // getBrands() to get the Beer advice
		 BeerExpert be = new BeerExpert();
		 List<String> result = be.getBrands(c);
		
		 // add an attribute to the request object for the JSP to use.
		 // JSP is looking for "styles"
		 request.setAttribute("styles", result);
		
		 // Instantiate a request dispatcher for the JSP
		 RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		
		 // Uses the request dispatcher to ask the dispatcher to crank up the
		 // JSP,
		 // sending it the request and response
		 view.forward(request, response);

	}

}
