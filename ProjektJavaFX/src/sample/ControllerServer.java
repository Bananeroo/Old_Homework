package sample;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;

public class ControllerServer implements Initializable {

    private ArrayList<ClientDatabase> clientDatabase = new ArrayList<ClientDatabase>();
    private ArrayList<ClientDatabase> copyClientDatabase = new ArrayList<ClientDatabase>();
    private ArrayList<File> filesInFolder = new ArrayList<>();
    private ArrayList<File> copyFilesInFolder = new ArrayList<>();

    @FXML ListView<String> activeUsers = new ListView<String>();
    ObservableList<String> clients = FXCollections.observableArrayList ();
    @FXML ListView<String> userFile = new ListView<String>();
    ObservableList<String> files = FXCollections.observableArrayList ();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread() {
            public void run() {
                while (true) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if(clientDatabase != null){
                                //refreshClientList();
                            }
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

    /**     Initializing parameters     **/
    /**     Initializing parameters, getting user name     **/
    public void initializeData(ArrayList<ClientDatabase> clientDatabase2, String newUsername, ArrayList<File> filesInFolder2) {

        this.copyClientDatabase = clientDatabase2;
        this.copyFilesInFolder = filesInFolder2;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Chuj mi w dupe");
                for (int i = 0; i < clientDatabase.size(); i++) {
                    System.out.println("CLEINTDATABASE: " + clientDatabase.get(i).getUserName() + clientDatabase.size());
                }
                for (int i = 0; i < copyClientDatabase.size(); i++) {
                    System.out.println("COPYCLEINTDATABASE: " + copyClientDatabase.get(i).getUserName() + copyClientDatabase.size());
                }
                System.out.println("Controller server username: " + newUsername);
                if (copyClientDatabase.size() != clientDatabase.size()) {

                        clientDatabase.clear();
                        clientDatabase.addAll(copyClientDatabase);
                        //clientDatabase.removeIf(n -> (n.getUserName().equals(newUsername)));
                        clearListViewUsers();
                        setListOfClients();
                }
                //if(copyFilesInFolder != null) {
                    if (filesInFolder.size() != copyFilesInFolder.size()) {
                        filesInFolder.clear();
                        filesInFolder.addAll(copyFilesInFolder);
                        clearListViewFiles();
                        setFilesList();
                    }
                //}
            }
        });
    }
    /**        Displaying user list on Server Window       **/
    public void setListOfClients(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (clientDatabase != null){
                    for (int i = 0; i < clientDatabase.size(); i++) {
                        clients.add(clientDatabase.get(i).getUserName());
                        System.out.println("clientsSetLisOfclients:" + clients);
                    }
                }
                activeUsers.setItems(clients);
            }});

    }

    private void setFilesList(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < filesInFolder.size(); i++) {
                    files.add(filesInFolder.get(i).getName());
                    System.out.println("Lists of files:" + files);
                }
                userFile.setItems(files);
            }});
    }

//    /**     clearing list in order to have on Server Active User List only 1 of every userName      **/
//    @FXML
//    public void clearListView(){
//        Platform.runLater(new Runnable() {
//           @Override
//            public void run() {
//                activeUsers.getItems().clear();
//            }});
//    }

    /** coping clientDatabase from server initialize (55 l. in Server.java) to copyClientDatabase    **/
    public void saveOrginalDatabaseToCopy(ArrayList<ClientDatabase> userDatabase){
        if(copyClientDatabase != null) {
            copyClientDatabase.clear();
            copyClientDatabase.addAll(userDatabase);
        }
    }


        @FXML
        public void clearListViewUsers(){
           activeUsers.getItems().clear();
       }

        @FXML
        public void clearListViewFiles(){
            userFile.getItems().clear();
        }


    /**        Refresh Users List   **/
    public void refreshClientList(){
        if (copyClientDatabase != null) {
            if (copyClientDatabase.size() != this.clientDatabase.size()) {
                this.copyClientDatabase.clear();
                this.copyClientDatabase.addAll(clientDatabase);
                clearListViewUsers();
                setListOfClients();
            }
        }
    }

}

