class WektoryRoznejDlugosciException extends Exception{

	private int s1;
  private int s2;
	private String eldo; 
  public WektoryRoznejDlugosciException(int size1,int size2, String info){
	eldo=info;
	s1=size1;
	s2=size2;
}
public int get1()
{
	return s1;
}
}
