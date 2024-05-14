package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	private static final String URL = "jdbc:mysql://localhost:3306/modulo5";
	private static final String USER = "root";
	private static final String PASSWORD = "12345678";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static Connection conexion = null;

	public static Connection getConexion() {
		try {
			// registrar driver
			Class.forName(DRIVER);
			// establecemos conexion con la base de datos
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conectado");
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("No conectado");
			ex.printStackTrace();
		}

		return conexion;
	}

	public static void main(String[] args) {
		Connection conexion = getConexion();
		Statement stmt = null;
		try {
			// le indicamos que estamos creando una sentencia sql
			stmt = conexion.createStatement();
			String consultaSQL = "select * from usuarios";
			// lo guardamos y ejecutamos la consulta
			ResultSet rs = stmt.executeQuery(consultaSQL);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String correo = rs.getString("correo");
				String contrasena = rs.getString("contrasena");
				Double saldo = rs.getDouble("saldo");
				System.out.println(id + nombre + apellido + correo + contrasena + saldo);
			}
			// recordar que por seguridad debemos cerrar conexiones
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
