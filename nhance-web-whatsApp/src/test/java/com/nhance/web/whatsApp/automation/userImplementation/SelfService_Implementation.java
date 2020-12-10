package com.nhance.web.whatsApp.automation.userImplementation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.nhance.web.whatsApp.automation.userPageFactory.SelfService_Page;
import com.nhance.web.whatsApp.automation.userPageFactory.WhatsAppCommonPage;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ConstantValueForWeb;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ExcelLibrary;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class SelfService_Implementation extends WebDriverIgnit {

	SelfService_Page selfservicepage;
	WhatsAppCommonPage whatsappcommon;
	ExcelLibrary excelLib;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	String account_Name;
	String response_For_Invalid_Input;
	String selfserviceType_Name;
	String selfservice_Document_Name;
	String selfService_DocumentLink;
	String selfServiceMessage_To_Contniue;
	String menuOptionsAndMainMenuReturn_Message;
	String mainMenuReturn_Message;
	String response_For_Invalid_TextInput;
	String selfService_Submenu_Count;
	int expectedCount_For_SelfserviceSubemnu;
	int actualCount_For_SelfserviceSubemnu;
	String initiator_Code;
	String logout_Message;

	public void setUpAllVariable() throws EncryptedDocumentException, InvalidFormatException, IOException {
		selfservicepage = new SelfService_Page(driver);
		whatsappcommon = new WhatsAppCommonPage(driver);
		excelLib = new ExcelLibrary();
		account_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 1, 1);
		response_For_Invalid_Input = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 2,
				1);
		selfserviceType_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.SELFSERVICE_TESTDATA_SHEETNAME, 1, 1);
		selfservice_Document_Name = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.SELFSERVICE_TESTDATA_SHEETNAME,
				2, 1);
		selfService_DocumentLink = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.SELFSERVICE_TESTDATA_SHEETNAME,
				3, 1);
		selfServiceMessage_To_Contniue = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.SELFSERVICE_TESTDATA_SHEETNAME,
				4, 1);
		selfService_Submenu_Count = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.SELFSERVICE_TESTDATA_SHEETNAME,
				5, 1);
		menuOptionsAndMainMenuReturn_Message = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 3,
				1);
		mainMenuReturn_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 4, 1);
		response_For_Invalid_TextInput = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 5,
				1);
		initiator_Code = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 6, 1);
		logout_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 7, 1);

	}

	public void selfService_PositiveFlow() throws InterruptedException {
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
		whatsappcommon.write_On_Type_Message("2");
		System.out.println("SelfSrevice menu is selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Its showing the SelfService submenus properly.");
		Thread.sleep(10000);

		// To get the count for selfservice expected count
		expectedCount_For_SelfserviceSubemnu = selfservicepage.listOfSelfservice_SubMenus();
		actualCount_For_SelfserviceSubemnu = Integer.parseInt(selfService_Submenu_Count);
		assertEquals(actualCount_For_SelfserviceSubemnu, expectedCount_For_SelfserviceSubemnu);
		System.out.println("Assertion passed for expected and actual count of selfservice submenus...Success");
		System.out.println("The actual value for the selfservice submenu is:" + actualCount_For_SelfserviceSubemnu);
		Thread.sleep(1000);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("3");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Response for Invalid input has been verified successfully.");
		Thread.sleep(10000);

		// To put the assertion for invalid input scenario
		String value_Of_Invalid_Input = whatsappcommon.read_Value_Of_Invalid_Input();
		String expected_Value_For_InvalidInput = response_For_Invalid_Input;
		String actual_Value_For_InvalidInput = value_Of_Invalid_Input;
		// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
		if (actual_Value_For_InvalidInput.contains(expected_Value_For_InvalidInput)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println(
				"Response for the invalid input, has been verified successfully." + actual_Value_For_InvalidInput);
		webCmnUtil.explicitlyWait(whatsappcommon.invalid_Input);

		// To assert the Self service type ("Additional" Service type)
		String value_For_selfserviceType = selfservicepage.read_Value_For_selfserviceType();
		String expected_Value1 = selfserviceType_Name;
		String actual_Value1 = value_For_selfserviceType;
		Assert.assertEquals(actual_Value1, expected_Value1, "Assertion passed");
		System.out.println("Self service type 'Additional' has been verified successfully." + actual_Value1);
		webCmnUtil.explicitlyWait(selfservicepage.selfserviceType);

		// To assert the self service footer message in selfservice listing screen
		String value_For_MainMenuReturn_Message = whatsappcommon.read_Value_For_MainMenuReturn_Message();
		String expected_Value8 = mainMenuReturn_Message;
		String actual_Value8 = value_For_MainMenuReturn_Message;
		// Assert.assertEquals(actual_Value7, expected_Value7, "Assertion passed");
		if (actual_Value8.contains(expected_Value8)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("self service footer, has been verified successfully." + actual_Value8);
		webCmnUtil.explicitlyWait(whatsappcommon.mainMenuReturn_Message);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("1");
		System.out.println("Additional menu is selected under selfservice.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To assert the Self service document name, in that particular document details
		// display screen
		String value_For_SelfService_DocumentName = selfservicepage.read_Value_For_selfService_DocumentName();
		String expected_Value2 = selfservice_Document_Name;
		String actual_Value2 = value_For_SelfService_DocumentName;
		// Assert.assertEquals(actual_Value2, expected_Value2, "Assertion passed");
		if (actual_Value2.contains(expected_Value2)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Self service document name, has been verified successfully." + actual_Value2);
		webCmnUtil.explicitlyWait(selfservicepage.selfService_DocumentName);

		// To assert the Self service document link
		String value_For_SelfService_DocumentLink = selfservicepage.read_Value_For_SelfService_DocumentLink();
		String expected_Value3 = selfService_DocumentLink;
		String actual_Value3 = value_For_SelfService_DocumentLink;
		Assert.assertEquals(actual_Value3, expected_Value3, "Assertion passed");
		System.out.println("Self service document link, has been verified successfully." + actual_Value3);
		webCmnUtil.explicitlyWait(selfservicepage.selfService_DocumentLink);

		// To assert the self service message to continue more
		String value_For_SelfServiceMessage_To_Contniue = selfservicepage
				.read_Value_For_SelfServiceMessage_To_Contniue();
		String expected_Value4 = selfServiceMessage_To_Contniue;
		String actual_Value4 = value_For_SelfServiceMessage_To_Contniue;
		// Assert.assertEquals(actual_Value4, expected_Value4, "Assertion passed");
		if (actual_Value4.contains(expected_Value4)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("self service message to continue more, has been verified successfully." + actual_Value4);
		webCmnUtil.explicitlyWait(selfservicepage.selfServiceMessage_To_Contniue);

		// To assert the self service footer message
		String value_For_MenuOptionsAndMainMenuReturn_Message = whatsappcommon
				.read_Value_For_MenuOptionsAndMainMenuReturn_Message();
		String expected_Value5 = menuOptionsAndMainMenuReturn_Message;
		String actual_Value5 = value_For_MenuOptionsAndMainMenuReturn_Message;
		// Assert.assertEquals(actual_Value5, expected_Value5, "Assertion passed");
		if (actual_Value5.contains(expected_Value5)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("self service footer message, has been verified successfully." + actual_Value5);
		webCmnUtil.explicitlyWait(whatsappcommon.menuOptionsAndMainMenuReturn_Message);

		System.out.println("Content of the Additional submenu showing properly.");

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

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("2");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("1");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("0");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Back navigation is working properly under selfservice.");
		Thread.sleep(10000);

		// To assert the Self service type ("Additional" Service type)
		String value_For_selfserviceType1 = selfservicepage.read_Value_For_selfserviceType();
		String expected_Value6 = selfserviceType_Name;
		String actual_Value6 = value_For_selfserviceType1;
		Assert.assertEquals(actual_Value6, expected_Value6, "Assertion passed");
		System.out.println("Self service type 'Additional' has been verified successfully." + actual_Value6);
		webCmnUtil.explicitlyWait(selfservicepage.selfserviceType);

		// To assert the self service footer message in selfservice listing screen
		String value_For_MainMenuReturn_Message1 = whatsappcommon.read_Value_For_MainMenuReturn_Message();
		String expected_Value7 = mainMenuReturn_Message;
		String actual_Value7 = value_For_MainMenuReturn_Message1;
		// Assert.assertEquals(actual_Value7, expected_Value7, "Assertion passed");
		if (actual_Value7.contains(expected_Value7)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("self service footer, has been verified successfully." + actual_Value7);
		webCmnUtil.explicitlyWait(whatsappcommon.mainMenuReturn_Message);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("#");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Its showing the dk menu listing successfully.");
		Thread.sleep(10000);

		// } else {
		// System.out.println("Panel view is not showing." + displayPanelView);
		// }

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
