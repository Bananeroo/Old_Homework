package sample;
import java.io.Serializable;
import java.net.Socket;

public class ClientDatabase implements Serializable {
    private String userName;
    private String localFolderPath;
    private transient Socket socket;

    public ClientDatabase(String userName, String localFolderPath, Socket socket)
    {
        this.userName = userName;
        this.localFolderPath = localFolderPath;
        this.socket = socket;
    }

    public String getLocalFolderPath() {
        return localFolderPath;
    }

    public String getUserName() {
        return userName;
    }

    public Socket getSocket() {
        return socket;
    }

}

