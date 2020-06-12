package stepDefinations;

import pageObjects.LandingPage;
import pageObjects.LoggedInPage;
import pageObjects.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Resources.Base;


public class stepDefination extends Base {

	public WebDriver driver;
	
	@Before
    public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
		driver.manage().window().maximize();
    }
	
	@Given("^Navigate to Landing Page \"([^\"]*)\"$")
	public void navigate_to_landing_page_something(String strArg1) throws Throwable {
		driver.get(strArg1);
	}
	
	@And("^Click on Login link to navigate to sign in page$")
    public void click_on_login_link_to_navigate_to_sign_in_page() throws Throwable {
		LandingPage l = new LandingPage(driver);
		Thread.sleep(5000);
		
		if (l.getNoThanks().size() != 0)
		{
			l.getNoThanks().get(0).click();
		}
		
		l.getLogin();
    }
	
    @When("^^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage lp = new LoginPage(driver);
    	lp.getEmail().sendKeys(username);
    	Thread.sleep(5000);
		lp.getPassword().sendKeys(password);
		Thread.sleep(5000);
		lp.clickLogin().click();
    }

    @Then("^Login should be successful$")
    public void Login_should_be_successful() throws Throwable {
    	LoggedInPage lip = new LoggedInPage(driver);
    	if (lip.usernavigation().isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else
		{	
			getScreenshotPath(scenarioName, driver);
			Assert.assertFalse(false);			
		}  	
    }
	
	@After
    public void close_browsers() throws Throwable {
    	driver.close();
    }

}