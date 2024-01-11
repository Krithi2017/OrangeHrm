package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Dataproviders {

	
    //Dataprovider1
	@DataProvider(name="logindata")
	public static void main(String[] args, XSSFRow row, int c) throws IOException {
		
		FileInputStream fis=new FileInputStream(".\\testdata\\testdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("Sheet1");
		int rows=ws.getLastRowNum();//3-count strats from zero
		int cols=ws.getRow(0).getLastCellNum();//2-count strats from one
		System.out.println("number of rows:"+rows);
		System.out.println("nummber of cols:"+cols);
		
		String[][] arr=new String[rows][cols];
		
		for(int r=1;r<=rows;r++)
		{
			
			XSSFCell cell=row.getCell(c);
			DataFormatter formatter=new DataFormatter();
			arr[r-1][c]=formatter.formatCellValue(cell);

}
	}
	
}
   //Dataprovider 2
