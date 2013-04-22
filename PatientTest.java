//PatientTest
class PatientTest
{
	public static void main(String [] args)
	{
		Patient p1 = new Patient("Tazo", "cancer", 10);
		Patient p2 = new Patient("Wild Orenge", "cancer", 5);
		System.out.println("test");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		int moreSirious = 0;
		moreSirious = p1.compareTo(p2);
		System.out.println("higher priority is " + moreSirious);
	}

}