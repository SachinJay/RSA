package driver;

import java.math.BigInteger;

import utils.Constants;

public class Driver
{

	public static void main(String[] args)
	{
		PublicKey pk = new PublicKey(new BigInteger("234559"), new BigInteger("496597"));
		BigInteger phi = new BigInteger("495180");

//		System.out.println(RSA.encrypt(new BigInteger("2800"), pk));
//		System.out.println(RSA.decrypt(new BigInteger("210776"), pk, phi));

		BigInteger num = RSA.numberify("ABCDEFGHIJKlmnopqrstuvwxy z");
		System.out.println(num.toString());
		System.out.println(num.toString(Constants.CIPHER_RADIX));
		System.out.println(RSA.deNumberify(num));

	}

}
