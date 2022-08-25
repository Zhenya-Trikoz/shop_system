package dao.sql;

import dao.controller.DBConnector;
import dao.iface.CurrencyDAO;
import dao.sql.query.QueryCurrency;
import domain.model.Currency;
import domain.model.ListCurrency;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLCurrencyDAO implements CurrencyDAO {
    @Override
    public ArrayList<ListCurrency> readListCurrency() {
        ArrayList<ListCurrency> listCurrency = new ArrayList<>();
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryCurrency.readListCurrency())
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    listCurrency.add(new ListCurrency(resultSet.getString("currency")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCurrency;
    }

    @Override
    public BigDecimal priceCurrency(String sellCurrency, String buyCurrency) {
        BigDecimal price = null;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryCurrency.readPrice())
        ) {
            statement.setString(1, sellCurrency);
            statement.setString(2, buyCurrency);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    price = resultSet.getBigDecimal("price");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }
}
