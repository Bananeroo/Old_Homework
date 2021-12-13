import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server {
    public static void main(String arg[]) throws InterruptedException {
        ServerSocket server = null;
        try{
            server = new ServerSocket(1234);

            while(true) {
        /**     Accepting new users                 **/
                final Socket socket = server.accept();
                System.out.println("New user");
        /**     Receiving userName from client       **/
                Thread threadUserNameReceive = new Thread(()-> {
                    try {
                        DataInputStream getUserName = new DataInputStream(socket.getInputStream());
                        while (true) {
                             Thread.sleep(4000);
                            String str = getUserName.readUTF();
                            System.out.println(str);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                threadUserNameReceive.start();

            }
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
    }
}