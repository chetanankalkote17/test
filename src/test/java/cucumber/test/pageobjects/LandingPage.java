package cucumber.test.pageobjects;

import java.util.Iterator;
import java.util.Set;

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
	
	private By facebooklink=By.xpath("//div[@class='footer-container']//footer[@id='footer']//div[@class='row']//section[@id='social_block']//ul//li[@class='facebook']/a[@href='https://www.facebook.com/groups/525066904174158/']");
	
	private By twitterLink=By.xpath("//div[@class='footer-container']//footer[@id='footer']//div[@class='row']//section[@id='social_block']//ul//li[@class='twitter']/a[@href='https://twitter.com/seleniumfrmwrk']");
	
	private By youtubeLink=By.xpath("//div[@class='footer-container']//footer[@id='footer']//div[@class='row']//section[@id='social_block']//ul//li[@class='youtube']/a[@href='https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA']");
	
	private By googlePlusLink=By.xpath("//a[@href='https://plus.google.com/111979135243110831526/posts']");
	
	
	
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
	
	
	public void clickForFacebook()
	{
		driver.findElement(facebooklink).click();
	}
	
	public void windowhandling(int windowNumber)
	{
		String windowid=null;
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		for(int i=1;  i<=windowNumber;    i++)
		{
			windowid=it.next();
		}
		driver.switchTo().window(windowid);
	}
	
	public void clickForTwitter()
	{
		driver.findElement(twitterLink).click();
	}
	public void clickForYoutube()
	{
		driver.findElement(youtubeLink).click();
	}
	
	public void clickForGooglePlus()
	{
		driver.findElement(googlePlusLink).click();
	}
	
	
}
