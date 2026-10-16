package P12_Handle_JavaScriptExec;

import java.time.Duration;
import java.util.function.ToDoubleBiFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* JavaScript property	    Meaning
 * ===================      =======
   window.pageYOffset	    Current vertical position of the webpage
   window.pageXOffset	    Current horizontal position of the webpage
   element.scrollLeft	    Current horizontal position inside the element
   element.scrollTop	    Current vertical position inside the element
   element.scrollWidth	    Total width of the element's scrollable content
   element.clientWidth	    Visible inner width of the element
  */

public class HorizontalPageScrollUsingJSE {
	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://www.tutorialspoint.com/selenium/practice/horizontal-scroll.php");
		JavascriptExecutor js = (JavascriptExecutor)d;
   
		js.executeScript("window.scrollBy(0,500)", "");	
		Thread.sleep(2000);
		
		//1. Scroll By Pixel		
		WebElement scrollContainer = d.findElement(By.cssSelector("div.horizan-scroll"));              
		js.executeScript("arguments[0].scrollLeft = 50;",scrollContainer);
		System.out.println("ScrollBar Move upto: "+js.executeScript("return arguments[0].scrollLeft;", scrollContainer));
		Thread.sleep(2000);

	    //2. Scroll until Element got visible
		String sentence = "(injected humour and the like)";		
		WebElement element = d.findElement(By.xpath("//div[@class='horizan-scroll']//p[contains(.,'" + sentence + "')]"));
		js.executeScript("arguments[0].scrollIntoView({block:'nearest', inline:'start'});",element);
		Thread.sleep(2000);
		System.out.println("ScrollBar moved up to: "+ js.executeScript("return arguments[0].scrollLeft;", scrollContainer));		
		Thread.sleep(2000);
	
	   //3. Scroll till Right end of the scroll container
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;",scrollContainer);
        System.out.println("At Right end: "+ js.executeScript("return arguments[0].scrollLeft;",scrollContainer));
		Thread.sleep(2000);
		
        //4. Scroll back to left of the scroll container  
		js.executeScript("arguments[0].scrollLeft = -arguments[0].scrollWidth;", scrollContainer);		
        // js.executeScript("arguments[0].scrollLeft = 0;", scrollContainer);
        System.out.println("At Left end: "+ js.executeScript("return arguments[0].scrollLeft;",scrollContainer));
		Thread.sleep(2000);

        d.close();
        
	
	}

}


