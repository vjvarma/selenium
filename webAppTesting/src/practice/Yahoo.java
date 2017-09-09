package practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Yahoo {
	FirefoxDriver driver;
	@BeforeTest
public void Open(){
driver=new FirefoxDriver();
driver.get("https://login.yahoo.com/account/create?src=ym&intl=us&lang=en-US&done=https%3A%2F%2Fmail.yahoo.com&specId=yidReg");
driver.manage().window().maximize();
	}
	
@Test
public void Appilcation() throws IOException{
	FileInputStream fileProperties=new FileInputStream("C:\\Users\\vijay\\Desktop\\WorkSelenium\\webAppTesting\\Yahoo.properties");
	Properties pr=new Properties();
	pr.load(fileProperties);
	FileInputStream file=new FileInputStream("C:\\Users\\vijay\\Desktop\\WorkSelenium\\webAppTesting\\src\\com\\InputFileTestData\\TestData.xlsx");
	XSSFWorkbook WB=new XSSFWorkbook(file);	
	XSSFSheet Ws=WB.getSheet("Sheet1");
	Row r=Ws.getRow(1);
	driver.findElement(By.id(pr.getProperty("FirstName"))).sendKeys(r.getCell(0).getStringCellValue());
	driver.findElement(By.id(pr.getProperty("LastName"))).sendKeys(r.getCell(1).getStringCellValue());
	driver.findElement(By.id(pr.getProperty("UserName"))).sendKeys(r.getCell(2).getStringCellValue());
	driver.findElement(By.id(pr.getProperty("Password"))).sendKeys(r.getCell(3).getStringCellValue());
	double d=r.getCell(4).getNumericCellValue();
	long L=(long)d;
	String S=Long.toString(L);
	driver.findElement(By.id(pr.getProperty("PhoneNumber"))).sendKeys(S);
	driver.findElement(By.id(pr.getProperty("BirthMonth"))).sendKeys(r.getCell(5).getStringCellValue());
	double d1=r.getCell(6).getNumericCellValue();
	long L1=(long)d1;
	String S1=Long.toString(L1);
	driver.findElement(By.id(pr.getProperty("BirthDay"))).sendKeys(S1);
	
	long L2=(long)r.getCell(7).getNumericCellValue();
	String S2=Long.toString(L2);
	driver.findElement(By.id(pr.getProperty("BirthYear"))).sendKeys(S2);
	driver.findElement(By.id(pr.getProperty("Gender"))).sendKeys(r.getCell(8).getStringCellValue());
	driver.findElement(By.id("reg-submit-button")).click();
}
@AfterTest
public void TearDown(){
driver.close();
}
}
