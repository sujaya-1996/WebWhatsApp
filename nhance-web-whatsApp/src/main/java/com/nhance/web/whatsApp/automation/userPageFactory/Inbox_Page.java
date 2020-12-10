package com.nhance.web.whatsApp.automation.userPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

public class Inbox_Page {
	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	boolean displayPanelView;

	public Inbox_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	// To assert the Inbox menu header
	@FindBy(xpath = "//span[contains(text(), 'Menu for DX Card : DoctorHeatlh card')]")
	public WebElement inboxMenu_Header;

	public String read_Value_For_InboxMenu_Header() {
		String value_For_InboxMenu_Header = inboxMenu_Header.getText();
		webUtil.implicitWait();
		return value_For_InboxMenu_Header;
	}

	// To check the smart notification submenu emoji is showing or not!
	@FindBy(xpath = "//img[@src = 'data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7' and @class= 'b66 emoji wa _3Whw5 selectable-text invisible-space copyable-text']")
	public WebElement smartNotification_Submenu;

	public boolean read_Value_For_SmartNotification_Submenu() {
		boolean value_For_SmartNotification_Submenu = smartNotification_Submenu.isDisplayed();
		webUtil.implicitWait();
		return value_For_SmartNotification_Submenu;
	}

	// To check whether offers submenu is showing or not with emoji!
	@FindBy(xpath = "//img[@class='b25 emoji wa _3Whw5 selectable-text invisible-space copyable-text']")
	public WebElement offers_Submenu;

	public boolean read_Value_For_Offers_Submenu() {
		boolean value_For_Offers_Submenu = offers_Submenu.isDisplayed();
		webUtil.implicitWait();
		return value_For_Offers_Submenu;
	}

	// To assert the smart notification pwa link screen header
	@FindBy(xpath = "//span[contains(text(), 'Please select from one of the options below for DX Card: DoctorHeatlh card')]")
	public WebElement smartNotification_LinkScreen_Header;

	public String read_Value_For_SmartNotification_LinkScreen_Header() {
		String value_For_SmartNotification_LinkScreen_Header = smartNotification_LinkScreen_Header.getText();
		webUtil.implicitWait();
		return value_For_SmartNotification_LinkScreen_Header;
	}

	// To assert the smart notification pwa link
	@FindBy(xpath = "//a[@href= 'http://tinyurl.com/y7ppxa6n']")
	public WebElement smartNotification_PWALink;

	public String read_Value_For_SmartNotification_PWALink() {
		String value_For_SmartNotification_PWALink = smartNotification_PWALink.getText();
		webUtil.implicitWait();
		return value_For_SmartNotification_PWALink;
	}

	// To click the smart notification pwa link (in dev as of now)
	@FindBy(xpath = "//a[@href= 'http://tinyurl.com/y7ppxa6n']")
	public WebElement smartNotification_Link;

	public void click_On_SmartNotification_Link() {
		smartNotification_Link.click();
		webUtil.implicitWait();

	}
	
	// To assert the offer pwa link
	@FindBy(xpath = "//a[@href= 'http://tinyurl.com/y9p9e6o9']")
	public WebElement offer_PWALink;

	public String read_Value_For_Offer_PWALink() {
		String value_For_Offer_PWALink = offer_PWALink.getText();
		webUtil.implicitWait();
		return value_For_Offer_PWALink;
	}

	// To click the Offer pwa link (in dev as of now)
	@FindBy(xpath = "//a[@href= 'http://tinyurl.com/y9p9e6o9']")
	public WebElement offer_Link;

	public void click_On_Offer_Link() {
		offer_Link.click();
		webUtil.implicitWait();

	}
	
	

	// To assert the smart notification pwa screen header
	@FindBy(xpath = "//h1[contains(text(),'Notification ')]")
	public WebElement smartNotification_PWAScreen_Header;

	public String read_Value_For_SmartNotification_PWAScreen_Header() {
		String value_For_SmartNotification_PWAScreen_Header = smartNotification_PWAScreen_Header.getText();
		webUtil.implicitWait();
		return value_For_SmartNotification_PWAScreen_Header;
	}

