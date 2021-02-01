
public class SlowStringSeach {
	
	public static void main (String[] args)
	{
		String needle = "WESTWOOD";
		String haystack = "WESTLAKE WISHES IT WERE WESTWOOD.";
				
		System.out.println(indexOf(needle.toCharArray(), haystack.toCharArray() ));
		
	}
	
	public static int indexOf (char[] needle, char[] haystack)
	{
		for ( int i=0; i<= haystack.length - needle.length; i++ )
		{
			int k;
			for (k=0; k<needle.length; k++)
			{
				if (haystack[i+k]!= needle[k])
				{
					break;
				}
					
			}
			if (k== needle.length) 
			{
			return i;
			}
			
		}
		return -1;
	}

}
