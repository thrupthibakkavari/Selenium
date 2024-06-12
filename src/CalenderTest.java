import java.lang.invoke.CallSite;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderTest {

	public static void main(String[] args) {
		
		String date= "15";
		String monthString="7";
		String yearString= "2026";
		String [] dateStrings= {monthString,date,yearString};
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        //react-calendar__navigation__label
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+yearString +"']")).click();
      
	driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthString)-1).click();
	driver.findElement(By.xpath("//abbr[text()='"+date+"']" )).click();
	
	List<WebElement> list= driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
	
	for(int i =0; i<list.size() ;i++)
	
	{
		
		System.out.println(list.get(i).getAttribute("value"));
		Assert.assertEquals(list.get(i).getAttribute("value"), dateStrings[i]);
	}
	
	driver.close();
	}

}
