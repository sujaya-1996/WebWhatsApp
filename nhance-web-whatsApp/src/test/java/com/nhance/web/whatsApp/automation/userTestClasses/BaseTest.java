package com.nhance.web.whatsApp.automation.userTestClasses;

import java.awt.AWTException;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nhance.web.whatsApp.automation.webBusinessLibrary.BusinessFunctionWebSpecific;
import com.nhance.web.whatsApp.automation.webGenericLibrary.Testlistener;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;


public class BaseTest extends WebDriverIgnit{
	
    protected WebDriverCommonUtill webCmnUtil = new WebDriverCommonUtill();
	protected BusinessFunctionWebSpecific bFuction = new BusinessFunctionWebSpecific();
    WebDriverWait wait;
	String userName_For_CustomerAdmin;
	String password_For_CustomerAdmin;
	String userName_For_Superuser;
	String password_For_Superuser;

	    public void openBrowser() throws AWTException
	    {
	    	getFireFox_browser();
	    }
		
	    
	    public void chrome_Launch() {
	    	getChrome_Browser();
	    }
		
		public void cleanUp() throws InterruptedException
		{
			try{
			bFuction.logOut_Application();
			}catch (Exception e) {
				Testlistener.log("Got Exception while logout" + e.getMessage());
			}
			//driver.quit();
		}
		
		public void logOut()
		{
			try{
				bFuction.logOut_Application();
				}catch (Exception e) {
					Testlistener.log("Got Exception while logout" + e.getMessage());
				}
		}
		
		public void quitBrowser()
		{
			driver.quit();
		}
	    

}
