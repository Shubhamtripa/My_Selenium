package dynamicPath_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_iPhone_Prices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.amazon.in/");

driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
/*
String name1 = driver.findElement(By.xpath("(//span[text()='Apple iPhone 15 (128 GB) - Black'])[1]")).getText();
System.out.print(name1+"  ₹");
String price1 = driver.findElement(By.xpath("(//span[text()='Apple iPhone 15 (128 GB) - Black'])[1]/../../../..//span[@class='a-price-whole']")).getText();
System.out.println(price1);

String name2 = driver.findElement(By.xpath("(//span[text()='Apple iPhone 15 Plus (128 GB) - Black'])[1]")).getText();
System.out.print(name2+"  ₹");
String price2 = driver.findElement(By.xpath("(//span[text()='Apple iPhone 15 Plus (128 GB) - Black'])[1]/../../../..//span[@class='a-price-whole']")).getText();
System.out.println(price2);

String name3 = driver.findElement(By.xpath("(//span[text()='Apple iPhone 13 (128GB) - Starlight'])[1]")).getText();
System.out.print(name3+"  ₹");
String price3 = driver.findElement(By.xpath("(//span[text()='Apple iPhone 13 (128GB) - Starlight'])[1]/../../../..//span[@class='a-price-whole']")).getText();
System.out.println(price3);
*/
List<WebElement> phone_Names = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
List<WebElement> phone_Prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
for (int i = 0; i < phone_Names.size(); i++) {
	System.out.println(phone_Names.get(i).getText()+"---  ₹"+phone_Prices.get(i).getText());
}
	
	}

}
