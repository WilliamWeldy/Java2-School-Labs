/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


public class Main {
    public static void main(String[] args) {
        FileDetails fd = new FileDetails("src/anyfile.doc"); /*This class will report back the file size,
                                                                            whether the file's readable or writeable,
                                                                            and if it's a file or directory. */

        FileWrite fw = new FileWrite("src/myfile.txt", "Go Braves"); /*This creates "myfile.txt"
                                                                                               and writes "Go Braves".*/

        FileRead fr = new FileRead("src/myfile.txt"); /* This class reads the text from "myfile.txt"
                                                                      and prints the data to the Console. */
    }
}
