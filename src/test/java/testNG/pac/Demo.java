package testNG.pac;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo 

{

	@Test(dependsOnMethods = "test4", priority=-1)
	public void test2() {
		System.out.println("test 2 done");
	}

	@Test(priority = 2)
	public void test4() {
		System.out.println("test 4 done");
		Assert.assertEquals(false, false);
	}
//	@Test()
//	public void test3() {
//		System.out.println("test 3 done");
//
//	}
}