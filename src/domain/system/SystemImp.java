package domain.system;

import dao.iface.CardDAO;
import dao.iface.PhoneDAO;
import dao.iface.UserDAO;
import dao.sql.SQLCardDAO;
import dao.sql.SQLUserDAO;
import domain.iface.I_System;
import domain.model.Card;
import domain.model.User;

import javax.swing.*;
import java.util.ArrayList;

public class SystemImp implements I_System {

    private User user;
    private Card card;
    private UserDAO userDAO;
    private CardDAO cardDAO;
    private PhoneDAO phoneDAO;

    public SystemImp() {

    }

    public SystemImp(User user) {
        this.user = user;
    }

    @Override
    public void registrationUser() {
        userDAO = new SQLUserDAO();

        userDAO.createUser(user);
    }

    @Override
    public User authorization(User user) {
        userDAO = new SQLUserDAO();

        this.user = userDAO.readUser(user);
        if (this.user != null) {
            System.out.println("User successful authorization!");
            return this.user;
        } else {
            JOptionPane.showMessageDialog(null,
                    "User not defined!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void createCard() {
        cardDAO = new SQLCardDAO();

        cardDAO.createCard(user);

    }

    @Override
    public ArrayList<Card> returnListCardsUser() {
        cardDAO = new SQLCardDAO();

        return cardDAO.readListCard(user);
    }
}
