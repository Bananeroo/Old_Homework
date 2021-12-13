package project;
public class StorageAndValidate {
	String nazwa;
    int wys;
    long mody;
	public StorageAndValidate(String name,long mody){
        nazwa=name;
        wys=0;
        this.mody=mody;
}
void opis(){
	System.out.println("Plik: "+ nazwa+ " Wyslany?: "+ wys );

}
public String getNazwa() {
    return nazwa;
}

public void setNazwa(String firstName) {
    this.nazwa = firstName;
}

public int getWys() {
    return wys;
}
}