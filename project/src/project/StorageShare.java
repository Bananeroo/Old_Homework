package project;

import java.io.File ;
public class StorageShare {
	StorageKlienci klient;
	File plik;

	public StorageShare(StorageKlienci klient, File plik){
        this.klient=klient;
        this.plik=plik;
}
void opis(){
	System.out.println("Plik: "+ plik.getName()+ " Klient: "+klient  );
}
void sciezka(){
	System.out.println(plik.getAbsolutePath() );
}
public File getPlik() {
    return plik;
}

public void setPlik(File plik) {
    this.plik=plik;
}

public StorageKlienci getKlient() {
    return klient;
}

public void StorageKlienci(StorageKlienci klient) {
    this.klient=klient;
}
}