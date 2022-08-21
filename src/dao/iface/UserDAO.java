package dao.iface;

import domain.model.User;

public interface UserDAO {
    void createUser(User user);

    User readUser(User user);

    User updateUser();

    void deleteUser();
}
