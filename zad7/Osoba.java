class Osoba extends Wpis{
	String imie;
	String nazwisko;
	String adres;
	NrTelefoniczny eldo;
	public Osoba(String im,String na,String ad,NrTelefoniczny num){
		super(num);
		eldo=num;
		imie=im;
		nazwisko=na;
		adres=ad;
}
void opis(){
	System.out.println("Numer: +"+ nr.nrkierunkowy+ " "+ nr.nrTelefonu+" Imie i nazwisko: "+ imie + " "+ nazwisko+ " adres: " +adres );

}

}
