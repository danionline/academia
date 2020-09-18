package academia.modelo.dao;

import java.util.ArrayList;

import academia.modelo.pojo.Cursos;
import academia.modelo.pojo.Usuario;

public interface UsuarioDAO {

	/**
	 * Busca alumnos que contengan la palabraBuscada
	 * 
	 * @param palabraBuscada palabra a buscar
	 * @return ArrayList<Alumno>
	 * 
	 *         Ej: si palabraBuscada = "a" <br>
	 *         lista [ "ander", "pepe", "manolo"] <br>
	 *         retorna ["ander","manolo"] <br>
	 * 
	 *         SQL = SELECT id, nombre FROM alumno WHERE nombre LIKE '%a%' ORDER BY
	 *         nopmbre ASC;
	 * 
	 */
	ArrayList<Usuario> getAllByNombre(String palabraBuscada);

	/**
	 * Busca si existe el usuario en la base datsos
	 * 
	 * @param nombre   String nombre del usuario
	 * @param password String contraseña para acceder, cuidado que esta cifrada en
	 *                 MD5
	 * @return Usuario con datos si lo encuentra, si no existe retorna null
	 */
	 
	Usuario buscar(String nombre, String password);
	 
	 ArrayList<Cursos> listarAlumnos(int id);
	
	 ArrayList<Cursos> listarProfesor(int id);
}
