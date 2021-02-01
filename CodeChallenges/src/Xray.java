

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
	
public class Xray {
		public static void main(String[] args)
		{
				try
				{
					Scanner fin = new Scanner(new File("Xray.dat"));
					int n = fin.nextInt();
					fin.nextLine();
					
					Map<String, Integer> purchases= new TreeMap<>();
					
					for (int i = 0; i < n; i++)
					{
						String currentLine = fin.nextLine();
						// Splits the line on a space
						String[] arrayOfPurchases = 
								currentLine.split(" ");
						
						String item = arrayOfPurchases[1];
						int numberP =
							Integer.parseInt(arrayOfPurchases[0]);
						
						/*checks if the key is not contained and 
						 if its not it adds the new item 
						 purchased into the TreeMap */
						if (!purchases.containsKey(item))
						{
							purchases.put(item, numberP);
						}
						/*Since the item is already contained the
						  else statement replaces the number of 
						  items purchased with  the previous number
						  of items purchased plus the new one*/
						else 
						{
							int temp = purchases.get(item);
							purchases.replace
								(item, temp,  temp+numberP);
						}
					}
					/* Creates a String variable for the 
					 * TreeMap to sting */
					String purchaseString = purchases.toString();
					/* removes "{" and "}" */
					purchaseString = purchaseString.substring
							(1, purchaseString.length()-1);
					/* splits at ", " in order to get the 
					 * item and how many were purchased 
					 * as string in an array of all the
					 * items  */
					String[] printArray = 
							purchaseString.split("(, )");
					
					for (String item : printArray)
					{
						/* Splits at "=" and reorganizes the 
						item and number array so the the number 
						of items is before the item with a space
						in the middle */
						String [] k = item.split("="); 
						System.out.println(k[1] + " " + k[0]);
					}
						
					
	
					fin.close();
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
		}
}
