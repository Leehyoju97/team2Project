import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AccountNoGenerator {
    private static Set<String> accountNumbers = new HashSet<>();
    private static final int DIGITS = 12;

    public static String generate() {
        String accountNo;
        do {
            accountNo = generateRandomNumber();
        } while (accountNumbers.contains(accountNo));

        accountNumbers.add(accountNo);
        return accountNo;
    }

    private static String generateRandomNumber() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < DIGITS; i++) {
            int digit = new Random().nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }
}
