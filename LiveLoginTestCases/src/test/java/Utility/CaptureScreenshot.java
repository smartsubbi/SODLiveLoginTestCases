package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot 
{
	public static String takeScreenshot(WebDriver driver,String screenshotname)
	{
		
	TakesScreenshot ts=(TakesScreenshot)driver;
		
	 File src= ts.getScreenshotAs(OutputType.FILE);  
	 
	 String userDirectory =  System.getProperty("user.dir");
		String path = userDirectory.replace("\\","/");
	  
	 String destination=path+"/Screenshots/"+screenshotname+System.currentTimeMillis()+".jpg";
		
	 try 
	 {
		FileUtils.copyFile(src, new File(destination));
	} 
	 catch (IOException e) 
	 {
		
	}
	 
	 return destination;
	 
	}
	
	

}
