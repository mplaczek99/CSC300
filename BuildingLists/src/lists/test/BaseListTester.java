package lists.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import ledger.LoggedTest;
import lists.SimplifiedList;

/**
 * @author Tony
 */
public abstract class BaseListTester extends LoggedTest
{
	protected abstract SimplifiedList getUUT();
	protected abstract List<String> getExemplar();

    String[] testValues     = {"a", "b", "c", "d", "e"};
    String[] advancedValues = {"a", "b", "a", "d", "b"};
    
	@Test		
    @GradedTest(name="Test Empty()", max_score=5)
    public void testEmpty()
    {
		SimplifiedList uut = getUUT();
        assertEquals("Expected the list size to be zero", 0, uut.size());
        assertTrue("Expected the list to be empty", uut.isEmpty());
        
        assertNull("The list should not have returned anything on remove", uut.remove(1));
        assertNull("The list should not have returned anything on get", uut.get(1));
        assertNull("The list should not have returned anything on set", uut.set(1, null));

        uut.add("junk");
        assertEquals("Expected the list to no longer be zero", 1, uut.size());
        assertFalse("Expected the list to no longer be empty", uut.isEmpty());
        
    }

	@Test		
    @GradedTest(name="Test add()", max_score=5)
    public void testAdd()
    {
		SimplifiedList uut = getUUT();
        int count = 0;
        for (String value : testValues)
        {
        	assertTrue("Did not return true when it should have added",uut.add(value)); 
            count = count + 1;
            assertEquals("Size did not match after add", count, uut.size());
        }      
    }
        
	@Test		
    @GradedTest(name="Test get()", max_score=5)
    public void testGet()
    {
		SimplifiedList uut = getUUT();
		fillList(uut, testValues);
        for(int i = 0; i < testValues.length; i++)
        {
        	assertEquals("The value at index " + i + " did not match", testValues[i], uut.get(i));
        }
    }
	
	@Test		
    @GradedTest(name="Test set()", max_score=5)
    public void testSet()
    {
		SimplifiedList uut = getUUT();
		fillList(uut, testValues);
        for(int i = 0; i < testValues.length; i++)
        {
            int reverseValue = testValues.length - 1 - i;
            assertEquals("The value returned from set at index "+ i + " did not match the original added value", testValues[i], uut.set(i, testValues[reverseValue]));
            assertEquals("The new value at index " + i + " is not the newly set value", testValues[reverseValue], uut.get(i)); 
        }
    }
	
	@Test		
    @GradedTest(name="Test clear()", max_score=5)
    public void testClear()
    {
		SimplifiedList uut = getUUT();
		fillList(uut, testValues);
        uut.clear();
        assertEquals("Expected the list size to be zero", 0, uut.size());
        assertTrue("Expected the list to be empty", uut.isEmpty());
        for (int i = 0; i < testValues.length; i++)
        {
        	assertNull("The list returned a value at index " + i + " that should be null", uut.get(i));
        }
        uut.add("junk");
        assertEquals("Expected the list size to no longer be zero", 1, uut.size());
        assertFalse("Expected the list to no longer be empty", uut.isEmpty());
    }
        
	@Test		
    @GradedTest(name="Test remove()", max_score=10)
    public void testRemove()
    {
		SimplifiedList uut = getUUT();
        fillList(uut, testValues);
        for(int i = 0; i < testValues.length; i++)
        {
        	assertEquals("The returned value from remove does not match the expected", testValues[i], uut.remove(0));
        	assertEquals("The size does not match expected", testValues.length - (i + 1), uut.size());
        }

    	assertEquals("The size is not zero after removing all values", 0, uut.size());
        assertTrue("List is not empty after removing all values", uut.isEmpty());
        fillList(uut, testValues);
        for(int i = testValues.length - 1; i >= 0; i--)
        {
        	assertEquals("The returned value from remove does not match the expected", testValues[i], uut.remove(i));
        	assertEquals("The size does not match expected", i, uut.size());
        }

    	assertEquals("The size is not zero after removing all values", 0, uut.size());
        assertTrue("List is not empty after removing all values", uut.isEmpty());
        fillList(uut, testValues);
        List<String> exemplar = getExemplar();
        for (String value : testValues)
        {
            exemplar.add(value);
        }
        while(! exemplar.isEmpty())
        {
            int index = exemplar.size()/2;
        	assertEquals("The returned value from remove does not match the expected", exemplar.remove(index), uut.remove(index));
        	assertEquals("The size does not match expected", exemplar.size(), uut.size());
        }
    	assertEquals("The size is not zero after removing all values", 0, uut.size());
        assertTrue("List is not empty after removing all values", uut.isEmpty());
    }
    
