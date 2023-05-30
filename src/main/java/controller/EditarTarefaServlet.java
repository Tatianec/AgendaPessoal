package controller;

import java.io.IOException;
import java.util.List;

import dao.TarefaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;

@WebServlet("/editarTarefa")
public class EditarTarefaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private TarefaDao tarefaDao = new TarefaDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String idTarefaString = request.getParameter("id");

	    try {
	        int idTarefa = Integer.parseInt(idTarefaString);
	        
	        Tarefa tarefa = tarefaDao.getTarefaById(idTarefa);

	        request.setAttribute("tarefa", tarefa);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/editartarefa.jsp");
	        dispatcher.forward(request, response);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }   
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 String idTarefaString = request.getParameter("id");


		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		
		String concluido = request.getParameter("concluido");

		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo(titulo);
		tarefa.setDescricao(descricao);
		
		if (!concluido.isEmpty()) {
		    tarefa.setStatus("Concluído");
		}

		try {
			int idTarefa = Integer.parseInt(idTarefaString);
			tarefa.setId(idTarefa);
		        
			tarefaDao.atualizarTarefa(tarefa);
		} catch (Exception e) {
			throw new ServletException("Erro ao atualizar a tarefa", e);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tarefas.jsp");
		dispatcher.forward(request, response);
	}
	
}
