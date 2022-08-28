package user_interface.swing.userMain;

import domain.model.User;
import user_interface.swing.startMenu.MainForm;

import javax.swing.*;
import java.awt.*;

public class UserMenuForm extends JDialog {

    private JPanel panelUserMenu;
    private JPanel panelButton;
    private JButton buttonCreateCard;
    private JButton buttonCreatePhone;
    private JButton exitButton;
    private JButton buttonReplenishmentPhone;
    private JButton buttonReplenishmentCard;
    private JButton buttonGoShop;
    private JButton buttonCheckMoneyCard;
    private JButton buttonCheckMoneyPhone;
    private JButton buttonChangeCurrencyCard;

    public UserMenuForm(User user) {
        setUndecorated(true);
        setContentPane(panelUserMenu);
        setMinimumSize(new Dimension(480, 300));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        exitButton.addActionListener(e -> {
            dispose();
            new MainForm();
        });

        buttonCreateCard.addActionListener(e -> {
            dispose();
            new CreateCardForm(user);
        });

        buttonReplenishmentCard.addActionListener(e -> {
            dispose();
            new ReplenishmentCardForm(user);
        });

        buttonCreatePhone.addActionListener(e -> {
            dispose();
            new CreatePhoneForm(user);
        });
        buttonReplenishmentPhone.addActionListener(e -> {
            dispose();
            new ReplenishmentPhoneForm(user);

        });
        buttonCheckMoneyCard.addActionListener(e -> {
            dispose();
            new CheckMoneyCardForm(user);
        });

        buttonCheckMoneyPhone.addActionListener(e -> {
            dispose();
            new CheckMoneyPhoneForm(user);
        });
        buttonChangeCurrencyCard.addActionListener(e -> {
            dispose();
            new ChangeCurrencyCardForm(user);
        });

        setVisible(true);

    }
}
