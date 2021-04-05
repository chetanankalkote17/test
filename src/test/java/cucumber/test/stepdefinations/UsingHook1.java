package cucumber.test.stepdefinations;

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
