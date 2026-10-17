package P14_HandleFileActions;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoItFileUpload
{

 @SuppressWarnings("deprecation")
public static void main(String[] args) throws InterruptedException, IOException
 {
	    WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demoqa.com/upload-download");
		Thread.sleep(5000);
	    d.findElement(By.xpath("//input[@type='file']")).click();
	    Thread.sleep(5000);
	    /*
	    1. Install:
           AutoIT software
           SciTE Script Editor (comes with it)

        2. Open SciTE Editor and write:

           WinWaitActive("Open")
           Send("C:\\Users\\Dell\\Downloads\\sampleFile.jpeg")
           Send("{ENTER}")

        3. Right click file:

           upload.au3 → Compile Script

        4. You will get: upload.exe

	    */
	    Runtime.getRuntime().exec(
                "E:\\SHIV SCRIPTS\\Selenium MScripts\\MyUploadAutoIt.exe"
        );

        System.out.println("File upload triggered using AutoIT");

        d.quit();
 }

}
