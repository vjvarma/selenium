package webAppTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataExl {
public static void main(String[] args) throws IOException
{
	
	FirefoxDriver driver = new FirefoxDriver();
	  driver.get("http://newtours.demoaut.com");
	  driver.manage().window().maximize();
	  FileInputStream file=new FileInputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx");
      XSSFWorkbook wb = new XSSFWorkbook(file);
      XSSFSheet ws =wb.getSheet("Sheet1");
     Row  r=ws.createRow(0);
     Cell c = r.createCell(0); 
     c.setCellValue("UserName");
     Row  r1=ws.createRow(0);
     Cell c1 = r1.createCell(1); 
     c1.setCellValue("Password");
FileOutputStream file1=new FileOutputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx");
wb.write(file1);
}
}
