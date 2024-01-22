package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MsgController extends Thread{

    @FXML
    public JFXTextArea clientMsg;
    @FXML
    public JFXTextArea viewSeverMsg;
    @FXML
    public JFXButton send;
    @FXML
    public AnchorPane root;
    public ScrollPane scrollPane;
    public VBox msgVbox;
    @FXML
    private TextField txtMsg;


    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public void initialize(){
        /*String name = LoginController.user;
        lblName.setText(name);*/

        try {
            socket = new Socket("localhost",3000);
            System.out.println("Socket connected to server");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);

            this.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendOnAction(ActionEvent actionEvent) {
        String message = txtMsg.getText();
        //printWriter.println(lblName.getText() + ":" + message);
        txtMsg.clear();

        if ((message.equalsIgnoreCase("exit")) || (message.equalsIgnoreCase("bye"))){
            System.exit(0);
        }
    }
}
