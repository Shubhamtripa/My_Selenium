package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcelUsingDataFormatter {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
//step1:- Path Representation
FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");

//step2-> keeping the excel file in read mode
//use WorkbookFactory class and use create(InputStream ) method
Workbook book = WorkbookFactory.create(fis);

//step3:- get the control of the Sheet-1
Sheet sheet = book.getSheet("Sheet1");

//step4:- get the control of the row
Row row = sheet.getRow(0);

//step5:- get the control of the cell
Cell cell = row.getCell(5);
//cell.getStringCellValue();//it will give IllegalStateException

//step6:- Reading cell value by using data formatter 
//which is use to read all type of data
DataFormatter format = new DataFormatter();
String excellData = format.formatCellValue(cell);
System.out.println(excellData);
	}

}
