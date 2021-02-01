
/** Represents a "sacred disk" for the Towers of Hanoi puzzle.
*/
public class SacredDisk
{
	// FIELDS
	// ----------------------------------------------------------------------
	private int mySize;			// The diameter of the disk
	
	
	// CONSTRUCTORS
	// ----------------------------------------------------------------------
	/** precondition: 0 < diskSize
	 * postcondition: Initializes this disk with the specified diameter.
	 */
	public SacredDisk(int size)
	{
		mySize = size;
	}
	
	
	// METHODS
	// ----------------------------------------------------------------------
	/** precondition:
	 * postcondition: Returns a String representation of this disk,
	 *                indicating its size.
	 */
	public String toString()
	{
		return "(" + mySize + ")";
	}
	
}

