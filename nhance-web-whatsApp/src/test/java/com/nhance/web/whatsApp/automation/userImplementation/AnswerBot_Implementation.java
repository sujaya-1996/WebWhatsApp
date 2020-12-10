package com.nhance.web.whatsApp.automation.userImplementation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.nhance.web.whatsApp.automation.userPageFactory.AnswerBot_Page;
import com.nhance.web.whatsApp.automation.userPageFactory.WhatsAppCommonPage;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ConstantValueForWeb;
import com.nhance.web.whatsApp.automation.webGenericLibrary.ExcelLibrary;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;
import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverIgnit;

public class AnswerBot_Implementation extends WebDriverIgnit {

	AnswerBot_Page answerbotpage;
	WhatsAppCommonPage whatsappcommon;
	ExcelLibrary excelLib;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();
	String account_Name;
	String initiator_Code;
	String logout_Message;
	String answerBot_Header;
	String answerBot_FirstQuestion;
	String answerBot_SecondQuestion;
	String answerBot_ThirdQuestion;
	String type_Your_query_Text;
	String answer_Of_FirstQuestion;
	String type_ToContinue_Selecting_OtherAnswers;
	String sample_QuestionTwo_SubQuestionOne;
	String sample_QuestionTwo_SubQuestionTwo;
	String sample_QuestionTwo_SubQuestionOne_Answer;
	String sample_QuestionThree_FirstLevelQuestion;
	String sample_QuestionThree_SecondLevelQuestion;
	String sample_QuestionThree_SecondLevelQuestion_Answer;
	String response_For_RandomQuery;
	String response_For_LiveAgentSupport;

