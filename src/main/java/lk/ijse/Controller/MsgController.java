package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

public class MsgController extends Thread implements Initializable {

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
    public AnchorPane emojiPane;

    @FXML
    private TextField txtMsg;


    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public void initialize(URL url, ResourceBundle resourceBundle){
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

    @FXML
    void emoji_on_action(MouseEvent event) {
        emojiPane.setVisible(true);
    }

    @FXML
    void emoji1(MouseEvent mouseEvent) {

    }

    @FXML
    void emoji10(MouseEvent event) {
    }

    @FXML
    void emoji11(MouseEvent event) {

    }

    @FXML
    void emoji12(MouseEvent event) {

    }

    @FXML
    void emoji2(MouseEvent event) {

    }

    @FXML
    void emoji3(MouseEvent event) {

    }

    @FXML
    void emoji4(MouseEvent event) {

    }

    @FXML
    void emoji5(MouseEvent event) {

    }

    @FXML
    void emoji6(MouseEvent event) {

    }

    @FXML
    void emoji7(MouseEvent event) {

    }

    @FXML
    void emoji8(MouseEvent event) {

    }

    @FXML
    void emoji9(MouseEvent event) {

    }

}
