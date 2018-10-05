package com.ashok.reports;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ashok.model.User;
import com.ashok.service.UserService;

public class GenerateExcel {

	public static void main(String[] args) throws Exception {

		// Calling service cls method to get data
		UserService service = new UserService();
		List<User> usersList = service.fetchUsersData();

		// calling method to genreate report
		GenerateExcel excelGenerator = new GenerateExcel();
		excelGenerator.generateExcelReport(usersList);

	}

	public void generateExcelReport(List<User> usersList) throws Exception {

		// creating workbook
		Workbook book = new HSSFWorkbook();

		// create sheet in workbook
		Sheet sheet = book.createSheet("Users Data");

		// create row in sheet using index
		Row headerRow = sheet.createRow(0);

		// create cells For Data Row and Set column headers
		headerRow.createCell(0).setCellValue("User Name");
		headerRow.createCell(1).setCellValue("User Email");
		headerRow.createCell(2).setCellValue("User Address");

		int rowIndex = 1;

		for (User u : usersList) {

			// creating dataRow for every user obj
			Row dataRow = sheet.createRow(rowIndex);

			// creating cells and setting the data
			dataRow.createCell(0).setCellValue(u.getUsername());
			dataRow.createCell(1).setCellValue(u.getUserEmail());
			dataRow.createCell(2).setCellValue(u.getUserAddress());

			// incrementing row index for next row
			rowIndex++;
		}

		// write workbook data to file using OutputStream
		FileOutputStream fos = new FileOutputStream("Users-Data.xls");

		book.write(fos);
		book.close();
		fos.close();

		System.out.println("Report Generated...!");

	}

}
