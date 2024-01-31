/* Created By Sithira Roneth
 * Date :1/16/24
 * Time :21:55
 * Project Name :Chat_Application
 * */
package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/welcomePage.fxml"))));
        stage.setTitle("welcome page");
        stage.centerOnScreen();
        stage.show();
    }
}
