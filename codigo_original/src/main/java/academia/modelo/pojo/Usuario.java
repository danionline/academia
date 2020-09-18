package academia.modelo.pojo;

public class Usuario {

	public static final int ROL_PROFESOR = 2;
	public static final int ROL_ALUMNO = 1;
	private int id;
	private String nombre;
	private String contrasena;
	private int rol;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.contrasena = "";
		this.rol = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String conse) {
		this.contrasena = conse;
	}

	public Usuario(int id, String nombre, String contrasena, int rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.rol = rol;
	}

	public static int getRolProfesor() {
		return ROL_PROFESOR;
	}

	public static int getRolAlumno() {
		return ROL_ALUMNO;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", rol=" + rol + "]";
	}

}
