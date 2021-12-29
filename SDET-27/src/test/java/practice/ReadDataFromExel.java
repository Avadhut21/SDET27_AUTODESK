package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
    FileInputStream fis = new FileInputStream("./data/TestScriptdata.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    
    Sheet sh=wb.getSheet("org");
   Row row = sh.getRow(1);
    Cell cel = row.getCell(2);
     String data = cel.getStringCellValue();
     System.out.println(data);
     wb.close();
    
	}

}
