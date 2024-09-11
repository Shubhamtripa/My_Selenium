package dynamicPath_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class olympic_medal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://olympics.com/en/paris-2024/medals");
String a = "//span[text()='Japan']";

String country = driver.findElement(By.xpath(a)).getText();
System.out.println("Country: "+country);
String gold = driver.findElement(By.xpath("("+a+"/../..//span[@class='e1oix8v91 emotion-srm-81g9w1'])[1]")).getText();
System.out.println("Gold: "+gold);	
String silver = driver.findElement(By.xpath("("+a+"/../..//span[@class='e1oix8v91 emotion-srm-81g9w1'])[2]")).getText();	
System.out.println("Silver: "+ silver);
String bronze = driver.findElement(By.xpath("("+a+"/../..//span[@class='e1oix8v91 emotion-srm-81g9w1'])[3]")).getText();
System.out.println("Bronze: "+ bronze);
String total = driver.findElement(By.xpath(a+"/../..//span[@class='e1oix8v91 emotion-srm-5nhv3o']")).getText();
System.out.println("Total: "+total);
	}

}
