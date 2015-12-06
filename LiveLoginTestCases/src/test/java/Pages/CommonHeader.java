package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utility.HighLighter;



public class CommonHeader 
{
	WebDriver driver;
	
	public CommonHeader(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[@id='ctl00_logindiv']/a[@class='logo'][@title='Log in'][@href='/Login.aspx']")
	WebElement headerLogInLink;
	
	@FindBy(xpath="//div[@id='ctl00_logoutdiv']/a[@class='logo'][@title='Logout'][@href='/Logout.aspx']")
	WebElement headerLogOutLink;
	
	@FindBy(xpath="//div[@id='ctl00_logindiv']/a[@class='logo'][@title='Create An Account'][@href='/Signup.aspx'][.='Create An Account']")
	WebElement headerCreateAnAccountLink;
	
	public void clickHeaderLoginLink()
	{
		HighLighter.elementHighLight(driver, headerLogInLink);
		headerLogInLink.click();
	}
	
	public void clickHeaderLogOutLink()
	{
		headerLogOutLink.click();
	}
	
	public void clickHeaderCreateAnAccountLink()
	{
		headerCreateAnAccountLink.click();
	}
	
	public void verifyHomePageTitle()
	{
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "How To Train Your Dragon Games | School of Dragons Online");
	}	

}
