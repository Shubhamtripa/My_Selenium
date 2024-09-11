package dynamicPath_practice;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_iPhone_Color {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.amazon.in/");

driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
/*
driver.findElement(By.xpath("(//span[text()='Apple iPhone 13 (128GB) - Starlight'])[1]")).click();
String parentwinID = driver.getWindowHandle();
Set<String> windowIDs = driver.getWindowHandles();
windowIDs.remove(parentwinID);
//System.out.println(windowIDs);
for (String winID : windowIDs) {
	driver.switchTo().window(winID);
	for (int i = 1; i < 7; i++) {
		String color = driver.findElement(By.xpath("(//img[@class='imgSwatch'])["+i+"]")).getAttribute("alt");
System.out.println(color);
}
}
	*/
List<WebElement> allcolor = driver.findElements(By.xpath("(//span[text()='Apple iPhone 13 (128GB) - Starlight'])[1]/../../../..//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));
for (WebElement color : allcolor) {
	System.out.println(color.getAttribute("aria-label"));
}
	}
}
