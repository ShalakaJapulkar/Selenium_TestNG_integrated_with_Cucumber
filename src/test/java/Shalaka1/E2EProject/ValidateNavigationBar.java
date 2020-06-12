package Shalaka1.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;

public class ValidateNavigationBar extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void InitilizeTest() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
	}
	
	@Test
	public void ValidateAppNavigationBar()
	{
		LandingPage l = new LandingPage(driver);
		
		if (l.getNoThanks().size() != 0)
		{
			l.getNoThanks().get(0).click();
		}
		
		if (l.getNavigationBar().isDisplayed())
		{
			Assert.assertTrue(true);
			log.info("Navigation Bar validated");
		}
		else
		{
			Assert.assertFalse(false);
			log.error("Navigation bar not present");
		}	
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
}

