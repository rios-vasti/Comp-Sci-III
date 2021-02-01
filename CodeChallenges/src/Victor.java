
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Victor
{
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("victor.dat"));
				int n = fin.nextInt();
				fin.nextLine();
				for (int i = 0; i < n; i++)
				{
					
					Stack<String> s = new Stack<String>(); 
			
					String currentLine = fin.nextLine();
					//splits the current line by spaces
					String[] arrayOfExpression = currentLine.split(" ");
					
					for (int y =0; y<arrayOfExpression.length; y++)
					{
						String temp= arrayOfExpression[y];
						if (temp.equals("*")  || temp.equals("/") || 
							temp.equals("+") || temp.equals("-") )
						{
							/*pops the last three items and 
							rearranges them by adding the 
							most bottom number the operator 
							and then the last number, this 
							added back to the stack as a 
							single string
							 */
							String top = s.pop();
							String  bottom= s.pop();
							String add = "("+ bottom + temp + top+")";
							s.push(add);
						
						}
						else 
						{
							s.push(temp);
						}
					
					}
					String answer = s.pop();
					System.out.println(answer);
					
				}
				fin.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
	}
}
