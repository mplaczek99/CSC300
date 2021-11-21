package sorting.test;

import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class TestCase
{
	public Comparable[] original;
	public Comparable[] expected;
	
	public Comparable[] getTestCase()
	{
		return Arrays.copyOf(original, original.length);
	}
}
