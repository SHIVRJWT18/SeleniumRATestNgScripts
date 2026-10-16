package P13_TakeScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullPageScreenShot {

		public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver d = new ChromeDriver();
		// ChromeDriver cd = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://www.jio.com/");
		Thread.sleep(9000);
		// TakesScreenshot ts = cd;
	    TakesScreenshot ts = (TakesScreenshot)d;
	    File f1 = ts.getScreenshotAs(OutputType.FILE);
	    File f2 = new File("./Evidences/ScrShot3.png");
	    File f3 =  new File(System.getProperty("user.dir")+"\\Evidences\\ScrShot2.png");
	    FileUtils.copyFile(f1, f2);
	    f1.renameTo(f3);
	    FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("./Evidences/ScrShot1.png"));

		 d.close();

	}

}
