import java.time.LocalTime;
import java.net.Socket;
class Wpis{
    String tekst;
    LocalTime czas;
    int offset;
    Socket klient;
    Boolean flag;
	public Wpis(String a,LocalTime time,int b,Socket c){
        tekst=a;
        czas=time;
        offset=b;
        klient=c;
        flag=false;
}
public void desc(){
    System.out.println("Wiadomość: "+ tekst+ " została odesłana o: "+ czas);
}
}