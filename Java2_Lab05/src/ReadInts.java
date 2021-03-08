/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.io.*;


public class ReadInts {

    ReadInts(String fileInQuestion, int[] Array) {
        File f1 = new File(fileInQuestion);

        try {
            FileInputStream fin = new FileInputStream(f1);
            DataInputStream din = new DataInputStream(fin);
            if (Array.length!=1) { //If the array is more than 1 int, it'll list them all one by one
                System.out.print("File contents in " + fileInQuestion + ": ");
                for (int i = 0; i < Array.length-1; i++) { System.out.print(din.readInt() + ", "); }
                System.out.print(din.readInt()); //the last number is read without adding a comma afterwards.
            }
            else System.out.println("File content in " + fileInQuestion + ": " + din.readInt());
            din.close();
        }
        catch(IOException e) { System.out.println("ERROR: " + e); }
    }
}
