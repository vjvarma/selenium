package practice;


	

	import java.io.IOException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

	public class AutoIt {
	
	 public static void main(String[] args) throws IOException 
	 {
	  FirefoxDriver driver = new FirefoxDriver();
	  driver.get("http://seleniumhq.org");
	  
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.xpath("html/body/div[3]/div[1]/ul/li[4]/a")).click();
	  Sleeper.sleepTightInSeconds(2);
	  driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/p[3]/a")).click();
	  
	  //driver.findElement(By.linkText("3.5.3")).click();
	  Sleeper.sleepTightInSeconds(5);
	  java.lang.Runtime.getRuntime().exec("C:\\Users\\Sys\\Desktop\\FileDownload.exe");
      
	 }
}
