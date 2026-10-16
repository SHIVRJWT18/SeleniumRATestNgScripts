package P14_HandleFileActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchData {

    public static void main(String[] args) throws IOException {
	File f = new File("./Files/ReadData.xlsx");
	FileInputStream fis =  new FileInputStream(f);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sht = wb.getSheetAt(0);
    int rw = sht.getLastRowNum()-sht.getFirstRowNum();
    WebDriver d = new ChromeDriver();
    d.get("https://demoqa.com/automation-practice-form");
    WebElement Fname = d.findElement(By.id("firstName"));
    WebElement Lname = d.findElement(By.id("lastName"));
    WebElement Email = d.findElement(By.id("userEmail"));
    d.findElement(By.xpath("//label[text()='Male']")).click();
    WebElement Mobile = d.findElement(By.id("userNumber"));
    WebElement Address = d.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
    DataFormatter formatter = new DataFormatter();

    for(int i=1;i<rw;i++)
    {
    String val = formatter.formatCellValue(sht.getRow(i).getCell(4));
    Fname.sendKeys(sht.getRow(i).getCell(0).getStringCellValue());
    Lname.sendKeys(sht.getRow(i).getCell(1).getStringCellValue());
    Email.sendKeys(sht.getRow(i).getCell(2).getStringCellValue());
    Mobile.sendKeys(val);
    Address.sendKeys(sht.getRow(i).getCell(5).getStringCellValue());

    }






	}

}
