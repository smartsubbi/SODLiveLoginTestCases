package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlmostDonePopUp
{
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='confirmation-form']/div[@class='SOD-DIV-POPUP']/h1[.='Almost Done!']")
	WebElement almostDoneText;
	
	@FindBy(xpath="//*[@id='ctl00_mcp_RegistrationConfirmation_parentLabel'][.='An email has been sent to your parent. Play now while your parent completes the registration.']")
	WebElement emailSentConfirmationText;
	
	@FindBy(xpath="//*[@id='btnLogin']/div[@class='SOD-Login-Btn'][@onclick='RedirectToGamePage()']")
	WebElement almostDonePopUpPlayNowButton;
	
	public void verifyAlmostDonePopUpTexts()
	{
		Assert.assertTrue(almostDoneText!=null);
		Assert.assertTrue(almostDoneText.isDisplayed());
		Assert.assertTrue(emailSentConfirmationText!=null);
		Assert.assertTrue(emailSentConfirmationText.isDisplayed());
	}
	
	public void clickAlmostDonePopUpPlayNowButton()
	{
		almostDonePopUpPlayNowButton.click();		
	}

}
