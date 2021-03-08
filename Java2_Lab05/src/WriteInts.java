/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.io.*;


public class WriteInts {

    WriteInts(String fileInQuestion, int[] Array) {
        File f1 = new File(fileInQuestion);


        try {
            FileOutputStream fout = new FileOutputStream(f1);
            DataOutputStream dout = new DataOutputStream(fout);
            for (int i=0 ; i < Array.length ; i++) { dout.writeInt(Array[i]); } /*Writes each int in the array to
                                                                                  the file passed in. */
            dout.close();
        }
        catch(IOException e) { System.out.println("ERROR: " + e); }
        }
}
