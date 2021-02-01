
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Romeo
{
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("romeo.dat"));
				
				String currentLine1 = fin.nextLine();
				String[] arrayOfBlocks1= currentLine1.split(" ");
				
				Stack<String> stackOfBlocks1 = new Stack<String>();
				for (int x=0; x<arrayOfBlocks1.length; x++)
				{
					stackOfBlocks1.push(arrayOfBlocks1[x]);
				}
				
				
				
				String currentLine2 = fin.nextLine();
				String[] arrayOfBlocks2= currentLine2.split(" ");
				
				Stack<String> stackOfBlocks2 = new Stack<String>();
				for (int x=0; x<arrayOfBlocks2.length; x++)
				{
					stackOfBlocks2.push(arrayOfBlocks2[x]);
				}	
				
				
				
				String currentLine3 = fin.nextLine();
				String[] arrayOfBlocks3= currentLine3.split(" ");
				
				Stack<String> stackOfBlocks3 = new Stack<String>();
				for (int x=0; x<arrayOfBlocks3.length; x++)
				{
					stackOfBlocks3.push(arrayOfBlocks3[x]);
				}
	
				
				
				int n = fin.nextInt();
				fin.nextLine();
				for (int i = 0; i < n; i++)
				{	
					int blocksMove= fin.nextInt();
					int from= fin.nextInt();
					int to= fin.nextInt();
					
					for (int y=0;y<blocksMove;y++)
					{
						if (from == 1)
						{
							if (to == 2)
							{
								stackOfBlocks2.push( stackOfBlocks1.pop());
							}
							
							if (to == 3)
							{
								stackOfBlocks3.push( stackOfBlocks1.pop());
							}
						}
						
						if (from == 2)
						{
							if (to == 1)
							{
								stackOfBlocks1.push( stackOfBlocks2.pop());
							}
							
							if (to == 3)
							{
								stackOfBlocks3.push( stackOfBlocks2.pop());
							}
						}
						
						if (from == 3)
						{
							if (to == 1)
							{
								stackOfBlocks1.push( stackOfBlocks3.pop());
							}
							
							if (to == 2)
							{
								stackOfBlocks2.push( stackOfBlocks3.pop());
							}
							
							
						}
					}
					
				for (int c=0;c<3;c++)
				{
					for (int f=0; f <stackOfBlocks1.size();f++)
					{
						System.out.println("{"+stackOfBlocks1.pop());
					}
				}
					
				}
				fin.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
	}
	
}
