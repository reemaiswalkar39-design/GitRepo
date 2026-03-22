package Testing;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReadIterator {
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
String excelFilePath = System.getProperty("user.dir")+"\\Files\\Employee.xlsx";
File excelFile = new File(excelFilePath);
FileInputStream fis = new FileInputStream(excelFile);

XSSFWorkbook workbook = new XSSFWorkbook(fis);
XSSFSheet sheet = workbook.getSheet("Emp");

Iterator<Row> itrRow = sheet.iterator();

while(itrRow.hasNext())
{
	Row row = itrRow.next();
	
	Iterator<Cell> itrCell =row.iterator();
	
	while(itrCell.hasNext())
	{
		Cell cell = itrCell.next();
		CellType cellType =cell.getCellType();
		
		switch(cellType) {
		case STRING: System.out.println(cell.getStringCellValue());
		break;
		case NUMERIC:System.out.println(cell.getNumericCellValue());
		break;
		case BOOLEAN: System.out.println(cell.getBooleanCellValue());
		break;
		case BLANK:
			break;
		case ERROR:
			break;
		case FORMULA:
			break;
		case _NONE:
			break;
		default:
			break;
		
		
		
		}
		System.out.print(" ");
		
		
	}
	System.out.println();
	
	workbook.close();

		
	}
	
}



	}
	


