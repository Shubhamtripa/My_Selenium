package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingAllLinkOfAmazonIFromExcell {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
FileInputStream fis = new FileInputStream("./src/test/resources/AmazonLinks.xlsx");

Workbook book = WorkbookFactory.create(fis);
Sheet sheet = book.getSheet("Sheet1");

for (int i = 0; i <=sheet.getLastRowNum(); i++) 
	{
		Row row = sheet.getRow(i);
		for (int j = 0; j < row.getLastCellNum(); j++) {
		
			Cell cell = row.getCell(j);
			System.out.println(cell.getStringCellValue());
		}
	}
	}

}
