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
		lastIndex = 1;
		maxIndex = maxSize + 1;//in order to hide elements[0], but need the same size of user's need.

	}
	/**
	 * [inEmpty determine whether this heap is empty]
	 * @return [if lastIndex remains -1, return true, that is, empty]
	 */
	public boolean isEmpty()
	{
		return (lastIndex == -1);
	}
	/**
	 * [isFull Determine whether this heap is full]
	 * @return [if lastIndex reaches to maxIndex, return true, that means full]
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
			elements[1] = elements[lastIndex];//instead of deleting, update the value of lastIndex
			downTrade(1);//because elements[1] = root

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
		if(maxIndex < (index * 2 +1))
		{//determine if there is still space or not
			if((2 * index + 1) <= maxIndex )
			{//there are 2 children 
				if(elements[2*index+1].getPriority() > elements[2*index].getPriority())
				{
					if(elements[index].getPriority() < elements[2*index+1].getPriority())
					{
						temp = elements[index];
						elements[index * 2] = elements[index];
						elements[index] = elements[index * 2];
						downTrade(2*index +1);
					}
				}
				
			}
			else if((2* index) == maxIndex)
			{//there is only left side child
				if(elements[2*index].getPriority() > elements[index].getPriority())
				{
					temp = elements[index];
					elements[index * 2] = elements[index];
					elements[index] = elements[index * 2];
					//since there is no more child(determine by no-right most child), no need to look downward
				}
			}else if(2*index > maxIndex)
			{
				//nothing to do
			}
			
		}
	}//dwonTrade()
}//class 