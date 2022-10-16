import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
import org.openqa.selenium.devtools.v104.network.model.Request;
import org.openqa.selenium.devtools.v104.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akp88\\Documents\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		// Event will be fired.
		devTools.addListener(Network.requestWillBeSent(), request->{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
			// req.getHeader();
		});
		
		devTools.addListener(Network.responseReceived(), response ->
		{
			Response res = response.getResponse();
//			System.out.println(res.getUrl());
			System.out.println(res.getStatus());
//			if(res.getStatus().toString.startsWith("4"))
//			{
//			
//		}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	}

}
