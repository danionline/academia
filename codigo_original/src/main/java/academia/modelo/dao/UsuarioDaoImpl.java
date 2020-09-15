package academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import academia.modelo.pojo.ConnectionManager;
import academia.modelo.pojo.Usuario;



public class UsuarioDaoImpl implements UsuarioDAO {

	private static UsuarioDaoImpl INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(UsuarioDaoImpl.class);

	// exceuteQuerys => ResultSet
	static final String SQL_GET_ALL_BY_NOMBRE = " SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol' FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE nombre LIKE ? LIMIT 500 ;   ";
	static final String SQL_GET_ALL           = " SELECT id_usuarios , nombre,pasword FROM usuarios ORDER BY id_usuarios DESC LIMIT 500 ; ";
	static final String SQL_GET_BY_ID         = " SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol' FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE u.id = ? ; ";
	static final String SQL_EXISTE            = " SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol' FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE u.nombre = ? AND contrasenia = ? ; ";

	// executeUpdate => int
	static final String SQL_INSERT = " INSERT INTO usuario(nombre, contrasenia, id_rol) VALUES( ? , ? , ? ); ";
	static final String SQL_DELETE = " DELETE FROM usuario WHERE id = ? ;";
	static final String SQL_UPDATE = " UPDATE usuario SET nombre = ?, contrasenia = ? , id_rol = ? WHERE id = ? ; ";

	private UsuarioDaoImpl() {
		super();
	}

	static synchronized public UsuarioDaoImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDaoImpl();
		}

		return INSTANCE;

	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			LOG.debug(pst);
			while (rs.next()) {				
				usuarios.add( mapper(rs) );
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return usuarios;
	}

	
	
	private Usuario mapper( ResultSet rs ) throws SQLException {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setContrasena( rs.getString("contrasena"));
		
	
		
		
		return usuario;
		
	}

	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario existe(String nombre, String password) {
		// TODO Auto-generated method stub
		return null;
	}



}
