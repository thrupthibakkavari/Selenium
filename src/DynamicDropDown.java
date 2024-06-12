import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    WebDriver driver = new ChromeDriver();
 
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
    
    driver.findElement(By.xpath("//a[@value='BLR']")).click();
    
    Thread.sleep(2000);
//    driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
    
//    without using index and using parent to child 
    
   ////div[@id ='glsctl00_mainContent_ddl_destinationStation1_CTNR']/a[@value='BLR']
    driver.findElement(By.xpath("//div[@id ='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Chennai (MAA)']")).click();
	}

}
