package user_interface.swing.userMain;

import domain.model.User;
import user_interface.swing.AuthorizationForm;

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

    public UserMenuForm(User user) {
        setUndecorated(true);
        setContentPane(panelUserMenu);
        setMinimumSize(new Dimension(480, 300));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        exitButton.addActionListener(e -> {
            dispose();
            new AuthorizationForm();
        });

        buttonCreateCard.addActionListener(e -> {
            dispose();
            new CreateCardForm(user);
        });

        setVisible(true);

    }
}
