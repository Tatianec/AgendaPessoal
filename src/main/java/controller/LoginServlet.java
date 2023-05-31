package controller;

import java.io.IOException;

import dao.TarefaDao;
import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Usuario;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDao usuarioDao = new UsuarioDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        try {
            Integer id = usuarioDao.validarUsuario(login, senha);

            if (id != null && id > 0) {
                request.getSession().setAttribute("id", id);
                response.sendRedirect(request.getContextPath() + "/tarefas");
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private boolean isValidLogin(String name, String password) {

		return true;
	}
}
