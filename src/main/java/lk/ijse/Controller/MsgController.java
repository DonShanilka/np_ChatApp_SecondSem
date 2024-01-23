package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
    public GridPane emojiGridPane;
    public AnchorPane emojiAnchorPane;

    @FXML
    private TextField txtMsg;


    private final String[] emojis = {"\uD83D\uDE00", // 😀
            "\uD83D\uDE01", // 😁
            "\uD83D\uDE02", // 😂
            "\uD83D\uDE03", // 🤣
            "\uD83D\uDE04", // 😄
            "\uD83D\uDE05", // 😅
            "\uD83D\uDE06", // 😆
            "\uD83D\uDE07", // 😇
            "\uD83D\uDE08", // 😈
            "\uD83D\uDE09", // 😉
            "\uD83D\uDE0A", // 😊
            "\uD83D\uDE0B", // 😋
            "\uD83D\uDE0C", // 😌
            "\uD83D\uDE0D", // 😍
            "\uD83D\uDE0E", // 😎
            "\uD83D\uDE0F", // 😏
            "\uD83D\uDE10", // 😐
            "\uD83D\uDE11", // 😑
            "\uD83D\uDE12", // 😒
            "\uD83D\uDE13"  // 😓
    };


    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public void initialize(URL url, ResourceBundle resourceBundle){
        /*String name = LoginController.user;
        lblName.setText(name);*/

        emojiAnchorPane.setVisible(false);
        int buttonIndex = 0;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                if (buttonIndex < emojis.length) {
                    String emoji = emojis[buttonIndex];
                    JFXButton emojiButton = createEmojiButton(emoji);
                    emojiGridPane.add(emojiButton, column, row);
                    buttonIndex++;
                } else {
                    break;
                }
            }
        }

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

    public void emojiButtonAction(ActionEvent event) {
        JFXButton button = (JFXButton) event.getSource();
        txtMsg.appendText(button.getText());
    }

    private JFXButton createEmojiButton(String emoji) {
        JFXButton button = new JFXButton(emoji);
        button.getStyleClass().add("emoji-button");
        button.setOnAction(this::emojiButtonAction);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setFillWidth(button, true);
        GridPane.setFillHeight(button, true);
        button.setStyle("-fx-font-size: 15; -fx-text-fill: black; -fx-background-color: #F0F0F0; -fx-border-radius: 50" );
        return button;
    }

}
