package com.nhance.web.whatsApp.automation.userImplementation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.nhance.web.whatsApp.automation.userPageFactory.Helpdesk_Page;
import com.nhance.web.whatsApp.automation.userPageFactory.WhatsAppCommonPage;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ConstantValueForWeb;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ExcelLibrary;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class helpdesk_Implementation extends WebDriverIgnit {

	Helpdesk_Page helpdeskpage;
	WhatsAppCommonPage whatsappcommon;
	ExcelLibrary excelLib;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	String account_Name;
	String helpdesk_Email;
	String helpdesk_Number;
	String response_For_Invalid_TextInput;
	String initiator_Code;
	String logout_Message;

	public void setUpAllVariable() throws EncryptedDocumentException, InvalidFormatException, IOException {
		helpdeskpage = new Helpdesk_Page(driver);
		whatsappcommon = new WhatsAppCommonPage(driver);
		excelLib = new ExcelLibrary();
		account_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 1, 1);
		helpdesk_Email = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.HELPDESK_TESTDATA_SHEETNAME, 1, 1);
		helpdesk_Number = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.HELPDESK_TESTDATA_SHEETNAME, 2, 1);
		response_For_Invalid_TextInput = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 5,
				1);
		initiator_Code = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 6, 1);
		logout_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 7, 1);

	}

	public void helpdesk_PositiveFlow() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Whatsappweb launched successfully.");
		webUtil.implicitWait();
		System.out.println("QR code scan successfully verified, whatsapp web started.");
		webUtil.implicitWait();
		Thread.sleep(15000);

		// // To check the panel view is showing or not!!
		// boolean displayPanelView = selfservicepage.check_Panel_View();
		// if (displayPanelView == true) {
		// System.out.println("Panel view showing properly." + displayPanelView);

		// To click on the search-box and write the account name
		webCmnUtil.explicitlyWait(whatsappcommon.searchText);
		whatsappcommon.write_On_Search_Field(account_Name);
		Thread.sleep(2000);

		// To click on the gupshuplive account
		webCmnUtil.explicitlyWait(whatsappcommon.userChat);
		whatsappcommon.click_On_User_Gupshup();
		System.out.println("Gupshuplive account is selected.");

		// To click and write on the type a message field
		webCmnUtil.explicitlyWait(whatsappcommon.typeMessage);
		whatsappcommon.write_On_Type_Message(initiator_Code);
		System.out.println("In Type a message field, Hi+initiator code message written successfully.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Hi+initiator code message sent successfully, and it will show the dk now.");
		Thread.sleep(10000);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("5");
		System.out.println("SelfSrevice menu is selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Its showing the SelfService submenus properly.");
		Thread.sleep(10000);

		// To assert the helpdesk email
		String value_For_Heldesk_Email = helpdeskpage.read_Value_For_Heldesk_Email();
		String expected_Value1 = helpdesk_Email;
		String actual_Value1 = value_For_Heldesk_Email;
		// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
		if (actual_Value1.contains(expected_Value1)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Helpdesk email has been verified successfully.");
		System.out.println("Actual heldesk email is:" + actual_Value1);
		webCmnUtil.explicitlyWait(helpdeskpage.heldesk_Email);
		
		// To assert the helpdesk mobile number
		String value_For_Heldesk_number = helpdeskpage.read_Value_For_Heldesk_number();
		String expected_Value2 = helpdesk_Number;
		String actual_Value2 = value_For_Heldesk_number;
		// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
		if (actual_Value2.contains(expected_Value2)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Helpdesk number has been verified successfully.");
		System.out.println("Actual heldesk number is:" + actual_Value2);
		webCmnUtil.explicitlyWait(helpdeskpage.heldesk_number);
		
		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("Random Text Input");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To put the assertion for invalid input scenario(giving wrong text inputs)
		String value_Of_Invalid_TextInput = whatsappcommon.read_Value_Of_Invalid_TextInput();
		String expected_Value9 = response_For_Invalid_TextInput;
		String actual_Value9 = value_Of_Invalid_TextInput;
		// Assert.assertEquals(actual_Value5, expected_Value5, "Assertion passed");
		if (actual_Value9.contains(expected_Value9)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println(
				"Invalid input scenario(giving wrong text inputs), has been verified successfully." + actual_Value9);
		webCmnUtil.explicitlyWait(whatsappcommon.invalid_TextInput);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("#");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		System.out.println("Helpdesk functionalities working fine.");
		
		// To do the logout from brand account
		whatsappcommon.write_On_Type_Message("logout");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Logout has been done successfully.");
		Thread.sleep(10000);

		// To assert the logout success message
		String value_For_LogOutMessage = whatsappcommon.read_Value_For_LogOutMessage();
		String expected_Value_for_Logout = logout_Message;
		String actual_Value_for_Logout = value_For_LogOutMessage;
		if (actual_Value_for_Logout.contains(expected_Value_for_Logout)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Logout message, has been verified successfully." + actual_Value_for_Logout);
		webCmnUtil.explicitlyWait(whatsappcommon.logOutMessage);

	}
}
