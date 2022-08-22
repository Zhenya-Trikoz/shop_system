package dao.sql;

import dao.controller.DBConnector;
import dao.iface.UserDAO;
import dao.sql.query.QueryUser;
import domain.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {
    @Override
    public void createUser(User user) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryUser.createUser())
        ) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getLogin());
            statement.setString(6, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User readUser(User user) {

        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryUser.selectUser())
        ) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            user = null;
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    String login_user = resultSet.getString("login_user");
                    String password_user = resultSet.getString("password_user");
                    user = new User(first_name, last_name, age, email, login_user, password_user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public void deleteUser() {

    }
}
