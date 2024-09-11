package vTiger_Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Web_Driver_Utility;
import object_Repository.Create_Product_Page;
import object_Repository.Delete_Product_Name;
import object_Repository.HomePage;
import object_Repository.LoginPage;
import object_Repository.ProductPage;

public class Delete_Product {

	public static void main(String[] args) throws Throwable {
WebDriver driver = new ChromeDriver();
//driver.manage().window().maximize();
Web_Driver_Utility wlib = new Web_Driver_Utility();
Java_Utility jlib = new Java_Utility();
File_Utility flib = new File_Utility();
wlib.maximizeWindow(driver);
	
	String URL = flib.getPropertiesData("url");
	String UserName = flib.getPropertiesData("user_Name");
	String Password = flib.getPropertiesData("password");
	
	driver.get(URL);
//	driver.findElement(By.name("user_name")).sendKeys(UserName);
//	driver.findElement(By.name("user_password")).sendKeys(Password);
//	driver.findElement(By.id("submitButton")).click();


LoginPage login = new LoginPage(driver);
login.LoginTOApp(UserName, Password);

	//click on Product link
	//driver.findElement(By.linkText("Products")).click();
HomePage home = new HomePage(driver);
home.getProductsLink().click();

	//driver.findElement(By.cssSelector("[alt='Create Product...']")).click();
ProductPage proImg = new ProductPage(driver);
proImg.getProPlusSign().click();

	String P_Name = flib.getPropertiesData("product_Name");
	
	int ranNum = jlib.getRandomNum();
	String Product_name = P_Name+ranNum;
	
	//driver.findElement(By.name("productname")).sendKeys(Product_name);
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Create_Product_Page proData = new Create_Product_Page(driver);
proData.ProductData(Product_name);

	//driver.findElement(By.xpath("//a[text()='Products']")).click();
proImg.getProductText().click();

	//avoid using indexing
	//driver.findElement(By.xpath("(//a[text()='"+Product_name+"'])[2]/../..//input[@name='selected_id']")).click();
	//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+Product_name+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	Delete_Product_Name deletePrdName = new Delete_Product_Name(driver);
	deletePrdName.selectPrdData(driver, Product_name);
	
	//driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
	deletePrdName.getDeleteButton().click();
	driver.switchTo().alert().accept();
	
	Thread.sleep(4000);
	//validation
//	List<WebElement> all_Product = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
//	boolean flag = false;
//	for (WebElement product : all_Product) {
//		String single_pro = product.getText();
//		//System.out.println(single_pro);
//		if(single_pro.contains(Product_name)) {
//			
//			flag = true;
//			System.out.println("=====");
//			break;
//		}
//	}
//	System.out.println(flag);
//	if(!flag) {
//		System.out.println("Product is deleted");
//	}
//	else
//	{
//		System.out.println("Product is not deleted...");
//	}
	deletePrdName.validate(driver, Product_name);
	home.LogOutFromApp(driver);
	
	}

}
