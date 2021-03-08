/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.util.ArrayList;
import java.util.Scanner;


public class PresidentsAA {
    Scanner input = new Scanner(System.in);

    PresidentsAA() {
        ArrayList<String> president = new ArrayList<>(); //An ArrayList of U.S Presidents, index 0 and 1 are the same to avoid confusion
            president.add("George Washington"); //choice #0
            president.add("George Washington"); //choice #1
            president.add("John Adams");        //choice #2, etc..
            president.add("Thomas Jefferson");
            president.add("James Madison");
            president.add("James Monroe");
            president.add("John Quincy Adams");
            president.add("Andrew Jackson");
            president.add("Martin Van Buren");
            president.add("William Henry Harrison");
            president.add("John Tyler");

        System.out.print("Enter a number to find out who was the president of the United States.\n(NOTE: 0 and 1 are same input, this input, -1, exits the program)\nEnter Here: ");
        try {
            int presInt = Integer.parseInt(input.nextLine()); //This is the number the user entered

                 if(presInt == 0) {System.out.println("President #1 is president George Washington. (your input: 0)"); }
            else if(presInt == -1) { System.exit(0); } //-1 exits the code.
            else if(presInt < -1) { //this flips the input from a negative value to a positive one and executes the same default code.
                presInt *= -1;
                System.out.println("President #" + presInt + " is president " + president.get(presInt) + ".");
            }
            else { System.out.println("President #" + presInt + " is president " + president.get(presInt) + "."); } //The default code.
        }
        catch (Exception e) { //This will show the user the error and prompt them to try again
            System.out.println("*Exception:  " + e);
            System.out.println("INVALID VALUE DETECTED. Please try again, and enter a valid number....");
                new PresidentsAA(); //recalls the function to try again
        }
    }
}
