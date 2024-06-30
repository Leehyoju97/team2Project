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
        balance += amount;
        printBalance(Type.DEPOSIT, amount);
        addTransaction(Type.DEPOSIT, amount);
    }

    public void withdraw(long amount) {
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        balance -= amount;
        printBalance(Type.WITHDRAW, amount);
        addTransaction(Type.WITHDRAW, amount);
    }

    private void printBalance(Type type, long amount) {
        System.out.println(amount + "원 " + type.getName() + "하셨습니다.");
        System.out.println("현재 잔액은 " + balance + "원 입니다.");
    }

    private void addTransaction(Type type, long amount) {
        Date date = new Date();
        String transactionDate = DateConverter.dateToString(date);
        String transactionTime = DateConverter.timeToString(date);

        Transaction transaction = new Transaction(transactionDate, transactionTime, type, amount, balance);
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
