package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {

	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	CellStyle style;
	String path = null;

	@DataProvider(name = "Login_Data")
	public Object[][] ReadLogindata() {

		try {

			/*
			 * String inputFile = System.getProperty("user.dir") + "\\Data\\TestData.xlsx";
			 * fis = new FileInputStream(inputFile);
			 * System.out.println(System.getProperty("user.dir") + "\\Data\\TestData.xlsx");
			 * myWorkBook = new XSSFWorkbook(fis); mySheet = myWorkBook.getSheet("Login");
			 */

			String xlsxfile = "C:\\Users\\dt212092\\eclipse-aug-workspace\\InvoiceJournal\\Data\\TestData.xlsx";
			FileInputStream fis = new FileInputStream(xlsxfile);
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			System.out.println(System.getProperty("user.dir") + "\\Data\\TestData.xlsx");
			XSSFSheet mySheet = myWorkBook.getSheet("Login");

			//String[][] tabArray = null;

			Iterator<Row> rowIterator = mySheet.iterator(); // Traversing over each row of XLSX file
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next(); // For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t");
						break;
					default:
					}
				}
				System.out.println("");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return null;
		return (new Object[][] { { "demo", "demo" }, { "demo", "demo" } });
	}

	public ExcelUtility(String filePath) {
		this.path = filePath;

	}

	public ExcelUtility() {

	}
	
	public int getRowCount(String sheetName) {
		int rowcount = 0;
		try {
			fis = new FileInputStream(path);

			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			rowcount = sheet.getLastRowNum();
			workbook.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowcount;
	}

	public int getCellCount(String sheetName, int rownum) {
		int cellCount = 0;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cellCount = row.getLastCellNum();
			workbook.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return cellCount;
	}

	
	//Returns the celldata in String format
	public String getCellData(String sheetName, int rownum, int colnum) {
		String data = null;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cell = row.getCell(colnum);

			DataFormatter formatter = new DataFormatter();
			try {
				data = formatter.formatCellValue(cell);
			} catch (Exception e) {
				data = "";
			}

			workbook.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
