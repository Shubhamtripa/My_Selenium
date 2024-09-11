package generic_utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * This method is use to Read Data from Properties File
	 * @return
	 * @author Shubham
	 * @throws Throwable 
	 */
	
	public String getPropertiesData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
		Properties pro =new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
	

}
