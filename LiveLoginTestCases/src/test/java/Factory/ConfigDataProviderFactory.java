package Factory;

import DataProvider.ConfigDataProvider;

public class ConfigDataProviderFactory 
{
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}
}
