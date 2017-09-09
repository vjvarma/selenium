package webAppTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxGmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FirefoxDriver driver=new FirefoxDriver();
driver.get("http://google.com");
driver.findElementByLinkText("Gmail").click();
driver.findElementByXPath("html/body/nav/div/a[2]").click();
driver.findElementByXPath("html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div/div[1]/div[1]/div/div[1]/div/div[1]/input").sendKeys("kvvarma2008");
driver.manage().window().maximize();
System.out.println(driver.getCurrentUrl());
System.out.println(driver.getTitle()); 

driver.close();
	}}