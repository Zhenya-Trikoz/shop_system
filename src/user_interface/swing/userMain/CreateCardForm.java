package user_interface.swing.userMain;

import domain.iface.I_System;
import domain.model.User;
import domain.system.SystemImp;

import javax.swing.*;
import java.awt.*;

public class CreateCardForm extends JDialog {
    private JPanel panelCreateCard;
    private JTextField textFieldNumberCard;
    private JTextField textFieldDataEndCard;
    private JTextField textFieldCVC2;
    private JButton buttonOk;
    private User user;

    public CreateCardForm(User user) {
        this.user = user;
        this.user.setCard();
        setUndecorated(true);
        setContentPane(panelCreateCard);
        setMinimumSize(new Dimension(480, 300));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        textFieldNumberCard.setText(this.user.getCard().getNumberCard());
        textFieldDataEndCard.setText(this.user.getCard().getDataEndCard());
        textFieldCVC2.setText(this.user.getCard().getCVC2());
        buttonOk.addActionListener(e -> {
            createCard();
            dispose();
            new UserMenuForm(this.user);

        });
        setVisible(true);

    }

    public void createCard() {
        I_System i_system = new SystemImp(user);
        i_system.createCard();
    }
}
