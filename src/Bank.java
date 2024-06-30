import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int totalAccount;
    private static Bank bank;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public static Bank getInstance() {
        if (bank == null) {
            bank = new Bank();
        }
        return bank;
    }

    public void addAccount(String accountNo, String name) {
        accounts.add(new Account(accountNo, name));
        totalAccount++;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public int getTotalAccount() {
        return totalAccount;
    }
}
