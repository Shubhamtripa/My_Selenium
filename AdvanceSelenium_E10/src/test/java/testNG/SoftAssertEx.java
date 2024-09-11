package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {

	@Test
	public void m1() {
		System.out.println("first");
		System.out.println("second");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(false, true);
		System.out.println("third");
		System.out.println("fourth");
		soft.assertAll();
	}
}
