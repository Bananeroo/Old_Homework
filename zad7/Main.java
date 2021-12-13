import java.io.*; 
import java.util.*; 
  
class Main { 
    public static void main(String[] args) 
    {
        NrTelefoniczny telefon1=new  NrTelefoniczny(10,123456789);
        NrTelefoniczny telefon2=new  NrTelefoniczny(20,649201693);
        NrTelefoniczny telefon3=new  NrTelefoniczny(30,134958603);
        NrTelefoniczny telefon4=new  NrTelefoniczny(30,683927693);
        NrTelefoniczny telefon5=new  NrTelefoniczny(50,254245332);
        NrTelefoniczny telefon6=new  NrTelefoniczny(60,246235662);
        Osoba osoba1 =new Osoba("Mateusz","Banaszkiewicz","Łódź",telefon1);    
        Osoba osoba2 =new Osoba("Kamil","Kowalski","Warszawa",telefon4);    
        Osoba osoba3 =new Osoba("Przemek","Guzicki","Krakau",telefon3);    
        Firma firma1 =new Firma("DMCS","Łódź",telefon2);    
        Firma firma2 =new Firma("Tartak","Warszawa",telefon5);    
        Firma firma3= new Firma("Stocznia","Gdańsk",telefon6);    
                
    TreeMap<NrTelefoniczny,Wpis> map=new TreeMap<NrTelefoniczny,Wpis>();

    map.put(osoba1.nr,osoba1);
    map.put(osoba2.nr,osoba2);
    map.put(osoba3.nr,osoba3);
    map.put(firma1.nr,firma1);
    map.put(firma2.nr,firma2);
    map.put(firma3.nr,firma3);
    
    Iterator<Map.Entry<NrTelefoniczny,Wpis>> it=(map.entrySet()).iterator();
    int i=0;

    for (i=0;i<6;i++){
        Map.Entry<NrTelefoniczny,Wpis> maine=it.next();
        Wpis inse=maine.getValue();
        inse.opis();
        
    }




    }
} 
