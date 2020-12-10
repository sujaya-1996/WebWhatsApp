package com.nhance.web.whatsApp.automation.userPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

public class WhatsappMe_Page {
	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	

	public WhatsappMe_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}
	
	// To assert the header message in the whatsappMe menu
	@FindBy(xpath="//span[contains(text(),'Please click on the link below to start communicating')]")
	public WebElement whatsappMe_Header;
	
	public String read_Value_For_WhatsappMe_Header() {
		String value_For_WhatsappMe_Header = whatsappMe_Header.getText();
		webUtil.implicitWait();
		return value_For_WhatsappMe_Header;
	}
	
	// To assert the whatsappme link in the whatsappMe menu
	@FindBy(xpath="//a[@href= 'https://wa.me/917019145221']")
	public WebElement whatsappMe_Link;
	
	public String read_Value_For_WhatsappMe_Link() {
		String value_For_WhatsappMe_Link = whatsappMe_Link.getText();
		webUtil.implicitWait();
		return value_For_WhatsappMe_Link;
	}
	
	// To click on the whatsappme link
	@FindBy(xpath="//a[@href= 'https://wa.me/917019145221']")
	public WebElement whatsappMe_Link_Click;
	
	public void click_On_WhatsappMe_Link() {
		whatsappMe_Link_Click.click();
		webUtil.implicitWait();
		
	}
	
	// To check the new chat window after clicking on the whatsappme link
	@FindBy(xpath="//span[@title = '+91 70191 45221']")
	public WebElement newChat_Window;
	
	public boolean read_Value_For_NewChat_Window() {
		boolean value_For_NewChat_Window = newChat_Window.isDisplayed();
		webUtil.implicitWait();
		return value_For_NewChat_Window;
	}
}
