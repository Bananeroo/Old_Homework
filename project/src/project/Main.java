package project;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File ;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.collections.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Main extends Application {

    Stage window;
    static ArrayList<StorageAndValidate> handl = new ArrayList<StorageAndValidate>();
    static ArrayList<StorageKlienci> klienci = new ArrayList<StorageKlienci>();
    static ArrayList<StorageShare> share = new ArrayList<StorageShare>();
    static ObservableList<StorageKlienci> obsklienci = FXCollections.observableList(klienci);
    static ObservableList<StorageAndValidate> observableList = FXCollections.observableList(handl);
    static Socket socket;
    static PrintWriter out;
    static BufferedReader in;
    static String sciezka;
    static volatile boolean running=true;
    static volatile boolean running1=true;
    static int size;
    static int uptodate=0;
    static String nazwa;
    
    public static void main(String[] args) throws FileNotFoundException {
    	
    	sciezka=args[0];
    	String content = new Scanner(new File(sciezka)).useDelimiter("\\Z").next();
    	System.out.println(content);
        }
    	
    Scene scene1, scene2, scene3, scene4;
    static ChoiceBox choiceBox = new ChoiceBox();
    static File selectedFile; 
    static int scena=0;
    static Label label=new Label();
  	
    @Override
    public void start(Stage primaryStage) {
    	 window = primaryStage;
     	
    	 FileChooser fileChooser = new FileChooser();
    	   Button akc = new Button("Share");
    	   
		      
      	 akc.setOnAction(e -> {
            	getChoice(choiceBox);
            	choiceBox = new ChoiceBox();
            	
             	window.setScene(scene1);
             	scena=0;
            	});
      
    	 
    	 //Button 1
    	 Button button1 = new Button("Display Files");
    	 
         //Button 2
         Button button2 = new Button("Back to menu");
         button2.setOnAction(e -> {
        	 scena=0;
           	
         	window.setScene(scene1);
         	});
           //Button 3
    	 Button button3 = new Button("Share Files");
    	 button3.setOnAction(e -> {
    		 scena=3;
    		 selectedFile = fileChooser.showOpenDialog(primaryStage);
    		 if(selectedFile==null)  button2.fire();
    		 else 
    		 {
    		        HBox hbox = new HBox(choiceBox,akc,button2);
    		        for (StorageKlienci i: obsklienci)
    		        {
    		        	choiceBox.getItems().add(i.nazwa);
    		        }
    		        Scene scene = new Scene(hbox, 600, 200);
    		        primaryStage.setScene(scene);
    		        primaryStage.show();
    		 }
    	   });
    	 
    	//Button 4
         Button button4 = new Button("Back to menu");
         button4.setOnAction(e -> {
        	 scena=0;
         	window.setScene(scene1);
           });
       //Button 5
         Button button5 = new Button("Klienci");
        
         

    
      button1.setOnAction(e -> {
    	 
    	  TableView tableView = new TableView();
        	 tableView.setPlaceholder(new Label("No file to display"));
        	 
        	 TableColumn<String, StorageAndValidate> column1 = new TableColumn<>("Plik");
        	     column1.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        	    
        	    tableView.getColumns().add(column1);
        	
        	    for(StorageAndValidate i: observableList)
        	    {
        	    	tableView.getItems().add(i);
        	    }
       
        	    VBox vbox = new VBox(button2,tableView);
        	    Scene scene = new Scene(vbox,600,300);
        
        	    primaryStage.setScene(scene);
        	    scena=1;
        	  
         });   
      
      button5.setOnAction(e -> {
     	 
    	  TableView tableView = new TableView();
        	 tableView.setPlaceholder(new Label("No clients to display"));
        	 
        	 TableColumn<String, StorageKlienci> column1 = new TableColumn<>("Klienci");
        	  column1.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        	    
        	    tableView.getColumns().add(column1);
        	    for(StorageKlienci i: obsklienci)
        	    {
        	    	tableView.getItems().add(i);
        	    }
       
        	    VBox vbox = new VBox(button2,tableView);
        	    Scene scene = new Scene(vbox,600,300);
        
        	    primaryStage.setScene(scene);
        	    scena=2;
        	  
         });   
      
      	  //Layout 1 - children laid out in vertical column
      	 VBox layout1 = new VBox(20);
      	 layout1.getChildren().addAll( button1, button3,button5, label);
      	 scene1 = new Scene(layout1, 600, 300);
      	 
         

         //Layout 3
         StackPane layout3 = new StackPane();
         layout3.getChildren().addAll(button4);
         scene3 = new Scene(layout3, 600, 300);

         
         //Display scene 1 at first
         window.setScene(scene1);
         window.setTitle(nazwa);
         
         obsklienci.addListener(new ListChangeListener() {
     	    
             @Override
             public void onChanged(ListChangeListener.Change change) {
               	 if (scena==2) button5.fire();
             }
         });
         
         observableList.addListener(new ListChangeListener() {
        	    
             @Override
             public void onChanged(ListChangeListener.Change change) {
            	 if (scena==1)button1.fire();
             }
         });
         
         window.show();
     
    }
    private void getChoice(ChoiceBox<String> choiceBox) {

    	if (choiceBox.getValue()!=null) share.add(new StorageShare(new StorageKlienci(choiceBox.getValue()),selectedFile));
    
    }
    
    
    private static class sending implements Runnable{
       
        public sending() {
            
        }

        @Override
        public void run() {
            while(running)
            {
                try{
                	ArrayList<StorageCzas> nazwy = new ArrayList<StorageCzas>();
                	ArrayList<Integer> indexy = new ArrayList<Integer>();
                   
                	Platform.runLater(new Runnable() {
                        @Override public void run() {
                        	try{
                         		int iner=0;
                        	//Dodawanie do listy dodanych plików.
                        	File fileName = new File(sciezka);
                            File[] fileList = fileName.listFiles();
                            String tmp;
                            long mody;
                            for (File file: fileList) {  
                                tmp=file.toString();
                                tmp=tmp.substring(size, tmp.length());
                                mody = file.lastModified();
                                for(StorageAndValidate i: observableList)
                        	    {
                               	 	if(i.nazwa.compareTo(tmp)==0) {
                               	 		if(i.mody<mody)
                               	 		{
                               	 			i.wys=0;
                               	 			i.mody=mody;
                               	 		}
                               	 		
                               	 		iner=-1;break;
                               	 	}
                                }
                              
                                if(iner!=-1) nazwy.add(new StorageCzas(tmp,file.lastModified()));
                            iner=0;
                            }
                        	for(StorageCzas i: nazwy)
                        	{
                        		observableList.add(new StorageAndValidate(i.nazwa,i.mody));  
                        		uptodate=0;
                        	}
                        	nazwy.clear();
                        	//Usuwanie z listy usuniêtych plików
                            iner=0;
                        	int flag=0;
                            for(StorageAndValidate i: observableList)
                    	    {
                        		for (File file: fileList) {  
                                    tmp=file.toString();
                                    tmp=tmp.substring(size, tmp.length());
                                    if(i.nazwa.compareTo(tmp)==0) {flag=1;break;}
                            	}
                        	if(flag==0) {indexy.add(iner);}
                    		iner++;
                    		flag=0;
                    		}
                            Collections.sort(indexy);
                            Collections.reverse(indexy);
                             if(indexy.isEmpty()==false)
                            {
                            	out.println("del");
                            	for (Integer i : indexy)
                            	{
                            		out.println(observableList.get(i.intValue()).nazwa);
                            	}
                            	out.println("end");
                            }
                             for(Integer i: indexy)
                         	{
                         		observableList.remove(i.intValue());  
                         	}
                            
                            indexy.clear();
                            //Sprawdzanie czy wszystkie zostaly wyslane.
                            for(StorageAndValidate i: observableList)
                    	    {
                            	
                            	if(i.wys==0) { uptodate=0;break;}          	    
                    	    }
                            //Wysy³anie
                   
                            if(uptodate==0) {
                            	out.println("send");

                            for(StorageAndValidate i: observableList)
                    	    {
                            	if (i.wys==1) continue;
                            	
                            		  File myObj = new File(sciezka+ "\\" +i.nazwa);
                            	      Scanner myReader = new Scanner(myObj);
                            	      out.println(i.nazwa);
                            	      out.println(i.mody);
                            	      while (myReader.hasNextLine()) {
                            	        String data = myReader.nextLine();
                            	       out.println(data);
                            	      }
                            	      out.println("next");
                            	      myReader.close();
                            	      
                            	   
                            	i.wys=1;
                    	    }
                            out.println("end");
                            uptodate=1;
                            }
                             //Czytanie
                            String tekst;
                            String mody1;
                          
								while(in.ready()) {
									tekst=in.readLine();
									if (tekst.compareTo("klienci")==0)
									{
										obsklienci.clear();
										
										tekst=in.readLine();
										while(tekst.compareTo("end")!=0)
										{
											obsklienci.add(new StorageKlienci(tekst));
											tekst=in.readLine();
										}
									}
									else if (tekst.compareTo("pliki")==0)
									{
										tekst=in.readLine();
										String gor=tekst;
										FileWriter myWriter = new FileWriter(sciezka+ "\\" +tekst);
										
										StorageAndValidate nowy= new StorageAndValidate(tekst,0);
										nowy.wys=1;
										
										tekst=in.readLine();
									     while(tekst.compareTo("end")!=0)
										{
									    	 myWriter.write(tekst+System.lineSeparator());
									    	 tekst=in.readLine();
									    }
									     myWriter.close();
									     File myObj = new File(sciezka+ "\\" +gor);
									     nowy.mody=myObj.lastModified();
									     observableList.add(nowy);
									}
									
								}
							
                            //Share
                            if(share.isEmpty()==false)
                            {
                            	out.println("share");
                              for(StorageShare i: share)
                              {
                            	  File myObj = new File(i.plik.getAbsolutePath());
                          	      Scanner myReader = new Scanner(myObj);
                          	      out.println(i.klient.nazwa);
                          	      out.println(myObj.getName());
                          	      
                          	      while (myReader.hasNextLine()) {
                          	        String data = myReader.nextLine();
                          	       out.println(data);
                          	      }
                          	      out.println("next");
                          	      myReader.close();
                              }
                              share.clear();
                              out.println("end");
                           	 	
                            }
                            
                        }catch(IOException e){
                            e.printStackTrace();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        
                        }
                    });
                	 Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            out.println("exit");
            try {
				while(in.readLine().compareTo("kk")!=0) {}
				
				running1=false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        }
    }
}






