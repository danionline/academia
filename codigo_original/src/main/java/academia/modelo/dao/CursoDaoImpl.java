package academia.modelo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;


import academia.modelo.pojo.ConnectionManager;
import academia.modelo.dao.CursoDao;

import academia.modelo.pojo.Cursos;
import academia.modelo.pojo.Profesores;
/**
 * 
 */


/**
 * @author dani
 *
 */
public class CursoDaoImpl implements CursoDao {
	





		
		
		private final static String SQL_LISTAR = "SELECT \n" + 
													"	c.id as 'curso_id',\n" + 
													"	c.identificador,\n" + 
													"	c.nombre as 'curso_nombre',\n" + 
													"	c.horas,\n" + 
													"	f.id as 'profesor_id',\n" + 
													"	f.nombre as 'profesor_nombre',\n" + 
													"	f.apellidos as 'profesor_apellidos'\n" + 
													"\n" + 
													"FROM cursos c, profesores f\n" + 
													"WHERE\n" + 
													"	c.id_profesor = f.id;";
		

		public ArrayList <Cursos> listar() {
			
			ArrayList <Cursos> cursos = new ArrayList<Cursos>();
			
			try( Connection con = ConnectionManager.getConnection() ;
				 PreparedStatement pst = con.prepareStatement(SQL_LISTAR);
				 ResultSet rs = pst.executeQuery()	
				){
				
				while ( rs.next() ) {				
					
					Cursos c = new Cursos();
					c.setId( rs.getInt("curso_id"));
					c.setNombre( rs.getString("curso_nombre"));
					c.setIdentificador(rs.getString("identificador"));
					c.setHoras(rs.getInt("horas"));
					
					Profesores p = new Profesores();
					p.setId(rs.getInt("profesor_id"));
					p.setNombre(rs.getString("profesor_nombre"));
					p.setApellidos(rs.getString("profesor_apellidos"));
					
					c.setProfesor(p);
					
					cursos.add(c);
					
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return cursos;
		}

	}

	
