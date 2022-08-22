package domain.model;

import java.math.BigDecimal;

public class Card {
    public static char FIRST_NUMBER_PAYMENT_SYSTEM_MASTER_CARD = '5';

    private String numberCard;
    private String dataEndCard;
    private String CVC2;
    private BigDecimal money;
    private String currency;

    public Card(String numberCard, String dataEndCard, String CVC2, BigDecimal money, String currency) {
        this.numberCard = numberCard;
        this.dataEndCard = dataEndCard;
        this.CVC2 = CVC2;
        this.money = money;
        this.currency = currency;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public String getDataEndCard() {
        return dataEndCard;
    }

    public String getCVC2() {
        return CVC2;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Card{" +
                "numberCard='" + numberCard + '\'' +
                ", dataEndCard='" + dataEndCard + '\'' +
                ", CVC2='" + CVC2 + '\'' +
                ", money='" + money + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
