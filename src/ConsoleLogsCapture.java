import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akp88\\Documents\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("a[class='btn btn-lg btn-success']")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2", Keys.ENTER);
		
		// to get the logs
		
		// Get LogEntries object
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		
		//iterating through list and printing each log message
		List<LogEntry> logs = entry.getAll();
		
		for(LogEntry e:logs) {
			System.out.println(e.getMessage()); //Log4j
		}
		
		
	}

}
