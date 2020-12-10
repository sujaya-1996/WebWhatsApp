package com.nhance.web.whatsApp.automation.userTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nhance.web.whatsApp.automation.userImplementation.About_Implementation;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class About_FeatureTest extends WebDriverIgnit {
	About_Implementation aboutimpl = new About_Implementation();
	
	@BeforeTest
	public void beforeClass() {

		getChrome_Browser();

	}
	
	@BeforeMethod
	public void Test_SetupVariables() throws EncryptedDocumentException, InvalidFormatException, IOException {
		aboutimpl.setUpAllVariable();

	}


	@Test(priority = 1, description = "To do the Test for About menu")
	public void About_ModuleTest_Flow() throws InterruptedException {
		aboutimpl.about_ModuleTest();
	}
}
