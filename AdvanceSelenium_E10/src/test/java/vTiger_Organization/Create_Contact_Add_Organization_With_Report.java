package vTiger_Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Web_Driver_Utility;
import object_Repository.ContactPage;
import object_Repository.Create_Contact_Page;
import object_Repository.Create_Organization_page;
import object_Repository.HomePage;
import object_Repository.LoginPage;
import object_Repository.OrganizationPage;
import object_Repository.Popup_Page;

public class Create_Contact_Add_Organization_With_Report {

	public static void main(String[] args) throws Throwable {

WebDriver driver = new ChromeDriver();
Web_Driver_Utility wlib = new Web_Driver_Utility();
File_Utility flib = new File_Utility();
Java_Utility jlib = new Java_Utility();
Excel_Utility elib = new Excel_Utility();

wlib.maximizeWindow(driver);
wlib.waitElementToLoad(driver);
			
String URL = flib.getPropertiesData("url");
String UserName = flib.getPropertiesData("user_Name");
String Password = flib.getPropertiesData("password");
			
driver.get(URL);
//driver.findElement(By.name("user_name")).sendKeys(UserName);
//driver.findElement(By.name("user_password")).sendKeys(Password);
//driver.findElement(By.id("submitButton")).click();

LoginPage login = new LoginPage(driver);
login.LoginTOApp(UserName, Password);

HomePage home = new HomePage(driver);
home.getContactsLink().click();
//driver.findElement(By.linkText("Contacts")).click();

ContactPage conImg = new ContactPage(driver);
conImg.getConPlusSign().click();
//driver.findElement(By.cssSelector("[alt='Create Contact...']")).click();

int ranNum = jlib.getRandomNum();

Create_Contact_Page conData = new Create_Contact_Page(driver);
WebElement dd =conData.getSalutationDropDown();
//WebElement dd = driver.findElement(By.name("salutationtype"));

wlib.dropDown_SelectByIndex(dd,5);
String f_Name = elib.getExcelData("Sheet1", 1, 1);
String l_Name = elib.getExcelData("Sheet1", 2, 1);
 
//driver.findElement(By.name("firstname")).sendKeys(f_Name);
//driver.findElement(By.name("lastname")).sendKeys(l_Name+" "+ranNum);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
conData.ContactData(f_Name, l_Name+" "+ranNum);

//driver.findElement(By.linkText("Organizations")).click();
home.getOrganizationLink().click();

//driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
OrganizationPage orgImg = new OrganizationPage(driver);
orgImg.getOrgPlusSign().click();

String Org_Name = flib.getPropertiesData("Organization_Name");

//driver.findElement(By.name("accountname")).sendKeys(Org_Name+ranNum);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Create_Organization_page orgData = new Create_Organization_page(driver);
orgData.getOrgName().sendKeys(Org_Name+ranNum);
orgData.getSaveButton().click();

Thread.sleep(2000);
//driver.findElement(By.linkText("Contacts")).click();
home.getContactsLink().click();
//driver.findElement(By.cssSelector("[alt='Create Contact...']")).click();
conImg.getConPlusSign().click();

//WebElement dd1 = driver.findElement(By.name("salutationtype"));
WebElement dd1 = conData.getSalutationDropDown();
wlib.dropDown_SelectByIndex(dd1,1);
String f_Name2 = elib.getExcelData("Sheet1", 1, 0);
String l_Name2 = elib.getExcelData("Sheet1", 2, 0);

//driver.findElement(By.name("firstname")).sendKeys(f_Name2);
//driver.findElement(By.name("lastname")).sendKeys(l_Name2+ranNum);
conData.getFirstName().sendKeys(f_Name2);
conData.getLastName().sendKeys(l_Name2+ranNum);

//driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
conData.getOrgLookUPIcon().click();
wlib.switchingWindows(driver, "Accounts&action");

//driver.findElement(By.id("search_txt")).sendKeys(Org_Name+ranNum);
//driver.findElement(By.name("search")).click();

Popup_Page proPopUp = new Popup_Page(driver);
proPopUp.SearchLatest_Product(Org_Name+ranNum);

driver.findElement(By.xpath("//a[text()='"+Org_Name+ranNum+"']")).click();
wlib.switchingWindows(driver, "Contacts&action");
Thread.sleep(2000);
//driver.findElement(By.xpath("(//img[@style='cursor:hand;cursor:pointer'])[2]")).click();
conData.getContactLookUPIcon().click();

wlib.switchingWindows(driver, "Popup&html");

//driver.findElement(By.id("search_txt")).sendKeys(l_Name+" "+ranNum);
//driver.findElement(By.name("search")).click();
proPopUp.SearchLatest_Product(l_Name+" "+ranNum);

driver.findElement(By.xpath("//a[contains(text(),'"+ranNum+"')]")).click();

wlib.switchingWindows(driver, "Contacts&action");
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
conData.getSaveButton().click();

home.LogOutFromApp(driver);
	}

}
