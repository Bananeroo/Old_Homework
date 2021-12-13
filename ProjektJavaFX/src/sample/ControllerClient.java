package sample;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.io.File;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;

public class ControllerClient implements Initializable {

    private ArrayList<ClientDatabase> clientDatabase = new ArrayList<>();
    private ArrayList<ClientDatabase> copyClientDatabase = new ArrayList<>();

    private ArrayList<File> filesInFolder = new ArrayList<>();
    private ArrayList<File> copyFilesInFolder = new ArrayList<>();

    private String userName = new String();

    private String filePath = new String();

    @FXML ListView<String> usersList = new ListView<String>();
    @FXML ListView<String> foldersList = new ListView<String>();
    ObservableList<String> files = FXCollections.observableArrayList ();
    @FXML Text thisWindowUser = new Text();
    ObservableList<String> users = FXCollections.observableArrayList ();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        thisWindowUser.setText(userName);
        new Thread() {
            public void run() {
                while (true) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {}
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

    /**     Initializing parameters, getting user name     **/
    public void initializeData(ArrayList<ClientDatabase> clientDatabase2, String newUsername, ArrayList<File> filesInFolder2){
        this.copyClientDatabase = clientDatabase2;
        this.copyFilesInFolder = filesInFolder2;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(copyClientDatabase.size() != clientDatabase.size()){
                    clientDatabase.clear();
                    clientDatabase.addAll(copyClientDatabase);
                    clientDatabase.removeIf(n -> (n.getUserName().equals(newUsername)));
                    clearListViewUsers();
                    setUsersList();
                }
                if(filesInFolder.size() != copyFilesInFolder.size()) {
                    filesInFolder.clear();
                    filesInFolder.addAll(copyFilesInFolder);
                    clearListViewFiles();
                    setFilesList();
                }
            }});
        thisWindowUser.setText(newUsername);
    }

    /**        Displaying user list on Client Window       **/
    private void setUsersList(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < clientDatabase.size(); i++) {
                    users.add(clientDatabase.get(i).getUserName());
                    System.out.println("Users on every User Window:" + users);
                }
                usersList.setItems(users);
            }});
    }

    /**        Displaying file list on Client Window       **/
    private void setFilesList(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < filesInFolder.size(); i++) {
                    files.add(filesInFolder.get(i).getName());
                    System.out.println("Lists of files:" + files);
                }
                foldersList.setItems(files);
            }});
    }

    public void setUserName(String userName, String filePath){
        this.userName = userName;
        this.filePath = filePath;
    }

    @FXML
    public void clearListViewUsers(){
        usersList.getItems().clear();
    }

    @FXML
    public void clearListViewFiles(){
        foldersList.getItems().clear();
    }

}

