package com.nhance.web.whatsApp.automation.userPageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

/**
 * 
 */
/**
 * @author Manmohan
 *
 */
public class CustomerAdminCommonWebElementInAllPage {

	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();

	public CustomerAdminCommonWebElementInAllPage(WebDriver driver) {
		this.driver = driver;
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}
	
	// Logo Link
	@FindBy(xpath="//img[@class='headerLogostyle']")
	private WebElement nhance_Logo_Link;
	public void click_on_nhance_Logo_Link() throws InterruptedException
	{
		webUtil.retryingFindClick(nhance_Logo_Link);
	}
	
	
	// Country Flag ICon click
	@FindBy(xpath="//div[@class='iti-arrow']")
	private WebElement arrowMark_On_FlagIcon;
	
	public void click_On_arrowMark_On_FlagIcon() throws InterruptedException
	{
		webUtil.retryingFindClick(arrowMark_On_FlagIcon);
	}
	
	@FindBy(xpath="//ul[@class='country-list dropdown-menu show']/li/span[@class='country-name']")
	public List<WebElement> listOfCountryName;
	
	@FindBy(xpath = "//span[text()='Configure']")
	private WebElement configure_Link;

	public void click_On_Configure_Link() throws InterruptedException {
	webUtil.retryingFindClick(configure_Link);
	}

	@FindBy(xpath = "//span[text()='Manage']")
	private WebElement manage_Link;

	public void click_On_Manage_Link() throws InterruptedException {
	webUtil.retryingFindClick(manage_Link);
	}
	
	@FindBy(xpath = "//span[text()='Support']")
	private WebElement support_Link;
	
	public void click_On_Support_Link() throws InterruptedException {
		webUtil.retryingFindClick(support_Link);
	}

	// Logout Link
	@FindBy(xpath = "//img[@class='logoutLogo']")
	private WebElement logoutLink;

	// Pop Up Dialog Box
	@FindBy(xpath = "//div[@class='swal2-modal swal2-show']")
	private WebElement popUp_DialogBox;

	// Pop Up Message Except in Home Page
	@FindBy(xpath = "//div[@class='swal2-content']")
	private WebElement popUp_Message_Text;

	// Yes Btn in Pop Up
	@FindBy(xpath = "//button[text()='Yes']") 
	private WebElement yes_Btn_In_PopUp;

	// Cancel Button In Pop Up
	@FindBy(xpath = "//button[@class='cancel']")
	private WebElement cancel_Btn_In_PopUp;

	// Logged In User Name Text
	@FindBy(xpath = "//span[@id='headSessionFirstName']")
	private WebElement loggedIn_UserName_Text;

	// Get User Role who has Logged In
	@FindBy(xpath = "//span[@id='headSessionRoleName']")
	private WebElement userRole_Text;

	// Get the Header Text of Page Navigate
	@FindBy(xpath = "//h3")
	private WebElement header_Text;

	// Dashboard Menu Link
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	private WebElement dashboard_Menu_Link;

	// Digital Kit Management Link
	@FindBy(xpath = "//span[contains(text(),'DX Card Management')]")
	private WebElement digitalKitManagement_Menu_Link;

	// Partner Management Link
	@FindBy(xpath = "//span[contains(text(),'Partner & Service Offering')]")
	private WebElement partnerManagement_Menu_Link;

	// Product management Menu link
	@FindBy(xpath = "//span[contains(text(),'Product Management')]")
	private WebElement productManagemnet_Menu_Link;

	// Service Request Menu Link
	@FindBy(xpath = "//span[contains(text(),'Service Request')]")
	private WebElement serviceRequest_Menu_Link;

	// Purchase Configuration Menu Link
	@FindBy(xpath = "//span[contains(text(),'Purchase Configuration')]")
	private WebElement purchaseConfiguration_Menu_Link;

	// Reports Menu Link
	@FindBy(xpath = "//span[text()='Reports']")
	private WebElement Reports_Menu_Link;

	// Digital Kits Link in Reports and Analytics
	@FindBy(xpath = "//a[contains(text(),'Digital Kits')]")
	private WebElement digitalKits_Link_In_ReportsAndAnalytics;

	// Customer Link in Reports and Analytics
	@FindBy(xpath = "//a[text()='Customer']")
	private WebElement customer_Link_In_ReportsAndAnalytics;

