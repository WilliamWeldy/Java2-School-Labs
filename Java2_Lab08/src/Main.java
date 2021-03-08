/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 * Lab #8
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import java.sql.*;


public class Main {
    public static void main(String[] args) {
	    Student s1 = new Student(4,"Frank","Jones","123 Main","Atlanta","GA",30133,"fj@yahoo.com",3.2);
	        s1.selectDB(4);
	        s1.display();
        Student s2 = new Student();
            s2.insertDB(33,"Frank","Mayes","123 Main street","Atlanta","GA",30100,"fmayes@yahoo.com",3.3f);
            s2.display(33);
        Student s3 = new Student();
            s3.selectDB(6);
            s3.deleteDB();
        Student s4 = new Student();
            s4.selectDB(7);
            s4.setZip(30106);
            s4.updateDB();
    }
}
