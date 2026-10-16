package P12_Handle_JavaScriptExec;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerticalPageScrollUsingJSE {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor)d;
   
		//1. Scroll By Pixel
		js.executeScript("window.scrollBy(0,2000)", "");
		System.out.println("ScrollBar Move upto: "+js.executeScript("return window.pageYOffset;"));

	    //2. Scroll until Element got visible
		WebElement visitorstats = d.findElement(By.cssSelector("#Stats1_totalCount"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView()", visitorstats); 
		System.out.println("ScrollBar Move till element displayed: "+js.executeScript("return window.pageYOffset;"));
        System.out.println("Element Text: "+visitorstats.getText());
	
	    //3. Scroll till end of the page 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement lastlink = d.findElement(By.xpath("//a[text()='Blogger']"));
        System.out.println("LastLink Seen: "+lastlink.getText());
		
        //4. Scroll back to top of the page       
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		// js.executeScript("arguments[0].scrollTop = 0;", toplink);
        WebElement toplink = d.findElement(By.xpath("//a[text()='Data Entry Form']"));
        System.out.println("toplink Seen: "+toplink.getText());
        	
	}

}
