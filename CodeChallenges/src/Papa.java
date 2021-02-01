import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collection;


public class Papa
{
	
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("papa.dat"));
				int[][] matrix = new int[10][20];
				for (int i=0; i<10; i++)
				{
					for (int x=0; x<20; x++)
					{
						matrix[i][x]= fin.nextInt();
					}
					//fin.nextLine();
				}
				
				/*	for (int z = 0; z < 10; z++)
				{
					for (int a = 0; a < 20; a++)
						{
							System.out.print(matrix[z][a]); 
						 
						}
					System.out.println();
				}
				System.out.println();
				*/
				int n = fin.nextInt();
				fin.nextLine();
				
				for (int count = 0; count < n; count++)
				{
					int findSum = fin.nextInt();
				
					int row = 0;
					int col = 0;
					
					/*searches through all the rows 
					of the original matrix -2
					*/
					for (int z = 0; z < 8 ; z++) 
					{
						/*searches through all the columns 
						of the original matrix -2
						*/
						for (int a = 0; a < 18; a++)	
						{
							int sum = 0;
							
							/*at a position of the original 
							 matrix it searches the 2 rows after
							*/
							for (int i=z; i<z+3; i++) 
							{
								/*at a position of the original 
								matrix it searches the 2 columns 
								after
								*/
								for (int x=a; x<a+3;x++)
								{	/*last two for loops 
									create a subMatrix of 3x3 
									*/
									
									 /*adds the positions of 
									  all the subMatrix
									*/
									sum = sum + matrix[i][x];
								}
							}
							/*checks to see if the sum found 
							 of the subMatrix at this 
							 location matches the findSum
							 */
							if (sum == findSum)
							{
								row = z;
								col = a; 
							}
						 
						}
						
					}
					
					System.out.println("(" + row +", " + col +")");
				}
				
				fin.close();
			  }
				
			
			
		catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	
	
}

