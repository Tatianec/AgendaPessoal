package controller;

import java.io.IOException;

import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

import dao.PasswordEncryptor;

@WebServlet("/registerUsuario")
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UsuarioDao usuarioDao = new UsuarioDao();
    PasswordEncryptor password = new PasswordEncryptor();

    public UsuarioServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuarioregister.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        Usuario usuario = new Usuario();
        usuario.setLogin(login);

        String newPassword = password.encryptPassword(senha);

        usuario.setSenha(newPassword);
        usuario.setNome(nome);
        usuario.setEmail(email);

        try {
            if (usuarioDao.usuarioJaCadastrado(usuario)) {
            	request.setAttribute("mensagemErro", "Já existe um usuário cadastrado com essas informações.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/usuarioregister.jsp");
                dispatcher.forward(request, response);
                return;
            }

            usuarioDao.registerUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
        dispatcher.forward(request, response);
    }

}
