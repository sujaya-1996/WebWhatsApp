package com.nhance.web.whatsApp.automation.userPageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

public class Buy_Page {

	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	boolean displayPanelView;

	public Buy_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	// To assert the buy menu header
	@FindBy(xpath = "//span[contains(text(), 'Here you could place orders , track your orders and cancel your orders. ')]")
	public WebElement buyMenu_Header;

	public String read_Value_For_BuyMenu_Header() {
		String value_For_BuyMenu_Header = buyMenu_Header.getText();
		webUtil.implicitWait();
		return value_For_BuyMenu_Header;
	}

	// To check the first submenu (place order)
	@FindBy(xpath = "//img[@class='b66 emoji wa _3Whw5 selectable-text invisible-space copyable-text']")
	private WebElement placeOrder_Submenu;

	public boolean read_Value_For_PlaceOrder_Submenu() {
		boolean value_For_PlaceOrder_Submenu = placeOrder_Submenu.isDisplayed();
		webUtil.implicitWait();
		return value_For_PlaceOrder_Submenu;
	}

	// To check the second submenu (order status)
	@FindBy(xpath = "//img[@class='b25 emoji wa _3Whw5 selectable-text invisible-space copyable-text']")
	private WebElement orderStatus_Submenu;

	public boolean read_Value_For_OrderStatus_Submenu() {
		boolean value_For_OrderStatus_Submenu = orderStatus_Submenu.isDisplayed();
		webUtil.implicitWait();
		return value_For_OrderStatus_Submenu;
	}

	// To check the third submenu (cancel order)
	@FindBy(xpath = "//img[@class='b7 emoji wa _3Whw5 selectable-text invisible-space copyable-text']")
	private WebElement cancelOrder_Submenu;

	public boolean read_Value_For_CancelOrder_Submenu() {
		boolean value_For_CancelOrder_Submenu = cancelOrder_Submenu.isDisplayed();
		webUtil.implicitWait();
		return value_For_CancelOrder_Submenu;
	}

	// To assert the failure message for Order status menu
	@FindBy(xpath = "//span[contains(text(),'There are no orders details to display at this point of time. Please continue to experience our other services')]")
	public WebElement orderStaus_FailureMessage;

	public String read_Value_For_OrderStaus_FailureMessage() {
		String value_For_OrderStaus_FailureMessage = orderStaus_FailureMessage.getText();
		webUtil.implicitWait();
		return value_For_OrderStaus_FailureMessage;
	}

	// To assert the failure message for Cancel Order menu
	@FindBy(xpath = "//span[contains(text(),'Uh ho! There are no orders available for cancellation for now. Please check back later or continue using other services. ')]")
	public WebElement cancelOrder_FailureMessage;

	public String read_Value_For_CancelOrder_FailureMessage() {
		String value_For_CancelOrder_FailureMessage = cancelOrder_FailureMessage.getText();
		webUtil.implicitWait();
		return value_For_CancelOrder_FailureMessage;
	}

	// Below are the xpaths for the place order flow

	// To assert the PlaceOrder purchase category listing screen header message
	@FindBy(xpath = "//span[contains(text(),'Please select a purchase category')]")
	public WebElement purchaseCategory_ListingScreen_Header;

	public String read_Value_For_PurchaseCategory_ListingScreen_Header() {
		String value_For_PurchaseCategory_ListingScreen_Header = purchaseCategory_ListingScreen_Header.getText();
		webUtil.implicitWait();
		return value_For_PurchaseCategory_ListingScreen_Header;
	}

	// To assert the message for selecting items to purchase
	@FindBy(xpath = "//span[contains(text(),'Please select the items you wish to purchase')]")
	public WebElement messageFor_Selecting_Items_To_Purchase;

	public String read_Value_For_MessageFor_Selecting_Items_To_Purchase() {
		String value_For_MessageFor_Selecting_Items_To_Purchase = messageFor_Selecting_Items_To_Purchase.getText();
		webUtil.implicitWait();
		return value_For_MessageFor_Selecting_Items_To_Purchase;
	}

