package webAppTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
 
public class Gmail {
	 public static void main(String[] args) throws IOException{
		 
		 	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 	ChromeDriver driver=new ChromeDriver();
		 	driver.get("https://accounts.google.com/SignUp?service=mail&continue=https://mail.google.com/mail/?pc=topnav-about-en");
		 	driver.manage().window().maximize();	
		 	FileInputStream file=new FileInputStream("C:\\Users\\vijay\\Desktop\\TEST.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFSheet ws=wb.getSheet("Sheet1");
			for(int i=1;i<=ws.getLastRowNum();i++){
			Row r=ws.getRow(i);
				driver.findElement(By.name("FirstName")).sendKeys(r.getCell(0).getStringCellValue());
				driver.findElement(By.name("LastName")).sendKeys(r.getCell(1).getStringCellValue());	 
				driver.findElement(By.name("GmailAddress")).sendKeys(r.getCell(2).getStringCellValue());	 
				driver.findElement(By.name("Passwd")).sendKeys(r.getCell(3).getStringCellValue());
				driver.findElement(By.name("PasswdAgain")).sendKeys(r.getCell(4).getStringCellValue());
				driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[1]/div/form/div[5]/fieldset/label[1]/span/div")).sendKeys(r.getCell(5).getStringCellValue());
				double l=r.getCell(6).getNumericCellValue();
			    long p= (long)l;
			    String k=Long.toString(p);
			    driver.findElement(By.name("BirthDay")).sendKeys(k);			    
			    double l1=r.getCell(7).getNumericCellValue();
			    long p1= (long)l1;
			    String k1=Long.toString(p1);
			    driver.findElement(By.name("BirthYear")).sendKeys(k1);
			    driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[1]/div/form/div[6]/label/div/div")).sendKeys(r.getCell(8).getStringCellValue());
			    double l2=r.getCell(9).getNumericCellValue();
			    long p2= (long)l2;
			    String k2=Long.toString(p2);
			    driver.findElement(By.name("RecoveryPhoneNumber")).sendKeys(k2);	
			    driver.findElement(By.name("RecoveryEmailAddress")).sendKeys(r.getCell(10).getStringCellValue());
				driver.findElement(By.id("submitbutton")).click();
			    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/div/div/img")).click();
			    Sleeper.sleepTightInSeconds(2);
			    driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/div/div/img")).click();
			    driver.findElement(By.id("iagreebutton")).click();
				}
			     
				 }
			
	 }

