package sample;
import javafx.fxml.FXMLLoader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server extends Thread {

    private FXMLLoader loader;

    public Server(FXMLLoader loader) {
        this.loader = loader;
    }

    @Override
    public void run() {
        ArrayList<ClientDatabase> clientDatabase = new ArrayList<ClientDatabase>();
        ArrayList<ClientDatabase> clientDatabasesCopyForClient = new ArrayList<ClientDatabase>();

        try {
            ServerSocket server = new ServerSocket(3200);
            ControllerServer controller = loader.<ControllerServer>getController();
            while (true) {
                /**     Accepting new users                 **/
                final Socket socket = server.accept();
                System.out.println("New user");

                ThreadServer threadServer = new ThreadServer(socket, clientDatabase, clientDatabasesCopyForClient, controller);
                threadServer.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
