package Assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Assign {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		driver.findElement(By.cssSelector("#checkBoxOption3")).click();
		String textString = driver.findElement(By.xpath("(//label)[6]")).getText(); 
				
		WebElement selectString =  driver.findElement(By.id("dropdown-class-example"));	 
		Select dropSelect= new Select(selectString);
	    dropSelect.selectByVisibleText(textString);
	    
	    driver.findElement(By.cssSelector("#name")).sendKeys(textString);
	    driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
	    
	String alertString=    driver.switchTo().alert().getText();
	
	if (alertString.contains(textString)) {
		
		System.out.println(textString + " is Selected");
	}
	    
	 
		
		
	}

}
