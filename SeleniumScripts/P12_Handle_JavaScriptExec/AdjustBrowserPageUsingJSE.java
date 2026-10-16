package P12_Handle_JavaScriptExec;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdjustBrowserPageUsingJSE {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();

		// For Maximize the Page
		// d.manage().window().maximize();
		
		// For Minimize the Page
		// d.manage().window().minimize();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Set Zoom Level
		JavascriptExecutor js = (JavascriptExecutor)d;
        js.executeScript("document.body.style.zoom='50%'");
        Thread.sleep(3000);		
		d.get("https://practicetestautomation.com/practice-test-login/");
        js.executeScript("document.body.style.zoom='80%'");
		System.out.println("Login Page title: "+d.getTitle());
        d.close();
	}

}
