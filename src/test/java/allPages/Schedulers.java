package allPages;

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

public class Schedulers extends Locators{
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
	public void tearDown() throws IOException, InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void ACHSchedulerBtn() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SchedBtn)));
		driver.findElement(By.xpath(SchedBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSchBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void NoPaymentBtn() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SchedBtn)));
		driver.findElement(By.xpath(SchedBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SCHNoPayBtn)).click();
	}

	@Test(priority = 1,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException {
		ACHSchedulerBtn();
		String ScheBankDD=PropertyFileReader.propertymap.get("ScheBankDD");
		String SchFromDate=PropertyFileReader.propertymap.get("SchFromDate");
		ele1=driver.findElement(By.xpath(SchBankDD));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(ScheBankDD);
		Thread.sleep(2000);
		ele2=driver.findElement(By.xpath(SchFrmDte));
		//ele2.sendKeys(SchFromDate);
		String desiredDate = "01-01-2023";
		
		if (desiredDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
			ele2.sendKeys(desiredDate);
		} else {
		    // Handle invalid date format (e.g., display an error message)
		    System.out.println("Invalid date format. Please use YYYY-MM-DD.");
		}
	}

	@Test(priority = 2,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException {
		TC01();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SchCusViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(SchCusActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(SchCusFileLogBtn)).click();
	}

	@Test(priority = 3,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException {
		TC01();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SchCusViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(SchCusActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(SchCusFileExcelExpBtn)).click();
	}

	@Test(priority = 4,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException {
		TC01();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SchCusViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(SchCusActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(SchCusFileBckBtn)).click();
	}

	@Test(priority = 5,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException {
		TC01();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(SchActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(SchExcelExpBtn)).click();
	}

	@Test(priority =6,retryAnalyzer = ReRunFailedTestCase.class )
	public void TC06() throws InterruptedException {
		TC01();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(SchActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(SCHAchSchBtn)).click();
	}

	
	@Test(priority = 8,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException {
		NoPaymentBtn();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(NoPayActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayStopBtn)).click();
	}

	@Test(priority = 7,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException {
		NoPaymentBtn();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(NoPayActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayRunBtn)).click();
	}

	@Test(priority = 9,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException {
		NoPaymentBtn();
		driver.findElement(By.name(NoPaySunBtn)).click();
		driver.findElement(By.name(NoPayMonBtn)).click();
		driver.findElement(By.name(NoPayTueBtn)).click();
		driver.findElement(By.name(NoPayWedBtn)).click();
		driver.findElement(By.name(NoPayThurBtn)).click();
		driver.findElement(By.name(NoPayFriBtn)).click();
		driver.findElement(By.name(NoPaySatBtn)).click();
	}

	@Test(priority = 10,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException {
		NoPaymentBtn();
		driver.findElement(By.xpath(NoPayAddUsr)).click();
		driver.findElement(By.xpath(NoPayAddUsrSavBtn)).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]")));
		ele1=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]"));
		if(ele1.isDisplayed()) {
			String text = ele1.getText();
			System.out.println("Alert message displayed like: "+text);
		}
		else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(priority = 11,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException {
		NoPaymentBtn();
		driver.findElement(By.xpath(NoPayAddUsr)).click();
		driver.findElement(By.xpath(NoPayAddUSrNameBtn)).click();
		driver.findElement(By.xpath(NoPayAddUsrSavBtn)).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]")));
		ele1=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]"));
		if(ele1.isDisplayed()) {
			String text = ele1.getText();
			System.out.println("Alert message displayed like: "+text);
		}
		else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(priority =12,retryAnalyzer = ReRunFailedTestCase.class )
	public void TC12() throws InterruptedException {
		NoPaymentBtn();
		driver.findElement(By.xpath(NoPayAddUsr)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayAddUsrClsBtn)).click();
	}

	@Test(priority = 13,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException {
		NoPaymentBtn();
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayExtAddUsrBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayExtAddUsrSavBtn)).click();
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/form/div/div[2]/div[2]/div[1]/div/div")));
		ele1=driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/form/div/div[2]/div[2]/div[1]/div/div"));
		ele2=driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/form/div/div[2]/div[2]/div[2]/div/div"));
		if(ele1.isDisplayed()) {
			String text = ele1.getText();
			String text2 = ele2.getText();
			System.out.println("Alert message displayed like: "+text);
			System.out.println("Alert message displayed like: "+text2);
		}
		else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(priority = 14,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException {
		NoPaymentBtn();
		String NPUsrName=PropertyFileReader.propertymap.get("NPUsrName");
		String NPMailId=PropertyFileReader.propertymap.get("NPMailId");
		String NPUsrTyp=PropertyFileReader.propertymap.get("NPUsrTyp");
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayExtAddUsrBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(NoPayExtAddUsrName)).sendKeys(NPUsrName);
		driver.findElement(By.name(NoPayExtAddUsrMail)).sendKeys(NPMailId);
		driver.findElement(By.name(NoPayExtAddUsrTyp)).sendKeys(NPUsrTyp);
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayExtAddUsrClrBtn)).click();
	}

	@Test(priority = 15,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException {
		NoPaymentBtn();
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayExtAddUsrBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayExtClsBtn)).click();
	}

	@Test(priority = 16,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException {
		NoPaymentBtn();
		String NPUsrName=PropertyFileReader.propertymap.get("NPUsrName");
		String NPMailId=PropertyFileReader.propertymap.get("NPMailId");
		String NPUsrTyp=PropertyFileReader.propertymap.get("NPUsrTyp");
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayExtAddUsrBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(NoPayExtAddUsrName)).sendKeys(NPUsrName);
		driver.findElement(By.name(NoPayExtAddUsrMail)).sendKeys(NPMailId);
		driver.findElement(By.name(NoPayExtAddUsrTyp)).sendKeys(NPUsrTyp);
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPayExtAddUsrSavBtn)).click();
	}

	@Test(priority = 17,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC17() throws InterruptedException {
		NoPaymentBtn();
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPaySavBtn)).click();
	}

	@Test(priority = 18,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC18() throws InterruptedException {
		NoPaymentBtn();
		Thread.sleep(2000);
		String NPSignUsrID=PropertyFileReader.propertymap.get("NPSignUsrID");
		ele1=driver.findElement(By.xpath(NoPayEmailSign));
		Select sel=new Select(ele1);
		sel.selectByVisibleText(NPSignUsrID);
		Thread.sleep(2000);
		driver.findElement(By.xpath(NoPaySavBtn)).click();
	}
}


