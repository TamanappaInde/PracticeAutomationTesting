package com.PracticeAutomation.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;



public class ExcelUtil {
	
	private static Workbook workbook;
	private static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		String path = "C:\\Users\\Admin\\git\\UIAutomation_PracticeAutomationTesting\\PracticeAutomationTesting\\src\\test\\resources\\Testdata\\testdata.xlsx";
		
		try (FileInputStream fis = new FileInputStream(path)) {
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getLastCellNum();
			
			Object[][] data = new Object[rows - 1][cols];
			
			for (int i = 1; i < rows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < cols; j++) { // corrected to start from 0
					Cell cell = row.getCell(j);
					data[i - 1][j] = getCellValue(cell);
				}
			}
			
			return data;

		} catch (IOException e) {
			e.printStackTrace();
			return new Object[0][0]; // ensures it compiles even if exception occurs
		}
	}
	
	private static Object getCellValue(Cell cell) {
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					return cell.getDateCellValue().toString();
				} else {
					return String.valueOf((int) cell.getNumericCellValue());
				}
			case BOOLEAN:
				return cell.getBooleanCellValue();
			case FORMULA:
				return cell.getCellFormula();
			default:
				return "";
		}
	}
}
