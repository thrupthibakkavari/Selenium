import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement source= driver.findElement(By.cssSelector("#draggable"));
		WebElement target = driver.findElement(By.cssSelector("#droppable"));
		
		
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
	}

}
