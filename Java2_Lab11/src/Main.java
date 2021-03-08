/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 * Lab #11
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


public class Main {
    public static void main(String[] args) {
	    new PresidentsAA(); //calls the PresidentsAA constructor to run.

	    Account acct1 = new Account(1000, "William", 1242.00);
        Account acct2 = new Account(2000, "Nikki", 600.00);
        Account acct3 = new Account(3000, "James", 3489.00);
            System.out.println("\n****************************************\nDISPLAYING ALL ACCOUNTS\n****************************************");
            new AccVector(acct1, acct2, acct3); //calls the AccVector constructor to run, with the 3 created accounts passed into the constructor.
            System.out.println("****************************************");
    }
}
