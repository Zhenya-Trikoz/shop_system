package user_interface.switchBox;

import domain.iface.I_System;
import domain.model.*;
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

    public static ArrayList<Phone> setListPhone(User user, JComboBox comboBoxPhone) {
        I_System i_system = new SystemImp(user);
        ArrayList<Phone> listPhone = i_system.returnListPhone();

        Iterator<Phone> iterator = listPhone.iterator();
        comboBoxPhone.addItem("Your phone");
        while (iterator.hasNext()) {
            comboBoxPhone.addItem(iterator.next().getNumberPhone());
        }
        return listPhone;
    }

}
