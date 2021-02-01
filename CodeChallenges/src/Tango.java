import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Stack;


public class Tango {
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("tango.dat"));
				int n = fin.nextInt();
				fin.nextLine();
				for (int i = 0; i < n; i++)
				{
					String currentLine1 = fin.nextLine();
					String[] venn1= currentLine1.split(" ");
					Set<String> setVenn1 = new TreeSet<String>();
					
					for (int y=0; y< venn1.length; y++)
					{
						setVenn1.add(venn1[y]);
					}
					
					
					String currentLine2 = fin.nextLine();
					String[] venn2= currentLine2.split(" ");
					Set<String> setVenn2 = new TreeSet<String>();
					
					for (int y=0; y< venn2.length; y++)
					{
						setVenn2.add(venn2[y]);
					}
					
					Set<String> both = new TreeSet<String>();
					
					for (int x=0; x< venn1.length; x++)
					{
						if (setVenn2.contains(venn1[x]))
						{
							both.add(venn1[x]);
							setVenn1.remove(venn1[x]);
							setVenn2.remove(venn1[x]);
						}
						
					}
					
					System.out.println("A: "+ setVenn1.toString());
					System.out.println("B: "+ setVenn2.toString());
					System.out.println("BOTH: "+ both.toString());
					System.out.println(" ");

				}
				fin.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
	}

}


