package com.wipro.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXLData {

	public static String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException {

		File file = new File(
				"C:\\Users\\SunilKumar\\eclipse-workspace\\CapstonetByUsingfindBy.zip_expanded\\CapstonetByUsingfindBy\\src\\test\\resources\\testdata\\SunilHiregowda@26New.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheetName = workbook.getSheet(excelSheetName);
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);

		DataFormatter dataFormat = new DataFormatter();
		String testData[][] = new String[totalRows][totalCols];

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = dataFormat.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}

		}
		return testData;
	}

}
