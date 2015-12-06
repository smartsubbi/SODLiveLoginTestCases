package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLighter 

{

	
	
	public static void elementHighLight(WebDriver driver,WebElement element)
	{
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px red');", element);
		
		try 
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e) 
		{
			
		}
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
	}
	
	
}
