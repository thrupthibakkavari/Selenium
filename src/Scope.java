import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
         
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		        
				WebElement footdriverElement = driver.findElement(By.cssSelector("#gf-BIG"));
				
			System.out.println(footdriverElement.findElements(By.tagName("a")).size());	
	

	WebElement columElement= footdriverElement.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		
			System.out.println(columElement.findElements(By.tagName("a")).size());	
			for(int i = 1;i< columElement.findElements(By.tagName("a")).size(); i++)
			{
				String clickString = Keys.chord(Keys.CONTROL,Keys.ENTER);
				columElement.findElements(By.tagName("a")).get(i).sendKeys(clickString);
				Thread.sleep(5000);
			}
		
			Set<String> window = driver.getWindowHandles();
			Iterator<String> itr=window.iterator();
			while(itr.hasNext()) {
				
				driver.switchTo().window(itr.next());
			System.out.println(	driver.getTitle());
			
			}
			
			
			
			
			
			
			
			
			

	
	}

}
