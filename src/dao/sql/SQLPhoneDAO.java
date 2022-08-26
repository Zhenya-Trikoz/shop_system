package dao.sql;

import dao.controller.DBConnector;
import dao.iface.PhoneDAO;
import dao.sql.query.QueryPhone;
import domain.model.Phone;
import domain.model.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLPhoneDAO implements PhoneDAO {
    @Override
    public void createPhone(User user, String numberPhone, String currency) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryPhone.createPhone())
        ) {
            statement.setString(1, numberPhone);
            statement.setBigDecimal(2, new BigDecimal(0));
            statement.setString(3, currency);
            statement.setInt(4, SQLCheckIDDAO.checkIdUser(user));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Phone> returnListPhone(User user) {
        ArrayList<Phone> listPhone = new ArrayList<>();
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryPhone.readListPhone())
        ) {
            statement.setInt(1, SQLCheckIDDAO.checkIdUser(user));
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    listPhone.add(new Phone(resultSet.getString("numberPhone"),
                            resultSet.getBigDecimal("amount"),
                            resultSet.getString("currency")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPhone;
    }

    @Override
    public void updateBalancePhone(String numberPhone, BigDecimal amount) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryPhone.updateBalancePhone())
        ) {
            statement.setBigDecimal(1, amount);
            statement.setString(2, numberPhone);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
