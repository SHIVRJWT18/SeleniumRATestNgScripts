package P05_HandleWebElements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * A broken link is a hyperlink that fails to access the intended resource on the server.
 * Common errors include 404 Not Found, 400 Bad Request, and other HTTP error responses.
 * When a link is accessed, the client sends an HTTP request to the server to retrieve the requested resource.
 * If available, the server returns the resource with an HTTP status code.
 * If the request fails, the server may return an error status code.
 * How to Identify Broken Links?
   =============================
   1. Extract the URLs from the web page and check href attribute is present or not.
   2. Send HTTP requests to each URL.
   3. Check the HTTP response status codes.
      if status code >=400 --> broken link
      if status code <400 --> Not a broken link
 */
public class BrokenLink {
	int count =0;
	public void CheckUrlLinks(String linkurl)
	{
	try {
	 URL urlobj = new URL(linkurl);
	 HttpURLConnection urlconnection = (HttpURLConnection)urlobj.openConnection();
	 urlconnection.setRequestMethod("HEAD");
	 urlconnection.setConnectTimeout(3000);
	 urlconnection.connect();
	 int statusCode = urlconnection.getResponseCode();

	 if(urlconnection.getResponseCode()>=400)
	 {  
      System.out.println("Broken Link: "+linkurl+" | Status: " +statusCode);
      count++;
	 } 
	 else {
         System.out.println("Not broken: "+linkurl+" | Status: " +statusCode);
     }
	 urlconnection.disconnect();
	}
	catch (Exception e) 
	{
	 System.out.println("Unable to test link: "+linkurl+" | Reason: "+e.getMessage());	
	}
	}
	public static void main(String[] args) {
    WebDriver d = new ChromeDriver();
    BrokenLink bl = new BrokenLink();
    d.manage().window().maximize();
    d.get("http://www.deadlinkcity.com/");
    
	List<WebElement> links = d.findElements(By.tagName("a"));
	System.out.println("Total no. of links: "+links.size());
	for(WebElement elem :links)
	{
	 String hrefvalue = elem.getAttribute("href");
	 System.out.println(hrefvalue);
	 if(hrefvalue==null || hrefvalue.isEmpty())
	 {
	  System.out.println("Unable to test the link due to its href value is invalid..");	 
	  continue;
	 }	 
	 
	 bl.CheckUrlLinks(hrefvalue);
	}
	System.out.println("Total broken links: " + bl.count);
	d.quit();
   
	   }
	}

