package testNG;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GRID {
	
		 @Parameters("Browser")
		 
		 @Test
		 public void FaceBookingApplLaunch(String b) throws MalformedURLException
		 {
		  System.out.println(b);
		  
		  DesiredCapabilities cap=null;
		  
		  if(b.equals("firefox"))
		  {
		   cap=DesiredCapabilities.firefox();
		   cap.setBrowserName("firefox");
		   cap.setPlatform(Platform.WINDOWS);
		  }
		  
		  else
		   if(b.equals("chrome"))
		   {
		    cap=DesiredCapabilities.chrome();
		    cap.setBrowserName("chrome");
		    cap.setPlatform(Platform.WINDOWS);
		   }
		  
		  RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:1111/wd/hub"),cap);
		  
		  driver.get("http://facebook.com");
		  driver.close();
		  
		  
		 }
		 
		}
