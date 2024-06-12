import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//invoke the Browers
		// to use chrome we can use thrid party chromedriver.exe or Selenium manager can invoke directly 
		
//			WebDriver driver = new ChromeDriver();
		
//		WebDriver driver = new FirefoxDriver();
			// to invoke Microsoft egde 
			// nedd to download egde driver as thrid party driver ans use as below msedgedriver.exe
			System.setProperty("webdriver.edge.driver", "C:\\Users\\pc\\OneDrive\\Documents\\msedgedriver.exe");
		
			WebDriver driver = new EdgeDriver();
			driver.get("https://chatgpt.com/");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.close();
		//driver.quit();
	}

}
