import java.util.Stack;


/** TOWERS OF HANOI PUZZLE
 *
 *  LEGEND: In an ancient city in India, so the legend goes, monks in a
 *          temple were assigned to move a pile of 64 sacred disks from a
 *          pillar in one corner of the temple to another pillar in the
 *          center of the temple. The disks are fragile, so only one can
 *          be carried at a time. Likewise, a larger disks cannot be placed
 *          on top of a smaller disks or else they will break. To add to the
 *          monks' task, there is only one other pillar in the temple (in
 *          the opposite corner) that is sacred enough for a pile of disks
 *          to be placed there.
 *
 *          So, the monks start moving disks back and forth between the
 *          three pillars, always keeping each pile in order (largest on the
 *          bottom, smallest on the top). The legend is that, before the
 *          monks make the final move to complete the ultimate pile on the
 *          center pillar, the temple will turn to dust and the world will
 *          end.
 *
 *    GOAL: Move all of the disks from the first pillar to the center pillar.
 *
 *   RULES: Only 1 disk may be moved at a time.
 *          No disks may be placed on top of a smaller disk.
 */
public class TowersOfHanoi
{
	// FIELDS
	// ----------------------------------------------------------------------
	private Stack<SacredDisk> myPegA;	// 1st pillar of sacred disks
	private Stack<SacredDisk> myPegB;	// 2nd pillar of sacred disks
	private Stack<SacredDisk> myPegC;	// 3rd pillar of sacred disks
	
	
	// CONSTRUCTORS
	// ----------------------------------------------------------------------
	/** Initializes myPegA to have n sacred disks ranging from size 1 to n,
	 *  with the smaller disks on the top of the stack and the larger disks
	 *  on the bottom of the stack.  Initializes myPegB and myPegC to be
	 *  empty stacks.
	 */
	public TowersOfHanoi(int n)
	{
		myPegA = new Stack<SacredDisk>();
		myPegB = new Stack<SacredDisk>();
		myPegC = new Stack<SacredDisk>();
		
		for (int i = n; i > 0; i--)
		{
			myPegA.push(new SacredDisk(i));
		}
	}
	
	
	// METHODS
	// ----------------------------------------------------------------------
	/** precondition: All disks are stacked in ascending order on myPegA.
	 * postcondition: All disks are stacked in ascending order on myPegB.
	 *                Disks must be moved from one pillar to another one at
	 *                a time in accordance with the rules of the puzzle.
	 */
	public void solvePuzzle()
	{
		moveTower(myPegA.size(),myPegA,myPegB,myPegC);	
		// TODO: Implement this method correctly
	}
	
	
	
	/** precondition: n is the number of disks to be moved. There are at
	 *                least n disks on the source stack. dest and temp each
	 *                contain 0 or more disks. All disks on each pillar are 
	 *                stacked in ascending order. The top n disks of source
	 *                are all smaller than any disks in dest and temp.
	 * postcondition: The top n disks of source have been removed and 
	 *                placed on top of any disks on dest. All other disks
	 *                in the puzzle remain in their original locations.
	 *                All disks on each pillar are stacked in ascending 
	 *                order. Disks must be moved from one pillar to another  
	 *                one at a time in accordance with the rules of the 
	 *                puzzle.
	 */
	private void moveTower(int n, Stack<SacredDisk> source, 
	                              Stack<SacredDisk> dest,
	                              Stack<SacredDisk> temp)
	{
		
	// TODO: Implement this method correctly
		if ( n>0)
		{
		moveTower( n-1, source,temp ,dest);
		moveDisk(source,dest);
		moveTower( n-1, temp,dest ,source);
		}
	}
	
	
	
	/** precondition: There is at least 1 disk on the source stack. All 
	 *                disks in dest are stacked in ascending order. The
	 *                topmost disk of source is smaller than any disk
	 *                in dest.
	 * postcondition: The topmost disk of source has been removed and 
	 *                placed on the top of dest. All other disks in the 
	 *                puzzle remain in their original locations. All disks
	 *                on each pillar are stacked in ascending order. Disks
	 *                must be moved from one pillar to another one at a 
	 *                time in accordance with the rules of the puzzle.
	 */
	private void moveDisk(Stack<SacredDisk> source, Stack<SacredDisk> dest)
	{
			dest.push(source.pop());
			System.out.println(this);
	}
	
	
	
	/** precondition: myPegA, myPegB, and myPegC each contain 0 or more
	 *                SacredDisks.
	 * postcondition: Returns a String representation of the puzzle,
	 *                showing the current contents of each pillar.
	 */
	public String toString()
	{
		String s = "";
		s += "A:" + myPegA + "\n";
		s += "B:" + myPegB + "\n";
		s += "C:" + myPegC + "\n";
		return s;
	}
	
	
	/** Main method.  Instantiates and solves a Towers of Hanoi puzzle.
	 */
	public static void main(String[] args)
	{
		TowersOfHanoi t = new TowersOfHanoi( 7 );
		System.out.println("BEFORE...");
		System.out.println(t);

		t.solvePuzzle();

		System.out.println("AFTER...");
		System.out.println(t);
	}
	
	
}

