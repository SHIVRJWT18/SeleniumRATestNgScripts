package P01_HandleBrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* Enable Extensions in the browsers:
1. Install CRX Extractor/Downloader: 
Search for the extension in the Chrome Web Store and add it to Chrome. (Manual step)

2. Install SelectorsHub/Ad Blocker: 
Search for the required extension in the Chrome Web Store and add it to Chrome. (Manual step)

3. Download the CRX file: 
Right-click the SelectorsHub extension, download its CRX file, and copy the file path.

4. Configure ChromeOptions: 
Pass the CRX file path in your automation script to load the extension.
 * */

public class EnableBrowserExtensions {

	// Enable SelectorsHub Extension in the Browser manually then use it through Automation script
	public static void main(String[] args) {
     ChromeOptions co = new ChromeOptions();
     File f1 = new File("E:\\SHIV SCRIPTS\\TestData\\SelectorsHub-Chrome-Web-Store.crx"); // Path of CRX File
     co.addExtensions(f1);
     WebDriver d = new ChromeDriver(co);
     d.get("https://demoqa.com/swagger");
     System.out.println("Browser with extension: "+d.getTitle());
     
    // Enable Ad-blocker Extension in the Browser manually then use Ad Blockers extension    
     File f2 = new File("E:\\SHIV SCRIPTS\\TestData\\Ad-Blocker-Stands-AdBlocker-Chrome-Web-Store.crx"); // Path of CRX File
     co.addExtensions(f2);
     d = new ChromeDriver(co);
     d.get("https://www.guru99.com/");
     System.out.println("Browser with extension: "+d.getTitle());
     d.quit();
	}

}
