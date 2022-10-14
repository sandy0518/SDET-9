package testNG1;

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
	public void bS() {
		System.out.println("@BeforeSuit");
	}
	
	@AfterSuite
	public void aS() {
		System.out.println("@AfterSuit");
	}
	
	@BeforeTest
	public void bT() {
		System.out.println("@BeforeTest");
	}
	
	@AfterTest
	public void aT() {
		System.out.println("@AfterTest");
	}
	
	@BeforeClass
	public void bC() {
		System.out.println("@BeforeClass");
	}
	
	@AfterClass
	public void aC() {
		System.out.println("@AfterClass");
	}
	
	@BeforeMethod
	public void bM() {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void aM() {
		System.out.println("@AfterMethod");
	}
	
}
