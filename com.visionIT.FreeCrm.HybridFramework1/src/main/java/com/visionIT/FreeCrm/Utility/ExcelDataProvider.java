package com.visionIT.FreeCrm.Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {
	static XSSFWorkbook wb;

	public ExcelDataProvider() {

		try {
			File fs = new File(".//Testdata1//ExcelData.xlsx");

			FileInputStream fins = new FileInputStream(fs);

			wb = new XSSFWorkbook(fins);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getNumericCellData(String sheetName, int row, int col) {

		XSSFSheet sheet = wb.getSheet(sheetName);
		double numeric = sheet.getRow(row).getCell(col).getNumericCellValue();

		return (int) numeric;
	}

	public int getNumericCellData(int sheetIndex, int row, int col) {
		XSSFSheet sheet = wb.getSheetAt(sheetIndex);
		double numeric = sheet.getRow(row).getCell(col).getNumericCellValue();

		return (int) numeric;
	}

	public String getStringCellData(int sheetIndex, int row, int col) {
		XSSFSheet sheet = wb.getSheetAt(sheetIndex);
		String stringdata = sheet.getRow(row).getCell(col).getStringCellValue();

		return stringdata;
	}

	public String getStringCellData(String sheetName, int row, int col) {
		XSSFSheet sheet = wb.getSheet(sheetName);
		String stringdata = sheet.getRow(row).getCell(col).getStringCellValue();

		return stringdata;
	}

	public Object[][] getExcelData(String sheetName) {

		XSSFSheet sheet = wb.getSheet(sheetName);

		int rows = sheet.getLastRowNum();

		System.out.println("total no. of rows are :" + rows);

		int cols = sheet.getRow(0).getLastCellNum();

		System.out.println("total no. of cells are :" + cols);

		Object[][] excelData = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < cols; j++) {

				excelData[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return excelData;
	}

	public Object[][] getExcelData(int sheetIndex) {

		XSSFSheet sheet = wb.getSheetAt(sheetIndex);

		int rows = sheet.getLastRowNum();
		System.out.println("total no. of rows are :" + rows);

		int cols = sheet.getRow(0).getLastCellNum();

		System.out.println("total no. of cells are :" + cols);

		Object[][] excelData = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < cols; j++) {

				excelData[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return excelData;
	}

}


