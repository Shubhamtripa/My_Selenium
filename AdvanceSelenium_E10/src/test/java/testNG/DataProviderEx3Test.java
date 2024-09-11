package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import object_Repository.Create_Organization_page;
import object_Repository.HomePage;
import object_Repository.LoginPage;
import object_Repository.OrganizationPage;

public class  DataProviderEx3Test{
	
	@Test(dataProvider = "readData")
	public void Create_Organization(String Org_Name, String Org_Phone, String Org_Email) throws Throwable
	{
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
	public Object readData() {
		Object[][] objArr = new Object[2][3];
	
		Java_Utility jlib = new Java_Utility();
		int ranNums = jlib.getRandomNum();
		objArr[0][0]="AAA"+ranNums;
		objArr[0][1]="687654684";
		objArr[0][2]="abc@gmail.com";
		
		objArr[1][0]="BBB"+ranNums;
		objArr[1][1]="687654684";
		objArr[1][2]="abc@gmail.com";
		return objArr;
		
	}

}
