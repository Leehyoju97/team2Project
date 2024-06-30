public enum TransactionType {   // todo: enum 네이밍 수정
    DEPOSIT("입금"),
    WITHDRAW("출금");

    // todo: 네이밍 고치기
    private String transaction;

    TransactionType(String transaction) {
        this.transaction = transaction;
    }

    public String getTransaction() {
        return transaction;
    }
}
