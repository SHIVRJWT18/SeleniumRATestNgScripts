package P05_HandleWebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * SVG (Scalable Vector Graphics) is an HTML element used to display vector graphics, 
 * such as icons, logos, and shapes, on a web page.
 * We cannot handle through absolute XPath.
 * name() method is used in relative XPath to locate the SVG element  
 */
public class SVGElement {
    
	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        d.findElement(By.name("username")).sendKeys("Admin");
        d.findElement(By.name("password")).sendKeys("admin123");
        d.findElement(By.cssSelector("[type='submit']")).click();
        // Using Absolute XPath --> NoSuchElementException
        // Handle Maintenance icon in left menu 
        //d.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a/svg")).click();
	
	    // Using Relative XPath
        
        // Handle Directory icon 
        WebElement elem = d.findElement(By.xpath("//a[.//span[normalize-space()='Directory']]//*[local-name()='svg']"));
        System.out.println("Directory SVG: "+elem.getTagName());  
      
        // Handle Maintenance icon 
        d.findElement(By.xpath("//a[.//span[normalize-space()='Maintenance']]//*[local-name()='svg']")).click();
	
        d.close();
        
	}

}
