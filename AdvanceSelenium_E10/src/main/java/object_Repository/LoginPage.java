package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//initialization
	public LoginPage(WebDriver driver)//constructor
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name = "user_name")
	private WebElement UserTextField;
	
	@FindBy(css = "[name='user_password']")
	private WebElement PasswordTextField;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement LoginButton;
	
	//Getter Methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Bussiness Logics or Library
	/**
	 * This Method is use to Login into application
	 * @param username
	 * @param password
	 * @author Shubham
	 */
	public void LoginTOApp(String username, String password)
	{
		UserTextField.sendKeys(username);
		PasswordTextField.sendKeys(password);
		LoginButton.click();
	}
	
}
