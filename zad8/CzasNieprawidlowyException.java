class CzasNieprawidlowyException extends Exception{

	private int s;
public CzasNieprawidlowyException(int a){
    s=a;
}
public int get(){
	return s;
}
public void desc(){
	System.out.println("Podany czas: "+ s +" jest błędny.");
}

}