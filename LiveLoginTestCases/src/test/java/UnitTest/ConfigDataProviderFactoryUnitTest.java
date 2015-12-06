package UnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.ConfigDataProvider;
import Factory.ConfigDataProviderFactory;

public class ConfigDataProviderFactoryUnitTest 
{
	@Test
	public void getConfigObject()
	{
		ConfigDataProvider config = ConfigDataProviderFactory.getConfig();
		Assert.assertTrue(config!=null);
	}	
}
