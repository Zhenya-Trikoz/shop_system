package domain.model;

import java.math.BigDecimal;

public class Currency {
    private String currency;
    private BigDecimal sell_currency;
    private String currency_we_buy;

    public Currency(String currency, BigDecimal sell_currency, String currency_we_buy) {
        this.currency = currency;
        this.sell_currency = sell_currency;
        this.currency_we_buy = currency_we_buy;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getSell_currency() {
        return sell_currency;
    }

    public void setSell_currency(BigDecimal sell_currency) {
        this.sell_currency = sell_currency;
    }

    public String getCurrency_we_buy() {
        return currency_we_buy;
    }

    public void setCurrency_we_buy(String currency_we_buy) {
        this.currency_we_buy = currency_we_buy;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currency='" + currency + '\'' +
                ", sell_currency=" + sell_currency +
                ", currency_we_buy=" + currency_we_buy +
                '}';
    }
}
