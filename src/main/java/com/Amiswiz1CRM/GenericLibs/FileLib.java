package com.Amiswiz1CRM.GenericLibs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	/**
	 * this generic reusable method is used to read the data from property file.
	 * 
	 * @param propath
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readPropertyData(String propath, String key) throws Throwable {
		FileInputStream fis = new FileInputStream(propath);
		Properties prop = new Properties();
		prop.load(fis);
		String propvalue = prop.getProperty(key, "Incorrect key");
		return propvalue;
	}

	/**
	 * this generic reusable method is used to read the data from excel file.
	 * 
	 * @param path
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */

	public String readExcelData(String path, String SheetName, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String excelvalue = wb.getSheet(SheetName).getRow(row).getCell(cell).toString();
		return excelvalue;

	}

	/**
	 * this generic reusable method is used to write the data inside excel file.
	 * 
	 * @param path
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void WriteExcelData(String path, String sheetName, int row, int cell, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
	}

	/**
	 * this generic reusable method is used to count the total rows filled in any
	 * sheet of an excel file.
	 * 
	 * @param path
	 * @param sheet
	 * @return rowCount
	 * @throws Throwable
	 */
	public int getRowcount(String path, String sheet) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheet).getLastRowNum();
		return rowcount;
	}
}
