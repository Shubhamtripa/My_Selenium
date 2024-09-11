package testNG_Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.Base_Class;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Web_Driver_Utility;
import object_Repository.CampaignPage;
import object_Repository.Campaign_ValidationPage;
import object_Repository.Create_Campaign_Page;
import object_Repository.Create_Product_Page;
import object_Repository.HomePage;
import object_Repository.Popup_Page;
import object_Repository.ProductPage;
import object_Repository.Product_ValidationPage;

@Listeners(generic_utilities.Listener_Implementation.class)
public class Create_Campaign_With_ProductTest extends Base_Class {
	@Test(groups = "smokeTest")
	public void create_Campaign_With_ProductTest() throws Throwable
	{
		Web_Driver_Utility wlib = new Web_Driver_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();

HomePage home = new HomePage(driver);
home.getProductsLink().click();

ProductPage pImg = new ProductPage(driver);
pImg.getProPlusSign().click();

String P_Name = flib.getPropertiesData("product_Name");
int ranNum = jlib.getRandomNum();

String Product_name = P_Name+ranNum;

Create_Product_Page proData = new Create_Product_Page(driver);
proData.ProductData(Product_name);

Product_ValidationPage page = new Product_ValidationPage(driver);
String data = page.validate(driver);
Assert.assertEquals(data, P_Name);

WebElement link = home.getMoreLink();
wlib.mouseActions(driver, link);

home.getCampaignsLink().click();

CampaignPage cImg = new CampaignPage(driver);
cImg.getCampPlusSign().click();

String C_Name = flib.getPropertiesData("Campaign_Name")+ranNum;
Create_Campaign_Page camData = new Create_Campaign_Page(driver);
camData.getCamName().sendKeys(C_Name);

camData.getProductLookUPIcon().click();

wlib.switchingWindows(driver, "Products&action");

Popup_Page proPopUp = new Popup_Page(driver);
proPopUp.SearchLatest_Product(Product_name);

driver.findElement(By.xpath("//a[text()='"+Product_name+"']")).click();
wlib.switchingWindows(driver, "Campaigns&action");

camData.getSaveButton().click();
Campaign_ValidationPage page2 = new Campaign_ValidationPage(driver);
String data2 = page2.validate(driver);
Assert.assertEquals(data2, C_Name);
Thread.sleep(2000);

	}

}
