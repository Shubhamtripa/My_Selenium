package object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Organization_ValidationPage {
	
	public Organization_ValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is use to Validate Product is created or not
	 * @param driver
	 * @return
	 * @author Shubham
	 */
	public String validate(WebDriver driver) {
		String actData = driver.findElement(By.id("dtlview_Organization Name")).getText();
		return actData;
	}

}
