package P13_TakeScreenshot;

import java.io.File;import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ParticularElementScrnshot {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver d = new ChromeDriver();
		 d.manage().window().maximize();
		 d.get("https://www.amazon.in/");
	     WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));	

	     WebElement searchBox = wait.until(
             ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox"))
         );
     searchBox.sendKeys("Mi Mobiles");
     d.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[2]/div[1]/form[1]/div[3]/div[1]")).click();
	 Thread.sleep(1000);

	 WebElement actprice =d.findElement(By.xpath("(//span[contains(text(),'Redmi Note 17 Pro')]/ancestor::div[contains(@class,'a-section')]//span[contains(@class,'a-text-strike')])[1]"));
	 WebElement disprice= d.findElement(By.xpath("(//span[contains(text(),'Redmi Note 17 Pro')]/ancestor::div[contains(@class,'a-section')]//span[contains(@class,'a-price-whole')])[1]"));
	 System.out.println(actprice.getText());
	 System.out.println(disprice.getText());
	 JavascriptExecutor js = (JavascriptExecutor)d;
		
        WebElement mimobile = d.findElement(By.xpath("(//div[@data-asin='B0HFW39R5W'])[1]"));
        js.executeScript("arguments[0].scrollIntoView()", mimobile); 
        Thread.sleep(2000);
        File f1 = mimobile.getScreenshotAs(OutputType.FILE); // From Selenium 4.X Version onwards
	    File f2 = new File("./Evidences/ScrElementShot1.png");
	    f1.renameTo(f2);

	    Thread.sleep(3000);
		 d.close(); 		
			

}
}