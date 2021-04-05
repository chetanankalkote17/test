package cucumber.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LandingPage {

	WebDriver driver;
	
	private By signInButton=By.xpath("//a[@class='login']");
	
	private By contactUs=By.xpath("//a[@title='Contact Us']");
	
	private By searchProducts=By.xpath("//input[@id='search_query_top']");
	
	private By searchButton=By.xpath("//button[@name='submit_search']");
	
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void clickMethodForSignIn()
	{
		driver.findElement(signInButton).click();
	}
	
	public void clickMethodForContactUs()
	{
		driver.findElement(contactUs).click();
	}
	
	public void validatePageTilte(String expectedTitle,String actualTitle)
	{
		WebDriverWait wait1=new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.titleIs(expectedTitle));
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	public void navigateToApplication(String url)
	{
		driver.get(url);
	}
	
	public void sendingKeys(String textToSend)
	{
		driver.findElement(searchProducts).sendKeys(textToSend);
		
	}
	
	public void clickForSearchProdct()
	{
		driver.findElement(searchButton).click();
	}
	
	
	
	
	
	
}