	// To assert the accessories which dont have imgaes configured
	@FindBy(xpath = "//span[contains(text(),'. accessory4 Heatlh card Accessory ₹ 500.00  ')]")
	public WebElement accessory_WithoutHaving_Image_Configured;

	public String read_Value_For_Accessory_WithoutHaving_Image_Configured() {
		String value_For_Accessory_WithoutHaving_Image_Configured = accessory_WithoutHaving_Image_Configured.getText();
		webUtil.implicitWait();
		return value_For_Accessory_WithoutHaving_Image_Configured;
	}

	// To check the image of the first accessory from the list accessroies which do
	// have image configured
	@FindBy(xpath = "//img[@src='blob:https://web.whatsapp.com/178c91f0-558f-4540-b741-2479222a9586']")
	public WebElement firstAccessory_Having_Image;

	public boolean read_Value_For_FirstAccessory_Having_Image() {
		boolean value_For_FirstAccessory_Having_Image = firstAccessory_Having_Image.isDisplayed();
		webUtil.implicitWait();
		return value_For_FirstAccessory_Having_Image;
	}

	// To assert the first accessory details (which do have image configured)
	@FindBy(xpath = "//span[contains(text(),'. Accessory1 Heatlh card Accessory ₹ 200.00  ')]")
	public WebElement firstAccessory_Having_Image_Configured;

	public String read_Value_For_FirstAccessory_Having_Image_Configured() {
		String value_For_FirstAccessory_Having_Image_Configured = firstAccessory_Having_Image_Configured.getText();
		webUtil.implicitWait();
		return value_For_FirstAccessory_Having_Image_Configured;
	}

	// To check the image of the Second accessory from the list accessroies which do
	// have image configured
	@FindBy(xpath = "//img[@src='blob:https://web.whatsapp.com/feed4aae-4eff-4685-9027-f32eb4dbb0c7']")
	public WebElement secondAccessory_Having_Image;

	public boolean read_Value_For_SecondAccessory_Having_Image() {
		boolean value_For_SecondAccessory_Having_Image = secondAccessory_Having_Image.isDisplayed();
		webUtil.implicitWait();
		return value_For_SecondAccessory_Having_Image;
	}

	// To assert the Second accessory details (which do have image configured)
	@FindBy(xpath = "//span[contains(text(),'. Accessory2 Heatlh card Accessory ₹ 300.00 Document URL :')]")
	public WebElement secondAccessory_Having_Image_Configured;

	public String read_Value_For_SecondAccessory_Having_Image_Configured() {
		String value_For_SecondAccessory_Having_Image_Configured = secondAccessory_Having_Image_Configured.getText();
		webUtil.implicitWait();
		return value_For_SecondAccessory_Having_Image_Configured;
	}

	// To check the document URL link of the Second accessory from the list
	// accessroies which do have image configured
	@FindBy(xpath = "//a[@href='http://tinyurl.com/y4vnqdpm']")
	public WebElement documentURL_Of_SecondAccessory_Having_Image;

	public boolean read_Value_For_DocumentURL_Of_SecondAccessory_Having_Image() {
		boolean value_For_DocumentURL_Of_SecondAccessory_Having_Image = documentURL_Of_SecondAccessory_Having_Image
				.isDisplayed();
		webUtil.implicitWait();
		return value_For_DocumentURL_Of_SecondAccessory_Having_Image;
	}

	// To assert the message for successfull addition of items in the cart.
	@FindBy(xpath = "//span[contains(text(),'Yay! Item successfully added to your cart!')]")
	public WebElement successfull_Item_Addition_In_Cart_Message;

	public String read_Value_For_Successfull_Item_Addition_In_Cart_Message() {
		String value_For_Successfull_Item_Addition_In_Cart_Message = successfull_Item_Addition_In_Cart_Message
				.getText();
		webUtil.implicitWait();
		return value_For_Successfull_Item_Addition_In_Cart_Message;
	}

	// To assert the message for successfull addition of items in the cart.
	@FindBy(xpath = "//span[contains(text(),'Your Cart now contains:')]")
	public WebElement cart_Containing_Items_Message;

