package com.nhance.web.whatsApp.automation.userTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nhance.web.whatsApp.automation.userImplementation.helpdesk_Implementation;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class Helpdesk_FeatureTest extends WebDriverIgnit {
	helpdesk_Implementation helpdeskimpl = new helpdesk_Implementation();
	
	@BeforeTest
	public void beforeClass() {

		getChrome_Browser();

	}
	
	@BeforeMethod
	public void Test_SetupVariables() throws EncryptedDocumentException, InvalidFormatException, IOException {
		helpdeskimpl.setUpAllVariable();

	}


	@Test(priority = 1, description = "To do the helpdesk positiveflow.")
	public void Test_Helpdesk_PositiveFlow() throws InterruptedException {
		helpdeskimpl.helpdesk_PositiveFlow();
	}
}
