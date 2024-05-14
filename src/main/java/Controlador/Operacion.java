package Controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Modelo.Usuario;

import Dao.UsuarioDao;
import Dao.UsuarioDaoImplementacion;

@WebServlet("/operaciones")
public class Operacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDao usuarioDao = new UsuarioDaoImplementacion();
	Usuario usuario = null;
	int exitoso = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// obtenemos parametros de la ruta
		String operacion = request.getParameter("operacion");
		Double monto = Double.parseDouble(request.getParameter("operacion"));

		// obtener sesion
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("id");

		// obtener usuario
		usuario = (Usuario) session.getAttribute("usuario");

		// saber si es depositar o retirar
		if (operacion.equals("depositar")) {
			exitoso = usuarioDao.depositar(monto, id);
			if (exitoso > 0) {
				session.setAttribute("status", "success");
				response.sendRedirect("home");
			} else {
				session.setAttribute("status", "failed");
				response.sendRedirect("home");
			}
		} else if (operacion.equals("retirar")) {
			if (usuario.getSaldo() >= monto) {
				exitoso = usuarioDao.retirar(monto, id);
				if (exitoso > 0) {
					session.setAttribute("status", "success");
					response.sendRedirect("home");
				} else {
					session.setAttribute("status", "failed");
					response.sendRedirect("home");
				}
			} else {
				session.setAttribute("status", "failed");
				response.sendRedirect("home");
			}

		}

	}

}
