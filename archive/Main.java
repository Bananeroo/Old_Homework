import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

class HelloWorldApp {
    public static void main(String[] args) {
        //System.out.println("Hello World!"); // Display the string
/*

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}


*/


int ra = ThreadLocalRandom.current().nextInt(0, 555);
System.out.println(ra);
int odp=-1;
while( odp!= ra)
{
System.out.println("dej liczbe");
Scanner sc = new Scanner(System.in);
int i = sc.nextInt();
	if(i<ra)
{
System.out.println("malo");

}
else if (i>ra)
{
System.out.println("duzo");

}
else {
break;
}
}
System.out.println("jack pot");


/*
System.out.println(args.length);
int[] tab = new int[3];
if(args.length<3 || args.length>3)
{
System.out.println("Elo za mało,za duzo");

}
else
{

for( int i=1; i<3; i++)
{
try {
 tab[i-1] = Integer.parseInt(args[i]);
}
catch (NumberFormatException e)
{
System.out.println("Not a number");
System.exit(0);
}

}
String elo = args[0];
System.out.println(elo.substring(tab[0], tab[1]+1));

}
 for (int i = 0; i < args.length; i++)
            System.out.println("args[" + i + "]: " + args[i]);
    }	


int foo=12;
String myString = "1234";
 
System.out.println(foo);
foo=foo+12;
System.out.println(foo);

*/


 }
}

