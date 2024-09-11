package testNG_Vtiger;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.Base_Class;
import generic_utilities.Excel_Utility;
import generic_utilities.Java_Utility;
import object_Repository.CampaignPage;
import object_Repository.Campaign_ValidationPage;
import object_Repository.Create_Campaign_Page;
import object_Repository.HomePage;

@Listeners(generic_utilities.Listener_Implementation.class)
public class Create_CampaignTest extends Base_Class{
	
	@Test(retryAnalyzer = generic_utilities.RetryImp.class)
	public void createCampaignTest() throws Throwable {
		
		HomePage home = new HomePage(driver);
		
		Actions act = new Actions(driver);
		act.moveToElement(home.getMoreLink()).perform();
		home.getCampaignsLink().click();

		CampaignPage camImg = new CampaignPage(driver);
		camImg.getCampPlusSign().click();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		Excel_Utility elib = new Excel_Utility();
		String C_name = elib.getExcelData("Campaign", 0, 0)+ranNum;
		
		//Assert.assertEquals(false, true);
		
		Create_Campaign_Page cData =new Create_Campaign_Page(driver);
		cData.campaignData(C_name);

		Thread.sleep(4000);
		Campaign_ValidationPage page = new Campaign_ValidationPage(driver);
		String data = page.validate(driver);
		Assert.assertEquals(data, C_name);
		
	}

}
