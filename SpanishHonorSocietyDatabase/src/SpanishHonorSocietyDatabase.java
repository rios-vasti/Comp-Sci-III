import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class SpanishHonorSocietyDatabase {
	
	
private Map<String, Member> myMembers;
private String myFileName;
/**
 * A Database that reads from a text file of members in the National Spanish Honor Society and can change or edit the 
 * information of the members as well as output lists of probation, revoked members, and all members.
 */
public  SpanishHonorSocietyDatabase()
{
	
	myMembers = new TreeMap<>();
	myFileName = "SHSData.txt";
	
	this.loadDataFromFile();
}
	
/**
 * Initializes the Spanish Honor Society Database by reading from a text file the members and all the according information
 * and putting it in a Tree Map
 */
private void loadDataFromFile()
{
	// TODO: Parse file data and use it to populate data structure
	try 
	{
		Scanner fin = new Scanner(new File(myFileName));
		while(fin.hasNextLine())
		{
			String line = fin.nextLine();
			String[] parts = line.split("(\\t)");
			
			int grade = Integer.parseInt(parts[0]);
			int numSem= Integer.parseInt(parts[1]); 
			String first= parts[2];
			String last= parts[3];
			double c= Double.parseDouble(parts[4]);
			double cs= Double.parseDouble(parts[5]);
			double f= Double.parseDouble(parts[6]);
			double misc= Double.parseDouble(parts[7]);
			double d= Double.parseDouble(parts[8]); 
			String email= parts[9]; 
			int p= Integer.parseInt(parts[10]);
			String name = parts[2] + " " +parts[3];
			Member current = new Member(grade,numSem, first,last, c , cs, f, misc, d, email, p);
			myMembers.put(name, current);
			
		}
		
		//This Prints all the members in alphabetical order
		
	/*	Set<String> members = myMembers.keySet();
		for(String m : members)
		{
			System.out.println(myMembers.get(m));
		} */
		
		fin.close();
	} 
	catch (FileNotFoundException e)
	{
		// TODO Auto-generated catch block
		System.out.println("File not found. No data loaded");
	}
}
/**
 * Saves the Tree map of the members into fileName
 * @param fileName, the name of the file you want to save the information of the members to
 */
public void save(String fileName)
{
	try 
	{
		PrintWriter fout = new PrintWriter(fileName);
		Set<String> members = myMembers.keySet();
		
		for(String m : members)
		{
			fout.println(myMembers.get(m).toString());
		}
		fout.flush();
		fout.close();
	}
	catch (Exception e)
	{
		System.out.println("Error");
	}
}
/**
 * Looks up a member by name (First Last) and returns all their information such as name, email, semester, points, 
 * and if the member should be on probation or their membership revoked.
 * @param myName
 * @return The name, email, semester, points, and if the member should be on probation or their membership revoked.
 */
public 	String lookupByName(String myName)
{
	
	/*Set<String> members = myMembers.keySet();
	
	for(String m : members)
	{
		if (myMembers.get(m).getName().equals(myName))
		{

			return myMembers.get(m);	
		}
	}
	*/
	Member member = myMembers.get(myName);
	if(member != null)
	{
		return member.toString2();
	}
	else
	{
		return "Person not Found!";
	}
	
		
}
/**
 * Searches the Tree Map of members for those that should be on probation and returns an arrayList of Strings 
 * that has the name and email of all the members who should be on probation.
 * @return ArrayList of Strings that has the name and email of all the members who should be on probation.
 */
public ArrayList<String> probationList()
{
	ArrayList<String> proabtionMembers = new ArrayList<String>();
	
	Set<String> members = myMembers.keySet();
	for(String m : members)
	{
		if (myMembers.get(m).getProbaion())
		{

			proabtionMembers.add(myMembers.get(m).getName()+" - "+ myMembers.get(m).getEmail());
		}
	}
	
	return proabtionMembers;
}

public ArrayList<String> revokedList()
{
	ArrayList<String> revokedMembers = new ArrayList<String>();
	
	Set<String> members = myMembers.keySet();
	for(String m : members)
	{
		if (myMembers.get(m).getRevoked())
		{

			revokedMembers.add(myMembers.get(m).getName()+" - "+ myMembers.get(m).getEmail());
		}
	}
	
	return revokedMembers;
}

public String increaseSemester()
{
	Set<String> members = myMembers.keySet();
	for(String m : members)
	{
		myMembers.get(m).increaseSemester();
	}
	this.save(myFileName);
	return "The semster has been Increased";
}

public String addPoints(String name,String type, double x)
{
	Member currentMember = myMembers.get(name);
	String longType = " ";
	
	if(currentMember == null)
	{
		return "Person not Found!";
	}
	if (type.equals("c"))
	{
		currentMember.addCulture(x);
		longType = "Culture";
	}
	else if (type.equals("cs"))
	{
		currentMember.addCommunityService(x);
		longType = "Community Service";
	}
	else if (type.equals("f"))
	{
		currentMember.addFundraiser(x);
		longType = "Fundraiser";
	}
	else if (type.equals("m"))
	{
		currentMember.addMiscellaneous(x);
		longType = "Miscellaneous";
	}
	else
	{
		currentMember.addDeduct(x);
		longType = "Deducted";
		this.save(myFileName);
		return x +" point have been"+ longType +" to " + name;
	}
	this.save(myFileName);
	return x +" "+ longType +" point have been added to " + name;
}
public ArrayList<String> MemberList()
{
	ArrayList<String> membersList = new ArrayList<String>();
	
	Set<String> members = myMembers.keySet();
	for(String m : members)
	{
		if (myMembers.get(m).getRevoked())
		{

			membersList.add(myMembers.get(m).toString2());
		}
	}
	
	return membersList;
}




public static void main(String[] args)
{
	
	SpanishHonorSocietyDatabase db= new SpanishHonorSocietyDatabase();
	Scanner scan = new Scanner(System.in);
	String menu = "-----------------------------------------------------------------------"
			+ "\nPick the number of the task you wish to do:"
			+ "\n1- to get a list of those who are in probation"
			+ "\n2- to get a list of those whose membership should be revoked "
			+ "\n3- to find infromation of a member by searching by name "
			+ "\n4- to increase the sememster of all members"
			+ "\n5- to print all the members"
			+ "\n6- to change the points a member has"
			+ "\n7-in order to quit"
			+"\n-----------------------------------------------------------------------";
	System.out.println(menu);
	System.out.println();
	String nextLine = scan.nextLine();
	while (!nextLine.contentEquals("7"))
	{
		if (nextLine.contentEquals("1"))
		{
			ArrayList<String> probation = db.probationList();
			for (String member: probation )
			{
				System.out.println(member);
			}
		}
		
		else if (nextLine.contentEquals("2"))
		{
			ArrayList<String> revoked = db.revokedList();
			for (String member: revoked )
			{
				System.out.println(member);
			}
			if (revoked.size()==0)
			{
				System.out.println("There are no members to revoke");
			}
		}
		else if (nextLine.contentEquals("3"))
		{
		
			System.out.println(" Type the name of the member (Fist,Last)");
			nextLine = scan.nextLine();
			String member = db.lookupByName(nextLine);
			//if(member.equals(null))
			//{
			//	System.out.println("This person could not be found");
			//}
			//else 
			//{
				System.out.println(member);	
			//}
			
		
		}
		else if (nextLine.contentEquals("4"))
		{
		
			System.out.println(db.increaseSemester());
			
		
		}
		
		
		else if (nextLine.contentEquals("5"))
		{
		
			System.out.println(" These are the current Members:");
			ArrayList<String> members = db.MemberList();
			for (String m: members )
			{
				System.out.println(m);
			}
		
		}
		
		else if (nextLine.contentEquals("6"))
		{
			System.out.println(" Type the name of the member (Fist Last), the type of point you wish to add "
					+ "(c or cs or m or f or d), how many points will be added \n(separate each item by a comma "
					+ "and no spaces between items)");
			nextLine = scan.nextLine();
			String[] arrayOfLine = nextLine.split(",");
			String name = arrayOfLine[0];
			String type =arrayOfLine[1];
			double x = Double.parseDouble(arrayOfLine[2]);
			String member = db.addPoints(name, type, x);
			System.out.println(member);
			
			
		}
		System.out.println();
		
		System.out.println(menu);
		nextLine = scan.nextLine();
	}
	System.out.println(" ");	
	System.out.println("Bye");
	scan.close();
}
	
}

