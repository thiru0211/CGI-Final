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
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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

public class InstallerSetup extends Locators {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele1, ele2, ele3, ele4, ele5;
	static ExtentReports report;
	static ExtentTest test;
	static ExtentReports extent = new ExtentReports();
	
	@BeforeMethod
	public void setUp() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		driver.get("http://192.168.1.36/CGI/auth");
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
//		File file = new File("C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOnee\\Data.properties");
//		FileInputStream FIS = new FileInputStream(file);
//		Properties prop = new Properties();
//		prop.load(FIS);
	}

	@AfterMethod
	public void tearDown() throws IOException, InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(priority = 1, retryAnalyzer = ReRunFailedTestCase.class)
	public void InstallerBtnClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(SetupBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(InstallerBtn));
		ele2.click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[1]/span[2]/div/select")));
		ele1 = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[1]/span[2]/div/select"));
		Select sel = new Select(ele1);
		sel.selectByVisibleText("All");
	}

	@Test(priority = 3, retryAnalyzer = ReRunFailedTestCase.class)
	public void EnterAllDetails() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstlrName = PropertyFileReader.propertymap.get("InstlrName");
		String CntryDD = PropertyFileReader.propertymap.get("CntryDD");
		String StateDD = PropertyFileReader.propertymap.get("StateDD");
		String Add1 = PropertyFileReader.propertymap.get("Add1");
		String Add2 = PropertyFileReader.propertymap.get("Add2");
		String InstlrCity = PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode = PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone = PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail = PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite = PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy = PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName = PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl = PropertyFileReader.propertymap.get("CRMUrl");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstAddBtn)));
		ele1 = driver.findElement(By.xpath(InstAddBtn));
		ele1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstName)));
		driver.findElement(By.name(InstName)).sendKeys(InstlrName);
		ele4 = driver.findElement(By.xpath(InstStatusEnbl));
		ele4.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstCntryDD)));
		ele2 = driver.findElement(By.name(InstCntryDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(CntryDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstStateDD)));
		ele3 = driver.findElement(By.name(InstStateDD));
		Select sel1 = new Select(ele3);
		sel1.selectByVisibleText(StateDD);
		Thread.sleep(1000);
		driver.findElement(By.name(InstAdres1)).sendKeys(Add1);
		Thread.sleep(1000);
		driver.findElement(By.name(InstAdres2)).sendKeys(Add2);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstCity)));
		driver.findElement(By.name(InstCity)).sendKeys(InstlrCity);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstZipCode)));
		driver.findElement(By.name(InstZipCode)).sendKeys(ZipCode);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstPhone)));
		driver.findElement(By.name(InstPhone)).sendKeys(InstlrPhone);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstEmail)));
		driver.findElement(By.name(InstEmail)).sendKeys(InstlrMail);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstWebsite)));
		driver.findElement(By.name(InstWebsite)).sendKeys(InstlrWebSite);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstInvoiceCpy)));
		driver.findElement(By.name(InstInvoiceCpy)).sendKeys(InstlrInvCpy);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstCrmName)));
		driver.findElement(By.name(InstCrmName)).sendKeys(CRMName);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstCrmUrl)));
		driver.findElement(By.name(InstCrmUrl)).sendKeys(CRMUrl);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstApiActNo)));
		driver.findElement(By.xpath(InstApiActNo)).click();
	}

	@Test(priority = 2, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException, AWTException {
		InstallerBtnClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstAddBtn)));
		ele1 = driver.findElement(By.xpath(InstAddBtn));
		ele1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstSaveBtn)));
		driver.findElement(By.xpath(InstSaveBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstAlrtMsg)));
		ele2 = driver.findElement(By.xpath(InstAlrtMsg));
		if (ele2.isDisplayed()) {
			System.out.println("Mandatory alert message is shown");
			ele3 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele3.getText();
			System.out.println("Alert message displayed like: " + text);
			ele2.click();
		} else {
			System.out.println("Mandatory alert message is not shown");
		}
	}

	@Test(priority = 4, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException, AWTException {
		EnterAllDetails();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(InstClrBtn)));
		ele1 = driver.findElement(By.id(InstClrBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		ele1.click();
	}

	@Test(priority = 5, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException, AWTException {
		EnterAllDetails();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstSaveBtn)));
		ele1 = driver.findElement(By.xpath(InstSaveBtn));
		ele1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]")));
		ele2 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]"));
		if (ele2.isDisplayed()) {
			String text = ele2.getText();
			System.out.println("Alert message displayed like: " + text);
			wait.until(ExpectedConditions.elementToBeClickable(By.name(InstName)));
			ele3 = driver.findElement(By.name(InstName));
			String text2 = ele3.getText();
			ele3.sendKeys(text2 + "a");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstSaveBtn)));
			ele1 = driver.findElement(By.xpath(InstSaveBtn));
			ele1.click();

		} else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(priority = 6, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstlrName = PropertyFileReader.propertymap.get("InstlrName");
		String CntryDD = PropertyFileReader.propertymap.get("CntryDD");
		String StateDD = PropertyFileReader.propertymap.get("StateDD");
		String Add1 = PropertyFileReader.propertymap.get("Add1");
		String Add2 = PropertyFileReader.propertymap.get("Add2");
		String InstlrCity = PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode = PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone = PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail = PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite = PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy = PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName = PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl = PropertyFileReader.propertymap.get("CRMUrl");
		ele1 = driver.findElement(By.xpath(InstAddBtn));
		ele1.click();
		driver.findElement(By.name(InstName)).sendKeys(InstlrName);
		driver.findElement(By.xpath(InstStatusDSbl)).click();
		ele2 = driver.findElement(By.name(InstCntryDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(CntryDD);
		Thread.sleep(3000);
		ele3 = driver.findElement(By.name(InstStateDD));
		Select sel1 = new Select(ele3);
		sel1.selectByVisibleText(StateDD);
		driver.findElement(By.name(InstAdres1)).sendKeys(Add1);
		driver.findElement(By.name(InstAdres2)).sendKeys(Add2);
		driver.findElement(By.name(InstCity)).sendKeys(InstlrCity);
		driver.findElement(By.name(InstZipCode)).sendKeys(ZipCode);
		driver.findElement(By.name(InstPhone)).sendKeys(InstlrPhone);
		driver.findElement(By.name(InstEmail)).sendKeys(InstlrMail);
		driver.findElement(By.name(InstWebsite)).sendKeys(InstlrWebSite);
		driver.findElement(By.name(InstInvoiceCpy)).sendKeys(InstlrInvCpy);
		driver.findElement(By.name(InstCrmName)).sendKeys(CRMName);
		driver.findElement(By.name(InstCrmUrl)).sendKeys(CRMUrl);
		driver.findElement(By.xpath(InstApiActNo)).click();
		driver.findElement(By.xpath(InstSaveBtn)).click();
	}

	@Test(priority = 7, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException, AWTException {
		InstallerBtnClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstAddBtn)));
		driver.findElement(By.xpath(InstAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstBackBtn)));
		driver.findElement(By.xpath(InstBackBtn)).click();
	}

	@Test(priority = 8, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstActionsBtn)));
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EditInstaller)));
		driver.findElement(By.xpath(EditInstaller)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstBackBtn)));
		driver.findElement(By.xpath(InstBackBtn)).click();
	}

	@Test(priority = 9, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		String ModifiedInstName = PropertyFileReader.propertymap.get("ModifiedInstName");
		String CntryDD = PropertyFileReader.propertymap.get("CntryDD");
		String StateDD = PropertyFileReader.propertymap.get("StateDD");
		String Add1 = PropertyFileReader.propertymap.get("Add1");
		String Add2 = PropertyFileReader.propertymap.get("Add2");
		String InstlrCity = PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode = PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone = PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail = PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite = PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy = PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName = PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl = PropertyFileReader.propertymap.get("CRMUrl");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstSearchBtn)));
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstActionsBtn)));
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EditInstaller)));
		driver.findElement(By.xpath(EditInstaller)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstName)));
		ele1 = driver.findElement(By.name(InstName));
		String text = ele1.getAttribute("value");
		ele1.clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InstName)));
		ele2 = driver.findElement(By.name(InstName));
		ele2.sendKeys(text);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(InstResetBtn)));
		driver.findElement(By.id(InstResetBtn)).click();
	}

	@Test(priority = 10, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		String ModifiedInstName = PropertyFileReader.propertymap.get("ModifiedInstName");
		String CntryDD = PropertyFileReader.propertymap.get("CntryDD");
		String StateDD = PropertyFileReader.propertymap.get("StateDD");
		String Add1 = PropertyFileReader.propertymap.get("Add1");
		String Add2 = PropertyFileReader.propertymap.get("Add2");
		String InstlrCity = PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode = PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone = PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail = PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite = PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy = PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName = PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl = PropertyFileReader.propertymap.get("CRMUrl");
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInstaller)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(InstResetBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(InstName)).sendKeys(ModifiedInstName);
		ele4 = driver.findElement(By.xpath(InstStatusDSbl));
		ele4.click();
		ele2 = driver.findElement(By.name(InstCntryDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(CntryDD);
		Thread.sleep(3000);
		ele3 = driver.findElement(By.name(InstStateDD));
		Select sel1 = new Select(ele3);
		sel1.selectByVisibleText(StateDD);
		driver.findElement(By.name(InstAdres1)).sendKeys(Add1);
		driver.findElement(By.name(InstAdres2)).sendKeys(Add2);
		driver.findElement(By.name(InstCity)).sendKeys(InstlrCity);
		driver.findElement(By.name(InstZipCode)).sendKeys(ZipCode);
		driver.findElement(By.name(InstPhone)).sendKeys(InstlrPhone);
		driver.findElement(By.name(InstEmail)).sendKeys(InstlrMail);
		driver.findElement(By.name(InstWebsite)).sendKeys(InstlrWebSite);
		driver.findElement(By.name(InstInvoiceCpy)).sendKeys(InstlrInvCpy);
		driver.findElement(By.name(InstCrmName)).sendKeys(CRMName);
		driver.findElement(By.name(InstCrmUrl)).sendKeys(CRMUrl);
		driver.findElement(By.xpath(InstApiActNo)).click();
		driver.findElement(By.xpath(InstUpdateBtn)).click();
	}

	@Test(priority = 11, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		String ModifiedInstName = PropertyFileReader.propertymap.get("ModifiedInstName");
		String CntryDD = PropertyFileReader.propertymap.get("CntryDD");
		String StateDD = PropertyFileReader.propertymap.get("StateDD");
		String Add1 = PropertyFileReader.propertymap.get("Add1");
		String Add2 = PropertyFileReader.propertymap.get("Add2");
		String InstlrCity = PropertyFileReader.propertymap.get("InstlrCity");
		String ZipCode = PropertyFileReader.propertymap.get("ZipCode");
		String InstlrPhone = PropertyFileReader.propertymap.get("InstlrPhone");
		String InstlrMail = PropertyFileReader.propertymap.get("InstlrMail");
		String InstlrWebSite = PropertyFileReader.propertymap.get("InstlrWebSite");
		String InstlrInvCpy = PropertyFileReader.propertymap.get("InstlrInvCpy");
		String CRMName = PropertyFileReader.propertymap.get("CRMName");
		String CRMUrl = PropertyFileReader.propertymap.get("CRMUrl");
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInstaller)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(InstResetBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(InstName)).sendKeys(ModifiedInstName);
		ele4 = driver.findElement(By.xpath(InstStatusEnbl));
		ele4.click();
		ele2 = driver.findElement(By.name(InstCntryDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(CntryDD);
		Thread.sleep(3000);
		ele3 = driver.findElement(By.name(InstStateDD));
		Select sel1 = new Select(ele3);
		sel1.selectByVisibleText(StateDD);
		driver.findElement(By.name(InstAdres1)).sendKeys(Add1);
		driver.findElement(By.name(InstAdres2)).sendKeys(Add2);
		driver.findElement(By.name(InstCity)).sendKeys(InstlrCity);
		driver.findElement(By.name(InstZipCode)).sendKeys(ZipCode);
		driver.findElement(By.name(InstPhone)).sendKeys(InstlrPhone);
		driver.findElement(By.name(InstEmail)).sendKeys(InstlrMail);
		driver.findElement(By.name(InstWebsite)).sendKeys(InstlrWebSite);
		driver.findElement(By.name(InstInvoiceCpy)).sendKeys(InstlrInvCpy);
		driver.findElement(By.name(InstCrmName)).sendKeys(CRMName);
		driver.findElement(By.name(InstCrmUrl)).sendKeys(CRMUrl);
		driver.findElement(By.xpath(InstApiActNo)).click();
		driver.findElement(By.xpath(InstUpdateBtn)).click();
	}

	@Test(priority = 12, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditInstaller)).click();
		ele4 = driver.findElement(By.xpath(InstStatusDSbl));
		ele4.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InstUpdateBtn)));
		driver.findElement(By.xpath(InstUpdateBtn)).click();
	}

	// TC-12------------> there is no full view button
	// TC-13------------> there is no simple view button

	@Test(priority = 13, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstSearchBtn)).sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstDetails)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstClseBtn)));
		driver.findElement(By.xpath(InvstClseBtn)).click();
	}

	@Test(priority = 14, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		String TranDate = PropertyFileReader.propertymap.get("TranDate");
		String TranAmount = PropertyFileReader.propertymap.get("TranAmount");
		String TranBankName = PropertyFileReader.propertymap.get("TranBankName");
		String TranAccNum = PropertyFileReader.propertymap.get("TranAccNum");
		String Remarks = PropertyFileReader.propertymap.get("Remarks");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstDetails)).click();
		driver.findElement(By.name(InvstTraDate)).sendKeys(TranDate);
		driver.findElement(By.name(InvstAmount)).sendKeys(TranAmount);
		driver.findElement(By.name(InvstBankname)).sendKeys(TranBankName);
		driver.findElement(By.name(InvstAccnum)).sendKeys(TranAccNum);
		driver.findElement(By.name(InvstRemarks)).sendKeys(Remarks);
		driver.findElement(By.xpath(InvstDocAttach)).click();
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Image.jpg";
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
		driver.findElement(By.xpath(InvstClrBtn)).click();
	}

	@Test(priority = 15, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException, AWTException {
		InstallerBtnClick();
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		String TranDate = PropertyFileReader.propertymap.get("TranDate");
		String TranAmount = PropertyFileReader.propertymap.get("TranAmount");
		String TranBankName = PropertyFileReader.propertymap.get("TranBankName");
		String TranAccNum = PropertyFileReader.propertymap.get("TranAccNum");
		String Remarks = PropertyFileReader.propertymap.get("Remarks");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstDetails)).click();
		driver.findElement(By.name(InvstTraDate)).sendKeys(TranDate);
		driver.findElement(By.name(InvstAmount)).sendKeys(TranAmount);
		driver.findElement(By.name(InvstBankname)).sendKeys(TranBankName);
		driver.findElement(By.name(InvstAccnum)).sendKeys(TranAccNum);
		driver.findElement(By.name(InvstRemarks)).sendKeys(Remarks);
		driver.findElement(By.xpath(InvstDocAttach)).click();
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Image.jpg";
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
		driver.findElement(By.xpath(InvstSaveBtn)).click();
	}

	@Test(priority = 16, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC17() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(InvstDetails)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstDocAttach)).click();
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Image.jpg";
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
		// WebElement element2 =
		// driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[6]/div/div/div/h6"));
		// String text = element2.getText();
		// System.out.println(text);
	}

	@Test(priority = 17, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC18() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InstActionsBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstBackBtn)).click();
	}

	@Test(priority = 18, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		String StatusEnbl = PropertyFileReader.propertymap.get("StatusEnbl");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		ele2 = driver.findElement(By.name(InstStatusDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(StatusEnbl);
	}

	@Test(priority = 19, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC20() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String StatusDSbl = PropertyFileReader.propertymap.get("StatusDSbl");
		ele2 = driver.findElement(By.name(InstStatusDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(StatusDSbl);
	}

	@Test(priority = 20, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstCloseBtn)).click();
	}

	@Test(priority = 21, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstClrBtn)).click();
	}

	@Test(priority = 22, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC23() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		String TranDate = PropertyFileReader.propertymap.get("TranDate");
		String TranAmount = PropertyFileReader.propertymap.get("TranAmount");
		String TranBankName = PropertyFileReader.propertymap.get("TranBankName");
		String TranAccNum = PropertyFileReader.propertymap.get("TranAccNum");
		String Remarks = PropertyFileReader.propertymap.get("Remarks");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstClrBtn)).click();
		driver.findElement(By.name(InvstTraDate)).sendKeys(TranDate);
		driver.findElement(By.name(InvstAmount)).sendKeys(TranAmount);
		driver.findElement(By.name(InvstBankname)).sendKeys(TranBankName);
		driver.findElement(By.name(InvstAccnum)).sendKeys(TranAccNum);
		driver.findElement(By.name(InvstRemarks)).sendKeys(Remarks);
		driver.findElement(By.xpath(InvstSaveBtn)).click();
	}

	@Test(priority = 23, retryAnalyzer = ReRunFailedTestCase.class, enabled = true, description = "After file upload page goes to blank page")
	public void TC24() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstEditBtn)).click();
		Thread.sleep(2000);
		// Attached document remove
		ele3 = driver.findElement(
				By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div[6]/div/div/button"));
		ele3.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstDocAttach)).click();
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Image.jpg";
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
		WebElement element2 = driver
				.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div[6]/div"));
		String text = element2.getText();
		System.out.println(text);
	}

	@Test(priority = 24, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstEditBtn)).click();
		driver.findElement(By.xpath(InvstBankSetupBtn)).click();
		String checkBoxXpath = "//*[@id=\"kt_content_container\"]/div[2]/div/div[1]/table/thead/tr/th[5]/input";
		WebElement checkBox = driver.findElement(By.xpath(checkBoxXpath));
		checkBox.click();
	}

	@Test(priority = 25, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC26() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFSetupBtn)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(InvstNSFSetupUpdBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(InvstNSFSetupAlrtBtn));
		Thread.sleep(2000);
		if (ele2.isDisplayed()) {
			String text = ele2.getText();
			System.out.println("Sucessfull Message is shown");
			System.out.println("Sucessfull Message is shows like: " + text);
		} else {
			System.out.println("Sucessfull Message is not shown");
		}
		ele2.click();
	}

	@Test(priority = 26, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC27() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		driver.findElement(By.xpath(InvstNSFSetupBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFStpNoRadBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.id(InvstNSFStpAtmptBtn));
		Select sel = new Select(ele2);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		ele3 = driver.findElement(By.id(InvstNSFStpIntvBtn));
		Select sel1 = new Select(ele3);
		sel1.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFStpClrBtn)).click();
	}

	@Test(priority = 27, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC28() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		driver.findElement(By.xpath(InvstNSFSetupBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFStpNoRadBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.id(InvstNSFStpAtmptBtn));
		Select sel = new Select(ele2);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		ele3 = driver.findElement(By.id(InvstNSFStpIntvBtn));
		Select sel1 = new Select(ele3);
		sel1.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFStpUpdBtn)).click();
	}

	@Test(priority = 28, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC29() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		String Amount = PropertyFileReader.propertymap.get("Amount");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InstEditBtn)).click();
		driver.findElement(By.xpath(InvstNSFSetupBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFStpYesRadBtn)).click();
		driver.findElement(By.xpath(InvstNSFStpClrBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(InvstNSFStpAmtBtn)).sendKeys(Amount);
		driver.findElement(By.name(InvstNSFStpSepTranBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.id(InvstNSFStpAtmptBtn));
		Select sel = new Select(ele2);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		ele3 = driver.findElement(By.id(InvstNSFStpIntvBtn));
		Select sel1 = new Select(ele3);
		sel1.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFStpUpdBtn1)).click();
	}

	@Test(priority = 29, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC30() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		String Amount = PropertyFileReader.propertymap.get("Amount");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		driver.findElement(By.xpath(InvstNSFSetupBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFStpYesRadBtn)).click();
		driver.findElement(By.xpath(InvstNSFStpClrBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(InvstNSFStpAmtBtn)).sendKeys(Amount);
		Thread.sleep(2000);
		driver.findElement(By.name(InvstNSFStpMonPayBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.id(InvstNSFStpAtmptBtn));
		Select sel = new Select(ele2);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		ele3 = driver.findElement(By.id(InvstNSFStpIntvBtn));
		Select sel1 = new Select(ele3);
		sel1.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFStpUpdBtn1)).click();
	}

	@Test(priority = 30, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC31() throws InterruptedException, AWTException {
		InstallerBtnClick();
		Thread.sleep(2000);
		String InstSearchName = PropertyFileReader.propertymap.get("InstSearchName");
		ele1 = driver.findElement(By.xpath(InstSearchBtn));
		ele1.sendKeys(InstSearchName);
		driver.findElement(By.xpath(InstEditBtn)).click();
		driver.findElement(By.xpath(InvstNSFSetupBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstNSFStpActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstNSFStpActBckBtn)).click();
	}
}
