package webAppTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTab {
	FirefoxDriver driver;
	@BeforeTest
	public void open(){
		 driver = new FirefoxDriver();
		driver.get("http://tsrtconline.in/oprs-web/");
		  
		  driver.manage().window().maximize();
	}
	@Test
	public void main() throws IOException{
	FileInputStream file=new FileInputStream("C:\\Users\\vijay\\Desktop\\WorkSelenium\\webAppTesting\\src\\webAppTesting\\file2.properties");
	Properties pr=new Properties();
	pr.load(file);
	driver.findElement(By.id(pr.getProperty("SearchBtn"))).click();
		 
 Alert alt=driver.switchTo().alert();
 
 System.out.println(alt.getText());
 Sleeper.sleepTightInSeconds(10);
 alt.accept();
	}
 
	
	@AfterTest
	public void tearDown(){
		  driver.close();
	
 
	}

}
