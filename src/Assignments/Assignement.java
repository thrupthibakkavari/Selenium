package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  WebDriver driver = new ChromeDriver();
	      driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	      
	      WebElement tabledriver = driver.findElement(By.cssSelector(".table-display"));
	    
	   int rowCount=   tabledriver.findElements(By.tagName("tr")).size();
	   int colCount = tabledriver.findElements(By.tagName("th")).size();
	   int colmnCount = tabledriver.findElements(By.tagName("td")).size();
	   int columnCount = colCount+colmnCount;
	   
	   System.out.println(rowCount);
	   System.out.println(columnCount);
	   
	   List<WebElement> secondrow=tabledriver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
	   
	   System.out.println(secondrow.get(0).getText()+" "+secondrow.get(1).getText()+" "+secondrow.get(2).getText());

	  
	}

}
