/*Heap class which children can only make sure if children is bigger than parant or not*/

class Heap <E>
{
	
	private E[] elements;//Array that holds heap elements 
	private int lastIndex;//index of last element in heap
	private int maxIndex;//index of last position in array 

	/**
	 * [Heap Constructor]
	 * @param  maxSize [Size of Array]
	 * @return         [description]
	 */
	public Heap(int maxSize)
	{
		elements =  new E[maxSize];
		lastIndex = -1;
		maxIndex = maxSize -1;

	}
	/**
	 * [inEmpty determin whether this heap is empty]
	 * @return [if lastIndex remains -1, return true, that is, empty]
	 */
	public boolean isEmpty()
	{
		return (lastIndex == -1);
	}
	/**
	 * [isFull Determine whether this heap is full]
	 * @return [if lastIndex recheas to maxIndex, return true, that means full]
	 */
	public boolean isFull()
	{
		return (lastIndex == maxIndex);
	}
	/**
	 * [add Adds item to this heap 
	 * 	throw  PriQOverflowException if the heap is already full]
	 * @param item [added element ]
	 */
	public void add(E item)
	{
		int where = 0;
		if(isFull())
		{//heap is full
			throw new PriQOverflowException("---This Heap is already FULL---");
		}
		else
		{
			 E[lastIndex] = item;
			 upTrade(lastIndex);
				

				
			
		}
	}
	/**
	 * [remove Removes the root element from the heap]
	 * @return [description]
	 * @throws PriQUnderflowException [if heap is empty]
	 */
	public E remove() 
	{
		if(isEmpty())
		{
			throw new PriQunderflowException("---This Heap is EMPTY---");
		} 
		else
		{

		}
		return null;
	}
	/**
	 * [toString returns a string of all the heap element]
	 * @return [string of heap]
	 */
	public String toString()
	{
		String theHeap = new String ("the heap is \n");
		for(int index = 0; index <= lastIndex; index++)
		{
			theHeap = theHeap + index + ". " + elements[index] + "\n";
		}
		return theHeap;

	}
	public int upTrade(int index)
	{
		E temp; 
		if((elements[index] > elements[index % 2]) && (index != 1))
		{
			temp = elements[index];//store value at elements[index] temporally 
			elements[index] = elements[index % 2];//sudstitude parents value to a child
			elements[index % 2] = temp;//re-store value at elements[index]

		}		
		else
		{
			return upTrade(index);
		}
	}
	public int downTrade(int index)
	{
		if((elements[index] < elements[index * 2]) && ((index * 2 + 1) > maxIndex ))
		{
			elements[index % 2] = elements[index];
		}
		else
		{
			return downTrade(index);
		}
	}
}//class 