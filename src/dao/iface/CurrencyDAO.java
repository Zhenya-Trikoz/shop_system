package dao.iface;

import domain.model.Currency;
import domain.model.ListCurrency;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface CurrencyDAO {
    ArrayList<ListCurrency> readListCurrency();

    BigDecimal priceCurrency(String sellCurrency, String buyCurrency);
}
