package driver;

import java.math.BigInteger;

/**
 * class to represent the public key pair in RSA
 * 
 * @author sachi
 *
 */
public class PublicKey
{
	private BigInteger encryptionKey;
	private BigInteger modulus;

	/**
	 * Constructs the public key pair
	 * 
	 * @param e the encryption key
	 * @param m the modulus
	 */
	public PublicKey(BigInteger e, BigInteger m)
	{
		setEncryptionKey(e);
		setModulus(m);
	}

	/**
	 * @return the encryptionKey
	 */
	public BigInteger getEncryptionKey()
	{
		return encryptionKey;
	}

	/**
	 * @param encryptionKey the encryptionKey to set
	 */
	public void setEncryptionKey(BigInteger encryptionKey)
	{
		this.encryptionKey = encryptionKey;
	}

	/**
	 * @return the modulus
	 */
	public BigInteger getModulus()
	{
		return modulus;
	}

	/**
	 * @param modulus the modulus to set
	 */
	public void setModulus(BigInteger modulus)
	{
		this.modulus = modulus;
	}

}
