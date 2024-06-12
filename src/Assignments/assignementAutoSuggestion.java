package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignementAutoSuggestion {
	public static void main(String[] args) throws InterruptedException {
		
		
		
		  WebDriver driver = new ChromeDriver();
	      driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	      
	      driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).sendKeys("ind");
	      Thread.sleep(5000);
	      driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).sendKeys(Keys.DOWN);
	      driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).sendKeys(Keys.DOWN);
	   
	      
	      System.out.println( driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).getAttribute("value"));
	}
}
