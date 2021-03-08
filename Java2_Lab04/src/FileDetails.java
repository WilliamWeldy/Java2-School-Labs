/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.io.*;

public class FileDetails {

    //The constructor
    FileDetails(String fileInQuestion) {
        File f1 = new File(fileInQuestion);


        //Declaring properties INSIDE the constructor
            boolean exists = f1.exists();
            long size = f1.length();
            boolean readable = f1.canRead();
            boolean writable = f1.canWrite();
            boolean directory = f1.isDirectory();
            boolean file = f1.isFile();


        if(exists==true) { //Before anything else, we need to check if the file exists
            if(file) { /* If it's a file, the character size is measured */
                System.out.println(fileInQuestion + " is a file.");
                    if (size != 1) { System.out.println(fileInQuestion + " is " + size + " characters long."); }
                    else { System.out.println(fileInQuestion + " has only 1 character."); }
            }
            else if(directory) { System.out.println(fileInQuestion + " is a directory."); }

            //Whether it's a file or directory, it needs to be checked if you can READ or WRITE to it
            if(readable) { System.out.println(fileInQuestion + " is readable."); }
                else { System.out.println(fileInQuestion + " is unreadable.");}
            if(writable) { System.out.println(fileInQuestion + " is writable."); }
                else { System.out.println(fileInQuestion + " is unwritable.");}
        }
        else System.out.println(fileInQuestion + " does not exist!"); //Prints if it can't detect the file being passed.
    }

}
