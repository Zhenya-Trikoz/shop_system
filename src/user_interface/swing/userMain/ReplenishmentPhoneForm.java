package user_interface.swing.userMain;

import domain.iface.I_System;
import domain.model.Card;
import domain.model.Phone;
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

public class ReplenishmentPhoneForm extends JDialog {

    private JPanel panelReplenishmentPhone;
    private JComboBox comboBoxPhone;
    private JTextField textFieldBalancePhone;
    private JTextField textFieldCurrencyPhone;
    private JComboBox comboBoxUserCard;
    private JTextField textFieldBalanceCard;
    private JTextField textFieldCurrencyCard;
    private JButton exitButton;
    private JButton buttonReplenishmentPhone;
    private JTextField textFieldSumReplenishment;

    public ReplenishmentPhoneForm(User user) {
        setUndecorated(true);
        setContentPane(panelReplenishmentPhone);
        setMinimumSize(new Dimension(550, 300));
        setModal(true);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ArrayList<Phone> phones = SwitchBox.setListPhone(user, comboBoxPhone);
        comboBoxPhone.addActionListener(e -> {
            if (comboBoxPhone.getSelectedItem() != null) {
                List<Phone> phoneList = phones.stream().
                        filter((phone) -> (phone.getNumberPhone().equals(comboBoxPhone.getSelectedItem()) && !phone.getNumberPhone().
                                equals("Your Phone"))).
                        peek(System.out::println).collect(Collectors.toList());
                if (phoneList.size() != 0) {
                    textFieldBalancePhone.setText(String.valueOf(phoneList.get(0).getAmount()));
                    textFieldCurrencyPhone.setText(String.valueOf(phoneList.get(0).getCurrency()));
                } else {
                    textFieldBalancePhone.setText("");
                    textFieldCurrencyPhone.setText("");
                }
            }
        });

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

        exitButton.addActionListener(e -> {
            dispose();
            new UserMenuForm(user);
        });
        buttonReplenishmentPhone.addActionListener(e -> {
            dispose();
            replenishmentPhone(user);
        });
        setVisible(true);
    }

    public void replenishmentPhone(User user) {
        I_System i_system = new SystemImp(user);
        BigDecimal priceCurrency;
        if (!textFieldCurrencyPhone.getText().equals(textFieldCurrencyCard.getText())) {
            priceCurrency = i_system.priceCurrency(textFieldCurrencyCard.getText(), textFieldCurrencyPhone.getText());
        } else {
            priceCurrency = BigDecimal.valueOf(1);
        }
        BigDecimal reductionAmount = new BigDecimal(textFieldBalanceCard.getText()).subtract(new BigDecimal(textFieldSumReplenishment.getText()));
        BigDecimal replenishmentAmount = Generator.balanceAfterToUp(textFieldSumReplenishment.getText(), String.valueOf(priceCurrency), textFieldBalancePhone.getText());
        i_system.replenishmentPhone(comboBoxUserCard.getSelectedItem().toString(), reductionAmount, comboBoxPhone.getSelectedItem().toString(), replenishmentAmount);
        dispose();
        new UserMenuForm(user);
    }
}
