package Listner;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class MyListnerClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
	
		//ExtentReport = util.ExtentReports.getExtentReport();
	
	}
	@Override
	public void onTestStart(ITestResult result) {
	
		String testName = result.getName();
	    test = report.createTest(testName);
		test.log(Status.INFO, testName+"test is start to execute");
		System.out.println(testName+ " " + "test is start to execute");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		test.log(Status.INFO,result.getThrowable());
		test.log(Status.PASS,testName+ "test is successfully execute");
		//String testName = result.getName();
		System.out.println(testName+ " " + "test is successfully execute");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		test.log(Status.INFO,result.getThrowable());
		test.log(Status.FAIL,testName+ "test is failed");
		System.out.println(testName+ " " +  "test is failed");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		String testName = result.getName();
		test.log(Status.INFO,result.getThrowable());
		test.log(Status.FAIL,testName+ "test is skipp");
		System.out.println(testName+ " " +  "test is skipp");
	}

	

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}

	
}
