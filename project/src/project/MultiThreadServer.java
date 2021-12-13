package project;
import java.util.*; 
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.FileWriter;
import javafx.collections.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class MultiThreadServer extends Application {
	
	public static String sciezka ="C:\\serwer\\";
    static ArrayList<StorageHandler> handl =new ArrayList<StorageHandler>();
    static ArrayList<String> just =new ArrayList<String>(); 
    static ObservableList<StorageHandler> observableList = FXCollections.observableList(handl);
    static ObservableList<String> observableListString = FXCollections.observableList(just );
    static volatile boolean running=true;
    static volatile int uptodate=1;
    
    public static void main(String[] args) {
    	 
    		 maine moje = new maine();
             new Thread(moje).start();
             Akceptowanie akcept = new Akceptowanie();
             new Thread(akcept).start();
             launch(args);
             running=false;
    }
    Stage window;
    Scene scene1, scene2, scene3, scene4;
    static File selectedFile; 

    static Label label=new Label();
    @Override
    public void start(Stage primaryStage) {
   	 window = primaryStage;
  	
	 //Button 1
	 Button button1 = new Button("Display Clients");
	 
     //Button 2
     Button button2 = new Button("Back to menu");
     button2.setOnAction(e -> {
     	window.setScene(scene1);
     	});

  button1.setOnAction(e -> {
	 
	  TreeItem rootItem = new TreeItem("Klienci");
	  
	  synchronized(observableList) 
      { 
		  	Iterator<StorageHandler> iterator = observableList.iterator(); 
   	   		StorageHandler tmp;
   	   		String tekst;
   	   	int size=sciezka.length();
   	   while (iterator.hasNext())
   	   {
   		   tmp=iterator.next();
   		   File fileName = new File(sciezka+ "\\" +tmp.nazwa);
   		   File[] fileList = fileName.listFiles();
   		   String nowy;
   		   TreeItem webItem = new TreeItem(tmp.nazwa);
   		   for (File file: fileList) {
   			   nowy=file.toString();
   			 webItem.getChildren().add(new TreeItem(nowy.substring(size, nowy.length())));
   		   }
   		 rootItem.getChildren().add(webItem);
   	   }
      }
      TreeView treeView = new TreeView();
      treeView.setRoot(rootItem);

      treeView.setShowRoot(false);
      VBox vbox = new VBox(treeView,button2);

      Scene scene = new Scene(vbox);

      primaryStage.setScene(scene);

      primaryStage.show();
 
    	  
     });   
  
 
  	  //Layout 1 - children laid out in vertical column
  	 VBox layout1 = new VBox(20);
  	 layout1.getChildren().addAll( button1 , label);
  	 scene1 = new Scene(layout1, 600, 300);
  	 
     //Display scene 1 at first
     window.setScene(scene1);
     window.setTitle("Serwer");
     
     observableList.addListener(new ListChangeListener() {
  	    
         @Override
         public void onChanged(ListChangeListener.Change change) {
        	 button1.fire();
         }
     });
     observableListString.addListener(new ListChangeListener() {
 	    
         @Override
         public void onChanged(ListChangeListener.Change change) {
        	 button1.fire();
         }
     });
     
     window.show();
    }

    private static class Akceptowanie implements Runnable{
        

        @Override
        public void run() {
        	 ServerSocket server = null;
           while(running){
        	 try{   
             
        		 File folder = new File(sciezka);
               if(folder.mkdir()==false && folder.isDirectory()==false) 
               {
               	System.out.println(sciezka);
               	System.exit(0);		
               } 
        	   server = new ServerSocket(32000);
        	   server.setReuseAddress(true);
               while (running) {
            	     	  try{

                     		 
                              
                  String nazwa;
            	  Socket client = server.accept();
                   System.out.println("New client connected " + client.getInetAddress().getHostAddress());
                   BufferedReader in  = new BufferedReader(new InputStreamReader(client.getInputStream()));
                   nazwa=in.readLine();
                   folder = new File(sciezka+nazwa);
                   if(folder.mkdir()==false && folder.isDirectory()==false) 
                   {
                   	System.out.println("Klient: "+nazwa+"Nie zostanie obs³u¿ony" );
                   }
                   else { 
                	   Thread.sleep(1000);
                 	  Platform.runLater(new Runnable() {
                           @Override public void run() {
                    
                        	   synchronized(observableList) 
                               { 
                        		   observableList.add(new StorageHandler(client,nazwa));
                        		   uptodate=0;
                               }
                           }});
                          
                       
                   }
                    	  }catch(Exception e)
                    	  {
                    		  e.printStackTrace();
                    	  }
              }
           }catch(Exception e)
           {
        	   e.printStackTrace();
           }
           }

           }
        }

    private static class maine implements Runnable{
     

        @Override
        public void run() {
            ArrayList<Integer> indexy = new ArrayList<Integer>();
            
            
           while(running){
        	   
        	   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   synchronized(observableList) 
               { 
        	   Iterator<StorageHandler> iterator = observableList.iterator(); 
        	   StorageHandler tmp=null;
        	   if(uptodate==0)
        	   {
        		   while (iterator.hasNext())
            	   {
        			   Iterator<StorageHandler> iterator_v2 = observableList.iterator();
        			   tmp=iterator.next();
        			   PrintWriter out=null;
					try {
						out = new PrintWriter(tmp.klient.getOutputStream(), true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.println("klienci");
        			   while (iterator_v2.hasNext())
                	   {
        				   StorageHandler tmp_v2=null;
        				   tmp_v2=iterator_v2.next();
        				  if(tmp.nazwa.compareTo(tmp_v2.nazwa)!=0) out.println(tmp_v2.nazwa);
                	   
                	   }
        			   out.println("end");
            	   }
        		 uptodate=1;  
        	   }
        		    iterator = observableList.iterator(); 
        	  
        	   String tekst;
        	   int iner=0;
        	   while (iterator.hasNext())
        	   {
        		   tmp=iterator.next();
        		   try {
					BufferedReader in  = new BufferedReader(new InputStreamReader(tmp.klient.getInputStream()));
					int flaga=0;
			            while(in.ready())
	                   {
	                	   tekst=in.readLine();
	                		System.out.println(tekst);
	                	   while(tekst.compareTo("end")!=0 && tekst.compareTo("exit")!=0)
	                	   {
	                		   Platform.runLater(new Runnable() {
	                               @Override public void run() {
                			   observableListString.add("update");
	                               }});
                			   switch(tekst)
	                		   {
	                		   case "share":
	                			   
                				   String klient=in.readLine();
	                			   while(tekst.compareTo("end")!=0)
	                			   {
	                				   tekst=in.readLine();
	                				   Iterator<StorageHandler> iterator_v2 = observableList.iterator(); 
	                	        	   StorageHandler tmp_v2=null;
	                	        	   while (iterator_v2.hasNext())
	                	        	   {
	                	        		   tmp_v2=iterator_v2.next();
	                	        		   if(tmp_v2.nazwa.compareTo(klient)==0) {
	                	        			flaga=1;
	                	        			break;
	                	        		   }
	                	        	   }
	                	        	   if(flaga==0) break;
	                	        	   flaga=0;
	                	        	   PrintWriter out_v2 = new PrintWriter(tmp_v2.klient.getOutputStream(), true);
	                					FileWriter myWriter = new FileWriter(sciezka+ "\\" +klient+"\\" + tekst);
	                				
	                					out_v2.println("pliki");
	                					out_v2.println(tekst);
	                					tekst=in.readLine();
	                					while (tekst.compareTo("next")!=0)
	                					{
	                						 myWriter.write(tekst+System.lineSeparator());
	                						 out_v2.println(tekst);
	                						 tekst=in.readLine();
	                					}
	                					myWriter.close();
	                					out_v2.println("end");
	                					tekst=in.readLine();
	                					
	                			   }

	                			   break;
	                		   case "send":
	                			   tekst=in.readLine();
	                			   while(tekst.compareTo("end")!=0)
	                			   {
	                				   FileWriter myWriter = new FileWriter(sciezka+ "\\" +tmp.nazwa+"\\" + tekst);
		                			   tekst=in.readLine();
		                			   tekst=in.readLine();
		                			   while(tekst.compareTo("next")!=0)
		                			   {
		                				   myWriter.write(tekst+System.lineSeparator());
		                				   tekst=in.readLine();
		                			   }
		                			   myWriter.close();
		                			   tekst=in.readLine();
	                			   }

	                			   break;
	                		   case "del":
	                			   tekst=in.readLine();
	                			   while(tekst.compareTo("end")!=0)
	                			   {
	                			   File file = new File(sciezka+"\\" +tmp.nazwa+"\\"+tekst);
	                			   file.delete();
	                			   tekst=in.readLine();
	                			   }
	                			   break;
	                		 
	                		   }

		                	   
	                	   }

	                	   if (tekst.compareTo("exit")==0)
	                	   {
	                		    PrintWriter kk = new PrintWriter(tmp.klient.getOutputStream(), true);
	                		    kk.println("kk");

	                		    indexy.add(iner);
            					uptodate=0;  
	                            
	                		   break;
	                	   }
	                   }
        		   } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	   iner++;
        	   

                
        	   }
        	   Collections.sort(indexy);
               Collections.reverse(indexy);
               Platform.runLater(new Runnable() {
                   @Override public void run() {
                	
                	     
              
           	for (Integer i : indexy)
           	{
           	
           		observableList.remove(i.intValue());
       		
           	}
           	indexy.clear();
                   }});
               
               }
           
           }
            

           }
        }
    }

  
