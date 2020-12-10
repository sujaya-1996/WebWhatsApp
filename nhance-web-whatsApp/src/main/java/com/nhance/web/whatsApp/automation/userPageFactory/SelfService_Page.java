package com.nhance.web.whatsApp.automation.userPageFactory;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

public class SelfService_Page {

	
	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	boolean displayPanelView;

	public SelfService_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}
	
	//To check the panel view is showing or not!!
	@FindBy(xpath="//div[@id='pane-side']")
	private WebElement panelView;
	
	public boolean check_Panel_View() {
		boolean displayPanelView = panelView.isDisplayed();
		webUtil.implicitWait();
		return displayPanelView;
	}
	
	//To click on the search-box and write the account name
	@FindBy(xpath = "//div[contains(text(),'Search or start new chat')]")
	private WebElement searchText;
	
	public void write_On_Search_Field(String userName) {
		webUtil.retryingWriteText(searchText, userName);
		//searchText.sendKeys(userName);
			webUtil.implicitWait();
		
	}
	
	// To click on the gupshuplive account
	@FindBy(xpath="//span[contains(@class,'_3ko75 _5h6Y_ _3Whw5') and contains(text(),'Gupshup Live')]")
	private WebElement gupshupLive_Account;
	
	public void click_On_GupshupLive_Account() {
		gupshupLive_Account.click();
		webUtil.implicitWait();
	}
	
	//To click and write on the type a message field 
	@FindBy(xpath = "//div[contains(@class, '_3FRCZ copyable-text selectable-text') and @data-tab='1']")
	private WebElement type_A_Message_Field;
	
	public void write_On_Type_A_Message_Field(String reply_Text) {
			webUtil.retryingWriteText(type_A_Message_Field, reply_Text);
			webUtil.implicitWait();
		
	}
	
	
	// To click on the link of the invoice/document
	@FindBy(xpath="//a[@href ='http://tinyurl.com/yxe5wde2']")
	private WebElement invoiceLink_In_SelfService;
	
	public void click_On_InvoiceLink_In_SelfService() {
		invoiceLink_In_SelfService.click();
		webUtil.implicitWait();
	}
	
	// To assert the Self service type ("Additional" Service type)
	@FindBy(xpath="//strong[@class = '_3Whw5 selectable-text invisible-space copyable-text' and contains(text(),'Additional')]")
	public WebElement selfserviceType;
	
	public String read_Value_For_selfserviceType() {
		String value_For_selfserviceType = selfserviceType.getText();
		webUtil.implicitWait();
		return value_For_selfserviceType;
	}
	
	// To assert the Self service document name, in that particular document details display screen
	@FindBy(xpath="//span[contains(text(), 'doc2 ')]")
	public WebElement selfService_DocumentName;
	
	public String read_Value_For_selfService_DocumentName() {
		String value_For_SelfService_DocumentName = selfService_DocumentName.getText();
		webUtil.implicitWait();
		return value_For_SelfService_DocumentName;
	}
	
	// To assert the Self service document link
	@FindBy(xpath="//a[@href = 'http://tinyurl.com/yxe5wde2']")
	public WebElement selfService_DocumentLink;
	
	public String read_Value_For_SelfService_DocumentLink() {
		String value_For_SelfService_DocumentLink = selfService_DocumentLink.getText();
		webUtil.implicitWait();
		return value_For_SelfService_DocumentLink;
	}
	
	// To assert the self service message to continue more
	@FindBy(xpath="//span[contains(text(), 'If you wish to continue, you can choose from the above Self Service ')]")
	public WebElement selfServiceMessage_To_Contniue;
	
	public String read_Value_For_SelfServiceMessage_To_Contniue() {
		String value_For_SelfServiceMessage_To_Contniue = selfServiceMessage_To_Contniue.getText();
		webUtil.implicitWait();
		return value_For_SelfServiceMessage_To_Contniue;
	}
	
	// To get the count of the Self service documents
	@FindBy(xpath="//div[@class='eRacY']//span[contains(text(),'Self Service ')]//img/parent::strong")
	public List<WebElement> selfService_Submenus;
	
	public int getCountForSubmenus=0;
	List<String> submenuDetails;
	
	public int listOfSelfservice_SubMenus() {
		for(int i=0; i<selfService_Submenus.size(); i++) {
			String subMenuText = selfService_Submenus.get(i).getText();
			submenuDetails = new ArrayList<>();
			submenuDetails.add(subMenuText);
			getCountForSubmenus++;
			System.out.println("The Submenus of Selfservice are "+submenuDetails);
			
		}	
		System.out.println("The total count of the submenus are: "+getCountForSubmenus);
		return getCountForSubmenus;
	}

	
	
}
