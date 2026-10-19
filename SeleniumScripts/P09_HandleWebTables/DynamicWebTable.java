package P09_HandleWebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) {
	    WebDriver d = new ChromeDriver();
	    d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    d.get("https://testautomationpractice.blogspot.com/");
	    // 1. Count no. of rows
	    List<WebElement> trows = d.findElements(By.cssSelector("#taskTable tr"));
	    System.out.println("Total Rows: "+trows.size());
	    
	    // 2. Count no. of columns
	    List<WebElement> tcol = d.findElements(By.cssSelector("#taskTable th"));
	    System.out.println("Total Columns: "+tcol.size());
	    
        //3. Read the data from specific row & column (4th row and 3rd column)
	    String data = d.findElement(By.cssSelector("#taskTable tr:nth-child(4) td:nth-child(3)")).getText();
	    System.out.println("4th Rw 3rd Col data:  "+data);
	    System.out.println("============================");
	    
        // 4. Read all the data from specific row (Second Last row)
	    List<WebElement> trData = d.findElements(By.cssSelector("#taskTable tr:nth-last-child(2)"));
	    for (WebElement cell : trData) {
	        System.out.println("2nd LastRw data: " + cell.getText());
	    }
	    System.out.println("============================");
	    
	    // 5. Read all the data from specific column (Second column)
	    List<WebElement> tdData = d.findElements(By.cssSelector("#taskTable tr td:nth-child(2)"));
	    
	    for (WebElement cell : tdData) {
	        System.out.println("2nd Col data: " + cell.getText());
	    }
	    System.out.println("============================");
	    
	    //6. Read all the table data
	    for (int i = 0; i < trows.size(); i++) {
	    List<WebElement> cells = trows.get(i).findElements(By.tagName("td"));
	    
	    for (int j = 0; j < cells.size(); j++) {
	     System.out.print(cells.get(j).getText() + "\t");
	    }
	    
	     System.out.println();
	    }
	    System.out.println("============================");

	    // 7. Read headers with first row data
	    List<WebElement> headers = d.findElements(By.cssSelector("#taskTable tr:first-child th"));
	    List<WebElement> firstRowData = d.findElements(By.cssSelector("#taskTable tr:nth-child(2) td"));

	    for (int i = 0; i < headers.size(); i++) {
	        System.out.println(headers.get(i).getText() + " : " + firstRowData.get(i).getText());
	    }
	    System.out.println("============================");
	    
	  /*  //8. Read those bookname and its price whose authors is Mukesh	    
	    trData = d.findElements(By.cssSelector("[name='BookTable'] tr td:nth-child(2)"));

	    for (WebElement cell : trData) {
	      if (cell.getText().equalsIgnoreCase("Mukesh")) {
          WebElement row = cell.findElement(By.xpath("./parent::tr")); // Get the parent row
   
          String bkname = row.findElement(By.cssSelector("td:nth-child(1)")).getText(); // Get BookName (1st column)    
          String price = row.findElement(By.cssSelector("td:nth-child(4)")).getText(); // Get Price (4th column)
          System.out.println("Book Name: " + bkname);
          System.out.println("Author: " + cell.getText());
          System.out.println("Price: " + price);
          }
	    }
	    System.out.println("============================");
	    
	    //9. Calculate total price of all books
	    tdData = d.findElements(By.cssSelector("[name='BookTable'] tr td:nth-child(4)"));
        int total=0;
	    for(WebElement elem : tdData)
        {
         total = total+ Integer.parseInt(elem.getText());        	
        }
	    System.out.println("Total Price: "+total);
	    d.close();
*/
	}

}
