package user_interface.swing.userMain;

import domain.model.Card;
import domain.model.User;
import user_interface.switchBox.SwitchBox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckMoneyCardForm extends JDialog {
    private JComboBox comboBoxUserCard;
    private JTextField textFieldBalance;
    private JTextField textFieldCurrency;
    private JButton buttonOk;
    private JPanel panelCheckMoneyCard;

    public CheckMoneyCardForm(User user) {
        setUndecorated(true);
        setContentPane(panelCheckMoneyCard);
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
                    textFieldBalance.setText(String.valueOf(cardList.get(0).getMoney()));
                    textFieldCurrency.setText(String.valueOf(cardList.get(0).getCurrency()));
                } else {
                    textFieldBalance.setText("");
                    textFieldCurrency.setText("");
                }
            }
        });
        buttonOk.addActionListener(e -> {
            dispose();
            new UserMenuForm(user);
        });
        setVisible(true);

    }
}
