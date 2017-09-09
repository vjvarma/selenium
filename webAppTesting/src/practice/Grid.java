package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid {
 @Parameters ("Browser")
 @Test
 public void application(String b) throws IOException{{
		System.out.println(b);
DesiredCapabilities cap=null;

if(b.equals("firefox")){
cap=DesiredCapabilities.firefox();
cap.setBrowserName("firefox");
cap.setPlatform(Platform.WINDOWS);
}


else if (b.equals("chrome"))
{
	cap=DesiredCapabilities.chrome();
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.WINDOWS);
}
 RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
driver.get("https://login.yahoo.com/account/create?src=ym&intl=us&lang=en-US&done=https%3A%2F%2Fmail.yahoo.com&specId=yidReg");
driver.manage().window().maximize();
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

driver.close();
}

 }}
 

