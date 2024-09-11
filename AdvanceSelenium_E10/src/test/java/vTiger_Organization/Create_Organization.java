package vTiger_Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Web_Driver_Utility;
import object_Repository.Create_Organization_page;
import object_Repository.HomePage;
import object_Repository.LoginPage;
import object_Repository.OrganizationPage;

public class Create_Organization {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
WebDriver driver;
//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
Web_Driver_Utility wlib = new Web_Driver_Utility();
File_Utility flib= new File_Utility();

String browser = flib.getPropertiesData("Browser");

if(browser.equalsIgnoreCase("Chorme"))
{
	driver = new ChromeDriver();
}
else if(browser.equalsIgnoreCase("edge"))
{
	driver = new  EdgeDriver();
}
else if(browser.equalsIgnoreCase("firefox"))
{
	driver = new  FirefoxDriver();
}
else {
	driver = new ChromeDriver();
}


wlib.maximizeWindow(driver);
wlib.waitElementToLoad(driver);

//driver.get("http://localhost:8888/");

////login into Vtiger application
//driver.findElement(By.name("user_name")).sendKeys("admin");
//driver.findElement(By.name("user_password")).sendKeys("admin");
//driver.findElement(By.id("submitButton")).click();

//reading Data from property file
String URL = flib.getPropertiesData("url");
String UserName = flib.getPropertiesData("user_Name");
String Password = flib.getPropertiesData("password");

driver.get(URL);
//driver.findElement(By.name("user_name")).sendKeys(UserName);
//driver.findElement(By.name("user_password")).sendKeys(Password);
//driver.findElement(By.id("submitButton")).click();

////using getter method
//LoginPage login = new LoginPage(driver);
//login.getUserTextField().sendKeys(UserName);
//login.getPasswordTextField().sendKeys(Password);
//login.getLoginButton().click();

LoginPage login = new LoginPage(driver);
login.LoginTOApp(UserName, Password);

//click on organization link
//driver.findElement(By.linkText("Organizations")).click();
HomePage home = new HomePage(driver);
home.getOrganizationLink().click();

//click on organization lookup image
//driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
OrganizationPage oImg = new OrganizationPage(driver);
oImg.getOrgPlusSign().click();

Java_Utility jlib = new Java_Utility();
int ranNum = jlib.getRandomNum();

//Enter organization name,phone number and email from Property file
//String Org_Name = flib.getPropertiesData("Organization_Name");
//String Org_Phone = flib.getPropertiesData("Organization_Phone");
//String Org_Email = flib.getPropertiesData("Organization_Email");

//Enter organization name,phone number and email from Excel file
Excel_Utility elib = new Excel_Utility();
String Org_Name = elib.getExcelDataUsingFormater("Organization", 0, 0)+ranNum;
String Org_Phone = elib.getExcelDataUsingFormater("Organization", 0, 1);
String Org_Email = elib.getExcelDataUsingFormater("Organization", 0, 2);

//driver.findElement(By.name("accountname")).sendKeys(Org_Name+ranNum);
//driver.findElement(By.id("phone")).sendKeys(Org_Phone);
//driver.findElement(By.name("email1")).sendKeys(Org_Email);

////click on save Button
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Create_Organization_page create = new Create_Organization_page(driver);
create.orgDetail(Org_Name+ranNum, Org_Phone, Org_Email);
Thread.sleep(3000);
// Logout from the application
//driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']")).click();
//driver.findElement(By.linkText("Sign Out")).click();

//home.getAdminLink().click();
//home.getSignOutLink().click();

home.LogOutFromApp(driver);
driver.close();
}

}
