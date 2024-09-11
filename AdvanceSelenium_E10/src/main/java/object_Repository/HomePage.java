package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//initialization
		public HomePage(WebDriver driver)//constructor
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(linkText = "Organizations")
		private WebElement OrganizationLink;
		
		@FindBy(linkText = "Products")
		private WebElement ProductsLink;
		
		@FindBy(linkText = "Campaigns")
		private WebElement CampaignsLink;
		
		@FindBy(linkText = "Contacts")
		private WebElement ContactsLink;
		
		@FindBy(linkText = "More")
		private WebElement MoreLink;
		
		@FindBy(css = "[src='themes/softed/images/user.PNG']")
		private WebElement AdminLink;
		
		@FindAll({@FindBy(xpath = "//a[text()='Sign Out']"), @FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")})
		private WebElement SignOutLink;

		//getter methods
		public WebElement getOrganizationLink() {
			return OrganizationLink;
		}

		public WebElement getProductsLink() {
			return ProductsLink;
		}

		public WebElement getCampaignsLink() {
			return CampaignsLink;
		}
		
		public WebElement getContactsLink() {
			return ContactsLink;
		}

		public WebElement getMoreLink() {
			return MoreLink;
		}

		public WebElement getAdminLink() {
			return AdminLink;
		}

		public WebElement getSignOutLink() {
			return SignOutLink;
		}
		WebDriver driver;
		//bussiness logic
		/**
		 * This method is use to LogOut From Applicaton
		 * @author Shubham
		 */
		public void LogOutFromApp(WebDriver driver)
		{
			Actions act = new Actions(driver);
			act.moveToElement(AdminLink).perform();
			SignOutLink.click();
		}
}
