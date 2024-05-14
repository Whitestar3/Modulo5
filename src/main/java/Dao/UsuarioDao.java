package Dao;

import java.util.List;

import Modelo.Usuario;

public interface UsuarioDao {

	public int guardar(Usuario usuario);

	// public int actualizar(Usuario usuario);
	// operacion depositar
	public int depositar(Double monto, int usuarioID);

	// operacion retirar
	public int retirar(Double monto, int usuarioID);

	// obtener usuario en login
	public Usuario obtenerUsuario(String correo, String contrasena);

	// obtener usuario en home
	public Usuario obtenerUsuarioPorID(int usuarioID);

	// comodin
	public List<Usuario> obtenerTodos();
	// public int eliminar(int idUsuario);

}
