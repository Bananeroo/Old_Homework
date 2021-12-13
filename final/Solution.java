import java.util.*;  // Import the Scanner class

public class Solution{

	static Scanner input=new Scanner(System.in);
	
	private int numOfVec;
	private boolean sum;
	private ArrayList<Integer> fullVec;
	private ArrayList<ArrayList<Integer>> vecOfVec;

	public Solution(int numberOfVectors){
		sum= false;
		numOfVec=numberOfVectors;
		fullVec = new ArrayList<>();
		vecOfVec = new ArrayList<>();
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

	public void sumVec() throws WektoryRoznejDlugosciException{

	int size=-1;
	for(ArrayList<Integer> v: vecOfVec){
		if(size==-1)
			size=v.size();
		if(size !=v.size()){
			sum=false;
				throw new WektoryRoznejDlugosciException(size,v.size()," wektory");
		}
	}

	ArrayList<Integer> nvec=new ArrayList<Integer>();
	int guard=1;
	for(ArrayList<Integer> v: vecOfVec){
		
	if (guard==1)
{
		for (int i=0;i<v.size();i++)
	{
		nvec.add(0);
	}
guard=0;
}
		for (int i=0;i<v.size();i++)
	{
		nvec.set(i, nvec.get(i)+v.get(i));
	}
	}
		fullVec = nvec;
		sum = true;
		
}

public void displayFullVec(){
	if(sum)
		System.out.println(fullVec);
}

public void enterAndAddInputValue(){
	sum = false;
	for(int i=0; i<numOfVec; i++){
		System.out.println("Podaj" + (i+1) + "/" + numOfVec+ ":");
		String line=input.nextLine();
		getNumersFromText(line);
	}
}
public String vectorToString(){
	String s="";
	for(int i: fullVec)
		s+=i+" ";
	return s;
}
}
