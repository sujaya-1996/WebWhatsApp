package com.nhance.web.whatsApp.automation.webGenericLibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
/**
 * 
 */
/**
 * @author Manmohan
 *
 */
public class ExcelLibrary {

	static List<String> cellValues;
	static String s1 = "";
	int col_Num;
	static String getDataFromCSV="";
	public FileInputStream fis = null;
   // public XSSFWorkbook workbook = null;
    //public XSSFSheet sheet = null;
    //public XSSFRow row = null;
    //public XSSFCell cell = null;

	public static String getXlSheetStringValue(Object FilePath, Object sheetName, int rowno, int cellno)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream((String) FilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet((String) sheetName);
		Row row = sh.getRow(rowno);
		String s1 = row.getCell(cellno).getStringCellValue();
		//wb.close();
		return s1;
		

	}

	public static int getXlSheetIntegerValue(String filePath, String sheetname, int rowno, int cellno)
			throws EncryptedDocumentException, InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowno);
		int s1 = (int) row.getCell(cellno).getNumericCellValue();
		return s1;
	}
	
	public static String getThedateFromatFromExcel(Object FilePath, int sheetPostion, int rowno, int cellno , Object dateFormat) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fileIn = new FileInputStream((String) FilePath);
		Workbook workbook = WorkbookFactory.create(fileIn);
		CreationHelper creationHelper = workbook.getCreationHelper();
		CellStyle cellStyle = workbook.getSheetAt(sheetPostion).getRow(rowno).getCell(cellno).getCellStyle();
		cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat((String) dateFormat));
		workbook.getSheetAt(sheetPostion).getRow(rowno).getCell(cellno).setCellStyle(cellStyle);
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(workbook.getSheetAt(sheetPostion).getRow(rowno).getCell(cellno));
		//System.out.println(val);
		return val;
	}

	public static void setExcelData(Object filePath, Object sheetName, int rowNum, int colNum, String data)
			throws EncryptedDocumentException, InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		FileInputStream fis = new FileInputStream((String) filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet((String) sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellType(Cell.CELL_TYPE_STRING);
		java.io.FileOutputStream fos = new java.io.FileOutputStream((String) filePath);
		cel.setCellValue(data.toString());
		wb.write(fos);
		wb.close();
	}

	public static int getRowCount(Object filePath, Object sheetName)
			throws EncryptedDocumentException, InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		FileInputStream fis = new FileInputStream((String) filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet((String) sheetName);
		return sh.getLastRowNum()+ 1;

	}
	
	//@Test
	public void test1() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		int rowCount = getRowCount("D:\\Nhance_Automation_Workspace\\github\\nhance-automation-qa-web\\src\\main\\resources\\BulkUploadFiles\\AddProduct_AutoITFiles\\productWithMandatory.xlsx", "Sheet1");
		System.out.println("rowCount = "+ rowCount);
	}

	public static List<String> getRowDataForSpecificColumn(Object filePath, Object sheetName,int colNum)
			throws EncryptedDocumentException, InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		FileInputStream fis = new FileInputStream((String) filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet((String) sheetName);
		int rowCount = getRowCount((String) filePath, (String) sheetName);
		System.out.println("Total Number of row : " + rowCount);
		for (int i = 1; i <= rowCount; i++) {
			Row row = sh.getRow(i);
			try{
			s1 += row.getCell(colNum).getStringCellValue() + ",";
			System.out.println(s1);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		List<String> myList = new ArrayList<String>(Arrays.asList(s1.split(",")));
		s1 = "";
		return myList;

	}
	
	public static void setFormatCell_To_Text(String filePath,String SheetName,int rowNum,int colNum , String data) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		 /* FileInputStream fis = new FileInputStream(filePath);
		  Workbook wb = WorkbookFactory.create(fis);
		   DataFormat fmt = wb.createDataFormat();
		   Sheet sh = wb.getSheet(SheetName);
		   CellStyle textStyle = wb.createCellStyle();
		   textStyle.setDataFormat(fmt.getFormat("@"));
		   sh.setDefaultColumnStyle(0, textStyle);*/
		/*FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		CellStyle cellStyle = wb.createCellStyle();
		CreationHelper createHelper = wb.getCreationHelper();
		cellStyle.setDataFormat(
		    createHelper.createDataFormat().getFormat("@"));
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		cel.setCellStyle(cellStyle);*/
		
		/*FileInputStream inputStream = new FileInputStream(filePath);
		Workbook wb = new XSSFWorkbook(inputStream);
		CellStyle cellStyle = wb.createCellStyle();
		//Date date1=new Date();
		Sheet xlsMainTable = (Sheet) wb.getSheetAt(0);
		Row myRow= CellUtil.getRow(rowNum, xlsMainTable);
		CellUtil.getCell(myRow, colNum).setCellValue(data);*/
	}

	public static List<String> getcsvDataFile(String filePathOfCSV , int columnIndex) throws EncryptedDocumentException, InvalidFormatException, IOException {
		    String splitBy = ",";
			BufferedReader br = new BufferedReader(new FileReader(filePathOfCSV));
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				// String[] b = line.split(splitBy);
			    // System.out.println(line); // .. This will print all d row data
				 String[] li = line.split(splitBy);
				 System.out.println(li[columnIndex]);// ... This will print whole given coloumn index data
				 getDataFromCSV += li[columnIndex]+",";
			}
			System.out.println("Get The DATA for Column Index "+columnIndex +" From CSV File "+getDataFromCSV);
			List<String> mylist=new  ArrayList<String>(Arrays.asList(getDataFromCSV.split(",")));
			System.out.println("After Converting to List The Size  is : "+mylist.size());
			for(int i=0; i<mylist.size();i++)
			{
				s1 += mylist.get(i)+",";
			}
			List<String> myList = new ArrayList<String>(Arrays.asList(s1.split(",")));
			getDataFromCSV ="";
			s1 = "";
			br.close();
			return myList;
			
	}

	public static List<String> getList_CellValues(Object filePath, int rowValue, int index)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream fis = new FileInputStream((String) filePath);
		cellValues = new ArrayList<String>();
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(index);
		Row row = sh.getRow(rowValue);
		int LastcellNum = row.getLastCellNum();
		System.out.println("The total Number of column=" + LastcellNum);
		for (int i = 0; i < LastcellNum; i++) 
		{
			cellValues.add(row.getCell(i).getStringCellValue());
			
		}
		System.out.println("Cell values in the excell sheet rowWise" + cellValues);
		return cellValues;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	static Sheet sheet1;
	static File getLatestFile = WebDriverCommonUtill.getLatestFilefromDir("C:\\Users\\NEW USER\\Downloads");
	 static String sheetName;
	 String columnOne;
	 String columnTwo;
	 String columnThree;
	 String columnFour;
	 static String values;
	//@Test
	public static  List<String> validateReportValuesFromExcel() throws IOException, EncryptedDocumentException, InvalidFormatException {
		FileInputStream fileInputStreamOne = new FileInputStream(getLatestFile);
		
		Workbook workBookOne = WorkbookFactory.create(fileInputStreamOne);
		//Workbook workBookOne = new HSSFWorkbook(fileInputStreamOne);
		//for (int i = 0; i < workBookOne.getNumberOfSheets(); i++) {
			
		//sheet1 = workBookOne.getSheetAt(0);
		sheet1 = workBookOne.getSheetAt(0);

		Iterator rowIter = sheet1.rowIterator();
		while (rowIter.hasNext()) {
			Row myRow = (Row) rowIter.next();
			Iterator cellIter = myRow.cellIterator();
			Vector<String> cellStoreVector = new Vector<String>();
			while (cellIter.hasNext()) {
				Cell myCell = (Cell) cellIter.next();
				String cellvalue = myCell.getStringCellValue();
				String rowVal = cellIter.toString();
				cellStoreVector.addElement(cellvalue);
			}
			for (int i = 0; i < cellStoreVector.size(); i++) {
				values = cellStoreVector.get(i).toString();

				System.out.println("The values are " + values);
			}
		}
		//Map<List<String>, List<String>> map= new HashMap<List<String>, List<String>>();  
		List<String> list_CellValues = ExcelLibrary.getList_CellValues(getLatestFile.toString(), 0,0);
		
		return list_CellValues;
		
		//List<String> list_CellValues1 = ExcelLibrary.getList_CellValues(getLatestFile.toString(), 1, sheetName);
	}
	
	
	

}
