package allPages;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerGroup extends Locators {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele1,ele2,ele3,ele4,ele5;
	static ExtentReports report;
	static ExtentTest test;
	static ExtentReports extent=new ExtentReports();
	@BeforeMethod
	public void setUp() throws IOException{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--headless=new");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		driver.get("http://192.168.1.36/CGI/auth");
//		File file=new File("C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOnee\\Data.properties");
//		FileInputStream FIS=new FileInputStream(file);
//		Properties prop=new Properties();
//		prop.load(FIS);	
	}

		@AfterMethod
		public void tearDown() throws IOException, InterruptedException{
			Thread.sleep(3000);
			driver.quit();
}
	
	@Test(priority = 1,retryAnalyzer = ReRunFailedTestCase.class)
	public void CustomerGroupBtnClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");

		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(SetupBtn)).click();
		driver.findElement(By.xpath(CusGrpBtn)).click();
		
	}

	@Test(priority = 2,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		String CusSrchName=PropertyFileReader.propertymap.get("CusSrchName");
		String CusStsEnbl=PropertyFileReader.propertymap.get("CusStsEnbl");
		String CusStsDsbl=PropertyFileReader.propertymap.get("CusStsDsbl");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		
		driver.findElement(By.xpath(CusSrchBox)).sendKeys(CusSrchName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusStsDD)));
		ele1 = driver.findElement(By.xpath(CusStsDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusStsEnbl);
		Thread.sleep(1000);
		sel.selectByVisibleText(CusStsDsbl);
		Thread.sleep(1000);
		sel.selectByVisibleText(CusStsEnbl);
	}
	
	
	@Test(priority = 3,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		String CusSelInstlrName=PropertyFileReader.propertymap.get("CusSelInstlrName");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddBtn)));
		driver.findElement(By.xpath(CusAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(CusSelInstlrDD)));
		ele1 = driver.findElement(By.id(CusSelInstlrDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusSelInstlrName);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusGrpName)));
		driver.findElement(By.name(CusGrpName)).sendKeys(CusGrpName);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusGrpStsEnbl)));
		driver.findElement(By.name(CusGrpStsEnbl)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(CusGrpClrBtn)));
		driver.findElement(By.id(CusGrpClrBtn)).click();
	}

	@Test(priority = 4,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		String CusSelInstlrName=PropertyFileReader.propertymap.get("CusSelInstlrName");
		String CustGrpName=PropertyFileReader.propertymap.get("CustGrpName");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddBtn)));
		driver.findElement(By.xpath(CusAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(CusSelInstlrDD)));
		ele1 = driver.findElement(By.id(CusSelInstlrDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(CusSelInstlrName);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusGrpName)));
		driver.findElement(By.name(CusGrpName)).sendKeys(CustGrpName);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusGrpStsEnbl)));
		driver.findElement(By.name(CusGrpStsEnbl)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusGrpSavBtn)));
		driver.findElement(By.xpath(CusGrpSavBtn)).click();
	}
	
	@Test(priority = 5,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddBtn)));
		driver.findElement(By.xpath(CusAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusGrpCloseBtn)));
		driver.findElement(By.xpath(CusGrpCloseBtn)).click();
	}
	
	
	@Test(priority = 6,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException, AWTException {
		CustomerGroupBtnClick();
		String CusSrchName=PropertyFileReader.propertymap.get("CusSrchName");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusSrchBox)));
		driver.findElement(By.xpath(CusSrchBox)).sendKeys(CusSrchName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusGrpEditBtn)));
		driver.findElement(By.xpath(CusGrpEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusGrpEditStsDsbl)));
		driver.findElement(By.xpath(CusGrpEditStsDsbl)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(CusGrpEditClrBtn)));
		driver.findElement(By.id(CusGrpEditClrBtn)).click();	
	}
	
	
}
