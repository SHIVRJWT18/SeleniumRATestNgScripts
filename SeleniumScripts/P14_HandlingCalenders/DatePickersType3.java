package P14_HandlingCalenders;

import java.time.Duration;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickersType3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// TODO: Fix the website connection timeout
		d.get("https://www.w3.org/WAI/ARIA/apg/patterns/dialog-modal/examples/datepicker-dialog/");
		// Selection of only year from dropdown	
		WebElement datebox = d.findElement(By.xpath("//button[@aria-label='Choose Date']"));
		datebox.click();
		String targetday = "18";
		int targetMonthNo = 11;
		int targetyear = 2027;
		datebox.click();
		// Selecting year
		while(true)
		{
		 String currentyear = d.findElement(By.cssSelector(".ui-datepicker-year")).getText();			     
		 int getyear = Integer.parseInt(currentyear);
		 if(getyear ==targetyear)
		 {
			break;	 
		 }	 				 
		 else if (getyear > targetyear) {
		  // Current year is in the future: move backward
		  d.findElement(By.xpath("(//div[@class='numInputWrapper']//span)[7]")).click();
		 } else {
		  // Current year is in the past: move forward
		  d.findElement(By.xpath("(//div[@class='numInputWrapper']//span)[8]")).click();
		    }
		}
		
		while (true) {
		String currentMonth = d.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		int currentMonthNo = Month.valueOf(currentMonth.toUpperCase()).getValue();
		 if (currentMonthNo == targetMonthNo) {
		        break;
		    } else if (currentMonthNo > targetMonthNo) {
		        d.findElement(By.xpath("(//span[@class='flatpickr-prev-month'])[2]")).click();
		    } else {
		    }
		}
		// Selecting day
		List<WebElement> alldays = d.findElements(By.xpath("(//div[@class='dayContainer'])[2]//span"));
		for(WebElement dy: alldays)
		{
		 if(dy.getText().equals(targetday))	
		 {
			dy.click();
			break;
		 }	 
		}
		
		Thread.sleep(2000);
		System.out.println("Selected target date: "+datebox.getAttribute("value"));
	
		
		d.close();
						
		
	}

}
