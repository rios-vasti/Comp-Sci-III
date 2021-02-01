import 	java.util.List;
import java.util.ArrayList;

public class ListSetTester
{
	public static void main(String[] args)
	{
		ListSet<String> a = new ListSet<String>();

		System.out.println("ListSet Tester:");
		System.out.println("---------------");
		
		// Insert code to thoroughly test each of your
		// methods in the LinkedListSet class.
		System.out.println(a);
		
		a.add("hello");
		System.out.println(a);
		
		a.add("Hi");
		System.out.println(a);
		
		a.add("ha");
		System.out.println(a);
		
		a.add(1,"hu");
		System.out.println(a);
		System.out.println("*****************");
		
		System.out.println(a.indexOf("Hi"));
		System.out.println("*****************");
		
		List<String> b = new ArrayList<String>();
		b.add("ha");
		b.add("me");
		b.add("my");
	
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
		
		a.clear();
		System.out.println(a);
		System.out.println(b);
		
		a.add("ha");
		a.add("me");
		a.add("Hi");
		a.add("hello");
		
		System.out.println(a);
		
		a.retainAll(b);
		System.out.println(a);
		a.add("ha");
		a.add("me");
		a.add("Hi");
		a.add("hello");
		a.add("a");
		a.add("e");
		a.add("i");
		System.out.println(a);
		
		System.out.println(a.subList(1,4));
		
		System.out.println(a.toArray());
	
		System.out.println("---------------");
		System.out.println("Done.");
	}
}