	// To check the smart notification bell icon!
	@FindBy(xpath = "//img[@src='assets/img/push-notification.png']")
	public WebElement smartNotification_BellIcon;

	public boolean read_Value_For_SmartNotification_BellIcon() {
		boolean value_For_SmartNotification_BellIcon = smartNotification_BellIcon.isDisplayed();
		webUtil.implicitWait();
		return value_For_SmartNotification_BellIcon;
	}

	// To assert the smart notification name in the pwa screen
	@FindBy(xpath = "//h3[contains(text(),'test notificationone')]")
	public WebElement smartNotification_Name_InPWAScreen;

	public String read_value_For_SmartNotification_Name_InPWAScreen() {
		String value_For_SmartNotification_Name_InPWAScreen = smartNotification_Name_InPWAScreen.getText();
		webUtil.implicitWait();
		return value_For_SmartNotification_Name_InPWAScreen;
	}

	// To assert the smart notification message in the pwa screen
	@FindBy(xpath = "//p[contains(text(),'message for test notificationone')]")
	public WebElement smartNotification_Message_InPWAScreen;

	public String read_Value_For_SmartNotification_Message_InPWAScreen() {
		String value_For_SmartNotification_Message_InPWAScreen = smartNotification_Message_InPWAScreen.getText();
		webUtil.implicitWait();
		return value_For_SmartNotification_Message_InPWAScreen;
	}

	// To check for time icon
	@FindBy(xpath = "//img[@src='assets/img/date_time.svg']")
	public WebElement timeIcon_InPWAScreen;

	public boolean read_Value_For_TimeIcon_InPWAScreen() {
		boolean value_For_TimeIcon_InPWAScreen = timeIcon_InPWAScreen.isDisplayed();
		webUtil.implicitWait();
		return value_For_TimeIcon_InPWAScreen;
	}

	// To check for the clear all button
	@FindBy(xpath = "//a[@href='JavaScript:Void(0);']")
	public WebElement clearAll_InPWAScreen;

	public boolean read_Value_For_ClearAll_InPWAScreen() {
		boolean value_For_ClearAll_InPWAScreen = clearAll_InPWAScreen.isDisplayed();
		webUtil.implicitWait();
		return value_For_ClearAll_InPWAScreen;
	}

	// To assert the offer header in the pwa screen
	@FindBy(xpath = "//h1[contains(text(),'Rewards')]")
	public WebElement offerHeader_InPWAScreen;

	public String read_Value_For_OfferHeader_InPWAScreen() {
		String value_For_OfferHeader_InPWAScreen = offerHeader_InPWAScreen.getText();
		webUtil.implicitWait();
		return value_For_OfferHeader_InPWAScreen;
	}

	// To check the image in the pwa screen, when image is not configured for offer
	@FindBy(xpath = "//p[contains(text(),'No Images to Show')]")
	public WebElement defaultImage_ForNoImageConfig_InPWAScreen;

	public boolean read_Value_For_DefaultImage_ForNoImageConfig_InPWAScreen() {
		boolean value_For_DefaultImage_ForNoImageConfig_InPWAScreen = defaultImage_ForNoImageConfig_InPWAScreen
				.isDisplayed();
		webUtil.implicitWait();
		return value_For_DefaultImage_ForNoImageConfig_InPWAScreen;
	}

	// To assert the offer Name in the pwa screen
	@FindBy(xpath = "//h3[contains(text(),'test offerone')]")
	public WebElement offerName_InPWAScreen;

	public String read_Value_For_OfferName_InPWAScreen() {
		String value_For_OfferName_InPWAScreen = offerName_InPWAScreen.getText();
		webUtil.implicitWait();
		return value_For_OfferName_InPWAScreen;
	}

	// To assert the offer sent by (Brand name) in the pwa screen
	@FindBy(xpath = "//p[contains(text(),' Sent by : Gupshup Testing Account')]")
	public WebElement offerSentBy_InPWAScreen;

