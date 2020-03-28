package modulus;

public class ModOps
{
	/**
	 * Reduces a number mod another number
	 * @param a number to be reduced
	 * @param m modulus
	 * @return a reduced mod m
	 */
	public static long reduceMod(long a, long m)
	{
		if(m <= 0) throw new IllegalArgumentException("modulus most be positive integer");
		
		if(a < 0)
		{
			//Simply multiply by 1 mod m
			//But to make it a positive number the one must be a negative number
			//So multiply by 1-m which still is congruent to 1 mod m
			
			return reduceMod(a * (1-m), m);
		}
		else
		{
			if(a<m) return a;
			return a%m;
		}
	}
	
	/**
	 * Gives remainder when dividing two numbers
	 * @param a dividend
	 * @param b divisor
	 * @return remainder of a/b
	 * @throws IllegalArgumentException if a<=0, b<=0, or a < b
	 */
	public static long getRemainder(long a, long b)
	{
		if(a <= 0 || b <= 0 || a < b)
		{
			throw new IllegalArgumentException("First number must be >= 0\nSecond number must be >=0"
					+ "\nFirst number must be >= second");			
		}
		
		long quotient = 0;
		long remainder = 0;
		
		quotient = a/b;
		
		remainder = a - (b*quotient);
		
		return remainder;
		
	}

	/**
	 * computes a^b mod m
	 * @param a base
	 * @param b exponent
	 * @param m modulus
	 * @return
	 */
	public static long fastExp(long a, long b, long m)
	{
		int[] arr =	breakUpExponent(b);	
		long ans = 1L; 
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == 1)
			{
				if( i == 0)
				{
					ans = reduceMod(a,m);
				}
				else
				{
					for(int j = 0; j < i; j++)
					{
						ans = reduceMod(ans * reduceMod(a*a,m),m);
					}
				}
			}
		}
		
		ans = reduceMod(ans, m);
		return ans;
	}
	
	private static int[] breakUpExponent(long exp)
	{
		String bin = Long.toBinaryString(exp);
		String revBin = reverseStr(bin);
		
		int[] arr = new int[bin.length()];
		
		for(int i = 0; i < revBin.length(); i++)
		{
			arr[i] = Integer.parseInt(revBin.substring(i, i+1));
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		return arr;
	}
	
	private static String reverseStr(String str) 
	{
	    StringBuilder output = new StringBuilder(str).reverse();
	    return output.toString();
	}
	
	
	
	/**
	 * Calculates totient of m
	 * @param m
	 * @return
//	 */
//	public static int totient(int m)
//	{
//		
//	}
	
//	public static boolean isPrime()
//	{
//		
//	}
}
