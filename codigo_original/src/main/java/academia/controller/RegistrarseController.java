package academia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.modelo.dao.CursoDaoImpl;

/**
 * Servlet implementation class RegistrarseController
 */
@WebServlet("/formulario")
public class RegistrarseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarseController() {
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

		CursoDaoImpl dao = new CursoDaoImpl();
		
		
		String apellidos= (String) request.getAttribute("apellidos");
		String nomb =(String) request.getAttribute("nombre");
		try {
			dao.InsertarProfesor(nomb, apellidos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		request.getAttribute("ha sido con exito");
		request.getRequestDispatcher("registrarse.jsp").forward(request, response);;
		
		
	}

}