import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {

            System.out.println("메뉴를 선택하세요");
            System.out.println("1. 계좌 생성");
            System.out.println("2. 계좌 찾기");
            System.out.println("3. 계좌 목록 보기");
            System.out.println("4. 종료");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: getAccount(); break;
                case 3: getAccountList(); break;
                case 4: exit(); return;
            }
        }
    }

    public static void createAccount() {
        System.out.println("===========1. 계좌 생성===============");
        System.out.print("이름을 입력해주세요: ");
        String name = sc.next();

        Bank bank = Bank.getInstance();
        bank.addAccount(Account.generateAccountNumber(), name);
    }

    public static void depositDetails(Account account){
        System.out.println("입금할 금액을 입력하세요: ");
        long amount = sc.nextLong();
        account.deposit(amount);
        System.out.println("현재 잔액은 " + account.getBalance() + "원 입니다.\n");
    }

    public static void withDrawDetails(Account account){
        System.out.println("출금할 금액을 입력하세요: ");
        long amount = sc.nextLong();
        account.withdraw(amount);
        System.out.println("현재 잔액은 " + account.getBalance() + "원 입니다.\n");
    }


    public static void getAccount() {
        System.out.println("===========2. 계좌 찾기===============");
        System.out.println("1.계좌번호 2.이름");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: getAccountByAccountNo(); break;
            case 2: getAccountsByName(); break;
        }
    }

    public static void getAccountByAccountNo() {
        Bank bank = Bank.getInstance();
        System.out.print("계좌번호를 입력하세요: ");
        String accountNo = sc.next();
        Account account = bank.getAccount(accountNo);

        System.out.println(account.toString());
        System.out.println();

        System.out.println("1.입금 2.출금");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: depositDetails(account); break;
            case 2: withDrawDetails(account); break;
        }
    }

    public static void getAccountsByName(){
        Bank bank = Bank.getInstance();
        System.out.println("이름을 입력하세요: ");
        String name = sc.next();
        List<Account> accounts = bank.findAccounts(name);

        for (Account account : accounts) {
            System.out.println(account.toString());
        }
        System.out.println();
    }

    public static void getAccountList() {
        System.out.println("===========3. 전체 계좌 목록===============");
        Bank bank = Bank.getInstance();
        List<Account> accounts = bank.getAccounts();

        for(Account account : accounts) {
            System.out.println(account.toString());
        }
    }

    public static void exit() {
        System.out.println("종료합니다.");
    }
}