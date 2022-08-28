package user_interface.swing.userMain;

import domain.iface.I_System;
import domain.model.Card;
import domain.model.ListCurrency;
import domain.model.User;
import domain.system.Generator;
import domain.system.SystemImp;
import user_interface.switchBox.SwitchBox;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChangeCurrencyCardForm extends JDialog {
    private JPanel panelChangeCurrencyCard;
    private JComboBox comboBoxUserCard;
    private JTextField textFieldBalanceCard;
    private JTextField textFieldCurrencyCard;
    private JComboBox comboBoxCurrency;
    private JButton exitButton;
    private JButton buttonOk;

    public ChangeCurrencyCardForm(User user) {
        setUndecorated(true);
        setContentPane(panelChangeCurrencyCard);
        setMinimumSize(new Dimension(480, 300));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ArrayList<Card> cards = SwitchBox.setListCard(user, comboBoxUserCard);
        comboBoxUserCard.addActionListener(e -> {
            if (comboBoxUserCard.getSelectedItem() != null) {
                List<Card> cardList = cards.stream().
                        filter((card) -> (card.getNumberCard().equals(comboBoxUserCard.getSelectedItem()) && !card.getNumberCard().
                                equals("Your choose"))).
                        peek(System.out::println).collect(Collectors.toList());
                if (cardList.size() != 0) {
                    textFieldBalanceCard.setText(String.valueOf(cardList.get(0).getMoney()));
                    textFieldCurrencyCard.setText(String.valueOf(cardList.get(0).getCurrency()));
                } else {
                    textFieldBalanceCard.setText("");
                    textFieldCurrencyCard.setText("");
                }
            }
        });
        ArrayList<ListCurrency> listCurrency = SwitchBox.setListCurrency(comboBoxCurrency);

        exitButton.addActionListener(e -> {
            dispose();
            new UserMenuForm(user);
        });
        buttonOk.addActionListener(e -> {
            dispose();
            changeCurrencyCard();
            dispose();
            new UserMenuForm(user);
        });
        setVisible(true);
    }

    public void changeCurrencyCard() {
        I_System i_system = new SystemImp();
        i_system.changeCurrencyCard(
                (String) comboBoxUserCard.getSelectedItem(),
                Generator.balanceAfterToUp(
                        textFieldBalanceCard.getText(),
                        (i_system.priceCurrency(
                                textFieldCurrencyCard.getText(),
                                (String) comboBoxCurrency.getSelectedItem())).toString(),
                        "0"),
                (String) comboBoxCurrency.getSelectedItem());

    }
}
