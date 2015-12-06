package UnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import DataProvider.ExcelDataProvider;

public class ExcelDataProviderUnitTest 
{
	
	@Test
	public void testExcelDataProvider()
	{		
		ExcelDataProvider excel = new ExcelDataProvider();
		String username = excel.getCellData(1, 1, 2);
		System.out.println("User name is : "+username);
		Assert.assertEquals(username, "subbuPlayer");
		String password = excel.getCellData(1, 1, 3);
		System.out.println("Password is : "+password);
		Assert.assertEquals(password, "123456");	
		int lastUsedRowSheet1 = excel.getLastUsedRow(0);
		System.out.println("Last used Row in Sheet 1 is : "+lastUsedRowSheet1);
		Assert.assertEquals(lastUsedRowSheet1, 5);
		int lastUsedRowSheet2 = excel.getLastUsedRow(1);
		System.out.println("Last used Row in Sheet 2 is : "+lastUsedRowSheet2);
		Assert.assertEquals(lastUsedRowSheet2, 4);
		int getFirstRowContainsString = excel.getFirstRowContains(1, "AuthorizedPlayer", 0);
		System.out.println("Row containing AuthorizedPlayer is : "+getFirstRowContainsString);
		Assert.assertEquals(getFirstRowContainsString, 2);
		int getFirstRowContainsString1 = excel.getFirstRowContains(1, "NonauthorizedPlayer", 0);
		System.out.println("Row containing NonauthorizedPlayer is : "+getFirstRowContainsString1);
		Assert.assertEquals(getFirstRowContainsString1, 4);
		
	}	
	
}