	// Customer Summary Report Link in Reports and Analytics
	@FindBy(xpath = "//a[text()='Customer Summary Report']")
	private WebElement customerSummaryReport_Link_In_ReportsAndAnalytics;

	// Campaign Manager Menu Link
	@FindBy(xpath = "//span[contains(text(),'Campaign Manager')]")
	private WebElement campaignManager_Menu_Link;

	// Privilege Management Menu Link
	@FindBy(xpath = "//span[contains(text(),'Privilege Management')]")
	private WebElement privilegeManagement_Menu_Link;

	// Settings Menu Link
	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	private WebElement settings_Menu_Link;
	
	// Configure Unique Code Link
	@FindBy(xpath = "//span[contains(text(),'Configure Uniquecode')]")
	private WebElement configureUniqueCode_Menu_Link;


	// + sign Link for adding
	@FindBy(xpath = "//img[@class='create']")
	private WebElement plus_Sign_Link_For_Adding;

	// Import Button
	@FindBy(xpath = "//input[@value='Import']")
	private WebElement import_Btn;

	// Import Link While Uploading Files
	@FindBy(xpath = "//input[@value='Import']")
	private WebElement import_link_After_Uplaoding;

	// Back Button in Importing
	@FindBy(xpath = "//div[@id='importModuleModal']/descendant::span[contains(text(),'Back')]")
	private WebElement back_Btn_While_Importing_File;

	// Back Button in Adding
	@FindBy(xpath = "//div[@id='addModuleModal']/descendant::span[contains(text(),'Back')]")
	private WebElement back_Btn_While_Adding;

	// Save Button in Adding
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement save_Btn_While_Adding;

	// Browse Btn
	//label[contains(text(),'Choose File:')]/following-sibling::div/input
	@FindBy(xpath = "//ui-label[label[contains(text(),'Select file')]]/following-sibling::div/ui-fileupload/span/span/i")
	private WebElement browse_Btn;

	// OK Button in Pop Up
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement ok_Btn;

	// Total No in Search Table List
	@FindBy(xpath = "//li[@class='ng2-smart-page-item page-item']/span")
	private WebElement totalNumber_Text;

	
	// Edit Image Link
	@FindBy(xpath = "//img[@class='edit']")
	private WebElement edit_Image_Link;

	// Delete Image Link
	@FindBy(xpath = "//img[@class='delete']")
	private WebElement delete_Image_Link;

	// Next Page Pagination Link
	@FindBy(xpath = "//i[@class='fa fa-chevron-right']")
	public WebElement nextPageLink;

	// No Data Found Text
	@FindBy(xpath = "//td[contains(text(),'No data found')]")
	private WebElement noDataFound_Text;
	
	// Attach Button Icon
	@FindBy(xpath="//input[@value='Attach File']")
	private WebElement attachFile_Button;
	
	// Click on fast Backward Page Pagination link
	@FindBy(xpath="//i[@class='fa fa-fast-backward']")
	private WebElement fast_Backward_Link;
	
	// Click on Help Center Configuration
	@FindBy(xpath = "//span[contains(text(),'Help Configuration')]")
	private WebElement helpCenterConf_Menu_Link;
	
	// Method to click on Attach Button link
	public void click_On_attachFile_Button() throws InterruptedException
	{
		webUtil.retryingFindClick(attachFile_Button);
	}

	// Method to get the text of noDataFound
	public String get_noDataFound_Text() {
		String text = webUtil.getTheTextFromUI(noDataFound_Text);
		return text;
	}
	

	// Product Discovery Link
	@FindBy(xpath="//span[contains(text(),'Product Discovery')]")
	private WebElement product_discovery_Link;
	public void click_On_product_discovery_Link() throws InterruptedException
	{
		webUtil.retryingFindClick(product_discovery_Link);
	}

	// Method to click on Delete Image Link
	public void click_delete_Image_Link() throws InterruptedException {
		if (delete_Image_Link.isDisplayed()) {
			webUtil.retryingFindClick(delete_Image_Link);
		}
	}

	// Method to click on Edit Image Link
	public void click_edit_Image_Link() throws InterruptedException {
		if (edit_Image_Link.isDisplayed()) {
			webUtil.retryingFindClick(edit_Image_Link);
		}
	}

