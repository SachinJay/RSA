package driver;

import java.math.BigInteger;

import utils.Constants;
import utils.Pair;

public class Driver
{

	public static void main(String[] args)
	{
//		PublicKey pk = new PublicKey(new BigInteger("234559"), new BigInteger("496597"));
//		BigInteger phi = new BigInteger("495180");

//		System.out.println(RSA.encrypt(new BigInteger("2800"), pk));
//		System.out.println(RSA.decrypt(new BigInteger("210776"), pk, phi));

		BigInteger num = RSA.numberify("ABCDEFGHIJKlmnopqrstuvwxy z");
		System.out.println(num.toString());
		System.out.println(num.toString(Constants.CIPHER_RADIX));
		System.out.println(RSA.deNumberify(num));

//		BigInteger ciphertxt = RSA.encrypt(num, pk);
//		System.out.println("Cyphertext: " + ciphertxt);
//		System.out.println("Message: " + RSA.deNumberify(RSA.decrypt(ciphertxt, pk, phi)));

		Pair<PublicKey, BigInteger> p = RSA.genPublicKey();
		PublicKey pk = p.getFirst();
		BigInteger d = p.getSecond();

		BigInteger ciphertext = RSA.encrypt(num, pk).mod(pk.getModulus());
		System.out.println(ciphertext);
		BigInteger decrypted = RSA.decrypt(ciphertext, pk, d);
		System.out.println(decrypted);
		String msg = RSA.deNumberify(decrypted);
		System.out.println("Original: " + msg);

	}

}
