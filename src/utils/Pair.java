package utils;

public class Pair<A, B>
{
	private A first;
	private B second;

	public Pair(A ob1, B ob2)
	{
		this.setFirst(ob1);
		this.setSecond(ob2);
	}

	/**
	 * @return the first
	 */
	public A getFirst()
	{
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(A first)
	{
		this.first = first;
	}

	/**
	 * @return the second
	 */
	public B getSecond()
	{
		return second;
	}

	/**
	 * @param second the second to set
	 */
	public void setSecond(B second)
	{
		this.second = second;
	}
}
