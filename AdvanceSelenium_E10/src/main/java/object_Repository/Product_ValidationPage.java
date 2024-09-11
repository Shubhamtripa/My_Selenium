package object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Product_ValidationPage {
	
	public Product_ValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is use to Validate Product is created or not
	 * @param driver
	 * @return
	 * @author Shubham
	 */
	public String validate(WebDriver driver) {
		String actData = driver.findElement(By.id("dtlview_Product Name")).getText();
		return actData;
	}
	
	/**
	 * This method is use to Validate Product is created or not with if and else statment
	 * @param driver
	 * @param data
	 * @author Shubham
	 * @return 
	 */
	public String validate2(WebDriver driver, String data) {
		String actData = driver.findElement(By.id("dtlview_Product Name")).getText();
		if(actData.contains(data))
		{
			System.out.println("Product is created");
		}
		else
		{
			System.out.println("Product is not created");
		}
		return data;
	}

}
