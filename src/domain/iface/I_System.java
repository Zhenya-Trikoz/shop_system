package domain.iface;

import domain.model.User;

public interface I_System {
    void registrationUser();

    void authorization(User user);
}
