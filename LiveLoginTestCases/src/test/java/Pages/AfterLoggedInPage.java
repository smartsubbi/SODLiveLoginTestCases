package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utility.HighLighter;

public class AfterLoggedInPage 
{
	WebDriver driver;
	
	public AfterLoggedInPage(WebDriver driver)
	{
		this.driver = driver;		
	}
	
	public WebElement currentlyLoggedInText(String userName)
	{
		String loggedInTextXpath = "//div[@class='launchgame-content']/p[contains(text(),'"+userName+"')]/strong[contains(text(),'You are currently logged in as')]";
		return driver.findElement(By.xpath(loggedInTextXpath));		
	}
	
	@FindBy(xpath="//a[@id='ctl00_mcp_logout'][@class='LaunchClass'][@href='Logout.aspx'][.='Logout']")
	WebElement logoutAfterLoggedIn;
	
	@FindBy(xpath="//a[@id='change-password'][@class='LaunchClass'][@href='#'][.='Change Password']")
	WebElement changePasswordAfterLoggedIn;
	
	@FindBy(xpath="//p/a[@class='launch-game'][@href='#']")
	WebElement playGameAfterLoggedIn;
	
	public void afterLoggedInSuccessfully()
	{
		logoutAfterLoggedIn.isDisplayed();
		changePasswordAfterLoggedIn.isDisplayed();
		playGameAfterLoggedIn.isDisplayed();
	}
	
	public void clickPlayNowButton()
	{
		HighLighter.elementHighLight(driver, playGameAfterLoggedIn);
		playGameAfterLoggedIn.click();
	}
	
	public void verifyAfterLoggedInPageTitle()
	{
		String loggedInPageTitle = driver.getTitle();
		Assert.assertEquals(loggedInPageTitle, "Launch – Play Online Dragon Game for Kids – School of Dragons");
	}
}
