package academia.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;

import academia.modelo.dao.UsuarioDaoImpl;
import academia.modelo.pojo.Cursos;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("contrasena");
		UsuarioDaoImpl dao = new UsuarioDaoImpl();
		Usuario usuario = new Usuario();

		usuario = dao.buscar(nombre, password);
		
		
		
			
		
			
		if (usuario == null) {
			request.setAttribute("mensaje", "Credenciales incorrectas, prueba de nuevo por favor");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else if (Usuario.getRolAlumno() != Usuario.ROL_PROFESOR) {

			// LISTAR CURSOS DE PROFESORES
		/*	ArrayList<Cursos> cursos = new ArrayList<Cursos>();
			cursos = dao.listarProfesor(usuario.getId());
			// Crea el DAO de Cursos y obtento todos los cursos de ese profesor por su id
			request.setAttribute("cursos", cursos);

		*/	request.getSession().setAttribute("usuario_sesion", usuario);
			response.sendRedirect(request.getContextPath()+"/privado/profesor");
			//request.getRequestDispatcher("privado/profesor").forward(request, response);

		} else { /// LISTAR CURSOS DE ALUMNOS
			
			request.getSession().setAttribute("usuario_sesion", usuario);
			response.sendRedirect(request.getContextPath()+"/privado/alumnos");
		}
		
	}	
		
}
