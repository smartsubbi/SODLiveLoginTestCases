package UnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.ConfigDataProvider;

public class ConfigDataProviderUnitTest 
{
	
	@Test
	public void testGetChromePath()
	{
//		String filePath = System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver_win32/chromedriver.exe";
//		System.out.println(filePath);
//		System.out.println(System.getProperty("user.dir"));
		ConfigDataProvider config = new ConfigDataProvider();
		String chromePath = config.getChromePath();
		
		System.out.println("Unit Test Chromepath : "+chromePath);
		Assert.assertEquals(chromePath, "./SeleniumDrivers/chromedriver_win32/chromedriver.exe");				
	}
	@Test
	public void testGetIePath()
	{
		ConfigDataProvider config = new ConfigDataProvider();
		String iePath = config.getIEPath();
		System.out.println("Unit Test IePath : "+iePath);
		Assert.assertEquals(iePath, "./SeleniumDrivers/iedriver_win64/IEDriverServer.exe");				
	}
}
