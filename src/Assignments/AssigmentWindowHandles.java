package Assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssigmentWindowHandles {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.partialLinkText("Multiple Windows")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		Set<String>window =  driver.getWindowHandles();
		Iterator<String> itr = window.iterator();
		String partenID = itr.next();
		String childID = itr.next();
		
		driver.switchTo().window(childID);
		
	System.out.println(driver.findElement(By.cssSelector("div h3")).getText());	
	driver.switchTo().window(partenID);
	System.out.println(driver.findElement(By.cssSelector("div h3")).getText());	
	
	}

}
