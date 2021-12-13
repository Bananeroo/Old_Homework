class StorageAndValidate {
	String tekst;
	String czas;
    int intczas;
	public StorageAndValidate(){
        tekst="No.1";
        czas="No.2";
        intczas=420;
}
void opis(){
	System.out.println("Tekst: "+ tekst+ " czas w wersji string: "+ czas+ " czas w int: "+intczas );

}
public void convert(){
    intczas=Integer.parseInt(czas);

}
public void validatetext() throws TekstNieprawidlowyException{
    if (tekst.length()==0 || tekst.replaceAll("\\s+","").length()==0)
    {
       throw new TekstNieprawidlowyException(tekst);
    }
    
}

public void validateczas() throws CzasNieprawidlowyException{
if (intczas <=0)
{
   throw new CzasNieprawidlowyException(intczas);
}
}
}