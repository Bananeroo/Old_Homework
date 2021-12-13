package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartClient extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Box.fxml"));
        Parent root = (Parent)loader.load();
        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(root, 521, 342));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
