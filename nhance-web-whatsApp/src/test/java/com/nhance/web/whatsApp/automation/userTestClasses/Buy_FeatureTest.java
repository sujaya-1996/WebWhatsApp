package com.nhance.web.whatsApp.automation.userTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nhance.web.whatsApp.automation.userImplementation.Buy_Implementation;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class Buy_FeatureTest extends WebDriverIgnit {
	Buy_Implementation buyimpl = new Buy_Implementation();

	@BeforeTest
	public void beforeClass() {

		getChrome_Browser();

	}

	@BeforeMethod
	public void Test_SetupVariables() throws EncryptedDocumentException, InvalidFormatException, IOException {
		buyimpl.setUpAllVariable();

	}

	@Test(priority = 1, description = "To do the placeOrder_PositiveFlow_For_OnlinePayment")
	public void Test_placeOrder_PositiveFlow_For_OnlinePayment() throws InterruptedException {
		buyimpl.placeOrder_PositiveFlow_For_OnlinePayment();
	}

	@Test(priority = 2, description = "To do the orderStatus_Flow_After_Doing_OnlinePayment")
	public void Test_orderStatus_Flow_After_Doing_OnlinePayment() throws InterruptedException {
		buyimpl.orderStatus_Flow_After_Doing_OnlinePayment();
	}

	@Test(priority = 3, description = "To do the CashOnDelivery_Flow")
	public void Test_CashOnDelivery_Flow() throws InterruptedException {
		buyimpl.CashOnDelivery_Flow();
	}

	@Test(priority = 4, description = "To do the orderStatusFlow_After_COD")
	public void Test_orderStatusFlow_After_COD() throws InterruptedException {
		buyimpl.orderStatusFlow_After_COD();
	}

/*	@Test(priority = 5, description = "To do the cancelOrder_Flow")
	public void Test_CancelOrder_Flow() throws InterruptedException {
		buyimpl.cancelOrder_Flow();
	}*/
}
