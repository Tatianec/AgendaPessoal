package controller;

import java.io.IOException;

import dao.TarefaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;

@WebServlet("/registrarTarefas")
public class RegistrarTarefasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TarefaDao tarefaDao = new TarefaDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/registrartarefas.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		
		Integer id = (Integer) request.getSession().getAttribute("id");
		
		TarefaServlet tarefaServelet = new TarefaServlet();

		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo(titulo);
		tarefa.setDescricao(descricao);

		try {
			tarefa.setIdUsuario(id);
			tarefaDao.registrarTarefa(tarefa);
			
            request.getSession().setAttribute("id", id);
            response.sendRedirect(request.getContextPath() + "/tarefas");
		} catch (Exception e) {
			throw new ServletException("Erro ao registrar tarefa", e);
		}

	}
}
