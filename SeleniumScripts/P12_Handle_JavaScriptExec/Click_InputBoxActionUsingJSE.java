package P12_Handle_JavaScriptExec;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Click_InputBoxActionUsingJSE {

	public static void main(String[] args)  {
		WebDriver d = new ChromeDriver();
		// ChromeDriver d = new ChromeDriver();
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://practicetestautomation.com/practice-test-login/");
		System.out.println("Login Page title: "+d.getTitle());
        
		WebElement un = d.findElement(By.name("username"));
		JavascriptExecutor js = (JavascriptExecutor)d;
		//JavascriptExecutor js = driver // No need to type cast if using Step:15
		
		// Sending input value without using sendKeys() method
		js.executeScript("arguments[0].setAttribute('value', 'student')", un); 
		
		WebElement psw = d.findElement(By.name("password"));
		js.executeScript("arguments[0].setAttribute('value', 'Password123')", psw); 

		// Clicking element without using click() method
		WebElement submit = d.findElement(By.xpath("//button[text()='Submit']"));
		js.executeScript("arguments[0].click()", submit); 
		System.out.println("Home Page title: "+d.getTitle());
		
		d.close();

	}

}
