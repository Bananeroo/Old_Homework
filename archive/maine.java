
public class Main{

	public static void main(String[] args){
		if(args.length < 1){
			System.out.println("Brak argumentow funkcji main");
			return;
		}
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
				obj.concatenateSameSizeVec();
				obj.displayFullVec();

				FileSave fs= new FileSave(obj, "vector.txt");
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
