package dao.sql;

import dao.controller.DBConnector;
import dao.sql.query.QueryUser;
import domain.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLCheckIDDAO {
    public static int checkIdUser(User user) {
        int id = 0;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryUser.selectUser())
        ) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    id = resultSet.getInt("id_user");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
