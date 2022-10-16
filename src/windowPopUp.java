import org.openqa.selenium.chrome.ChromeDriver;

public class windowPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akp88\\Documents\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Provide the username and password
		// Basic syntax of the URL is http://Username:Password@SiteURL
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}

}
