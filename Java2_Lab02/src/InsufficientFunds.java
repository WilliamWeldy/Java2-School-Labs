/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


public class InsufficientFunds extends Exception {
    private String msg = "ERROR: INSUFFICIENT FUNDS FOR TRANSACTION!";

    public void display() {
        System.out.println(msg);
    }
}
