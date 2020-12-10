package com.nhance.web.whatsApp.automation.userTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nhance.web.whatsApp.automation.userImplementation.SelfService_Implementation;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class SelfService_FeatureTest extends WebDriverIgnit {

	SelfService_Implementation selfserviceimpl = new SelfService_Implementation();
	
	@BeforeTest
	public void beforeClass() {

		getChrome_Browser();

	}
	
	@BeforeMethod
	public void Test_SetupVariables() throws EncryptedDocumentException, InvalidFormatException, IOException {
		selfserviceimpl.setUpAllVariable();

	}


	@Test(priority = 1, description = "To do the Selfservice positiveflow.")
	public void Test_SelfService_PositiveFlow() throws InterruptedException {
		selfserviceimpl.selfService_PositiveFlow();
	}

}
