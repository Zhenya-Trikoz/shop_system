package user_interface.swing.userMain;

import domain.model.Phone;
import domain.model.User;
import user_interface.switchBox.SwitchBox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckMoneyPhoneForm extends JDialog {
    private JPanel panelCheckMoneyPhone;
    private JComboBox comboBoxPhone;
    private JTextField textFieldBalance;
    private JTextField textFieldCurrency;
    private JButton buttonOk;

    public CheckMoneyPhoneForm(User user) {
        setUndecorated(true);
        setContentPane(panelCheckMoneyPhone);
        setMinimumSize(new Dimension(480, 300));
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
                    textFieldBalance.setText(String.valueOf(phoneList.get(0).getAmount()));
                    textFieldCurrency.setText(String.valueOf(phoneList.get(0).getCurrency()));
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
