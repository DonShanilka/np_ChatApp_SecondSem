package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Server {

    @FXML
    public JFXTextArea clientMsg;
    @FXML
    public JFXTextArea viewSeverMsg;
    @FXML
    public JFXButton send;
    @FXML
    public AnchorPane root;


    public void initialize(){
        new Thread(() -> {

        });
    }

    public void sendOnAction(ActionEvent actionEvent) {

    }
}
