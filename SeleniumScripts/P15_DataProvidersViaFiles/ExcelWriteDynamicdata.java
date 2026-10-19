package P15_DataProvidersViaFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteDynamicdata {

	public static void main(String[] args) throws Exception {
	File f = new File("E:\\SHIV SCRIPTS\\TestData\\WriteData.xlsx");
	FileOutputStream fos = new FileOutputStream(f);
	XSSFWorkbook wb = new XSSFWorkbook();
	XSSFSheet sht = wb.createSheet("DynamicDataWrite");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter required rows:");
	int lastrw = sc.nextInt();
	System.out.println("Enter required cells:");
	int lastcell = sc.nextInt();
	for(int i=1;i<lastrw;i++)
	{
	 XSSFRow currentrow= sht.createRow(i);	
     for(int j =0;j<lastcell;j++)
     {
       XSSFCell currentcell = currentrow.createCell(j);
       currentcell.setCellValue(sc.next());
     }	 
	}
	wb.write(fos);
	wb.close();
	fos.close();


	}
}
