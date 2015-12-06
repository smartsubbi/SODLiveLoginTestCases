package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUpPage
{
	WebDriver driver;
	
	public void verifySignUpPageTitle()
	{
		String signUpPageTitle = driver.getTitle();
		Assert.assertEquals(signUpPageTitle, "Sign Up – Play Dragon Game Online – School of Dragons");
	}
	
	@FindBy(xpath="//a[@id='ctl00_mcp_ucRegModule_btnAgeSelector'][@class='SOD-Confirm-BtnInactive'][@usesubmitbehavior='false'][@disabled='disabled'][.='Confirm']")
	WebElement signUpPageDisabledConfirmButton;
	
	public void confirmButtonDisabledElementValidation()
	{
		Assert.assertTrue(signUpPageDisabledConfirmButton!=null);
		Assert.assertTrue(signUpPageDisabledConfirmButton.isDisplayed());				
	}
	
	@FindBy(xpath="//select[@id='ctl00_mcp_ucRegModule_ddlAge'][@class='list_month'][@name='ctl00$mcp$ucRegModule$ddlAge']")
	WebElement signUpPageDropDownBox;
	
	public void selectAge(String age)
	{
		Select se = new Select(signUpPageDropDownBox);
		se.selectByValue(age);		
	}
	
	@FindBy(xpath="//select[@id='ctl00_mcp_ucRegModule_ddlAge'][@class='list_month'][@name='ctl00$mcp$ucRegModule$ddlAge']/option[@value='12'][@selected='selected'][.='12']")
	WebElement signUpPageSelectedAge;
	
	@FindBy(xpath="//a[@id='ctl00_mcp_ucRegModule_btnAgeSelector'][@class='SOD-Confirm-Btn'][@usesubmitbehavior='false'][.='Confirm']")
	WebElement signUpPageEnabledConfirmButton;
	
	public void selectedAgeElementValidation()
	{
		Assert.assertTrue(signUpPageSelectedAge!=null);
		Assert.assertTrue(signUpPageSelectedAge.isDisplayed());				
	}
	
	public void confirmButtonEnabledElementValidation()
	{
		Assert.assertTrue(signUpPageEnabledConfirmButton!=null);
		Assert.assertTrue(signUpPageEnabledConfirmButton.isDisplayed());				
	}
	
	public void clickConfirmButton()
	{
		signUpPageEnabledConfirmButton.click();
	}
	
	
	
	

}
