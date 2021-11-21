package lists.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;

import ledger.LoggedTest;
import lists.MyLinkedList;
import lists.SimplifiedList;

/**
 * @author Tony
 */
public class LinkedListTester extends BaseListTester
{
	@Override
	protected SimplifiedList getUUT()
	{
		return new MyLinkedList();
	}

	@Override
	protected List<String> getExemplar()
	{
		return new LinkedList<>();
	}

	private static final String CODE_FILE= "src/lists/MyLinkedList";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}