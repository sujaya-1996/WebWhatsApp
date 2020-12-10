package com.nhance.web.whatsApp.automation.userTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nhance.web.whatsApp.automation.userImplementation.Inbox_Implementation;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class Inbox_FeatureTest extends WebDriverIgnit {

	
	Inbox_Implementation inboximpl = new Inbox_Implementation();
	
	@BeforeTest
	public void beforeClass() {

		getChrome_Browser();

	}
	
	@BeforeMethod
	public void Test_SetupVariables() throws EncryptedDocumentException, InvalidFormatException, IOException {
		inboximpl.setUpAllVariable();

	}


	@Test(priority = 1, description = "To do the SmartNotification_Flow")
	public void Test_SmartNotification_Flow() throws InterruptedException {
		inboximpl.smartNotification_Flow();
	}
	
	@Test(priority = 2, description = "To do the Offer_Flow")
	public void Test_Offer_Flow() throws InterruptedException {
		inboximpl.offer_Flow();
	}
	
	@Test(priority = 3, description = "To do the Feedback rating flow")
	public void Test_Feedback_Flow() throws InterruptedException {
		inboximpl.feedback_Flow();
	}
}
