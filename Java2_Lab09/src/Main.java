/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 * Lab #9
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) { launch(args); } //Launch into the start method of the Application class

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("STUDENT REGISTRATION         (CTC CIST 2372 Java II: Lab 09 GUI Menu)"); //The stage is set!
                Student obj = new Student(); //The Student Business Object that'll be used in this main GUI class.


            //Setting up the Scene
                BorderPane rootNode = new BorderPane(); //The BorderPane that'll hold everything
                rootNode.setStyle("-fx-background-color: E8E8E8");
            //Node 1 - The title
                HBox top = new HBox();
                Text title = new Text("Student Information");
                title.setStyle("-fx-font: 24px Arial; -fx-font-weight: bold");
                top.setAlignment(Pos.CENTER);
                top.setPadding(new Insets(20, 25, 25, 25));
                top.getChildren().add(title);
            //Node 2 - The information for the program
                GridPane information = new GridPane();
                information.setStyle("-fx-font-weight: bold;");
                information.setAlignment(Pos.CENTER);
            //Node 3 - The rest of the buttons on the bottom that perform actions
                HBox bottom = new HBox();
                bottom.setAlignment(Pos.CENTER);
                bottom.setSpacing(5);
            //Aligning everything in the root node Border pane
                rootNode.setTop(top);
                rootNode.setCenter(information);
                rootNode.setBottom(bottom);
            //////////////////////////////////


            primaryStage.setScene(new Scene(rootNode, 550, 375)); //The root node is set up
            Group groupActions = new Group(); //The buttons for the Bottom Pane are grouped early.

            /**
             * Information Pane
             */
            //adding the rest of the text fields, then the labels to this gridpane
            TextField idTxtBox = new TextField();
            TextField fNameTxtBox = new TextField();
            TextField lNameTxtBox = new TextField();
            TextField streetTxtBox = new TextField();
            TextField cityTxtBox = new TextField();
            TextField stateTxtBox = new TextField();
            TextField zipTxtBox = new TextField();
            TextField emailTxtBox = new TextField();
            TextField gpaTxtBox = new TextField();
                Label idLbl = new Label("Student ID:");
                    Button findBtn = new Button("Find");
                Label fNameLbl = new Label("First Name: ");
                Label lNameLbl = new Label("Last Name: ");
                Label streetLbl = new Label("Street: ");
                Label cityLbl = new Label("City: ");
                Label stateLbl = new Label("State: ");
                Label zipLbl = new Label("Zip Code: ");
                Label emailLbl = new Label("E-Mail: ");
                Label gpaLbl = new Label("GPA: ");
                    //These are padding, except the first Label which is used to display messages back to the user
                    Label findBtnResultTxt = new Label ("");
                        findBtnResultTxt.setStyle("-fx-font-weight: bold;");
                    Label gridplanePadding = new Label("");
                    Label gridplaneEndPadding = new Label("");

            information.add(idLbl, 0, 0);
            information.add(idTxtBox, 1, 0);
            information.add(findBtn, 2, 0);
                information.add(findBtnResultTxt, 1, 1);
                information.add(gridplanePadding, 0, 2);
            information.add(fNameLbl, 0, 3);
            information.add(fNameTxtBox, 1, 3);
            information.add(lNameLbl, 0, 4);
            information.add(lNameTxtBox, 1, 4);
            information.add(streetLbl, 0, 5);
            information.add(streetTxtBox, 1, 5);
            information.add(cityLbl, 0, 6);
            information.add(cityTxtBox, 1, 6);
            information.add(stateLbl, 0, 7);
            information.add(stateTxtBox, 1, 7);
            information.add(zipLbl, 0, 8);
            information.add(zipTxtBox, 1, 8);
            information.add(emailLbl, 0, 9);
            information.add(emailTxtBox, 1, 9);
            information.add(gpaLbl, 0, 10);
            information.add(gpaTxtBox, 1, 10);
                information.add(gridplaneEndPadding, 0, 11);

            /**
             * Bottom Pane
             */
            //putting everything in a group, and then creating the buttons
                Button insertBtn = new Button("Insert");
                Button deleteBtn = new Button("Delete");
                Button updateBtn = new Button("Update");
                Button exitBtn = new Button("Exit");
            exitBtn.setStyle("-fx-font-weight: bold;");
            bottom.getChildren().addAll(insertBtn, deleteBtn, updateBtn, exitBtn);


            /*** The button events with all the SQL actions in place ***/
                findBtn.setOnAction(new EventHandler<ActionEvent>() { //SELECT from student id
                    @Override
                    public void handle(ActionEvent event) {
                        String input = idTxtBox.getText();
                        try {
                            if (Integer.parseInt(input) > 0) {
                                obj.selectDB(Integer.parseInt(input));
                                findBtnResultTxt.setText("");
                            } else if (Integer.parseInt(input) < 0) {
                                obj.selectDB(Integer.parseInt(input) * -1);
                                findBtnResultTxt.setText("**ERROR: Negative numbers can't be IDs. Making entry positive.");
                            } else {
                                obj.selectDB(1);
                                findBtnResultTxt.setText("**ERROR: \" 0 \" is not valid, Student \" 1 \" selected.");
                            }
                            idTxtBox.setText(Integer.toString(obj.getSid()));
                            fNameTxtBox.setText(obj.getFname());
                            lNameTxtBox.setText(obj.getLname());
                            streetTxtBox.setText(obj.getStreet());
                            cityTxtBox.setText(obj.getCity());
                            stateTxtBox.setText(obj.getState());
                            zipTxtBox.setText(Integer.toString(obj.getZip()));
                            emailTxtBox.setText(obj.getEmail());
                            gpaTxtBox.setText(Double.toString(obj.getGPA()));
                        }
                        catch(Exception e) {
                            findBtnResultTxt.setText("**ERROR: \"" + idTxtBox.getText() + "\" is invalid, try again.");
                            idTxtBox.setText("");
                        }
                    }
                });

            //INSERT
                insertBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String sid = idTxtBox.getText();
                        try {
                            obj.insertDB(Integer.parseInt(sid), fNameTxtBox.getText(), lNameTxtBox.getText(), streetTxtBox.getText(), cityTxtBox.getText(), stateTxtBox.getText(), Integer.parseInt(zipTxtBox.getText()), emailTxtBox.getText(), Double.parseDouble(gpaTxtBox.getText()));
                            findBtnResultTxt.setText("Student #" + sid + " is Created.");
                        }
                        catch(Exception e) {
                            findBtnResultTxt.setText("**ERROR: Not all fields are valid. Make sure they make sense.");
                        }
                    }
                });

            //DELETE
                deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String sid = idTxtBox.getText();
                        try {
                            System.out.println("Delete Button Pressed!");
                            findBtnResultTxt.setText("Student #" + sid + " is deleted.");
                            obj.deleteDB();
                        }
                        catch(Exception e) {
                            findBtnResultTxt.setText("**ERROR: Not all fields are valid. Make sure they make sense.");
                        }
                    }
                });

            //UPDATE
                updateBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String sid = idTxtBox.getText();
                        try {
                            obj.setSid(Integer.parseInt(sid));
                            obj.setFname(fNameTxtBox.getText());
                            obj.setLname(lNameTxtBox.getText());
                            obj.setStreet(streetTxtBox.getText());
                            obj.setCity(cityTxtBox.getText());
                            obj.setState(stateTxtBox.getText());
                            obj.setZip(Integer.parseInt(zipTxtBox.getText()));
                            obj.setEmail(emailTxtBox.getText());
                            obj.setGPA(Double.parseDouble(gpaTxtBox.getText()));
                            findBtnResultTxt.setText("Student #" + sid + " is updated.");
                            obj.updateDB();
                        }
                        catch(Exception e) {
                            findBtnResultTxt.setText("**ERROR: Not all fields are valid. Make sure they make sense.");
                        }
                    }
                });

                exitBtn.setOnAction(new EventHandler<ActionEvent>() { //This exits the program
                    @Override
                    public void handle(ActionEvent event) {
                        System.exit(0);
                    }
                });


            primaryStage.show(); //Finally, the scenes and stages are shown
    }
}
