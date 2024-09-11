package DDT;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromProperties_File {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

//normal Approach
/*
driver.get("https://www.saucedemo.com/v1/");
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();
*/


//Reading data from External Resource----> Properties File

//step1: get the java representation object of the Physical File
FileInputStream fis = new FileInputStream("./src/test/resources/credentialForSaucedemo.properties");

//step2: create an Object to property class to load all the keys
Properties pro = new Properties();

// to load the data from external file call load Method
pro.load(fis);

//step3: read the value using getpropety Method
 String URL = pro.getProperty("url");
 String UserName = pro.getProperty("username");
 String Password = pro.getProperty("password");
 
 //Now use driver class to execute the script
 driver.get(URL);
 driver.findElement(By.id("user-name")).sendKeys(UserName);
 driver.findElement(By.id("password")).sendKeys(Password);
 driver.findElement(By.id("login-button")).click();


	}

}
