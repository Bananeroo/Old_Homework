import java.io.*; 

public class FileSave{
	private Solution maine;
	private String filename;
	public FileSave(Solution vec, String name){
		maine=vec;
		filename=name;
	}
		
	public void saveVector() throws IOException{
		File file=new File(filename);
		FileOutputStream outs = new FileOutputStream(file);

		byte vec[] = maine.vectorToString().getBytes();
		outs.write(vec);
		outs.close();
	}

}
