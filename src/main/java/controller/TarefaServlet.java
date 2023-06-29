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

@WebServlet("/tarefas")
public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TarefaDao tarefaDao = new TarefaDao();

	public TarefaServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Integer id = (Integer) request.getSession().getAttribute("id");

	    try {
	        String filtro = request.getParameter("filtro");

	        List<Tarefa> tarefas;

	        if (filtro != null && !filtro.isEmpty()) {
	            tarefas = tarefaDao.getTarefasByFiltro(id, filtro);
	        } else {
	            tarefas = tarefaDao.getTarefasByIdUsuario(id);
	        }

	        request.setAttribute("tarefas", tarefas);

	        request.getSession().setAttribute("id", id);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tarefas.jsp");
	        dispatcher.forward(request, response);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tarefas.jsp");
		dispatcher.forward(request, response);		
	}

}
