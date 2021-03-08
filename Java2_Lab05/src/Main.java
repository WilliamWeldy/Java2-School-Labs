/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 * Lab #5
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


public class Main {
    public static void main(String[] args) {
        int myArr[] = {16, 31, 90, 45, 89};
        WriteInts wi = new WriteInts("src/mydata.dat", myArr); /* This class will write the array
                                                                               of integers to "mydata.dat". */

        ReadInts fw = new ReadInts("src/mydata.dat", myArr); /* This class reads the integers from
                                                                             "mydata.dat", and prints to console.*/

        WriteString ws = new WriteString("src/f1.txt", "Hello world");
        /* This class writes the text "Hello World" to "f1.txt" by using a PrintStream Obj
           connected to a FileOutputStream Obj   */
    }
}
