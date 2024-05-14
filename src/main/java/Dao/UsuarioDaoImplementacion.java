package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Conexion.Conexion;
import Modelo.Usuario;

public class UsuarioDaoImplementacion implements UsuarioDao {

	private String sql = "";
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Usuario usuario = null;

	@Override
	public int guardar(Usuario usuario) {
		int row = 0;

		sql = "INSERT INTO usuarios (nombre, apellido, correo, contrasena, saldo)\r\n" + "VALUES (?,?,?,?,?)";

		// ahora obtenemos la conexion
		con = Conexion.getConexion();
		try {
			// ahora vamos de donde saca la sentencia en la BD
			ps = con.prepareStatement(sql);
			// setetear los parametros

			ps.setString(1, usuario.getNombre());
			ps.setString(1, usuario.getApellido());
			ps.setString(1, usuario.getCorreo());
			ps.setString(1, usuario.getContrasena());
			ps.setDouble(1, usuario.getSaldo());
			// ahora indicamos que en caso de que existe alguna exepcion se ejecute lo de
			// abajo
			row = ps.executeUpdate();
			// fallo cerramos todos
			ps.close();
			con.close();
			// aca la alerta del sistema en catch
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		return row;
	}

	@Override
	public List<Usuario> obtenerTodos() {
		List<Usuario> lista = new ArrayList<>();
		Statement st;
		sql = "select * from usuarios";
		con = Conexion.getConexion();
		try {
			st = con.createStatement();
			// resultado nos trae los datos (se utiliza con select)
			rs = st.executeQuery(sql);
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContrasena(rs.getString("contrasena"));
				usuario.setSaldo(rs.getDouble("saldo"));
				lista.add(usuario);
			}
			st.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return lista;
	}

	@Override
	public int depositar(Double monto, int usuarioID) {
		int row = 0;
		sql = "UPDATE usuarios SET saldo = saldo + ? WHERE id = ?";
		con = Conexion.getConexion();

		try {
			// preparedstatement -> consulta dinamica, le debemos pasar los parametros
			// estos son representados con un ?
			PreparedStatement ps = con.prepareStatement(sql);
			// vamos a ejecutar que la query de la BD
			ps.setDouble(1, monto);
			ps.setInt(2, usuarioID);
			row = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public int retirar(Double monto, int usuarioID) {
		int row = 0;
		sql = "UPDATE usuarios SET saldo = saldo - ? WHERE id = ?";
		con = Conexion.getConexion();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, monto);
			ps.setInt(2, usuarioID);
			row = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Usuario obtenerUsuario(String correo, String contrasena) {
		sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
		con = Conexion.getConexion();
		try {
			if (con != null) { // Verifica si la conexión no es nula
				ps = con.prepareStatement(sql);
				ps.setString(1, correo);
				ps.setString(2, contrasena);
				rs = ps.executeQuery();
				if (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellido(rs.getString("apellido"));
					usuario.setCorreo(rs.getString("correo"));
					usuario.setContrasena(rs.getString("contrasena"));
					usuario.setSaldo(rs.getDouble("saldo"));
				}
			} else {
				System.out.println("Error: La conexión es nula.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return usuario;
	}

	@Override
	public Usuario obtenerUsuarioPorID(int usuarioID) {
		sql = "select * from usuarios where id = ?";
		con = Conexion.getConexion();

		try {
			// lo buscamos en nuestra BD sql
			ps = con.prepareStatement(sql);
			// reseteamos los parametros
			ps.setInt(1, usuarioID);
			// guardamos datos y ejecutamos query
			rs = ps.executeQuery();
			// si llamamos al usuario
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContrasena(rs.getString("contrasena"));
				usuario.setSaldo(rs.getDouble("saldo"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuario;
	}

}
