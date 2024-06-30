import java.util.*;

public class Account {
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
        // todo: withdraw 코드중복 고치기
        Date date = new Date();
        String transactionDate = DateConverter.dateToString(date);
        String transactionTime = DateConverter.timeToString(date);
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
        String transactionDate = DateConverter.dateToString(date);
        String transactionTime = DateConverter.timeToString(date);
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

    @Override
    public String toString() {
        return "[계좌번호: " + accountNo +
                ", 소유자 명: " + name +
                ", 잔액: " + balance + "]";
    }
}
