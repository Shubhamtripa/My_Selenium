package dynamicPath_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasket_Search_grapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.manage().window().maximize();
driver.get("https://www.bigbasket.com/");

driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("grapes");

List<WebElement> suggestions = driver.findElements(By.xpath("(//span[@class='Label-sc-15v1nk5-0 QuickSearch___StyledLabel2-sc-rtz2vl-7 gJxZPQ gFDEBU'])[5]"));

for (WebElement suggestion : suggestions) {
	System.out.println(suggestion.getText());
	suggestion.getText().equals("Grapes - Red Globeâ€š Indian");
	suggestion.click();
}
driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
driver.findElement(By.xpath("(//*[name()='svg' and @viewBox='0 0 25 24'])[2]")).click();
	}

}
