package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Server.Client.Client;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtUser;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void btnSigninOnAction(ActionEvent actionEvent) throws SQLException, IOException {
        try {
            if (Pattern.matches("^[a-zA-Z\\s]+", txtUser.getText())) {
                Client client = new Client(txtUser.getText());

                Thread thread = new Thread(client);
                thread.start();

            }
            clearFields();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void clearFields(){
        txtUser.setText("");
    }

}
