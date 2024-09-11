package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	//initialization
			public CampaignPage(WebDriver driver)//constructor
			{
				PageFactory.initElements(driver, this);
			}
			
			//Declaration
			@FindBy(css = "[alt='Create Campaign...']")
			private WebElement CampPlusSign;

			public WebElement getCampPlusSign() {
				return CampPlusSign;
			}
}
