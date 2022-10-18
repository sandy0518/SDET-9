package testNG.pac;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Annotations {
	@BeforeSuite(groups="smoke")
	public void bs() {
		System.out.println("@BeforeSuite");

	}

	@AfterSuite(groups="smoke")
	public void as() {
		System.out.println("@AfterSuite");
	}

	@BeforeTest(groups="regression")
	public void bt() {
		System.out.println("@BeforeTest");
	}

	@AfterTest(groups="regression")
	public void at() {
		System.out.println("@AfterTest");
	}
	@BeforeClass(groups="integration")
	public void bc() {
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public void ac() {
		System.out.println("@AfterClass");

	}

	@BeforeMethod(groups= {"smoke","integration","regression"})
	public void bm() {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod(groups= {"smoke","integration","regression"})
	public void am() {
		System.out.println("@AfterMethod");
	}


}
