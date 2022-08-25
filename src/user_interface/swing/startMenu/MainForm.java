package user_interface.swing.startMenu;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JDialog {
    private JPanel panelMenu;
    private JButton exitButton;
    private JButton authorizationButton;
    private JButton registrationButton;

    public MainForm() {
        setUndecorated(true);
        setContentPane(panelMenu);
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
            dispose();
            new RegistrationForm();

        });
        setVisible(true);
    }


}
