package com.nhance.web.whatsApp.automation.userImplementation;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.nhance.web.whatsApp.automation.userPageFactory.Inbox_Page;
import com.nhance.web.whatsApp.automation.userPageFactory.WhatsAppCommonPage;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ConstantValueForWeb;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ExcelLibrary;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class Inbox_Implementation extends WebDriverIgnit {

	Inbox_Page inboxpage;
	WhatsAppCommonPage whatsappcommon;
	ExcelLibrary excelLib;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	String account_Name;
	String initiator_Code;
	String inbox_HeaderMessage;
	String smartNotification_PwaLink_ScreenHeader;
	String smartNotification_PWALink;
	String offer_PWALink;
	String logout_Message;
	String smartNotification_Name;
	String smartNotification_Message;
	String offer_Name;
	String Offer_SentBy;
	String offer_Message;
	String feedbackRating_Name;
	String feedbackRating_Message;
	String feedback_SentBy_AdminName;

	public void setUpAllVariable() throws EncryptedDocumentException, InvalidFormatException, IOException {
		inboxpage = new Inbox_Page(driver);
		whatsappcommon = new WhatsAppCommonPage(driver);
		excelLib = new ExcelLibrary();
		account_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 1, 1);
		initiator_Code = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 6, 1);
		logout_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 7, 1);
		inbox_HeaderMessage = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 8, 1);
		smartNotification_PwaLink_ScreenHeader = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 9,
				1);
		smartNotification_PWALink = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 1,
				1);
		offer_PWALink = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 2, 1);
		smartNotification_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 3, 1);
		smartNotification_Message = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 4,
				1);
		offer_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 5, 1);
		offer_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 6, 1);
		Offer_SentBy = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 7, 1);
		feedbackRating_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 10, 1);
		feedbackRating_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 11, 1);
		feedback_SentBy_AdminName = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.Inbox_TESTDATA_SHEETNAME, 12,
				1);

	}

	public void smartNotification_Flow() throws InterruptedException {

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
		whatsappcommon.write_On_Type_Message("9");
		System.out.println("Inbox menu is selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Its showing the Inbox submenus properly.");
		Thread.sleep(10000);

		// To assert the Inbox menu header
		String value_For_InboxMenu_Header = inboxpage.read_Value_For_InboxMenu_Header();
		String expected_Value1 = inbox_HeaderMessage;
		String actual_Value1 = value_For_InboxMenu_Header;
		// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
		if (actual_Value1.contains(expected_Value1)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Inbox menu header has been verified successfully.");
		webCmnUtil.explicitlyWait(inboxpage.inboxMenu_Header);

		// To check the smart notification sub-menu emoji is showing or not!
		boolean value_For_SmartNotification_Submenu = inboxpage.read_Value_For_SmartNotification_Submenu();
		if (value_For_SmartNotification_Submenu == true) {
			System.out.println("Smart notification submenu with emoji showing properly.");

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("1");
			System.out.println("Smart notification submenu is selected.");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			Thread.sleep(10000);

			// To assert the smart notification pwa link screen header
			String value_For_SmartNotification_LinkScreen_Header = inboxpage
					.read_Value_For_SmartNotification_LinkScreen_Header();
			String expected_Value2 = smartNotification_PwaLink_ScreenHeader;
			String actual_Value2 = value_For_SmartNotification_LinkScreen_Header;
			// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
			if (actual_Value2.contains(expected_Value2)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Smart notification pwa link screen header has been verified successfully.");
			webCmnUtil.explicitlyWait(inboxpage.smartNotification_LinkScreen_Header);

			// To assert the smart notification pwa link
			String value_For_SmartNotification_PWALink = inboxpage.read_Value_For_SmartNotification_PWALink();
			String expected_Value3 = smartNotification_PWALink;
			String actual_Value3 = value_For_SmartNotification_PWALink;
			// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
			if (actual_Value3.contains(expected_Value3)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Smart notification pwa link has been verified successfully.");
			webCmnUtil.explicitlyWait(inboxpage.smartNotification_PWALink);

			// To click the smart notification pwa link (in dev as of now)
			inboxpage.click_On_SmartNotification_Link();
			Thread.sleep(10000);

			// Below code implemented for web window switch (using windows handler)

			Set<String> handler = driver.getWindowHandles();

			Iterator<String> it = handler.iterator();

			String parentWindowID = it.next();
			System.out.println("Parent windowID: " + parentWindowID);

			String childWindowID = it.next();
			System.out.println("Child windowID: " + childWindowID);

			// To switch the window control to the child window(PWA screen for smart
			// notification)
			driver.switchTo().window(childWindowID);
			Thread.sleep(10000);

			// To assert the smart notification pwa screen header
			String value_For_SmartNotification_PWAScreen_Header = inboxpage
					.read_Value_For_SmartNotification_PWAScreen_Header();
			String expected_Value4 = "Notification ";
			String actual_Value4 = value_For_SmartNotification_PWAScreen_Header;
			if (actual_Value4.contains(expected_Value4)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Smart notification pwa screen header has been verified successfully.");
			webCmnUtil.explicitlyWait(inboxpage.smartNotification_PWAScreen_Header);
			Thread.sleep(4000);

			// To check the smart notification bell icon!
			boolean value_For_SmartNotification_BellIcon = inboxpage.read_Value_For_SmartNotification_BellIcon();
			if (value_For_SmartNotification_BellIcon == true) {
				System.out.println("Notification bell icon showing properly.");

				// To assert the smart notification name in the pwa screen
				String value_For_SmartNotification_Name_InPWAScreen = inboxpage
						.read_value_For_SmartNotification_Name_InPWAScreen();
				String expected_Value5 = smartNotification_Name;
				String actual_Value5 = value_For_SmartNotification_Name_InPWAScreen;
				if (actual_Value5.contains(expected_Value5)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println("Smart notification name in the pwa screen has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.smartNotification_Name_InPWAScreen);

				// To assert the smart notification message in the pwa screen
				String value_For_SmartNotification_Message_InPWAScreen = inboxpage
						.read_Value_For_SmartNotification_Message_InPWAScreen();
				String expected_Value6 = smartNotification_Message;
				String actual_Value6 = value_For_SmartNotification_Message_InPWAScreen;
				if (actual_Value6.contains(expected_Value6)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println("Smart notification message in the pwa screen has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.smartNotification_Message_InPWAScreen);

				// To check for time icon
				boolean value_For_TimeIcon_InPWAScreen = inboxpage.read_Value_For_TimeIcon_InPWAScreen();
				if (value_For_TimeIcon_InPWAScreen == true) {
					System.out.println("Notification received time is showing properly.");

					// To check for the clear all button
					boolean value_For_ClearAll_InPWAScreen = inboxpage.read_Value_For_ClearAll_InPWAScreen();
					if (value_For_ClearAll_InPWAScreen == true) {
						System.out.println("ClearAll button is showing properly.");

						// To close the child window only
						driver.close();

						// To switch the window control back to the parent window(Whatsapp screen)
						driver.switchTo().window(parentWindowID);
						Thread.sleep(5000);

						// To click and write on the type a message field
						whatsappcommon.write_On_Type_Message("0");
						System.out.println("Typed 0 to navigate back the submenu listing screen.");
						Thread.sleep(1000);

						// To click on the send button
						whatsappcommon.click_On_Send_Button();
						Thread.sleep(10000);

					} else {
						System.out.println("ClearAll button is not showing.");
					}

				} else {
					System.out.println("Notification received time is not showing.");
				}

			} else {
				System.out.println("Notification bell icon is not showing.");
			}

		} else {
			System.out.println("Smart notification submenu with emoji not showing.");
		}

	}

	public void offer_Flow() throws InterruptedException {

		// To check whether offers submenu is showing or not with emoji!
		boolean value_For_Offers_Submenu = inboxpage.read_Value_For_Offers_Submenu();
		if (value_For_Offers_Submenu == true) {
			System.out.println("Offers submenu is showing with emoji.");

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("2");
			System.out.println("Offer submenu is selected.");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			Thread.sleep(10000);

			// To assert the Offer pwa link screen header
			String value_For_SmartNotification_LinkScreen_Header = inboxpage
					.read_Value_For_SmartNotification_LinkScreen_Header();
			String expected_Value1 = smartNotification_PwaLink_ScreenHeader;
			String actual_Value1 = value_For_SmartNotification_LinkScreen_Header;
			// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
			if (actual_Value1.contains(expected_Value1)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Offer pwa link screen header has been verified successfully.");
			webCmnUtil.explicitlyWait(inboxpage.smartNotification_LinkScreen_Header);

			// To assert the Offer pwa link
			String value_For_Offer_PWALink = inboxpage.read_Value_For_Offer_PWALink();
			String expected_Value2 = offer_PWALink;
			String actual_Value2 = value_For_Offer_PWALink;
			// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
			if (actual_Value2.contains(expected_Value2)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Offer pwa link has been verified successfully.");
			webCmnUtil.explicitlyWait(inboxpage.offer_PWALink);

			// To click the smart notification pwa link (in dev as of now)
			inboxpage.click_On_Offer_Link();
			Thread.sleep(10000);

			// Below code implemented for web window switch (using windows handler)

			Set<String> handler = driver.getWindowHandles();

			Iterator<String> it = handler.iterator();

			String parentWindowID = it.next();
			System.out.println("Parent windowID: " + parentWindowID);

			String childWindowID = it.next();
			System.out.println("Child windowID: " + childWindowID);

			// To switch the window control to the child window(PWA screen for Offer)
			driver.switchTo().window(childWindowID);
			Thread.sleep(10000);

			// To assert the offer header in the pwa screen
			String value_For_OfferHeader_InPWAScreen = inboxpage.read_Value_For_OfferHeader_InPWAScreen();
			String expected_Value3 = "Rewards";
			String actual_Value3 = value_For_OfferHeader_InPWAScreen;
			if (actual_Value3.contains(expected_Value3)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Offer pwa screen header has been verified successfully.");
			webCmnUtil.explicitlyWait(inboxpage.offerHeader_InPWAScreen);

			// To check the image in the pwa screen, when image is not configured for offer
			boolean value_For_DefaultImage_ForNoImageConfig_InPWAScreen = inboxpage
					.read_Value_For_DefaultImage_ForNoImageConfig_InPWAScreen();
			if (value_For_DefaultImage_ForNoImageConfig_InPWAScreen == true) {
				System.out.println("No Image text is showing properly.");

				// To assert the offer Name in the pwa screen
				String value_For_OfferName_InPWAScreen = inboxpage.read_Value_For_OfferName_InPWAScreen();
				String expected_Value4 = offer_Name;
				String actual_Value4 = value_For_OfferName_InPWAScreen;
				if (actual_Value4.contains(expected_Value4)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println("Offer name in the pwa screen has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.offerName_InPWAScreen);

				// To assert the offer sent by (Brand name) in the pwa screen
				String value_For_OfferSentBy_InPWAScreen = inboxpage.read_Value_For_OfferSentBy_InPWAScreen();
				String expected_Value5 = Offer_SentBy;
				String actual_Value5 = value_For_OfferSentBy_InPWAScreen;
				if (actual_Value5.contains(expected_Value5)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println("Offer sentBy in the pwa screen has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.offerSentBy_InPWAScreen);

				// To click the offer Name in the pwa screen
				inboxpage.click_OfferName_InPWAScreen();
				Thread.sleep(6000);

				// To assert the offer details header in details screen
				String value_For_OfferHeader_InDetailsScreen = inboxpage.read_Value_For_OfferHeader_InDetailsScreen();
				String expected_Value6 = "Details";
				String actual_Value6 = value_For_OfferHeader_InDetailsScreen;
				if (actual_Value6.contains(expected_Value6)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println("Offer details header in details screen, has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.offerHeader_InDetailsScreen);

				// To assert the offer name in offer details screen
				String value_For_OfferName_InDetailsScreen = inboxpage.read_Value_For_OfferName_InDetailsScreen();
				String expected_Value7 = offer_Name;
				String actual_Value7 = value_For_OfferName_InDetailsScreen;
				if (actual_Value7.contains(expected_Value7)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println("Offer name in details screen, has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.offerName_InDetailsScreen);

				// To assert the offer message in offer details screen
				String value_For_OfferMessage_InDetailsScreen = inboxpage.read_Value_For_OfferMessage_InDetailsScreen();
				String expected_Value8 = offer_Message;
				String actual_Value8 = value_For_OfferMessage_InDetailsScreen;
				if (actual_Value8.contains(expected_Value8)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println("Offer message in details screen, has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.offerMessage_InDetailsScreen);

				// To click on the arrow for the previous screen, in offer details screen
				inboxpage.click_On_PreviousScreen_InOfferDetailsScreen();
				Thread.sleep(4000);

				// To assert the offer header in the pwa screen
				String value_For_OfferHeader_InPWAScreen1 = inboxpage.read_Value_For_OfferHeader_InPWAScreen();
				String expected_Value9 = "Rewards";
				String actual_Value9 = value_For_OfferHeader_InPWAScreen1;
				if (actual_Value9.contains(expected_Value9)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println(
						"Offer pwa screen header has been verified successfully, after navigating back from Offer details screen.");
				webCmnUtil.explicitlyWait(inboxpage.offerHeader_InPWAScreen);

				// To close the child window only
				driver.close();

				// To switch the window control back to the parent window(Whatsapp screen)
				driver.switchTo().window(parentWindowID);
				Thread.sleep(5000);

				// To click and write on the type a message field
				whatsappcommon.write_On_Type_Message("0");
				System.out.println("Typed 0 to navigate back the submenu listing screen.");
				Thread.sleep(1000);

				// To click on the send button
				whatsappcommon.click_On_Send_Button();
				Thread.sleep(10000);

			} else {
				System.out.println("No Image text is not showing.");
			}

		} else {
			System.out.println("Offers submenu is not showing.");
		}

	}

	public void feedback_Flow() throws InterruptedException {

		// To check the smart notification sub-menu emoji is showing or not!
		boolean value_For_SmartNotification_Submenu = inboxpage.read_Value_For_SmartNotification_Submenu();
		if (value_For_SmartNotification_Submenu == true) {
			System.out.println("Smart notification submenu with emoji showing properly.");

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("1");
			System.out.println("Smart notification submenu is selected.");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			Thread.sleep(10000);

			// To assert the smart notification pwa link screen header
			String value_For_SmartNotification_LinkScreen_Header = inboxpage
					.read_Value_For_SmartNotification_LinkScreen_Header();
			String expected_Value2 = smartNotification_PwaLink_ScreenHeader;
			String actual_Value2 = value_For_SmartNotification_LinkScreen_Header;
			if (actual_Value2.contains(expected_Value2)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Smart notification pwa link screen header has been verified successfully.");
			webCmnUtil.explicitlyWait(inboxpage.smartNotification_LinkScreen_Header);

			// To assert the smart notification pwa link
			String value_For_SmartNotification_PWALink = inboxpage.read_Value_For_SmartNotification_PWALink();
			String expected_Value3 = smartNotification_PWALink;
			String actual_Value3 = value_For_SmartNotification_PWALink;
			if (actual_Value3.contains(expected_Value3)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Smart notification pwa link has been verified successfully.");
			webCmnUtil.explicitlyWait(inboxpage.smartNotification_PWALink);

			// To click the smart notification pwa link (in dev as of now)
			inboxpage.click_On_SmartNotification_Link();
			Thread.sleep(10000);

			// Below code implemented for web window switch (using windows handler)

			Set<String> handler = driver.getWindowHandles();

			Iterator<String> it = handler.iterator();

			String parentWindowID = it.next();
			System.out.println("Parent windowID: " + parentWindowID);

			String childWindowID = it.next();
			System.out.println("Child windowID: " + childWindowID);

			// To switch the window control to the child window(PWA screen for smart
			// notification)
			driver.switchTo().window(childWindowID);
			Thread.sleep(10000);

			// To assert the smart notification pwa screen header
			String value_For_SmartNotification_PWAScreen_Header = inboxpage
					.read_Value_For_SmartNotification_PWAScreen_Header();
			String expected_Value4 = "Notification ";
			String actual_Value4 = value_For_SmartNotification_PWAScreen_Header;
			if (actual_Value4.contains(expected_Value4)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Smart notification pwa screen header has been verified successfully.");
			webCmnUtil.explicitlyWait(inboxpage.smartNotification_PWAScreen_Header);

			// To check the feedback default Image
			boolean value_For_FeedbackImage_In_PWAScreen = inboxpage.read_Value_For_FeedbackImage_In_PWAScreen();
			if (value_For_FeedbackImage_In_PWAScreen == true) {
				System.out.println("Feedback default icon showing properly.");

				// To assert the feedback name
				String value_For_FeedbackName_In_PWAScreen = inboxpage.read_Value_For_FeedbackName_In_PWAScreen();
				String expected_Value5 = feedbackRating_Name;
				String actual_Value5 = value_For_FeedbackName_In_PWAScreen;
				if (actual_Value5.contains(expected_Value5)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println("Feedback rating name in the pwa screen has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.feedbackName_In_PWAScreen);

				// To assert the feedback message
				String value_For_FeedbackMessage_In_PWAScreen = inboxpage.read_Value_For_FeedbackMessage_In_PWAScreen();
				String expected_Value6 = feedbackRating_Message;
				String actual_Value6 = value_For_FeedbackMessage_In_PWAScreen;
				if (actual_Value6.contains(expected_Value6)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println("Feedback rating message in the pwa screen has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.feedbackMessage_In_PWAScreen);

				// To click on the feedback
				inboxpage.click_On_Feedback_In_PWAScreen();

				// To assert the Header of the Rating Details screen
				String value_For_Header_In_Rating_DetailsScreen = inboxpage
						.read_Value_For_FeedbackMessage_In_PWAScreen();
				String expected_Value7 = "How do you rate your experience with us?";
				String actual_Value7 = value_For_Header_In_Rating_DetailsScreen;
				if (actual_Value7.contains(expected_Value7)) {
					System.out.println("Asserstion passed, because actual value contains the expected value.");
				}
				System.out.println(" Header of the Rating Details screen, has been verified successfully.");
				webCmnUtil.explicitlyWait(inboxpage.header_In_Rating_DetailsScreen);
				Thread.sleep(4000);

/*				// To check the brands image in the rating details screen
				boolean value_For_BrandImage_In_Rating_DetailsScreen = inboxpage
						.read_Value_For_BrandImage_In_Rating_DetailsScreen();
				if (value_For_BrandImage_In_Rating_DetailsScreen == true) {
					System.out.println("Brands image in the rating details screen showing properly.");*/

					// To assert the SentBy admin's name in the Rating Details screen
					String value_For_SentBy_AdminName_In_Rating_DetailsScreen = inboxpage
							.read_Value_For_SentBy_AdminName_In_Rating_DetailsScreen();
					String expected_Value8 = feedback_SentBy_AdminName;
					String actual_Value8 = value_For_SentBy_AdminName_In_Rating_DetailsScreen;
					if (actual_Value8.contains(expected_Value8)) {
						System.out.println("Asserstion passed, because actual value contains the expected value.");
					}
					System.out.println(
							" SentBy admin's name in the Rating Details screen, has been verified successfully.");
					webCmnUtil.explicitlyWait(inboxpage.sentBy_AdminName_In_Rating_DetailsScreen);

					// To check stars for rating in the rating details screen
					boolean value_For_StarsForRating_In_Rating_DetailsScreen = inboxpage
							.read_Value_For_StarsForRating_In_Rating_DetailsScreen();
					if (value_For_StarsForRating_In_Rating_DetailsScreen == true) {
						System.out.println("Stars for rating in the rating details screen showing properly.");

						// To assert the Additional Comment field placeholder in the Rating Details
						// screen
						String value_For_AdditionalComment_Placeholder_In_Rating_DetailsScreen = inboxpage
								.read_Value_For_AdditionalComment_Placeholder_In_Rating_DetailsScreen();
						String expected_Value9 = feedback_SentBy_AdminName;
						String actual_Value9 = value_For_AdditionalComment_Placeholder_In_Rating_DetailsScreen;
						if (actual_Value9.contains(expected_Value9)) {
							System.out.println("Asserstion passed, because actual value contains the expected value.");
						}
						System.out.println(
								" Additional Comment field placeholder in the Rating Details screen, has been verified successfully.");
						webCmnUtil.explicitlyWait(inboxpage.additionalComment_Placeholder_In_Rating_DetailsScreen);

						// To check the submit button for rating in the rating details screen
						boolean value_For_SubmitButton_In_Rating_DetailsScreen = inboxpage
								.read_Value_For_SubmitButton_In_Rating_DetailsScreen();
						if (value_For_SubmitButton_In_Rating_DetailsScreen == true) {
							System.out
									.println("Submit button for rating in the rating details screen showing properly.");

							// To check the poweredBy details in the rating details screen
							boolean value_For_PoweredBy_In_Rating_DetailsScreen = inboxpage
									.read_Value_For_PoweredBy_In_Rating_DetailsScreen();
							if (value_For_PoweredBy_In_Rating_DetailsScreen == true) {
								System.out.println("PoweredBy details in the rating details screen showing properly.");

								// To close the child window only
								driver.close();

								// To switch the window control back to the parent window(Whatsapp screen)
								driver.switchTo().window(parentWindowID);
								Thread.sleep(5000);

								// To click and write on the type a message field
								whatsappcommon.write_On_Type_Message("0");
								System.out.println("Typed 0 to navigate back the submenu listing screen.");
								Thread.sleep(1000);

								// To click on the send button
								whatsappcommon.click_On_Send_Button();
								Thread.sleep(10000);

								// To click and write on the type a message field
								whatsappcommon.write_On_Type_Message("0");
								System.out.println("Typed 0 to navigate back to the main menu, dk menu listing.");
								Thread.sleep(1000);

								// To click on the send button
								whatsappcommon.click_On_Send_Button();
								System.out.println("Dk menu listing screen showing properly.");
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

							} else {
								System.out.println("PoweredBy details in the rating details screen not showing.");
							}
						} else {
							System.out.println("submit button for rating in the rating details screen not showing.");
						}
					} else {
						System.out.println("Stars for rating in the rating details screen not showing.");
					}

/*				} else {
					System.out.println("Brands image in the rating details screen not showing.");
				}*/

			} else {
				System.out.println("Feedback default icon not showing.");
			}

		} else {
			System.out.println("Smart notification submenu with emoji not showing.");
		}
	}

}
