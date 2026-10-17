package P15_DataProviders_ExcelNotepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws Exception {
	File f = new File("F:\\WriteData.xlsx");
	FileInputStream fis = new FileInputStream(f);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sht = wb.getSheetAt(0);
	int rw = 10;
	for(int i=0;i<rw;i++)
	{
		sht.getRow(i).createCell(0).setCellValue("Diana");
		sht.getRow(i).createCell(1).setCellValue("Jane");
		sht.getRow(i).createCell(2).setCellValue("djanes@gmail.com");
		sht.getRow(i).createCell(3).setCellValue("Female");
		sht.getRow(i).createCell(4).setCellValue("8786858432");
		sht.getRow(i).createCell(5).setCellValue("Park Lane");
	}
	FileOutputStream fos = new FileOutputStream(f);
	wb.write(fos);
	fos.flush();
	fos.close();


	}
}
