/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.sql.*;


public class Student {
    private int sid;
    private String fname, lname;
    private String street, city, state;
    private int zip;
    private String email;
    private double gpa;
    private String sql; //The SQL statement used in the SQL methods (SELECT, INSERT, DELETE, and UPDATE)


    //Constructors
    Student() { //empty Constructor
        sid = 0;
        fname = " - ";
        lname = " - ";
        street = " - ";
        city = " - ";
        state = " - ";
        zip = 00000;
        email = " - ";
        gpa = 0.0;
    }
    Student(int studentID, String firstName, String lastName, String studentStreet, String studentCity, String studentState, int zipCode, String EmailAddress, double studentGPA) { //properties Constructor
        sid = studentID;
        fname = firstName;
        lname = lastName;
        street = studentStreet;
        city = studentCity;
        state = studentState;
        zip = zipCode;
        email = EmailAddress;
        gpa = studentGPA;
    }


    //Methods
    public void display() {
        //Print stuff out to display
        System.out.println("Student ID: " + sid);
        System.out.println("First Name: " + fname);
        System.out.println("Last Name: " + lname);
        System.out.println("Street: " + street);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip Code: " + zip);
        System.out.println("E-Mail: " + email);
        System.out.println("GPA: " + gpa);
    } public void display(int sid) { //Used to populate values before displaying without having to call selectDB()
        selectDB(sid);
        display();
    }

    public void selectDB(int sid) { sql = "SELECT * FROM Students WHERE ID = " + sid;
        try {

            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/DefaultTheMighty/IdeaProjects/Java2_Lab09/src/RegistrationDB.mdb"); //connecting driver to the DB
            Statement st = connection.createStatement(); //Creating statement object

            ResultSet rs = st.executeQuery(sql); //Executing the SQL statement

            while (rs.next()) { //All the DB information is retrieved & set to the appropriate values
                setSid(Integer.valueOf(rs.getString(1)));
                setFname(rs.getString(2));
                setLname(rs.getString(3));
                setStreet(rs.getString(4));
                setCity(rs.getString(5));
                setState(rs.getString(6));
                setZip(Integer.valueOf(rs.getString(7)));
                setEmail(rs.getString(8));
                setGPA(Double.valueOf(rs.getString(9)));
            }
            System.out.println("*SELECTion complete");
            connection.close(); //Database connection closed
        } catch (Exception e) { System.out.println(e); } //If caught, an exception statement is printed
    }

    public void insertDB(int sid, String firstName, String lastName, String studentStreet, String studentCity, String studentState, int zipCode, String EmailAddress, double studentGPA) {
        sql = "INSERT INTO Students " +
                "VALUES (" + sid + ", '" + firstName + "', '" + lastName + "', '" + studentStreet + "', '" + studentCity + "', '" + studentState + "', " + zipCode + ", '" + EmailAddress + "', " + studentGPA + ")";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Loading the Ucanaccess driver
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/DefaultTheMighty/IdeaProjects/Java2_Lab09/src/RegistrationDB.mdb"); //connecting driver to the DB
            Statement st = connection.createStatement(); //Creating a statement object

            st.executeUpdate(sql); //Execute the SQL Statement

            System.out.println("*INSERTion complete");
            connection.close(); //Database connection closed
        } catch (Exception e) { System.out.println(e); } //If caught, an exception statement is printed
    }

    public void deleteDB() { sql = "DELETE FROM Students WHERE ID = " + getSid();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Loading the Ucanaccess driver
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/DefaultTheMighty/IdeaProjects/Java2_Lab09/src/RegistrationDB.mdb"); //connecting driver to the DB
            Statement st = connection.createStatement(); //Creating statement object

            st.executeUpdate(sql); //Execute the SQL statement

            System.out.println("*DELETion complete");
            connection.close(); //Database connection closed
        } catch (Exception e) { System.out.println(e); } //If caught, an exception statement is printed
    }

    public void updateDB() {
        sql = "UPDATE Students SET FirstName = '" + getFname() + "', LastName = '" + getLname() + "', Street = '" + getStreet() + "', City = '" + getCity() + "', State = '" + getState() + "', Zip = " + getZip() + ", EMail = '" + getEmail() + "', GPA = " + getGPA() + " WHERE ID = " + getSid();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Loading the Ucanaccess driver
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/DefaultTheMighty/IdeaProjects/Java2_Lab09/src/RegistrationDB.mdb"); //connecting driver to the DB
            Statement st = connection.createStatement(); //Creating a statement object

            st.executeUpdate(sql); //Execute the SQL statement

            System.out.println("*UPDATE complete");
            connection.close(); //Database connection closed
        } catch (Exception e) { System.out.println(e); } //If caught, an exception statement is printed
    }


    //Accessors(getters) & Mutators(setters)
    public int getSid() { return sid; }
    public void setSid(int sid) {
        if(sid==0) {
            System.out.println("Student ID is 0!");
            this.sid = sid;
        } else {
            this.sid = sid;
        }}

    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }
    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public int getZip() { return zip; }
    public void setZip(int zip) {this.zip = zip; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getGPA() { return gpa; }
    public void setGPA(double gpa) {
        if(gpa==0.0) {
            System.out.println("GPA is 0.0!");
            this.gpa = gpa;
        } else {
            this.gpa = gpa;
        }}

}
