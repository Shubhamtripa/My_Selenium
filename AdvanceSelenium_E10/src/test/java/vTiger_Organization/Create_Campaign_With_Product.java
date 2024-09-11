package vTiger_Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Web_Driver_Utility;
import object_Repository.CampaignPage;
import object_Repository.Create_Campaign_Page;
import object_Repository.Create_Product_Page;
import object_Repository.HomePage;
import object_Repository.LoginPage;
import object_Repository.Popup_Page;
import object_Repository.ProductPage;

public class Create_Campaign_With_Product {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();

Web_Driver_Utility wlib = new Web_Driver_Utility();
File_Utility flib = new File_Utility();
Java_Utility jlib = new Java_Utility();

wlib.maximizeWindow(driver);

//reading data from property file
String URL = flib.getPropertiesData("url");
String UserName = flib.getPropertiesData("user_Name");
String Password = flib.getPropertiesData("password");

driver.get(URL);

LoginPage login = new LoginPage(driver);
login.LoginTOApp(UserName, Password);

HomePage home = new HomePage(driver);
home.getProductsLink().click();

ProductPage pImg = new ProductPage(driver);
pImg.getProPlusSign().click();

String P_Name = flib.getPropertiesData("product_Name");
int ranNum = jlib.getRandomNum();

String Product_name = P_Name+ranNum;

Create_Product_Page proData = new Create_Product_Page(driver);
proData.ProductData(Product_name);

WebElement link = home.getMoreLink();
wlib.mouseActions(driver, link);

home.getCampaignsLink().click();

CampaignPage cImg = new CampaignPage(driver);
cImg.getCampPlusSign().click();

String C_Name = flib.getPropertiesData("Campaign_Name");
//driver.findElement(By.name("campaignname")).sendKeys(C_Name + ranNum);
Create_Campaign_Page camData = new Create_Campaign_Page(driver);
camData.getCamName().sendKeys(C_Name+ranNum);

//driver.findElement(By.cssSelector("[src='themes/softed/images/select.gif']")).click();
camData.getProductLookUPIcon().click();
/*
String parent_win = driver.getWindowHandle();
Set<String> allwin = driver.getWindowHandles();
allwin.remove(parent_win);


for (String window : allwin) {
	driver.switchTo().window(window);
	driver.findElement(By.name("search_text")).sendKeys(Product_name);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+Product_name+"']")).click();
}
driver.switchTo().window(parent_win);
*/

////standard approach for window switching 

//Set<String> allwin = driver.getWindowHandles();//in set insertion order is not fixed
//Iterator<String> it = allwin.iterator();//iterator work as loop which contains window ID
////switch to child
//while(it.hasNext())//it will check weather multiple window are available or not
//{
//	String win = it.next();//store all window ID in win one after another
//	driver.switchTo().window(win);
//	String current_title = driver.getTitle();
//	if(current_title.contains("Products&action")) {
//		break;
//	}
//}
wlib.switchingWindows(driver, "Products&action");

//driver.findElement(By.name("search_text")).sendKeys(Product_name);
//driver.findElement(By.name("search")).click();
Popup_Page proPopUp = new Popup_Page(driver);
proPopUp.SearchLatest_Product(Product_name);

driver.findElement(By.xpath("//a[text()='"+Product_name+"']")).click();

//switch to parent
wlib.switchingWindows(driver, "Campaigns&action");

camData.getSaveButton().click();
Thread.sleep(2000);
home.LogOutFromApp(driver);
	}

}
