import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequests {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// css, images

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akp88\\Documents\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css") ));
		
		long startTime = System.currentTimeMillis();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("a[class='btn btn-lg btn-success']")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		driver.findElement(By.linkText("Cart")).click();
//		driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
		
//		Thread.sleep(3000);
	}

}
