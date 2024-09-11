package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Product_Page {

	//initialization
			public Create_Product_Page(WebDriver driver)//constructor
			{
				PageFactory.initElements(driver, this);
			}
			
			//Declaration
			@FindBy(name = "productname")
			private WebElement ProName;
			
			public WebElement getProName() {
				return ProName;
			}

			public WebElement getSaveButton() {
				return SaveButton;
			}

			@FindBy(xpath = "//input[@title='Save [Alt+S]']")
			private WebElement SaveButton;

			public void ProductData(String pName)
			{
				ProName.sendKeys(pName);
				SaveButton.click();
			}
}
