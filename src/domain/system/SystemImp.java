package domain.system;

import dao.iface.UserDAO;
import dao.sql.SQLUserDAO;
import domain.iface.I_System;
import domain.model.User;

public class SystemImp implements I_System {

    private User user;
    private UserDAO userDAO;

    public SystemImp() {

    }

    public SystemImp(User user) {
        this.user = user;
    }

    @Override
    public void registrationUser() {
        userDAO = new SQLUserDAO();

        userDAO.createUser(user);
    }

    @Override
    public void authorization(User user) {
        userDAO = new SQLUserDAO();

        this.user = userDAO.readUser(user);
        System.out.println(this.user);
    }
}
