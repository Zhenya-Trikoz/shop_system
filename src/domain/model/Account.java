package domain.model;

import domain.system.Encryption;

import java.security.NoSuchAlgorithmException;

public class Account {
    private String login;
    private String password;

    public Account(char[] login, char[] password) {
        try {
            this.login = new String(Encryption.encryptionSHA256(login));
            this.password = new String(Encryption.encryptionSHA256(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
