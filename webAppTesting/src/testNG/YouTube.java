package testNG;

import java.util.Properties;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YouTube {
System.setProperties
	@BeforeTest
public void OpenApplication()
{
driver=new FirefoxDriver();		
driver.get("https://www.youtube.com/playlist?list=PLBFH5WGakOIHoeDvZWO-cMrhUUV5Xg0rm");
}
    @Test
public void Application(){
driver.findElementByXPath("html/body/div[2]/div[4]/div/div[5]/div/div[2]/div/div/div/div/div/div[2]/div[1]/a").click();
    }
}
