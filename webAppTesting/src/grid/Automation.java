package grid;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Automation {
@Test
public void HomePageTest(){
	FirefoxDriver driver =new FirefoxDriver();
	driver.get("http://newtours.demoaut.com");
	Pom pom=PageFactory.initElements(driver, Pom.class);
    driver.manage().window().maximize();
	pom.Registration();
    driver.navigate().back();
    pom.contactLink();
    driver.navigate().back();
    pom.destinationlink();
    driver.navigate().back();
    pom.supportlink();
    driver.navigate().back();
    driver.close();
    
}
}
