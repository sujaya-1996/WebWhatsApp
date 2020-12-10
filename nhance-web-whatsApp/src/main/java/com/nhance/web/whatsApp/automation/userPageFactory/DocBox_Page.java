package com.nhance.web.whatsApp.automation.userPageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;


public class DocBox_Page {
	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	boolean displayPanelView;
	boolean welcomeMessageText;

	public DocBox_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}
	
	//div[@id='pane-side']
	
	//div[contains(text(),'Search or start new chat')]
	
	@FindBy(xpath="//div[@id='pane-side']")
	private WebElement panelView;
	
	public boolean  check_Panel_View() {
		return displayPanelView = panelView.isDisplayed();
	}
	

	
	
	//span[@dir='ltr']//span[contains(text(),'Welcome')]//strong
	
	//ul[@class='I4jbF']//li/div[contains(text(),'Delete')]
	
	
	
}
