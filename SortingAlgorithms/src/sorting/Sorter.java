package sorting;

/**
 * @author Tony
 */
public interface Sorter 
{
	/**
	 * Sort the array in place using your chosen algorithm
	 * @param target the array to sort
	 */
	@SuppressWarnings("rawtypes")
	public void sort(Comparable[] target);
}