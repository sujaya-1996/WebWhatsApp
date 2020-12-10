package com.nhance.web.whatsApp.automation.userPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhance.web.whatsApp.automation.webGenericLibrary.WebDriverCommonUtill;

public class AnswerBot_Page {

	public WebDriver driver;
	WebDriverCommonUtill webUtil = new WebDriverCommonUtill();

	public AnswerBot_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	// To assert the header message of the Answerbot menu
	@FindBy(xpath = "//span[contains(text(),'What would you like to know ?')]")
	public WebElement answerBot_Header;

	public String read_Value_For_AnswerBot_Header() {
		String value_For_AnswerBot_Header = answerBot_Header.getText();
		webUtil.implicitWait();
		return value_For_AnswerBot_Header;
	}

	// To assert the answer of the first question
	@FindBy(xpath = "//span[contains(text(),'Sample Answer one.')]")
	public WebElement answerOne;

	public String read_Value_For_AnswerOne() {
		String value_For_AnswerOne = answerOne.getText();
		webUtil.implicitWait();
		return value_For_AnswerOne;
	}

	// To assert the sub-questions under second question
	@FindBy(xpath = "//span[contains(text(),'. Sample question two? -- Subquestion one.')]")
	public WebElement sample_QuestionTwo_SubQuestionOne;

	public String read_Value_For_Sample_QuestionTwo_SubQuestionOne() {
		String value_For_Sample_QuestionTwo_SubQuestionOne = sample_QuestionTwo_SubQuestionOne.getText();
		webUtil.implicitWait();
		return value_For_Sample_QuestionTwo_SubQuestionOne;
	}

	// To assert the answer of the question two -- subquestion one
	@FindBy(xpath = "//span[contains(text(),'Sample question two? -- Subquestion one answer.')]")
	public WebElement sample_QuestionTwo_SubQuestionOne_Answer;

	public String read_Value_For_Sample_QuestionTwo_SubQuestionOne_Answer() {
		String value_For_Sample_QuestionTwo_SubQuestionOne_Answer = sample_QuestionTwo_SubQuestionOne_Answer.getText();
		webUtil.implicitWait();
		return value_For_Sample_QuestionTwo_SubQuestionOne_Answer;
	}

	// To assert the answer of the question two -- subquestion Two
	@FindBy(xpath = "//span[contains(text(),'Sample question two? -- Subquestion two answer.')]")
	public WebElement sample_QuestionTwo_SubQuestionTwo_Answer;

	public String read_Value_For_Sample_QuestionTwo_SubQuestionTwo_Answer() {
		String value_For_Sample_QuestionTwo_SubQuestionTwo_Answer = sample_QuestionTwo_SubQuestionTwo_Answer.getText();
		webUtil.implicitWait();
		return value_For_Sample_QuestionTwo_SubQuestionTwo_Answer;
	}

	// To assert the question Three -- First Level question
	@FindBy(xpath = "//span[contains(text(),'. Sample question three? -- First level subquestion.')]")
	public WebElement sample_QuestionThree_FirstLevelQuestion;

	public String read_value_For_Sample_QuestionThree_FirstLevelQuestion() {
		String value_For_Sample_QuestionThree_FirstLevelQuestion = sample_QuestionThree_FirstLevelQuestion.getText();
		webUtil.implicitWait();
		return value_For_Sample_QuestionThree_FirstLevelQuestion;
	}

	// To assert the question Three -- Second Level question
	@FindBy(xpath = "//span[contains(text(),'. Sample question three? -- Second level subquestion.')]")
	public WebElement sample_QuestionThree_SecondLevelQuestion;

	public String read_Value_For_Sample_QuestionThree_SecondLevelQuestion() {
		String value_For_Sample_QuestionThree_SecondLevelQuestion = sample_QuestionThree_SecondLevelQuestion.getText();
		webUtil.implicitWait();
		return value_For_Sample_QuestionThree_SecondLevelQuestion;
	}

	// To assert the answer of the question Three -- Second Level question
	@FindBy(xpath = "//span[contains(text(),'Sample question three? -- Second level subquestion answer.')]")
	public WebElement sample_QuestionThree_SecondLevelQuestion_Answer;

	public String read_Value_For_Sample_QuestionThree_SecondLevelQuestion_Answer() {
		String value_For_Sample_QuestionThree_SecondLevelQuestion_Answer = sample_QuestionThree_SecondLevelQuestion_Answer
				.getText();
		webUtil.implicitWait();
		return value_For_Sample_QuestionThree_SecondLevelQuestion_Answer;
	}
	
	// To assert the message upon giving some random query
	@FindBy(xpath = "//span[contains(text(),'We are unable to understand your query. Kindly rephrase your query or type ')]")
	public WebElement response_For_RandomQuery;

	public String read_Response_For_RandomQuery() {
		String Response_For_RandomQuery = response_For_RandomQuery
				.getText();
		webUtil.implicitWait();
		return Response_For_RandomQuery;
	}
	
	// To assert the message after typing Yes for Live agent support
	@FindBy(xpath = "//span[contains(text(),'You are now connected to a Support Agent. How can we help you today? At any time please type # to exit')]")
	public WebElement response_For_LiveAgentSupport;

	public String read_Response_For_LiveAgentSupport() {
		String Response_For_LiveAgentSupport = response_For_LiveAgentSupport
				.getText();
		webUtil.implicitWait();
		return Response_For_LiveAgentSupport;
	}
	
}
