package util;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {

	static ExtentReports report;
	static ExtentSparkReporter sparReport;
	static ExtentTest test;
	public static ExtentReports getExtentReport()
	{
		report = new ExtentReports();
		//File extentFile = new File(System.getProperty("D:\\GitDemo\\com.assignment\\test-output\\extentReport\\extentRepor.html"));
		sparReport = new ExtentSparkReporter("ExtentReportDemo.html");
		report.attachReporter(sparReport);
		
		sparReport.config().setTheme(Theme.DARK);
		sparReport.config().setReportName("Extent Automation Result");
		sparReport.config().setDocumentTitle("Automation result");
		sparReport.config().setTimeStampFormat("dd/MM/yyyy  hh:mm:ss");
		
//		report.attachReporter(sparReport);
		report.setSystemInfo("Browser Name", "chrome");
		report.setSystemInfo("Machine", "Dell");
		report.setSystemInfo("User Name", "Akshay");
		return report; 
		
	}
}
