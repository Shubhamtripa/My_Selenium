package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import object_Repository.Create_Organization_page;
import object_Repository.HomePage;
import object_Repository.LoginPage;
import object_Repository.OrganizationPage;

public class DataProviderEx4Test {

	@Test(dataProvider = "readData")
	public void organizationModuleTest(String Org_Name, String Org_Phone, String Org_Email) throws Throwable {
	WebDriver driver = new ChromeDriver();
	File_Utility flib = new File_Utility();
	Java_Utility jlib = new Java_Utility();

	String URL = flib.getPropertiesData("url");
	String UserName = flib.getPropertiesData("user_Name");
	String Password = flib.getPropertiesData("password");
	
	driver.get(URL);
	LoginPage login = new  LoginPage(driver);
	login.LoginTOApp(UserName, Password);
	HomePage home = new HomePage(driver);
	home.getOrganizationLink().click();
	
	OrganizationPage orgImg = new OrganizationPage(driver);
	orgImg.getOrgPlusSign().click();
	int ranNum = jlib.getRandomNum();

	Create_Organization_page orgData = new Create_Organization_page(driver);
	orgData.orgDetail(Org_Name+ranNum, Org_Phone, Org_Email);
	Thread.sleep(2000);
	home.LogOutFromApp(driver);
	driver.quit();
	}
	
	@DataProvider
	public Object[][] readData() throws Throwable
	{
		Excel_Utility elib = new Excel_Utility();
		Object[][] value = elib.getDataProviderData("DataProvider");
		return value;
		
	}
	
}
