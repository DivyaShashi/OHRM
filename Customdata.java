package DatadriverTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Customdata{ 
	public Object[][]testdata()
	{
		Object data[][]= {{"Admin","admin123"},{"sarang","test123"},{"Admin","admin123"}};
		return data;
		}
@DataProvider(name="Exceldata")
public Object[][] filedata(){
		XSSFWorkbook wb;
		Object[][] data=null;
		File f1=new File("./"+"\\TestData\\Udata.xlsx");
		FileInputStream fs;
		try {
			fs = new FileInputStream(f1);
			wb = new XSSFWorkbook(fs);
		    int rows = wb.getSheet("userdata").getPhysicalNumberOfRows();//Row
			int cells = wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();//Cell
			data = new Object[rows-1][cells];//create an array as per size 6 read 5
			for(int i=1;i<rows;i++)//for rows ,ignore heading
			{
				for(int j=0;j<cells;j++)
				{
					//array always starts from 0
					data[i-1][j] = wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
				   System.out.print(data[i-1][j]+" ");
			}
			}
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;	
	  
	}		




}






