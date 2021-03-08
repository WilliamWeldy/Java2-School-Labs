import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/


public class GUImenu extends Application {
   public static void main(String[] args) { launch(args); } //Launch straight into the start method in the Application class

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab 01 GUI Menu"); //The stage is set!

        //Setting up the Scene
        BorderPane rootNode = new BorderPane(); //The BorderPane that'll hold everything
        rootNode.setStyle("-fx-background-color: E8E8E8");
            //Node 1 - The title
            HBox top = new HBox();
                Text title = new Text("Client Program");
                title.setStyle("-fx-font: 24px Arial; -fx-font-weight: bold;");
                top.setAlignment(Pos.CENTER);
                top.getChildren().add(title);
            //Node 2 - The information for the program
            GridPane information = new GridPane();
                information.setStyle("-fx-font-weight: bold;");
                information.getColumnConstraints().add(new ColumnConstraints(75)); //This makes sure the fields are spaced out correctly
                information.setAlignment(Pos.CENTER);
            //Node 3 - The buttons on bottom to perform the actions
            HBox bottom = new HBox();
                bottom.setAlignment(Pos.CENTER);
                bottom.setSpacing(5);
        //Aligning everything in the root node Border pane
        rootNode.setTop(top);
        rootNode.setCenter(information);
        rootNode.setBottom(bottom);

            primaryStage.setScene(new Scene(rootNode, 310, 210)); //The root node is set up

        /**
         * Information Pane
         */
        //add the text fields, then the labels to this gridpane
       TextField idTxtBox = new TextField();
        TextField fNameTxtBox = new TextField();
        TextField lNameTxtBox = new TextField();
        TextField emailTxtBox = new TextField();
        TextField gpaTxtBox = new TextField();
        Label idLbl = new Label("ID: ");
        Label fNameLbl = new Label("First Name: ");
        Label lNameLbl = new Label("Last Name: ");
        Label emailLbl = new Label("E-Mail: ");
        Label gpaLbl = new Label("GPA: ");
            information.add(idLbl, 0, 0);
            information.add(idTxtBox, 1, 0);
            information.add(fNameLbl, 0, 1);
            information.add(fNameTxtBox, 1, 1);
            information.add(lNameLbl, 0, 2);
            information.add(lNameTxtBox, 1, 2);
            information.add(emailLbl, 0, 3);
            information.add(emailTxtBox, 1, 3);
            information.add(gpaLbl, 0, 4);
            information.add(gpaTxtBox, 1, 4);

        /**
         * Bottom Pane
         */
        //put everything in a group, and then create the buttons
        Group groupActions = new Group();
            Button findBtn = new Button("Find");
            Button insertBtn = new Button("Insert");
            Button deleteBtn = new Button("Delete");
            Button updateBtn = new Button("Update");
            Button exitBtn = new Button("Exit");
                exitBtn.setStyle("-fx-font-weight: bold;");
        bottom.getChildren().addAll(findBtn, insertBtn, deleteBtn, updateBtn, exitBtn);

        //The button events
        findBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { System.out.println("Find Button Pressed!"); }
        });
        insertBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { System.out.println("Insert Button Pressed!"); }
        });
        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { System.out.println("Delete Button Pressed!"); }
        });
        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { System.out.println("Update Button Pressed!"); }
        });
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { System.exit(0); }
        });


        primaryStage.show(); //Finally, the scenes and stages are shown
    }
}
