
public class Quiz11Es4 {

	public static byte rosse = 10;
	public static byte nere = 5;
	public static byte estratte = 3;
	public static double mu = estratte*(double)rosse/(rosse+nere);
	public static int estrazioni = 100000000;
	
	public static void main(String[] args) {
		
		System.out.println(estrazioni+" estrazioni di "+estratte+" carte scelte tra "
	+rosse+" rosse e "+nere+" nere\n");
		System.out.println("\tcon definizione  |   con formula E[x^2]-E[x]^2   |  tempo");
		for(int i=1; i<=5; i++)
		{
			System.out.print(i+") ");
			es4();
		}
		
		// OUTPUT
		//	100000000 estrazioni di 3 carte scelte tra 10 rosse e 5 nere
		//
		//		con definizione  |   con formula E[x^2]-E[x]^2   |  tempo
		//	1) vardef: 0,666809330	 |   varfor: 0,666809328	 | t: 8.291s
		//	2) vardef: 0,666796790	 |   varfor: 0,666796780	 | t: 8.217s
		//	3) vardef: 0,666737230	 |   varfor: 0,666737216	 | t: 8.115s
		//	4) vardef: 0,666687210	 |   varfor: 0,666687197	 | t: 8.246s
		//	5) vardef: 0,666587730	 |   varfor: 0,666587713	 | t: 7.966s

	}
	

	public static void es4()
	{
		long start = System.currentTimeMillis();

		double sumx  = 0;
		double sumx2 = 0;
		double sumsq = 0;
		for(int i=0; i<estrazioni; i++)
		{
			double x = rossein3pescate();
			sumx +=x;
			sumx2+=Math.pow(x, 2);
			sumsq+=Math.pow(mu-(double)x,2);
		}
		double ex  = (double)sumx /estrazioni;
		double ex2 = (double)sumx2/estrazioni;
		double var = (double)sumsq/estrazioni;
		
		double varform = ex2 - Math.pow(ex, 2);		
		
		long end = System.currentTimeMillis();
		
		System.out.printf("vardef: %.9f",var);
		System.out.print("\t |   ");
		System.out.printf("varfor: %.9f",varform);
		System.out.println("\t | t: " + (end-start)/(double)1000 + "s");
		
	}
	
	private static int rossein3pescate() {

		int nrosse = 0;
		int min = 1;			// pesco 3 carte da 1
		int max = rosse+nere;	// a 15
		for(int i=0; i<estratte; i++)
		{
			// se è tra le prime 10 carte è rossa
			if((min + (int)(Math.random() * ((max - min) + 1)))<=rosse)
				nrosse++;
		}
		return nrosse;
	}
	
//	private static double avg(double[] a)
//	{
//		double sum = 0;
//		for(int i=0; i<a.length; i++)
//			sum+=a[i];
//		return sum/(double)a.length;
//	}
//	
//	private static int factorial(int n)
//	{
//		int prod = 1;
//		for(int i=1; i<n; i++)
//			prod*=i;
//		return prod;
//	}
//	
//	private static int binomial(int i, int j)
//	{
//		return factorial(i)/(factorial(j)*factorial(i-j));
//	}
//	
	
//	int max = arr.length -1;
//	int min = 0;
//	
//		rand[i] = min + (int)(Math.random() * ((max - min) + 1));
}
