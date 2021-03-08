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


public class ServerString {
    public static void main(String[] args) { new ServerString(); }

    ServerString() {
        try {
            ServerSocket ss = new ServerSocket(7777); //attaching server socket to port:7777
            Socket s1 = ss.accept(); //Socket "s1" starts accepting incoming requests to port:7777
            BufferedReader br = new BufferedReader(new InputStreamReader(s1.getInputStream()));

            String st = null; //the string is set to 'null' in case information is never received.
            st = br.readLine(); //the line is read and changes the string from null to the client's message
            System.out.println("Client String = " + st);
        }
        catch (Exception e) { System.out.println("Error in ServerString!"); }
    }
}
