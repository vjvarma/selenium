package testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.examples.CreateCell;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
	
		 
		 FirefoxDriver driver;

		 @BeforeTest
		 public void ApplicationLaunch()
		 {
		   driver = new FirefoxDriver();
		  driver.get("http://newtours.demoaut.com");
		 }
		 
		 @Test
		 public void LogIn() throws IOException
		 {
			 
			  
			FileInputStream file=new FileInputStream("C:\\Users\\vijay\\Desktop\\DataDrivenLinksTestData.xlsx");
			 XSSFWorkbook wb=new XSSFWorkbook(file);
			 XSSFSheet ws=wb.getSheet("Sheet1");
			 
			 for(int i=1;i<=ws.getLastRowNum();i++){
			 Row r=ws.getRow(i);		 
			 driver.findElement(By.linkText(r.getCell(0).getStringCellValue())).click();;
			 String CurrentURL=driver.getCurrentUrl();
				r.createCell(2).setCellValue(CurrentURL);
				System.out.println(CurrentURL);
		 		
		 String ExpURL=r.getCell(1).getStringCellValue();
		 System.out.println(ExpURL);
		 if(CurrentURL.contains(ExpURL))
		 {
			 r.createCell(3).setCellValue("Pass");
			 
		 }
		 else{
			 r.createCell(3).setCellValue("Fail");
		 }
		 FileOutputStream file1=new FileOutputStream("C:\\Users\\vijay\\Desktop\\DataDrivenLinksTestData.xlsx");
			wb.write(file1);	
			driver.get("http://newtours.demoaut.com");
			 }
		 }
		 
		 
		 @AfterTest
		 public void ApplicationClose()
		 {
		  driver.close();
		 }
		}

