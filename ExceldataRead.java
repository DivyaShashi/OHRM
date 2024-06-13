package DatadriverTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExceldataRead {
  @Test
  public void dataRead() throws IOException {
	  
	 File f1=new File("./"+"\\TestData\\Udata.xlsx");
	FileInputStream fs=new FileInputStream(f1);
	//Workbook->sheet->Row->cell->data
	XSSFWorkbook wb = new XSSFWorkbook(fs);
	int rows = wb.getSheet("userdata").getPhysicalNumberOfRows();//Row
	int cells = wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();//Cell
	Object[][] data = new Object[rows-1][cells];//create an array as per size 6 read 5
	for(int i=1;i<rows;i++)//for rows ,ignore heading
	{
		for(int j=0;j<cells;j++)
		{
			//array always starts from 0
			data[i-1][j] = wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
		    System.out.print(data[i-1][j]);
	}
		System.out.println();
	}
	String value1=wb.getSheet("userdata").getRow(0).getCell(1).getStringCellValue();
	System.out.println(value1);

  }
}
	
	
//	for Single record
	
//	XSSFWorkbook wb=new XSSFWorkbook(fs);
//	XSSFSheet sheet = wb.getSheet("userdata");
//	XSSFRow row = sheet.getRow(0);
//	XSSFCell cell = row.getCell(1);
//	String value = cell.getStringCellValue();
//	System.out.println(value);
	

	
	
	
	
