package com.nhance.web.whatsApp.automation.userTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nhance.web.whatsApp.automation.userImplementation.AnswerBot_Implementation;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class AnswerBot_FeatureTest extends WebDriverIgnit {
	AnswerBot_Implementation answerbotimpl = new AnswerBot_Implementation();
	
	@BeforeTest
	public void beforeClass() {

		getChrome_Browser();

	}
	
	@BeforeMethod
	public void Test_SetupVariables() throws EncryptedDocumentException, InvalidFormatException, IOException {
		answerbotimpl.setUpAllVariable();

	}


	@Test(priority = 1, description = "To do the AnswerBot_Flow")
	public void Test_AnswerBot_Flow() throws InterruptedException {
		answerbotimpl.answerBot_Flow();
	}
}
