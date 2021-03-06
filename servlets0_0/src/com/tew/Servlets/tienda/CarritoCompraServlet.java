package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoCompraServlet
 */
@WebServlet(name="CarritoCompraServlet",urlPatterns= {"/CarritoCompraServlet"})

public class CarritoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>CARRITO DE LA COMPRA</TITLE></HEAD>");
		out.println("<BODY>");
		
		out.println("<h1>TIENDA</h1>");
		
		out.println("<form method=\"post\" >\r\n" + 
				"		<br>\r\n" + 
				"		<table >\r\n" + 
				"			<tr>\r\n" + 
				"				<td >escoja el art�culo que desea:</td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td>\r\n" + 
				"					<select name=\"producto\" size=\"1\">\r\n" + 
				"					<option value=\"010\">Monty Python and the Holy Grail</option>\r\n" + 
				"					<option value=\"345\">La gran apuesta</option>\r\n" + 
				"					<option value=\"025\">Four Rooms</option>\r\n" +
				"					<option value=\"654\">From Dusk till Down</option>\r\n" + 
				"					<option value=\"123\">1917</option>\r\n" + 
				"					<option value=\"587\">Knives Out</option>\r\n" + 
				"					<option value=\"914\">Jojo Rabbitd</option>\r\n" + 
				"					<option value=\"863\">Tenet</option>\r\n" + 
				"					<option value=\"753\">The silence of the Lambs</option>\r\n" + 
				"					<option value=\"206\">Sin City</option>\r\n" + 
				"					</select>\r\n" + 
				"				</td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td >\r\n" + 
				"					<input type=\"submit\" value=\"a�adir al carrito...\">\r\n" + 
				"				</td>\r\n" + 
				"			</tr>\r\n" + 
				"		</table>\r\n" + 
				"	</form>");
		
		
		RequestDispatcher dispatcher =getServletContext().getNamedDispatcher("CarritoLogica");
		
    	dispatcher.include(request, response);
		
		
		
		out.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
