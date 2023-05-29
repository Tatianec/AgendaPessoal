package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDao {

	Usuario user = new Usuario();

	public int registerUsuario(Usuario usuario) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "insert into usuarios (login, senha, nome, email) values (?, ?, ?, ?);";

		int result = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
				"root", "T8157124*");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.setString(4, usuario.getEmail());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
		}
		return result;
	}

	public int validarUsuario(String login, String senha) throws ClassNotFoundException {
		int id = 0;

		String GET_USERS_SQL = "select id from usuarios where login = ? and senha = ? ;";

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
				"root", "T8157124*");

				PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_SQL)) {
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, senha);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				id = rs.getInt("id");
				System.out.println(id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			id = -1;
			return id;
		}

		return id;
	}

	public Usuario getUsuarioByLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
	}
}
