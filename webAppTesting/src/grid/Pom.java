package grid;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pom {

	@FindBy(linkText="REGISTER")
    WebElement Register;
	public void Registration()
	{
		Register.click();
	}

	@FindBy(linkText="SUPPORT")
WebElement Support;
public void supportlink()
{
Support.click();	
}

@FindBy(linkText="CONTACT")
WebElement Contact;
public void contactLink(){

	Contact.click();
	}

@FindBy(linkText="your destination")
WebElement destination;
public void destinationlink()
{
destination.click();	
}

}
