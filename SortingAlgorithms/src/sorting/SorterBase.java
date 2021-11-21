package sorting;

/**
 * @author Tony
 */
@SuppressWarnings("rawtypes")
public abstract class SorterBase implements Sorter 
{
	/**
	 * Compares two values where me < other
	 * @param me the value to compare
	 * @param other the other value t
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	protected boolean less(Comparable me, Comparable other)
	{
		return me.compareTo(other) < 0;
	}
	
	protected void swap(Comparable[] target, int first, int second)
	{
		Comparable temp = target[first];
		target[first]   = target[second];
		target[second]  = temp;
	}
}