	// Method to get the text of totalNumber
	public String get_totalNumber_Text() {
		String text = totalNumber_Text.getText();
		return text;
	}

	// Method to click on Ok Button in Pop Up
	public void click_ok_Btn() throws InterruptedException {
		if (ok_Btn.isDisplayed()) {
			webUtil.retryingFindClick(ok_Btn);
		}
	}
	
	
	

	// Back Button
	@FindBy(xpath = "//input[@value='Back']")
	private WebElement back_Btn;


	public void click_back_Btn() throws InterruptedException {
		if (back_Btn.isDisplayed()) {
			webUtil.retryingFindClick(back_Btn);
		}
	}


	// Product Recommendation Management Link
		@FindBy(xpath="//span[text()='Product Recommendation']")
		private WebElement product_Recomendation_Menu_Link;


		// Method to click on ProductRecommendation_Menu_Link
			public void click_productRecommendation_Menu_Link() throws InterruptedException {
				if (product_Recomendation_Menu_Link.isDisplayed()) {
					webUtil.retryingFindClick(product_Recomendation_Menu_Link);
				}
			}

			public boolean productRecommendationLinkDisplay() {
				boolean prdrcmndLnk =  product_Recomendation_Menu_Link.isDisplayed();
				if(prdrcmndLnk) {
					return prdrcmndLnk;
				}
				return false;
			}
	
	// Method to click browse Btn
	public void click_Browse_Btn() throws InterruptedException {
		if (browse_Btn.isDisplayed()) {
			webUtil.retryingFindClick(browse_Btn);
		}
	}

	// Method to click on Save Btn in adding
	public void click_On_Save_Btn_In_Adding() throws InterruptedException {
		if (save_Btn_While_Adding.isDisplayed()) {
			webUtil.retryingFindClick(save_Btn_While_Adding);
			Thread.sleep(5000);
		}
	}
	
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement save_Button;

	
	public void click_Save_Button() throws InterruptedException {
			webUtil.retryingFindClick(save_Button);
		}

	// Method to click on back_Btn_While_Adding
	public void click_back_Btn_While_Adding() throws InterruptedException {
		if (back_Btn_While_Adding.isDisplayed()) {
			webUtil.retryingFindClick(back_Btn_While_Adding);
		}
	}

	// Method to click on back_Btn_While_Importing_File
	public void click_back_Btn_While_Importing_File() throws InterruptedException {
		if (back_Btn_While_Importing_File.isDisplayed()) {
			webUtil.retryingFindClick(back_Btn_While_Importing_File);
		}
	}

	// Method to click on import_link after uploading
	public void click_import_link_After_Uplaoding() throws InterruptedException {
		if (import_link_After_Uplaoding.isDisplayed()) {
			Thread.sleep(500);
			webUtil.retryingFindClick(import_link_After_Uplaoding);
		}
	}

	// Method to click on import_Btn
	public void click_import_Btn() throws InterruptedException {
		if (import_Btn.isDisplayed()) {
			Thread.sleep(500);
			webUtil.retryingFindClick(import_Btn);
		}
	}

	// Method click on plus_Sign_Link_For_Adding
	public void click_plus_Sign_Link_For_Adding() throws InterruptedException {
		if (plus_Sign_Link_For_Adding.isDisplayed()) {
			webUtil.retryingFindClick(plus_Sign_Link_For_Adding);
		}
	}

	// Method to Click on Privilege Management Menu Link
	public void click_On_privilegeManagement_Menu_Link() throws InterruptedException {
		if (privilegeManagement_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(privilegeManagement_Menu_Link);
		}
	}

	// Method to click on settings_Menu_Link
	public void click_settings_Menu_Link() throws InterruptedException {
		if (settings_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(settings_Menu_Link);
		}
	}

	// Method to click on campaignManager_Menu_Link
	public void click_campaignManager_Menu_Link() throws InterruptedException {
		if (campaignManager_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(campaignManager_Menu_Link);
		}
	}

