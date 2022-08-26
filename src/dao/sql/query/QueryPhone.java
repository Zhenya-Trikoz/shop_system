package dao.sql.query;

public class QueryPhone {
    public static String createPhone() {
        return "insert into phones (numberPhone, amount, currency, id_user) values (?,?,?,?);";
    }

    public static String readListPhone() {
        return "select * from phones where id_user in (?);";
    }

    public static String updateBalancePhone() {
        return "update phones set amount = (?) where numberPhone = (?);";
    }
}
