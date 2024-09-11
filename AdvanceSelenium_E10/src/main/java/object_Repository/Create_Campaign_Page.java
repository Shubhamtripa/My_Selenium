package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Campaign_Page {
	//initialization
		public Create_Campaign_Page(WebDriver driver)//constructor
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(name = "campaignname")
		private WebElement CamName;
		
		@FindBy(css = "[src='themes/softed/images/select.gif']")
		private WebElement ProductLookUPIcon;
		
		public WebElement getProductLookUPIcon() {
			return ProductLookUPIcon;
		}

		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement SaveButton;

		public WebElement getCamName() {
			return CamName;
		}

		public WebElement getSaveButton() {
			return SaveButton;
		}
		
		public void campaignData(String c_name)
		{
			CamName.sendKeys(c_name);
			SaveButton.click();
		}

}
