package com.nhance.web.whatsApp.automation.userImplementation;

import com.nhance.web.whatsApp.automation.userPageFactory.CustomerAdminCommonWebElementInAllPage;
import com.nhance.web.whatsApp.automation.userPageFactory.WhatsAppCommonPage;
import com.nhance.web.whatsApp.automation.userTestClasses.BaseTest;
import com.nhance.web.whatsApp.automation.webBusinessLibrary.BusinessFunctionWebSpecific;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

	public class DocBox_Linear_Implementation extends BaseTest{

		WebDriverCommonUtill webCmnUtil;
		BusinessFunctionWebSpecific bFuction;
		CustomerAdminCommonWebElementInAllPage cmnElement;
		WhatsAppCommonPage wpcmpge;
		

		String numberData;
		String typeMessage01;
		String typeMessage02;
		String typeMessage03;
		
		public void customerSpecificSetUp() throws Exception {
			
			cmnElement = new CustomerAdminCommonWebElementInAllPage(driver);
			webCmnUtil = new WebDriverCommonUtill();
			bFuction = new BusinessFunctionWebSpecific();
			wpcmpge = new WhatsAppCommonPage(driver);
			
		}
		
		public void addTest() throws InterruptedException {
			
			Thread.sleep(15000);
			
			webCmnUtil.explicitlyWait(wpcmpge.searchText);
						 
		    wpcmpge.write_On_Search_Field("9108499377");
		    System.out.println("The bot number is searched");
		    webCmnUtil.explicitlyWait(wpcmpge.userChat);
			wpcmpge.click_On_User_Gupshup();
			System.out.println("The bot user is selected");
			webCmnUtil.explicitlyWait(wpcmpge.typeMessage);
			wpcmpge.write_On_Type_Message("hi");
			System.out.println("Hi is typed");
			wpcmpge.verify_Welcome_Message();
			wpcmpge.write_On_Type_Message("1");
			wpcmpge.write_On_Type_Message("3");
		}


}
