package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoLogica
 */

@WebServlet(name="CarritoLogica",urlPatterns= {"/CarritoLogica"})
public class CarritoLogica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoLogica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		@SuppressWarnings("unchecked")
		HashMap<String,Integer> carrito = (HashMap<String,Integer>)request.getSession().getAttribute("carrito");
		if ( carrito == null ) {carrito = new HashMap<String, Integer>();}
		
		
		String producto = request.getParameter("producto");
		if ( producto != null ){
			Integer cantidad = (Integer) carrito.get(producto);
			if ( cantidad == null )
				cantidad = new Integer ( 1 );
			else
				cantidad = new Integer ( cantidad.intValue() + 1 );
			
			carrito.put(producto, cantidad);	
		}
		
		request.getSession().setAttribute("carrito",carrito);
		
		out.println("<br>\r\n" + 
				"			<H2>Carrito de la compra</h2>\r\n" + 
				"		<br>\r\n" + 
				"			<ul>\r\n" );
				for(HashMap.Entry<String,Integer> entry : carrito.entrySet()) {
					out.println("<li> PRODUCTO:"+entry.getKey() +": "+ entry.getValue()+ "unidades</li>");
				}
				
				out.println("</ul> ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
