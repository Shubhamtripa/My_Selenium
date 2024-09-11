package testNG_Vtiger;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.Base_Class;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import object_Repository.CampaignPage;
import object_Repository.Create_Campaign_Page;
import object_Repository.Create_Organization_page;
import object_Repository.Create_Product_Page;
import object_Repository.HomePage;
import object_Repository.OrganizationPage;
import object_Repository.ProductPage;

@Listeners(generic_utilities.Listener_Implementation.class)
public class Multiple_MethodsTest extends Base_Class {
	
	@Test(groups = "smokeTest")
	public  void create_OrganizationTest() throws Throwable
	{
		HomePage home = new HomePage(driver);
		home.getOrganizationLink().click();
		
		OrganizationPage orgImg = new OrganizationPage(driver);
		orgImg.getOrgPlusSign().click();
		
		Excel_Utility elib = new Excel_Utility();
		String orgName = elib.getExcelData("Sheet1", 0, 0);
		String orgPhone = elib.getExcelData("Sheet1", 0, 1);
		String orgMail = elib.getExcelData("Sheet1", 0, 2);

		Create_Organization_page orgData = new Create_Organization_page(driver);
		orgData.orgDetail(orgName, orgPhone, orgMail);		
	}
	
	@Test(groups = {"smokeTest","regressionTest"})
	public void CreateProductTest() throws Throwable
	{
		HomePage home = new HomePage(driver);
		home.getProductsLink().click();
		
		ProductPage pImg = new ProductPage(driver);
		pImg.getProPlusSign().click();

		File_Utility flib = new File_Utility();
		String P_Name = flib.getPropertiesData("product_Name");

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Create_Product_Page proData = new Create_Product_Page(driver);
		proData.ProductData(P_Name+ranNum);
		Thread.sleep(2000);
	}
	
	@Test(groups = "regressionTest")
	public void createCampaignTest() throws Throwable {
		
		HomePage home = new HomePage(driver);
		
		Actions act = new Actions(driver);
		act.moveToElement(home.getMoreLink()).perform();
		home.getCampaignsLink().click();

		CampaignPage camImg = new CampaignPage(driver);
		camImg.getCampPlusSign().click();
		Excel_Utility elib = new Excel_Utility();
		String C_name = elib.getExcelData("Sheet1", 0, 0);
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		Create_Campaign_Page cData =new Create_Campaign_Page(driver);
		cData.campaignData(C_name+ranNum);

		Thread.sleep(4000);
	}

}
