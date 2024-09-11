package testNG_Vtiger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.Base_Class;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import object_Repository.Create_Product_Page;
import object_Repository.Delete_Product_Name;
import object_Repository.HomePage;
import object_Repository.ProductPage;
import object_Repository.Product_ValidationPage;

@Listeners(generic_utilities.Listener_Implementation.class)
public class Delete_ProductTest extends Base_Class {
	@Test(groups = "smokeTest")
	public void deleteProductTest() throws Throwable {
		HomePage home = new HomePage(driver);
		home.getProductsLink().click();

		ProductPage proImg = new ProductPage(driver);
		proImg.getProPlusSign().click();
		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
		String P_Name = flib.getPropertiesData("product_Name");
			
		int ranNum = jlib.getRandomNum();
		String Product_name = P_Name+ranNum;
			
		Create_Product_Page proData = new Create_Product_Page(driver);
		proData.ProductData(Product_name);
		
		Product_ValidationPage page = new Product_ValidationPage(driver);
		String data = page.validate(driver);
		Assert.assertEquals(data, P_Name);

		proImg.getProductText().click();
		Delete_Product_Name deletePrdName = new Delete_Product_Name(driver);
		deletePrdName.selectPrdData(driver, Product_name);
		deletePrdName.getDeleteButton().click();
		driver.switchTo().alert().accept();
		
		Thread.sleep(4000);
		deletePrdName.validate(driver, Product_name);
	}

}
