import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> listlink = driver.findElements(By.cssSelector("table[class='gf-t'] a"));
		SoftAssert a = new SoftAssert();

		for (WebElement linkElement : listlink) {
			String url = linkElement.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respocode = conn.getResponseCode();

			System.out.println(respocode);
			a.assertTrue(respocode < 400, "the link " + linkElement.getText() + " is broken");
       
		}

		a.assertAll();
		
		
	}

}



// get the urls tied up to the links with selinuim
// then use java methods to call the urls and get ypou the status code
// if the status code >400 then url is not working -- link is broken
//By using softAssert , we can store all the broken link. It will check all the link for broken links 
//rather than stopping when one broken link is found 
//



 