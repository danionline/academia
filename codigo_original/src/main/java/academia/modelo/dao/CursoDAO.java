package academia.modelo.dao;

import java.util.ArrayList;

import academia.modelo.pojo.Cursos;

public interface CursoDAO {

	
	ArrayList<Cursos> listar();
	void insertarProfesor(String nomb, String apellidos) throws Exception;
	void actualizarPasword(int pasw) throws Exception;
	
}
