package dao.sql;

import dao.controller.DBConnector;
import dao.iface.CardDAO;
import dao.sql.query.QueryCard;
import domain.model.Card;
import domain.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLCardDAO implements CardDAO {
    @Override
    public void createCard(User user) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryCard.createCard())
        ) {
            statement.setString(1, user.getCard().getNumberCard());
            statement.setString(2, user.getCard().getDataEndCard());
            statement.setString(3, user.getCard().getCVC2());
            statement.setString(4, user.getCard().getCurrency());
            statement.setInt(5, SQLCheckIDDAO.checkIdUser(user));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readCard() {

    }

    @Override
    public ArrayList<Card> readListCard(User user) {
        ArrayList<Card> cards = new ArrayList<>();
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryCard.readListCard())
        ) {
            statement.setInt(1, SQLCheckIDDAO.checkIdUser(user));
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cards.add(new Card(resultSet.getString("numberCard"),
                            resultSet.getString("dataEmdCard"),
                            resultSet.getString("CVC2"),
                            resultSet.getBigDecimal("money"),
                            resultSet.getString("currency")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    @Override
    public void deleteCard() {

    }

    @Override
    public void updateCard() {

    }
}
