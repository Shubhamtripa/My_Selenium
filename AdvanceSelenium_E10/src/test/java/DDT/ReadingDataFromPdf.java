package DDT;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadingDataFromPdf {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
File fis = new File("./src/test/resources/PROJECT NOTES.pdf");
PDDocument doc = PDDocument.load(fis);

System.out.println(doc.getNumberOfPages());//to print no. of pages

PDFTextStripper pdfData = new PDFTextStripper();

//String read = pdfData.getText(doc);//--->this approach is for reading whole PDF
//System.out.println(read);

/*pdfData.setStartPage(5);
String read2 = pdfData.getText(doc);//--->this approach is for reading particular PDF page
System.out.println(read2);
	*/
pdfData.setStartPage(9);
pdfData.setEndPage(12);
String read3 = pdfData.getText(doc);
System.out.println(read3);
	}

}
