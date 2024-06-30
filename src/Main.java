import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("메뉴를 선택하세요");
            System.out.println("1. 계좌 생성");
            System.out.println("2. 계좌 찾기 (계좌번호)");
            System.out.println("3. 계좌 찾기 (소유자명)");
            System.out.println("4. 계좌 목록");
            System.out.println("5. 입금");
            System.out.println("6. 출금");
            System.out.println("7. 잔고 확인");
            System.out.println("8. 거래 내역");
            System.out.println("9. 총 계좌수");
            System.out.println("10. 종료");
            System.out.println("======================");
            System.out.print("번호 선택: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break; //계좌 생성
                case 2:
                    findAccountByAccountNo();
                    break;    // 계좌번호로 계좌 찾기
                case 3:
                    findAccountByName();
                    break; // 소유자명으로 계좌 찾기
                case 4:
                    ListAllAccount();
                    break;    //계좌 목록
                case 5:
                    depositAccount();
                    break;    // 입금
                case 6:
                    withdrawAccount();
                    break;   // 출금
                case 7:
                    checkAccountBalance();
                    break;  // 잔고 확인
                case 8:
                    checkTransactionList();
                    break;  // 거래내역
                case 9:
                    totalAccount();
                    break;
                case 10:
                    exit();
                    return;
            }
        }
    }

    private static void createAccount() {
        System.out.print("계좌 만들분 성함 입력: ");
        String name = sc.next();

        Bank bank = Bank.getInstance();
        bank.addAccount(Account.generateAccountNumber(), name);
        System.out.println(name + "님 계좌 생성되었습니다.");
    }

    private static Account findAccountByAccountNo() {
        System.out.print("계좌 번호를 입력해주세요: ");
        String accountNo = sc.next();

        Bank bank = Bank.getInstance();
        List<Account> accounts = bank.getAccounts();

        for (Account account : accounts) {
            if (account.getAccountNo().equals(accountNo)) {
                System.out.println("= 해당 계좌번호의 계좌정보 =");
                System.out.println(account.toString());
                return account;
            }
        }
        return null;
    }

    private static void findAccountByName() {
        System.out.print("소유자명을 입력해주세요: ");
        String name = sc.next();

        Bank bank = Bank.getInstance();
        List<Account> accounts = bank.getAccounts();

        System.out.println("= 해당 소유자명의 계좌정보 =");
        for (Account account : accounts) {
            if (account.getName().equals(name)) {
                System.out.println(account.toString());
            }
        }
    }

    private static void ListAllAccount() {
        System.out.println("= 전체 계좌 목록 =");
        Bank bank = Bank.getInstance();
        List<Account> accounts = bank.getAccounts();

        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }

    private static void depositAccount() {
        Account currentAccount = findAccountByAccountNo();

        if (currentAccount != null) {
            System.out.print("입금 금액: ");
            long amount = sc.nextLong();

            currentAccount.deposit(amount);
        } else {
            System.out.println("계좌 번호를 잘못 입력하셨습니다.");
        }
    }

    private static void withdrawAccount() {
        Account currentAccount = findAccountByAccountNo();

        if (currentAccount != null) {
            System.out.print("출금 금액: ");
            long amount = sc.nextLong();

            currentAccount.withdraw(amount);
        } else {
            System.out.println("계좌 번호를 잘못 입력하셨습니다.");
        }
    }

    private static void checkAccountBalance() {
        Account currentAccount = findAccountByAccountNo();

        if (currentAccount != null) {
            currentAccount.getBalance();
        } else {
            System.out.println("계좌 번호를 잘못 입력하셨습니다.");
        }
    }

    private static void checkTransactionList() {
        Account currentAccount = findAccountByAccountNo();

        if (currentAccount != null) {
            List<Transaction> transactions = currentAccount.getTransactions();

            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("거래 내역이 없습니다.");
        }
    }

    private static void exit() {
        System.out.println("프로그램을 종료합니다.");
    }

    private static void totalAccount() {
        Bank bank = Bank.getInstance();
        int totalAccount = bank.getTotalAccount();
        System.out.println("총 계좌수 : " + totalAccount);
    }
}