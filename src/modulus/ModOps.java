package modulus;

public class ModOps
{
	/**
	 * computes a^b mod m using fast exponentiation.
	 * 
	 * @param a base
	 * @param b exponent
	 * @param m modulus
	 * @return
	 */
	public static long fastExp(long a, long b, long m)
	{
		int[] arr = breakUpExponent(b);
		long ans = 1L;

		for (int i = 0; i < arr.length; i++)
		{
			ans *= ans;
			ans %= m;
			if (arr[i] == 1) ans *= a;
			ans %= m;
		}

		return ans;
	}

	/**
	 * Converts the exponent into binary
	 * 
	 * @param exp the exponent
	 * @return the binary version of the exponent in the form of an array. For
	 *         example: exp = 19 yields [1,0,0,1,1] since 19 in binary is 10011
	 */
	public static int[] breakUpExponent(long exp)
	{
		// Get the binary string of the exponent
		String bin = Long.toBinaryString(exp);

		int[] arr = new int[bin.length()];

		// Convert to array of integers
		for (int i = 0; i < bin.length(); i++)
		{
			arr[i] = Integer.parseInt(bin.substring(i, i + 1));
		}

		return arr;
	}

	/**
	 * Calculates totient of m
	 * 
	 * @param m
	 * @return //
	 */
//	public static int totient(int m)
//	{
//		
//	}

//	public static boolean isPrime()
//	{
//		
//	}
}
