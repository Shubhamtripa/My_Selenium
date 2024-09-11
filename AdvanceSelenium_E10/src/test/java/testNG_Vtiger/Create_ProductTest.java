package testNG_Vtiger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.Base_Class;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import object_Repository.Create_Product_Page;
import object_Repository.HomePage;
import object_Repository.ProductPage;
import object_Repository.Product_ValidationPage;

@Listeners(generic_utilities.Listener_Implementation.class)
public class Create_ProductTest extends Base_Class{
	@Test(retryAnalyzer = generic_utilities.RetryImp.class)
	public void CreateProductTest() throws Throwable
	{
		HomePage home = new HomePage(driver);
		home.getProductsLink().click();
		
		ProductPage pImg = new ProductPage(driver);
		pImg.getProPlusSign().click();


		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		File_Utility flib = new File_Utility();
		String P_Name = flib.getPropertiesData("product_Name")+ranNum;
		
//		Assert.assertEquals(false, true);
		Create_Product_Page proData = new Create_Product_Page(driver);
		proData.ProductData(P_Name);
		Thread.sleep(2000);
		
//		 String actData = driver.findElement(By.id("dtlview_Product Name")).getText();
		Product_ValidationPage page = new Product_ValidationPage(driver);
//		String data = page.validate(driver);
		String data = page.validate2(driver, P_Name);
		Assert.assertEquals(data, P_Name);
	}

}
