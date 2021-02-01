import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class White3A 
{
	
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("white3a.dat"));
				int n = fin.nextInt();
				fin.nextLine();
				
				for (int count = 0; count < n; count++)
				{
				
					String currentLine = fin.nextLine();
					String lower = currentLine.toLowerCase();
					String a =lower.replaceAll("a","A");
					String e =a.replaceAll("e","E");
					String i =e.replaceAll("i","I");
					String o =i.replaceAll("o","O");
					String u =o.replaceAll("u","U"); 
					
					
					
					System.out.println(u);  
					
						
				}
				
				fin.close();
			  }
				
			
			
		catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	
	
}
