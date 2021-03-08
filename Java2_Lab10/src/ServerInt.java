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


public class ServerInt {
    public static void main(String[] args) {
        new ServerInt();
    }

    ServerInt() {
        try {
            ServerSocket ss = new ServerSocket(7777); //attaching server socket to port:7777
            Socket s1 = ss.accept(); //Socket "s1" starts accepting incoming requests to port:7777
            DataInputStream din = new DataInputStream(s1.getInputStream());

            int[] x = new int[5];
            System.out.print("Client Integers = ");
            for (int i = 0; i < x.length-1; i++) { System.out.print(din.readInt() + ", "); }
            System.out.print(din.readInt()); //the final number's read and printed without adding a comma afterwards
        } catch (Exception e) { System.out.println("Error in ServerInt!"); }
    }
}
