package Testing;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReadForLoop {

	private static XSSFWorkbook workbook;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String excelFilePath= System.getProperty("user.dir")+"\\Files\\Employee.xlsx";
		File excelFile =new File(excelFilePath);
		FileInputStream fis=new FileInputStream(excelFile);
		
		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Emp");
		int rows=sheet.getLastRowNum();
		
		int cols=sheet.getRow(1).getLastCellNum();
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row= sheet.getRow(r);
			
			for(int c=0; c<cols;c++) {
				
				XSSFCell  cell=row.getCell(c);
				CellType celltype=cell.getCellType();
				
				switch(celltype)
				{
				
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
