package Testing;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataPOIAPI {

	private static XSSFWorkbook workbook;

	public static void main(String[] args) throws IOException {

		workbook = new XSSFWorkbook();
		XSSFSheet sheetOne = workbook.createSheet("SheetOne");
		 Object[][] data = {{"Name","Location","Experience"},
				 {"Arun","Hyderabad",15},
				 {"Varun","Mumbai",12},
				 {"Aru","Thane",2}};
		 
		 int rows = data.length;
		 int columns = data[0].length;
		 
		 for(int r=0;r<rows;r++)
		 {
			
			 XSSFRow row = sheetOne.createRow(r);
			 
			 for(int c=0; c<columns;c++)
			 {
				XSSFCell cell = row.createCell(c);
				Object cellValue = data[r][c];
				
				if(cellValue instanceof String)
				{
					cell.setCellValue((String)cellValue);
					
				} 
				else if(cellValue instanceof Integer)
				{
					cell.setCellValue((Integer)cellValue);
					
				}else if(cellValue instanceof Boolean)
				{
					cell.setCellValue((Boolean)cellValue);

				}
				
				
				
			 }
		 }
		 File file = new File(System.getProperty("user.dir") + "\\Files\\Employee.xlsx");
		 FileOutputStream fos = new FileOutputStream(file);
		 workbook.write(fos);
		 workbook.close();
	
		 
			System.out.println("Task Completed");

		 
		 }

	
	
	}


