package sorting.test.timing;

import sorting.Sorter;

/**
 * @author Tony
 */
public class Timing
{
	Sorter sorter;
	long randomized;
	long sorted;
	long inverseSorted;
	
	@Override
	public String toString() 
	{
		return sorter.getClass().getName() + ".......\nTiming on Random: " + randomized +
				"\nTiming on Sorted: " + sorted +
				"\nTiming on Inverse Sorted: " + inverseSorted;
	}
}
