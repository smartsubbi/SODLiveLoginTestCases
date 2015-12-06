package Factory;

import DataProvider.ExcelDataProvider;

public class ExcelDataProviderFactory 
{
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
	}
}
