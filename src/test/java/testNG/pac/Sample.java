package testNG.pac;

import org.testng.annotations.Test;

public class Sample extends Annotations
{
	
	@Test(groups="smoke")
	public void createaccount() {
		System.out.println("Smoke ");
	}
	@Test(groups="regression")
	public void createOrg() {
		System.out.println("regression");
	}
	
	@Test(groups = {"integration","smoke","regression"})
	public void allconditions() {
		System.out.println("allconditions");
	}
	
	
	
	
	
	
	
}
