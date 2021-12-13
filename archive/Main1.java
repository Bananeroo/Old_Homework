
public class Main{

	public static void main(String[] args){
	int n=0;
	try{
		n= Integer.parseInt(args[0]);
	}catch(NumberFormatException exc){
		exc.printStackTrace();
		return;
	}
	catch(Exception exc){
		exc.printStackTrace();
	}

		Solution maine = new Solution(n);
		while (true){
			
			maine.loadword();
			try {
				maine.sumVec();
				maine.displayvecend();

				FileSave save= new FileSave(maine, "wector.txt");
				save.saveVector();
				break;
				} catch (WektoryRoznejDlugosciException exc){
					System.out.println(exc.getMessage());
					
				} catch(Exception exc){
					exc.printStackTrace();
				}
			maine = new Solution(n);
			}
		}
	}
