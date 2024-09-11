package vTiger_Organization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.Web_Driver_Utility;
import object_Repository.CampaignPage;
import object_Repository.Create_Campaign_Page;
import object_Repository.HomePage;
import object_Repository.LoginPage;

public class Create_Campaign {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		Web_Driver_Utility wlib = new Web_Driver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementToLoad(driver);
		
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

HomePage home = new HomePage(driver);

Actions act = new Actions(driver);
//act.moveToElement(driver.findElement(By.linkText("More"))).perform();
//driver.findElement(By.name("Campaigns")).click();
act.moveToElement(home.getMoreLink()).perform();
home.getCampaignsLink().click();

//driver.findElement(By.cssSelector("[alt='Create Campaign...']")).click();
CampaignPage camImg = new CampaignPage(driver);
camImg.getCampPlusSign().click();

//		//step1:- Path Representation
//		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
//
//		//step2-> keeping the excel file in read mode
//		//use WorkbookFactory class and use create(InputStream ) method
//		Workbook book = WorkbookFactory.create(fis);
//
//		//step3:- get the control of the Sheet-1
//		Sheet sheet = book.getSheet(SheetName);
//
//		//step4:- get the control of the row
//		Row row = sheet.getRow(rowNum);
//
//		//step5:- get the control of the cell
//		Cell cell = row.getCell(cellNum);
//
//		//step6:- Reading cell value
//		String excelData = cell.getStringCellValue();
		Excel_Utility elib = new Excel_Utility();
		String C_name = elib.getExcelData("Sheet1", 0, 0);

//String C_name = pro.getProperty("Campaign_Name");
//String C_name = elib.getExcelData("Campaign_Name");

Java_Utility jlib = new Java_Utility();
int ranNum = jlib.getRandomNum();

//driver.findElement(By.name("campaignname")).sendKeys(C_name + ranNum);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Create_Campaign_Page cData =new Create_Campaign_Page(driver);
cData.campaignData(C_name+ranNum);

Thread.sleep(2000);
//driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']")).click();
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

//home.getAdminLink().click();
//home.getSignOutLink().click();

//home.LogOutFromApp(driver);
	}

}
