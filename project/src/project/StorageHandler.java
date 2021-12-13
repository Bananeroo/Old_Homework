package project;

import java.net.Socket;

public class StorageHandler {
	Socket klient;
	String nazwa;

	public StorageHandler(Socket klient, String nazwa){
        this.klient=klient;
        this.nazwa=nazwa;
}
void opis(){
	System.out.println(" Klient: "+nazwa  );
}

public String getNazwa() {
    return nazwa;
}

public void setNazwa(String nazwa) {
    this.nazwa=nazwa;
}

}