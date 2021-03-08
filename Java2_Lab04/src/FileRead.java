/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.io.*;

public class FileRead {

    //The constructor
    FileRead(String fileInQuestion) {
        File f3 = new File(fileInQuestion);


        byte barr[] = new byte[(int)f3.length()]; //Creating a byte array for file reading

        try {
            FileInputStream fin = new FileInputStream(f3);
            fin.read(barr); //Reading from the file
            fin.close();
        }
        catch(IOException e) { System.out.println("ERROR: " + e); }

        String s1 = new String(barr); //Creates a string from the byte array
        System.out.println("    DATA FROM FILE = " + s1);
    }

}
