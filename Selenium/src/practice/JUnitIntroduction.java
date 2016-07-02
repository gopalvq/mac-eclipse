/**
 * 
 */
package practice;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Venu
 *
 */
public class JUnitIntroduction {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executes before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executed after class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Executes before every class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("Executes after every class");
	}

	@Test
	public void test() {
		System.out.println("Executes test...");
		//fail("Not yet implemented");
	}
	
	@Test
	public void test1(){
		System.out.println("Executes test1...");
	}

}
