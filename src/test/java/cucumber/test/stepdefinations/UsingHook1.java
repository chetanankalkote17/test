package cucumber.test.stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class UsingHook1 {
      
	   WebDriver driver;
	
	@Before
	public void before_scenario()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Given("User redirected to  url")
	public void user_redirected_to_url() {
		
           driver.get("http://automationpractice.com/");
	    
	    String pageTitle="My Store";
	    
	    Assert.assertEquals(pageTitle, driver.getTitle());
	}


	@When("User click on sign in button")
	public void user_click_on_sign_in_button() {
	  
		 WebElement signInButton=driver.findElement(By.xpath("//a[@class='login']"));
		   signInButton.click();
		
	}
	
	@Then("Sign in page is displayed")
	public void sign_in_page_is_displayed() {
		
		WebDriverWait wait1=new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.titleIs("Login - My Store"));
		Assert.assertEquals("Login - My Store", driver.getTitle());

	}

	@After
	public void after_scenario()
	{
		driver.quit();
	}
	
}
