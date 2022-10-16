import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsTest {

		public static final String USERNAME = "rahul2";

		  public static final String ACCESS_KEY = "xxxxx";

//		  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";



		public static void main(String[] args) throws MalformedURLException {

		// TODO Auto-generated method stub



//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		caps.setCapability("platform", "Windows 10");
//		caps.setCapability("version", "51.0");
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("latest");
		
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("build", "<your build id>");
		sauceOptions.put("name", "<your test name>");
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://USERNAME:ACCESS_KEY@ondemand.us-west-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		

//		WebDriver driver=new RemoteWebDriver(new URL(URL), browserOptions);

		driver.get("http://google.com");

		System.out.println(driver.getTitle());

		}


		
	}


