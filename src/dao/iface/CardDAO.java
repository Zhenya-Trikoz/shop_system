package dao.iface;

import domain.model.Card;
import domain.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface CardDAO {
    void createCard(User user);

    void readCard();

    ArrayList<Card> readListCard(User user);

    void deleteCard();

    void updateCard(String numberCard, BigDecimal money);

}
