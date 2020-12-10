package com.nhance.web.whatsApp.automation.userPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

public class WhatsAppCommonPage {

	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	boolean displayPanelView;
	boolean welcomeMessageText;

	public WhatsAppCommonPage(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='pane-side']")
	private WebElement panelView;

	public boolean check_Panel_View() {
		return displayPanelView = panelView.isDisplayed();
	}

	@FindBy(xpath = "//div[@class = '_3FRCZ copyable-text selectable-text']")
	public WebElement searchText;

	public void write_On_Search_Field(String userName) {
		boolean status = check_Panel_View();
		if (status) {
			webUtil.retryingWriteText(searchText, userName);
		}
	}

	//To click on gupshup live account
	@FindBy(xpath = "//div[@class='_2kHpK']//span[contains(text(),'Gupshup')]")
	public WebElement userChat;

	public void click_On_User_Gupshup() throws InterruptedException {
		webUtil.retryingFindClick(userChat);
	}
	
	//To click on Twilio live account
	@FindBy(xpath = "//span[@class= 'matched-text _3Whw5' and contains(text(), 'Twilio Live Account')]")
	public WebElement twilio_UserChat;

	public void click_On_User_Twilio() throws InterruptedException {
		webUtil.retryingFindClick(twilio_UserChat);
	}


	@FindBy(xpath = "//div[@class='_2FbwG' and contains(text(),'Type a message')]/following-sibling::div")
	public WebElement typeMessage;

	public void write_On_Type_Message(String typeMessageData) {
		webUtil.retryingWriteText(typeMessage, typeMessageData);
	}

	@FindBy(xpath = "//span[@dir='ltr']//span[contains(text(),'Welcome')]")
	private WebElement welcomeMessage;

	public void verify_Welcome_Message() {
		welcomeMessageText = welcomeMessage.isDisplayed();
		System.out.println("The welcome message display is " + welcomeMessageText);
	}
	
	// To click on the send button
	@FindBy(xpath="//div[@class='_1JNuk']")
	private WebElement send_Button;
	
	public void click_On_Send_Button() {
		send_Button.click();
		webUtil.implicitWait();
	}
	
	// To put the assertion for invalid input scenario (giving wrong number inputs)
	@FindBy(xpath="//span[contains(text(), 'It looks like you have chosen an invalid selection. Please re-enter.')]")
	public WebElement invalid_Input;
	
	public String read_Value_Of_Invalid_Input() {
		String value_Of_Invalid_Input = invalid_Input.getText();
		webUtil.implicitWait();
		return value_Of_Invalid_Input;
	}
	
	// To put the assertion for invalid input scenario(giving wrong text inputs)
	@FindBy(xpath="//span[contains(text(), 'We are unable to understand your query. Kindly rephrase your query or type ')]")
	public WebElement invalid_TextInput;
	
	public String read_Value_Of_Invalid_TextInput() {
		String value_Of_Invalid_TextInput = invalid_TextInput.getText();
		webUtil.implicitWait();
		return value_Of_Invalid_TextInput;
	}
	
	// To assert the footer message (MenuOptionsAndMainMenuReturn_Message)
	@FindBy(xpath="//span[contains(text(), 'Type 0 to go back or type # to go back to the main menu.')]")
	public WebElement menuOptionsAndMainMenuReturn_Message;
	
	public String read_Value_For_MenuOptionsAndMainMenuReturn_Message() {
		String value_For_MenuOptionsAndMainMenuReturn_Message = menuOptionsAndMainMenuReturn_Message.getText();
		webUtil.implicitWait();
		return value_For_MenuOptionsAndMainMenuReturn_Message;
	}
	
	// To assert the MainMenuReturn_Message
	@FindBy(xpath="//span[contains(text(), 'Type # to go back to the main menu')]")
	public WebElement mainMenuReturn_Message;
	
	public String read_Value_For_MainMenuReturn_Message() {
		String value_For_MainMenuReturn_Message = mainMenuReturn_Message.getText();
		webUtil.implicitWait();
		return value_For_MainMenuReturn_Message;
	}
	
	// To logout from the chat
	@FindBy(xpath = "//div[@class='eRacY']//span[contains(text(),'Sad to see you leave us')]")
	public WebElement logOutMessage;
	
	public String read_Value_For_LogOutMessage() {
		String value_For_LogOutMessage = logOutMessage.getText();
		webUtil.implicitWait();
		return value_For_LogOutMessage;
	}
	

}
