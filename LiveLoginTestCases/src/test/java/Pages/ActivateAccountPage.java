package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ActivateAccountPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//span[@id='ctl00_mcp_lblParentEmail'][.='seleniumsubbu@gmail.com']")
	WebElement emailAddress;	
	
	@FindBy(xpath="//input[@id='ctl00_mcp_txtParentPassword'][@type='password'][@name='ctl00$mcp$txtParentPassword']")
	WebElement activateAccountPageParentPasswordField;
	
	@FindBy(xpath="//input[@id='ctl00_mcp_txtConfirmParentPassword'][@type='password'][@name='ctl00$mcp$txtConfirmParentPassword']")
	WebElement activateAccountPageParentConfirmPasswordField;
	
	@FindBy(xpath="//select[@id='ctl00_mcp_ddlMonth'][@class='list_month'][@name='ctl00$mcp$ddlMonth']")
	WebElement activateAccountPageSelentMonthDropDown;
	
	@FindBy(xpath="//select[@id='ctl00_mcp_ddlDay'][@class='list_day'][@name='ctl00$mcp$ddlDay']")
	WebElement activateAccountPageSelentDayDropDown;
	
	@FindBy(xpath="//select[@id='ctl00_mcp_ddlYear'][@class='list_year'][@name='ctl00$mcp$ddlYear']")
	WebElement activateAccountPageSelentYearDropDown;
	
	@FindBy(xpath="//input[@id='ctl00_mcp_chkAgreeToTnC'][@type='checkbox'][@name='ctl00$mcp$chkAgreeToTnC']")
	WebElement tAndCCheckBox;
	
	@FindBy(xpath="//a[@id='ctl00_mcp_btnUpdate'][@class='activate-btn']")
	WebElement activateButton;
	
	@FindBy(xpath="//div[@id='page']/div/div[@class='confirmation-page']/div[@class='thank-you']/h1[contains(text(),'Thank you for activating your account')]")
	WebElement thankYouForActivatingAccountText;
	
	@FindBy(xpath="//*[@id='tc-content']/p[139]")
	WebElement clickInsideTandC;
	
	public void enterPassword(String password)
	{
		activateAccountPageParentPasswordField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String password)
	{
		activateAccountPageParentConfirmPasswordField.sendKeys(password);
	}
	
	public void selectMonth(String month)
	{
		Select se = new Select(activateAccountPageSelentMonthDropDown);
		se.selectByValue(month);		
	}
	
	public void selectDay(String day)
	{
		Select se = new Select(activateAccountPageSelentDayDropDown);
		se.selectByValue(day);		
	}
	
	public void selectYear(String year)
	{
		Select se = new Select(activateAccountPageSelentYearDropDown);
		se.selectByValue(year);		
	}
	
	public void scrollTandCtoTheEnd()
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='tc-content']/p[139]")));
	}
	
	public void tickCheckBox()
	{
		tAndCCheckBox.click();
	}
	
	public void clickActivateButton()
	{
		activateButton.click();
	}
	
	public void clickTandC()
	{
		clickInsideTandC.click();
	}
	
	public void verifyPlayerName(String userName)
	{		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='ctl00_mcp_lblUserName'][.='"+userName+"'])")).isDisplayed());		
	}
	
	public void verifyEmailID()
	{
		Assert.assertTrue(emailAddress!=null);
		Assert.assertTrue(emailAddress.isDisplayed());	
	}
	
	public void ThankYouForActivatingAccountText()
	{
		Assert.assertTrue(thankYouForActivatingAccountText!=null);
		Assert.assertTrue(thankYouForActivatingAccountText.isDisplayed());	
	}

}
