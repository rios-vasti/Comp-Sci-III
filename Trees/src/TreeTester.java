
public class TreeTester 
{
	public static void main(String[] args)
	{
		
		Tree test = new Tree("A", 2);
		
		Tree [] testSub = test.getChildren();
		
		testSub[0] =  new Tree ("B", 2);	
		testSub[1] =  new Tree ("C", 2);
		
		Tree [] childSub = testSub[0].getChildren();
		childSub[0]= new Tree ("D", 2);
		
		System.out.println("Tree: " + test);
		System.out.println("Root Value:  " + test.getValue());
		for (int i= 0; i< test.getChildren().length; i++)
		{
			System.out.println("Children [" + i + "] " + test.getChildren()[i].getValue());
		}
		
		System.out.println("Is the root a leaf? " + test.isLeaf());
		System.out.println("Is the B a leaf? " +testSub[0].isLeaf());
		System.out.println("Is the D a leaf? " +childSub[0].isLeaf());
		System.out.println("What is the MaxHeight? " + test.maxHeight());
		System.out.println("Deapth First Search: " + test.depthFirstSearch("C"));
		System.out.println("Breath First Search: " + test.breathFirstSearch("C"));
		System.out.println("Size: " + test.size());
		System.out.println("Size B: " + childSub[0].size());
		System.out.println("Hash Code: " + test.hashCode());
		
	}
}
