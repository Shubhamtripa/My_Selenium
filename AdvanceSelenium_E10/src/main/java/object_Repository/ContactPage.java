package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//initialization
	public ContactPage(WebDriver driver)//constructor
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(css = "[alt='Create Contact...']")
	private WebElement ConPlusSign;

	public WebElement getConPlusSign() {
		return ConPlusSign;
	}
}