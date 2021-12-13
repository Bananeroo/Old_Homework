import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = 32000;
        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String tekst = null;
            String i=null;
            StorageAndValidate first = new StorageAndValidate();
            receive moje = new receive(socket);
            new Thread(moje).start();
            
            while (true) {
                System.out.println("Podaj tekst");
                tekst = scanner.nextLine();
                if ("exit".equalsIgnoreCase(tekst)) break;
                first.tekst=tekst;
                try{
                    first.validatetext();

                }catch(TekstNieprawidlowyException e){
                    e.desc();
                    continue;
                }
                System.out.println("Podaj czas");
                i=scanner.nextLine();
                try{
                    first.czas=i;
                    first.convert();
                    first.validateczas();

                }catch(CzasNieprawidlowyException e ){
                    e.desc();
                    continue;
                }catch(NumberFormatException e){
                    System.out.println("Wpisany ciag nie jest integerem");
                    continue;
                }catch(Exception e ){
                    e.printStackTrace();
                    continue;
                }
                
                out.println(tekst);     
                out.flush();
                out.println(i);
                out.flush();
                
            }
            scanner.close();
            System.out.println("Klient odłączony");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class receive implements Runnable{
        Socket klient;
        public receive(Socket z) {
             klient=z;
        }

        @Override
        public void run() {
            while(true)
            {
                try{
                    BufferedReader in = new BufferedReader(new InputStreamReader(klient.getInputStream()));
                    if(in.ready()){
                        System.out.println("Server replied " + in.readLine());
                        }
                }catch(IOException e){
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
           
        }
    }


}