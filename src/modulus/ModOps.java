package modulus;

import java.math.BigInteger;

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
	public static BigInteger fastExp(BigInteger a, BigInteger b, BigInteger m)
	{
		int[] arr = breakUpExponent(b);
		BigInteger ans = BigInteger.ONE;

		for (int i = 0; i < arr.length; i++)
		{
			ans = ans.multiply(ans);
			ans = ans.mod(m);
			if (arr[i] == 1) ans = ans.multiply(a);
			ans = ans.mod(m);
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
	public static int[] breakUpExponent(BigInteger exp)
	{
		// Get the binary string of the exponent
		String bin = exp.toString(2);

		int[] arr = new int[bin.length()];

		// Convert to array of integers
		for (int i = 0; i < bin.length(); i++)
		{
			arr[i] = Integer.parseInt(bin.substring(i, i + 1));
		}

		return arr;
	}

	/**
	 * Returns gcd(a,b) as well as the bezout coefficients
	 * 
	 * @param a
	 * @param b
	 * @return array whose first element is the gcd of a and b. arr[0] = a*arr[1] +
	 *         b*arr[2]
	 */
	public static int[] extendedEuclid(int a, int b)
	{
		// Base case: if b is 0 then a is the gcd and a = 1*a + 0*b
		if (b == 0) return new int[] { a, 1, 0 };

		// array to keep track of intermediate values
		int[] track = extendedEuclid(b, a % b);
		int gcd = track[0];
		int x = track[2];
		int y = track[1] - ((a / b) * track[2]);

		return new int[] { gcd, x, y };
	}

}
