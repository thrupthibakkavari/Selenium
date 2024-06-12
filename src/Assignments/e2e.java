package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(4000);
		List<WebElement> optionElements = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		for (WebElement option : optionElements) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@value='OneWay']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']"))
				.click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

		{
			System.out.println("its disabled");

			Assert.assertTrue(true);

		}

		else

		{

			Assert.assertTrue(false);

		}
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=1 ; i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.xpath("//div[@class='ad-row align-center']/input")).click();
		
		WebElement dropoptionsElements = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropDown = new Select(dropoptionsElements);
		dropDown.selectByValue("INR");
		//ctl00_mainContent_chk_SeniorCitizenDiscount
		
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected();
		//ctl00_mainContent_btn_FindFlights
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
