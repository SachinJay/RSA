package driver;

import java.math.BigInteger;

public class Driver
{

	public static void main(String[] args)
	{
		PublicKey pk = new PublicKey(new BigInteger("234559"), new BigInteger("496597"));
		BigInteger phi = new BigInteger("495180");

		System.out.println(RSA.encrypt(new BigInteger("2800"), pk));
		System.out.println(RSA.decrypt(new BigInteger("210776"), pk, phi));

	}

}
