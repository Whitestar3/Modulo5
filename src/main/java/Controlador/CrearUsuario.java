package Controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Modelo.Usuario;
import Dao.UsuarioDao;
import Dao.UsuarioDaoImplementacion;

/**
 * Servlet implementation class CrearUsuario
 */
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// con response.sendredirect nos hace redireccionar de forma visual al usuario
		// si lo enviamos con la ruta /registrarse se cambiará a /registrarse.jsp
		// response.sendRedirect("index.jsp");

		// con requestdispatcher se hace una redireccion interna
		// si lo enviamos con la ruta /registarse seguira mostrando /registrase pero con
		// la vista cambiada
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("Index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = null;
		UsuarioDao usuarioDao = new UsuarioDaoImplementacion();
		RequestDispatcher dispatcher = null;

		// ahora le damos los parametros
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		int operacion;

		try {
			usuario = new Usuario(nombre, apellido, correo, contrasena, 0.00);
			operacion = usuarioDao.guardar(usuario);
			if (operacion > 0) {
				// si la operacion de guardado sale exitoso se almacena en
				// status y si es mayor a uno da success y todo salio
				// bien vamos a INDEX.JSP con el usuario nuevo guardado
				request.setAttribute("status", "success");
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				// si la operacion sale mal se guarda la variable en estatus
				// pero no es mayor a 1 entonces es fallido y te mantiene en la pagina
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
