import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		String downloadPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akp88\\Documents\\chromedriver_win32\\chromedriver.exe");
		
		// To set a default directory
		
		HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		//To tell the chrome driver to prefer these options -chromePrefs
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.linkText("Select PDF files")).click();
		
		Thread.sleep(3000);
		
		//To execute something at runtime
		
		Runtime.getRuntime().exec("C:\\Users\\akp88\\Downloads\\Autoit_test\\fileupload.exe");
		
		Thread.sleep(3000);
		//Convert to JPG 
		driver.findElement(By.cssSelector(".btn")).click();
		
		Thread.sleep(3000);
		//To download the file
		driver.findElement(By.linkText("Download JPG images")).click();
		
		Thread.sleep(5000);
		
		File f = new File(downloadPath+"/th_page-0001.jpg");
		if(f.exists()) {
			System.out.println("File is found. Download succesfull");
			f.delete(){
				System.out.println("File is deleted");
			}
		}
		
		
	}

}
