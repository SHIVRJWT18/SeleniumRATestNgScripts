package P14_HandleFileActions;

import java.awt.AWTException;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadPopup {

	public static void main(String[] args) throws InterruptedException, AWTException {
	WebDriver d = new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	d.get("https://demoqa.com/upload-download");
	d.findElement(By.xpath("//a[text()='Download']")).click();

	String downloadPath = "C:\\Users\\Dell\\Downloads";
    String fileName = "sampleFile.jpeg";

    File file = new File(downloadPath + "\\" + fileName);

    int waitTime = 0;

    while (!file.exists() && waitTime < 10) {

        Thread.sleep(1000);

        waitTime++;
    }

    if (file.exists()) {

        System.out.println("File downloaded successfully");

    } else {

        System.out.println("File not downloaded");
    }

    if (file.exists()) {

        System.out.println("Downloaded File is exist");

        // delete file
        if (file.delete()) {

            System.out.println("File deleted successfully");

        } else {

            System.out.println("File not deleted");
        }

    } else {

        System.out.println("File not downloaded");
    }

    d.quit();

	}

}
