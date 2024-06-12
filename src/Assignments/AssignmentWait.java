package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentWait {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-footer")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		WebElement dropdownElement = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select optionSelect = new Select(dropdownElement);
		optionSelect.selectByValue("consult");
	
//		driver.findElement(By.cssSelector("#terms")).click();
		//signInBtn
		driver.findElement(By.cssSelector("#signInBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		//"div[class='card h-100']"
		   List<WebElement> phonesElements=  driver.findElements(By.cssSelector(".btn.btn-info"));
		   
		   for(int i=0; i<phonesElements.size();i++) {
			   phonesElements.get(i).click();
			   
			  
		   }
		   driver.findElement(By.partialLinkText("Checkout")).click();
	}
	

}
