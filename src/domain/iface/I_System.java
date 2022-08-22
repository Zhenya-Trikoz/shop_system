package domain.iface;

import domain.model.Card;
import domain.model.User;

import java.util.ArrayList;

public interface I_System {
    void registrationUser();
    User authorization(User user);
    void createCard();

    ArrayList<Card> returnListCardsUser();
}
