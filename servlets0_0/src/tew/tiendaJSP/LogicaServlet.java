package tew.tiendaJSP;

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
 * Servlet implementation class Logica
 */

@WebServlet(name="Logica",urlPatterns= {"/Logica"})
public class LogicaServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicaServlet() {
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
		
		//Añadimos el producto recibido al carrito de la compra (en caso de que no sea nulo!)
		String producto = request.getParameter("producto");
		if ( producto != null ){
			Integer cantidad = (Integer) carrito.get(producto);
			if ( cantidad == null )
				cantidad = new Integer ( 1 );
			else
				cantidad = new Integer ( cantidad.intValue() + 1 );
			//Y añadimos el producto al carrito
			carrito.put(producto, cantidad);	
		}
		//Añadimos el carrito a la sesión
		request.getSession().setAttribute("carrito",carrito);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tienda.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
