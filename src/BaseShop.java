import java.io.ObjectInputStream.GetField;
import java.lang.foreign.AddressLayout;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseShop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		

		addIteams(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		//input.promoCode
	 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void addIteams(WebDriver driver,String[] itemsNeeded ) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j =0;
		
		for(int i =0 ; i<products.size() ; i++) {
			
			String [] itemStrings= products.get(i).getText().split("-");
			String formatedName = itemStrings[0].trim();
			
			
			List list=Arrays.asList(itemsNeeded);
			if (list.contains(formatedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length)

				{

					break;

				}
			}
		}
	}
	
}