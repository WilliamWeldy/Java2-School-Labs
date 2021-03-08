/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.io.*;

public class FileWrite {

    //The constructor
    FileWrite(String fileInQuestion, String textToWrite) {
        File f2 = new File(fileInQuestion);


        byte barr[] = textToWrite.getBytes(); //Creating a byte array for file writing

        try {
            FileOutputStream fout = new FileOutputStream(f2);
            fout.write(barr); //writing to the file with the contents in the byte array
            fout.close();
        }
        catch(IOException e) { System.out.println("ERROR: " + e); }
    }

}