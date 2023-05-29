package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.TarefaDao;

@WebServlet("/excluirTarefa")
public class ExcluirTarefaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    TarefaDao tarefaDao = new TarefaDao();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String idTarefaString = request.getParameter("id");
        try {
            int idTarefa = Integer.parseInt(idTarefaString);
            tarefaDao.excluirTarefa(idTarefa);
            System.out.println("Tarefa excluída com sucesso");
    
            response.sendRedirect(request.getContextPath() + "/tarefas");
        } catch (Exception e) {
            throw new ServletException("Erro ao excluir a tarefa", e);
        }    
    }
}

