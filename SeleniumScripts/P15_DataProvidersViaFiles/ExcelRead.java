package P15_DataProvidersViaFiles;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Excel File > Workbook > Sheets > Rows/Columns > Cells
public class ExcelRead {

	public static void main(String[] args) throws IOException {
	//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"TestData\\FakeTestData.xlsx");;
	//FileInputStream fis = new FileInputStream("E:\\SHIV SCRIPTS\\TestData\\FakeTestData.xlsx");
	
	  String folderpath = new File(System.getProperty("user.dir")).getParent();
	  String filepath = folderpath+"\\SHIV SCRIPTS\\TestData\\FakeTestData.xlsx";
	  System.out.println("File located at: "+filepath);
		
	  FileInputStream fis = new FileInputStream(filepath);
	  XSSFWorkbook wb= new XSSFWorkbook(fis);
	  XSSFSheet sht = wb.getSheet("TestData"); // Using sheetname
	// XSSFSheet sht = wb.getSheetAt(0); // Using index of sheet
	   int rw = sht.getLastRowNum();
	   DataFormatter formatter = new DataFormatter();
	   for(int i=1;i<=rw;i++)
	   {
	    int cel = sht.getRow(i).getLastCellNum();
        XSSFRow row = sht.getRow(i);
	   for(int j=0;j<cel;j++)
	   {
	    String val = formatter.formatCellValue(row.getCell(j));
        System.out.print(val+"\t");
	   }
	    System.out.println();
	  }
	    wb.close();
	    fis.close();
	}



	}


