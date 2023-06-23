package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Usuario;

public class UsuarioDao {

	Usuario user = new Usuario();
    PasswordEncryptor password = new PasswordEncryptor();

    public boolean usuarioJaCadastrado(Usuario usuario) throws ClassNotFoundException {
        String SELECT_USERS_SQL = "select count(*) as count from usuarios where login = ? or email = ?;";

        boolean usuarioExistente = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
                "root", "T8157124*");

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL)) {
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getEmail());

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                usuarioExistente = count > 0;
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarioExistente;
    }

    public int registerUsuario(Usuario usuario) throws ClassNotFoundException {
        if (usuarioJaCadastrado(usuario)) {
            return 0;
        }

        String INSERT_USERS_SQL = "insert into usuarios (login, senha, nome, email) values (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
                "root", "T8157124*");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setString(3, usuario.getNome());
            preparedStatement.setString(4, usuario.getEmail());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


	public int validarUsuario(String login, String senha) throws ClassNotFoundException {
		int id = 0;

		
		String GET_USERS_SQL = "SELECT id, senha FROM usuarios WHERE login = ?";

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false",
				"root", "T8157124*");

			PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_SQL)) {
			preparedStatement.setString(1, login);

			ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("senha");
                boolean passwordMatch = password.checkPassword(senha, hashedPassword);

                if (passwordMatch) {
                    id = rs.getInt("id");
                    System.out.println("Senha correspondente: true");
                } else {
                    System.out.println("Senha correspondente: false");
                }
            } else {
                System.out.println("Usuário não encontrado");
            }

		} catch (SQLException e) {
			e.printStackTrace();
			id = -1;
			return id;
		}

		return id;
	}
	

}