	public String read_Value_For_OfferSentBy_InPWAScreen() {
		String value_For_OfferSentBy_InPWAScreen = offerSentBy_InPWAScreen.getText();
		webUtil.implicitWait();
		return value_For_OfferSentBy_InPWAScreen;
	}

	// To click the offer Name in the pwa screen
	@FindBy(xpath = "//h3[contains(text(),'test offerone')]")
	public WebElement click_On_OfferName_InPWAScreen;

	public void click_OfferName_InPWAScreen() {
		click_On_OfferName_InPWAScreen.click();
		webUtil.implicitWait();

	}

	// To assert the offer details header in details screen
	@FindBy(xpath = "//h1[contains(text(),'Details')]")
	public WebElement offerHeader_InDetailsScreen;

	public String read_Value_For_OfferHeader_InDetailsScreen() {
		String value_For_OfferHeader_InDetailsScreen = offerHeader_InDetailsScreen.getText();
		webUtil.implicitWait();
		return value_For_OfferHeader_InDetailsScreen;
	}

	// To click on the arrow for the previous screen, in offer details screen
	@FindBy(xpath = "//i[@class='icon icon-arrow-right']")
	public WebElement previousScreen_InOfferDetailsScreen;

	public void click_On_PreviousScreen_InOfferDetailsScreen() {
		previousScreen_InOfferDetailsScreen.click();
		webUtil.implicitWait();

	}

	// To assert the offer name in offer details screen
	@FindBy(xpath = "//a[contains(text(),'test offerone')]")
	public WebElement offerName_InDetailsScreen;

	public String read_Value_For_OfferName_InDetailsScreen() {
		String value_For_OfferName_InDetailsScreen = offerName_InDetailsScreen.getText();
		webUtil.implicitWait();
		return value_For_OfferName_InDetailsScreen;
	}

	// To assert the offer message in offer details screen
	@FindBy(xpath = "//p[contains(text(),'message for test offerone')]")
	public WebElement offerMessage_InDetailsScreen;

	public String read_Value_For_OfferMessage_InDetailsScreen() {
		String value_For_OfferMessage_InDetailsScreen = offerMessage_InDetailsScreen.getText();
		webUtil.implicitWait();
		return value_For_OfferMessage_InDetailsScreen;
	}
	
	// To assert the feedback name
	@FindBy(xpath = "//h3[contains(text(),'testfeedbackone')]")
	public WebElement feedbackName_In_PWAScreen;

	public String read_Value_For_FeedbackName_In_PWAScreen() {
		String value_For_FeedbackName_In_PWAScreen = feedbackName_In_PWAScreen.getText();
		webUtil.implicitWait();
		return value_For_FeedbackName_In_PWAScreen;
	}
	
	// To assert the feedback message
	@FindBy(xpath = "//p[contains(text(),'message for testfeedbackone')]")
	public WebElement feedbackMessage_In_PWAScreen;

	public String read_Value_For_FeedbackMessage_In_PWAScreen() {
		String value_For_FeedbackMessage_In_PWAScreen = feedbackMessage_In_PWAScreen.getText();
		webUtil.implicitWait();
		return value_For_FeedbackMessage_In_PWAScreen;
	}
	
	// To check the feedback default Image
	@FindBy(xpath = "//img[@src='assets/img/feedback.svg']")
	public WebElement feedbackImage_In_PWAScreen;

	public boolean read_Value_For_FeedbackImage_In_PWAScreen() {
		boolean value_For_FeedbackImage_In_PWAScreen = feedbackImage_In_PWAScreen.isDisplayed();
		webUtil.implicitWait();
		return value_For_FeedbackImage_In_PWAScreen;
	}
	
	// To click on the feedback
	@FindBy(xpath = "//h3[contains(text(),'testfeedbackone')]")
	public WebElement click_Feedback_In_PWAScreen;

	public void click_On_Feedback_In_PWAScreen() {
		click_Feedback_In_PWAScreen.click();
		webUtil.implicitWait();
		
	}
	
