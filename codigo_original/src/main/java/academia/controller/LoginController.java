package academia.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import academia.modelo.dao.UsuarioDaoImpl;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/sesion")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		UsuarioDaoImpl dao = UsuarioDaoImpl.getInstance();
		ArrayList<Usuario> asuario = null;
		asuario = dao.getAll();
		Usuario usu = new Usuario();
		String id = "";

		boolean usuariosi = false;

		HttpSession sesion = request.getSession();

		try {

			String nomb = request.getParameter("nombre");
			String cons = request.getParameter("contrasena");
			usu.setNombre(nomb);
			usu.setContrasena(cons);

			for (Usuario usuario : asuario) {

				if (usuario.getNombre().equalsIgnoreCase(nomb) & (usuario.getContrasena().equalsIgnoreCase(cons))) {

					usuariosi = true;
				}

			}
			if (usuariosi == false) {

				sesion.invalidate();
				request.setAttribute("usuario",usu);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} else {
				sesion.setMaxInactiveInterval(60 * 5);
				

				request.getRequestDispatcher("index.jsp").forward(request, response);

			}

		} catch (Exception e) {

			e.getMessage();
			e.printStackTrace();

		}
	}

}
