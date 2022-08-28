package domain.iface;

import domain.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface I_System {
    void registrationUser();

    User authorization(User user);

    void createCard();

    ArrayList<Card> returnListCardsUser();

    ArrayList<ListCurrency> returnListCurrency();

    ArrayList<Phone> returnListPhone();

    BigDecimal priceCurrency(String sellCurrency, String buyCurrency);

    void replenishmentCardUser(String numberCard, BigDecimal money);

    void changeCurrencyCard(String numberCard, BigDecimal money, String currency);
    void createPhone(User user, String numberPhone, String currency);

    void replenishmentPhone(String numberCard, BigDecimal reductionAmount, String numberPhone, BigDecimal replenishmentAmount);

}
