package dynamicPath_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kabaddi_Point_Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.prokabaddi.com/standings");
String a = "//p[text()='Puneri Paltan']";

String team_Name = driver.findElement(By.xpath(a)).getText();
System.out.println(team_Name);
String text = driver.findElement(By.xpath("("+a+"/../../../..//p[@class='count'])[6]")).getText();
System.out.println(text);
String won_Match = driver.findElement(By.xpath("//p[text()='Puneri Paltan']/../../../following-sibling::div[@class='table-data matches-won']")).getText();
System.out.println(won_Match);

String lost_Match = driver.findElement(By.xpath("//p[text()='Puneri Paltan']/../../../..//div[@class='table-data matches-lost']")).getText();
System.out.println(lost_Match);
	}

}
