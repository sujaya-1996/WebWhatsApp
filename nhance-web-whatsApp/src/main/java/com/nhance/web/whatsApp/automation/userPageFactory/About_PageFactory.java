package com.nhance.web.whatsApp.automation.userPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

public class About_PageFactory {
	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	

	public About_PageFactory(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}
	
	// To assert the header message of the About menu
	@FindBy(xpath="//span[contains(text(), 'Here are details of your product Doctor Heatlh card.')]")
	public WebElement about_Header;
	
	public String read_Value_For_About_Header() {
		String value_For_About_Header = about_Header.getText();
		webUtil.implicitWait();
		return value_For_About_Header;
	}
	
	// To assert the model number label
	@FindBy(xpath="//strong[contains(text(), 'Model Number')]")
	public WebElement modelNumber_Label;
	
	public String read_Value_For_ModelNumber_Label() {
		String value_For_ModelNumber_Label = modelNumber_Label.getText();
		webUtil.implicitWait();
		return value_For_ModelNumber_Label;
	}
	
	// To assert the Product Manufacturer label
	@FindBy(xpath="//strong[contains(text(), 'Product Manufacturer')]")
	public WebElement productManufacturer_Label;
	
	public String read_Value_For_ProductManufacturer_Label() {
		String value_For_ProductManufacturer_Label = productManufacturer_Label.getText();
		webUtil.implicitWait();
		return value_For_ProductManufacturer_Label;
	}
	
	// To assert the purchase date label
	@FindBy(xpath="//strong[contains(text(), 'Purchased Date')]")
	public WebElement purchaseDate_Label;
	
	public String read_Value_For_PurchaseDate_Label() {
		String value_For_PurchaseDate_Label = purchaseDate_Label.getText();
		webUtil.implicitWait();
		return value_For_PurchaseDate_Label;
	}
	
	// To assert the Warranty Expires On label
	@FindBy(xpath="//strong[contains(text(), 'Warrnty Expires On')]")
	public WebElement warrantyExpiresOn_Label;
	
	public String read_Value_For_WarrantyExpiresOn_Label() {
		String value_For_WarrantyExpiresOn_Label = warrantyExpiresOn_Label.getText();
		webUtil.implicitWait();
		return value_For_WarrantyExpiresOn_Label;
	}
	

	
}
