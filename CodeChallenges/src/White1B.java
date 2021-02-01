
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class White1B
{
	
	public static void main(String[] args)
	{
		try
		{
			ArrayList <Integer> nums = new ArrayList <Integer>();

			Scanner finb = new Scanner(new File("white1b.dat"));
			
			while (finb.hasNextInt())
			{
					nums.add(finb.nextInt());	
				
			}
			
			sortList(nums);
			System.out.println(findMedian(nums));
			
			finb.close();
		}
				
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
	}
	
	public static void sortList(ArrayList<Integer> a)
	{
		int swap= 1;
		while (swap > 0 )
		{
			swap = 0;
			for (int i =0; i< (a.size()-1); i++)
			{
				if (a.get(i) > a.get(i+1))
				{
					int temp = a.get(i);
					a.set(i,  a.get(i+1));
					a.set(i +1, temp );
					swap ++;
				}
				
			}
		}
			
		
	}
	public static int findMedian( ArrayList<Integer> b)
	{
		
		return b.get(b.size()/2);
	}
}
