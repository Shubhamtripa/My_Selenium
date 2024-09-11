package DDT;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class ReadingDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
Driver driverRef = new OracleDriver();

DriverManager.registerDriver(driverRef);
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "scott", "tiger");
Statement stmt = conn.createStatement();
String query = "select * from emp;";

ResultSet result = stmt.executeQuery(query);

while(result.next()) {
	System.out.println(result);
}
conn.close();
	}

}
