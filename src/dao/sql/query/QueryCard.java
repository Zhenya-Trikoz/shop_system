package dao.sql.query;

public class QueryCard {
    public static String createCard() {
        return "insert into cards (numberCard, dataEndCard, CVC2, currency, id_user) values (?,?,?,?,?)";
    }

    public static String readListCard() {
        return "select * from cards where id_user in (?);";
    }

    public static String updateCard() {
        return "update cards set money = (?) where numberCard = (?);";
    }
}
