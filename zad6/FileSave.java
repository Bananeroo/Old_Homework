import java.io.*; 
import java.util.*;

public class FileSave{
	private ArrayList<Integer> maine;
	private String filename;
	public FileSave(loadword vec, String name,int n){
		maine=vec.kopia(n);
		filename=name;
	}
		
	public void saveVector() throws IOException{
		File file=new File(filename);
		FileOutputStream outs = new FileOutputStream(file);
	String s="";
		for (int i=0;i<maine.size();i++)
{
		s+=String.valueOf(maine.get(i));
		s+=" ";
		
		
}
byte vec[] = s.getBytes();
		outs.write(vec);
		outs.close();
	}

}
