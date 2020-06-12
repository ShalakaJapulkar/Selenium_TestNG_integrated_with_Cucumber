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

public class ValidateTitle extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage l;
	
	@BeforeTest
	public void InitilizeTest() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
	}
	
	@Test (priority = 1)
	public void ValidateAppTitle() throws IOException
	{
		l = new LandingPage(driver);
		
		if (l.getNoThanks().size() != 0)
		{
			l.getNoThanks().get(0).click();
		}
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Title validation successful");
	}
	
	@Test (priority = 2)
	public void ValidateAppHeader() throws IOException
	{
		
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Header validation successful");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
}

