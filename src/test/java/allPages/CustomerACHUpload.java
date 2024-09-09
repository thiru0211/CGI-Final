package allPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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

public class CustomerACHUpload extends Locators {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele1,ele2,ele3,ele4,ele5;
	static ExtentReports report;
	static ExtentTest test;
	static ExtentReports extent = new ExtentReports();
	
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
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
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

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void ACHUploadClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CustomerBtn)));
		driver.findElement(By.xpath(CustomerBtn)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ACHUploadBtn)));
		driver.findElement(By.xpath(ACHUploadBtn)).click();
	}


	@Test(priority = 1,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException {
		ACHUploadClick();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ACHUploadBtn)));
		driver.findElement(By.xpath(ACHUploadBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ACHSubBtn)));
		driver.findElement(By.xpath(ACHSubBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ACHManMsgChk)));
		ele1=driver.findElement(By.xpath(ACHManMsgChk));
		if(ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			String text = ele1.getText();
			System.out.println("Mandatory messagge displayed like: "+text);
		}
		else {
			System.out.println("Mandatory message is not shown");
		}
	}

	@Test(priority = 2,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException, AWTException {
		ACHUploadClick();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ACHUploadFileBtn)));
		driver.findElement(By.xpath(ACHUploadFileBtn)).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Blank.xlsx";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSubBtn)).click();
	}

	@Test(priority = 3,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException, AWTException {
		ACHUploadClick();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHUploadDateBtn)).click();
	}

	@Test(priority = 4,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException, AWTException {
		ACHUploadClick();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHUpldSampFilBtn)).click();
	}

	@Test(priority = 5,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException, AWTException {
		ACHUploadClick();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHFrmStupBtn)).click();
	}

	@Test(priority = 6,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException, AWTException {
		ACHUploadClick();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"installer\"]")));
		ele1=driver.findElement(By.xpath("//*[@id=\"installer\"]"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("LA SOLAR");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ACHUploadFileBtn)));
		driver.findElement(By.xpath(ACHUploadFileBtn)).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Blank.xlsx";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSubBtn)).click();
	}

	@Test(priority = 7,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException, AWTException {
		ACHUploadClick();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusListBtn)));
		driver.findElement(By.xpath(CusListBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusLisExclUpldBtn)).click();
		driver.findElement(By.xpath(CusLisExclUplSumBtn)).click();
		ele1=driver.findElement(By.xpath(CusLisExclMandMsg));
		if(ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			String text = ele1.getText();
			System.out.println("Mandatory message displayed like: "+text);
		}
		else {
			System.out.println("Mandatory message is not shown");
		}
	}

	@Test(priority = 8,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException, AWTException {
		ACHUploadClick();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusListBtn)));
		driver.findElement(By.xpath(CusListBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisExclUpldBtn)));
		driver.findElement(By.xpath(CusLisExclUpldBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"installer\"]")));
		ele1=driver.findElement(By.xpath("//*[@id=\"installer\"]"));
		Select sel=new Select(ele1);
		sel.selectByIndex(3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CusListExclUpldFilUpld)));
		driver.findElement(By.xpath(CusListExclUpldFilUpld)).click();
		String FilePath="C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Blank.xlsx";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSubBtn)).click();
	}


	@Test(priority = 9,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException, AWTException {
		TC07();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusListExclUpldDateBtn)).click();
	}

	// TC10=Need to click sample button but There is no sample button.

	@Test(priority = 10,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException, AWTException {
		String ACHInstlrDD=PropertyFileReader.propertymap.get("ACHInstlrDD");
		ACHUploadClick();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusListBtn)));
		driver.findElement(By.xpath(CusListBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusLisExclUpldBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusListExclUpldFilUpld)));
		driver.findElement(By.xpath(CusListExclUpldFilUpld)).click();
		Thread.sleep(2000);
		String FilePath="C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Blank.xlsx";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSubBtn)).click();
	}
}




