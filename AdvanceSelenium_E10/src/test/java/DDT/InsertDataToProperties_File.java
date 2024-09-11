package DDT;

import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDataToProperties_File {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
//create object of properties class
Properties pro = new Properties();

//call setProperty method to write the data
//write in key = value form
pro.setProperty("url", "https://www.saucedemo.com/v1/");
pro.setProperty("username", "standard_user");
pro.setProperty("password", "secret_sauce");


//create object of FileOutputStream class in order to store data
FileOutputStream fos = new FileOutputStream("./src/test/resources/credentialForSaucedemo.properties");

//pro.store(fos, "CommonData");//store data in external file
pro.store(fos, "updated common data");
	}

}
