package Selenium4_Features;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.jar.Attributes.Name;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.NoSuchDriverException;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> itr = window.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();
		driver.switchTo().window(parentWindow);
	WebElement course	= driver.findElement(By.cssSelector("[name='name']"));
	course.sendKeys(courseName);
		
	   File src=  course.getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(src, new File("logo.png"));
	   
	   System.out.println(course.getRect().getDimension().getHeight());
	   System.out.println(course.getRect().getDimension().getWidth());
	   
	   
	   
	   
	   
		
	}

}
