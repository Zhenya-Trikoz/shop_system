package domain.model;

import domain.system.Encryption;
import domain.system.Generator;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Currency;
import java.util.Locale;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String login;
    private String password;

    private Card card;
    private Phone phone;

    public User(char[] login, char[] password) {
        try {
            this.login = new String(Encryption.encryptionSHA256(login));
            this.password = new String(Encryption.encryptionSHA256(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /*Registration constructor*/
    public User(String firstName, String lastName, int age, String email, char[] login, char[] password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        try {
            this.login = new String(Encryption.encryptionSHA256(login));
            this.password = new String(Encryption.encryptionSHA256(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /*Authorization constructor*/
    public User(String firstName, String lastName, int age, String email, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.login = login;
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Card getCard() {
        return card;
    }

    public void setCard() {
        this.card = new Card(
                Generator.generateNumberCard(),
                Generator.generateCardEndData(),
                Generator.generateCVC2(),
                new BigDecimal(0),
                "UAH"
        );
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
