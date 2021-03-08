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


    //Account class methods
    public void deposit(double deposit) { setBalance(balance + deposit); }
    public void withdraw(double withdrawl) throws InsufficientFunds {
        if((balance-withdrawl) >= 0 ) setBalance(balance - withdrawl);
        else throw new InsufficientFunds(); //if the account's dollar amount is so much as 1 penny in the negative, the exception will be thrown
    }

    public void display() {
        System.out.println("Account Owner: " + owner);
        System.out.println("Account Number: " + acctNo);
        System.out.println("Account Balance: " + balance);
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
