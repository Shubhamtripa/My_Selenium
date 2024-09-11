package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Organization_page {

	//initialization
	public Create_Organization_page(WebDriver driver)//constructor
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name = "accountname")
	private WebElement OrgName;
	
	@FindBy(id = "phone")
	private WebElement OrgPhone;
	
	@FindBy(name = "email1")
	private WebElement OrgEmail;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getOrgPhone() {
		return OrgPhone;
	}

	public WebElement getOrgEmail() {
		return OrgEmail;
	}
	/**
	 * This method is use to enter data in create Organization Page
	 * @param orgName
	 * @param phone
	 * @param email
	 * @author Shubham
	 */
	public void orgDetail(String orgName, String phone, String email)
	{
		OrgName.sendKeys(orgName);
		OrgPhone.sendKeys(phone);
		OrgEmail.sendKeys(email);
		SaveButton.click();
	}
}
