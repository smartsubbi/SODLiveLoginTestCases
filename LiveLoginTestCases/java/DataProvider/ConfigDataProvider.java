package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider 
{
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
		} 
		catch (Exception e) 
		{
			
		}
	}
	
	public String getChromePath()
	{
		String chrome_driver_path = pro.getProperty("ChromePath");
		System.out.println("Tester "+chrome_driver_path);
		
		return chrome_driver_path;
		
	}
	
	public String getIEPath()
	{
		String id_driver_path = pro.getProperty("IEPath");
		
		return id_driver_path;
	}

}
