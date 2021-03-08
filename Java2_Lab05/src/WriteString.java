/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.io.*;


public class WriteString {

    WriteString(String fileInQuestion, String message) {
        File f1 = new File(fileInQuestion);


        try {
            FileOutputStream fout = new FileOutputStream(f1);
            PrintStream ps = new PrintStream(fout);
            ps.println(message); //Prints the message passed in from constructor arguments
            ps.close();
        }
        catch(IOException e) { System.out.println("ERROR: " + e); }
    }
}
