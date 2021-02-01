import java.util.List;

public class BinaryTree {
	
	// CONSTRUCTORS
	// ------------------------------------------------------------------
	
	/**
	 * Constructs a Binary tree, which is a tree that has a branching factor of two
	 * @param rootValue is the parent/root of all the items stored in the tree
	 */
	public BinaryTree(Object rootValue)
	{
		
	
	}

	/**Constructs a Binary tree, which is a tree that has a branching factor of two
	 * @param rootValue is a tree that is the parent/root of all the items stored in the tree. 
	 * @param left is a tree that is the  child store in the left side of the root value. 
	 * @param right is a tree that is the  child store in the right side of the root value.  
	 */
	public BinaryTree(Object rootValue,BinaryTree left, BinaryTree right)
	{
		
	
	}
	
	/**
	 * Sets the left child of the root to be the parameter
	 * @param left is the child stored to the left of the root
	 */
	public void setLeft (BinaryTree left)
	{
		
	}
	
	/**
	 * Sets the right child of the root to be the parameter
	 * @param right is the child stored to the right of the root
	 */
	public void setRight (BinaryTree right)
	{
		
	}
	/**
	 * Finds and returns the BinaryTree child that is stored to the left of the root
	 * @return the BinaryTree child that is stored to the left of the root
	 */
	
	public BinaryTree getLeft ()
	{
		return null;
	}
	
	/**
	 * Finds and returns the BinaryTree child that is stored to the right of the root
	 * @return the BinaryTree child that is stored to the right of the root
	 */
	
	public BinaryTree getRigth ()
	{
		return null;
	}
	
	/**
	 * Finds and returns a list of the objects stored in a tree inOrder (Left child, root, right child)
	 * @return Returns a list of the objects stored in a tree in oder (Left child, root, right child)
	 */
	public List<Object> inOrder()
	{
		return null;
	}
	

	/**
	 * Finds and returns a list of the objects stored in a tree in preOrder (root, Left child, right child)
	 * @return Returns a list of the objects stored in a tree in preOrder (root, Left child, right child)
	 */
	public List<Object> preOrder()
	{
		return null;
	}
	
	/**
	 * Finds and returns a list of the objects stored in a tree in postOrder (Left child, right child, root)
	 * @return Returns a list of the objects stored in a tree in postOrder (Left child, right child, root)
	 */
	
	public List<Object> postOrder()
	{
		return null;
	}
	
	/**
	 * Finds and returns a list of the objects stored in a tree Level by Level (root value of the tree the all
	 * it's children, then the children of all those children, and so forth)
	 * @return returns the objects stored in a tree Level by Level
	 */
	public List<Object> levelByLevel()
	{
		return null;
	}
	
	
	

}