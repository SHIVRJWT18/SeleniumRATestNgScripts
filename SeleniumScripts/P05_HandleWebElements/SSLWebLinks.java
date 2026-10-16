package P05_HandleWebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// SSL(Secure Socket Layer) Link: https://expired.badssl.com 
public class SSLWebLinks {

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		d.get("https://expired.badssl.com/");
		
		System.out.println("SSL page title: "+ d.getTitle()); // Privacy Error
		System.out.println("SSL page link: "+d.getCurrentUrl());
		
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true); // Accepts SSL Certification
		
		d = new ChromeDriver(co);
		d.get("https://expired.badssl.com/");
		
		System.out.println("SSL page title: "+ d.getTitle()); // expired.badssl.com
		System.out.println("SSL page link: "+d.getCurrentUrl());
		
		d.close();
	}

}