	public String read_Value_For_Cart_Containing_Items_Message() {
		String value_For_Cart_Containing_Items_Message = cart_Containing_Items_Message.getText();
		webUtil.implicitWait();
		return value_For_Cart_Containing_Items_Message;
	}

	// To assert the selected items details in the cart
	@FindBy(xpath = "//span[contains(text(),'Healthcare Accessories - accessory4 - Qty 2 - ₹ 1000.00')]")
	public WebElement selectedItemDetails_In_Cart;

	public String read_Value_For_SelectedItemDetails_In_Cart() {
		String value_For_SelectedItemDetails_In_Cart = selectedItemDetails_In_Cart.getText();
		webUtil.implicitWait();
		return value_For_SelectedItemDetails_In_Cart;
	}

	// To assert the payment mode Screen header showing to place the order
	@FindBy(xpath = "//span[contains(text(),'How would you like to pay for this order?')]")
	public WebElement paymentModeScreen_Header;

	public String read_Value_For_PaymentModeScreen_Header() {
		String value_For_PaymentModeScreen_Header = paymentModeScreen_Header.getText();
		webUtil.implicitWait();
		return value_For_PaymentModeScreen_Header;
	}

	// To assert the payment message showing to place the order flow
	@FindBy(xpath = "//span[contains(text(),'Please pay for  accessory4, for the selected DX card Doctor Heatlh card')]")
	public WebElement paymentMessage;

	public String read_Value_For_PaymentMessage() {
		String value_For_PaymentMessage = paymentMessage.getText();
		webUtil.implicitWait();
		return value_For_PaymentMessage;
	}

	// To click on the QA razorpay link
	@FindBy(xpath = "//span[contains(text(),'Click on this link to pay to Manmohan')]")
	public WebElement razorpay_PaymentLink;

	public void click_On_razorpay_PaymentLink() {
		razorpay_PaymentLink.click();
		webUtil.implicitWait();

	}

	// To assert the total amount of purchase in razorpay payment screen (assert
	// this with the multiplied value of
	// price and quantity variable)
	@FindBy(xpath = "//div[contains(text(),'  ₹ 1,000.00')]")
	public WebElement totalAmount_In_RazorpayPaymentScreen;

	public String read_Value_For_TotalAmount_In_RazorpayPaymentScreen() {
		String value_For_TotalAmount_In_RazorpayPaymentScreen = totalAmount_In_RazorpayPaymentScreen.getText();
		webUtil.implicitWait();
		return value_For_TotalAmount_In_RazorpayPaymentScreen;
	}

	// To assert the consumer phone number in razorpay screen
	@FindBy(xpath = "//span[contains(text(),'+919556951836')]")
	public WebElement consumerNumber_In_RazorpayScreen;

	public String read_Value_For_ConsumerNumber_In_RazorpayScreen() {
		String value_For_ConsumerNumber_In_RazorpayScreen = consumerNumber_In_RazorpayScreen.getText();
		webUtil.implicitWait();
		return value_For_ConsumerNumber_In_RazorpayScreen;
	}

	// To click on the netbanking option in razorpay screen
	@FindBy(xpath = "//div[contains(text(),'Netbanking')]")
	public WebElement netbanking_In_RazorpayScreen;

	public void click_On_Netbanking_In_RazorpayScreen() {
		webUtil.implicitWait();
		netbanking_In_RazorpayScreen.click();
		

	}

	// To click on the SBI option in razorpay screen
	@FindBy(xpath = "//div[contains(text(),'SBI')]")
	public WebElement SBI_Netbanking_In_RazorpayScreen;

	public void click_On_SBI_Netbanking_In_RazorpayScreen() {
		SBI_Netbanking_In_RazorpayScreen.click();
		webUtil.implicitWait();

	}

	// To click on the pay option in razorpay screen
	@FindBy(xpath = "//span[text()='Pay ₹ 1,000'][2]")
	public WebElement payOption_In_RazorpayScreen;

	public void click_On_PayOption_In_RazorpayScreen() {
		payOption_In_RazorpayScreen.click();
		webUtil.implicitWait();

	}

	// To click on the Success button, in confirmation screen
	@FindBy(xpath = "//button[@class='success']")
	public WebElement successButton_In_ConfirmationScreen;

