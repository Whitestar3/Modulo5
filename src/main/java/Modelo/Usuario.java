package Modelo;

public class Usuario {

	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	private Double saldo;

	public Usuario() {
	}

	// contructor para crear nuevos registros
	public Usuario(String nombre, String apellido, String correo, String contrasena, Double saldo) {
		super();

		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		this.saldo = saldo;
	}

	// contructor con todos los datos para actualizar y buscar
	public Usuario(int id, String nombre, String apellido, String correo, String contrasena, Double saldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		this.saldo = saldo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	// este overrider es para depurar los datos y sea mas limpios.
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", contrasena=" + contrasena + ", saldo=" + saldo + "]";
	}

}
