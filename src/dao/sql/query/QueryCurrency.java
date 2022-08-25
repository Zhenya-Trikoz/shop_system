package dao.sql.query;

public class QueryCurrency {
    public static String readListCurrency() {
        return "select * from list_currency";
    }
    public  static  String readPrice(){
        return "select * from buy_currency where currency in (?) and buy_currency in (?);";
    }
}
