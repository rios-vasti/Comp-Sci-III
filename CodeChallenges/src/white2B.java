
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class white2B {
	
	public static void main(String[] args)
	{
			try
			{
				Scanner fin = new Scanner(new File("white2b.dat"));
				int n = fin.nextInt();
				fin.nextLine();
				
				for (int i = 0; i < n; i++)
				{
					
					String[] nums  = fin.nextLine().split(" ");
					int base = Integer.parseInt(nums[0],10);
					int x =  Integer.parseInt(nums[1],base);
					int y = Integer.parseInt(nums[2],base);
					
					
						System.out.println(x + " + "+ y+ " = " +(x+y));
						
				}
				
				fin.close();
			  }
				
			
			
		catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	
}
