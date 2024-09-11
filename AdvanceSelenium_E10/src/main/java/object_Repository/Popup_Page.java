package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Popup_Page {
	//initialization
	public Popup_Page(WebDriver driver)//constructor
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name = "search_text")
	private WebElement SearchTextField;
	
	@FindBy(name = "search")
	private WebElement SearchButton;

	public WebElement getSearchTextField() {
		return SearchTextField;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}
	public void SearchLatest_Product(String SearchData)
	{
		SearchTextField.sendKeys(SearchData);
		SearchButton.click();
	}

}
