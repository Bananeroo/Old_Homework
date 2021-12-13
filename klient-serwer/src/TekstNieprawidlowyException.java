class TekstNieprawidlowyException extends Exception{

	private String s;
public TekstNieprawidlowyException(String a){
    s=a;
}
public String get(){
	return s;
}
public void desc(){
	System.out.println("Podany tekst: "+ s +" jest błędny.");
}

}