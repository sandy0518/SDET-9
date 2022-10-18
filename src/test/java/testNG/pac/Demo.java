package testNG.pac;

import org.testng.annotations.Test;

public class Demo  extends Annotations

{

	@Test()
	public void test2() {
		System.out.println("12");
	}

	@Test(groups = "regression")
	public void test4() {
		System.out.println("regressiuon");
		
	}
	@Test(groups = "integration")
	public void test3() {
		System.out.println("integration");

	}
}