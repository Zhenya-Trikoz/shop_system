package domain.model;

import java.math.BigDecimal;

public class Phone {
    private String numberPhone;
    private BigDecimal amount;
    private String currency;

    public Phone(String numberPhone, BigDecimal amount, String currency) {
        this.numberPhone = numberPhone;
        this.amount = amount;
        this.currency = currency;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "numberPhone='" + numberPhone + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