	// To assert the Header of the Rating Details screen 
	@FindBy(xpath = "//h1[contains(text(), 'How do you rate your experience with us?')]")
	public WebElement header_In_Rating_DetailsScreen;

	public String read_Value_For_Header_In_Rating_DetailsScreen() {
		String value_For_Header_In_Rating_DetailsScreen = header_In_Rating_DetailsScreen.getText();
		webUtil.implicitWait();
		return value_For_Header_In_Rating_DetailsScreen;
	}
	
	// To check the brands image in the rating details screen
	@FindBy(xpath = "//img[@src='blob:https://dev.nhancenow.com/8dca6b67-b384-4f81-9eef-a13a97ede52d']")
	public WebElement brandImage_In_Rating_DetailsScreen;

	public boolean read_Value_For_BrandImage_In_Rating_DetailsScreen() {
		boolean value_For_BrandImage_In_Rating_DetailsScreen = brandImage_In_Rating_DetailsScreen.isDisplayed();
		webUtil.implicitWait();
		return value_For_BrandImage_In_Rating_DetailsScreen;
	}
	
	// To assert the SentBy admin's name in the Rating Details screen 
	@FindBy(xpath = "//h2[contains(text(),'Gupshup Testing Account')]")
	public WebElement sentBy_AdminName_In_Rating_DetailsScreen;

	public String read_Value_For_SentBy_AdminName_In_Rating_DetailsScreen() {
		String value_For_SentBy_AdminName_In_Rating_DetailsScreen = sentBy_AdminName_In_Rating_DetailsScreen.getText();
		webUtil.implicitWait();
		return value_For_SentBy_AdminName_In_Rating_DetailsScreen;
	}
	
	// To check stars for rating in the rating details screen
	@FindBy(xpath = "//label[@class = 'star star-5']")
	public WebElement starsForRating_In_Rating_DetailsScreen;

	public boolean read_Value_For_StarsForRating_In_Rating_DetailsScreen() {
		boolean value_For_StarsForRating_In_Rating_DetailsScreen = starsForRating_In_Rating_DetailsScreen.isDisplayed();
		webUtil.implicitWait();
		return value_For_StarsForRating_In_Rating_DetailsScreen;
	}
	
	// To assert the Additional Comment field placeholder in the Rating Details screen 
	@FindBy(xpath = "//input[@placeholder = 'Additional Comments']")
	public WebElement additionalComment_Placeholder_In_Rating_DetailsScreen;

	public String read_Value_For_AdditionalComment_Placeholder_In_Rating_DetailsScreen() {
		String value_For_AdditionalComment_Placeholder_In_Rating_DetailsScreen = additionalComment_Placeholder_In_Rating_DetailsScreen.getText();
		webUtil.implicitWait();
		return value_For_AdditionalComment_Placeholder_In_Rating_DetailsScreen;
	}
	
	// To check the submit button for rating in the rating details screen
	@FindBy(xpath = "//a[@class = 'btn-custom']")
	public WebElement submitButton_In_Rating_DetailsScreen;

	public boolean read_Value_For_SubmitButton_In_Rating_DetailsScreen() {
		boolean value_For_SubmitButton_In_Rating_DetailsScreen = submitButton_In_Rating_DetailsScreen.isDisplayed();
		webUtil.implicitWait();
		return value_For_SubmitButton_In_Rating_DetailsScreen;
	}
	
	// To check the poweredBy details in the rating details screen
	@FindBy(xpath = "//h4[contains(text(), 'NHANCE NOW')]")
	public WebElement poweredBy_In_Rating_DetailsScreen;

	public boolean read_Value_For_PoweredBy_In_Rating_DetailsScreen() {
		boolean value_For_PoweredBy_In_Rating_DetailsScreen = poweredBy_In_Rating_DetailsScreen.isDisplayed();
		webUtil.implicitWait();
		return value_For_PoweredBy_In_Rating_DetailsScreen;
	}
	
}
