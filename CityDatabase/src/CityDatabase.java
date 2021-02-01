import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Stack;
import java.util.Queue;
import java.util.PriorityQueue;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


public class CityDatabase
{
	
	// Fields
	//-----------------------------------------------------------------
	// TODO: Declare appropriate data structure(s) to hold the data
	
	private Map<String, Set<City>> myCities; //hash map to be declared later, treeSet to be declared later 
	
	// Constructors
	//-----------------------------------------------------------------
	public CityDatabase() {
		myCities = new HashMap<>();
		this.loadDataFromFile();
	}
	
	
	// Methods
	//-----------------------------------------------------------------
	private void loadDataFromFile()
	{
		// TODO: Parse file data and use it to populate data structure
		try 
		{
			Scanner fin = new Scanner(new File("CityData.txt"));
			while(fin.hasNextLine())
			{
				String line = fin.nextLine();
				String[] parts = line.split("(, )|(\\t)");
				String city = parts[0];
				String state = parts[1];
				int population = Integer.parseInt(parts[2]); //makes the string an int
				
			
			if (!myCities.containsKey(state))
			{
				
				myCities.put(state, new TreeSet<>() );
			}
			myCities.get(state).add( new City(city,population));
			}
			
			
			//For testing 
			/*System.out.println(myCities.size());
			Set<String> states = myCities.keySet();
			for(String s : states)
			{
				System.out.println(s + " : "+ myCities.get(s));
			}
			*/	
			fin.close();
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("File not found. No data loaded");
		}
	}
	
	public Set<String> lookupByAlphaOrder(String state) {
		Set<City> citiesAndPopulation =  myCities.get(state); // TODO
		Set<String> cities = new TreeSet<>();
		for (City c: citiesAndPopulation)
		{
			cities.add(c.getCity());
		}
		
		return cities;
	}
	
	
	public ArrayList<String> lookupByPopulation(String state) {
		Set<City> citiesAndPopulation =  myCities.get(state); // TODO
		ArrayList<String> cities = new ArrayList<>();
		for (City c: citiesAndPopulation)
		{
			cities.add(c.getCity());
		}
		
		return cities;
	}
	
	
	// Driver (main) Method
	//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		CityDatabase db = new CityDatabase();
		
		
		// TODO:
		// Repeat the following until the user types 'quit'...
		//   ...Prompt the user to input a state abbreviation or 'quit'
		//   ...Print the list of cities in the user-specified state
		//        ...Basic assignment: List cities in alphabetical order
		//        ...Advanced assignment: List cities in order of population
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a state abreviation to find the cities in this state or quit in order to stop");
		String nextLine = scan.nextLine();
		while (!nextLine.equals("quit"))
		{
			
			Set<String> statesAlpha = db.lookupByAlphaOrder(nextLine);
			ArrayList<String> statesPop = db.lookupByPopulation(nextLine);
			System.out.println("States Alphabetically: ");
			for (String state:statesAlpha)
			{
				System.out.print(state +", ");
			}
			System.out.println();
			System.out.println();
			System.out.println("States by Population: ");
			for (String state: statesPop)
			{
				System.out.print(state +", ");
			}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Enter a state abbreviation to find the cities in this state or quit in order to stop");
		nextLine = scan.nextLine();
		}
		
		System.out.println(" ");	
		System.out.println("Bye");
		scan.close();
		
	}

}
