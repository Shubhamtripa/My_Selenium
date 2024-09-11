package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	//initialization
	public ProductPage(WebDriver driver)//constructor
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(css = "[alt='Create Product...']")
	private WebElement ProPlusSign;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement ProductText;

	public WebElement getProductText() {
		return ProductText;
	}

	public WebElement getProPlusSign() {
		return ProPlusSign;
	}
	
}
