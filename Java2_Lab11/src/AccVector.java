/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.util.Enumeration;
import java.util.Vector;


public class AccVector {
    AccVector(Account a1, Account a2, Account a3) {
        Vector<Account> v = new Vector<>(); //The 3 accounts created in main are added to AccVector "v"
            v.add(a1);
            v.add(a2);
            v.add(a3);

        Enumeration e = v.elements(); //All the accounts are enumerated in order to be printed out
         Account a;
        while(e.hasMoreElements()) { //Each enumeration of the 3 accounts are cycled through until there's no more left to display
            a = (Account)e.nextElement(); //Account obj "a" goes to the next element While there's more elements in "e"
            a.display();
            System.out.println(); //added for extra spacing in the output
        }
    }
}
