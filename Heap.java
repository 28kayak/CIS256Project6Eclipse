/*Heap class which children can only make sure if children is bigger than parant or not*/

class Heap <Patirnt>
{
	
	private Patient[] elements;//Array that holds heap elements 
	private int lastIndex;//index of last element in heap
	private int maxIndex;//index of last position in array 

	/**
	 * [Heap Constructor]
	 * @param  maxSize [Size of Array]
	 * @return         [description]
	 */
	public Heap(int maxSize)
	{
		elements =  new Patient[maxSize];
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
	public void add(Patient item)
	{
		int where = 0;
		if(isFull())
		{//heap is full
			throw new PriQOverflowException("---This Heap is already FULL---");
		}
		else
		{
			elements[lastIndex] = item;
			 upTrade(lastIndex);
				

				
			
		}
	}
	/**
	 * [remove Removes the root element from the heap]
	 * @return [description]
	 * @throws PriQUnderflowException [if heap is empty]
	 */
	public Patient remove() 
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
	public void upTrade(int index)
	{
		Patient temp; 
		if((elements[index].getPriority() <= elements[index % 2].getPriority()) && (index != 1))
		{
			temp = elements[index];//store value at elements[index] temporally 
			elements[index] = elements[index % 2];//sudstitude parents value to a child
			elements[index % 2] = temp;//re-store value at elements[index]
			upTrade(index % 2);
			

		}		
		else
		{
			//nothing to do
		}
	}
	public void downTrade(int index)
	{
		Patient temp;
		if(elements[index * 2].getPriority() > elements[index * 2 + 1].getPriority())
		{//elements[index * 2].getPriority() is bigger 
			if((elements[index].getPriority() < elements[index * 2].getPriority() && ((index * 2 + 1) > maxIndex )))
			{
				temp = elements[index];
				elements[index * 2] = elements[index];
				elements[index] = elements[index * 2];
				downTrade(index * 2);
			}
			else
			{
				//nothing to do
			}
		}
		else
		{
			if((elements[index].getPriority() < elements[index * 2 + 1].getPriority() && ((index * 2) > maxIndex )))
			{
				temp = elements[index];
				elements[index * 2] = elements[index];
				elements[index] = elements[index * 2];
				downTrade(index * 2);
			}
			else
			{
				//nothing to do
			}
		}
		
		/*
		
		if((elements[index].getPriority() < elements[index * 2].getPriority()) && ((index * 2 + 1) > maxIndex ) || (index * 2) > maxIndex)
		{
			temp = elements[index];
			elements[index * 2] = elements[index];
			elements[index] = elements[index * 2];
			downTrade(index * 2);
		}
		else
		{
			//nothing to do
		}
		*/
	}
}//class 