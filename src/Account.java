import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class Account {
    private String accountNo;
    private String name;
    private long balance;
    private List<Transaction> transactions;

    static final String DEPOSIT = "입금";
    static final String WITHDRAW = "출금";

    public Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }


    public void deposit(long amount) {
        Date date = new Date();
        String transactionDate = DateExample.dateToString(date);
        String transactionTime = DateExample.dateToString(date);
        balance += amount;
        System.out.println(amount + "원 입금하셨습니다.");
        Transaction transaction = new Transaction(transactionDate, transactionTime, Account.DEPOSIT, amount, balance);
        transactions.add(transaction);
    }

    public void withdraw(long amount) {
        if(amount > balance) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        Date date = new Date();
        String transactionDate = DateExample.dateToString(date);
        String transactionTime = DateExample.dateToString(date);
        balance -= amount;
        System.out.println(amount + "원 출금하셨습니다.");
        Transaction transaction = new Transaction(transactionDate, transactionTime, Account.WITHDRAW, amount, balance);
        transactions.add(transaction);
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[계좌번호: " + accountNo +
                ", 소유자 명: "  + name +
                ", 잔액: " + balance + "]";
    }
}
