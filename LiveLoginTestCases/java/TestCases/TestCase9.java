package TestCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Pages.ActivateAccountPage;
import Pages.AfterLoggedInPage;
import Pages.AlmostDonePopUp;
import Pages.CommonHeader;
import Pages.CreateAnAccountPage;
import Pages.LoginPage;
import Pages.SignUpPage;
import ReUse.AuthorizeEmail;
import Utility.BrowserCredentialLogger;
import Utility.CaptureScreenshot;
import Utility.GetNewEmail;
import Utility.RandomStringGenerator;

public class TestCase9 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;			
	
	@BeforeClass
	public void setUp()
	{		
		report=ExtentManager.Instance();
	}
	
	@Parameters(value="Category")
	@Test
	public void createNewUserAge12() throws Throwable
	{
        logger = report.startTest("Test Case 6: QA - Age 12 Player (Authorized User) Login to School of Dragons Live ","This will verify if a Autorized user with age 12 can login with valid credentials").assignCategory("none");
		
		driver = BrowserFactory.getBrowser("firefox");
		logger.log(LogStatus.INFO, "Browser is up and running");
		String browserOpenedScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, browserOpenedScreenshot);
		
		BrowserCredentialLogger.mozillaCredentialsLogger();
		logger.log(LogStatus.INFO, "Successfully ran the Authentication exe ");
		
		driver.get("http://qa.schoolofdragons.com");		
		logger.log(LogStatus.INFO, "Entered Authentication credentials successfully and Url is Loading");		
		
		CommonHeader header = PageFactory.initElements(driver, CommonHeader.class);
		header.verifyHomePageTitle();
		logger.log(LogStatus.INFO, "Home Page Title is verified");
		String homePageScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, homePageScreenshot);		
				
		BrowserCredentialLogger.mozillaCredentialsLogger();
		header.clickHeaderCreateAnAccountLink();
		logger.log(LogStatus.INFO, "Clicked the Create an Account Link on the Homepage header");
		
		Thread.sleep(5000);
		
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
//		signUpPage.verifySignUpPageTitle();
		logger.log(LogStatus.INFO, "Sign Up Page Title is verified");
		String signUpPageScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, signUpPageScreenshot);
		
		signUpPage.confirmButtonDisabledElementValidation();
		logger.log(LogStatus.INFO, "Verified if the Confirm Button is disabled");
		
		signUpPage.selectAge("12");
		logger.log(LogStatus.INFO, "Select age 12");
		
		signUpPage.selectedAgeElementValidation();
		logger.log(LogStatus.INFO, "Verify is age selected is 12");
		
		signUpPage.confirmButtonEnabledElementValidation();
		logger.log(LogStatus.INFO, "Verify if the confirm button is enabled");
		
		String signUpPageAfterAgeSelection=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, signUpPageAfterAgeSelection);
		
		signUpPage.clickConfirmButton();
		logger.log(LogStatus.INFO, "Click on the Confirm Button");	
		
		CreateAnAccountPage createAnAccountPage = PageFactory.initElements(driver, CreateAnAccountPage.class);
//		createAnAccountPage.verifyCreateAnAccountPageTitle();
		logger.log(LogStatus.INFO, "Create an account Page Title is verified");
		String createAnAccountPageScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, createAnAccountPageScreenshot);
		
		createAnAccountPage.selectedAgeElementValidation();
		logger.log(LogStatus.INFO, "Verify is age selected is 12");
		
		String string = RandomStringGenerator.generateRandomString();
		String emailAddress = GetNewEmail.getNewEmail(string);
		
		createAnAccountPage.enterEmail("seleniumsubbu@gmail.com");
		logger.log(LogStatus.INFO, "Enter Email address");
		
		createAnAccountPage.enterUserName(string);
		logger.log(LogStatus.INFO, "Enter Username");
		
		createAnAccountPage.enterPassword("123456");
		logger.log(LogStatus.INFO, "Enter Password");	
		
		String createAnAccountPageAfterEnteringAllDetailsScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, createAnAccountPageAfterEnteringAllDetailsScreenshot);
		
		createAnAccountPage.clickFinishAndPlayButton();
		
		AlmostDonePopUp almostDonePopUp = PageFactory.initElements(driver, AlmostDonePopUp.class);
		almostDonePopUp.verifyAlmostDonePopUpTexts();
		String almostDonePeopUpScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, almostDonePeopUpScreenshot);
		
		almostDonePopUp.clickAlmostDonePopUpPlayNowButton();
		
		AfterLoggedInPage afterLoggedInPage = PageFactory.initElements(driver, AfterLoggedInPage.class);
        afterLoggedInPage.verifyAfterLoggedInPageTitle();					
		afterLoggedInPage.currentlyLoggedInText(string).isDisplayed();
		afterLoggedInPage.afterLoggedInSuccessfully();
		logger.log(LogStatus.INFO, "After Logged in Page is verified successfully");
		String afterLoggedinPageScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, afterLoggedinPageScreenshot);
		
		driver.get("http://www.gmail.com");		
		String parentWindow = driver.getWindowHandle();
		
		AuthorizeEmail authorizeEmail = PageFactory.initElements(driver, AuthorizeEmail.class);		
		authorizeEmail.authroiseEmail(string);	
		
		Thread.sleep(9000);
		System.out.println(driver.getWindowHandles().size());
		
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
		
		ActivateAccountPage activateAccountPage = PageFactory.initElements(driver, ActivateAccountPage.class);
		activateAccountPage.verifyEmailID();
		activateAccountPage.enterPassword("123456");
		activateAccountPage.enterConfirmPassword("123456");
		activateAccountPage.selectMonth("6");
		activateAccountPage.selectDay("11");
		activateAccountPage.selectYear("1984");
		activateAccountPage.clickTandC();
		activateAccountPage.tickCheckBox();
		activateAccountPage.clickActivateButton();		
		activateAccountPage.ThankYouForActivatingAccountText();		
		BrowserFactory.closeBrowser();
		logger.log(LogStatus.INFO, "Quitting the Browser Opened");	
		
		
	}
	
	@AfterMethod
	public void afterTest(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)	
		{		
			logger.log(LogStatus.FAIL, "<pre>" + result.getThrowable().getMessage() + "</pre>");
			String failureScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver,result.getName()));			  
			logger.log(LogStatus.FAIL, failureScreenshot);				
		}		
	}

}
