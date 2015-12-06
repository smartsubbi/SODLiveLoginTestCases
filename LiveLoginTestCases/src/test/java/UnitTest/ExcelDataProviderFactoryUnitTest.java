package UnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.ExcelDataProvider;
import Factory.ExcelDataProviderFactory;


public class ExcelDataProviderFactoryUnitTest 
{
	@Test
	public static void getExcelObject()
	{
		ExcelDataProvider excel = ExcelDataProviderFactory.getExcel();
		Assert.assertTrue(excel!=null);
	}
}
