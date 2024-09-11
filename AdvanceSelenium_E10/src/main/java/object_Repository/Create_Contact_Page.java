package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Contact_Page {
	public Create_Contact_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "salutationtype")
	private WebElement SalutationDropDown;
	
	@FindBy(name = "firstname")
	private WebElement FirstName;
	
	@FindBy(name = "lastname")
	private WebElement LastName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement OrgLookUPIcon;
	
	@FindAll({@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[2]"),
		@FindBy(xpath = "(//img[@style='cursor:hand;cursor:pointer'])[2]")
	})private WebElement ContactLookUPIcon;

	public WebElement getSalutationDropDown() {
		return SalutationDropDown;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public WebElement getOrgLookUPIcon() {
		return OrgLookUPIcon;
	}
	
	public WebElement getContactLookUPIcon() {
		return ContactLookUPIcon;
	}
	
	public void ContactData(String fName, String lName)
	{
		FirstName.sendKeys(fName);
		LastName.sendKeys(lName);
		SaveButton.click();
	}
}
