import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akp88\\Documents\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Predicate give your filter and returns based on fiter.
		Predicate<URI> uriPredicate = uri ->  uri.getHost().contains("httpbin.org");
				
		// To make sure your web page has some form of authentication
		// you must inform/register the driver
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
				
				
	}

}
