package com.nhance.web.whatsApp.automation.webBusinessLibrary;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.nhance.web.whatsApp.automation.userPageFactory.CustomerAdminCommonWebElementInAllPage;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ConstantValueForWeb;
import com.nhance.web.whatsApp.automation.webGenericLibrary.Testlistener;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

import io.qameta.allure.Step;

/**
 * 
 */
/**
 * @author Manmohan
 *
 */

public class BusinessFunctionWebSpecific extends WebDriverIgnit {

	WebDriverCommonUtill webCmnUtil = new WebDriverCommonUtill();
	static boolean r1;
	static String linkedCliked;
	CustomerAdminCommonWebElementInAllPage cmnWebElmnt ;
	public static int i;
	public String[] onlyDynamicPageNumber;
	String actualpopUpMessgaeText;
	static int largest_Slab;
	String inlineSearchText;
    String actualMmessageCapturedAfterDeleteProduct;
    String popUpMessage;
    String currentTime;
    List<String> actualRowDetails = new ArrayList<>();
    List<String> listOfAllCellValueFromExcel;
    List<WebElement> listOfValuesInRow;
	
	@Step("Login Step With Email Id : {0}, Password : {1}, for method : {method} step...")
	public void login_For_NhanceAngular_Web(String emailIdFromExcel, String passwordFromExcel)
			throws InterruptedException {
	}

	public void logOut_Application() throws InterruptedException {
		cmnWebElmnt = new CustomerAdminCommonWebElementInAllPage(driver);
		cmnWebElmnt.Logout_Link();
		Thread.sleep(1000);
		String actualpopUpMessgaeText = cmnWebElmnt.get_PopUP_MessageText();
		Testlistener.log("The Message appear in Pop Up Box after clicking on Logout Image : " + actualpopUpMessgaeText);
		cmnWebElmnt.click_On_yes_Btn_In_PopUp();
		Thread.sleep(1500);
	}

	public String click_On_OK_BUtton_And_CaptureThe_POPUpMessage(String HardcoadedexpectedPoPUpMessage)
			throws InterruptedException {
		// Nhance system exception thrown.
		cmnWebElmnt = new CustomerAdminCommonWebElementInAllPage(driver);
		boolean sts = cmnWebElmnt.get_popUp_DialogBox_Sts();
		Testlistener.log("The Pop Up Box is Displayed after clicking on Save Button : " + sts);
		String expectedPopUpMessageText = HardcoadedexpectedPoPUpMessage;
		actualpopUpMessgaeText = cmnWebElmnt.get_PopUP_MessageText();
		webCmnUtil.compareString(expectedPopUpMessageText,actualpopUpMessgaeText);
		Testlistener.log("Assertion Completed....FOR POP UP MESSAGE---->");
		cmnWebElmnt.click_ok_Btn();
		Thread.sleep(3000);
		webCmnUtil.implicitWait();
		Testlistener.log("Clicked on OK button in Sucess POP UP....");
		return actualpopUpMessgaeText;
	}
	
	public String click_on_YES_Button_And_Capture_ThePOPUpMessage(String HardcoadedexpectedPoPUpMessage) throws InterruptedException
	{
		cmnWebElmnt = new CustomerAdminCommonWebElementInAllPage(driver);
		boolean sts = cmnWebElmnt.get_popUp_DialogBox_Sts();
		Testlistener.log("The Pop Up Box is Displayed after clicking on delete Button : " + sts);
		System.out.println("The Pop Up Box is Displayed after clicking on delete Button : " + sts);
		String expectedPopUpMessageText = HardcoadedexpectedPoPUpMessage;//"Sure you want to delete?";
		String actualpopUpMessgaeText = cmnWebElmnt.get_PopUP_MessageText();
		Assert.assertEquals(actualpopUpMessgaeText, expectedPopUpMessageText);
		Testlistener.log("Assertion Completed....The Message in Pop Up Box : " + actualpopUpMessgaeText);
		System.out.println("Assertion Completed....The Message in Pop Up Box : " + actualpopUpMessgaeText);
		cmnWebElmnt.click_On_yes_Btn_In_PopUp();
		Thread.sleep(2000);
		webCmnUtil.implicitWait();
		//Thread.sleep(5000);
		return actualpopUpMessgaeText;
	}
	
