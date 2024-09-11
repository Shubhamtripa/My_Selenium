package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	@Test
	public void m1() {
		System.out.println("first");
		System.out.println("second");
		Assert.assertEquals(false, true);
		System.out.println("third");
		System.out.println("fourth");
	}
	@Test
	public void m2() {
		String expData ="shubham";
		String actData ="shubham";
		Assert.assertEquals(actData, expData);
	}

}
