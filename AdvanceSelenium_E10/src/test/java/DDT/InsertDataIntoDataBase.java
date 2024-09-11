package DDT;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class InsertDataIntoDataBase {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Driver driverRef = new OracleDriver();

		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "scott", "tiger");
		Statement stmt = conn.createStatement();
		String query = "";
		int result = stmt.executeUpdate(query);
		
		if(result==1) {
			System.out.println("Data is inserted");
		}
		else
			System.out.println("Data is not inserted");
	}

}
