package sample;

import javafx.fxml.FXMLLoader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;


public class Client extends Thread {

    private FXMLLoader loader;
    private ClientDatabase clientDatabase;

    public Client(FXMLLoader loader, ClientDatabase clientDatabase)
    {
        this.loader = loader;
        this.clientDatabase = clientDatabase;
    }

    @Override
    public void run() {

        ArrayList<File> filesInFolder = new ArrayList<>();

        String userName = this.clientDatabase.getUserName();
        String localFolderPath = this.clientDatabase.getLocalFolderPath();

        new File(localFolderPath + "/" + userName).mkdirs();
        File files = new File(localFolderPath + "/" + userName);

        System.out.println("Your User Name: " + userName +  " Path to your local folder: " + localFolderPath);

        try {
            Socket socket = new Socket("localhost", 3200);
            /**     Sending userName and localFolderPath to the server      **/
            DataOutputStream userNameToServer = new DataOutputStream(socket.getOutputStream());
            userNameToServer.writeUTF(userName);
            DataOutputStream localFolderPathToServer = new DataOutputStream(socket.getOutputStream());
            localFolderPathToServer.writeUTF(localFolderPath);

            ControllerClient controller = loader.<ControllerClient>getController();

            while(true) {
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
                ArrayList<ClientDatabase> fromServer = (ArrayList<ClientDatabase>) is.readObject();
                System.out.println("List of users: ");
                for(int i = 0; i < fromServer.size(); i++){
                    System.out.println(fromServer.get(i).getUserName());
                }

                for(int i = 0; i < filesInFolder.size(); i++){
                    System.out.println(filesInFolder.get(i).getName());
                }

                File[] filesList = files.listFiles();
                filesInFolder.clear();

                for (int i = 0; i < filesList.length; i++) {
                    filesInFolder.add(filesList[i]);
                }

                controller.initializeData(fromServer, userName, filesInFolder);

                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {}
    }
}

