public enum TransactionType {
    DEPOSIT("입금"),
    WITHDRAW("출금");

    private String transaction;

    TransactionType(String transaction) {
        this.transaction = transaction;
    }

    public String getTransaction() {
        return transaction;
    }
}
