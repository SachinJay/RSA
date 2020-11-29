package driver;

import java.math.BigInteger;

import modulus.ModOps;
import primes.PrimeOps;
import utils.Constants;

public class RSA
{

//	public static PublicKey genPublicKey()
//	{
//		
//
//	}

	/**
	 * Creates the modulus
	 * 
	 * @return array <b>arr</b> such that <b>arr[0]</b> is the modulus and
	 *         <b>arr[1]</b> is totient of the modulus (keep it secret, keep it
	 *         safe)
	 */
	private static BigInteger[] genModulus()
	{
		BigInteger p = PrimeOps.genPrime(Constants.PRIME_BITS);
		BigInteger q = PrimeOps.genPrime(Constants.PRIME_BITS);

		BigInteger pMinusOne = p.subtract(BigInteger.ONE);
		BigInteger qMinusOne = q.subtract(BigInteger.ONE);

		BigInteger phi = pMinusOne.multiply(qMinusOne);
		BigInteger m = p.multiply(q);

		return new BigInteger[] { m, phi };
	}

	/**
	 * Checks to see if the common encryption key works for phi, o.w. finds another
	 * 
	 * @param phi, the totient of the modulus
	 * @return the encryption key
	 */
	private static BigInteger genEncryptionKey(BigInteger phi)
	{
		if (ModOps.extendedEuclid(phi, Constants.COMMON_E)[0].equals(BigInteger.ONE)) return Constants.COMMON_E;

		BigInteger encryptionKey = Constants.COMMON_E;

		while (!ModOps.extendedEuclid(phi, encryptionKey)[0].equals(BigInteger.ONE))
		{
			encryptionKey = encryptionKey.add(BigInteger.TWO);
		}

		return encryptionKey;
	}

	/**
	 * 
	 * @param e   the encryption key
	 * @param phi the modulus for which we are trying <b>e</b>'s inverse
	 * @return the decryption key d such that <b>e*d = 1 mod phi <b>
	 */
	public static BigInteger getDecryptionKey(BigInteger e, BigInteger phi)
	{
		return ModOps.extendedEuclid(e, phi)[1];
	}

	/**
	 * 
	 * @param message
	 * @param key
	 * @return the ciphertext
	 */
	public static BigInteger encrypt(BigInteger message, PublicKey key)
	{
		return ModOps.fastExp(message, key.getEncryptionKey(), key.getModulus());

	}

	/**
	 * Decrypts the ciphertext
	 * 
	 * @param ciphertext the encrypted message
	 * @param key        the public key
	 * @param phi        the private phi
	 * @return the original message
	 */
	public static BigInteger decrypt(BigInteger ciphertext, PublicKey key, BigInteger phi)
	{
		BigInteger d = getDecryptionKey(key.getEncryptionKey(), phi);
		return ModOps.fastExp(ciphertext, d, key.getModulus());

	}
}
