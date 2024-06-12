import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortingTablesStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//collect the webelements of the vegitables
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
		//create a list of texts in the above web elements list by using the streams
		List<String> ogList=list.stream().map(s-> s.getText()).collect(Collectors.toList());
		//sort the oglist with streams and create a newList
		List<String> newList = ogList.stream().sorted().collect(Collectors.toList());
		
		//assert wheather the two lists are equals or not 
		Assert.assertTrue(ogList.equals(newList));
		
		List<String> price ;
		
		do {
	
			List<WebElement> list1 = driver.findElements(By.xpath("//tr/td[1]"));
		price = list1.stream().filter(s->s.getText().contains("Rice")).map(s->getVegPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		
		if(price.size()<1) {
			
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		
		}while(price.size()<1);
		
	}
	
	public static String  getVegPrice(WebElement s) {
		
		String Vegprice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return Vegprice;
	}

}
