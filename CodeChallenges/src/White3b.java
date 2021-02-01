import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class White3b {
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("white3b.dat"));
				int n = fin.nextInt();
				fin.nextLine();
				
				
				for (int i = 0; i < n; i++)
				{
					int LineL= fin.nextInt();
					fin.nextLine();
					String[][] myArray = new String[LineL][LineL];
							
					
					for (int x = LineL-1; x >= 0; x--)
					{	String currentLine = fin.nextLine();
						String[] arrayOfWords = currentLine.split(" ");
						
						for (int y = 0; y < LineL; y++)
						{
							myArray[y][x]= arrayOfWords[y];
						}
					
					
					}
					for (int z = 0; z < LineL; z++)
					{
						for (int a = 0; a < LineL; a++)
							{
								System.out.print(myArray[z][a]); 
							 
							}
						System.out.println();
					}
					System.out.println();
				}
				
				
				fin.close();
			  }
				
			
			
		catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	
}
