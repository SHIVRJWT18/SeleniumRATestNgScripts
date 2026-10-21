package P16_HandleFileActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileUsingRobotClass {
    static
    {
    	System.setProperty("webdriver.chrome.driver", "./Sel.Drivers/chromedriver.exe");
    	System.setProperty("webdriver.gecko.driver","./Sel.Drivers/geckodriver.exe");
    }
	public static void main(String[] args) throws InterruptedException, AWTException {
	WebDriver d = new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	d.get("https://demoqa.com/upload-download");
	Thread.sleep(3000);
	Robot rb=new Robot();
	// TODO: Need to fix this case

	d.findElement(By.xpath("//input[@type='file']")).click();
	Thread.sleep(2000);
	rb.keyPress(KeyEvent.VK_TAB);
	rb.keyRelease(KeyEvent.VK_TAB);
	rb.keyPress(KeyEvent.VK_TAB);
	rb.keyRelease(KeyEvent.VK_TAB);
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(1000);
    rb.keyPress(KeyEvent.VK_D);
    rb.keyPress(KeyEvent.VK_E);
    rb.keyPress(KeyEvent.VK_S);
    rb.keyPress(KeyEvent.VK_K);
    rb.keyPress(KeyEvent.VK_T);
    rb.keyPress(KeyEvent.VK_O);
    rb.keyPress(KeyEvent.VK_P);
    rb.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(1000);
    rb.keyPress(KeyEvent.VK_C);
    rb.keyPress(KeyEvent.VK_ENTER);
	}

}
