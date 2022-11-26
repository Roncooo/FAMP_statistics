

public class Quiz9Es12 {

	public static byte[] arr;
	public static short f1 = 135;
	public static short f2 = 127;
	public static short tot = (short)(f1+f2);
	public static long estrazioni_totali = 100000000;
	public static byte nestr = 5;					// numero di elementi estratti
	public static short[] rand = new short[nestr];	// array di indici

	public static void main(String[] args) {
		
		// creo insieme con 123 persone del canale A e 144 del canale B
		arr = new byte[tot];
		for(short i=0; i<f1; i++)
			arr[i] = 0;		// canale A
		for(short i=f1; i<tot; i++)
			arr[i] = 1;		// canale B
		
		for(int i=1; i<=10; i++)
		{
			System.out.print(i+") ");
			es12();
		}

	}
	

	public static void es12()
	{
		int favorevoli = 0;
		
		long start  = System.currentTimeMillis();
		
		for(int i=0; i<estrazioni_totali; i++)
		{
			if(quantiCanale1Tra5(arr)>=3)
				favorevoli++;
		}
		
		long end = System.currentTimeMillis();
		
		double prob = (double)favorevoli/estrazioni_totali;
		System.out.printf("%.9f",prob);
		System.out.println("\tt: " + (end-start)/(double)1000 + "s");
		
	}
	
	private static byte quantiCanale1Tra5(byte[] arr) {

		// resetto l'array di indici per confrontarli
		for(byte i=0; i<nestr; i++)
			rand[i] = -1;
		
		byte countCanale1 = 0;
		for(byte i=0; i<nestr; i++)
		{
			rand[i] = (short)(Math.random() * tot);
			// controllo di non aver preso un numero già scelto
			for(byte j=0; j<i; j++)
			{
				if(rand[i] == rand[j])
					i--;				
			}
		}
		
		for(byte i=0; i<nestr; i++)
		{
			if(arr[rand[i]] == 0)
				countCanale1++;						
		}
		return countCanale1;
	}
	
	
	
	public static void print(int[] arr)
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
