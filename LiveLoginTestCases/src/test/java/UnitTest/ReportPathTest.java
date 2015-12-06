package UnitTest;

import org.testng.annotations.Test;

public class ReportPathTest 
{
	@Test
	public void getReportPath()
	{
		System.out.println(System.getProperty("file.separator"));
		String fs = System.getProperty("file.separator"); 
		String myPropsPath =  System.getProperty("user.dir");
		System.out.println(myPropsPath);
		String path = myPropsPath.replace("\\","/");
		System.out.println(path);
	}
	 

}
