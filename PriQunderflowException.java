class PriQunderflowException extends RuntimeException
{
	public PriQunderflowException()
	{
		//defalt constructor
	}
	/**
	 * [PriQunderflowException constructor]
	 * @param  massage [massage to be thrown]
	 * @return         [description]
	 */
	public PriQunderflowException(String massage)
	{
		super(massage); 
	}

}