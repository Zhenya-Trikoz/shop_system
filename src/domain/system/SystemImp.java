package domain.system;

import dao.iface.CardDAO;
import dao.iface.CurrencyDAO;
import dao.iface.PhoneDAO;
import dao.iface.UserDAO;
import dao.sql.SQLCardDAO;
import dao.sql.SQLCurrencyDAO;
import dao.sql.SQLUserDAO;
import domain.iface.I_System;
import domain.model.Card;
import domain.model.Currency;
import domain.model.ListCurrency;
import domain.model.User;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class SystemImp implements I_System {

    private User user;
    private Card card;
    private UserDAO userDAO;
    private CardDAO cardDAO;
    private PhoneDAO phoneDAO;
    private CurrencyDAO currencyDAO;

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

    @Override
    public ArrayList<ListCurrency> returnListCurrency() {
        currencyDAO = new SQLCurrencyDAO();

        return currencyDAO.readListCurrency();
    }

    @Override
    public BigDecimal priceCurrency(String sellCurrency, String buyCurrency) {
        currencyDAO = new SQLCurrencyDAO();

        return currencyDAO.priceCurrency(sellCurrency, buyCurrency);
    }

    @Override
    public void replenishmentCardUser(String numberCard, BigDecimal money) {
        cardDAO = new SQLCardDAO();
        cardDAO.updateCard(numberCard, money);
    }
}
