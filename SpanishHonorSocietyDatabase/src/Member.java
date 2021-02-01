
public class Member
{
	private int myGrade;
	private int numberOfSemesters;
	private String myFirstName;
	private String myLastName;
	private double myCulture;
	private double myCommunityService;
	private double myFundraiser;
	private double myMiscellaneous;
	private double myDeduct;
	private String myEmail;
	private int probation; 
	
	public Member (int grade, int numSem, String first, String last,double c , double cs, double f, double misc, double d, String email, int p)
	{
		myGrade = grade;
		numberOfSemesters = numSem;
		myFirstName= first;
		myLastName= last;
		myEmail= email;
		myCommunityService= cs;
		myCulture= c;
		myFundraiser= f;
		myMiscellaneous= misc;
		probation = p;
		myDeduct = d;
		
	}
	
	
	public String getFirstName()
	{
		return myFirstName;
	}
	
	public String getLastName()
	{
		return myLastName;
	}
	
	public String getName()
	{
		return myFirstName +" "+ myLastName;
	}
	public String getEmail ()
	{
		return myEmail;
	}
	
	public double setCommunityService ()
	{
		return myCommunityService;
	}
	
	public double getCulture ()
	{
		return myCulture;
	}
		
	public double getMiscellaneous ()
	{
		return myMiscellaneous;
	}
	
	public double getFundraiser ()
	{
		return myFundraiser;
	}
	
	public double getDeduct ()
	{
		return myDeduct;
	}
	
	public int getSemester ()
	{
		return numberOfSemesters;
	}
	public int getGrade ()
	{
		return myGrade;
	}
	public boolean getProbaion()
	{
		if (probation==1)
		{
			return true;
		}
			
		else 
		{
			return false;
		}
	}
	
	public boolean getRevoked()
	{
		if (probation==1 || probation ==0)
		{
			return false;
		}
			
		else 
		{
			return true;
		}
	}
	
	
	//--------------------------------------------------------------------------------------------------
	public void setFirstName(String first)
	{
		myFirstName= first;
	}
	
	public void setLatName(String last)
	{
		myLastName= last;
	}
	
	public void setEmail (String email)
	{
		myEmail= email;
	}
	
	public void setCommunityService (double cs)
	{
		myCommunityService= cs;
	}
	
	public void setCulture (double c)
	{
		myCulture= c;
	}
		
	public void setMiscellaneous (double misc)
	{
		myMiscellaneous= misc;
	}
	
	public void setFundraiser (double f)
	{
		myFundraiser= f;
	}
	
	public void setDeduct (double d)
	{
		myDeduct = d;
	}

	public void addCommunityService (double cs)
	{
		myCommunityService= myCommunityService+ cs;
	}
	
	public void addCulture (double c)
	{
		myCulture= myCulture + c;
	}
		
	public void addMiscellaneous (double misc)
	{
		myMiscellaneous= myMiscellaneous + misc;
	}
	
	public void addFundraiser (double f)
	{
		myFundraiser= myFundraiser + f;
	}
	
	public void addDeduct (double d)
	{
		myDeduct = myDeduct + d;
	}

	public void increaseSemester ()
	{
		numberOfSemesters++;
		this.probation();
	}
	public void increaseGrade ()
	{
		myGrade++;
	}
	
	public void probation()
	{
		double tempMisc = myMiscellaneous;
		double requiredc=  numberOfSemesters * 2; //myCommunityService; 
		double requiredcs= numberOfSemesters * 2; //myCulture;
		double requiredf= numberOfSemesters;
		double requiredm= numberOfSemesters;
		
		double testcs = 0;
		double testc = 0;
		double testf = 0;
		double testm = 0;
		
		if (myCommunityService >= requiredcs)
		{
			tempMisc = tempMisc +(myCommunityService-requiredcs);
			testcs=1; 
		}
		if (myCulture >= requiredc )
		{
			tempMisc = tempMisc +(myCulture-requiredc);
			testc = 1;
		}
		if (myFundraiser >= requiredf)
		{
			tempMisc = tempMisc +(myFundraiser-requiredf);
			testf = 1;
		}
		if ((tempMisc - this.getDeduct()) >= requiredm )
		{
			testm = 1;
		}
		
		if ((testcs + testc + testf + testm) < 4.0 )
		{
			probation ++;
		}
		if ((testcs + testc + testf + testm) >= 4.0 )
		{
			probation = 0;
		}
	}
	
	public String toString2()
	{
		return "\nFirst Name:" +  myFirstName + "\nLast Name: "+myLastName + "\nGrade:" 
	+ myGrade +"\nNumber of Semesters:" + numberOfSemesters + "\nCulture Points:" + 
	myCulture + "\nComunity Service Points:" + myCommunityService +"\nFundraiser Points:" 
	+ myFundraiser + "\nMiscellaneous points:"	+ myMiscellaneous + "\n Deducted Points:" 
	+ myDeduct + "\nEmail:" + myEmail + "\n Probation:" + this.getProbaion() 
	+ "\n Revoked:" + this.getRevoked() + "\n ";
	}

	
	public String toString()
	{
		return myGrade+ "\t"+numberOfSemesters + "\t"+ myFirstName + "\t"+myLastName + "\t"+
	myCulture +"\t"+ myCommunityService + "\t"+ myFundraiser +"\t"+ myMiscellaneous +"\t"+ myDeduct 
	+"\t"+ myEmail +"\t"+ probation;
	}

}
