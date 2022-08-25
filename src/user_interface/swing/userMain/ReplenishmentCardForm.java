package user_interface.swing.userMain;

import domain.iface.I_System;
import domain.model.Card;
import domain.model.ListCurrency;
import domain.model.User;
import domain.system.SystemImp;
import user_interface.switchBox.SwitchBox;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReplenishmentCardForm extends JDialog {
    private JComboBox comboBoxUserCard;
    private JTextField textFieldCurrency;
    private JTextField textFieldUserSum;
    private JComboBox comboBoxCurrency;
    private JButton buttonExit;
    private JButton buttonReplenishment;
    private JPanel panelReplenishmentCard;
    private JTextField textFieldPriceCurrency;
    private JTextField textFieldBalanceAfterTopUp;
    private JTextField textFieldBalanceCard;

    private BigDecimal money;

    public ReplenishmentCardForm(User user) {
        setUndecorated(true);
        setContentPane(panelReplenishmentCard);
        setMinimumSize(new Dimension(600, 300));

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
                money = cardList.get(0).getMoney();
                if (cardList.size() != 0) {
                    textFieldBalanceCard.setText(String.valueOf(cardList.get(0).getMoney()));
                    textFieldCurrency.setText(String.valueOf(cardList.get(0).getCurrency()));
                } else {
                    textFieldCurrency.setText("");
                }
            }
        });
        ArrayList<ListCurrency> listCurrency = SwitchBox.setListCurrency(comboBoxCurrency);
        comboBoxCurrency.addActionListener(e -> {
            if (!textFieldUserSum.getText().isEmpty()) {
                I_System i_system = new SystemImp();

                textFieldPriceCurrency.setText("");
                textFieldBalanceAfterTopUp.setText("");
                if (!Objects.equals(comboBoxCurrency.getSelectedItem(), textFieldCurrency.getText())) {
                    textFieldPriceCurrency.setText((i_system.priceCurrency((String) comboBoxCurrency.getSelectedItem(), textFieldCurrency.getText())).toString());
                } else {
                    textFieldPriceCurrency.setText("1");
                }
                textFieldBalanceAfterTopUp.setText(balanceAfterToUp(money).toString());

            }
        });
        buttonExit.addActionListener(e -> {
            dispose();
            new UserMenuForm(user);
        });
        buttonReplenishment.addActionListener(e -> {
            dispose();
            replenishment();
            new UserMenuForm(user);
        });
        setVisible(true);
    }

    public void replenishment() {
        I_System i_system = new SystemImp();
        i_system.replenishmentCardUser((String) comboBoxUserCard.getSelectedItem(), new BigDecimal(textFieldBalanceAfterTopUp.getText()));
    }

    public BigDecimal balanceAfterToUp(BigDecimal money) {
        return new BigDecimal(textFieldUserSum.getText()).multiply(new BigDecimal(textFieldPriceCurrency.getText())).add(money);
    }
}
