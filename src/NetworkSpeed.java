import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
import org.openqa.selenium.devtools.v104.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akp88\\Documents\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		devTools.addListener(Network.loadingFailed(), loadingfail->{
			System.out.println(loadingfail.getErrorText());
			System.out.println(loadingfail.getTimestamp());
		});
		
		
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
	}

}
