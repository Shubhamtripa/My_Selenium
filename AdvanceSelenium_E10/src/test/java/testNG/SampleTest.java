package testNG;

import org.testng.annotations.Test;

public class SampleTest {
/*	//@Test annotation will run all methods Alphabetical order
	@Test
	public void createProduct()
	{
		System.out.println("Create Product");
	}
	
	@Test()
	public void modifyProduct()
	{
		System.out.println("Modify Product");
	}
	@Test
	public void deleteProduct()
	{
		System.out.println("Delete Product");
	}
*/
	
/*	//These @Test annotation will execute as prioritized
	@Test(priority = 0)
	public void createProduct()
	{
		System.out.println("Create Product");
	}
	
	@Test(priority = 1)
	public void modifyProduct()
	{
		System.out.println("Modify Product");
	}
	@Test(priority = 3)
	public void deleteProduct()
	{
		System.out.println("Delete Product");
	}
*/
/*	//Depends on Method will work if independent method will execute successfully
	@Test
	public void createProduct()
	{
		System.out.println("Create Product");
	}
	
	@Test(dependsOnMethods = "createProduct")
	public void modifyProduct()
	{
		System.out.println("Modify Product");
	}
	@Test(dependsOnMethods = "createProduct")
	public void deleteProduct()
	{
		System.out.println("Delete Product");
	}
*/
	
	//this method will help to execute single method multiple time
	@Test(invocationCount = 3)
	public void createProduct()
	{
		System.out.println("Create Product");
	}
	
	@Test()
	public void modifyProduct()
	{
		System.out.println("Modify Product");
	}
	@Test
	public void deleteProduct()
	{
		System.out.println("Delete Product");
	}
}
