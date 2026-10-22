package P14_HandlingCalenders;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickersType2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://www.hyrtutorials.com/p/calendar-practice.html");

		// Selection of month & year from dropdown		 
		String dateindob = "25";
		String monthindob = "May";
		String yearindob = "2016";
		
		WebElement datebox = d.findElement(By.cssSelector("#fourth_date_picker"));
		datebox.click();
		WebElement yrdrpdwn = d.findElement(By.cssSelector(".ui-datepicker-year"));	
		Select yrsel = new Select(yrdrpdwn); 
		yrsel.selectByVisibleText(yearindob);
		WebElement mnthdrpdwn = d.findElement(By.cssSelector(".ui-datepicker-month"));
		Select mnsel = new Select(mnthdrpdwn); 
		mnsel.selectByVisibleText(monthindob);
		
		//Select day
		List<WebElement> alldays = d.findElements(By.cssSelector(".ui-datepicker-calendar tbody td a"));
		for(WebElement dy: alldays)
		{
		 if(dy.getText().equals(dateindob))	
		 {
			dy.click();
			break;
		 }	 
		}
		
		Thread.sleep(2000);
		System.out.println("Selected dob date: "+datebox.getAttribute("value"));
	}

}
