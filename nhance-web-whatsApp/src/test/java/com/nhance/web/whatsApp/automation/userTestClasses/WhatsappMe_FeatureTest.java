package com.nhance.web.whatsApp.automation.userTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nhance.web.whatsApp.automation.userImplementation.WhatsappMe_Implementation;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class WhatsappMe_FeatureTest extends WebDriverIgnit {
	WhatsappMe_Implementation whatsappmeimpl = new WhatsappMe_Implementation();
	
	@BeforeTest
	public void beforeClass() {

		getChrome_Browser();

	}
	
	@BeforeMethod
	public void Test_SetupVariables() throws EncryptedDocumentException, InvalidFormatException, IOException {
		whatsappmeimpl.setUpAllVariable();

	}


	@Test(priority = 1, description = "To do the WhatsappMe_Flow")
	public void Test_WhatsappMe_Flow() throws InterruptedException {
		whatsappmeimpl.whatsappMe_Flow();
	}
}
