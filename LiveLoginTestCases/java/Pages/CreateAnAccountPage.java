package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateAnAccountPage 
{
	
    WebDriver driver;
	
	public void verifyCreateAnAccountPageTitle()
	{
		String createAnAccountPageTitle = driver.getTitle();
		Assert.assertEquals(createAnAccountPageTitle, "Sign Up – Play Dragon Game Online – School of Dragons");
	}
	
	@FindBy(xpath="//select[@id='ctl00_mcp_ucRegModule_ddlAge'][@class='list_month'][@name='ctl00$mcp$ucRegModule$ddlAge']/option[@value='12'][@selected='selected'][.='12']")
	WebElement createAnAccountPageSelectedAge;
	
	public void selectedAgeElementValidation()
	{
		Assert.assertTrue(createAnAccountPageSelectedAge!=null);
		Assert.assertTrue(createAnAccountPageSelectedAge.isDisplayed());				
	}
	
	@FindBy(xpath="//input[@id='ctl00_mcp_ucRegModule_tbEmail'][@type='text'][@name='ctl00$mcp$ucRegModule$tbEmail']")
	WebElement createAnAccountPageEmailInputField;
	
	@FindBy(xpath="//input[@id='ctl00_mcp_ucRegModule_tbUName'][@type='text'][@name='ctl00$mcp$ucRegModule$tbUName']")
	WebElement createAnAccountPageUserNameInputField;
	
	@FindBy(xpath="//input[@id='ctl00_mcp_ucRegModule_tbPassword'][@type='password'][@name='ctl00$mcp$ucRegModule$tbPassword']")
	WebElement createAnAccountPagePasswordInputField;
	
	@FindBy(xpath="//a[@id='ctl00_mcp_ucRegModule_btnSubmit'][@class='play-now']")
	WebElement createAnAccountPageFinishAndPlayButton;
	
	public void enterEmail(String email)
	{
		createAnAccountPageEmailInputField.sendKeys(email);
	}
	
	public void enterUserName(String userName)
	{
		createAnAccountPageUserNameInputField.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		createAnAccountPagePasswordInputField.sendKeys(password);
	}
	
	public void clickFinishAndPlayButton()
	{
		createAnAccountPageFinishAndPlayButton.click();
	}
}