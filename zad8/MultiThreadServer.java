
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


import java.time.LocalTime;
public class MultiThreadServer {

    static ArrayList<Socket> handl = new ArrayList<Socket>(); 
    static TreeMap<LocalTime,Wpis> map=new TreeMap<LocalTime,Wpis>();
    public static void main(String[] args) {

        ServerSocket server = null;
        try {
            
            server = new ServerSocket(32000);
            server.setReuseAddress(true);
            maine moje = new maine();
            new Thread(moje).start();
             // The main thread is just accepting new connections
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected " + client.getInetAddress().getHostAddress());
                handl.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class maine implements Runnable{
        public maine() {
        }

        @Override
        public void run() {
            ArrayList<LocalTime> godz= new ArrayList<LocalTime>();
           while(true){
             try{Thread.sleep(1000);
            }catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            
            
            for(Socket i: handl)
            {
                BufferedReader in = null;
                try {
                    in = new BufferedReader(new InputStreamReader(i.getInputStream()));
                    String tekst;
                    String czas;
                    int time;
                    while (in.ready()) {
                        tekst = in.readLine();
                        czas = in.readLine();
                        time=Integer.parseInt(czas);
                        LocalTime myObj = LocalTime.now();
                        myObj=myObj.plusSeconds(time);
                        Wpis nowy= new Wpis(tekst,myObj,time,i);
                        map.put(myObj,nowy);
                    }
                    
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
            }
            try{
                Iterator<Map.Entry<LocalTime,Wpis>> it=(map.entrySet()).iterator();
                LocalTime actual = LocalTime.now();
                while(it.hasNext()) 
                {
                    Map.Entry<LocalTime,Wpis> wys=it.next();
                    Wpis inse=wys.getValue();
                    if (inse.czas.compareTo(actual)==1) break;
                    PrintWriter out = new PrintWriter(inse.klient.getOutputStream(), true);
                    out.println(inse.tekst);
                    inse.desc();
                    godz.add(inse.czas);
                }
                int i;
                for(i=0;i<godz.size();i++)
                {
                    map.remove(godz.get(i));
                }
                
            }catch(NullPointerException e){
                e.printStackTrace();
                continue;
            }catch(ConcurrentModificationException e)
            {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }

           }
        }
    }

  
        
    }

