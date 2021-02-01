import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example
{
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("example.dat"));
				int n = fin.nextInt();
				fin.nextLine();
				for (int i = 0; i < n; i++)
				{
					System.out.println("I like " + fin.nextLine() + "!");
				}
				fin.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
	}
}
