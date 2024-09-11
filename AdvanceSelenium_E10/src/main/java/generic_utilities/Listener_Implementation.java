package generic_utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Implementation implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {

		TakesScreenshot ts = (TakesScreenshot)Base_Class.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScriptFailed.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
}
