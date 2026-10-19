package P15_DataProvidersViaFiles;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * System.getProperty("user.dir") --> returns E:\SHIV SCRIPTS\Selenium_MScripts
 * File f = new File(...).getParent() --> returns E:\SHIV SCRIPTS
 * Appending \TestData\WriteData.xlsx gives --> E:\SHIV SCRIPTS\TestData\WriteData.xlsx
 */
public class ExcelWriteStaticdata {

	public static void main(String[] args) throws Exception {
	File f = new File(new File(System.getProperty("user.dir")).getParent()+"\\TestData\\WriteData.xlsx");	
	FileOutputStream fos = new FileOutputStream(f);
	XSSFWorkbook wb = new XSSFWorkbook();
	XSSFSheet sht = wb.createSheet("StaticDataWrite");
	XSSFRow row = sht.createRow(0);
	row.createCell(0).setCellValue("FName");
	row.createCell(1).setCellValue("LName");
	row.createCell(2).setCellValue("Email");
	row.createCell(3).setCellValue("Gender");
	row.createCell(4).setCellValue("Mobile");
	row.createCell(5).setCellValue("Address");

	int lastrw = 10;
	for(int i=1;i<lastrw;i++)
	{
		XSSFRow dataRow = sht.createRow(i);
		dataRow.createCell(0).setCellValue("Diana");
		dataRow.createCell(1).setCellValue("Jane");
		dataRow.createCell(2).setCellValue("djanes@gmail.com");
		dataRow.createCell(3).setCellValue("Female");
		dataRow.createCell(4).setCellValue("8786858432");
		dataRow.createCell(5).setCellValue("Park Lane");
	}
	wb.write(fos);
	wb.close();
	fos.close();


	}
}
