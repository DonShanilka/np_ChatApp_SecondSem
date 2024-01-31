/* Created By Sithira Roneth
 * Date :1/30/24
 * Time :10:26
 * Project Name :Chat_Application
 * */
package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Server.Server;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private AnchorPane root;

    public void btnSigninOnAction(ActionEvent actionEvent) {
        try {
            Server server = Server.getServerSocket();
            Thread thread = new Thread(server);
            thread.start();

            root.getChildren().clear();
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login.fxml"))));
            stage.show();
            stage.setOnCloseRequest(e-> {
                System.exit(0);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/register.fxml"))));
        stage.setTitle("Sign Up Form");
        stage.show();

    }
}
