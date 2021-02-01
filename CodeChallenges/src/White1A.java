import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class White1A {
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("white1a.dat"));
				int n = fin.nextInt();
				fin.nextLine();
				
				for (int i = 0; i < n; i++)
				{
					String currentWords = fin.nextLine();
				
					for ( int x=0; x<currentWords.length(); x++ )
					{
						System.out.println(currentWords);
						currentWords = moveLeft (currentWords);
						
						
					}
					System.out.println(" " );
				}
				fin.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
	}
	
	public static String moveLeft (String currentWords)
	{
		
			String firstLetter =  currentWords.substring(0, 1);
			String restOfLetters = currentWords.substring(1);
			String newCurrentWord =  restOfLetters + firstLetter;
			
		return newCurrentWord;
		
	}
}

