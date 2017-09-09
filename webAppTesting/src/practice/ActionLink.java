package practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionLink {
FirefoxDriver driver;
	@BeforeTest
public void OpenWebDriver(){
	driver=new FirefoxDriver();
	driver.get("http://infotech.com");
	driver.manage().window().maximize();
	}
	@Test
public void RunTest() throws IOException{
	FileInputStream file=new FileInputStream("C:\\Users\\vijay\\Desktop\\WorkSelenium\\webAppTesting\\file2.properties");
		Properties pr=new Properties();
	pr.load(file);
			WebElement Services=driver.findElement(By.linkText("Services"));
	Actions act=new Actions(driver);
	act.moveToElement(Services).perform();
	driver.findElement(By.linkText(pr.getProperty("ConsultinG"))).click();
	
	}
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
}

