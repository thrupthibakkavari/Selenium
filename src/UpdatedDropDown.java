import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	System.out.println(driver.findElements(By.cssSelector("input[type*='checkbox']")).size());
		
		
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		for (int i=1; i< 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
//		int i=0;
//		while(i< 5) {
//			driver.findElement(By.id("hrefIncAdt")).click();
//			i++;
//			
//		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
