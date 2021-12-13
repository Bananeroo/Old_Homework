class Firma extends Wpis{
	String nazwa;
	String adres;

	public Firma(String na,String ad,NrTelefoniczny num){
		super(num);
		nazwa=na;
		adres=ad;
}
void opis(){
	System.out.println("Numer: +"+ nr.nrkierunkowy+ " "+ nr.nrTelefonu+" Nazwa: "+ nazwa + " adres: " +adres );

}

}