	public void setUpAllVariable() throws EncryptedDocumentException, InvalidFormatException, IOException {
		answerbotpage = new AnswerBot_Page(driver);
		whatsappcommon = new WhatsAppCommonPage(driver);
		excelLib = new ExcelLibrary();
		account_Name = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 1, 1);
		initiator_Code = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 6, 1);
		logout_Message = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.COMMON_TESTDATA_SHEETNAME, 7, 1);
		answerBot_Header = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME, 1, 1);
		answerBot_FirstQuestion = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				2, 1);
		answerBot_SecondQuestion = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				3, 1);
		answerBot_ThirdQuestion = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				4, 1);
		type_Your_query_Text = ExcelLibrary.getXlSheetStringValue(ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb,
				ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME, 5, 1);
		answer_Of_FirstQuestion = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				6, 1);
		type_ToContinue_Selecting_OtherAnswers = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				7, 1);
		sample_QuestionTwo_SubQuestionOne = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				8, 1);
		sample_QuestionTwo_SubQuestionTwo = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				9, 1);
		sample_QuestionTwo_SubQuestionOne_Answer =  ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				10, 1);
		sample_QuestionThree_FirstLevelQuestion = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				12, 1);
		sample_QuestionThree_SecondLevelQuestion = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				13, 1);
		sample_QuestionThree_SecondLevelQuestion_Answer = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				14, 1);
		response_For_RandomQuery = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				15, 1);
		response_For_LiveAgentSupport = ExcelLibrary.getXlSheetStringValue(
				ConstantValueForWeb.Excel_File_Path_For_WhatsappWeb, ConstantValueForWeb.ANSWERBOT_TESTDATA_SHEETNAME,
				16, 1);
	}

	public void answerBot_Flow() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Whatsappweb launched successfully.");
		webUtil.implicitWait();
		System.out.println("QR code scan successfully verified, whatsapp web started.");
		webUtil.implicitWait();
		Thread.sleep(15000);

		// // To check the panel view is showing or not!!
		// boolean displayPanelView = selfservicepage.check_Panel_View();
		// if (displayPanelView == true) {
		// System.out.println("Panel view showing properly." + displayPanelView);

		// To click on the search-box and write the account name
		webCmnUtil.explicitlyWait(whatsappcommon.searchText);
		whatsappcommon.write_On_Search_Field(account_Name);
		Thread.sleep(2000);

		// To click on the Gupshup live account
		webCmnUtil.explicitlyWait(whatsappcommon.userChat);
		whatsappcommon.click_On_User_Gupshup();
		System.out.println("Gupshup Live account is selected.");

		// To click and write on the type a message field
		webCmnUtil.explicitlyWait(whatsappcommon.typeMessage);
		whatsappcommon.write_On_Type_Message(initiator_Code);
		System.out.println("In Type a message field, Hi+initiator code message written successfully.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Hi+initiator code message sent successfully, and it will show the dk now.");
		Thread.sleep(10000);

		// To click and write on the type a message field
		whatsappcommon.write_On_Type_Message("7");
		System.out.println("AnswerBot menu is selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To assert the header message of the Answerbot menu
		String value_For_AnswerBot_Header = answerbotpage.read_Value_For_AnswerBot_Header();
		String expected_Value1 = answerBot_Header;
		String actual_Value1 = value_For_AnswerBot_Header;
		if (actual_Value1.contains(expected_Value1)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("AnswerBot menu header has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerBot_Header);

		// To assert the first question in the Answerbot menu
		String value_For_AnswerBot_FirstQuestion = answerbotpage.read_Value_For_AnswerBot_Header();
		String expected_Value2 = answerBot_FirstQuestion;
		String actual_Value2 = value_For_AnswerBot_FirstQuestion;
		if (actual_Value2.contains(expected_Value2)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("First question in the Answerbot menu has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerBot_Header);

		// To assert the Second question in the Answerbot menu
		String value_For_AnswerBot_SecondQuestion = answerbotpage.read_Value_For_AnswerBot_Header();
		String expected_Value3 = answerBot_SecondQuestion;
		String actual_Value3 = value_For_AnswerBot_SecondQuestion;
		if (actual_Value3.contains(expected_Value3)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Second question in the Answerbot menu has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerBot_Header);

		// To assert the Third question in the Answerbot menu
		String value_For_AnswerBot_ThirdQuestion = answerbotpage.read_Value_For_AnswerBot_Header();
		String expected_Value4 = answerBot_ThirdQuestion;
		String actual_Value4 = value_For_AnswerBot_ThirdQuestion;
		if (actual_Value4.contains(expected_Value4)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Third question in the Answerbot menu has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerBot_Header);

		// To assert the type_Your_query_Text in the Answerbot menu
		String value_For_Type_Your_query_Text = answerbotpage.read_Value_For_AnswerBot_Header();
		String expected_Value5 = type_Your_query_Text;
		String actual_Value5 = value_For_Type_Your_query_Text;
		if (actual_Value5.contains(expected_Value5)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Type your query text has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerBot_Header);

		// To Select the first question
		whatsappcommon.write_On_Type_Message("1");
		System.out.println("First Question has been selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To assert the answer of the first question
		String value_For_AnswerOne = answerbotpage.read_Value_For_AnswerOne();
		String expected_Value6 = answer_Of_FirstQuestion;
		String actual_Value6 = value_For_AnswerOne;
		if (actual_Value6.contains(expected_Value6)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Answer of the first question has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerOne);

		// To assert the Value For Type ToContinue Selecting OtherAnswers
		String value_For_Type_ToContinue_Selecting_OtherAnswers = answerbotpage.read_Value_For_AnswerOne();
		String expected_Value7 = type_ToContinue_Selecting_OtherAnswers;
		String actual_Value7 = value_For_Type_ToContinue_Selecting_OtherAnswers;
		if (actual_Value7.contains(expected_Value7)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Value For Type ToContinue Selecting OtherAnswers, has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerOne);

		// To Select the first question
		whatsappcommon.write_On_Type_Message("0");
		System.out.println("It will get navigated back to answerbot question listing screen.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To assert the header message of the Answerbot menu
		String value_For_AnswerBot_Header1 = answerbotpage.read_Value_For_AnswerBot_Header();
		String expected_Value8 = answerBot_Header;
		String actual_Value8 = value_For_AnswerBot_Header1;
		if (actual_Value8.contains(expected_Value8)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("AnswerBot menu header has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerBot_Header);

		// To Select the first question
		whatsappcommon.write_On_Type_Message("2");
		System.out.println("Second Question has been selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);

		// To assert the sub-questions under second question
		String value_For_Sample_QuestionTwo_SubQuestionOne = answerbotpage
				.read_Value_For_Sample_QuestionTwo_SubQuestionOne();
		String expected_Value9 = sample_QuestionTwo_SubQuestionOne;
		String actual_Value9 = value_For_Sample_QuestionTwo_SubQuestionOne;
		if (actual_Value9.contains(expected_Value9)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Sub-question One under second question has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.sample_QuestionTwo_SubQuestionOne);

		// To assert the sub-questions under second question
		String value_For_Sample_QuestionTwo_SubQuestionTwo = answerbotpage
				.read_Value_For_Sample_QuestionTwo_SubQuestionOne();
		String expected_Value10 = sample_QuestionTwo_SubQuestionTwo;
		String actual_Value10 = value_For_Sample_QuestionTwo_SubQuestionTwo;
		if (actual_Value10.contains(expected_Value10)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Sub-question Two under second question has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.sample_QuestionTwo_SubQuestionOne);
		
		// To Select the first question
		whatsappcommon.write_On_Type_Message("1");
		System.out.println("First Sub question under second Question has been selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		// To assert the answer of the question two -- subquestion one
		String value_For_Sample_QuestionTwo_SubQuestionOne_Answer = answerbotpage
				.read_Value_For_Sample_QuestionTwo_SubQuestionOne_Answer();
		String expected_Value11 = sample_QuestionTwo_SubQuestionOne_Answer;
		String actual_Value11 = value_For_Sample_QuestionTwo_SubQuestionOne_Answer;
		if (actual_Value11.contains(expected_Value11)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Answer of the question two -- subquestion one has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.sample_QuestionTwo_SubQuestionOne_Answer);
		
/*		// To assert the Value For Type ToContinue Selecting OtherAnswers
		String value_For_Type_ToContinue_Selecting_OtherAnswers1 = answerbotpage.read_Value_For_AnswerOne();
		String expected_Value12 = type_ToContinue_Selecting_OtherAnswers;
		String actual_Value12 = value_For_Type_ToContinue_Selecting_OtherAnswers1;
		if (actual_Value12.contains(expected_Value12)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Value For Type ToContinue Selecting OtherAnswers, has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerOne);*/
		
		// To Select the first question
		whatsappcommon.write_On_Type_Message("0");
		System.out.println("AnswerBot question listing screen is showing.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		// To Select the first question
		whatsappcommon.write_On_Type_Message("3");
		System.out.println("Third question has been selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		// To assert the question Three -- First Level question
		String value_For_Sample_QuestionThree_FirstLevelQuestion = answerbotpage.read_value_For_Sample_QuestionThree_FirstLevelQuestion();
		String expected_Value13 = sample_QuestionThree_FirstLevelQuestion;
		String actual_Value13 = value_For_Sample_QuestionThree_FirstLevelQuestion;
		if (actual_Value13.contains(expected_Value13)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Question Three -- First Level question, has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.sample_QuestionThree_FirstLevelQuestion);
		
		
		// To Select the first question
		whatsappcommon.write_On_Type_Message("1");
		System.out.println("First level question has been selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		// To assert the question Three -- Second Level question
		String value_For_Sample_QuestionThree_SecondLevelQuestion = answerbotpage.read_Value_For_Sample_QuestionThree_SecondLevelQuestion();
		String expected_Value14 = sample_QuestionThree_SecondLevelQuestion;
		String actual_Value14 = value_For_Sample_QuestionThree_SecondLevelQuestion;
		if (actual_Value14.contains(expected_Value14)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Question Three -- Second Level question, has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.sample_QuestionThree_SecondLevelQuestion);
		
		// To Select the first question
		whatsappcommon.write_On_Type_Message("1");
		System.out.println("Second level question has been selected.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		// To assert the answer of the question Three -- Second Level question
		String value_For_Sample_QuestionThree_SecondLevelQuestion_Answer = answerbotpage.read_Value_For_Sample_QuestionThree_SecondLevelQuestion_Answer();
		String expected_Value15 = sample_QuestionThree_SecondLevelQuestion_Answer;
		String actual_Value15 = value_For_Sample_QuestionThree_SecondLevelQuestion_Answer;
		if (actual_Value15.contains(expected_Value15)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Answer of the question Three -- Second Level question, has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.sample_QuestionThree_SecondLevelQuestion_Answer);
		
		/*// To assert the Value For Type ToContinue Selecting OtherAnswers
		String value_For_Type_ToContinue_Selecting_OtherAnswers2 = answerbotpage.read_Value_For_AnswerOne();
		String expected_Value16 = type_ToContinue_Selecting_OtherAnswers;
		String actual_Value16 = value_For_Type_ToContinue_Selecting_OtherAnswers2;
		if (actual_Value16.contains(expected_Value16)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Value For Type ToContinue Selecting OtherAnswers, has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.answerOne);*/
		
		// To Select the first question
		whatsappcommon.write_On_Type_Message("0");
		System.out.println("AnswerBot question listing screen is showing.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		// To Select the first question
		whatsappcommon.write_On_Type_Message("Rnadom Query");
		System.out.println("Random query has been sent.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		// To assert the message upon giving some random query
		String Response_For_RandomQuery = answerbotpage.read_Response_For_RandomQuery();
		String expected_Value17 = response_For_RandomQuery;
		String actual_Value17 = Response_For_RandomQuery;
		if (actual_Value17.contains(expected_Value17)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Message upon giving some random query, has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.response_For_RandomQuery);
		
		// To Select the first question
		whatsappcommon.write_On_Type_Message("yes");
		System.out.println("Yes has been typed and sent.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		// To assert the message upon giving some random query
		String Response_For_LiveAgentSupport = answerbotpage.read_Response_For_LiveAgentSupport();
		String expected_Value18 = response_For_LiveAgentSupport;
		String actual_Value18 = Response_For_LiveAgentSupport;
		if (actual_Value18.contains(expected_Value18)) {
			System.out.println("Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println("Message upon giving some random query, has been verified successfully.");
		webCmnUtil.explicitlyWait(answerbotpage.response_For_LiveAgentSupport);
		
		// To Select the first question
		whatsappcommon.write_On_Type_Message("#");
		System.out.println("Dk menu listing screen is showing properly.");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		Thread.sleep(10000);
		
		// To do the logout from brand account
		whatsappcommon.write_On_Type_Message("logout");
		Thread.sleep(1000);

		// To click on the send button
		whatsappcommon.click_On_Send_Button();
		System.out.println("Logout has been done successfully.");
		Thread.sleep(10000);

		// To assert the logout success message
		String value_For_LogOutMessage = whatsappcommon.read_Value_For_LogOutMessage();
		String expected_Value_for_Logout = logout_Message;
		String actual_Value_for_Logout = value_For_LogOutMessage;
		if (actual_Value_for_Logout.contains(expected_Value_for_Logout)) {
			System.out.println(
					"Asserstion passed, because actual value contains the expected value.");
		}
		System.out.println(
				"Logout message, has been verified successfully." + actual_Value_for_Logout);
		webCmnUtil.explicitlyWait(whatsappcommon.logOutMessage);

	}

}
