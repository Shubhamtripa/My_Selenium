package generic_utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * This method is use to Read Data from Excel File
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Shubham
	 */
public String getExcelData(String SheetName,int rowNum, int cellNum) throws Throwable
{
	//step1:- Path Representation
	//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	FileInputStream fis = new FileInputStream("C:\\Users\\Ayush Com\\Documents\\AdvanceSelenium File\\TestData.xlsx");
	//step2-> keeping the excel file in read mode
	//use WorkbookFactory class and use create(InputStream ) method
	Workbook book = WorkbookFactory.create(fis);

	//step3:- get the control of the Sheet-1
	Sheet sheet = book.getSheet(SheetName);

	//step4:- get the control of the row
	Row row = sheet.getRow(rowNum);

	//step5:- get the control of the cell
	Cell cell = row.getCell(cellNum);

	//step6:- Reading cell value
	String excelData = cell.getStringCellValue();
	return excelData;
}

/**
 * This method is use to read data from Excel file using Data Formatter
 * @param SheetName
 * @param rowNum
 * @param cellNum
 * @return
 * @throws Throwable
 * @author Shubham
 */

public String getExcelDataUsingFormater(String SheetName,int rowNum, int cellNum) throws Throwable
{
	//step1:- Path Representation
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");

	//step2-> keeping the excel file in read mode
	//use WorkbookFactory class and use create(InputStream ) method
	Workbook book = WorkbookFactory.create(fis);

	//step3:- get the control of the Sheet-1
	Sheet sheet = book.getSheet(SheetName);

	//step4:- get the control of the row
	Row row = sheet.getRow(rowNum);

	//step5:- get the control of the cell
	Cell cell = row.getCell(cellNum);
	//cell.getStringCellValue();//it will give IllegalStateException

	//step6:- Reading cell value by using data formatter 
	//which is use to read all type of data
	DataFormatter format = new DataFormatter();
	String excellData = format.formatCellValue(cell);
	System.out.println(excellData);
	return excellData;
}

/**
 * This method is use to access data from data provider
 * @param sheetName
 * @return
 * @throws Throwable
 * @author Shubham
 */
public Object[][] getDataProviderData(String sheetName) throws Throwable
{
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
    Workbook book = WorkbookFactory.create(fis);
    Sheet sheet = book.getSheet(sheetName);
    int lastRow = sheet.getLastRowNum()+1;
    int lastcell = sheet.getRow(0).getLastCellNum();
    Object[][] objArr = new Object[lastRow][lastcell];
    for (int i = 0; i < lastRow; i++) {
    	for (int j = 0; j < lastcell; j++) {
    		objArr[i][j]=sheet.getRow(i).getCell(j).toString();
		}
		
	}
    
	return objArr;
	
}
}
