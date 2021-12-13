
public class Main{

	public static void main(String[] args){
	int n=0;
	try{
		n= Integer.parseInt(args[0]);
	}catch(NumberFormatException e){
		e.printStackTrace();
		return;
	}
	catch(Exception e){
		e.printStackTrace();
	}

		Solution obj = new Solution(n);
		while (true){
			
			obj.enterAndAddInputValue();
			try {
				obj.sumVec();
				obj.displayFullVec();

				FileSave fs= new FileSave(obj, "wector.txt");
				fs.saveVector();
				break;
				} catch (WektoryRoznejDlugosciException e){
					System.out.println(e.getMessage());
					e.printStackTrace();
				} catch(Exception e){
					e.printStackTrace();
				}
			obj = new Solution(n);
			}
		}
	}
