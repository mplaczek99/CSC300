package files.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import files.FileSystemQuery;
import ledger.LoggedTest;

/**
 * @author Tony
 */
public class FileSystemTest extends LoggedTest
{
	private static final File TEST_FOLDER = new File("src/files/test");
	
	@Test		
    @GradedTest(name="Test numberOfSubdirectories()", max_score=5)
    public void testSubDirectories() 
    {
		FileSystemQuery uut = new FileSystemQuery();
		assertEquals("The number of subdirectories does not match", 4, uut.numberOfSubdirectories(TEST_FOLDER));
		assertEquals("The number of subdirectories does not match", 0, uut.numberOfSubdirectories(new File(TEST_FOLDER.getPath() + "/a")));
    }

	@Test		
    @GradedTest(name="Test numberOfFiles()", max_score=5)
    public void testFiles() 
    {
		FileSystemQuery uut = new FileSystemQuery();
		assertEquals("The number of files does not match", 6, uut.numberOfFiles(TEST_FOLDER));
		assertEquals("The number of files does not match", 2, uut.numberOfFiles(new File(TEST_FOLDER.getPath() + "/a")));
    }

	@Test		
    @GradedTest(name="Test numberOfHiddenFiles()", max_score=5)
    public void testHiddenFiles() 
    {
		FileSystemQuery uut = new FileSystemQuery();
		assertEquals("The number of hidden files does not match", 1, uut.numberOfHiddenFiles(TEST_FOLDER));
		assertEquals("The number of hidden files does not match", 0, uut.numberOfHiddenFiles(new File(TEST_FOLDER.getPath() + "/a")));
    }

	@Test		
    @GradedTest(name="Test sizeOfContents()", max_score=5)
    public void testSize() 
    {
		FileSystemQuery uut = new FileSystemQuery();
		assertEquals("The size does not match", 0, uut.sizeOfContents(new File(TEST_FOLDER.getPath() + "/a")));
		assertEquals("The size does not match", 43, uut.sizeOfContents(new File(TEST_FOLDER.getPath() + "/b")));
    }

	private static final String CODE_FILE= "src/files/FileSystemQuery";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}