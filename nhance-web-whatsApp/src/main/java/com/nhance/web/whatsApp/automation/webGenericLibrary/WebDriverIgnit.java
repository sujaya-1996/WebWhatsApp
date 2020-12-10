package com.nhance.web.whatsApp.automation.webGenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

/**
 * 
 */
/**
 * @author Manmohan
 *
 */
public class WebDriverIgnit {

	public static WebDriver driver;
	public WebDriverWait wait;
	protected static WebDriverCommonUtill webCmnUtil = new WebDriverCommonUtill();

	public WebDriver getDriver() {
		return driver;
	}

	// Method used to call Firefox Browser
	@Step("Open Firefox Browser..")
	public static void getFireFox_browser() throws AWTException {

		System.setProperty("webdriver.gecko.driver",
				(String) EnvironmentVariablesForWeb.getPropertyValue(ConstantValueForWeb.GECKO_DRIVER_LOCATION));
		FirefoxOptions foptions = new FirefoxOptions();
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		ffprofile.setPreference("browser.download.folderList", 2);
		ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		// webCmnUtil.setDownloadPreference();
		foptions.setProfile(ffprofile);
		driver = new FirefoxDriver(foptions);
		Testlistener.log("Firfox Browser opened ");
		driver.get((String) EnvironmentVariablesForWeb.getPropertyValue(ConstantValueForWeb.NHANCE_URL_FOR_WHATSAPP_WEB)); //
		// driver.get("https://www.google.co.in/");

		// driver.get(Constant_Value.NHANCE_URL_FOR_DEV_SERVER);
		String url = driver.getCurrentUrl();
		Testlistener.log("Actual URL opened is :: " + url);
		// webCmnUtil.maximize();
		Robot robot = new Robot();
		Testlistener.log("Web Page is About to Zoom Out");
		for (int i = 0; i < 3; i++) {
			Testlistener.log("Web Page Zoom Out for " + i + " time");
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public static void launch_FireFox_App() throws AWTException {


		System.setProperty("webdriver.gecko.driver",
				(String) EnvironmentVariablesForWeb.getPropertyValue(ConstantValueForWeb.GECKO_DRIVER_LOCATION));
		FirefoxOptions foptions = new FirefoxOptions();
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		ffprofile.setPreference("browser.download.folderList", 2);
		ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		// webCmnUtil.setDownloadPreference();
		foptions.setProfile(ffprofile);
		driver = new FirefoxDriver(foptions);
		Testlistener.log("Firfox Browser opened ");
		//driver.get((String) EnvironmentVariablesForWeb.getPropertyValue(ConstantValueForWeb.NHANCE_URL_FOR_SELF_ONBOARDING)); //
		// driver.get("https://www.google.co.in/");

		// driver.get(Constant_Value.NHANCE_URL_FOR_DEV_SERVER);
		String url = driver.getCurrentUrl();
		Testlistener.log("Actual URL opened is :: " + url);
		// webCmnUtil.maximize();
		Robot robot = new Robot();
		Testlistener.log("Web Page is About to Zoom Out");
		for (int i = 0; i < 3; i++) {
			Testlistener.log("Web Page Zoom Out for " + i + " time");
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	
	}
	
	// Method used to call Chrome Browser
	public static void getChrome_Browser() {
		System.setProperty("webdriver.chrome.driver", ConstantValueForWeb.CHROME_DRIVER_LOCATION);
		driver = new ChromeDriver();
		driver.get(ConstantValueForWeb.NHANCE_URL_FOR_WHATSAPP_WEB);
		webCmnUtil.maximize();
		

	}

	// Method used to call IE Browser
	public static void getIE_Browser() {
		System.setProperty("webdriver.ie.driver", ConstantValueForWeb.IE_DRIVER_LOCATION);
		driver = new InternetExplorerDriver();
		driver.get(ConstantValueForWeb.NHANCE_URL_FOR_WHATSAPP_WEB);
		webCmnUtil.maximize();
	}

}
