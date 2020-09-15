package academia.modelo.dao;

import academia.modelo.pojo.Cursos;

import java.sql.SQLException;
import java.util.ArrayList;







	public interface CursoDao{
		
		ArrayList <Cursos> listar();
		
		public void InsertarProfesor( String nomb, String apellidos) throws Exception;
		public void ActualizarPasword (int pasw) throws Exception ;
		
		
	}

