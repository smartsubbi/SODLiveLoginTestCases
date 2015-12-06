package UnitTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Factory.BrowserFactory;

public class BrowserFactoryUnitTest 
{
	@Test(priority=1)
	public void getFirefoxDriverUnitTest()
	{		
		WebDriver driver = BrowserFactory.getBrowser("FIREFOX");
		Assert.assertTrue(driver!=null);
		BrowserFactory.closeBrowser();
	}
	
	@Test(priority=2)
	public void getChromeDriverUnitTest()
	{		
		WebDriver driver = BrowserFactory.getBrowser("CHROME");
		Assert.assertTrue(driver!=null);
		BrowserFactory.closeBrowser();
	}
	
	@Test(priority=3)
	public void getInternetExplorerDriverUnitTest()
	{		
		WebDriver driver = BrowserFactory.getBrowser("IE");
		Assert.assertTrue(driver!=null);
		BrowserFactory.closeBrowser();
	}
	
	

}
