package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NotAuthorisedPopUp 
{
	@FindBy(xpath="//*[@id='parentUnAuthorizedLabel'][contains(text(),'Your account hasn')][contains(text(),'t been activated yet. Please re-enter your parent email to resend the activation email. If your parent don')][contains(text(),'t activate your account it will be deleted in60days and you')][contains(text(),'ll lose all your progress.')]")
	WebElement unAuthorizedText;
	
	@FindBy(xpath="//*[@id='unauthorized-popup']/div/a[@class='ok-btn'][@onclick='RedirectUnAuthorizedUser()'][@href='#'][.='OK']")
	WebElement unAuthorizedPopUpOkButton;
	
	@FindBy(xpath="//*[@id='parentEmailLabel'][.='Account Email<']")
	WebElement unAuthorizedPopUpAccountEmailText;
	
	@FindBy(xpath="//*[@id='tbEmail'][@type='text']")
	WebElement unAuthorizedPopUpAccountEmailInputField;
	
	@FindBy(xpath="//*[@id='unauthorized-popup']/div/span[@class='resend-authorization'][@onclick='return ResendEmail()']")
	WebElement unAuthorizedPopUpResendEmailButton;
	
	public void authorizedPopUpValidation()
	{
		Assert.assertTrue(unAuthorizedText!=null);
		Assert.assertTrue(unAuthorizedPopUpOkButton!=null);
		Assert.assertTrue(unAuthorizedPopUpAccountEmailText!=null);
		Assert.assertTrue(unAuthorizedPopUpAccountEmailInputField!=null);
		Assert.assertTrue(unAuthorizedPopUpResendEmailButton!=null);		
	}
	
	public void clickUnAuthorizedPopUpOkButton()
	{
		unAuthorizedPopUpOkButton.click();
	}

}
