package com.nhance.web.whatsApp.automation.webGenericLibrary;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

/**
 * 
 */
/**
 * @author Manmohan
 *
 */
public  class Testlistener extends WebDriverIgnit implements ITestListener {
	
	private static String getTestMethodName(ITestResult itestResult)
	{
		return itestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	//Image Attachment for Allure
	@Attachment(value="Page Screenshot" , type="image/png")
	public byte[] saveScreenShotPNG(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);	
	}
	
	// Text Attachment for Allure
	@Attachment(value="{0}",type="text/plain")
	public static String saveTextLog(String message)
	{
		return message;
		
	}
	
	// Capturing log to Allure Report
	@Step("{0}") 
	public static void log(String message) { 
		// Intensionally Empty
		}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult itestResult) {
		// TODO Auto-generated method stub
		System.out.println("  I am in onTestFailure Method  "+ getTestMethodName(itestResult) + " failed ");
		
		// Get Driver from Driver Ignit Class and assign to local WebDriver variable
		Object testClass= itestResult.getInstance();
		WebDriver driver= ((WebDriverIgnit) testClass).getDriver();
		
		// Allure ScreenshotRobot and SaveText
		if(driver instanceof WebDriver){
			System.out.println("Screenshot Captured for the Test Cases : "+getTestMethodName(itestResult));
			saveScreenShotPNG(driver);
		}
		
		// Save a Log on Allure
		saveTextLog(getTestMethodName(itestResult) + " failed and Screenshot taken ");
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
