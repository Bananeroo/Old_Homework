import java.io.*;
public class Main{

	public static void main(String[] args){
	
    while(true)    {
    loadword load=new loadword();
	int n=-1;

	while (n<1){	
	n++;	
	load.loading(n);
	try {
			load.convert(n);
	
	}catch ( NumberFormatException exc){
		n--;
		System.out.println(exc);
	}catch ( Exception exc){
		n--;
		System.out.println(exc);
	}
	}
	try{
		load.sumtingup();
	
	}catch(WektoryRoznejDlugosciException exc){
		System.out.println("Dlugosc pierwszego to "+ exc.gets1() + " a drugiego: "+ exc.gets2());

	continue;
}

load.disp(2);

try{
FileSave fs= new FileSave(load, "wector.txt",2);
fs.saveVector();
}catch(IOException exc)
{
	System.out.println(exc);
}catch(Exception exc)
{
	System.out.println(exc);
}

break;
    }
  
}
}

