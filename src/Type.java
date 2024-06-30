public enum Type {
    DEPOSIT("입금"),
    WITHDRAW("출금");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
