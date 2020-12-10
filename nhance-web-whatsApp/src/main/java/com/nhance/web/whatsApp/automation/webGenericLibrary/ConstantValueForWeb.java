package com.nhance.web.whatsApp.automation.webGenericLibrary;

import com.nhance.web.whatsApp.automation.webBusinessLibrary.BusinessFunctionWebSpecific;


public interface ConstantValueForWeb {

	// Report Related File Path 
    String FILEPATH_FOR_INPUT = "filepath_for_input";
	String FILEPATH_FOR_OUTPUT = "filepath_for_output";
	String FILEPATH_FOR_CMDLog = "filepath_for_cmdlog";
	String BATFILEPATH_FOR_GENERATE_ALLURE_REPORT = "batfilepath_for_generate_allure_report";
	String BATFILEPATH_FOR_DELETING_CMDLOG_FILE="batfilepath_for_deleting_cmdlog_file";
	String BATFILEPATH_FOR_ALLURE_REPORT_UPLOADING="batfilepath_for_allure_report_uploading";
	
	///  SMTP Properties File Location
	String SMTP_PROPERTIES_FILE_LOC = "smtp_properties_file_loc";

	/// Confirm Email URL from Local System
	String CONFIRM_EMAIL_URL_FROM_SYSTEM = "confirm_Email_URL_from_System";
	
	// Path of HTML page for Email Content to be fetched
	
	String HTMLPAGE_EMAILCONTENT_PATH ="htmlpage_emailcontent_path";
	String HTMLPAGE_OTP_CONTENT_IN_EMAIL_PATH ="htmlpage_otp_content_in_email_path";

	// *** DATE AND TIME CONSTANT ***////

	String dateFormat = "dd-MM-yyyy";
	String date = BusinessFunctionWebSpecific.systemCurrentDate(dateFormat);
	String timeFormat = "HH.mm.ss";
	String currentTime = BusinessFunctionWebSpecific.getCurrentTime(timeFormat);
	
	// SFTP URL
	static String sftp_URL = "https://qa.nhancenow.com/nhance/test/";

	// Remote Base Directory
	String remote_Base_Dir = "/var/www/html/nhance/test/";
	
	// DB URL
	String QA_DB_URL = "qa_db_url";
	String DEV_DB_URL = "dev_db_url";
	String STAGING_DB_URL ="staging_db_url";

	// NHANCE URL LINK
	String NHANCE_URL_FOR_WHATSAPP_WEB = "https://web.whatsapp.com/";
	String NHANCE_URL_FOR_DEV_SERVER = "nhance_url_for_dev_server";
	String NHANCE_URL_FOR_STAGING_SERVER = "nhance_url_for_staging_server";
	String NHANCE_URL_FOR_PRODUCTION = "nhance_url_for_production";
	
	// EXCEL TEST DATA for Brand FILE LOCATION
	String NHANCE_WEB_TESTDATA_EXCEL_FILE_LOC = "nhance_web_testdata_excel_file_loc";
	String NHANCE_WEB_TESTDATA_EXCEL_MESSENGER_FILE_LOC = "nhance_web_testdata_excel_messenger_file_loc";
	String Excel_File_Path_For_WhatsappWeb = "D://Nhance Automation workspace//excel files//WhatsappWeb Workbook.xlsx";
	
	// SHEET NAME FOR EXCEL FILE For whatsappWeb (Sujaya is using)
	String COMMON_TESTDATA_SHEETNAME = "CommonPage_TestData";
	String SELFSERVICE_TESTDATA_SHEETNAME = "SelfService_TestData";
	String HELPDESK_TESTDATA_SHEETNAME = "Helpdesk_TestData";
	String BUY_TESTDATA_SHEETNAME = "Buy_TestData";
	String Inbox_TESTDATA_SHEETNAME = "Inbox_Testdata";
	String About_TESTDATA_SHEETNAME = "About_TestData";
	String WHATSAPPME_TESTDATA_SHEETNAME = "WhatsappMe_TestData";
	String ANSWERBOT_TESTDATA_SHEETNAME = "AnswerBot_TestData";


	
	// SHEET NAME For BRAND 
	String SHEETNAME_FOR_BROWSER_OPENING="sheetname_for_browser_opening";
	String SHEETNAME_FOR_LOGIN_CREDENTIAL = "sheetname_for_login_credential";
	String SHEETNAME_FOR_MESSENGER_NLP = "sheetname_for_messenger_nlp";
	
	
	// Report for Sheetnames of downloaded ones
	