	public void click_On_SuccessButton_In_ConfirmationScreen() {
		successButton_In_ConfirmationScreen.click();
		webUtil.implicitWait();

	}

	// To assert the payment completed text, after the successful payment
	@FindBy(xpath = "//div[contains(text(),'Payment Completed')]")
	public WebElement paymentCompleted_Text_In_RazorpayScreen;

	public String read_Value_For_PaymentCompleted_Text_In_RazorpayScreen() {
		String value_For_PaymentCompleted_Text_In_RazorpayScreen = paymentCompleted_Text_In_RazorpayScreen.getText();
		webUtil.implicitWait();
		return value_For_PaymentCompleted_Text_In_RazorpayScreen;
	}

	// To assert the success follow up message in whatsapp, after the successful
	// payment in razorpay
	@FindBy(xpath = "//span[contains(text(),'Hooray !! We have received your payment.')]")
	public WebElement success_FollowUp_Message;

	public String read_Value_For_Success_FollowUp_Message() {
		String value_For_Success_FollowUp_Message = success_FollowUp_Message.getText();
		webUtil.implicitWait();
		return value_For_Success_FollowUp_Message;
	}

	// To assert the order status screen header
	@FindBy(xpath = "//span[contains(text(),'Please find below the details of your orders')]")
	public WebElement order_Status_ScreenHeader;

	public String read_Value_For_Order_Status_ScreenHeader() {
		String value_For_Order_Status_ScreenHeader = order_Status_ScreenHeader.getText();
		webUtil.implicitWait();
		return value_For_Order_Status_ScreenHeader;
	}

	// To assert the quantity label in odrerdetails screen
	@FindBy(xpath = "//strong[contains(text(),'Qty')]")
	public WebElement quantityLabel_In_OrderDetails_Screen;

	public String read_Value_For_QuantityLabel_In_OrderDetails_Screen() {
		String value_For_QuantityLabel_In_OrderDetails_Screen = quantityLabel_In_OrderDetails_Screen.getText();
		webUtil.implicitWait();
		return value_For_QuantityLabel_In_OrderDetails_Screen;
	}

	// To assert the amount label in odrerdetails screen
	@FindBy(xpath = "//strong[contains(text(),'Amount')]")
	public WebElement amountLabel_In_OrderDetails_Screen;

	public String read_Value_For_AmountLabel_In_OrderDetails_Screen() {
		String value_For_AmountLabel_In_OrderDetails_Screen = amountLabel_In_OrderDetails_Screen.getText();
		webUtil.implicitWait();
		return value_For_AmountLabel_In_OrderDetails_Screen;
	}
	
	// To take the count of the number of orders, in order status screen
	@FindBy(xpath = "//span[contains(text(), 'Please find below the details of your orders')] //strong[@class ='_3Whw5 selectable-text invisible-space copyable-text']")
	public List<WebElement> countOfOrders_in_OrderStatusScreen;

	public int read_value_For_CountOfOrders_in_OrderStatusScreen() {
		int value_For_CountOfOrders_in_OrderStatusScreen = countOfOrders_in_OrderStatusScreen.size();
		webUtil.implicitWait();
		return value_For_CountOfOrders_in_OrderStatusScreen;
		
	}
	
	// To assert the COD Confirmation message
	@FindBy(xpath = "//span[contains(text(),'Please reply with Yes to confirm and No to reject')]")
	public WebElement COD_Confirmation_Message;

	public String read_Value_For_COD_Confirmation_Message() {
		String value_For_COD_Confirmation_Message = COD_Confirmation_Message.getText();
		webUtil.implicitWait();
		return value_For_COD_Confirmation_Message;
	}
	
	// To assert the COD Success message
	@FindBy(xpath = "//span[contains(text(),'Hooray !! Your order is placed successfully.')]")
	public WebElement COD_Success_Message;

	public String read_Value_For_COD_Success_Message() {
		String value_For_COD_Success_Message = COD_Success_Message.getText();
		webUtil.implicitWait();
		return value_For_COD_Success_Message;
	}

	
	
}
