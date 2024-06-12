import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class actions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
	
		WebElement move= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		
		
		
         Actions a = new Actions(driver);
		a.moveToElement(move).build().perform();		
		a.moveToElement(driver.findElement(By.id("nav-search-bar-form"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		a.moveToElement(move).contextClick().build().perform();
		driver.close();
		
	}

}
