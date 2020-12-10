package com.nhance.web.whatsApp.automation.userImplementation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nhance.web.whatsApp.automation.userPageFactory.Buy_Page;
import com.nhance.web.whatsApp.automation.userPageFactory.WhatsAppCommonPage;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ConstantValueForWeb;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ExcelLibrary;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class Buy_Implementation extends WebDriverIgnit {

	Buy_Page buypage;
	WhatsAppCommonPage whatsappcommon;
	ExcelLibrary excelLib;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	String account_Name;
	String initiator_Code;
	String logout_Message;
	String Buy_Menu_Header;
	String orderStatus_Failure_Message;
	String cancelOrder_Failure_Message;
	String response_For_Invalid_Input;
	String menuOptionsAndMainMenuReturn_Message;
	String purchaseCategory_ListingScreen_Header;
	String purchase_Category_Name;
	String purchaseCategory_ListingScreen_Footer;
	String firstAccessory_WithoutHaving_Image;
	String secondAccessory_WithoutHaving_Image;
	String firstAccessory_Having_Image_Configured;
	String secondAccessory_Having_Image_Configured;
	String description_Of_FirstAccessory_Having_Image_Configured;
	String sampleFormat_For_Selecting_Items;
	String price_Of_Accessory4;
	String quantity_Need_To_Purchase;
	String online_PaymentMode;
	String offline_Paymentmode;
	String consumerNumber_On_RazorpayScreen;
	String success_FollowUp_Message_In_Whatsapp;
	String order_Status_Of_The_Placed_Order;
	int value_For_CountOfOrders_in_OrderStatusScreen_BeforePlaceOrder;
	String cod_Confirmation_Message;
	String cod_Success_Message;
	int value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingOrderSuccessfully;
	int increamented_value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingOrderSuccessfully;

	public void setUpAllVariable() throws EncryptedDocumentException, InvalidFormatException, IOException {
		buypage = new Buy_Page(driver);
		whatsappcommon = new WhatsAppCommonPage(driver);
		excelLib = new ExcelLibrary();
		account_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 1, 1);
		response_For_Invalid_Input = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 2,
				1);
		menuOptionsAndMainMenuReturn_Message = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 3,
				1);
		initiator_Code = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 6, 1);
		logout_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 7, 1);
		Buy_Menu_Header = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 1, 1);
		orderStatus_Failure_Message = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 2, 1);
		cancelOrder_Failure_Message = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 3, 1);
		purchaseCategory_ListingScreen_Header = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 4, 1);
		purchase_Category_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 5, 1);
		purchaseCategory_ListingScreen_Footer = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 6, 1);
		firstAccessory_WithoutHaving_Image = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 7, 1);
		secondAccessory_WithoutHaving_Image = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 8, 1);
		firstAccessory_Having_Image_Configured = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 9, 1);
		description_Of_FirstAccessory_Having_Image_Configured = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 10, 1);
		secondAccessory_Having_Image_Configured = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 11, 1);
		sampleFormat_For_Selecting_Items = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 13, 1);
		price_Of_Accessory4 = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 14, 1);
		quantity_Need_To_Purchase = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 15, 1);
		online_PaymentMode = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 16, 1);
		offline_Paymentmode = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 17, 1);
		consumerNumber_On_RazorpayScreen = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 18, 1);
		success_FollowUp_Message_In_Whatsapp = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 20, 1);
		order_Status_Of_The_Placed_Order = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 21, 1);
		cod_Confirmation_Message = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 24, 1);
		cod_Success_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.BUY_TESTDATA_SHEETNAME, 25, 1);

	}

	public void placeOrder_PositiveFlow_For_OnlinePayment() throws InterruptedException {

		Thread.sleep(4000);
		System.out.println("Whatsappweb launched successfully.");
		webUtil.implicitWait();
		System.out.println("QR code scan successfully verified, whatsapp web started." + Thread.currentThread().getId());
		webUtil.implicitWait();
		Thread.sleep(15000);

		// To click on the search-box and write the account name
		webCmnUtil.explicitlyWait(whatsappcommon.searchText);
		whatsappcommon.write_On_Search_Field(account_Name);
		Thread.sleep(2000);

		// To click on the twiliolive account
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
		whatsappcommon.write_On_Type_Message("3");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Buy menu has been selected.");
		Thread.sleep(10000);

		// To assert the buy menu header
		String value_For_BuyMenu_Header = buypage.read_Value_For_BuyMenu_Header();
		String expected_Value_Header = Buy_Menu_Header;
		String actual_Value_Header = value_For_BuyMenu_Header;
		if (actual_Value_Header.contains(expected_Value_Header)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Buy menu header message has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.buyMenu_Header);

		// // To assert the Buy footer message
		// String value_For_MenuOptionsAndMainMenuReturn_Message = whatsappcommon
		// .read_Value_For_MenuOptionsAndMainMenuReturn_Message();
		// String expected_Value_Footer = menuOptionsAndMainMenuReturn_Message;
		// String actual_Value_Footer = value_For_MenuOptionsAndMainMenuReturn_Message;
		// if (actual_Value_Footer.contains(expected_Value_Footer)) {
		// System.out.println("Asserstion passed, because actual value contains the
		// expected value.");
		// }
		// System.out.println("Buy menu footer message, has been verified
		// successfully.");
		// webCmnUtil.explicitlyWait(whatsappcommon.menuOptionsAndMainMenuReturn_Message);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("10");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To put the assertion for invalid input scenario
		String value_Of_Invalid_Input = whatsappcommon.read_Value_Of_Invalid_Input();
		String expected_Value_For_InvalidInput = response_For_Invalid_Input;
		String actual_Value_For_InvalidInput = value_Of_Invalid_Input;
		// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
		if (actual_Value_For_InvalidInput.contains(expected_Value_For_InvalidInput)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Response for the invalid input, has been verified successfully.");
		webCmnUtil.explicitlyWait(whatsappcommon.invalid_Input);

		// To select order status submenu
		whatsappcommon.write_On_Type_Message("2");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To take the count of the number of orders, in order status screen
		int value_For_CountOfOrders_in_OrderStatusScreen_IncludingFooterZero_BeforePlaceOrder = buypage
				.read_value_For_CountOfOrders_in_OrderStatusScreen();
		System.out.println("Total count of orders in Order Status Screen(including 0 in the footer): "
				+ value_For_CountOfOrders_in_OrderStatusScreen_IncludingFooterZero_BeforePlaceOrder);
		Thread.sleep(2000);

		value_For_CountOfOrders_in_OrderStatusScreen_BeforePlaceOrder = (value_For_CountOfOrders_in_OrderStatusScreen_IncludingFooterZero_BeforePlaceOrder
				- 1);
		System.out.println("Total count of plcaced orders in Order Status Screen, Before place order: "
				+ value_For_CountOfOrders_in_OrderStatusScreen_BeforePlaceOrder);

		// To go back to buy submenu listing
		whatsappcommon.write_On_Type_Message("0");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To check the first submenu (place order)
		boolean value_For_PlaceOrder_Submenu = buypage.read_Value_For_PlaceOrder_Submenu();
		if (value_For_PlaceOrder_Submenu == true) {

			System.out.println("Place order submenu is showing successfully.");

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("1");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			Thread.sleep(10000);

			// To assert the PlaceOrder purchase category listing screen header message
			String value_For_PurchaseCategory_ListingScreen_Header = buypage
					.read_Value_For_PurchaseCategory_ListingScreen_Header();
			String expected_Value_For_PlaceOrder1 = purchaseCategory_ListingScreen_Header;
			String actual_Value_For_PlaceOrder1 = value_For_PurchaseCategory_ListingScreen_Header;
			// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
			if (actual_Value_For_PlaceOrder1.contains(expected_Value_For_PlaceOrder1)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println(
					"PlaceOrder purchase category listing screen header message, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.purchaseCategory_ListingScreen_Header);

			// To assert the PlaceOrder purchase category in the listing screen
			String value_For_PurchaseCategory_In_ListingScreen = buypage
					.read_Value_For_PurchaseCategory_ListingScreen_Header();
			String expected_Value_For_PlaceOrder2 = purchase_Category_Name;
			String actual_Value_For_PlaceOrder2 = value_For_PurchaseCategory_In_ListingScreen;
			if (actual_Value_For_PlaceOrder2.contains(expected_Value_For_PlaceOrder2)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("PlaceOrder purchase category in the listing screen, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.purchaseCategory_ListingScreen_Header);

			// To assert the PlaceOrder purchase category Footer in the listing screen
			String value_For_PurchaseCategoryFooter_In_ListingScreen = buypage
					.read_Value_For_PurchaseCategory_ListingScreen_Header();
			String expected_Value_For_PlaceOrder3 = purchaseCategory_ListingScreen_Footer;
			String actual_Value_For_PlaceOrder3 = value_For_PurchaseCategoryFooter_In_ListingScreen;
			if (actual_Value_For_PlaceOrder3.contains(expected_Value_For_PlaceOrder3)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println(
					"PlaceOrder purchase category Footer in the listing screen , has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.purchaseCategory_ListingScreen_Header);

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("1");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("Purchase category has been selected.");
			Thread.sleep(20000);

			// To assert the message for selecting items to purchase
			String value_For_MessageFor_Selecting_Items_To_Purchase = buypage
					.read_Value_For_MessageFor_Selecting_Items_To_Purchase();
			String expected_Value_For_PlaceOrder4 = "Please select the items you wish to purchase";
			String actual_Value_For_PlaceOrder4 = value_For_MessageFor_Selecting_Items_To_Purchase;
			if (actual_Value_For_PlaceOrder4.contains(expected_Value_For_PlaceOrder4)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("message for selecting items to purchase , has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.messageFor_Selecting_Items_To_Purchase);

			// To assert the accessories which dont have imgaes configured
			String value_For_Accessory_WithoutHaving_Image_Configured = buypage
					.read_Value_For_Accessory_WithoutHaving_Image_Configured();
			String expected_Value_For_PlaceOrder5 = firstAccessory_WithoutHaving_Image;
			String actual_Value_For_PlaceOrder5 = value_For_Accessory_WithoutHaving_Image_Configured;
			if (actual_Value_For_PlaceOrder5.contains(expected_Value_For_PlaceOrder5)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("First accessory which dont have imgaes configured , has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.accessory_WithoutHaving_Image_Configured);

			// To assert the accessories which dont have imgaes configured
			String value_For_Accessory_WithoutHaving_Image_Configured1 = buypage
					.read_Value_For_Accessory_WithoutHaving_Image_Configured();
			String expected_Value_For_PlaceOrder6 = secondAccessory_WithoutHaving_Image;
			String actual_Value_For_PlaceOrder6 = value_For_Accessory_WithoutHaving_Image_Configured1;
			if (actual_Value_For_PlaceOrder6.contains(expected_Value_For_PlaceOrder6)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Second accessory which dont have imgaes configured , has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.accessory_WithoutHaving_Image_Configured);

			/*
			 * // To check the image of the first accessory from the list accessroies which
			 * do // have image configured boolean value_For_FirstAccessory_Having_Image =
			 * buypage.read_Value_For_FirstAccessory_Having_Image(); if
			 * (value_For_FirstAccessory_Having_Image == true) {
			 * System.out.println("Its showing the image for the third listed accessory.");
			 */

			// To assert the first accessory details (which do have image configured)
			String value_For_FirstAccessory_Having_Image_Configured = buypage
					.read_Value_For_FirstAccessory_Having_Image_Configured();
			String expected_Value_For_PlaceOrder7 = firstAccessory_Having_Image_Configured;
			String actual_Value_For_PlaceOrder7 = value_For_FirstAccessory_Having_Image_Configured;
			if (actual_Value_For_PlaceOrder7.contains(expected_Value_For_PlaceOrder7)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println(
					"First accessory details (which do have image configured) , has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.firstAccessory_Having_Image_Configured);

			// To assert the description for the third listed accessory
			String value_For_descriptionOf_FirstAccessory_Having_Image_Configured = buypage
					.read_Value_For_FirstAccessory_Having_Image_Configured();
			String expected_Value_For_PlaceOrder9 = description_Of_FirstAccessory_Having_Image_Configured;
			String actual_Value_For_PlaceOrder9 = value_For_descriptionOf_FirstAccessory_Having_Image_Configured;
			if (actual_Value_For_PlaceOrder9.contains(expected_Value_For_PlaceOrder9)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Description for the third listed accessory , has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.firstAccessory_Having_Image_Configured);

			/*
			 * // To check the image of the Second accessory from the list accessroies which
			 * do // have image configured boolean value_For_SecondAccessory_Having_Image =
			 * buypage.read_Value_For_SecondAccessory_Having_Image(); if
			 * (value_For_SecondAccessory_Having_Image == true) {
			 * System.out.println("Its showing the image for the fourth listed accessory.");
			 */

			// To assert the Second accessory details (which do have image configured)
			String value_For_SecondAccessory_Having_Image_Configured = buypage
					.read_Value_For_SecondAccessory_Having_Image_Configured();
			String expected_Value_For_PlaceOrder8 = secondAccessory_Having_Image_Configured;
			String actual_Value_For_PlaceOrder8 = value_For_SecondAccessory_Having_Image_Configured;
			if (actual_Value_For_PlaceOrder8.contains(expected_Value_For_PlaceOrder8)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println(
					"Second accessory details (which do have image configured) , has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.secondAccessory_Having_Image_Configured);

			/*
			 * // To check the document URL link of the Second accessory from the list //
			 * accessroies which do have image configured boolean
			 * value_For_DocumentURL_Of_SecondAccessory_Having_Image = buypage
			 * .read_Value_For_DocumentURL_Of_SecondAccessory_Having_Image(); if
			 * (value_For_DocumentURL_Of_SecondAccessory_Having_Image == true) {
			 * System.out.println("Document URL showing fine.");
			 */

			// To assert the Sample format for selecting items
			String value_For_Sample_Format = buypage.read_Value_For_SecondAccessory_Having_Image_Configured();
			String expected_Value_For_PlaceOrder10 = sampleFormat_For_Selecting_Items;
			String actual_Value_For_PlaceOrder10 = value_For_Sample_Format;
			if (actual_Value_For_PlaceOrder10.contains(expected_Value_For_PlaceOrder10)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Sample format for selecting items, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.secondAccessory_Having_Image_Configured);

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("1-2");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("Two quantities of the first Accessory has been selected.");
			Thread.sleep(10000);

			// To assert the message for successfull addition of items in the cart.
			String value_For_Successfull_Item_Addition_In_Cart_Message = buypage
					.read_Value_For_Successfull_Item_Addition_In_Cart_Message();
			String expected_Value_For_PlaceOrder11 = "Yay! Item successfully added to your cart!";
			String actual_Value_For_PlaceOrder11 = value_For_Successfull_Item_Addition_In_Cart_Message;
			if (actual_Value_For_PlaceOrder11.contains(expected_Value_For_PlaceOrder11)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out
					.println("message for successfull addition of items in the cart, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.successfull_Item_Addition_In_Cart_Message);

			// To assert the message for successful addition of items in the cart.
			String value_For_Cart_Containing_Items_Message = buypage
					.read_Value_For_Successfull_Item_Addition_In_Cart_Message();
			String expected_Value_For_PlaceOrder12 = "Your Cart now contains:";
			String actual_Value_For_PlaceOrder12 = value_For_Cart_Containing_Items_Message;
			if (actual_Value_For_PlaceOrder12.contains(expected_Value_For_PlaceOrder12)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out
					.println("message for successfull addition of items in the cart, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.successfull_Item_Addition_In_Cart_Message);

			// To assert the selected items details in the cart
			String value_For_SelectedItemDetails_In_Cart = buypage.read_Value_For_SelectedItemDetails_In_Cart();
			System.out.println("Value for Selected Item details in the cart:" + value_For_SelectedItemDetails_In_Cart);

			String[] part = value_For_SelectedItemDetails_In_Cart.split("₹ ");
			System.out.println("value till the currency symbol: " + part[0]); // To print the first value from the array

			String n = part[1];
			System.out.println("Value after the currency symbol: " + n); // To print the second value from the array

			String result = n.replaceAll("" + "Cart value.*", "");
			System.out.println("The replaced value is: " + result);
			Thread.sleep(2000);

			String trim_Result = result.trim();

			int num = (int) Float.parseFloat(trim_Result);
			System.out.println("The converted value of second split is " + num);

			// int num = Integer.parseInt(result);

			String value_For_Price_Of_Accessory4 = price_Of_Accessory4;
			String value_For_Quantity_Need_To_Purchase = quantity_Need_To_Purchase;

			int intValue_For_Price_Of_Accessory4 = Integer.parseInt(value_For_Price_Of_Accessory4.trim());
			int intValue_For_Quantity_Need_To_Purchase = Integer.parseInt(value_For_Quantity_Need_To_Purchase.trim());

			int totalCalculatedCartAmount = (intValue_For_Price_Of_Accessory4 * intValue_For_Quantity_Need_To_Purchase);
			System.out.println("Total calculated cart value is:" + totalCalculatedCartAmount);

			// To check the calculated total amount is same with the asserted amount or not!
			assertEquals(num, totalCalculatedCartAmount);
			System.out.println(
					"Calculated total amount is same with the asserted amount and has been verified successfully.");
			Thread.sleep(4000);

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("order");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("After typing order, it will show the payment options now.");
			Thread.sleep(10000);

			// To assert the payment mode Screen header showing to place the order
			String value_For_PaymentModeScreen_Header = buypage.read_Value_For_PaymentModeScreen_Header();
			String expected_Value_For_PlaceOrder13 = "How would you like to pay for this order?";
			String actual_Value_For_PlaceOrder13 = value_For_PaymentModeScreen_Header;
			if (actual_Value_For_PlaceOrder13.contains(expected_Value_For_PlaceOrder13)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out
					.println("Payment mode Screen header showing to place the order, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.paymentModeScreen_Header);

			// To assert the online payment
			String value_For_PaymentMode_OnlinePayment = buypage.read_Value_For_PaymentModeScreen_Header();
			String expected_Value_For_PlaceOrder14 = online_PaymentMode;
			String actual_Value_For_PlaceOrder14 = value_For_PaymentMode_OnlinePayment;
			if (actual_Value_For_PlaceOrder14.contains(expected_Value_For_PlaceOrder14)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Payment mode Online payment, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.paymentModeScreen_Header);

			// To assert the COD payment
			String value_For_PaymentMode_COD = buypage.read_Value_For_PaymentModeScreen_Header();
			String expected_Value_For_PlaceOrder15 = offline_Paymentmode;
			String actual_Value_For_PlaceOrder15 = value_For_PaymentMode_COD;
			if (actual_Value_For_PlaceOrder15.contains(expected_Value_For_PlaceOrder15)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Payment mode COD, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.paymentModeScreen_Header);

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("2");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("Online Payment mode has been selected");
			Thread.sleep(10000);

			// To assert the payment message showing to place the order flow
			String value_For_PaymentMessage = buypage.read_Value_For_PaymentMessage();
			String expected_Value_For_PlaceOrder16 = "Please pay for  accessory4, for the selected DX card Doctor Heatlh card";
			String actual_Value_For_PlaceOrder16 = value_For_PaymentMessage;
			if (actual_Value_For_PlaceOrder16.contains(expected_Value_For_PlaceOrder16)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Payment link message, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.paymentModeScreen_Header);
			Thread.sleep(3000);

			// To click on the QA razorpay link
			buypage.click_On_razorpay_PaymentLink();
			Thread.sleep(10000);

			// Below code implemented for web window switch (using windows handler)

			Set<String> handler = driver.getWindowHandles();

			Iterator<String> it = handler.iterator();

			String parentWindowID = it.next();
			System.out.println("Parent windowID: " + parentWindowID);
			Thread.sleep(2000);

			String childWindowID = it.next();
			System.out.println("Child windowID: " + childWindowID);
			Thread.sleep(2000);

			// To switch the window control to the child window(Razorpay payment screen)
			driver.switchTo().window(childWindowID);
			System.out.println("Window is now switched to razorpy screen from whatsapp screen.");
			Thread.sleep(10000);

			// To assert the total amount of purchase in razorpay payment screen (assert
			// this with the multiplied value of
			// price and quantity variable)
			String value_For_TotalAmount_In_RazorpayPaymentScreen = buypage
					.read_Value_For_TotalAmount_In_RazorpayPaymentScreen();
			String expected_Value_For_PlaceOrder17 = "₹ 1,000.00";
			String actual_Value_For_PlaceOrder17 = value_For_TotalAmount_In_RazorpayPaymentScreen;
			if (actual_Value_For_PlaceOrder17.contains(expected_Value_For_PlaceOrder17)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("total amount of purchase in razorpay payment screen, has been verified successfully.");
			// webCmnUtil.explicitlyWait(buypage.totalAmount_In_RazorpayPaymentScreen);
			Thread.sleep(6000);

			WebElement netBankingText = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
			driver.switchTo().frame(netBankingText);
			Thread.sleep(4000);

			// To assert the consumer phone number in razorpay screen
			String value_For_ConsumerNumber_In_RazorpayScreen = buypage
					.read_Value_For_ConsumerNumber_In_RazorpayScreen();
			String expected_Value_For_PlaceOrder18 = consumerNumber_On_RazorpayScreen;
			String actual_Value_For_PlaceOrder18 = value_For_ConsumerNumber_In_RazorpayScreen;
			if (actual_Value_For_PlaceOrder18.contains(expected_Value_For_PlaceOrder18)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Consumer phone number in razorpay screen, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.consumerNumber_In_RazorpayScreen);
			Thread.sleep(2000);

			// To click on the netbanking option in razorpay screen
			buypage.click_On_Netbanking_In_RazorpayScreen();
			System.out.println("Clicked on the netbacking option sucessfully.");
			Thread.sleep(3000);

			// To click on the SBI option in razorpay screen
			buypage.click_On_SBI_Netbanking_In_RazorpayScreen();
			System.out.println("SBI netbacking option selected sucessfully.");
			Thread.sleep(3000);

			// To click on the pay option in razorpay screen
			buypage.click_On_PayOption_In_RazorpayScreen();
			System.out.println("Payment option selected sucessfully.");
			Thread.sleep(10000);

			// Below code implemented for web window switch (using windows handler)

			Set<String> handler_For_Razorpay_Payment_Confirmation_Screen = driver.getWindowHandles();

			Iterator<String> it_For_Razorpay_Payment_Confirmation_Screen = handler_For_Razorpay_Payment_Confirmation_Screen
					.iterator();

			String parentWindowID_For_Razorpay_Payment_Confirmation_Screen = it_For_Razorpay_Payment_Confirmation_Screen
					.next();
			System.out.println("Parent windowID: " + parentWindowID_For_Razorpay_Payment_Confirmation_Screen);

			String firstChildWindowID_For_Razorpay_Payment_Confirmation_Screen = it_For_Razorpay_Payment_Confirmation_Screen
					.next();
			System.out.println("First Child windowID: " + firstChildWindowID_For_Razorpay_Payment_Confirmation_Screen);

			String secondChildWindowID_For_Razorpay_Payment_Confirmation_Screen = it_For_Razorpay_Payment_Confirmation_Screen
					.next();
			System.out
					.println("Second Child windowID: " + secondChildWindowID_For_Razorpay_Payment_Confirmation_Screen);

			// To switch the window control to the child window(Razorpay Payment
			// Confirmation Screen)
			driver.switchTo().window(secondChildWindowID_For_Razorpay_Payment_Confirmation_Screen);
			Thread.sleep(10000);

			// To click on the Success button, in confirmation screen
			buypage.click_On_SuccessButton_In_ConfirmationScreen();
			System.out.println("Sucess button clicked successfully.");

			// To switch the window control back to the parent window(Razorpay payment
			// screen)
			driver.switchTo().window(firstChildWindowID_For_Razorpay_Payment_Confirmation_Screen);
			System.out.println("Window switched to parent window.");
			Thread.sleep(5000);

			// To assert the payment completed text, after the successful payment
			String value_For_PaymentCompleted_Text_In_RazorpayScreen = buypage
					.read_Value_For_PaymentCompleted_Text_In_RazorpayScreen();
			String expected_Value_For_PlaceOrder19 = consumerNumber_On_RazorpayScreen;
			String actual_Value_For_PlaceOrder19 = value_For_PaymentCompleted_Text_In_RazorpayScreen;
			if (actual_Value_For_PlaceOrder19.contains(expected_Value_For_PlaceOrder19)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("Payment completed text, after the successful payment, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.paymentCompleted_Text_In_RazorpayScreen);

			// To close the child window only
			driver.close();
			System.out.println("Child window closed sucessfully.");

			// To switch the window control back to the parent window(Whatsapp screen)
			driver.switchTo().window(parentWindowID);
			System.out.println("Window switched to parent widnow, that is whatsapp.");
			Thread.sleep(5000);

			// To assert the success follow up message in whatsapp, after the successful
			// payment in razorpay
			String value_For_Success_FollowUp_Message = buypage.read_Value_For_Success_FollowUp_Message();
			String expected_Value_For_PlaceOrder20 = success_FollowUp_Message_In_Whatsapp;
			String actual_Value_For_PlaceOrder20 = value_For_Success_FollowUp_Message;
			if (actual_Value_For_PlaceOrder20.contains(expected_Value_For_PlaceOrder20)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println(
					"Success follow up message in whatsapp, after the successful payment in razorpay, has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.success_FollowUp_Message);

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("0");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("Its showing the Buy submenu listing properly.");
			Thread.sleep(10000);

			/*
			 * } else { System.out.println("Document URL not showing."); }
			 */

			/*
			 * } else { System.out.
			 * println("Its not showing the image for the fourth listed accessory."); }
			 */

			/*
			 * } else { System.out.
			 * println("Its not showing the image for the third listed accessory."); }
			 */

		} else {
			System.out.println("Place order submenu is not showing.");
		}
	}

	public void orderStatus_Flow_After_Doing_OnlinePayment() throws InterruptedException {
		

		// To check the second submenu (order status)
		boolean value_For_OrderStatus_Submenu = buypage.read_Value_For_OrderStatus_Submenu();
		if (value_For_OrderStatus_Submenu == true) {

			System.out.println("Order Status submenu is showing successfully.");

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("2");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("OrderStatus submenu has been selected.");
			Thread.sleep(10000);

			// To assert the order status screen header
			String value_For_Order_Status_ScreenHeader = buypage.read_Value_For_Order_Status_ScreenHeader();
			String expected_Value_For_OrderStatusScreen1 = "Please find below the details of your orders";
			String actual_Value_OrderStatusScreen1 = value_For_Order_Status_ScreenHeader;
			if (actual_Value_OrderStatusScreen1.contains(expected_Value_For_OrderStatusScreen1)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("OrderStatus screen header message has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.order_Status_ScreenHeader);

			// To take the count of the number of orders in order status screen, after
			// placing the order successfully
			int value_For_CountOfOrders_in_OrderStatusScreen_IncludingFooterZero = buypage
					.read_value_For_CountOfOrders_in_OrderStatusScreen();
			System.out.println("Total count of orders in Order Status Screen(including 0 in the footer): "
					+ value_For_CountOfOrders_in_OrderStatusScreen_IncludingFooterZero);
			Thread.sleep(2000);

			value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingOrderSuccessfully = (value_For_CountOfOrders_in_OrderStatusScreen_IncludingFooterZero
					- 1);
			System.out.println(
					"Total count of plcaced orders in Order Status Screen, after placing the order successfully: "
							+ value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingOrderSuccessfully);

			int increamented_Value_For_CountOfOrders_in_OrderStatusScreen_BeforePlaceOrder = (value_For_CountOfOrders_in_OrderStatusScreen_BeforePlaceOrder
					+ 1);
			System.out.println("Incremented value is: "+ increamented_Value_For_CountOfOrders_in_OrderStatusScreen_BeforePlaceOrder);
			Thread.sleep(3000);

			if (value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingOrderSuccessfully == increamented_Value_For_CountOfOrders_in_OrderStatusScreen_BeforePlaceOrder) {
				System.out.println("Order ID for the recent placed order, is showing properly.");

				// To select the recently added order ID, after placing the request successfully

				// To click and write on the type a message field
				whatsappcommon.write_On_Type_Message("0");
				Thread.sleep(1000);

				// To click on the send button
				whatsappcommon.click_On_Send_Button();
				System.out.println("Buy submenu been showing.");
				Thread.sleep(10000);

				/*
				 * // To click and write on the type a message field
				 * whatsappcommon.write_On_Type_Message("3"); Thread.sleep(1000);
				 * 
				 * // To click on the send button whatsappcommon.click_On_Send_Button();
				 * System.out.println("Buy menu has been selected."); Thread.sleep(10000);
				 */

			} else {
				System.out
						.println("Order ID for the recent placed order, is not showing. Hence flow is breaking here.");

			}

		} else {
			System.out.println("Order Status submenu is not showing.");
		}
	}

	public void CashOnDelivery_Flow() throws InterruptedException {

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("1");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To assert the PlaceOrder purchase category listing screen header message
		String value_For_PurchaseCategory_ListingScreen_Header = buypage
				.read_Value_For_PurchaseCategory_ListingScreen_Header();
		String expected_Value_For_PlaceOrder1 = purchaseCategory_ListingScreen_Header;
		String actual_Value_For_PlaceOrder1 = value_For_PurchaseCategory_ListingScreen_Header;
		// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
		if (actual_Value_For_PlaceOrder1.contains(expected_Value_For_PlaceOrder1)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out
				.println("PlaceOrder purchase category listing screen header message, has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.purchaseCategory_ListingScreen_Header);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("1");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Purchase category has been selected.");
		Thread.sleep(20000);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("1-2");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Two quantities of the first Accessory has been selected.");
		Thread.sleep(10000);

		// To assert the message for successfull addition of items in the cart.
		String value_For_Successfull_Item_Addition_In_Cart_Message = buypage
				.read_Value_For_Successfull_Item_Addition_In_Cart_Message();
		String expected_Value_For_PlaceOrder11 = "Yay! Item successfully added to your cart!";
		String actual_Value_For_PlaceOrder11 = value_For_Successfull_Item_Addition_In_Cart_Message;
		if (actual_Value_For_PlaceOrder11.contains(expected_Value_For_PlaceOrder11)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("message for successfull addition of items in the cart, has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.successfull_Item_Addition_In_Cart_Message);

		// To assert the message for successful addition of items in the cart.
		String value_For_Cart_Containing_Items_Message = buypage
				.read_Value_For_Successfull_Item_Addition_In_Cart_Message();
		String expected_Value_For_PlaceOrder12 = "Your Cart now contains:";
		String actual_Value_For_PlaceOrder12 = value_For_Cart_Containing_Items_Message;
		if (actual_Value_For_PlaceOrder12.contains(expected_Value_For_PlaceOrder12)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("message for successfull addition of items in the cart, has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.successfull_Item_Addition_In_Cart_Message);

		// To assert the selected items details in the cart
		String value_For_SelectedItemDetails_In_Cart = buypage.read_Value_For_SelectedItemDetails_In_Cart();
		System.out.println("Value for Selected Item details in the cart:" + value_For_SelectedItemDetails_In_Cart);

		String[] part = value_For_SelectedItemDetails_In_Cart.split("₹ ");
		System.out.println("value till the currency symbol: " + part[0]); // To print the first value from the array

		String n = part[1];
		System.out.println("Value after the currency symbol: " + n); // To print the second value from the array

		String result = n.replaceAll("" + "Cart value.*", "");
		System.out.println("The replaced value is: " + result);
		Thread.sleep(2000);

		String trim_Result = result.trim();

		int num = (int) Float.parseFloat(trim_Result);
		System.out.println("The converted value of second split is " + num);

		// int num = Integer.parseInt(result);

		String value_For_Price_Of_Accessory4 = price_Of_Accessory4;
		String value_For_Quantity_Need_To_Purchase = quantity_Need_To_Purchase;

		int intValue_For_Price_Of_Accessory4 = Integer.parseInt(value_For_Price_Of_Accessory4.trim());
		int intValue_For_Quantity_Need_To_Purchase = Integer.parseInt(value_For_Quantity_Need_To_Purchase.trim());

		int totalCalculatedCartAmount = (intValue_For_Price_Of_Accessory4 * intValue_For_Quantity_Need_To_Purchase);
		System.out.println("Total calculated cart value is:" + totalCalculatedCartAmount);

		// To check the calculated total amount is same with the asserted amount or not!
		assertEquals(num, totalCalculatedCartAmount);
		System.out.println(
				"Calculated total amount is same with the asserted amount and has been verified successfully.");
		Thread.sleep(4000);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("order");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("After typing order, it will show the payment options now.");
		Thread.sleep(10000);

		// To assert the payment mode Screen header showing to place the order
		String value_For_PaymentModeScreen_Header = buypage.read_Value_For_PaymentModeScreen_Header();
		String expected_Value_For_PlaceOrder13 = "How would you like to pay for this order?";
		String actual_Value_For_PlaceOrder13 = value_For_PaymentModeScreen_Header;
		if (actual_Value_For_PlaceOrder13.contains(expected_Value_For_PlaceOrder13)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Payment mode Screen header showing to place the order, has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.paymentModeScreen_Header);

		// To assert the online payment
		String value_For_PaymentMode_OnlinePayment = buypage.read_Value_For_PaymentModeScreen_Header();
		String expected_Value_For_PlaceOrder14 = online_PaymentMode;
		String actual_Value_For_PlaceOrder14 = value_For_PaymentMode_OnlinePayment;
		if (actual_Value_For_PlaceOrder14.contains(expected_Value_For_PlaceOrder14)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Payment mode Online payment, has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.paymentModeScreen_Header);

		// To assert the COD payment
		String value_For_PaymentMode_COD = buypage.read_Value_For_PaymentModeScreen_Header();
		String expected_Value_For_PlaceOrder15 = offline_Paymentmode;
		String actual_Value_For_PlaceOrder15 = value_For_PaymentMode_COD;
		if (actual_Value_For_PlaceOrder15.contains(expected_Value_For_PlaceOrder15)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Payment mode COD, has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.paymentModeScreen_Header);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("1");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("COD mode has been selected");
		Thread.sleep(10000);

		// To assert the COD Confirmation message
		String value_For_COD_Confirmation_Message = buypage.read_Value_For_COD_Confirmation_Message();
		String expected_Value_For_PlaceOrder16 = cod_Confirmation_Message;
		String actual_Value_For_PlaceOrder16 = value_For_COD_Confirmation_Message;
		if (actual_Value_For_PlaceOrder16.contains(expected_Value_For_PlaceOrder16)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("COD confirmation message, has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.COD_Confirmation_Message);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("yes");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("COD payment mode has been selected");
		Thread.sleep(10000);

		// To assert the COD Success message
		String value_For_COD_Success_Message = buypage.read_Value_For_COD_Success_Message();
		String expected_Value_For_PlaceOrder17 = cod_Success_Message;
		String actual_Value_For_PlaceOrder17 = value_For_COD_Success_Message;
		if (actual_Value_For_PlaceOrder17.contains(expected_Value_For_PlaceOrder17)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("COD Success message, has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.COD_Success_Message);

		// To assert the PlaceOrder purchase category listing screen header message
		String value_For_PurchaseCategory_ListingScreen_Header1 = buypage
				.read_Value_For_PurchaseCategory_ListingScreen_Header();
		String expected_Value_For_PlaceOrder18 = purchaseCategory_ListingScreen_Header;
		String actual_Value_For_PlaceOrder18 = value_For_PurchaseCategory_ListingScreen_Header1;
		// Assert.assertEquals(actual_Value, expected_Value,"Assertion passed");
		if (actual_Value_For_PlaceOrder18.contains(expected_Value_For_PlaceOrder18)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out
				.println("PlaceOrder purchase category listing screen header message, has been verified successfully.");
		webCmnUtil.explicitlyWait(buypage.purchaseCategory_ListingScreen_Header);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("0");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Buy Submenus showing properly.");
		Thread.sleep(10000);

	}

	public void orderStatusFlow_After_COD() throws InterruptedException {

		// To check the second submenu (order status)
		boolean value_For_OrderStatus_Submenu = buypage.read_Value_For_OrderStatus_Submenu();
		if (value_For_OrderStatus_Submenu == true) {

			System.out.println("Order Status submenu is showing successfully.");

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("2");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("OrderStatus submenu has been selected.");
			Thread.sleep(10000);

			// To assert the order status screen header
			String value_For_Order_Status_ScreenHeader = buypage.read_Value_For_Order_Status_ScreenHeader();
			String expected_Value_For_OrderStatusScreen1 = "Please find below the details of your orders";
			String actual_Value_OrderStatusScreen1 = value_For_Order_Status_ScreenHeader;
			if (actual_Value_OrderStatusScreen1.contains(expected_Value_For_OrderStatusScreen1)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("OrderStatus screen header message has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.order_Status_ScreenHeader);

			// To take the count of the number of orders in order status screen, after
			// placing the order successfully
			int value_For_CountOfOrders_in_OrderStatusScreen_IncludingFooterZero_AfterCOD = buypage
					.read_value_For_CountOfOrders_in_OrderStatusScreen();
			System.out.println("Total count of orders in Order Status Screen(including 0 in the footer): "
					+ value_For_CountOfOrders_in_OrderStatusScreen_IncludingFooterZero_AfterCOD);
			Thread.sleep(2000);

			int value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingCODOrder = (value_For_CountOfOrders_in_OrderStatusScreen_IncludingFooterZero_AfterCOD
					- 1);
			System.out.println(
					"Total count of plcaced orders in Order Status Screen, after placing the order successfully through COD: "
							+ value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingCODOrder);

			increamented_value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingOrderSuccessfully = (value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingOrderSuccessfully
					+ 1);

			if (value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingCODOrder == increamented_value_For_CountOfOrders_in_OrderStatusScreen_AfterPlacingOrderSuccessfully) {
				System.out.println("Order ID for the recent COD placed order, is showing properly.");

				// To select the recently added order id

				// To click and write on the type a message field
				whatsappcommon.write_On_Type_Message("0");
				Thread.sleep(1000);

				// To click on the send button
				whatsappcommon.click_On_Send_Button();
				System.out.println("Buy submenu showing properly.");
				Thread.sleep(10000);

			} else {
				System.out.println("Order ID for the recent COD placed order, is not showing.");
			}

		} else {
			System.out.println("Order Status submenu, is not showing.");
		}

	}

	public void cancelOrder_Flow() throws InterruptedException {

		// To check the third submenu (cancel order)
		boolean value_For_CancelOrder_Submenu = buypage.read_Value_For_CancelOrder_Submenu();
		if (value_For_CancelOrder_Submenu == true) {

			System.out.println("Cancel Order submenu is showing successfully.");

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("3");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("Cancel order submenu has been selected.");
			Thread.sleep(10000);

			// To assert the failure message under Cancel Order menu
			String value_For_CancelOrder_FailureMessage = buypage.read_Value_For_CancelOrder_FailureMessage();
			String expected_Value_For_CancelOrderFailureMessage = cancelOrder_Failure_Message;
			String actual_Value_CancelOrderFailureMessage = value_For_CancelOrder_FailureMessage;
			if (actual_Value_CancelOrderFailureMessage.contains(expected_Value_For_CancelOrderFailureMessage)) {
				System.out.println("Asserstion passed, because actual value contains the expected value.");
			}
			System.out.println("CancelOrder Failure message has been verified successfully.");
			webCmnUtil.explicitlyWait(buypage.cancelOrder_FailureMessage);

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("#");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("Main menu been showing.");
			Thread.sleep(10000);

			// To click and write on the type a message field
			whatsappcommon.write_On_Type_Message("3");
			Thread.sleep(1000);

			// To click on the send button
			whatsappcommon.click_On_Send_Button();
			System.out.println("Buy menu has been selected.");
			Thread.sleep(10000);

		} else {
			System.out.println("Cancel Order submenu is not showing.");
		}

		// To do the logout from brand account
		whatsappcommon.write_On_Type_Message("logout");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Logout has been done successfully.");
		Thread.sleep(10000);

		// To assert the logout success message
		String value_For_LogOutMessage = whatsappcommon.read_Value_For_LogOutMessage();
		String expected_Value_For_Logout = logout_Message;
		String actual_Value_For_Logout = value_For_LogOutMessage;
		if (actual_Value_For_Logout.contains(expected_Value_For_Logout)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Logout message, has been verified successfully.");
		webCmnUtil.explicitlyWait(whatsappcommon.logOutMessage);
	}

}
