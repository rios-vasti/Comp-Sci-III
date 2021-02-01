import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class White2A {
	
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("white2a.dat"));
				int n = fin.nextInt();
				fin.nextLine();
				
				for (int i = 0; i < n; i++)
				{
					String currentLine = fin.nextLine();
					
		
					String[] arrayOfWords = currentLine.split(" ");
				//	String[] backardsOfWords= { " ", " ", " "};	
					
//					System.out.println(Arrays.toString(arrayOfWords));

//					for (String a : arrayOfWords) 
//				            System.out.println(a); 
					
					for (int x = 0; x<arrayOfWords.length/2; x++)
					{
						String temp = arrayOfWords[x];
						arrayOfWords[x] = arrayOfWords[arrayOfWords.length-x-1];
						arrayOfWords[arrayOfWords.length - x - 1] = temp;
					}
					
//					System.out.println("------------------");
//						System.out.println(Arrays.toString(arrayOfWords));
					for (String b : arrayOfWords) 
			            System.out.print(b + " "); 
					
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
