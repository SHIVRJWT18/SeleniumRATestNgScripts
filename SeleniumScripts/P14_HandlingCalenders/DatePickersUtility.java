package P14_HandlingCalenders;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickersUtility {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://jqueryui.com/datepicker/");
		
		//1. Direct Using SendKeys() Method
		d.switchTo().frame(0);
		WebElement datebox = d.findElement(By.cssSelector("input#datepicker"));
		datebox.click();
		datebox.sendKeys("15/04/2027");
		Thread.sleep(2000);
		System.out.println("Selected date via SendKeys: "+datebox.getAttribute("value"));
		
		//2. Given Future date using calendar navigation
	    d.navigate().refresh();
	    d.switchTo().frame(0);
	    datebox = d.findElement(By.cssSelector("input#datepicker"));
	    datebox.click();
	    
	    // Expected Future date
		String day = "18";
		String month = "November";
		String year = "2027";
		datebox.click();

		// Selecting month year
		while(true)
		{
		 String currentmonth = d.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		 String currentyear = d.findElement(By.cssSelector(".ui-datepicker-year")).getText();
	     
		 if(currentmonth.equals(month) && currentyear.equals(year))
		 {
		  break;	 
		 }	 
		 
		 d.findElement(By.xpath("//a[@title='Next']")).click(); // Next icon
		}
		
		//Select day
		List<WebElement> alldays = d.findElements(By.cssSelector("table.ui-datepicker-calendar tbody td a"));
		for(WebElement dy: alldays)
		{
		 if(dy.getText().equals(day))	
		 {
			dy.click();
			break;
		 }	 
		}	
		
		Thread.sleep(2000);
		System.out.println("Selected future date: "+datebox.getAttribute("value"));
	
		//3. Given Past date using calendar navigation
	    d.navigate().refresh();
	    d.switchTo().frame(0);
	    datebox = d.findElement(By.cssSelector("input#datepicker"));
	    datebox.click();
	    
	    // Expected Future date
		String prevday = "8";
		month = "June";
		year = "2022";
		datebox.click();

		// Selecting month year
		while(true)
		{
		 String currentmonth = d.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		 String currentyear = d.findElement(By.cssSelector(".ui-datepicker-year")).getText();
	     
		 if(currentmonth.equals(month) && currentyear.equals(year))
		 {
		  break;	 
		 }	 
		 
		 d.findElement(By.xpath("//a[@title='Prev']")).click(); // Next icon
		}
		
		//Select day
		alldays = d.findElements(By.cssSelector("table.ui-datepicker-calendar tbody td a"));
		for(WebElement dy: alldays)
		{
		 if(dy.getText().equals(prevday))	
		 {
			dy.click();
			break;
		 }	 
		}	
		
		Thread.sleep(2000);
		System.out.println("Selected past date: "+datebox.getAttribute("value"));
		
		//4. Given Current date using calendar navigation
	    d.navigate().refresh();
	    d.switchTo().frame(0);
	    datebox = d.findElement(By.cssSelector("input#datepicker"));
	    datebox.click();
	    
	    // Expected this date
	    LocalDate today = LocalDate.now();

	    String todaymonth = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

	    String todayyear = String.valueOf(today.getYear());
	    String thisday = String.valueOf(today.getDayOfMonth());
	    System.out.println("Today's date: "+ todaymonth+" "+todayyear+" "+thisday);
	    
		datebox.click();

		// Selecting month year
		while(true)
		{
		 String currentmonth = d.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		 String currentyear = d.findElement(By.cssSelector(".ui-datepicker-year")).getText();
	     
		 if(currentmonth.equals(todaymonth) && currentyear.equals(todayyear))
		 {
		   //Select day
		   alldays = d.findElements(By.cssSelector("table.ui-datepicker-calendar tbody td a"));
		   break;
		 }
		}
		
	    for(WebElement dy: alldays)
		{
		 if(dy.getText().equals(thisday))	
		 {
				dy.click();
				break;
			 }	 
		 }	
		
		Thread.sleep(2000);
		System.out.println("Selected current date: "+datebox.getAttribute("value"));
		
		d.close();
	}

}
