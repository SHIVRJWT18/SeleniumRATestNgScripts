package P15_DataProviders_ExcelNotepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
	File f = new File("C:\\Users\\shivr_w4meoiz\\Pictures\\Our First Trip23.xlsx");
	FileInputStream fis = new FileInputStream(f);
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sht = wb.getSheetAt(0);
	int rw = sht.getLastRowNum()-sht.getFirstRowNum();
	DataFormatter formatter = new DataFormatter();
	for(int i=1;i<rw;i++)
	{
	 int cel = sht.getRow(i).getLastCellNum();

	 System.out.println("Row = "+ i +"Data is- ");
	 for(int j=0;j<cel;j++)
	 {
	   String val = formatter.formatCellValue(sht.getRow(i).getCell(j));
       System.out.println(sht.getRow(0).getCell(j)+" : "+val);

	 }
	 System.out.println("===============");
	}

	 wb.close();
	}



	}


