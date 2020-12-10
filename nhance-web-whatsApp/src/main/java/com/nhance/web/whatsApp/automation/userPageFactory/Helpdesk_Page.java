package com.nhance.web.whatsApp.automation.userPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

public class Helpdesk_Page {
	
	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	boolean displayPanelView;

	public Helpdesk_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}
	
	// To assert the helpdesk email
	@FindBy(xpath="//a[@href = 'mailto:mktg@gupshup.io']")
	public WebElement heldesk_Email;
	
	public String read_Value_For_Heldesk_Email() {
		String value_For_Heldesk_Email = heldesk_Email.getText();
		webUtil.implicitWait();
		return value_For_Heldesk_Email;
	}
	
	// To assert the heldpesk text that contains both mail and mobile number
	@FindBy(xpath="//span[contains(text(), ' or Call us on +91180008080 for any assistance.')]")
	public WebElement heldesk_Textmessage;
	
	public String read_Value_For_Heldesk_Textmessage() {
		String value_For_Heldesk_Textmessage = heldesk_Textmessage.getText();
		webUtil.implicitWait();
		return value_For_Heldesk_Textmessage;
	}
	
	// To assert the heldpesk number
	@FindBy(xpath="//span[contains(text(), ' or Call us on +91180008080 for any assistance.')]")
	public WebElement heldesk_number;
	
	public String read_Value_For_Heldesk_number() {
		String value_For_Heldesk_number = heldesk_number.getText();
		webUtil.implicitWait();
		return value_For_Heldesk_number;
	}
	
}
