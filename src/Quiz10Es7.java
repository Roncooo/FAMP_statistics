
public class Quiz10Es7 {

	public static short n_caramelle = 1143;
	public static short n_bambini = 100;
	public static short caramelle_mario = 11;
	public static long estrazioni_totali = 100000;
	public static short[] caramelle = new short[n_bambini];	// caramelle per ogni bambino

	public static void main(String[] args) {
		
		for(int i=1; i<=5; i++)
		{
			System.out.print(i+") ");
			es7();
		}

	}
	

	public static void es7()
	{

		long start = System.currentTimeMillis();
		
		double mario_11 = 0;
		for(int i=0; i<estrazioni_totali; i++)
		{
			dai_caramelle();
			if(caramelle[0]==caramelle_mario)
				mario_11 ++;
		}
		
		long end = System.currentTimeMillis();
		
		double prob = (double)(mario_11/estrazioni_totali);
		System.out.printf("%.9f",prob);
		System.out.println("\tt: " + (end-start)/(double)1000 + "s");
		
	}
	
	private static void dai_caramelle() {

		// azzero le caramelle del turno precedente
		for(int i=0; i<n_bambini; i++)
			caramelle[i] = 0;
		
		int max = n_bambini-1;
		int min = 0;
		for(int i=0; i<n_caramelle; i++)	// prendo una caramella alla volta e la do a un bambino a caso
			caramelle[(min + (int)(Math.random() * ((max - min) + 1)))]++;
	}
	
	
	
	public static void print(short[] arr)
	{
		System.out.print("[");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+", ");
		System.out.print("]\n");
	}
	public static void print(char[] arr)
	{
		System.out.print("[");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+", ");
		System.out.print("]\n");
	}
	
	
//	int max = arr.length -1;
//	int min = 0;
//	
//		rand[i] = min + (int)(Math.random() * ((max - min) + 1));
}
