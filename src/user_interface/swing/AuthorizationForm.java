package user_interface.swing;

import domain.iface.I_System;
import domain.model.User;
import domain.system.SystemImp;

import javax.swing.*;
import java.awt.*;

public class AuthorizationForm extends JDialog {

    private JTextField textFieldAuthorization;
    private JPasswordField passwordField;
    private JButton exitButton;
    private JButton authorizationButton;
    private JButton registrationButton;
    private JPanel panelAuthorization;

    public AuthorizationForm() {
        setUndecorated(true);
        setContentPane(panelAuthorization);
        setMinimumSize(new Dimension(480, 300));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        exitButton.addActionListener(e -> dispose());

        registrationButton.addActionListener(e -> {
            dispose();
            new RegistrationForm();
        });
        authorizationButton.addActionListener(e -> {
            dispose();
            authorization();
        });
        setVisible(true);
    }

    public void authorization() {
        if (!textFieldAuthorization.getText().isEmpty() &&
                passwordField.getPassword().length != 0 &&
                passwordField.getPassword().length >= 6) {
            User user = new User(textFieldAuthorization.getText().toCharArray(), passwordField.getPassword());
            I_System i_system = new SystemImp();
            i_system.authorization(user);
        }
    }
}
