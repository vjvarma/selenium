   package webAppTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataExl2 {
public static void main(String[] args) throws IOException
{
	FirefoxDriver driver = new FirefoxDriver();
	 driver.get("http://newtours.demoaut.com");
	  driver.manage().window().maximize();
	  
	  FileInputStream file=new FileInputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx");
      XSSFWorkbook wb = new XSSFWorkbook(file);
      XSSFSheet ws =wb.getSheet("Sheet1");
      
      Row r=ws.getRow(1);
      Cell c=r.getCell(0);
     String UserName=c.getStringCellValue();
     System.out.println(UserName);
     
     Row r1=ws.getRow(1);
     Cell c1=r1.getCell(1);
    String Password=c1.getStringCellValue();
    System.out.println(Password);
    
    Row r2=ws.getRow(1);
    Cell c2=r2.getCell(2);
    String RefData=c2.getStringCellValue();
    System.out.println(RefData);
    
    // Row r3=ws.createRow(1);
    //Cell c3=r3.createCell(3);
    //c3.setCellValue("Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city.");
   // FileOutputStream file1 =new FileOutputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx",true);
   // FileOutputStream file1 =new FileOutputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx", true);
   // wb.write(file1);
    
    Row r4=ws.getRow(1);
    Cell c4=r4.getCell(3);
    String ActData=c4.getStringCellValue();
    System.out.println(ActData);
    
    driver.findElement(By.name("userName")).sendKeys(UserName);
    driver.findElement(By.name("password")).sendKeys(Password);
    driver.findElement(By.name("login")).click();
    
    if(RefData.equals(ActData))
    {
    	Row r5=ws.createRow(1);
        Cell c5=r5.createCell(4);
       c5.setCellValue("Pass");
       FileOutputStream file1 =new FileOutputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx");	
    	wb.write(file1);
    }
    else
    {
    	Row r6=ws.createRow(1);
        Cell c6=r6.createCell(4);
       c6.setCellValue("Fail");
       FileOutputStream file1 =new FileOutputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx");	
    	wb.write(file1);
    	
    }

driver.close();
}}