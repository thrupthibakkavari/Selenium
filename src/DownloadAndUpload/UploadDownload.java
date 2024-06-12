package DownloadAndUpload;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.Adler32;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.ietf.jgss.Oid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v122.domdebugger.model.CSPViolationType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownload {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  String updatedValue = "603";
		String fruitName = "Apple";
		String filename = " C:\\Users\\pc\\Downloads\\download.xlsx";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/upload-download-test/");

		// download the file

		driver.findElement(By.id("downloadButton")).click();

		// edit the excel

		int col = getColumnNumber(filename, "price");
		int row = getRowNumber(filename, "Apple");
		
		Assert.assertTrue(updateCell(filename,row,col,updatedValue));
		// upload the file

		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys("C:\\Users\\pc\\Downloads\\download.xlsx");

		// wait for success message to show up and wait for disappear

		By toastText = By.cssSelector(".Toastify__toast-body");

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));

		w.until(ExpectedConditions.visibilityOfElementLocated(toastText));

		String txtString = driver.findElement(toastText).getText();

		Assert.assertTrue(txtString.equalsIgnoreCase("Updated Excel Data Successfully."));

		// verify updated excel data showing in web tables
		w.until(ExpectedConditions.invisibilityOfElementLocated(toastText));

		String colunm = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");

		String price = driver.findElement(By.xpath(
				"//div[text()='" + fruitName + "']/parent::div/parent::div/div[@id='cell-" + colunm + "-undefined']"))
				.getText();

		Assert.assertEquals(updatedValue, price);
		driver.close();

	}

	private static int getRowNumber(String filename, String text) throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fileInputStream = new FileInputStream(filename);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int row = 0;
		int k = 1;
		Iterator<Row> rows = sheet.iterator();
		while (rows.hasNext()) {

			Row r = rows.next();

			Iterator<Cell> ce = r.cellIterator();

			while (ce.hasNext()) {

				Cell cell1 = ce.next();
				if (cell1.getStringCellValue().equalsIgnoreCase(text))
					;
				{
					row = k;
				}

			}
			k++;

		}

		return row;

	}

	private static int getColumnNumber(String filename, String colSName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fileInputStream = new FileInputStream(filename);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);

//				 Identify the relevant Column(TestCases) all the rows from the sheet
		Iterator<Row> rows = sheet.iterator();
		Row firstRow = rows.next();
		Iterator<Cell> cell = firstRow.cellIterator();
		int k = 0;
		int column = 1;
		while (cell.hasNext()) {

			Cell value = cell.next();
			if (value.getStringCellValue().equalsIgnoreCase(colSName)) {

				column = k;
			}
			k++;
		}
		System.out.println(column);

		return column;

	}

	public static boolean updateCell(String filename, int row, int col, String updatedValue) throws IOException {

		FileInputStream fis = new FileInputStream(filename);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row rowField = sheet.getRow(row - 1);
		Cell cellField = rowField.getCell(col - 1);
		cellField.setCellValue(updatedValue);
		FileOutputStream fos = new FileOutputStream(filename);
		workbook.write(fos);
		workbook.close();
		fis.close();
	
		
		return true;

	}

}
