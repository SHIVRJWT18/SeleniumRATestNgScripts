package P05_HandleWebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Shadow DOM: A nested, encapsulated DOM tree within a parent DOM, used to isolate a component’s 
               structure and styles.
   Dom Hirerachy: Shadow Host > Shadom root > Element 
   * Here XPath and other locators does not work, We have to use CSS Selector 
 * */ 
public class ShadowDom {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://dev.automationtesting.in/shadow-dom");
		//WebElement shadowdomelem = d.findElement(By.cssSelector("#shadow-element")); // NosuchElementException
	
		//1. Handle Single Shadow DOM Element
		SearchContext parentshadow = d.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000); // Waiting to load the DOM
		WebElement shadowdomelem = parentshadow.findElement(By.cssSelector("#shadow-element"));
		System.out.println("Element in SingleShadow is: "+shadowdomelem.getText());
		
		//2. Handle Nested Shadow DOM Element
		parentshadow = d.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000); // Waiting to load the DOM
		SearchContext childshadow = parentshadow.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000); // Waiting to load the child DOM
		WebElement Innershadowdomelem = childshadow.findElement(By.cssSelector("#nested-shadow-element"));
		System.out.println("Element in NestedShadow is : "+Innershadowdomelem.getText());
		
		//3. Multi-Nested Shadow DOM Element
		parentshadow = d.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000); // Waiting to load the DOM
		SearchContext childshadow1 = parentshadow.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000); // Waiting to load the child DOM		
		SearchContext childshadow2 = childshadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000); // Waiting to load the inner child DOM

		WebElement Nestedshadowdomelem = childshadow2.findElement(By.cssSelector("#multi-nested-shadow-element"));
		System.out.println("Element in NestedShadow is : "+Nestedshadowdomelem.getText());

		d.close();
	}

}
