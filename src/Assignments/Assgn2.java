package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assgn2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Jules");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Jules@123.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement optionElement = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select optionSelect =new Select(optionElement);
		optionSelect.selectByVisibleText("Female");
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("2000-08-22");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
	}

}
