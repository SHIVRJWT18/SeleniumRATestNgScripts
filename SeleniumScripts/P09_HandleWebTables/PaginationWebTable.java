package P09_HandleWebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationWebTable {

	public static void main(String[] args) {
	    WebDriver d = new ChromeDriver();
	    d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    d.get("https://qaplayground.com/practice/data-table");
		String totalpages = d.findElement(By.cssSelector("[data-testid='row-count']")).getText();
		int index = totalpages.lastIndexOf("of");
		int totalPages1 = Integer.parseInt(totalpages.substring(index + 2).trim());
        System.out.println("Total Pages: "+totalPages1);
        
        // Repeating Pages
        for(int i =1;i<=totalPages1;i++)
        {
         if(i>1)
         {
          WebElement activepg = d.findElement(By.xpath("//button[text()="+i+"]")); 
          activepg.click();
         }
         
         // Reading Bookname and authors pf the books
         List<WebElement> rows = d.findElements(By.xpath("//tbody[@data-testid='table-body']//tr"));
     
         for (WebElement row : rows) {
          String bookname = row.findElement(By.xpath("./td[2]")).getText();
          String isbnNo = row.findElement(By.xpath("./td[5]")).getText();
          System.out.print("BookName: "+bookname+ "\t" +" IsbnNo.: "+ isbnNo);
          System.out.println();

         }  	 
         }
        }
}  	
        

