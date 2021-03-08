/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 * Lab #7
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.sql.*;


public class DBTester {
    public static void main(String[] args) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Loading the Ucanaccess driver
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/DefaultTheMighty/IdeaProjects/Java2_Lab07/src/RegistrationDB.mdb"); //connecting driver to the DB
            Statement st = c.createStatement(); //Creating a statement object

            String sql = "SELECT * FROM Instructors"; //The SQL statement
            //System.out.println(sql);

            ResultSet rs = st.executeQuery(sql); //Executing the SQL statement

            while (rs.next()) { //All the DB information is retrieved & printed
                System.out.println("___________________"); //Used for cleaner formatting
                System.out.println("Instructor ID: " + rs.getString(1));
                System.out.println("First Name: " + rs.getString(2));
                System.out.println("Last Name: " + rs.getString(3));
                System.out.println("Street: " + rs.getString(4));
                System.out.println("City: " + rs.getString(5));
                System.out.println("State: " + rs.getString(6));
                System.out.println("Zip: " + rs.getString(7));
                System.out.println("Office: " + rs.getString(8));
                System.out.println("E-Mail: " + rs.getString(9));
            }
            System.out.println("___________________"); //Last bar for formatting
            c.close(); //Database connection closed

        } catch(Exception e) { System.out.println(e); } //If caught, an exception statement is printed
    }
}
