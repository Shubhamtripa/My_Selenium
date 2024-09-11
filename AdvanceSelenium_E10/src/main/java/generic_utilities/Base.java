package generic_utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	@BeforeClass
	public void BC() {
		System.out.println("Before class");
	}

	@BeforeMethod
	public void BM() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void AM() {
		System.out.println("After Mehod");
	}
	
	@AfterClass
	public void AC() {
		System.out.println("After class");
	}
}
