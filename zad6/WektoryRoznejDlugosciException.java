class WektoryRoznejDlugosciException extends Exception{

	private int s1;
  	private int s2; 
public WektoryRoznejDlugosciException(int n1,int n2){

	s1=n1;
	s2=n2;
}
public int gets1(){
	return s1;
}
public int gets2(){
	return s2;
}

}
