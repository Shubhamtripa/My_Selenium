package generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import object_Repository.HomePage;
import object_Repository.LoginPage;

public class Base_Class {

public static 	WebDriver sdriver;
public WebDriver driver;

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("DataBase Connection open");
	}
	
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void BC() throws Throwable
	{
	
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getPropertiesData("Browser");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		   	 driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			 driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		System.out.println("Browser launched");
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void BM() throws Throwable
	{
		File_Utility flib = new File_Utility();
		
		Web_Driver_Utility wlib = new Web_Driver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementToLoad(driver);

      //reading data from properties file		
		String URL = flib.getPropertiesData("url");
		String UserName = flib.getPropertiesData("user_Name");
		String Password = flib.getPropertiesData("password");
	 //reading data from cmd prompt
		
		driver.get(URL);
		
		LoginPage login = new LoginPage(driver);
		login.LoginTOApp(UserName, Password);
		
		System.out.println("Login To Application");
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM()
	{
		HomePage home = new HomePage(driver);
		 home.LogOutFromApp(driver);
		System.out.println("Logout from Application");
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("close Browser");
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("Parallel execution done");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("Close DataBase Connection");
	}
}