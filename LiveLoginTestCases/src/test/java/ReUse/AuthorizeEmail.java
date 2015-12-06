package ReUse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utility.BrowserCredentialLogger;

public class AuthorizeEmail 
{
	WebDriver driver;
	
	String userNameLine;
	
	
	@FindBy(xpath="//*[@id='Email']")
	WebElement emailInputField;
	
	@FindBy(xpath="//*[@id='next']")
	WebElement nextButton;
	
	@FindBy(xpath="//*[@id='Passwd']")
	WebElement passwordInputField;
	
	@FindBy(xpath="//*[@id='signIn']")
	WebElement signInButton;
	
	@FindBy(xpath="//*[@id=':hw']/div/div[2]/span/a")
	WebElement sodFolder;
	
	@FindBy(xpath="html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[7]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/div/div/div/span[1]/b[.='School of Dragons Gameplay Permission']")
	WebElement firstEmail;
	
	@FindBy(xpath="//img[@alt='Click Here to Activate Account']")
	WebElement clickHereToActivateAccount;	  
	
	public void authroiseEmail(String userName) throws Throwable
	{		
		Thread.sleep(3000);
		
		emailInputField.sendKeys("seleniumsubbu@gmail.com");
		
		nextButton.click();
		
		Thread.sleep(3000);
		
		passwordInputField.sendKeys("blademaster1");
		
		signInButton.click();
		
		Thread.sleep(10000);
		
//		sodFolder.click();
//		
//		Thread.sleep(3000);
		
		firstEmail.click();			
		
		Thread.sleep(3000);
		
//		String userNameLine = "//table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/strong[contains(text(),'"+userName+"')][contains(text(),'Player')][contains(text(),'s Login:')]";
//		
//		
//		System.out.println(userNameLine);
//		
//		driver.findElement(By.xpath(userNameLine)).isDisplayed();     
		
		BrowserCredentialLogger.mozillaCredentialsLogger();
		
		clickHereToActivateAccount.click();	
		
		Thread.sleep(3000);
	}	
}