	String SHEETNAME_FOR_CONSUMER_DETAILS_REPORT = "sheetname_for_consumer_details_report";
	
	
	
	
	// Report URL SHEETNAME
	String SHEETNAME_FOR_FINAL_REPORT_URL="sheetname_for_final_report_url";
	
	// Excel Test data for SuperUser file location
	String NHANCE_SUPERUSER_TESTDATA_EXCEL_FILE_LOCATION = "nhance_superuser_testdata_excel_file_location";
	
	// Sheet Name for SuperUser
	String SHEETNAME_FOR_CUSTOMER_ONBOARDING = "sheetname_for_customer_onboarding";
	String SHEETNAME_FOR_REFERAL_MANAGEMENT = "sheetname_for_referral_management";
	String SHEETNAME_FOR_LOGIN_SUPERUSER="sheetname_for_login_superuser";
	String SHEETNAME_FOR_CATEGORIES = "sheetname_for_categories";
	String SHEETNAME_FOR_SMARTNOTIFICATION = "sheetname_for_smartnotification";
	String SHEETNAME_FOR_CARDCONFIGURATION = "sheetname_for_cardconfiguration";
	
	// SHEET NAME
	String SHEETNAME_FOR_UNIQUECONSUMER_MOBILENUMBER="sheetname_for_uniqueconsumer_mobilenumber";

	// BULK UPLOAD EXCEL FILE LOCATION

	// Bulk Upload Directory Location
	String BulkUpload_Dir = "C:\\Users\\Sudhanshu\\Desktop\\BulkUpload File\\";

	// Product Bulk Upload Excel FIle Location only with Mandatory field
	String PRODUCT_WITH_MANDATORY_FIELD_BULK_UPLOAD_EXCEL_FILE_LOC = "product_with_mandatory_field_bulk_upload_excel_file_loc";
	String SHEETNAME_FOR_PRODUCT_WITH_MANDATORY_FIELD_BULKUPLOAD_EXCEL = "sheetname_for_product_with_mandatory_field_bulkupload_excel";
	
	// Product Bulk Upload Excel FIle Location only with Mandatory field
	String PRODUCT_BULK_WITH_ALL_FIELD_BULK_UPLOAD_EXCEL_FILE_LOC = "product_bulk_with_all_field_bulk_upload_excel_file_loc";
	String SHEETNAME_FOR_PRODUCT_WITH_ALL_FIELD_BULKUPLOAD_EXCEL = "sheetname_for_product_with_all_field_bulkupload_excel";
	
	
	// DK Bulk Upload Excel File Location only with Mandatory field
	String DK_WITH_MANDATORY_FIELD_BULK_UPLOAD_EXCEL_FILE_LOC = "dk_with_mandatory_field_bulk_upload_excel_file_loc";
	String SHEETNAME_FOR_DK_WITH_MANDATORY_FIELD_BULKUPLOAD_EXCEL = "sheetname_for_dk_with_mandatory_field_bulkupload_excel";
	
	// DK Bulk Upload Excel FIle Location only with Mandatory field
	String DK_BULK_WITH_ALL_FIELD_BULK_UPLOAD_EXCEL_FILE_LOC = "dk_bulk_with_all_field_bulk_upload_excel_file_loc";
	String SHEETNAME_FOR_DK_WITH_ALL_FIELD_BULKUPLOAD_EXCEL = "sheetname_for_dk_with_all_field_bulkupload_excel";

	// Partner Bulk Upload Excel File Location
	String PARTNER_BULK_UPLOAD_FILE_LOC = "partner_bulk_upload_file_loc";
	String SHEETNAME_FOR_PARTNER_BULKUPLOAD_EXCEL = "sheetname_for_partner_bulkupload_excel";
	
	// Acessory Bulk Upload Excel File Location
	String ACCESSORY_BULK_UPLOAD_EXCEL_FILE_LOC ="accessory_bulk_upload_excel_file_loc";
	String SHEETNAME_FOR_ACCESSORY_BULKUPLOAD_EXCEL = "sheetname_for_accessory_bulkupload_excel";

