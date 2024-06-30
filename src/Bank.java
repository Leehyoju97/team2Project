import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int totalAccount;
    private static Bank bank;


    public Bank() {
    }

    public static Bank getInstance() {
        if (bank == null) {
            bank = new Bank();
        }
        return bank;
    }

    public void addAccount(String accountNo, String name) {
        accounts.add(new Account(accountNo, name));
    }

    public Account getAccount(String accountNo) {
        for (Account account : accounts) {
            if (account.getAccountNo().equals(accountNo)) {
                return account;
            }
        }
        System.out.println("계좌가 없습니다.");
        return null;
    }

    public List<Account> findAccounts(String name) {
        List<Account> userAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getName().equals(name))
                userAccounts.add(account);
        }
        return userAccounts;
    }

    public int getTotalAccount(int totalAccount) {
        return totalAccount;
    }

    public int getTotalAccount() {
        return totalAccount;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
