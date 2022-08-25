package user_interface.switchBox;

import domain.iface.I_System;
import domain.model.Card;
import domain.model.Currency;
import domain.model.ListCurrency;
import domain.model.User;
import domain.system.SystemImp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SwitchBox {
    public static ArrayList<Card> setListCard(User user, JComboBox comboBoxUserCard) {
        I_System i_system = new SystemImp(user);
        ArrayList<Card> cards = i_system.returnListCardsUser();

        Iterator<Card> iterator = cards.iterator();
        comboBoxUserCard.addItem("Your choose");
        while (iterator.hasNext()) {
            comboBoxUserCard.addItem(iterator.next().getNumberCard());
        }
        return cards;
    }

    public static ArrayList<ListCurrency> setListCurrency(JComboBox comboBoxCurrency) {
        I_System i_system = new SystemImp();
        ArrayList<ListCurrency> listCurrency = i_system.returnListCurrency();

        Iterator<ListCurrency> iterator = listCurrency.iterator();
        comboBoxCurrency.addItem("Your choose");
        while (iterator.hasNext()) {
            comboBoxCurrency.addItem(iterator.next().getCurrency());
        }

        return listCurrency;
    }

}
