package domain.system;

import domain.model.Card;

import java.math.BigDecimal;
import java.util.Calendar;

public class Generator {

    public static String generateNumberCard() {
        String bankIdentifier = String.valueOf(generateRandomize(10_000, 99_999));
        String cardID = String.valueOf(generateRandomize(1_00_000_000, 9_99_999_999));
        String checkDigit = String.valueOf(generateRandomize(0, 9));
        return Card.FIRST_NUMBER_PAYMENT_SYSTEM_MASTER_CARD + bankIdentifier + cardID + checkDigit;
    }


    public static String generateCardEndData() {
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentMonth > 9 ? "0" + currentMonth + "/" + currentYear : currentMonth + "/" + currentYear;
    }

    /**
     * Please change methods, we must get not only num from 100 to 999, for example 002 or 082 -> done
     */
    public static String generateCVC2() {
        int gNum = generateRandomize(1, 999);
        String sGNum = String.valueOf(gNum);
        return gNum > 10 ? gNum > 100 ? sGNum : "0" + sGNum : "00" + sGNum;
    }

    public static int generateRandomize(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static BigDecimal balanceAfterToUp(String sellAmount, String buyAmount, String money) {
        return new BigDecimal(sellAmount).multiply(new BigDecimal(buyAmount)).add(new BigDecimal(money));
    }

    public static String generateData() {
        Calendar calendar = Calendar.getInstance();
        int data = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        return data + ":" + month + ":" + year;
    }

}
