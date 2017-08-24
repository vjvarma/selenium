package webAppTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegPage {
	 public static void main(String[] args){
	FirefoxDriver driver=new FirefoxDriver();
	driver.get("http://newtours.demoaut.com");
	driver.manage().window().maximize();
	
	driver.findElement(By.linkText("REGISTER")).click();
	driver.findElement(By.name("firstName")).sendKeys("vijay");
	driver.findElement(By.name("lastName")).sendKeys("lastName");	 
	driver.findElement(By.name("phone")).sendKeys("9545454545");
	driver.findElement(By.name("userName")).sendKeys("vj@gmail.com");	 
	driver.findElement(By.name("address1")).sendKeys("123 street 123 ca");
	driver.findElement(By.name("city")).sendKeys("fremot");	 
	driver.findElement(By.name("state")).sendKeys("ca");
	driver.findElement(By.name("postalCode")).sendKeys("77556");	 
	String Username="ViJay";
	String containUser="Note: Your user name is "+Username+".";
	driver.findElement(By.name("email")).sendKeys(Username);
	driver.findElement(By.name("password")).sendKeys("ViJay");
	driver.findElement(By.name("password")).sendKeys("ViJay");
	driver.findElement(By.name("register")).click();
	String  YourUserName=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
	
	if(containUser.equals(YourUserName)){
		
		System.out.println("pass");
	}
	else{
		System.out.println("fail");
	}
	 driver.close();
	 }
}