	@Test		
    @GradedTest(name="Test index edge cases", max_score=5)
    public void testEdgeCases()
    {
		SimplifiedList uut = getUUT();
        fillList(uut, testValues);
        assertNull("A get with the index parameter of -1 should return null", uut.get(-1));
        assertNull("A set with the index parameter of -1 should return null", uut.set(-1, "!"));
        assertNull("A remove with the index parameter of -1 should return null", uut.remove(-1));

        assertNull("A get with the index parameter of " + testValues.length + " should return null", uut.get(testValues.length));
        assertNull("A set with the index parameter of " + testValues.length + " should return null", uut.set(testValues.length, "!"));
        assertNull("A remove with the index parameter of " + testValues.length + " should return null", uut.remove(testValues.length));

        int oldLength = testValues.length;
        uut.add("junk");
        assertNotNull("A get with the index parameter of " + testValues.length + " should return null", uut.get(oldLength));
        assertNotNull("A set with the index parameter of " + testValues.length + " should return null", uut.set(oldLength, "!"));
        assertNotNull("A remove with the index parameter of " + testValues.length + " should return null", uut.remove(oldLength));
    }

	@Test		
    @GradedTest(name="Test contains()", max_score=5)
    public void testContains()
    {
		SimplifiedList uut = getUUT();
		assertFalse("List returned true on an empty list for value \"!\"", uut.contains("!"));
		
        fillList(uut, advancedValues);
        for (String value : advancedValues)
        {
        	assertTrue("List did not contain the expected value of " + value, uut.contains(value));
        }
    	assertFalse("List reported that it contains the value \"!\"", uut.contains("!"));
    }

	@Test		
    @GradedTest(name="Test indexOf()", max_score=5)
    public void testIndexOf()
    {
		SimplifiedList uut = getUUT();
		fillList(uut, advancedValues);
		List<String> exemplar = getExemplar(); 
        for (String value : advancedValues)
        {
            exemplar.add(value);
        }
        for (String value : advancedValues)
        {
        	assertEquals("The first index of value did not match the expected", exemplar.indexOf(value), uut.indexOf(value));
        }
        assertEquals("The list reported a value other than -1 for the invalid entry \"!\"", -1, uut.indexOf("!"));

        assertEquals("Should have reported -1 for the non-existing item \"!\"", -1, uut.indexOf("!"));
    }
	
	
	@Test		
    @GradedTest(name="Test lastIndexOf()", max_score=5)
    public void testLastIndexOf()
    {
		SimplifiedList uut = getUUT();
		fillList(uut, advancedValues);
		List<String> exemplar = getExemplar();
        for (String value : advancedValues)
        {
            exemplar.add(value);
        }
        for (String value : advancedValues)
        {
        	assertEquals("The first index of value did not match the expected", exemplar.lastIndexOf(value), uut.lastIndexOf(value));
        }
        assertEquals("The list reported a value other than -1 for the invalid entry \"!\"", -1, uut.indexOf("!"));

        assertEquals("Should have reported -1 for the non-existing item \"!\"", -1, uut.lastIndexOf("!"));
    }

	@Test		
    @GradedTest(name="Test remove(value)", max_score=10)
    public void testRemoveValue()
    {
		SimplifiedList uut = getUUT();
		fillList(uut, advancedValues);
		int size = advancedValues.length;
        for(String original : advancedValues)
        {
        	assertTrue("List reported it did not remove the value " + original, uut.remove(original));
        	assertEquals("The size does not match expected", --size, uut.size());
        }

    	assertEquals("The size is not zero after removing all values", 0, uut.size());
        assertTrue("List is not empty after removing all values", uut.isEmpty());
        fillList(uut, advancedValues);
		size = advancedValues.length;
        for(int i = advancedValues.length - 1; i >= 0; i--)
        {
        	assertTrue("List reported it did not remove the value " + advancedValues[i], uut.remove(advancedValues[i]));
        	assertEquals("The size does not match expected", --size, uut.size());
        }
        
        assertFalse("Should have reported false for the non-existing item \"!\"", uut.remove("!"));
    }

	/**
     * Fills the provided list with the test values.
     * Should be classed after the Happy Path test of add is confirmed
     * @param list the list to fill
     */
    private void fillList(SimplifiedList list, String[] with)
    {
        for (String value : with)
        {
            list.add(value);
        }        
    }
}