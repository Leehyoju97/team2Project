import java.util.*;

public class Account {
    private static Set<String> existingAccounts = new HashSet<>();

    private String accountNo;
    private String name;
    private long balance;
    private List<Transaction> transactions;

    public Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(long amount) {
        Date date = new Date();
        String transactionDate = DateExample.dateToString(date);
        String transactionTime = DateExample.timeToString(date);
        balance += amount;
        System.out.println(amount + "원 입금하셨습니다.");
        System.out.println("현재 잔액은 " + balance + "원 입니다.");
        Transaction transaction = new Transaction(transactionDate, transactionTime, TransactionType.DEPOSIT.getTransaction(), amount, balance);
        transactions.add(transaction);
    }

    public void withdraw(long amount) {
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        Date date = new Date();
        String transactionDate = DateExample.dateToString(date);
        String transactionTime = DateExample.timeToString(date);
        balance -= amount;
        System.out.println(amount + "원 출금하셨습니다.");
        System.out.println("현재 잔액은 " + balance + "원 입니다.");
        Transaction transaction = new Transaction(transactionDate, transactionTime, TransactionType.WITHDRAW.getTransaction(), amount, balance);
        transactions.add(transaction);
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public static String generateAccountNumber() {
        Random random = new Random();
        String accountNo;
        do {
            accountNo = generateRandomNumber(random);
        } while (existingAccounts.contains(accountNo));

        existingAccounts.add(accountNo);
        return accountNo;
    }

    private static String generateRandomNumber(Random random) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "[계좌번호: " + accountNo +
                ", 소유자 명: " + name +
                ", 잔액: " + balance + "]";
    }
}
