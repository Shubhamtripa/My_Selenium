package testNG_Vtiger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.Base_Class;
import generic_utilities.Excel_Utility;
import generic_utilities.Java_Utility;
import object_Repository.Create_Organization_page;
import object_Repository.HomePage;
import object_Repository.OrganizationPage;
import object_Repository.Organization_ValidationPage;

@Listeners(generic_utilities.Listener_Implementation.class)
public class Create_OrganizationTest extends Base_Class {

//	@Test(groups = "smokeTest")
	@Test(retryAnalyzer = generic_utilities.RetryImp.class)
	public  void create_OrganizationTest() throws Throwable
	{
		HomePage home = new HomePage(driver);
		home.getOrganizationLink().click();
		
		OrganizationPage orgImg = new OrganizationPage(driver);
		orgImg.getOrgPlusSign().click();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String Org_Name = elib.getExcelDataUsingFormater("Organization", 0, 0)+ranNum;
		String Org_Phone = elib.getExcelDataUsingFormater("Organization", 0, 1);
		String Org_Email = elib.getExcelDataUsingFormater("Organization", 0, 2);

		Create_Organization_page orgData = new Create_Organization_page(driver);
		orgData.orgDetail(Org_Name, Org_Phone, Org_Email);	
		
		Thread.sleep(2000);
		Organization_ValidationPage page = new Organization_ValidationPage(driver);
		String data = page.validate(driver);
		Assert.assertEquals(data, Org_Name);
	}
}
