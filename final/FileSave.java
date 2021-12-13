import java.io.*; 

public class FileSave{
	private Solution obj;
	private String filename;
	public FileSave(Solution v, String fn){
		obj=v;
		filename=fn;
	}
		
	public void saveVector() throws IOException{
		File file=new File(filename);
		FileOutputStream outs = new FileOutputStream(file);

		byte vec[] = obj.vectorToString().getBytes();
		outs.write(vec);
		outs.close();
	}

}
