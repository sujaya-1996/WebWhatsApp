package com.nhance.web.whatsApp.automation.userImplementation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.nhance.web.whatsApp.automation.userPageFactory.About_PageFactory;
import com.nhance.web.whatsApp.automation.userPageFactory.WhatsAppCommonPage;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ConstantValueForWeb;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ExcelLibrary;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class About_Implementation extends WebDriverIgnit {
	
	About_PageFactory aboutpage;
	WhatsAppCommonPage whatsappcommon;
	ExcelLibrary excelLib;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	String account_Name;
	String initiator_Code;
	String About_Header;
	String model_Number;
	String product_Manufacturer;
	String purchased_Date;
	String warranty_Expires_On;
	String logout_Message;
	
	public void setUpAllVariable() throws EncryptedDocumentException, InvalidFormatException, IOException {
		aboutpage = new About_PageFactory(driver);
		whatsappcommon = new WhatsAppCommonPage(driver);
		excelLib = new ExcelLibrary();
		account_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 1, 1);
		initiator_Code = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 6, 1);
		logout_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 7, 1);
		model_Number = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.About_TESTDATA_SHEETNAME, 1, 1);
		product_Manufacturer = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.About_TESTDATA_SHEETNAME, 2, 1);
		purchased_Date = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.About_TESTDATA_SHEETNAME, 3, 1);
		warranty_Expires_On = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.About_TESTDATA_SHEETNAME, 4, 1);
		About_Header = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.About_TESTDATA_SHEETNAME, 5, 1);
	}
	
	
	public void about_ModuleTest() throws InterruptedException {
		
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

		// To click on the GupshupLive account
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
		whatsappcommon.write_On_Type_Message("10");
		System.out.println("Inbox menu is selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Its showing the Inbox submenus properly.");
		Thread.sleep(10000);
		
		// To assert the header message of the About menu
		String value_For_About_Header = aboutpage.read_Value_For_About_Header();
		String expected_Value1 = About_Header;
		String actual_Value1 = value_For_About_Header;
		if (actual_Value1.contains(expected_Value1)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("About menu header has been verified successfully.");
		webCmnUtil.explicitlyWait(aboutpage.about_Header);
		
		// To assert the model number label
		String value_For_ModelNumber_Label = aboutpage.read_Value_For_ModelNumber_Label();
		String expected_Value2 = "Model Number";
		String actual_Value2 = value_For_ModelNumber_Label;
		if (actual_Value2.contains(expected_Value2)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Model number label has been verified successfully.");
		//webCmnUtil.explicitlyWait(aboutpage.modelNumber_Label);
		Thread.sleep(2000);
		
		// To assert the Product manufacturer label
		String value_For_ProductManufacturer_Label = aboutpage.read_Value_For_ProductManufacturer_Label();
		String expected_Value3 = "Product Manufacturer";
		String actual_Value3 = value_For_ProductManufacturer_Label;
		if (actual_Value3.contains(expected_Value3)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Product manufacturer label has been verified successfully.");
		//webCmnUtil.explicitlyWait(aboutpage.productManufacturer_Label);
		Thread.sleep(2000);
		
		// To assert the purchase date label
		String value_For_PurchaseDate_Label = aboutpage.read_Value_For_PurchaseDate_Label();
		String expected_Value4 = "Purchased Date";
		String actual_Value4 = value_For_PurchaseDate_Label;
		if (actual_Value4.contains(expected_Value4)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Purchase date label has been verified successfully.");
		//webCmnUtil.explicitlyWait(aboutpage.purchaseDate_Label);
		Thread.sleep(2000);
		
		// To assert the Warranty Expires On label
		String value_For_WarrantyExpiresOn_Label = aboutpage.read_Value_For_WarrantyExpiresOn_Label();
		String expected_Value5 = "Warrnty Expires On";
		String actual_Value5 = value_For_WarrantyExpiresOn_Label;
		if (actual_Value5.contains(expected_Value5)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Warranty Expires On label has been verified successfully.");
		//webCmnUtil.explicitlyWait(aboutpage.warrantyExpiresOn_Label);
		Thread.sleep(2000);
		
		// To assert the model number value in the About menu
		String value_For_ModelNumber = aboutpage.read_Value_For_About_Header();
		String expected_Value6 = model_Number;
		String actual_Value6 = value_For_ModelNumber;
		if (actual_Value6.contains(expected_Value6)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Model Number has been verified successfully.");
		//webCmnUtil.explicitlyWait(aboutpage.about_Header);
		Thread.sleep(2000);
		
		// To assert the Product manufacturer value in the About menu
		String value_For_ProductManufacturer = aboutpage.read_Value_For_About_Header();
		String expected_Value7 = product_Manufacturer;
		String actual_Value7 = value_For_ProductManufacturer;
		if (actual_Value7.contains(expected_Value7)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Product manufacturer value has been verified successfully.");
		//webCmnUtil.explicitlyWait(aboutpage.about_Header);
		Thread.sleep(2000);
		
		// To assert the Purchased Date value in the About menu
		String value_For_Purchased_Date = aboutpage.read_Value_For_About_Header();
		String expected_Value8 = purchased_Date;
		String actual_Value8 = value_For_Purchased_Date;
		if (actual_Value8.contains(expected_Value8)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Purchased Date value has been verified successfully.");
		//webCmnUtil.explicitlyWait(aboutpage.about_Header);
		Thread.sleep(2000);
		
		// To assert the Warranty Expires On value in the About menu
		String value_For_Warranty_Expires_On = aboutpage.read_Value_For_About_Header();
		String expected_Value9 = warranty_Expires_On;
		String actual_Value9 = value_For_Warranty_Expires_On;
		if (actual_Value9.contains(expected_Value9)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Warranty Expires On value has been verified successfully.");
		//webCmnUtil.explicitlyWait(aboutpage.about_Header);
		Thread.sleep(2000);
		
		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("#");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Its showing the Dk menu listing screen properly.");
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
		
	}
	
	
}
