class NrTelefoniczny implements Comparable<NrTelefoniczny>{

	int nrkierunkowy;
	int nrTelefonu;
	
	public NrTelefoniczny(int kier,int tel)
{
	this.nrkierunkowy=kier;
	this.nrTelefonu= tel;
}
	public NrTelefoniczny kopia()
{
	return this;	
}
	public int compareTo(NrTelefoniczny maine){
		if(this.nrkierunkowy >  maine.nrkierunkowy) return  1;
		if(this.nrkierunkowy <  maine.nrkierunkowy) return -1;
		if(this.nrTelefonu   == maine.nrTelefonu)	return  0;
		if(this.nrTelefonu	 <  maine.nrTelefonu)	return -1;
		else return 1;
}
}
