package cucumber.test.stepdefinations;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.test.pageobjects.LandingPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class UsingHook1 {
      
	String appUrl="http://automationpractice.com/";
	private static final Logger logg=LogManager.getLogger(UsingHook1.class);
	   WebDriver driver;
	   Scenario scn;
	   
	   LandingPage LandingPageObject;
	
	@Before
	public void before_scenario(Scenario scn)
	{
		this.scn=scn;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		scn.log("chrome browser opened");
		
		LandingPageObject=new LandingPage(driver);
		
	}
	
	@Given("User redirected to  url")
	public void user_redirected_to_url() {
		
		LandingPageObject.navigateToApplication(appUrl);  
	    String pageTitle="My Store";
	    LandingPageObject.validatePageTilte(pageTitle, driver.getTitle());
	    logg.info("url successfully opened");
	    
	}


	@When("User click on sign in button")
	public void user_click_on_sign_in_button() {
	   
		LandingPageObject.clickMethodForSignIn();	
	}
	
	@Then("Sign in page is displayed")
	public void sign_in_page_is_displayed() {
		
		String signInPageTitle="Login - My Store";
		LandingPageObject.validatePageTilte(signInPageTitle, driver.getTitle());
	}
	
	
	@When("User click on contact us button")
	public void user_click_on_contact_us_button() {
	    
		LandingPageObject.clickMethodForContactUs();
	}
	
	@Then("Contact us page is displayed")
	public void contact_us_page_is_displayed() {
		
		String contactUsPageTitle="Contact us - My Store";
		LandingPageObject.validatePageTilte(contactUsPageTitle, driver.getTitle());	
	}
	
	
	@When("User Search for product {string}")
	public void user_search_for_product(String products) {
	    
		LandingPageObject.sendingKeys(products);
		LandingPageObject.clickForSearchProdct();
	}


	

	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed() {
	    
		String expectedSearch="Search - My Store";
		LandingPageObject.validatePageTilte(expectedSearch, driver.getTitle());
		
	}

	
	@When("User click in facebook icon")
	public void user_click_in_facebook_icon() {
		
		LandingPageObject.clickForFacebook();
	}


	

	@Then("facebook page is displayed")
	public void facebook_page_is_displayed() {
	    
		LandingPageObject.windowhandling(2);
		String facebookExpectedTilte="Selenium Framework";
		LandingPageObject.validatePageTilte(facebookExpectedTilte, driver.getTitle());
		driver.close();
		LandingPageObject.windowhandling(1);
	}

	@When("User click on twitter icon")
	public void user_click_on_twitter_icon() {
		LandingPageObject.clickForTwitter();
	}


	

	@Then("twitter page is displayed")
	public void twitter_page_is_displayed()   {
	   
	   	LandingPageObject.windowhandling(2);
		//System.out.println("twitter page title is "   +     driver.getTitle());
		String twitterExpectedTitle=""; //Selenium Framework (@seleniumfrmwrk) / Twitter
		
		LandingPageObject.validatePageTilte(twitterExpectedTitle, driver.getTitle());
		driver.close();
		LandingPageObject.windowhandling(1);
	}

	@When("User click on youtube icon")
	public void user_click_on_youtube_icon() {
	   
		LandingPageObject.clickForYoutube();
	}


	

	@Then("youtube page is displayed")
	public void youtube_page_is_displayed() {
		LandingPageObject.windowhandling(2);
		String expectedYoutubeTitle="Selenium Framework - YouTube";
		LandingPageObject.validatePageTilte(expectedYoutubeTitle, driver.getTitle());
		driver.close();
		LandingPageObject.windowhandling(1);
		
	}

	@When("User click on googleplus icon")
	public void user_click_on_googleplus_icon() {
	   
		LandingPageObject.clickForGooglePlus();
	}


	

	@Then("googleplus page is displayed")
	public void googleplus_page_is_displayed() {
	    
		LandingPageObject.windowhandling(2);
		String expectedGooglePlusTitle="Sign in – Google accounts";
		LandingPageObject.validatePageTilte(expectedGooglePlusTitle, driver.getTitle());
		driver.close();
		LandingPageObject.windowhandling(1);
	}


	@After(order=1)
	public void after_scenario()
	{
		driver.quit();
	}
	
	
	@After(order=2)
	public void takingScreenShot(Scenario sc)
	{
		if(sc.isFailed())
		{
			TakesScreenshot screenShot=(TakesScreenshot) driver;
			byte[] data=screenShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "step which is failed" + sc.getName());
			
		}
		
		else
		{
			scn.log("no need for screenshot as tests are excuted successfully");
		}
		
	}
	
	
	
	
	
}
