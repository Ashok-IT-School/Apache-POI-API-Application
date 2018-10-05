package com.ashok.reports;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcelData {

	public static void main(String[] args) throws Exception {

		readDataFromExcel("Users-Data.xls");

	}

	/**
	 * This method is used to read Data from Excel file
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void readDataFromExcel(String fileName) throws FileNotFoundException, IOException {

		// Passing File as input to Workbook
		FileInputStream fis = new FileInputStream(fileName);
		Workbook book = new HSSFWorkbook(fis);

		// Getting sheet at 0th index
		Sheet sheet = book.getSheetAt(0);

		// Getting Rows from sheet
		Iterator<Row> rowIterator = sheet.rowIterator();

		int rowIndex = 0;

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// skipping header row
			if (rowIndex == 0) {
				// incrementing rowIndex
				rowIndex++;
				continue;
			}

			// Getting cell iterator of a row
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				// Getting cell of row
				Cell cell = cellIterator.next();

				// getting cell value
				String cellVal = cell.getStringCellValue();

				System.out.print(cellVal + "\t");
			}

			System.out.println();

		}

		book.close();
		fis.close();
	}

}
