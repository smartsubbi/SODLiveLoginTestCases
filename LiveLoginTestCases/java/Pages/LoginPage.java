package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utility.HighLighter;



public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
 	
	@FindBy(xpath="//input[@id='ctl00_mcp_tbUserName'][@class='user-name'][@type='text'][@name='ctl00$mcp$tbUserName'][@maxlength='48']")
	WebElement loginPageUserNameInputField;
	
	@FindBy(xpath="//input[@id='ctl00_mcp_tbPassword'][@type='password'][@name='ctl00$mcp$tbPassword']")
	WebElement loginPagePasswordInputField;
	
	@FindBy(xpath="//input[@id='ctl00_mcp_btnLogin'][@class='SOD-Login-Btn'][@type='submit'][@name='ctl00$mcp$btnLogin']")
	WebElement loginPagePlayNowButton;
	
	public void verifyLoginPageTitle()
	{
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "Login – How to Train Your Dragon Game – School of Dragons");
	}
	
	public void userNameType(String userName)
	{
		HighLighter.elementHighLight(driver, loginPageUserNameInputField);
		loginPageUserNameInputField.sendKeys(userName);
	}
	
	public void passwordType(String password)
	{
		HighLighter.elementHighLight(driver, loginPagePasswordInputField);
		loginPagePasswordInputField.sendKeys(password);
	}
	
	public void playNowButtonClick()
	{		
		HighLighter.elementHighLight(driver, loginPagePlayNowButton);
		loginPagePlayNowButton.click();	
	}
}
