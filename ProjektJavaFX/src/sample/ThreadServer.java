package sample;

import javafx.fxml.FXMLLoader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadServer  extends Thread{

    private Socket socket;
    private ArrayList<ClientDatabase> clientDatabase;
    private ArrayList<ClientDatabase> clientDatabasesCopyForClient;
    private ControllerServer controller;

    public ThreadServer(Socket socket, ArrayList<ClientDatabase> clientDatabase, ArrayList<ClientDatabase> clientDatabasesCopyForClient, ControllerServer controller){
        this.socket = socket;
        this.clientDatabase = clientDatabase;
        this.clientDatabasesCopyForClient = clientDatabasesCopyForClient;
        this.controller = controller;

    }


    @Override
    public void run(){
        ArrayList<File> filesInFolder = new ArrayList<>();


        try {
                /**     Receiving userName and folderPath from client       **/
                DataInputStream userNameIn = new DataInputStream(socket.getInputStream());
                DataInputStream folderPathIn = new DataInputStream(socket.getInputStream());
                String userName = userNameIn.readUTF();
                String folderPath = folderPathIn.readUTF();
                System.out.println("Username of new client: " + userName);

                /**     Creating local folder      **/
                new File(folderPath + "/" + userName).mkdirs();
                clientDatabase.add(new ClientDatabase(userName, folderPath, socket));
                clientDatabasesCopyForClient.add(new ClientDatabase(userName, folderPath, socket));
                System.out.println("checking if there is right amuont of users:");
                for (int i = 0; i < clientDatabase.size(); i++) {
                    System.out.println(clientDatabase.get(i).getUserName());
                }

                while (true) {
                /**     Transfer clientDatabase to ControllerServer     **/
                System.out.println("Lista useruw: ");
                        ObjectOutputStream sendDatabaseToServer = new ObjectOutputStream(socket.getOutputStream());
                for(int i = 0; i < clientDatabasesCopyForClient.size(); i++){
                    System.out.println(clientDatabasesCopyForClient.get(i).getUserName());
                }
                sendDatabaseToServer.writeObject(clientDatabasesCopyForClient);
                sendDatabaseToServer.flush();
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                File files = new File(folderPath + "/" + userName);
                for(int i = 0; i < filesInFolder.size(); i++){
                System.out.println(filesInFolder.get(i).getName());
                }

                File[] filesList = files.listFiles();
                filesInFolder.clear();

                for (int i = 0; i < filesList.length; i++) {
                filesInFolder.add(filesList[i]);
                }

                System.out.println("Single Thread Server username: " + userName);
                        for (int i = 0; i < clientDatabase.size() ; i++) {
                            System.out.println("arg Thread: " + clientDatabase.get(i).getUserName() + clientDatabase.size());
                        }

                controller.initializeData(clientDatabase, userName, filesInFolder);
                controller.saveOrginalDatabaseToCopy(clientDatabase);

            }
        }catch(IOException e){
            e.printStackTrace();

        }
    }
}
