package user_interface.swing.userMain;

import domain.iface.I_System;
import domain.model.ListCurrency;
import domain.model.User;
import domain.system.Generator;
import domain.system.SystemImp;
import user_interface.switchBox.SwitchBox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreatePhoneForm extends JDialog {
    private JPanel panelCreatePhone;
    private JTextField textFieldNumberCard;
    private JButton exitButton;
    private JButton buttonCreatePhone;
    private JComboBox comboBoxCurrency;

    public CreatePhoneForm(User user) {
        setUndecorated(true);
        setContentPane(panelCreatePhone);
        setMinimumSize(new Dimension(480, 300));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        textFieldNumberCard.setText("+380" + Generator.generateRandomize(0, 999_999_999));
        ArrayList<ListCurrency> listCurrency = SwitchBox.setListCurrency(comboBoxCurrency);

        exitButton.addActionListener(e -> {
            dispose();
            new UserMenuForm(user);
        });
        buttonCreatePhone.addActionListener(e -> {
            dispose();
            createPhone(user);
        });

        setVisible(true);
    }

    public void createPhone(User user) {
        I_System i_system = new SystemImp();
        i_system.createPhone(user, textFieldNumberCard.getText(), (String) comboBoxCurrency.getSelectedItem());
        dispose();
        new UserMenuForm(user);
    }
}
