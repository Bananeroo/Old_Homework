package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartServer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Server.fxml"));
        Parent root = (Parent)loader.load();
        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(root, 521, 342));
        primaryStage.show();

        Server server = new Server(loader);
        server.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}