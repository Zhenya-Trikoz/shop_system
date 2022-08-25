package domain.model;

public class ListCurrency {
    private String currency;

    public ListCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "ListCurrency{" +
                "currency='" + currency + '\'' +
                '}';
    }
}
