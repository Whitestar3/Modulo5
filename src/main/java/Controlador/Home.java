package Controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Modelo.Usuario;

import java.io.IOException;

import Dao.UsuarioDao;
import Dao.UsuarioDaoImplementacion;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	UsuarioDao usuarioDao = new UsuarioDaoImplementacion();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// nos traemos al usuario guardado en la sesion
		HttpSession session = request.getSession(false);
		// colocamos false para que no nos cree una si es que no existe
		// si no existe sesion
		if (session == null) {
			// que nos redireccione al login
			response.sendRedirect("login");
		} else {
			// nos traemos el id del usuario
			Object id = session.getAttribute("id");

			// si no existe id
			if (id == null) {
				// que nos redireccione al login
				response.sendRedirect("login");
			} else {
				// y si es que existe al home
				int id2 = (int) session.getAttribute("id");
				Usuario usuario = usuarioDao.obtenerUsuarioPorID(id2);
				session.setAttribute("usuario", usuario);
				rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
		}

	}

}
