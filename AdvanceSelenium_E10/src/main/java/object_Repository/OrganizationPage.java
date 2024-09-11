package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//initialization
			public OrganizationPage(WebDriver driver)//constructor
			{
				PageFactory.initElements(driver, this);
			}
			
			//Declaration
			@FindBy(css = "[alt='Create Organization...']")
			private WebElement OrgPlusSign;

			public WebElement getOrgPlusSign() {
				return OrgPlusSign;
			}
			
}
