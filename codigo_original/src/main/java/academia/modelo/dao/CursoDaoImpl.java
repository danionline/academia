package academia.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

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
public final class CursoDaoImpl implements CursoDao {
	





		
		
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
		
		
		private final static String SQL_INSERTAR ="Insert into Profesores Values (?,'pepe','ronaldo');";

		private final static String SQL_UPDATE= "Update profesores set=MD5(pasword)";

		private int[] RETURN_GENERATE_KEYS;

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
		
		
		public void insertarProfesor (String nomb, String apellidos) throws Exception {
			
			long key = -1L;
			
			try 	( Connection con = ConnectionManager.getConnection() ;
					 PreparedStatement pst = con.prepareStatement(SQL_INSERTAR,PreparedStatement.RETURN_GENERATED_KEYS)){
						
						pst.executeUpdate();

					ResultSet rs = pst.getGeneratedKeys();
					pst.setInt(1, (int) key);
			        pst.setString(2, nomb);
			        pst.setString(3, apellidos);
			       
			        pst.execute();
			        rs = pst.getGeneratedKeys();
					if (rs.next()) {
					    key = rs.getInt(1);
					}
					
			
					
				
	
	

		}
		}
		
		public void actualizarPasword (int pasw) throws Exception{
			
			try( Connection con = ConnectionManager.getConnection() ;
					 PreparedStatement pst = con.prepareStatement(SQL_UPDATE)){
						
						pst.executeUpdate();

					
					pst.setInt(1, pasw);	
			
		}
		
		
		}


		@Override
		public void InsertarProfesor(String nomb, String apellidos) throws Exception {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void ActualizarPasword(int pasw) throws Exception {
			// TODO Auto-generated method stub
			
		}
}
