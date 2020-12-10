	package com.nhance.web.whatsApp.automation.userTestClasses;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.nhance.web.whatsApp.automation.userImplementation.DocBox_Linear_Implementation;
import com.nhance.web.whatsApp.automation.webGenericLibrary.Testlistener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


	@Listeners(Testlistener.class)
	@Epic("Smoke Test")
	public class DocBox_Linear_Feature  extends BaseTest {
		
		DocBox_Linear_Implementation docBoxLinearImplementation;
		
			Map<String, String> map;
			
			@BeforeClass(groups= {"Regression", "Smoke"})
			public void setUp() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException {
				super.chrome_Launch();
			}
			
			@BeforeMethod(groups= {"Regression", "Smoke"})
			public void before_whatsApp_Test_Execution_Method() throws Exception
			{
				docBoxLinearImplementation = new DocBox_Linear_Implementation();
				docBoxLinearImplementation.customerSpecificSetUp();
				 
				 // TODO: script entry to db
			}
			

			@Test(priority = 1, description = "Launch WhatsApp to start Bot", groups= {"Regression", "Smoke"})
			@Severity(SeverityLevel.BLOCKER)
			@Description("Test Description : Launch WhatsApp to start Bot......")
			public void launch_WhatsApp_to_start_Bot() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
				Testlistener.log("Test Started for Launch WhatsApp to start Bot......");
				// Calling add Method from DK Module Implementation Classes	
				docBoxLinearImplementation.addTest();
			}

			
			
			@AfterClass(alwaysRun=true,groups= {"Regression", "Smoke"})
			public void cleanUp() throws InterruptedException {
				driver.close();
				}

}
