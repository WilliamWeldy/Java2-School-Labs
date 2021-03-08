/*****************************************
 * Class: CIST 2372 Java Programming II
 * Semester: SPRING 2020
 * Instructor: Ron Enz
 *
 *  The Final Project
 *
 *
 * @author William  G.  Weldy
 * @version 1.0
 *****************************************/

import javafx.stage.Stage;
import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class ChatServer extends Application {
    String lastline = null; //the string is set to 'null' in case information is never received.

    PrintStream outputToClient;
    BufferedReader inputFromClient;
    ServerSocket ss;
    Socket s1;
    TextArea txtareainrunglobalscope;

    public static void main(String[] args) { launch(args); }

    class ReceiveInput extends Thread {
        ReceiveInput() {
            try {
                inputFromClient = new BufferedReader(new InputStreamReader(s1.getInputStream())); //Data input
                lastline = inputFromClient.readLine(); //the line is read and changes the string from null to the SERVER's message
                txtareainrunglobalscope.appendText(lastline + "\n"); //make sure we get to the next line
            } catch (IOException ioe) {
                System.out.println("Error in Client BufferedReader: " + ioe + "\n");
                ioe.printStackTrace();
            } catch (NullPointerException npe) {
                System.out.println("Error in Client BufferedReader: " + npe + "\n");
                npe.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error in Client BufferedReader: " + e + "\n");
                e.printStackTrace();
            }
        }
    }

    /*public void run() { //This method is for establishing connection and receiving messages as a second thread
            try {
                inputFromClient = new BufferedReader(new InputStreamReader(s1.getInputStream())); //Data input
                lastline = inputFromClient.readLine(); //the line is read and changes the string from null to the CLIENT's message
                txtareainrunglobalscope.appendText(lastline + "\n"); //make sure we get to the next line
            } catch (IOException ioe) {
                System.out.println("Error in Server BufferedReader: " + ioe + "\n");
                ioe.printStackTrace();
            } catch (NullPointerException npe) {
                System.out.println("Error in Server BufferedReader: " + npe + "\n");
                npe.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error in Server BufferedReader: " + e + "\n");
                e.printStackTrace();
            }
    }*/

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CHAT Application"); //The stage is set!

        //Establishing connection from serverside and creating the output stream
        try {
            ss = new ServerSocket(7777);
            s1 = ss.accept();

            outputToClient = new PrintStream(s1.getOutputStream());

            outputToClient.println("You (Client) are now connected to (Server), say Hello!");
        } catch (IOException ioe) {
            System.out.println("Error in Server PrintOutStream: " + ioe + "\n");
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            System.out.println("Error in Server PrintOutStream: " + npe + "\n");
            npe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error in Server PrintOutStream: " + e + "\n");
            e.printStackTrace();
        }

        //Setting up the Scene
        VBox rootNode = new VBox(); //This VBox will hold everything
        rootNode.setStyle("-fx-background-color: E9EFF2");

        //These are the contents of the scene itself
        Text title = new Text("CHAT Application:  Server"); //The title of the program
        HBox convoTxt = new HBox();
        TextArea txtarea = new TextArea(); txtareainrunglobalscope = txtarea;
        Label convoLbl = new Label("Conversation: ");
        HBox msgTxt = new HBox();
        TextField txtfield = new TextField();
        Label msgLbl = new Label("Your message: ");
        Label spacingLbl = new Label("");  //this creates spacing between your text field and the buttons
        spacingLbl.setText("");
        HBox buttons = new HBox();
        Button sendBtn = new Button(" Send Message ");
        Button exitBtn = new Button(" Exit Program ");

        //Setting the style of the scene contents
        title.setStyle("-fx-font: 36px Arial; -fx-font-weight: bold;");
        txtarea.setStyle("-fx-font: 12px Arial;"); convoLbl.setStyle("-fx-font: 16px Arial; -fx-font-weight: bold;");
        txtfield.setStyle("-fx-font: 12px Arial;"); msgLbl.setStyle("-fx-font: 16px Arial; -fx-font-weight: bold;");
        sendBtn.setStyle("-fx-font-weight: bold;");
        exitBtn.setStyle("-fx-font-weight: bold;");

        //Aligning, spacing, and pairing all the nodes together & defining their properties
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setSpacing (30);
        rootNode.getChildren().addAll(title, convoTxt, msgTxt, spacingLbl, buttons);
        convoTxt.getChildren().addAll(convoLbl, txtarea);
        convoTxt.setAlignment(Pos.CENTER);
        txtarea.setEditable(false);
        txtarea.setPrefRowCount(10);
        msgTxt.getChildren().addAll(msgLbl, txtfield);
        msgTxt.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(sendBtn, exitBtn);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing (20);

        primaryStage.setScene(new Scene(rootNode, 640, 480)); //The root node is set up

        new ReceiveInput();
        txtarea.appendText("\n");

        //The two button events, send your message and exit the program
        sendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    txtarea.appendText("[" + java.time.LocalDate.now() + "::" + java.time.LocalTime.now() + "]You: " + txtfield.getText() + "\n");
                outputToClient.println("[" + java.time.LocalDate.now() + "::" + java.time.LocalTime.now() + "]Server: " + txtfield.getText() + "\n"); //The message to send to the client
                ReceiveInput forClient = new ReceiveInput();
                forClient.start();
                txtfield.setText("");
            }
        });
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        primaryStage.show(); //Finally, the scenes and stages will be shown
    }
}

