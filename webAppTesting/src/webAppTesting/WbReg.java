package webAppTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WbReg {
	
			 public static void main(String[] args) throws IOException{
		
				// System.setProperty("webdriver.edge.driver", "C:\\MicrosoftWebDriver.exe");
			//data driven testing selenium webdriver	  
				 // EdgeDriver driver = new EdgeDriver();
				//System.setProperty("webdriver.edge.driver", "C:\\MicrosoftWebDriver.exe");
				//EdgeDriver driver=new EdgeDriver();
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");	
			ChromeDriver driver=new ChromeDriver();
	    //FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		//driver.manage().window().maximize();
		
		FileInputStream file=new FileInputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		
		
		for(int i=1;i<=ws.getLastRowNum();i++){
		Row r=ws.getRow(i);
	     	     
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());	 
		//driver.findElement(By.name("phone")).sendKeys(r.getCell(2).getNumericCellValue();
		driver.findElement(By.name("userName")).sendKeys(r.getCell(3).getStringCellValue());	 
		driver.findElement(By.name("address1")).sendKeys(r.getCell(4).getStringCellValue());
		driver.findElement(By.name("city")).sendKeys(r.getCell(5).getStringCellValue());	 
		driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
		//driver.findElement(By.name("postalCode")).sendKeys(r.getCell(7).getStringCellValue());	 
		String Username=r.getCell(8).getStringCellValue();
		//String containUser="Note: Your user name is "+Username+".";
		driver.findElement(By.name("email")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(r.getCell(9).getStringCellValue());
		driver.findElement(By.name("confirmPassword")).sendKeys(r.getCell(10).getStringCellValue());
		driver.findElement(By.name("register")).click();
		String  YourUserName=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
		
		
		if(YourUserName.contains(Username)){
			
			r.createCell(11).setCellValue("Pass");
		}
		else{
			r.createCell(11).setCellValue("fail");
		}
		 
		FileOutputStream file1 = new FileOutputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx");
	     wb.write(file1); 
	     
		}
	     driver.close();
		 }
	}