	public String click_on_OK_Button_In_DK_Delete_And_Capture_ThePOPUpMessage(String HardcoadedexpectedPoPUpMessage) throws InterruptedException
	{
		cmnWebElmnt = new CustomerAdminCommonWebElementInAllPage(driver);
		boolean sts = cmnWebElmnt.get_popUp_DialogBox_Sts();
		Testlistener.log("The Pop Up Box is Displayed after clicking on delete Button : " + sts);
		String expectedPopUpMessageText = HardcoadedexpectedPoPUpMessage;//"Sure you want to delete?";
		String actualpopUpMessgaeText = driver.findElement(By.xpath("//h2")).getText();;
		Assert.assertEquals(actualpopUpMessgaeText, expectedPopUpMessageText);
		Testlistener.log("Assertion Completed....The Message in Pop Up Box : " + actualpopUpMessgaeText);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		webCmnUtil.implicitWait();
		//Thread.sleep(5000);
		return actualpopUpMessgaeText;
	}

	public static String scrnsht(WebDriver driver, String ScreenShotName) throws IOException {
		// String remoteBaseDir = "/var/www/html/nhance/test/";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String screenshot = ScreenShotName + "_" + ConstantValueForWeb.currentTime + ".png";
			String Dest_Path = "D:\\CoreWallet_WorkSpace\\MavenNhanceBrandAdminProject\\src\\main\\java\\Screenshot\\"
					+ screenshot;
			File destination = new File(Dest_Path);
			FileUtils.copyFile(source, destination);
			System.out.println("ScreenShot Taken");

			// Upload this file to sftp location
			// sftp code goes here
			// -------------------------------------

			String completeFileLoc = ConstantValueForWeb.sftp_URL + screenshot;
			// writeToSftp(Dest_Path,Constant_Value.remote_Base_Dir);

			// -------------------------------------
			return completeFileLoc;
		} catch (Exception e) {
			System.out.println("Exception while taking ScreenShot" + e.getMessage());
			return e.getMessage();
		}

	}

	// Write FTP nd Capture Screenshot
	/*
	 * private static void writeToSftp(String sourcePath, String remoteBaseDir)
	 * { try { JSch jsch = new JSch(); Session session = jsch.getSession(
	 * "nhanceios", "qa.nhancenow.com", 2200 ); session.setConfig(
	 * "PreferredAuthentications", "password" ); session.setPassword(
	 * "jim!@34sim" ); java.util.Properties config = new java.util.Properties();
	 * config.put("StrictHostKeyChecking", "no");//do not prefer this. demo only
	 * session.setConfig(config); session.connect( 3600 ); Channel channel =
	 * session.openChannel( "sftp" ); ChannelSftp sftp = ( ChannelSftp )
	 * channel; sftp.connect( 600 ); channel = session.openChannel("sftp");
	 * channel.connect(); try { sftp.put(sourcePath, remoteBaseDir); } catch
	 * (Exception e) { e.printStackTrace(); } channel.disconnect();
	 * sftp.disconnect(); } catch (JSchException e) { e.printStackTrace(); } }
	 */

	public String  timeSetForNotifications(String timeFormat) {

		currentTime = getCurrentTime("HH:mm");
		int minutes = ((currentTime.charAt(0) - '0') * 10 + currentTime.charAt(1) - '0') * 60
				+ ((currentTime.charAt(3) - '0') * 10 + currentTime.charAt(4) - '0');
		int newMin = 02;
		minutes += newMin;
		int hour = (minutes / 60) % 24;
		System.out.println("Hour is " + hour);
		int min = minutes % 60;
		System.out.println("Minute is " + min);
		// Print the hour in appropriate format
	System.out.println("The time taken from system is ");
	
		if (hour < 10) {
			System.out.print("0" + hour + ":");
		} else {
			System.out.print(hour + ":");
		}
		if (min < 10) {
			System.out.println("0" + min);
		} else {
			System.out.println(min);
		}
		
		return timeFormat;
	
	}
		
	/*	{
		currentTime = getCurrentTime("HH:mm");
		 String[] time = currentTime.split ( ":" );
		   int hour = (Integer.parseInt ( time[0].trim()));
		   int min = Integer.parseInt ( time[1].trim() );
		   String newMin = "02";
		   int n = (min + Integer.parseInt(newMin));
		   System.out.println("n is "+ n);
		   String LatestTime = (Integer.toString(hour) + ":"+Integer.toString(n));
		   
	    System.out.println("The time taken from system is "+ LatestTime);
	    return LatestTime;
	}*/
	
	public String timeSetForOffers(String timeFormat) {
		currentTime = getCurrentTime("HH:mm");
		 String[] time = currentTime.split ( ":" );
		   int hour = (Integer.parseInt ( time[0].trim()));
		   int min = Integer.parseInt ( time[1].trim() );
		   String newMin = "02";
		   int n = (min + Integer.parseInt(newMin))%60;
		   System.out.println("n is "+ n);
		   String LatestTime = (Integer.toString(hour) + ":"+Integer.toString(n));
		   
	    System.out.println("The time taken from system is "+ LatestTime);
	    return LatestTime;
	}
	
	
	
	public static String systemCurrentDate(String dateFormatFromExcel) {
		DateFormat dateFormat = new SimpleDateFormat(dateFormatFromExcel);
		Date date = new Date();
		String sysDate = dateFormat.format(date);
		System.out.println("Current Date Taken From System " + sysDate);
		return sysDate;
	}

	public static String getCurrentTime(String timeFormat) {
		// "HH.mm.ss"
		SimpleDateFormat time_formatter = new SimpleDateFormat(timeFormat);
		String current_time_str = time_formatter.format(System.currentTimeMillis());
		System.out.println("The current time is "+current_time_str);
		return current_time_str;
	}
	
	

	public void scrollingUp() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i = 0; i < 1; i++) {
			jse.executeScript("window.scrollBy(0,-250)", "");
			Thread.sleep(1500);
		}
	}

	public void scrollingDown() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i = 0; i < 2; i++) {
			jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(1500);
		}
	}

	public int list_Of_Product_InDropDown(String productTypeNameFromExcel, List<WebElement> listOfWebElement) {
		int size = listOfWebElement.size();
		for (int i = 0; i < size; i++) {
			String productTypeName = listOfWebElement.get(i).getText();
			if (productTypeNameFromExcel.trim().equals(productTypeName.trim())) {
				listOfWebElement.get(i).click();
			}
		}
		return size;
	}

	public String operate_Particular_Link_From_Table(String TextFromExcel, List<WebElement> listOFTextFromTable,
			List<WebElement> listOf_ViewLink_From_Table, WebElement nextPaginationLink) {
		System.out.println("The Value of r1 at Intial= " + r1);
		while (!r1) {
			try {
				for (int i = 0; i < listOFTextFromTable.size(); i++) {
					System.out.println(listOFTextFromTable.get(i).getText());
					try {
						if (listOFTextFromTable.get(i).getText().trim().equals(TextFromExcel.trim())) {
							r1 = true;
							Thread.sleep(500);
							linkedCliked = listOFTextFromTable.get(i).getText();
							webCmnUtil.retryingFindClick(listOf_ViewLink_From_Table.get(i));
							Thread.sleep(500);
							break;
						}
					} catch (Exception e) {
						System.out.println("Catch part is runnning in if loopp..........." + e.getMessage());
						break;
					}
				}
				try {
					if (r1 == false) {
						webCmnUtil.retryingFindClick(nextPaginationLink);
						Thread.sleep(500);
					} else {
						break;
					}
				} catch (Exception e) {
					System.out.println("There is no Next Btn Link Available");
					break;
				}

			} catch (Exception e1) {
				System.out.println("Catch part is running inside Main Try....................." + e1.getMessage());
				break;
			}
			continue;
		}

		r1 = false;
		return linkedCliked;

	}

	public void mandatory_Field_Validation(WebElement elementToCLick) {
		elementToCLick.click();
		webCmnUtil.implicitWait();

		List<WebElement> listOFallRequiredText = driver
				.findElements(By.xpath("//div[contains(text(),'This field is required.')]"));
		int totalRequiredTextSize = listOFallRequiredText.size();
		System.out.println("Total Number of Mandatory Field is = " + totalRequiredTextSize);

		List<WebElement> listOFAllWebElement = driver
				.findElements(By.xpath("//div[@class='panel-body']/descendant::label"));
		int totalWebElementSize = listOFAllWebElement.size();
		System.out.println("Total Number of label Present Inside The Module is = " + totalWebElementSize);

		int totalNonRequiredFieldSize = totalWebElementSize - totalRequiredTextSize;
		System.out.println("Total Number of Non Required Field Count are=" + totalNonRequiredFieldSize);

		for (int i = 0; i < totalRequiredTextSize; i++) {
			String listofRequiredFieldText = listOFallRequiredText.get(i).getText();
			try {
				List<WebElement> dropDownRequiredFieldLbelXpath = driver.findElements(By.xpath(
						"// div[span[div[contains(text(),'This field is required.')]]]/preceding-sibling::label"));
				String dropDownRequiredFieldLbel = dropDownRequiredFieldLbelXpath.get(i).getText();
				System.out.println(dropDownRequiredFieldLbel + "=============> " + listofRequiredFieldText);

			} catch (Exception e) {

			}

			try {

				List<WebElement> EditBoxRequiredFieldLbelXpath = driver.findElements(By
						.xpath("//div[div[div[contains(text(),'This field is required')]]]/preceding-sibling::label"));
				String EditBoxRequiredFieldLbel = EditBoxRequiredFieldLbelXpath.get(i).getText();
				System.out.println(EditBoxRequiredFieldLbel + "=============>" + listofRequiredFieldText);

			} catch (Exception e) {

			}

			try {

				List<WebElement> MobileNumberRequiredFieldLbelXpath = driver.findElements(By.xpath(
						"//div[div[div[div[contains(text(),'This field is required.')]]]]/preceding-sibling::label"));
				String MobileNumberRequiredFieldLbel = MobileNumberRequiredFieldLbelXpath.get(i).getText();
				System.out.println(MobileNumberRequiredFieldLbel + "=============>" + listofRequiredFieldText);

			} catch (Exception e) {

			}

		}

	}

	public int getThe_ExpectedCount_Of_Particular_Row_In_Table(List<WebElement> element, String valueFromExcel)
			throws InterruptedException {
		Testlistener.log("The Value of r1 at Intial= " + r1);
		int count = 0;
		while (!r1) {
			try {
				for (i = 0; i < element.size(); i++) {
					//Testlistener.log(element.get(i).getText());
					//try {
						if (element.get(i).getText().trim().equals(valueFromExcel.trim())) {
							//Thread.sleep(500);
							count++;
						} else {
							continue;
						}
					/*} catch (Exception e) {
					}*/
				}
				//try {
					if (i == 10) {
						cmnWebElmnt = new CustomerAdminCommonWebElementInAllPage(driver);
						cmnWebElmnt.click_On_nextPageLink();
						i = 0;
						continue;
					}
				//} catch (Exception e) {
					else
					{
					Testlistener.log(
							"Exception Caught while cliking on Next Button..May be the button is disabled..and its the ending page");
					}
				//}

			} catch (Exception e1) {
				Testlistener.log("Catch part is running inside Main Try....................." + e1.getMessage());
			}

			try {
				String pageText = cmnWebElmnt.getText_Of_pageInfoText();
				String dynamicPageNumber = pageText.replaceAll("Page ", "");
				System.out.println("dynamicPageNumber is : " + dynamicPageNumber);
				onlyDynamicPageNumber = dynamicPageNumber.split("of");
				System.out.println("onlyDynamicPageNumber is : " + onlyDynamicPageNumber[0].trim());
				System.out.println("The Constant Page Number is : " + onlyDynamicPageNumber[1].trim());
				if (onlyDynamicPageNumber[0].trim().equals(onlyDynamicPageNumber[1].trim())) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Exception Caught because there is no more Page...");
				break;
			}
		}
		try{
		cmnWebElmnt.click_fast_Backward_Link();
		Thread.sleep(1000);
		}catch (Exception e) {
			System.out.println("There is no fast forward Option image...");
		}
		r1 = false;
		return count;
	}
	
	// Method to get the Total Count Number In View Page in Integer
	public int totalCount_In_ViewPage()
	{	
	cmnWebElmnt = new CustomerAdminCommonWebElementInAllPage(driver);
	String totalCountSize =cmnWebElmnt.get_totalNumber_Text();
	String Total_Count_In_String = totalCountSize.replaceAll("Total : ", "");
	int totalCount_In_Integer=Integer.parseInt(Total_Count_In_String.trim());
	return totalCount_In_Integer;
	}
	
	// Method to get the Total Count Number In View Page in Integer
	public String totalCount_In_ViewPage_In_String()
	{	
	cmnWebElmnt = new CustomerAdminCommonWebElementInAllPage(driver);
	String totalCountSize =cmnWebElmnt.get_totalNumber_Text();
	String Total_Count_In_String = totalCountSize.replaceAll("Total : ", "");
	return Total_Count_In_String;
	}
	
	
	public void click_on_Country_Flag_Icon_For_ContactNumber_In_CustomerManagement(String countryName) throws InterruptedException
	{
		/*cmnWebElmnt = new CustomerAdminCommonWebElementInAllPage(driver);
		Thread.sleep(1000);
		cmnWebElmnt.click_On_arrowMark_On_FlagIcon();
		webCmnUtil.implicitWait();
		List<WebElement> listOFCountryName= cmnWebElmnt.listOfCountryName;*/
		
		driver.findElement(By.xpath("//ui-label[label[contains(text(),'Contact Number')]]/following-sibling::div/descendant::div[@class='iti-arrow']")).click();
		Thread.sleep(1000);
		List<WebElement> listOFCountryName=driver.findElements(By.xpath("//ul[@class='country-list dropdown-menu']/li/span[@class='country-name']"));
		for(int i=0;i<listOFCountryName.size();i++)
		{
			if(listOFCountryName.get(i).getText().trim().contains(countryName.trim()))
			{
				listOFCountryName.get(i).click();
				break;
			}
		}
	}
	
	public void click_on_Country_Flag_Icon_For_HelpdeskNumber_In_CustomerManagement(String countryName) throws InterruptedException
	{
		driver.findElement(By.xpath("//ui-label[label[contains(text(),'Helpdesk Number')]]/following-sibling::div/descendant::div[@class='iti-arrow']")).click();
		Thread.sleep(1000);
		List<WebElement> listOFCountryCode=driver.findElements(By.xpath("//ul[@class='country-list dropdown-menu']/li/span[@class='country-name']"));
		for(int i=0;i<listOFCountryCode.size();i++)
		{
			if(listOFCountryCode.get(i).getText().trim().contains(countryName.trim()))
			{
				listOFCountryCode.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
	}
	
	
	public void click_on_Country_Flag_Icon_For_ContactNumber_In_Forgpassowrd(String countryName) throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[@class='iti-arrow']")).click();
		Thread.sleep(1000);
		List<WebElement> listOFCountryName=driver.findElements(By.xpath("//ul[@class='country-list dropdown-menu show']/li/span[@class='country-name']"));
		for(int i=0;i<listOFCountryName.size();i++)
		{
			if(listOFCountryName.get(i).getText().trim().contains(countryName.trim()))
			{
				listOFCountryName.get(i).click();
				break;
			}
		}
	}
	
	public void click_on_Country_Flag_Icon_For_ContactNumber(String countryName) throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[@class='iti-arrow']")).click();
		Thread.sleep(1000);
		List<WebElement> listOFCountryName=driver.findElements(By.xpath("//ul[@class='country-list dropdown-menu']/li/span[@class='country-name']"));
		for(int i=0;i<listOFCountryName.size();i++)
		{
			if(listOFCountryName.get(i).getText().trim().contains(countryName.trim()))
			{
				listOFCountryName.get(i).click();
				break;
			}
		}
		
		
		/*cmnWebElmnt = new CustomerAdminCommonWebElementInAllPage(driver);
		Thread.sleep(1000);
		cmnWebElmnt.click_On_arrowMark_On_FlagIcon();
		webCmnUtil.implicitWait();
		List<WebElement> listOFCountryName= cmnWebElmnt.listOfCountryName;
		for(int i=0;i<listOFCountryName.size();i++)
		{
			if(listOFCountryName.get(i).getText().trim().contains(countryName.trim()))
			{
				listOFCountryName.get(i).click();
				break;
			}
		}*/
	}

	/*public void edit_Click_on_Country_Flag_Icon_For_HelpdeskNumber(String countryName) throws InterruptedException
	{
		driver.findElement(By.xpath("//ui-label[label[contains(text(),'Helpdesk Number')]]/following-sibling::div/descendant::div[@class='iti-arrow']")).click();
		Thread.sleep(1000);
		List<WebElement> listOFCountryCode=driver.findElements(By.xpath("//ul[@class='country-list dropdown-menu']/li/span[@class='country-name']"));
		for(int i=0;i<listOFCountryCode.size();i++)
		{
			if(listOFCountryCode.get(i).getText().trim().equals(countryName.trim()))
			{
				listOFCountryCode.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
	}
*/
	
	
	public int  largestSlab(String slab1Unit_FromExcel, String slab2Unit_FromExcel , String slab3Unit_FromExcel)
	{
		  if ( Integer.parseInt(slab1Unit_FromExcel) > Integer.parseInt(slab2Unit_FromExcel) && Integer.parseInt(slab1Unit_FromExcel) > Integer.parseInt(slab3Unit_FromExcel) )
		  {
			Testlistener.log("SLAB 1 is largest.");
		   // largest_Slab=Integer.parseInt(slab1Unit_FromExcel);
		  } else if ( Integer.parseInt(slab2Unit_FromExcel)> Integer.parseInt(slab1Unit_FromExcel)&&Integer.parseInt(slab2Unit_FromExcel) >Integer.parseInt(slab3Unit_FromExcel) )
		  {
			Testlistener.log("SLAB 2 is largest.");
		   // largest_Slab=Integer.parseInt(slab1Unit_FromExcel);
		  }else if ( Integer.parseInt(slab3Unit_FromExcel) > Integer.parseInt(slab1Unit_FromExcel) && Integer.parseInt(slab3Unit_FromExcel) > Integer.parseInt(slab2Unit_FromExcel) )
		  {
			Testlistener.log("SLAB 3 is largest.");
		    largest_Slab=Integer.parseInt(slab3Unit_FromExcel);
		  }else   
	    	Testlistener.log("Entered numbers are not distinct.");
		  
		  return largest_Slab;
	}
	
	public String text_for_The_PartialSearch(String exactTextFromExcel)
	{
		 int sizeofText=exactTextFromExcel.length();
		  String partialText="";
		  for(int i=0;i<sizeofText; i++)
		  {
			  if(i!=3)
			  {
			  partialText = partialText + exactTextFromExcel. charAt(i); 
			  }
			  
			  else
			  {
				  break;
			  }
		  }
		
		  return partialText;   
	}
	
	public String doTheExactSearch(List<WebElement> listelement, String searchText)
	{
		try{
		for(int i=0;i<listelement.size();i++)
		{
			inlineSearchText=listelement.get(i).getText();
			System.out.println("The Text in the list is : "+inlineSearchText);
			if(inlineSearchText.equals(searchText.trim()))
			{
				Testlistener.log("Exact Text Picked for Search is : "+ searchText);
				Testlistener.log("Exact Searched Matched..The First Text Present in List is : "+ inlineSearchText);
				break;
			}
			else{
				Testlistener.log("Exact Search is not working for the value text "+ searchText);
			}
			
		}
		}catch (Exception e) {
			Testlistener.log("Exact Search is not working for the value text "+ searchText);
			Testlistener.log("Exception thrown is : "+ e.getMessage());
		}
		return inlineSearchText;
	}

	public String doThePartialSearch(List<WebElement> listelement, String searchText)
	{
		for(int i=0;i<listelement.size();i++)
		{
			inlineSearchText=listelement.get(i).getText();
			System.out.println("The Text in first list is : "+inlineSearchText);
			if(inlineSearchText.contains(searchText.trim()))
			{
				Testlistener.log("Partial Text Picked for Search is : "+ searchText);
				Testlistener.log("Partial Searched Matched..The First Text Present in List is :  "+ inlineSearchText);
				break;
			}
			else{
				Testlistener.log("Partial Search is not working for the value text "+ searchText);
			}
			
		}
		return inlineSearchText;
	}
	
	public String doTheInvalidSearch(List<WebElement> listelement, String searchText)
	{
		for(int i=0;i<listelement.size();i++)
		{
			inlineSearchText=listelement.get(i).getText();
			System.out.println("The Text in first list is : "+inlineSearchText);
			if(!inlineSearchText.contains(searchText.trim()))
			{
				Testlistener.log("Incorrect Text Picked for Search is : "+ searchText);
				Testlistener.log("Searched Completed..The First Text Present in List is :  "+ inlineSearchText);
				break;
			}
			else{
				Testlistener.log("Invalid Search is not working for the value text "+ searchText);
			}
			
		}
		return inlineSearchText;
	}
	
	

	// Written By Lopa for total Count Validation
	/**
	 * 
	 */
	/**
	 * @author Lopa
	 *
	 */
	public String totalCount_For_ValidData(String countCapturedFromUI, String TotalCount)
	{
		
		String[] countforSplitting = countCapturedFromUI.split("Total : ");
		String countAfterSplit = countforSplitting[1].trim();
		Testlistener.log("After search, total count captured is :- "+countAfterSplit);
			
		if(countCapturedFromUI.equals(TotalCount))
		{
			Testlistener.log("Exact search is not working as expected.");
		}
		else
		{
			Testlistener.log("Exact search is working as expected.");
		}
		return countAfterSplit;	
	}

	public String totalCount_For_PartialData(String countCapturedFromUI, String TotalCount)
	{
		
		String[] countforSplitting = countCapturedFromUI.split("Total : ");
		String countAfterSplit = countforSplitting[1].trim();
		Testlistener.log("After search, total count captured is :- "+countAfterSplit);
			
		if(countCapturedFromUI.equals(TotalCount))
		{
			Testlistener.log("Partial search is not working as expected.");
		}
		else
		{
			Testlistener.log("Partial search is working as expected.");
		}
		return countAfterSplit;	
	}

	public String totalCount_For_inValidData(String countCaptured, String TotalCount)
	{
		String[] countforSplittingForInvalidData = countCaptured.split("Total : ");
		String countAfterSplitForInvalidData = countforSplittingForInvalidData[1].trim();
		Testlistener.log("After search, total count captured is :- "+countAfterSplitForInvalidData);
		if(countCaptured.equals(TotalCount))
		{
			Testlistener.log("Invalid search is working as expected.");
		}
		else
		{
			Testlistener.log("Invalid search is not working as expected.");
		}
		return countAfterSplitForInvalidData;	
	}
	
	

}