	// DK Code Bulk Upload CSV File Location
	String DK_CODE_BULK_UPLOAD_EXCEL_FILE_LOC = "dk_code_bulk_upload_excel_file_loc";
	String SHEETNAME_FOR_DK_SERIALNUMBER_BULKUPLOAD_EXCEL ="sheetname_for_dk_serialnumber_bulkupload_excel";

	
	// ***************************** BULK UPLOAD
	// *******************************************************//
	// BULK UPLOAD .EXE FILE LOCATION

	// For Add Product with All field
	String ADDPRODUCT_WITH_ALL_FIELD_BULKUPLOAD_FILE_LOC = "addproduct_with_all_field_bulkupload_file_loc";
	
	// For Add Product With Mandatory Field
	String ADDPRODUCT_WITH_MANDATORY_FIELD_BULKUPLOAD_FILE_LOC = "addproduct_with_mandatory_field_bulkupload_file_loc";
	
	
	// DK .exe bulk upload file for Mandatory field Data
	String DK_WITH_MANDATORY_FIELD_BULKUPLOAD_FILE_LOC = "dk_with_mandatory_field_bulkupload_file_loc";
	
	// DK .exe bulk upload file for Mandatory field Data
	String DK_WITH_ALL_FIELD_BULKUPLOAD_FILE_LOC = "dk_with_all_field_bulkupload_file_loc";
	
	// For Adding Partner
	String ADDPARTNER_BULKUPLOAD_FILE_LOC = "addpartner_bulkupload_file_loc";

	// PRODUCT IMAGE UPLOAD FILE LOCATION
	String IMAGE_UPLOAD_FILE_LOC = "partner_logo_upload_file_loc";
	

	// PARTNER LOGO IMAGE UPLOAD FILE LOCATION
	String PARTNER_LOGO_UPLOAD_FILE_LOC = "partner_logo_upload_file_loc";

	// Acessory Upload File Location
	String ACCESSORY_UPLOAD_FILE_LOC = "accessory_upload_file_loc";
	
	// Invoice Attach File Path In DK
	String INVOICEATTACHFILEPATH = "invoiceattachfilepath";
	String WARRANTYCARD_ATTACH_FILE_PATH="warrantycard_attach_file_path";
	// Manual Docs Attach File Path in Product On boarding Master Data Mapping
	String DOCS_ATTACHFILEPATH = "docs_attachfilepath";
	
	// Partner Logo Attached File Path in Partner Management
	String PARTNERLOGO_ATTACH_FILE_PATH="brandlogo_path_file_to_attach";
	
	// Brand Logo Attached File Path in Customer Management
	String BRANDLOGO_PATH_FILE_TO_ATTACH="brandlogo_path_file_to_attach";
	String BRANDLOGO_EDIT_PATH_FILE_TO_ATTACH="brandlogo_edit_path_file_to_attach";
	
	// Product Image Attached File Path in Product Management
	String PRODUCT_IMAGE_PATH_FILE_TO_ATTACH= "product_image_path_file_to_attach";
	
	
	// NEO4J QUERY USED IN PROJECT
	String QUERY_TO_DELETE_CONSUMER = "query_to_delete_consumer";
	String QUERY_TO_FETCH_THE_CONSUMER_GUID_FOR_DELETE = "query_to_fetch_the_consumer_guid_for_delete";
	String QUERY_TO_DELETE_THE_CONSUMER_GUID = "query_to_delete_the_consumer_guid";
	String QUERY_FOR_FETCHING_THE_CONSUMER_GUID_FOR_FRESH_ISSUEDK = "query_for_fetching_the_consumer_guid_for_fresh_issuedk";
	String QUERY_FOR_FETCHING_LATEST_DK_CODE = "query_for_fetching_latest_dk_code";
	String QUERY_FOR_FETCHING_LATEST_SRN_ID = "query_for_fetching_latest_srn_id";
	
	// DRIVER PATH FOR IE ,GeckoDriver And CHROME
	String CHROME_DRIVER_LOCATION = "D:\\Nhance Automation workspace\\nhance-web-whatsApp\\src\\main\\resources\\BrowserDriver\\chromedriver.exe";
	String IE_DRIVER_LOCATION = "ie_driver_loc";
	String GECKO_DRIVER_LOCATION = "D:\\Nhance_Automation_Workspace\\nhance-web-whatsApp\\src\\main\\resources\\BrowserDriver\\geckodriver.exe";
	
	// download file storage:
	
	String userPath = "D:\\Nhance_Automation_Workspace\\github\\nhance-automation-qa-web\\src\\main\\resources\\PropertiesFiles";
	
	

}
