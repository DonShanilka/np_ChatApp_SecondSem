package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MsgController {

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


    public void initialize(){
        new Thread(() -> {

        });
    }

    public void sendOnAction(ActionEvent actionEvent) {

    }
}
