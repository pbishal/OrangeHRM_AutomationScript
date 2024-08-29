package TestScenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingExcel {

	@Test
	public void loginTest() throws IOException {
		String excelFilePath = ".\\dataFiles\\userDetails.xlsx";
		FileInputStream inputSrtream = new FileInputStream(excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputSrtream);

		// XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFSheet sheet = workbook.getSheetAt(0);

		// using for loop
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
		for(int r=0;r<=rows; r++)
		{
			XSSFRow row = sheet.getRow(r);
			
			for(int c=0;c<=rows; c++) 
			{
				XSSFCell cell = row.getCell(c);
				
				switch(cell.getCellType())
				{
				case STRING: System.out.println(cell.getStringCellValue()); break;
				case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
				case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;

				}
			}
			System.out.println();
		}
	}

}
