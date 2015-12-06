package UnitTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import Utility.BrowserCredentialLogger;

public class TestScroll 
{
	
	@Test
	public void testScroll()
	{
		
	
		WebDriver driver = new FirefoxDriver();
		
		BrowserCredentialLogger.mozillaCredentialsLogger();
		
		driver.get("http://qa.schoolofdragons.com");
		
		driver.get("http://www.yopmail.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys("HpiPN5ogf25e4io");
		
		driver.findElement(By.xpath("//*[@id='f']/table/tbody/tr[1]/td/input[@class='sbut'][@type='submit'][@title='Check inbox @yopmail.com'][@value='Check Inbox']")).click();
		
		
		
		System.out.println(driver.findElements(By.tagName("iFrame")).size());
		
		driver.switchTo().frame(driver.findElement(By.id("ifmail")));
		
		
		driver.findElement(By.xpath("//*[@id='affim']")).click();
		
		String userName = "HpiPN5ogf25e4io";
		
		String userNameLine = "html/body/div[1]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/strong[contains(text(),'"+userName+"')][contains(text(),'Player')][contains(text(),'s Login:')]";
		
        driver.findElement(By.xpath(userNameLine));
        
        BrowserCredentialLogger.mozillaCredentialsLogger();
		
		driver.findElement(By.xpath("//img[@alt='Click Here to Activate Account'][@src='http://wm.schoolofdragons.com/SoD/Email/Authorization/AccountActivation/btn-activate.png']")).click();
		
		
		
//		driver.switchTo().defaultContent();
		
		
		
		
//		WebElement scroll = driver.findElement(By.xpath(".//*[@id='tc-content']/p[139]"));
//		scroll.sendKeys(Keys.PAGE_DOWN);
		
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='tc-content']/p[139]")));
	}

}
