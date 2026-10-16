package P04_HandleWindows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleWindowMultipleTabs {

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demo.automationtesting.in/Windows.html");
		d.findElement(By.cssSelector("a > button.btn.btn-info")).click();

		Set<String> alltabs = d.getWindowHandles();
		List<String> alltabwindow = new ArrayList<String>(alltabs);
		System.out.println("FirstTabTitle: "+d.getTitle());
		String secondtab = alltabwindow.get(1);
		d.switchTo().window(secondtab);
		System.out.println("SecondTabTitle: "+d.getTitle());

		d.quit();

	}

}
