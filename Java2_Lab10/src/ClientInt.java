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
import java.util.Random;


public class ClientInt {
    public static void main(String[] args) { new ClientInt(); }

    ClientInt() {
        int[] Array = new int[5];
        Random r = new Random();

        for (int i = 0; i < Array.length-1; i++) { Array[i] = r.nextInt(255); } //Randomly assigns integer numbers to each element except for the final number
        try {
            Socket s1 = new Socket("localhost", 7777); //attaching server socket to port 7777
            DataOutputStream dout = new DataOutputStream (s1.getOutputStream()); //directing the output stream to the socket

            for (int i = 0; i < Array.length; i++) { dout.writeInt(Array[i]); } //The integers are sent to the data output stream
        }
        catch (Exception e) { System.out.println("Error in ClientInt!"); }
    }
}
