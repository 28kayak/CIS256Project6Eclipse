/*Patient Class*/

class Patient 
{
	String name;
	String malady;
	int prioity;

	public Patient(String patientName, String patientMalady, int thePrioity)
	{	
		name = patientName;
		malady = patientMalady;
		prioity = thePrioity;
	}
	/**
	 * [getName Accesser method to get parient name]
	 * @return [parient name]
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * [getMalady Accesser method to get patient malady]
	 * @return [patient malady]
	 */
	public String getMalady()
	{
		return malady;
	}
	/**
	 * [getPriority Accessor method to get priority]
	 * @return [return priority that 10 is the most serious]
	 */
	public int getPriority()
	{
		return prioity;
	}
	/**
	 * [toString a representation of containing all data in this object]
	 * @return [description]
	 */
	public String toString()
	{
		String information = "[ Priority: " + getPriority()+ " Name: " + getName() + " Malady: " + getMalady()+" ]";
		return information;

	}
	/**
	 * [compareTo compare defines ordering for Patient objects based on the priority field]
	 * @return [description]
	 */
	public int compareTo(Patient obj)
	{
		int moreSrious = 0;
		if(this.getPriority() <= obj.getPriority())
		{
			moreSrious = obj.getPriority();
		}
		else
		{
			moreSrious = this.getPriority();
		}
		return moreSrious;

	}

}

