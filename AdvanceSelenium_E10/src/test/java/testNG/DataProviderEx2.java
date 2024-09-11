package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {
//DataPRovider:- Executing same method/script multiple times with different set of data
	
	@Test(dataProvider = "dataProvider_BookTickets")
	public void bookTicketstest(String source, String destination,String peopleCount)
	{
		System.out.println("Booking Ticket from:- "+source+" to "+destination+" Peoples:- "+peopleCount);
	}
	
	@DataProvider
	public Object[][] dataProvider_BookTickets()
	{
		Object[] [] objArr = new Object[3][3];
		objArr[0][0]="Prayagraj";
		objArr[0][1]="Banglore";
		objArr[0][2]="5";
		
		objArr[1][0]="Prayagraj";
		objArr[1][1]="Hydrabad";
		objArr[1][2]="2";
		
		objArr[2][0]="Prayagraj";
		objArr[2][1]="Chennai";
		objArr[2][2]="70";
		
		return objArr	;
		
	}
}
