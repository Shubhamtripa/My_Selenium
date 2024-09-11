package generic_utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Web_Driver_Utility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 * @author Shubham
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the window
	 * @param driver
	 * @author Shubham
	 */

	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is use to fullscreen the window
	 * @param driver
	 * @author Shubham
	 */
	public void fullscreen(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	/**
	 * This method is use to go forward in a window
	 * @param driver
	 * @author Shubham
	 */
	public void forward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	/**
	 * This method is use to go backward in a window
	 * @param driver
	 * @author Shubham
	 */
	public void backward(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	/**
	 * This method is use to go Refresh in a window
	 * @param driver
	 * @author Shubham
	 */
	public void refresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	/**
	 * This method is use to Navigate Within the Web Application
	 * @param driver
	 * @param url
	 * @return
	 * @author Shubham
	 */
	public void navigate_To(WebDriver driver,String url)
	{
		driver.navigate().to(url);
		
	}
	/**
	 * This method is use to wait until all Element get loaded
	 * @param driver
	 * @author Shubham
	 */
	public void waitElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	/**
	 * This method is use for switching windows
	 * @param driver
	 * @param title
	 * @author Shubham
	 */
	public void switchingWindows(WebDriver driver, String title)
	{
		//standard approach for window switching 
		Set<String> allwin = driver.getWindowHandles();//in set insertion order is not fixed
		Iterator<String> it = allwin.iterator();//iterator work as loop which contains window ID
		//switch to child
		while(it.hasNext())//it will check weather multiple window are available or not
		{
			String win = it.next();//store all window ID in win
			driver.switchTo().window(win);
			String current_title = driver.getTitle();
			if(current_title.contains(title)) {
				break;
			}
		}
		
	}
	
	/**
	 * This method is use to move the curser to particular Element
	 * @param driver
	 * @param element
	 * @author Shubham
	 */
	public void mouseActions(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is use to Select Element in Drop Down by Index
	 * @param element
	 * @param index
	 * @author Shubham
	 */
	public void dropDown_SelectByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method is use to Select Element in Drop Down by Value
	 * @param element
	 * @param value
	 * @author Shubham
	 */
	public void dropDown_SelectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method is use to Select Element in Drop Down by Visible Text
	 * @param element
	 * @param visibleText
	 * @author Shubham
	 */
	public void dropDown_SelectByVisibleText(WebElement element, String visibleText)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method is use to De-Select Element in Drop Down by Index
	 * @param element
	 * @param index
	 * @author Shubham
	 */
	public void dropDown_De_SelectByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method is use to De-Select Element in Drop Down by Value
	 * @param element
	 * @param value
	 * @author Shubham
	 */
	public void dropDown_De_SelectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method is use to De-Select Element in Drop Down by Visible Text
	 * @param element
	 * @param visibleText
	 * @author Shubham
	 */
	public void dropDown_De_SelectByVisibleText(WebElement element, String visibleText)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	/**
	 * This method is use to De-Select All Element in Drop Down
	 * @param element
	 * @author Shubham
	 */
	public void dropDown_De_Select_All(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	}
	/**
	 * This method is use to get all Options from Drop Down
	 * @param element
	 * @author Shubham
	 */
	public void dropDown_Get_Options(WebElement element)
	{
		Select sel = new Select(element);
		sel.getOptions();
	}
	/**
	 * This method is use to get All Selected Option From Drop Down
	 * @param element
	 * @author Shubham
	 */
	public void dropDown_Get_All_Selected_Options(WebElement element)
	{
		Select sel = new Select(element);
		sel.getAllSelectedOptions();
	}
	/**
	 * This method is use to check that Drop Down is multi Select or not
	 * @param element
	 * @author Shubham
	 */
	public void dropDown_isMultiple(WebElement element)
	{
		Select sel = new Select(element);
		sel.isMultiple();
	}
	
	/**
	 * This method is use to take Screen Shot when TC got Failed
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 * @author Shubham
	 */
	public static String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{		
		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	} 
}
