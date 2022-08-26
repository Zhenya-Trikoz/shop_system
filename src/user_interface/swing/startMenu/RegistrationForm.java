package user_interface.swing.startMenu;

import domain.iface.I_System;
import domain.model.User;
import domain.system.SystemImp;
import user_interface.swing.userMain.CreateCardForm;
import user_interface.swing.userMain.CreatePhoneForm;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class RegistrationForm extends JDialog {
    private JPanel panelRegistration;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldAge;
    private JTextField textFieldEmail;
    private JTextField textFieldLogin;
    private JPasswordField passwordField;
    private JPasswordField passwordConfigField;
    private JButton authorizationButton;
    private JButton registrationButton;
    private JButton exitButton;

    public RegistrationForm() {
        setUndecorated(true);
        setContentPane(panelRegistration);
        setMinimumSize(new Dimension(480, 300));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        exitButton.addActionListener(e -> dispose());
        authorizationButton.addActionListener(e -> {
            dispose();
            new AuthorizationForm();
        });
        registrationButton.addActionListener(e -> {
            registration();
            dispose();
            new AuthorizationForm();
        });
        setVisible(true);
    }

    private void registration() {
        if (!textFieldFirstName.getText().isEmpty() &&
                !textFieldLastName.getText().isEmpty() &&
                !textFieldAge.getText().isEmpty() &&
                !textFieldEmail.getText().isEmpty() &&
                !textFieldLogin.getText().isEmpty() &&
                passwordField.getPassword().length != 0 &&
                passwordConfigField.getPassword().length != 0
        ) {
            if (Arrays.equals(passwordField.getPassword(), passwordConfigField.getPassword())) {
                if (passwordField.getPassword().length >= 6) {
                    User user = new User(textFieldFirstName.getText(),
                            textFieldLastName.getText(),
                            Integer.parseInt(textFieldAge.getText()),
                            textFieldEmail.getText(),
                            textFieldLogin.getText().toCharArray(),
                            passwordField.getPassword());
                    System.out.println(user);

                    I_System i_system = new SystemImp(user);
                    i_system.registrationUser();
                    dispose();
                    new CreateCardForm(user);
                    dispose();
                    new CreatePhoneForm(user);
                }
            }

        }

    }
}
