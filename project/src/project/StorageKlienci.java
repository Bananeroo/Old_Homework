package project;
public class StorageKlienci {
	String nazwa;
	public StorageKlienci(String name){
        nazwa=name;
}
void opis(){
	System.out.println("Plik: "+ nazwa );

}
public String getNazwa() {
    return nazwa;
}

public void setNazwa(String firstName) {
    this.nazwa = firstName;
}

}