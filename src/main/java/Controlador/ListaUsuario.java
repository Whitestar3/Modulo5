package Controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Usuario;

import Dao.UsuarioDao;
import Dao.UsuarioDaoImplementacion;

@WebServlet("/lista")
public class ListaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDao = new UsuarioDaoImplementacion();
	// requestDIspatcher es un reenviador de solicitudes
	// el objetivo es enviar esto para que sea visible en JSP
	RequestDispatcher dispatcher = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Usuario> lista = new ArrayList<>();
		lista = usuarioDao.obtenerTodos();
		request.setAttribute("lista", lista);
		dispatcher = request.getRequestDispatcher("lista.jsp");
		dispatcher.forward(request, response);
	}

}
