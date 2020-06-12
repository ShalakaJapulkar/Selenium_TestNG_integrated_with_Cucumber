package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By NoThanks = By.xpath("//button[contains(text(),'NO THANKS')]");
	By Login = By.xpath("//span[contains(text(),'Login')]");
	By Title = By.xpath("//h2");
	By NavigationBar = By.xpath("//nav[@class='navbar-collapse collapse']");
	By Header = By.cssSelector("div[class*='video-banner'] h3");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void getLogin()
	{
		driver.findElement(Login).click();
		
	}

	public List<WebElement> getNoThanks() 
	{
		return driver.findElements(NoThanks);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(Header);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavigationBar);
	}
}
