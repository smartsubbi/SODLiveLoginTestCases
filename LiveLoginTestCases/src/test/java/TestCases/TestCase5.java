package TestCases;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Pages.AfterLoggedInPage;
import Pages.CommonHeader;
import Pages.LoginPage;
import Utility.BrowserCredentialLogger;
import Utility.CaptureScreenshot;

public class TestCase5 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;	
	Set<String> windowsOpen;	
	
	@BeforeClass
	public void setUp()
	{		
		report=ExtentManager.Instance();
	}
	
	@Parameters(value="Category")
	@Test
	public void ValidNonAuthorisedPlayerLogin(String catg)
	{
		logger = report.startTest("Test Case 5: QA - Age 13 Player (Authorized User) Login to School of Dragons Live ","This will verify if Authorized user with age 13 can login with valid credentials").assignCategory(catg);
		
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
		logger.log(LogStatus.INFO, "Successfully ran the Authentication exe ");
		
		header.clickHeaderLoginLink();
		logger.log(LogStatus.INFO, "Clicked the Login Link on the Homepage header");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.verifyLoginPageTitle();
		logger.log(LogStatus.INFO, "Login Page Title is verified");
		String loginPageScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, loginPageScreenshot);
		
		loginPage.userNameType("subbuPlayer");
		logger.log(LogStatus.INFO, "Entered username");
		loginPage.passwordType("123456");
		logger.log(LogStatus.INFO, "Entered password");
		String afterEnteringUsernameAndPassword=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, afterEnteringUsernameAndPassword);
		loginPage.playNowButtonClick();
		logger.log(LogStatus.INFO, "Clicked on the Play Now button after entering Username and Password");
		
		AfterLoggedInPage afterLoggedInPage = PageFactory.initElements(driver, AfterLoggedInPage.class);
        afterLoggedInPage.verifyAfterLoggedInPageTitle();					
		afterLoggedInPage.currentlyLoggedInText("subbuPlayer").isDisplayed();
		afterLoggedInPage.afterLoggedInSuccessfully();
		logger.log(LogStatus.INFO, "After Logged in Page is verified successfully");
		String afterLoggedinPageScreenshot=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
		logger.log(LogStatus.INFO, afterLoggedinPageScreenshot);
		
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
	
	@AfterClass
	public void tearDown()
	{
		report.endTest(logger);
		report.flush();	
		BrowserFactory.closeBrowser();
		report.close();		
		
	}
	

}
