/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 * Lab #10
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.io.*;
import java.net.*;


public class ClientString {
    public static void main(String[] args) { new ClientString(); }

    ClientString() {
        try {
            Socket s1 = new Socket("localhost", 7777); //attaching the socket to port:7777
            PrintStream pout = new PrintStream(s1.getOutputStream()); //directing the print stream to the socket

            pout.println("Go Braves!!!"); //The message to send to the server
        }
        catch (Exception e) { System.out.println("Error in ClientString!"); }
    }
}
