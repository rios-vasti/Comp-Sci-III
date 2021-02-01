import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class November {
	
		public static void main(String[] args)
		{
				try
				{
					Scanner fin = new Scanner(new File("november.dat"));
					int n = fin.nextInt();
					fin.nextLine();
					
					
					for (int i = 0; i < n; i++)
					{
						int[][] square = new int[4][4];
								
						
						for (int x =0; x <4; x++)
						{	
							
							for (int y = 0; y < 4; y++)
							{
								square[x][y]= fin.nextInt();
							}
						
						
						}
					/*		for (int z = 0; z < 4; z++)
						{
							for (int a = 0; a < 4; a++)
								{
									System.out.print(square[z][a]); 
								 
								}
							System.out.println();
						}
						System.out.println();
					}
					*/
						int[] squareCheck = new int[10];
						int checkRow0=0;
						for (int q = 0; q < 4; q++ )
						{
							checkRow0= checkRow0 + square[0][q];
						}
						squareCheck[0]= checkRow0;
						
						int checkRow1=0;
						for (int w = 0; w < 4; w++ )
						{
							checkRow1= checkRow1 + square[0][w];
						}
						squareCheck[1]= checkRow1;
						
						int checkRow2=0;
						for (int q = 0; q < 4; q++ )
						{
							checkRow2= checkRow2 + square[0][q];
						}
						squareCheck[2]= checkRow2;
						
						int checkRow3=0;
						for (int q = 0; q < 4; q++ )
						{
							checkRow3= checkRow3 + square[0][q];
						}
						squareCheck[3]= checkRow3;
						
						int checkCol0=0;
						for (int q = 0; q < 4; q++ )
						{
							checkCol0= checkCol0 + square[q][0];
						}
						squareCheck[4]= checkCol0;
						
						int checkCol1=0;
						for (int q = 0; q < 4; q++ )
						{
							checkCol1= checkCol1 + square[q][0];
						}
						squareCheck[5]= checkCol1;
						
						int checkCol2=0;
						for (int q = 0; q < 4; q++ )
						{
							checkCol2= checkCol2 + square[q][0];
						}
						squareCheck[6]= checkCol2;
						
						int checkCol3=0;
						for (int q = 0; q < 4; q++ )
						{
							checkCol3= checkCol3 + square[q][0];
						}
						squareCheck[7]= checkCol3;
						
						int checkDiagonal=square[0][3]+square[1][2]+square[2][1]+square[3][0];
						squareCheck[8]= checkDiagonal;
					
						int checkDiagonal2=square[0][0]+square[1][1]+square[2][2]+square[3][3];
						squareCheck[9]= checkDiagonal2;
						
						boolean magicSquare = true;
						for (int f=0; f<9; f++)
						{if (squareCheck[f] != checkRow1)
							magicSquare= false;
						}
					
					if  (magicSquare==true) 
					{
						System.out.println("Magic"); 
					}
					else 
					{
						System.out.println("Not Magic"); 
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


