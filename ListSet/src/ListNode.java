public class ListNode<E>
{
	// FIELDS
	// ------------------------------------------------------------------
	private E data;
	private ListNode<E> next;
	private ListNode<E> prev;

	// CONSTRUCTORS
	// ------------------------------------------------------------------
	public ListNode(E initData, 
					ListNode<E> initNext, 
					ListNode<E> initPrev)
	{
		data = initData;
		next = initNext;
		prev = initPrev;
	}

	// METHODS
	// ------------------------------------------------------------------
	public E getData() { return data; }
	public void setData(E theNewData) { data = theNewData; }

	public ListNode<E> getNext() { return next; }
	public ListNode<E> getPrev() { return prev; }

	public void setNext(ListNode<E> theNewNext) { next = theNewNext; }
	public void setPrev(ListNode<E> theNewPrev) { prev = theNewPrev; }

	public String toString() { return "[" + data + "]"; }
	
	public int  hashCode()
	{
		int sum = 0;
		String s = data.toString();
		for (int i=0; i<s.length();i++)
				{
					char letter = s.charAt(i);
					int value = letter;
					sum = sum + value*(s.length()-i);
				}
		return sum;
	}

}
