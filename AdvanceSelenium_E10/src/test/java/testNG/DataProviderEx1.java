package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//pull


//second member

//main repo

public class DataProviderEx1 {
	@Test(dataProvider = "dataProvider_BookTickets")
	public void bookTicketstest(String source, String destination)
	{
		System.out.println("Booking Ticket from:- "+source+" to "+destination);
	}
	
	@DataProvider
	public Object[][] dataProvider_BookTickets()
	{
		Object[] [] objArr = new Object[3][2];
		objArr[0][0]="Prayagraj";
		objArr[0][1]="Banglore";
		
		objArr[1][0]="Prayagraj";
		objArr[1][1]="Hydrabad";
		
		objArr[2][0]="Prayagraj";
		objArr[2][1]="Chennai";
		
		return objArr	;
		
	}
}
