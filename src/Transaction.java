public class Transaction {
    private String transactionDate;
    private String transactionTime;
    private Type type;
    private long amount;
    private long balance;

    public Transaction(String transactionDate, String transactionTime, Type type, long amount, long balance) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "[거래금액 : " + amount +
                ", 잔액 : " + balance +
                "원 /" + transactionDate +
                transactionTime + "]";
    }
}
