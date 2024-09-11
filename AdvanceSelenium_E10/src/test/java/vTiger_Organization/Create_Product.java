package vTiger_Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import object_Repository.Create_Product_Page;
import object_Repository.HomePage;
import object_Repository.LoginPage;
import object_Repository.ProductPage;

public class Create_Product {

	public static void main(String[] args) throws Throwable {
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
		
//FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
//Properties pro =new Properties();
//pro.load(fis);
//
//String URL = pro.getProperty("url");
//String UserName = pro.getProperty("user_Name");
//String Password = pro.getProperty("password");

File_Utility flib = new File_Utility();
String URL = flib.getPropertiesData("url");
String UserName = flib.getPropertiesData("user_Name");
String Password = flib.getPropertiesData("password");

driver.get(URL);
//driver.findElement(By.name("user_name")).sendKeys(UserName);
//driver.findElement(By.name("user_password")).sendKeys(Password);
//driver.findElement(By.id("submitButton")).click();

LoginPage login = new LoginPage(driver);
login.LoginTOApp(UserName, Password);

//click on Product link
//driver.findElement(By.linkText("Products")).click();
HomePage home = new HomePage(driver);
home.getProductsLink().click();

//driver.findElement(By.cssSelector("[alt='Create Product...']")).click();
ProductPage pImg = new ProductPage(driver);
pImg.getProPlusSign().click();

String P_Name = flib.getPropertiesData("product_Name");

Java_Utility jlib = new Java_Utility();
int ranNum = jlib.getRandomNum();

//driver.findElement(By.name("productname")).sendKeys(P_Name+ranNum);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Create_Product_Page proData = new Create_Product_Page(driver);
proData.ProductData(P_Name+ranNum);

Thread.sleep(2000);
//driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']")).click();
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
home.LogOutFromApp(driver);
	}

}
