package com.nhance.web.whatsApp.automation.userImplementation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.nhance.web.whatsApp.automation.userPageFactory.WhatsAppCommonPage;
import com.nhance.web.whatsApp.automation.userPageFactory.WhatsappMe_Page;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ConstantValueForWeb;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ExcelLibrary;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class WhatsappMe_Implementation extends WebDriverIgnit{
	
	WhatsappMe_Page whatsappmepage;
	WhatsAppCommonPage whatsappcommon;
	ExcelLibrary excelLib;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	String account_Name;
	String initiator_Code;
	String logout_Message;
	String whatsappMe_Header_Message;
	String whatsappMe_link;
	String whatsappMe_Footer_Message;
	String menuReturn_TemplateMessage;
	
	
	public void setUpAllVariable() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		whatsappmepage= new WhatsappMe_Page(driver);
		whatsappcommon = new WhatsAppCommonPage(driver);
		excelLib = new ExcelLibrary();
		account_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 1, 1);
		initiator_Code = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 6, 1);
		logout_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 7, 1);
		whatsappMe_Header_Message =  ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.WHATSAPPME_TESTDATA_SHEETNAME, 2, 1);
		whatsappMe_link = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.WHATSAPPME_TESTDATA_SHEETNAME, 1, 1);
		whatsappMe_Footer_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.WHATSAPPME_TESTDATA_SHEETNAME, 3, 1);
		menuReturn_TemplateMessage = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.WHATSAPPME_TESTDATA_SHEETNAME, 4, 1);
	}
	
	public void whatsappMe_Flow() throws InterruptedException
	{
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

		// To click on the Gupshup live account
		webCmnUtil.explicitlyWait(whatsappcommon.userChat);
		whatsappcommon.click_On_User_Gupshup();
		System.out.println("Gupshup Live account is selected.");

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
		whatsappcommon.write_On_Type_Message("8");
		System.out.println("WhatsappMe menu is selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Its showing the details properly.");
		Thread.sleep(10000);

		// To assert the header message in the whatsappMe menu
		String value_For_WhatsappMe_Header = whatsappmepage.read_Value_For_WhatsappMe_Header();
		String expected_Value1 = whatsappMe_Header_Message;
		String actual_Value1 = value_For_WhatsappMe_Header;
		if (actual_Value1.contains(expected_Value1)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Header message in the whatsappMe menu has been verified successfully.");
		webCmnUtil.explicitlyWait(whatsappmepage.whatsappMe_Header);
		
		// To assert the whatsappme link in the whatsappMe menu
		String value_For_WhatsappMe_Link = whatsappmepage.read_Value_For_WhatsappMe_Link();
		String expected_Value2 = whatsappMe_link;
		String actual_Value2 = value_For_WhatsappMe_Link;
		if (actual_Value2.contains(expected_Value2)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Whatsappme link in the whatsappMe menu has been verified successfully.");
		webCmnUtil.explicitlyWait(whatsappmepage.whatsappMe_Link);
		
		// To assert the whatsappMe footer message in the whatsappMe menu
		String value_For_WhatsappMe_Footer = whatsappmepage.read_Value_For_WhatsappMe_Header();
		String expected_Value3 = whatsappMe_Footer_Message;
		String actual_Value3 = value_For_WhatsappMe_Footer;
		if (actual_Value3.contains(expected_Value3)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Footer message in the whatsappMe menu has been verified successfully.");
		webCmnUtil.explicitlyWait(whatsappmepage.whatsappMe_Header);
		
		// To click on the whatsappme link
		whatsappmepage.click_On_WhatsappMe_Link();
		Thread.sleep(4000);
		
		// To check the new chat window after clicking on the whatsappme link
		boolean value_For_NewChat_Window = whatsappmepage.read_Value_For_NewChat_Window();
		if(value_For_NewChat_Window == true) {
			System.out.println("New chat window is showing to the user.");
			
			// To click on the search-box and write the account name
			webCmnUtil.explicitlyWait(whatsappcommon.searchText);
			whatsappcommon.write_On_Search_Field(account_Name);
			Thread.sleep(4000);

			// To click on the GupshupLive account
			webCmnUtil.explicitlyWait(whatsappcommon.userChat);
			whatsappcommon.click_On_User_Gupshup();
			System.out.println("Gupshup Live account is selected.");
			
			
			// To assert the whatsappMe menuRetuen message in the whatsappMe menu
			String value_For_WhatsappMe_menuReturnMessage = whatsappmepage.read_Value_For_WhatsappMe_Header();
			String expected_Value4 = menuReturn_TemplateMessage;
			String actual_Value4 = value_For_WhatsappMe_menuReturnMessage;
			if (actual_Value4.contains(expected_Value4)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("WhatsappMe menuRetuen message in the whatsappMe menu has been verified successfully.");
			webCmnUtil.explicitlyWait(whatsappmepage.whatsappMe_Header);
			
			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("#");
			System.out.println("WhatsappMe menu is selected.");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("Its showing the dk menu listing properly.");
			Thread.sleep(10000);
			
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
				System.out.println(
						"Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println(
					"Logout message, has been verified successfully." + actual_Value_for_Logout);
			webCmnUtil.explicitlyWait(whatsappcommon.logOutMessage);
			
		}else {
			System.out.println("New chat window is not showing to the user.");
		}
		
	}
}
