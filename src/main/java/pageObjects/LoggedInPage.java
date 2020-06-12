package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPage {

	public WebDriver driver;
	
	By usernavigation = By.cssSelector("ul[class='navigation clearfix']");

	
	public LoggedInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	
	
	public WebElement usernavigation()
	{
		return driver.findElement(usernavigation);
	}

}
