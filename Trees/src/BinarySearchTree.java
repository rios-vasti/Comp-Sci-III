
public class BinarySearchTree <E extends Comparable <E>> extends BinaryTree
{
	/**
	 * Creates a BinarySearch Tree (A Binary Tree in which all the items are stored in an ordered fashion)
	 * @param rootValue the root value of the BinarySearchTree
	 */
	public BinarySearchTree(Comparable <E> rootValue)
	{
		super(rootValue);
	}
	
	/**
	 * 
	 * @param x The item to be Searched for.
	 * @return  <code>true</code> if x is contained within this
	 		* tree, <code>false</code> otherwise.
	 */
	public boolean contains (Comparable <E> x)
	{
		return false;
	}

	/**
	 * @param x The item to be added.
	 * @return  <code>true</code> if item x is added in the  tree, 
	 * <code>false</code> otherwise.
	 */
	public boolean add (Comparable <E> x)
	{
		return false;
	}
	
	/**
	 * @param x The item to be removed.
	 * @return  <code>true</code> if item x is removed from the  tree, 
	 * <code>false</code> otherwise.
	 */
	public boolean remove (Comparable <E> x)
	{
		return false;
	}
}
