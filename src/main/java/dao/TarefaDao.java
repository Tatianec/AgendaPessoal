package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.util.List;
import java.util.ArrayList;

import model.Tarefa;

public class TarefaDao {

	public int registrarTarefa(Tarefa tarefa) throws ClassNotFoundException {

		String status = "Em aberto";
		
		java.util.Date dataCriacao = new java.util.Date(); 

		Date dataCriacaoSql = new Date(dataCriacao.getTime());

		String INSERT_TAREFA_SQL = "insert into tarefas (titulo, descricao, data_criacao, status, usuario_id) values (?, ?, ?, ?, ?);";

		int result = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
				"root", "T8157124*");

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TAREFA_SQL)) {
			preparedStatement.setString(1, tarefa.getTitulo());
			preparedStatement.setString(2, tarefa.getDescricao());
			preparedStatement.setDate(3, dataCriacaoSql);
			preparedStatement.setString(4, status);
			preparedStatement.setInt(5, tarefa.getIdUsuario());

			System.out.println(preparedStatement);

			result = preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Tarefa> getTarefasByIdUsuario(int id) throws ClassNotFoundException {
	    List<Tarefa> tarefas = new ArrayList<>();

	    String GET_TAREFAS_SQL = "SELECT * FROM tarefas WHERE usuario_id = ?";

	    Class.forName("com.mysql.jdbc.Driver");

	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
	            "root", "T8157124*");

	            PreparedStatement preparedStatement = connection.prepareStatement(GET_TAREFAS_SQL)) {
	        preparedStatement.setInt(1, id);

	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            Tarefa tarefa = new Tarefa();
	            tarefa.setId(rs.getInt("id"));
	            tarefa.setTitulo(rs.getString("titulo"));
	            tarefa.setDescricao(rs.getString("descricao"));
	            tarefa.setDataCriacao(rs.getDate("data_criacao"));
	            tarefa.setDataConclusao(rs.getDate("data_conclusao"));
	            tarefa.setStatus(rs.getString("status"));

	            tarefas.add(tarefa);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return tarefas;
	}
	
	public Tarefa getTarefaById(int id) throws ClassNotFoundException {
		
		Tarefa tarefa = null;
		
	    String GET_TAREFAS_SQL = "SELECT id, titulo, descricao, status FROM tarefas WHERE id = ?";

	    Class.forName("com.mysql.jdbc.Driver");

	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
	            "root", "T8157124*");

	            PreparedStatement preparedStatement = connection.prepareStatement(GET_TAREFAS_SQL)) {
	        preparedStatement.setInt(1, id);

	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	        	tarefa = new Tarefa();
	        	tarefa.setId(rs.getInt("id"));
	            tarefa.setTitulo(rs.getString("titulo"));
	            tarefa.setDescricao(rs.getString("descricao"));
	            tarefa.setStatus(rs.getString("status"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return tarefa;
	}
	
	public int atualizarTarefa(Tarefa tarefa) throws ClassNotFoundException {
		
		java.util.Date dataConclusao = new java.util.Date(); 

		Date dataConclusaoSql = new Date(dataConclusao.getTime());

		String INSERT_TAREFA_SQL = "UPDATE tarefas SET titulo = ?, descricao = ?, data_conclusao = ?, status = ? WHERE id = ?;";

		int result = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
				"root", "T8157124*");

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TAREFA_SQL)) {
	        preparedStatement.setString(1, tarefa.getTitulo());
	        preparedStatement.setString(2, tarefa.getDescricao());

	        String status = tarefa.getStatus();
	        
	        System.out.println(status);
	        
	        if (status == null) {
	            preparedStatement.setDate(3, null);
	            preparedStatement.setString(4, "Em aberto");
	        } else {
	            preparedStatement.setDate(3, dataConclusaoSql);
	            preparedStatement.setString(4, status);
	        }

	        preparedStatement.setInt(5, tarefa.getId());
	        
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int excluirTarefa(int id) throws ClassNotFoundException {
		
	    String DELETE_TAREFA_SQL = "DELETE FROM tarefas WHERE id = ?";

	    int result = 0;

	    Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
				"root", "T8157124*");

	            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TAREFA_SQL)) {
	        preparedStatement.setInt(1, id);

	        result = preparedStatement.executeUpdate();

	        preparedStatement.close();
	        connection.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}


}
