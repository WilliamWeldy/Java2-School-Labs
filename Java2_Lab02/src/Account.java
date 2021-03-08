/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


public class Account {
    //properties
    private int acctNo;
    private String owner;
    private double balance;

    //Constructors
    Account() {
        acctNo = 0;
        owner = "";
        balance = 0f;
    }
    Account(int accountNumber, String accountOwner, double accountBalance) {
        balance = accountBalance;
        owner = accountOwner;
        acctNo = accountNumber;
    }

    public static void main(String[] args) {
        Account a1;
        //a1 = new Account(2222, "Frank", 1000);
        a1 = new Account(2222,"Frank",500.00);
        a1.deposit(100.00);
            a1.withdraw(900.00); //Frank overdrew by $300 and is now ($300) negative in his bank account.
        a1.display();
    }

    //Account class methods
    public void deposit(double deposit) { setBalance(balance + deposit); }
    public void withdraw(double withdrawl) { setBalance(balance - withdrawl); }

    public void display() {
        System.out.println("Account Number: " + acctNo);
        System.out.println("Account Balance: " + balance);
        System.out.println("Account Owner: " + owner);
    }

    //Accessors (Get Methods)
    public int getAcctNo() { return acctNo; }
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }

    //Mutators (Set Methods)
    public void setAcctNo(int acctNo) { this.acctNo = acctNo; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setBalance(double balance) { this.balance = balance; }
}