	public boolean campiagnManagerLinkDisplay() {
		boolean cmpnMngrLink =  campaignManager_Menu_Link.isDisplayed();
		if(cmpnMngrLink) {
			return cmpnMngrLink;
		}
		return false;
	}
	
	
	// Method to click on customerSummaryReport_Link_In_ReportsAndAnalytics
	public void click_customerSummaryReport_Link_In_ReportsAndAnalytics() throws InterruptedException {
		if (customerSummaryReport_Link_In_ReportsAndAnalytics.isDisplayed()) {
			webUtil.retryingFindClick(customerSummaryReport_Link_In_ReportsAndAnalytics);
		}
	}

	// Method to click on customer_Link_In_ReportsAndAnalytics
	public void click_customer_Link_In_ReportsAndAnalytics() throws InterruptedException {
		if (customer_Link_In_ReportsAndAnalytics.isDisplayed()) {
			webUtil.retryingFindClick(customer_Link_In_ReportsAndAnalytics);
		}
	}

	// Method to click on digitalKits_Link_In_ReportsAndAnalytics
	public void click_digitalKits_Link_In_ReportsAndAnalytics() throws InterruptedException {
		if (digitalKits_Link_In_ReportsAndAnalytics.isDisplayed()) {
			webUtil.retryingFindClick(digitalKits_Link_In_ReportsAndAnalytics);
		}
	}

	// Method to click on Reports link
	public void click_On_Reports_Menu_Link() throws InterruptedException {
		if (Reports_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(Reports_Menu_Link);
		}
	}

	
	// Click on Partner service offering link
	@FindBy(xpath="//span[text()='Partner & Service Offering']")
	private WebElement partnerServiceOffering_Link;
	public void click_On_Partner_ServiceOffering_Link() throws InterruptedException
	{
	webUtil.retryingFindClick(partnerServiceOffering_Link);
	}
	
	
	
	// Method to click on purchaseConfiguration_Menu_Link
	public void click_purchaseConfiguration_Menu_Link() throws InterruptedException {
		if (purchaseConfiguration_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(purchaseConfiguration_Menu_Link);
		}
	}

	// Method to click on serviceRequest_Menu_Link
	public void click_serviceRequest_Menu_Link() throws InterruptedException {
		if (serviceRequest_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(serviceRequest_Menu_Link);
		}
	}

	public boolean serviceRequestLinkDisplay() {
		boolean srvcrqLnk =  serviceRequest_Menu_Link.isDisplayed();
		if(srvcrqLnk) {
			return srvcrqLnk;
		}
		return false;
	}
	
	
	// Method to click on productManagemnet_Menu_Link
	public void click_productManagemnet_Menu_Link() throws InterruptedException {
		if (productManagemnet_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(productManagemnet_Menu_Link);
		}
	}
	
	public boolean productManagementLinkDisplay() {
		boolean prdmntLnk =  productManagemnet_Menu_Link.isDisplayed();
		if(prdmntLnk) {
			return prdmntLnk;
		}
		return false;
	}

	// Method to click on partnerManagement_Menu_Link
	public void click_partnerManagement_Menu_Link() throws InterruptedException {
		if (partnerManagement_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(partnerManagement_Menu_Link);
		}
	}

	public boolean partnerManagementLinkDisplay() {
		boolean prtnrLnk =  partnerManagement_Menu_Link.isDisplayed();
		if(prtnrLnk) {
			return prtnrLnk;
		}
		return false;
	}
	
	
	
	// Method to click on Digital Kit managemnt Link
	public void digitalKitManagement_Menu_Link() throws InterruptedException {
		if (digitalKitManagement_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(digitalKitManagement_Menu_Link);
		}

	}

	
	public boolean digitalKitManagementLinkDisplay() {
		boolean dkmntLnk = digitalKitManagement_Menu_Link.isDisplayed();
		if(dkmntLnk) {
			return dkmntLnk;
		}
		return false;
	}

	// Method to click on dashboard_Menu_Link
	public void dashboard_Menu_Link() throws InterruptedException {
		if (dashboard_Menu_Link.isDisplayed()) {
			webUtil.retryingFindClick(dashboard_Menu_Link);
		}
	}

	// Method to get the Header Text of all Pages
	public String get_header_Text() {
		String text = header_Text.getText();
		return text;
	}

	// Methods to get userRole_Text
	public String get_userRole_Text() throws InterruptedException {
		webUtil.explicitlyWait(userRole_Text);
		String text = userRole_Text.getText();
		return text;
	}

