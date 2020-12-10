package com.nhance.web.whatsApp.automation.webGenericLibrary;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * 
 */
/**
 * @author Manmohan
 *
 */
public class WebDriverCommonUtill extends WebDriverIgnit {
	
	String subWindowHandler;
	String parentWindowHandler;

	// Method for wait using Implicitly Wait condition
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}
	
	// Method for wait using Explicit wait condition till element present in UI
	public void explicitlyWait(WebElement element) {
	  WebDriverWait wait = new WebDriverWait(driver, 60);
			// By by=By.xpath(xpath);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

	// Method for wait using Explicit wait condition till element present in UI
	public void explicitlyWaitForList(List<WebElement> listOFTextFromTable) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			// By by=By.xpath(xpath);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) listOFTextFromTable));
		}

	// Method for wait using Fluent wait condition till element present in UI
	public void fluentWait(WebElement element) {
	/*FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	    .withTimeout(60, TimeUnit.SECONDS)
	    .pollingEvery(5, TimeUnit.SECONDS)
	    .ignoring(NoSuchElementException.class);*/
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
	       .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
	wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	// Method for maximize the Browser window
	public void maximize() {
		driver.manage().window().maximize();
	}

	// Method for maximize the Browser window
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Method for maximize the Browser window
	public void backPage() {
		driver.navigate().back();
	}

	// Method for maximize the Browser window
	public void forward() {
		driver.navigate().forward();
	}

	// Method to print in new line
	public String newLine() {
		String newLine = System.getProperty("line.separator");
		return newLine;
	}

	// Method to delete all cookies
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	// Method for Accepting alert
	public void acceptAlert() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	// Method for Cancel alert
	public void cancelalert() {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}

	// Method for capturing message of alert
	public void getAlertMsg() {
		Alert alt = driver.switchTo().alert();
		alt.getText();
	}

	// Method for comparing two string
	public void compareString(String expected, String actual) {
		Assert.assertEquals(actual.trim(), expected.trim(), "The Comparasion Finished");
	}
	
	// Method for comparing two Integer
		public void compareInteger(int expected, int actual) {
			Assert.assertEquals(actual, expected, "The Comparasion Finished");
		}

	// Method for Select class by using select by value
	public void selectByValue(WebElement wb, String value) {
		Select sel = new Select(wb);
		sel.selectByValue(value);

	}

	// Method for Select class by using select by index
	public void selectByIndex(WebElement wb, int index) {
		Select sel = new Select(wb);
		sel.selectByIndex(index);

	}

	// Method for Select class by using select by visible text
	public void selectByVisibletext(WebElement wb, String text) {
		fluentWait(wb);
		Select sel = new Select(wb);
		sel.selectByVisibleText(text);
	}

	public String getFirstSelectionOption(WebElement wb)
	{
		Select sel = new Select(wb);
		String optionText=sel.getFirstSelectedOption().getText();
		return optionText;	
	}
	// Method for checking Multiple select box
	public boolean selectMulti(WebElement wb) {
		Select sel = new Select(wb);
		boolean sts = sel.isMultiple();
		return sts;
	}

	// method for selecting all Element
	public void selectAll(List<WebElement> lstWbElmnt, WebElement SelectBoxwb) throws InterruptedException {
		int size = lstWbElmnt.size();
		for (int i = 0; i < size - 40; i++) {
			Select sel = new Select(SelectBoxwb);
			sel.selectByIndex(i);
			Thread.sleep(500);
		}
	}

	// Method for frame Handling by using index
	public void frameHandling(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}

	}

	// Method for frame Handling by using WebElement
	public void frameHandling(WebElement wb) {

		try {
			driver.switchTo().frame(wb);
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}

	}

	// Method for frame Handling by using Frame Name
	public void frameHandling(String FrameName) {

		try {
			driver.switchTo().frame(FrameName);
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}

	}

	// Method for Windows handling
	public void windowHandling() throws InterruptedException {

		
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
		     subWindowHandler = windowHandle;
		}
		if(subWindowHandler != null && !subWindowHandler.equals(parentWindowHandler) ){
		    driver.switchTo().window(subWindowHandler);
		   /* driver.close();
		    driver.switchTo().window(parentWindowHandler);*/
		}
		
		 /*    Set<String> handles = driver.getWindowHandles();
		       System.out.println(handles);
		       Iterator<String> b = handles.iterator();
		       String parentWindow=b.next();
		       String childWindow=b.next();
		       driver.switchTo().window(childWindow);
		       Thread.sleep(4000);
     		   System.out.println(driver.getCurrentUrl());*/
	}

	// Method to operate Mouse Over Action
	public void mouseOver(WebElement wb) {
		Actions act = new Actions(driver);
		fluentWait(wb);
		act.moveToElement(wb).build().perform();
	}
	
	public void dragAndDrop(WebElement from , WebElement to)
	{
	Actions actions = new Actions(driver);
	actions.dragAndDrop(from,to).build().perform();
	//System.out.println("The Drag and Drop done");
	}

	// Method to operate Keyboard Operation
	public void keyBoard(WebElement wb) {
		wb.sendKeys(Keys.ENTER);
	}

	// Method to capture the Screenshot
	public void getscreenshot(String destPath) throws IOException {
		EventFiringWebDriver efwd = new EventFiringWebDriver(driver);
		File srcpath = efwd.getScreenshotAs(OutputType.FILE);
		File destpath = new File(destPath);
		FileUtils.copyFileToDirectory(srcpath, destpath);
	}

	// Method to click an element in attempt
	public boolean retryingFindClick(WebElement element) throws InterruptedException {
		boolean result = false;
		int attempts = 0;
		 while(attempts < 1) {
			try {
				//fluentWait(element);
				explicitlyWait(element);
				element.click();
				Thread.sleep(500);
				//System.out.println(" Clicked in Attempts " + attempts);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	// Method to click an element in attempt
	public boolean retryingFindListOFElement(List<WebElement> listOFTextFromTable) {
		boolean result = false;
		int attempts = 0;
		while(attempts < 2) {
			try {
				explicitlyWaitForList(listOFTextFromTable);
				//System.out.println("Captured in Attempts " + attempts);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	// Method to write an element in Edit Box
	public boolean retryingWriteText(WebElement webelemnt, String passTheStringToWrite) {

		boolean result = false;
		int attempts = 0;
		while(attempts < 2) {
			try {
				explicitlyWait(webelemnt);
				//fluentWait(webelemnt);
				webelemnt.clear();
				webelemnt.sendKeys(passTheStringToWrite);
				//System.out.println("Printed in Attempts " + attempts);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;

	}
	
	public String getTheTextFromUI(WebElement element)
	{
		//fluentWait(element);
		implicitWait();
		String text = element.getText();
		return text;
	}

	// Method to Quit the Browser
	public void tearBrowser() {
		driver.quit();
	}

	// Method to upload file
	public void fileUpload(String FilePathToUpload) throws IOException {
		 Runtime.getRuntime().exec(FilePathToUpload);
	}

	// Scroll Up By Script Executor
	public void scrollingUpUsingScriptExecutor() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i = 0; i < 1; i++) {
			jse.executeScript("window.scrollBy(0,-250)", "");
			Thread.sleep(1500);
		}
	}

	public void scrollingHorizontally() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(1000,0)", "");
			Thread.sleep(1500);
		}

	public void scrollingRightUsingKeyBoard() throws InterruptedException {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_RIGHT).perform();
		;
	}
	
	
	// Scroll Up By Script Executor
	public void scrollingUpUsingKeyBoard() throws InterruptedException {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_UP).perform();
		;
	}
	
	// Scroll Page to last
	public void scrollingPage() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}
	
	// Scroll Page to Up
		public void scrollingPage_To_UP() throws InterruptedException
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo( document.body.scrollHeight,0)");
			Thread.sleep(2000);
		}
		
		// Scroll to a specific WebElement
				public void scroll_Upto_An_Element(WebElement element) throws InterruptedException
				{
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].scrollIntoView();",element);
					Thread.sleep(1000);
				}
	
	// Clicking on Hidden Element
	public void click_On_hiddenWebElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	// Capture the attribute value
	 public String get_Attribut_value(WebElement element)
	 {
	  String text =  element.getAttribute("value");
	  return text;
	 }
	 
	 
	 // Validate the data in UI
	 public void validate_the_data(String dataCapturedFromUI, String dataFromExcel,String log)
	 {
			/*String helpdeskNumber_in_EditPage=customerPage.getText_of_helpdeskEmailId_EditBox();
			Testlistener.log("Helpdesk Email Address in Edit Page :: " + helpdeskNumber_in_EditPage);*/
			webCmnUtil.compareString(dataFromExcel, dataCapturedFromUI);
			Testlistener.log(log);
	 }
	 
	 public void writeInto_File(String contentText , String filePath_to_Write)
		{
			   
				BufferedWriter bw = null;
				FileWriter fw = null;

				try {

					String content = contentText;

					fw = new FileWriter(filePath_to_Write);
					bw = new BufferedWriter(fw);
					bw.write(content);

					System.out.println("Done");

				} catch (IOException e) {

					e.printStackTrace();

				} finally {

					try {

						if (bw != null)
							bw.close();

						if (fw != null)
							fw.close();

					} catch (IOException ex) {

						ex.printStackTrace();

					}

				}

			}
	
	 
	 /**
	     * This method will set any parameter string to the system's clipboard.
	     */
		public  void setClipboardData(String string) {
			//StringSelection is a class that can be used for copy and paste operations.
			   StringSelection stringSelection = new StringSelection(string);
			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			}
		
	 public  void uploadFile(String fileLocation) {
	        /*try {
	        	//Setting clipboard with file location
	            setClipboardData(fileLocation);
	            //native key strokes for CTRL, V and ENTER keys
	            Robot robot = new Robot();
	            // Create object of Robot class
	            Thread.sleep(1000);    
	             // Press Enter
	            robot.keyPress(KeyEvent.VK_ENTER);	            
	           // Release Enter
	            robot.keyRelease(KeyEvent.VK_ENTER);	            
	             // Press CTRL+V
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_V);	            
	           // Release CTRL+V
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            robot.keyRelease(KeyEvent.VK_V);
	            Thread.sleep(1000);	                   
	           // Press Enter 
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);	            
	        } catch (Exception exp) {
	        	exp.printStackTrace();
	        }*/
		 
		 WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		 fileInput.sendKeys(fileLocation);
	    }

	 public static File getLatestFilefromDir(String dirPath){
		    File dir = new File(dirPath);
		    File[] files = dir.listFiles();
		    if (files == null || files.length == 0) {
		        return null;
		    }

		    File lastModifiedFile = files[0];
		    for (int i = 1; i < files.length; i++) {
		       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
		           lastModifiedFile = files[i];
		       }
		    }
		    return lastModifiedFile;
		    } 
	 
	// @Test
	 public static List<String> getTheFile() throws IOException, EncryptedDocumentException, InvalidFormatException
	 { 
		 File file = getLatestFilefromDir("C:\\Users\\NEW USER\\Downloads\\");
		 String path = file.getAbsolutePath();
		 String pathUpdated= path.replace("\\", "/"); 
		 System.out.println("The file stored in "+ pathUpdated);
	     List<String> expectedlAddColumnHeaders = ExcelLibrary.getList_CellValues(pathUpdated, 0, 0);
		 
		 return expectedlAddColumnHeaders; 
	 }
	 
	 public void setDownloadPreference(int i) {
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("browser.download.folderList", i);                
		ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	 }
	 
}
