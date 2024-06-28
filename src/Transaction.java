public class Transaction {
    private String transactionDate;
    private String transactionTime;
    private String kind;
    private long amount;
    private long balance;

    public Transaction(
            String transactionDate,
            String transactionTime,
            String kind,
            long amount,
            long balance
    ){
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.kind = kind;
        this.amount = amount;
        this.balance = balance;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }
    public void setTransactionDate() {
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getKind() {
        return kind;
    }

    public void setKind() {
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public long getAmount() {
        return amount;
    }

    public long setAmount(){
        return amount;
    }

    public long getBalance() {
        return balance;
    }

    public long setBalance() {
        return balance;
    }

    @Override
    public String toString() {


        return "[거래금액 : " + amount +
                ", 잔액 : " + balance +
                "원 /" + transactionDate +
                transactionTime + '\'' + "]";
    }
}
