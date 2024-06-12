import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExcutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      WebDriver driver = new ChromeDriver();
      driver.get("https://rahulshettyacademy.com/AutomationPractice/");
      
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,500)");
      js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
      
      
      int sum =0 ;
      
      List<WebElement> list = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
      for (int i =0 ; i< list.size(); i++)
      {
    	  sum= sum+ Integer.parseInt(list.get(i).getText());
    	  
      }
      System.out.println(sum);
      
      driver.findElement(By.cssSelector(".totalAmount")).getText();
     
  int total=    Integer.parseInt( driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
      
       Assert.assertEquals(sum, total);
      
	}

}
