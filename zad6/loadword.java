import java.util.*;

public class loadword{

	Scanner input=new Scanner(System.in);
	private String[] wektor;
	private ArrayList<ArrayList<Integer> > lista ;
	
	
	public loadword(){	
		lista=new ArrayList<ArrayList<Integer> >(); 
		wektor=new String[2];
	}
	public void disp(int n){
		System.out.println(this.lista.get(n));
}
	
	public void loading(int n){
		System.out.println("Podaj: " + (n+1));
		this.wektor[n]=input.nextLine();
	}
	public void convert(int n){
	 ArrayList<Integer> temp= new ArrayList<>();
	String []arr = this.wektor[n].split(" ");
for (String str : arr) {
    temp.add(Integer.parseInt(str));   
		}
		lista.add(temp);
}
	public ArrayList <Integer> kopia(int n){
		return this.lista.get(n);
	}
	public void sumtingup() throws WektoryRoznejDlugosciException{

	int n1 = (lista.get(0)).size();
  	int n2 = (lista.get(1)).size();
	if (n1 != n2)
 {
	throw new WektoryRoznejDlugosciException(n1,n2);
 }
	
ArrayList<Integer> temp= new ArrayList<>();
	for (int i=0;i<n1;i++)
	{
	 
		temp.add((lista.get(0)).get(i)+(lista.get(1)).get(i))	;		
	}	
	lista.add(temp);

	}	



}


