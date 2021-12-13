import java.util.Scanner; 
import java.util.ArrayList;

public class Solution{

	static Scanner input=new Scanner(System.in);
	
	private int ilosc;
	private boolean sum;
	private ArrayList<Integer> vecend;
	private ArrayList<ArrayList<Integer>> vecOfVec;

	public Solution(int numberOfVectors){
		sum= false;
		ilosc=numberOfVectors;
		vecend = new ArrayList<>();
		vecOfVec = new ArrayList<>();
	}


	public void sumVec() throws WektoryRoznejDlugosciException{

	int size=-1;
	for(ArrayList<Integer> nowy: vecOfVec){
		if(size==-1)
			size=nowy.size();
		if(size !=nowy.size()){
			sum=false;
				throw new WektoryRoznejDlugosciException(size,nowy.size()," wektory roznej dlugosci" + size+ " " + nowy.size());
		}
	}

	ArrayList<Integer> nvec=new ArrayList<Integer>();
	int guard=1;
	for(ArrayList<Integer> nowy: vecOfVec){
		
	if (guard==1)
{
		for (int i=0;i<nowy.size();i++)
	{
		nvec.add(0);
	}
guard=0;
}
		for (int i=0;i<nowy.size();i++)
	{
		nvec.set(i, nvec.get(i)+nowy.get(i));
	}
	}
		vecend = nvec;
		sum = true;
		
}

	private void getNumersFromText(String line){
		ArrayList<Integer> values= new ArrayList<>();
		String[] splited= line.split(" ",0);
		for(String str : splited){
			try{
				values.add(Integer.parseInt(str));
			} catch (Exception e){
					e.printStackTrace();
			}
		}
		vecOfVec.add(values);
	}
public void displayvecend(){
	if(sum)
		System.out.println(vecend);
}

public void loadword(){
	sum = false;
	for(int i=0; i<ilosc; i++){
		System.out.println("Podaj" + (i+1) + "/" + ilosc+ ":");
		String line=input.nextLine();
		getNumersFromText(line);
	}
}
public String vectorToString(){
	String s="";
	for(int i: vecend)
		s+=i+" ";
	return s;
}
}
