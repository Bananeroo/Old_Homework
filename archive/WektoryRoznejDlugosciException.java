class WektoryRoznejDlugosciException extends Exception{

	private int s1;
  private int s2;
  public WektoryRoznejDlugosciException(int size1,int size2, String info){
	super(info);
	size1=s1;
	size2=s2;
}

}
