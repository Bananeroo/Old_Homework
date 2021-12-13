package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class ControllerBox implements Initializable {

    @FXML
    TextField userNameBox = new TextField();
    @FXML
    TextField folderPathBox = new TextField();
    @FXML
    Button loginButton = new Button();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread() {
            public void run() {
                while (true) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    @FXML
    public void handleLogInButton(javafx.event.ActionEvent event) {
        Stage stage;
        Parent root;

        try {

            Socket socket = new Socket("localhost", 3200);

            if (event.getSource() == loginButton) {

                stage = (Stage) loginButton.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
                root = (Parent) loader.load();

                /** Getting userName from TextBox **/
                ClientDatabase user = new ClientDatabase(userNameBox.getText(), folderPathBox.getText(), socket);

                /** New Thread for Client   **/
                Client client = new Client(loader, user);
                client.start();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


