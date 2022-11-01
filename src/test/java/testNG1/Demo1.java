package testNG1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1 {
	
	@Test
	public void test1() {
		System.out.println("Demo");
	}
	
	@Test
	public void test2() {
		System.out.println("Demo2");
		//Assert.assertEquals(false, true);
	}
}
