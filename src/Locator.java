import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 // get the url 
		 driver.get("https://rahulshettyacademy.com/locatorspractice/");
		 //find the element 
//		//and sendKeys("rahul") is used to send the vaule "rahul" to the respective id 
		 
		 driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		 driver.findElement(By.name("inputPassword")).sendKeys("hello");
		 driver.findElement(By.className("signInBtn")).click(); //sign_in is  button to we use click button
		// create the css Selector for class as tagname.classname)
//		 css Selector for id as tagname#id
//		 without any id or classname present tagname[attribute='value']
		 driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click(); // name of the link 
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@placeholder ='Email']")).sendKeys("john@123.com");// for Xpath == (//tagname[@attribute='value']
	     driver.findElement(By.cssSelector("input[placeholder='Name']")).clear();	
	     driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("Johnn");
		 driver.findElement(By.xpath("//form/input[3]")).sendKeys("7584764734");
		 driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]")).click();
		//div/label
		 System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		 
		 
		 driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		 driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
//		 rahulshettyacademy
		 driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		//div/label
		 
		 
		 driver.findElement(By.id("chkboxOne")).click();
		 driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		 
	}

}
