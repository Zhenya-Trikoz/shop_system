package dao.iface;

import domain.model.Phone;
import domain.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface PhoneDAO {
    void createPhone(User user, String numberPhone,String currency);

    ArrayList<Phone> returnListPhone(User user);

    void updateBalancePhone(String numberPhone, BigDecimal amount);
}
