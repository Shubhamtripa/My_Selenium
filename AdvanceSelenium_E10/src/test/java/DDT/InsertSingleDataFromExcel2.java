package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataFromExcel2 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		//step1:- Path Representation
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");

		//step2-> keeping the excel file in read mode
		//use WorkbookFactory class and use create(InputStream ) method
		Workbook book = WorkbookFactory.create(fis);

		//step3:- get the control of the Sheet-1
		Sheet sheet = book.getSheet("Sheet1");

		//step4:- get the control to the row
		Row row = sheet.createRow(4);
		
		//step5:- get the control to the cell
		Cell cell = row.createCell(3);
		
		//step6:- write the data into the particular cell
		cell.setCellValue("Addidas");
		
		//step7:- keep excel book into write mode
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		book.write(fos);//pass FOS  reference to write data into the book 
		book.close();//close the book
	}

}
