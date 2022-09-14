package utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XlsxUtility {

	String fileLocation;
	String[][] datatable;

	@Test
	public void ReadXlsx() {
		try {
			XSSFWorkbook wb = new XSSFWorkbook(System.getProperty("user.dir") + "\\Input\\Data.xlsx");
			XSSFSheet sheet = wb.getSheet("Client");

			int rows = sheet.getLastRowNum() + 1;
			int cols = sheet.getRow(0).getLastCellNum();

			datatable = new String[rows][cols];

			for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum() + 1; i++) {

				Row row = sheet.getRow(i);
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					datatable[i][j] = cell.getStringCellValue();
				}
			}

			wb.close();
			// return datatable;
			printDT();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printDT() {

		for (int i = 0; i < datatable.length; i++) {
			for (int j=0 ;j< datatable[i].length; j++) {
				System.out.print(datatable[i][j]+ "   ");
			}
			System.out.println("");
		}
	}

}
