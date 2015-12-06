package TestCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager 
{
	static DateFormat dateFormat = new SimpleDateFormat("E.MMMM.yyyy_HH.mm.ss[a]");
	static Date date = new Date();
	static String userDirectory =  System.getProperty("user.dir");
	static String path = userDirectory.replace("\\","/");
	static String reportPath = path+"/ExtentReports/SchoolOfDragonsLive_" +dateFormat.format(date) + ".html";

	
	
	
	public static ExtentReports Instance() 
	{		
		ExtentReports report;		
		System.out.println(reportPath);
		report = new ExtentReports(reportPath, false);
		report.config().documentTitle("Automation Report").reportName("Regression");
		return report;
	}
	
	
	
}