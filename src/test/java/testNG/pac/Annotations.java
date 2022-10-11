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
	@BeforeSuite
	public void bs() {
		System.out.println("@BeforeSuite");

	}

	@AfterSuite
	public void as() {
		System.out.println("@AfterSuite");
	}

	@BeforeTest
	public void bt() {
		System.out.println("@BeforeTest");
	}

	@AfterTest
	public void at() {
		System.out.println("@AfterTest");
	}
	@BeforeClass
	public void bc() {
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public void ac() {
		System.out.println("@AfterClass");

	}

	@BeforeMethod
	public void bm() {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void am() {
		System.out.println("@AfterMethod");
	}


}
