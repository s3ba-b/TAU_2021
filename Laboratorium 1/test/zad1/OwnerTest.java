package zad1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OwnerTest {
	private Owner owner;
	
	@Before
	public void setUp(){
		owner = new Owner("Sebastian", "Bobrowski");
		System.out.println("Before");
	}
	
	@After
	public void tearDown(){
		owner = null;
		System.out.println("After");
	}
	
	@Test
	public void testNameAndSurname() {
		String result = owner.Name() + " " + owner.Surname();
		assertEquals("Sebastian Bobrowski",result);
		System.out.println("Test1");
	}
	
	@Test
	public void testOwnerNotNull() {
		assertNotNull(owner);
		System.out.println("Test2");
	}
	
	@Test
	public void testNewOwnerIsSame() {
		Owner newOwner = owner;
		assertSame(newOwner, owner);
		System.out.println("Test3");
	}
}