	// Methods to get the User Name Text
	public String get_loggedIn_UserName_Text() throws InterruptedException {
		webUtil.explicitlyWait(loggedIn_UserName_Text);
		String text = loggedIn_UserName_Text.getText();
		return text;
	}

	// Method to click on Cancel Btn in Pop Up
	public void click_On_cancel_Btn_In_PopUp() throws InterruptedException {
		if (cancel_Btn_In_PopUp.isDisplayed()) {
			webUtil.retryingFindClick(cancel_Btn_In_PopUp);
		}
	}

	// Method to click on Yes Btn in Pop Up
	public void click_On_yes_Btn_In_PopUp() throws InterruptedException {
		if (yes_Btn_In_PopUp.isDisplayed()) {
			webUtil.retryingFindClick(yes_Btn_In_PopUp);
		}
	}

	// Method to get the status of Pop Up
	public boolean get_popUp_DialogBox_Sts() {
		boolean sts = popUp_DialogBox.isDisplayed();
		return sts;
	}

	// Method to click on Logout Link
	public void Logout_Link() throws InterruptedException {
			webUtil.retryingFindClick(logoutLink);
	}
	
	public boolean sts_logout_Link()
	{
		boolean sts = logoutLink.isDisplayed();
		return sts;
	}

	// Methods to get the Pop Up Message Text
	public String get_PopUP_MessageText() {
		String text = popUp_Message_Text.getText();
		return text;
	}
	
	// Click on Next Link in Pagination
	public void click_On_nextPageLink() throws InterruptedException
	{
		webUtil.retryingFindClick(nextPageLink);
	}
	
	// Page Number Info Text
	@FindBy(xpath="//li[@class='pageInfoText']/span")
	private WebElement pageInfoText;
	
	public String getText_Of_pageInfoText()
	{
		String text=pageInfoText.getText();
		return text;
	}
	
	// Click on Fast Backward Page Pagination
	public void click_fast_Backward_Link() throws InterruptedException
	{
		webUtil.retryingFindClick(fast_Backward_Link);
	}
	
	// Click on Help center Configuration
	public void click_On_helpCenterConf_Menu_Link() throws InterruptedException
	{
		webUtil.retryingFindClick(helpCenterConf_Menu_Link);
	}
	
	public boolean helpConfigurationLinkDisplay() {
		boolean helpconfigLnk =  helpCenterConf_Menu_Link.isDisplayed();
		if(helpconfigLnk) {
			return helpconfigLnk;
		}
		return false;
	}
	
	public void click_On_configureUniqueCode_Menu_Link() throws InterruptedException
	{
		webUtil.retryingFindClick(configureUniqueCode_Menu_Link);
	}
	
	public boolean configureUniqueCodeLinkDisplay() {
		boolean cnfgrUnqLnk =  productManagemnet_Menu_Link.isDisplayed();
		if(cnfgrUnqLnk) {
			return cnfgrUnqLnk;
		}
		return false;
	}
	
	// Click on Account set up link
	@FindBy(xpath="//a[contains(text(),'Account Setup')]")
	private WebElement accountSetUp_Link;
	public void click_On_accountSetUp_Link() throws InterruptedException
	{
		webUtil.retryingFindClick(accountSetUp_Link);
	}
	
	// Click on Service Offering Link in setting
	@FindBy(xpath="//a[contains(text(),'Service Offerings')]")
	private WebElement serviceOffering_Link;
	public void click_On_serviceOffering_Link() throws InterruptedException
	{
		webUtil.retryingFindClick(serviceOffering_Link);
	}
		

	// Product Approval Link
	@FindBy(xpath="//span[text()='Product Approval']")
	private WebElement productApproval;
	// Method to click on Product Approval link
	public void click_Product_Approval() throws InterruptedException {
	if(productApproval.isDisplayed()) {
	webUtil.retryingFindClick(productApproval);
	}
	}
	
	
	// Click On Product Approval Menu Link
	@FindBy(xpath="//span[contains(text(),'Product Approval')]")
	private WebElement productApproval_Link;
	public void click_on_ProductApproval_Link() throws InterruptedException
	{
		webUtil.retryingFindClick(productApproval_Link);
	}
	
	
}
