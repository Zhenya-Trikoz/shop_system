package domain.iface;

import domain.model.Card;
import domain.model.Currency;
import domain.model.ListCurrency;
import domain.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface I_System {
    void registrationUser();

    User authorization(User user);

    void createCard();

    ArrayList<Card> returnListCardsUser();

    ArrayList<ListCurrency> returnListCurrency();

    BigDecimal priceCurrency(String sellCurrency, String buyCurrency);

    void replenishmentCardUser(String numberCard, BigDecimal money);
}
