package sorting.test.timing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tony
 */
public class Timings
{
	List<Timing> timings = new ArrayList<Timing>();
	public void add(Timing t)
	{
		timings.add(t);
	}
	
	@Override
	public String toString() 
	{
		Timing total = new Timing();
		for (Timing t : timings)
		{
			total.randomized += t.randomized;
			total.inverseSorted += t.inverseSorted;
			total.sorted += t.sorted;
			total.sorter = t.sorter;
		}
		total.randomized = total.randomized / timings.size();
		total.inverseSorted = total.inverseSorted / timings.size();
		total.sorted = total.sorted / timings.size();
		return total.toString();
	}
}