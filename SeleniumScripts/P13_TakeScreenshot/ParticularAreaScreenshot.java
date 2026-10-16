package P13_TakeScreenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParticularAreaScreenshot {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://birdeatsbug.com/blog/screenshot-in-selenium");
        WebElement imgarea = d.findElement(By.cssSelector(".w-inline-block div img"));
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView()", imgarea); 
		Thread.sleep(2000);
	    File f1 = imgarea.getScreenshotAs(OutputType.FILE); // From Selenium 4.X Version onwards
	    File f2 = new File("./Evidences/ScrAreaShot1.png");
	    f1.renameTo(f2);
	    
	    Thread.sleep(3000);
		 d.close();
	}

}
