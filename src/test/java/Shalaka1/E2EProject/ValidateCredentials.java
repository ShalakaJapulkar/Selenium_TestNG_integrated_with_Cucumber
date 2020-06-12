package Shalaka1.E2EProject;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoggedInPage;
import pageObjects.LoginPage;

public class ValidateCredentials extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void InitilizeTest() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider = "getData")
	public void ValidateAppCredentials(String Username, String Password ) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
		
		LandingPage l = new LandingPage(driver);
		Thread.sleep(5000);
		
		if (l.getNoThanks().size() != 0)
		{
			l.getNoThanks().get(0).click();
		}
		
		l.getLogin();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		Thread.sleep(5000);
		lp.getPassword().sendKeys(Password);
		Thread.sleep(5000);
		log.info("Entered " + Username + " and " + Password + " successfully");
		lp.clickLogin().click();
		LoggedInPage lip = new LoggedInPage(driver);
    	if (lip.usernavigation().isDisplayed())
		{
			Assert.assertTrue(true);
			log.info("Logged in successfully");
		}
		else
		{
			log.info("Login unsuccessful");
			Assert.assertFalse(false);
			
		}		
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "test8229290@gmail.com";
		data[0][1] = "1234567";
		data[1][0] = "user01@gmail.com";
		data[1][1] = "456789";
		
		return data;
	}
	
}

