package object_Repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Delete_Product_Name {

	public Delete_Product_Name(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * This Method is use to Select Product Which you want to Delete
	 * @param driver
	 * @param Product_name
	 * @author Shubham
	 */
	public void selectPrdData(WebDriver driver, String Product_name)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+Product_name+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement DeleteButton;

	public WebElement getDeleteButton() {
		return DeleteButton;
	}
	/**
	 * This method is use to Validate wheather product is Deleted or not
	 * @param driver
	 * @param Product_name
	 * @author Shubham
	 */
	public void validate(WebDriver driver, String Product_name) {
		List<WebElement> all_Product = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		boolean flag = false;
		for (WebElement product : all_Product) {
			String single_pro = product.getText();
			//System.out.println(single_pro);
			if(single_pro.contains(Product_name)) {
				
				flag = true;
				System.out.println("=====");
				break;
			}
		}
		System.out.println(flag);
		if(!flag) {
			System.out.println("Product is deleted");
		}
		else
		{
			System.out.println("Product is not deleted...");
		}
		
	}
	
}
