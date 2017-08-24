package applicationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	FirefoxDriver driver;
	@Given("^Open firefox and start aplication$")
	public void Open_firefox_and_start_aplication() throws Throwable {
	   driver=new FirefoxDriver();
	   driver.get("http://newtours.demoaut.com");
	}

	@When("^i enter valid UserName and Pasword$")
	public void i_enter_valid_UserName_and_Pasword() throws Throwable {
		  driver.findElement(By.name("userName")).sendKeys("tutorial");
		  driver.findElement(By.name("password")).sendKeys("tutorial");
		  driver.findElement(By.name("login")).click();
	}

	@Then("^User Should be able to Login Successfully$")
	public void User_Should_be_able_to_Login_Successfully() throws Throwable {
		driver.close();
	}

}
