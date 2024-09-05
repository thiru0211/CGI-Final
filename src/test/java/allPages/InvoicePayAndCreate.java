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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class InvoicePayAndCreate extends Locators {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele1, ele2, ele3, ele4, ele5, ele6;
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

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void InvoicePayClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CustomerBtn)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CustomerBtn)));
		driver.findElement(By.xpath(CustomerBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvoicePayBtn)));
		driver.findElement(By.xpath(InvoicePayBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void CreateInvoiceClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CustomerBtn)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CustomerBtn)));
		driver.findElement(By.xpath(CustomerBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CretInvBtn)));
		driver.findElement(By.xpath(CretInvBtn)).click();
	}

	@Test(priority = 1, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException {
		InvoicePayClick();
		String IPBankDDName = PropertyFileReader.propertymap.get("IPBankDDName");
		String IPPaySts = PropertyFileReader.propertymap.get("IPPaySts");
		String IPSrchBox = PropertyFileReader.propertymap.get("IPSrchBox");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPBankDD)));
		ele1 = driver.findElement(By.xpath(IPBankDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(IPBankDDName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPPySts)));
		ele2 = driver.findElement(By.xpath(IPPySts));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText(IPPaySts);
		// driver.findElement(By.xpath(IPSrchBtn)).sendKeys(IPSrchBox);
	}

	@Test(priority = 2, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException {
		TC01();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPCusEditBtn)));
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		driver.findElement(By.xpath(IPChngInvDate)).click();
		driver.findElement(By.xpath(IPChngInvPayDatBtn)).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/button")));
		ele1 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/button"));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory alert message is displayed");
			ele2 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message is displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("Mandatory alert message is not displayed");
		}
	}

	@Test(priority = 3, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException {
		TC02();
		String IPPayDate = PropertyFileReader.propertymap.get("IPPayDate");
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String EffectiveDromDate= scanner.nextLine();

		// Generate current month and year format like MM/YYYY
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/yyyy");
		String formattedDate = currentDate.format(formatter);

		System.out.println(formattedDate);
		driver.findElement(By.xpath(IPEffMonFrm)).sendKeys(formattedDate);

		// Generate current date
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd");
		String formattedTomorrow = tomorrow.format(formatter1);
		System.out.println(formattedTomorrow);
		ele2 = driver.findElement(By.xpath(IPPyDate));
		Select sel = new Select(ele2);
		// sel.selectByVisibleText(formattedTomorrow);
		sel.selectByValue("");
		driver.findElement(By.xpath(IPChngInvPayDatBtn)).click();
	}

	@Test(priority = 4, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException {
		TC02();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChPyEditPyBtn)));
		driver.findElement(By.xpath(IPChPyEditPyBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(IPChPyRobChck)).click();
		driver.findElement(By.xpath(IPChPyAgrBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChPyUpdBtn)));
		driver.findElement(By.xpath(IPChPyUpdBtn)).click();
	}

	@Test(priority = 5, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException {
		TC02();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChPyEditPyBtn)));
		driver.findElement(By.xpath(IPChPyEditPyBtn)).click();
		driver.findElement(By.xpath(IPChPyBckBtn)).click();
	}

	@Test(priority = 6, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException {
		TC02();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChPySkpPy)));
		driver.findElement(By.xpath(IPChPySkpPy)).click();
	}

	@Test(priority = 7, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException {
		TC07();
		String IpSkpPayRsn = PropertyFileReader.propertymap.get("IpSkpPayRsn");
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String StartMonth= scanner.nextLine();

		driver.findElement(By.name(IPSkpPyRsn)).sendKeys(IpSkpPayRsn);

		// Generate current month and year format like MM/YYYY
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println(formattedDate);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.name(IPSkpPyStrtMnt)));
		driver.findElement(By.name(IPSkpPyStrtMnt)).sendKeys(formattedDate);

		// Scanner scanner1 = new Scanner(System.in);
		// System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String EndMonth= scanner1.nextLine();

		LocalDate nextMonth = currentDate.plusMonths(1);

		// Format the date as "MMM/yyyy" (e.g., "Aug/2024")
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMM/yyyy");
		String formattedNextMonthYear = nextMonth.format(formatter1);

		wait.until(ExpectedConditions.elementToBeClickable(By.name(IPSkpPyEndMnt)));
		driver.findElement(By.name(IPSkpPyEndMnt)).sendKeys(formattedNextMonthYear);
		Thread.sleep(2000);
		driver.findElement(By.name(IPSkpPyEndMnt)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(IPSkpPyCnfrm)).click();
		driver.findElement(By.xpath(IPSkpPyBtn)).click();
	}

	@Test(priority = 8, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException {
		TC01();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPCusEditBtn)));
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		driver.findElement(By.xpath(IPChngInvDate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChPyBackBtn)));
		driver.findElement(By.xpath(IPChPyBackBtn)).click();
	}

	@Test(priority = 9, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException {
		TC01();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPCusEditBtn)));
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyBtn)));
		driver.findElement(By.xpath(IPChMntPyBtn)).click();
		driver.findElement(By.xpath(IPChMntPySavBtn)).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div/button")));
		ele1 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div/button"));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			ele2 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message is displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("Mandatory message is not shown");
		}
	}

	@Test(priority = 10, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException {
		TC10();
		String IPChMntPayAmt = PropertyFileReader.propertymap.get("IPChMntPayAmt");
		String IPChMntPayRsn = PropertyFileReader.propertymap.get("IPChMntPayRsn");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.name(IPChMntPyAmt)));
		driver.findElement(By.name(IPChMntPyAmt)).sendKeys(IPChMntPayAmt);
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String EffDate= scanner.nextLine();

		// Generate current month and year format like MM/YYYY
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println(formattedDate);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEffDate)));
		driver.findElement(By.xpath(IPChMntPyEffDate)).sendKeys(formattedDate);
		driver.findElement(By.name(IPChMntPyRsn)).sendKeys(IPChMntPayRsn);
		driver.findElement(By.xpath(IPChMntPySavBtn)).click();
	}

	@Test(priority = 11, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC12() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditCus)));
		driver.findElement(By.xpath(IPChMntPyEditCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditActBtn)));
		WebElement element1 = driver.findElement(By.xpath(IPChMntPyEditActBtn));
		Actions act1 = new Actions(driver);
		act1.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditClrBtn)));
		driver.findElement(By.xpath(IPChMntPyEditClrBtn)).click();
	}

	@Test(priority = 12, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusEditActPayBtn)));
		WebElement element = driver.findElement(By.xpath(CusEditActPayBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditCus)));
		driver.findElement(By.xpath(IPChMntPyEditCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("ptodate")));
		// Enter PTO Date
		driver.findElement(By.name("ptodate")).sendKeys("15-03-2024");
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(IPChMntPyEditActBtn));
		Actions act1 = new Actions(driver);
		act1.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditSavBtn)));
		driver.findElement(By.xpath(IPChMntPyEditSavBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Updated Successfully!!!']")));
		ele2 = driver.findElement(By.xpath("//div[text()='Updated Successfully!!!']"));
		if (ele2.isDisplayed()) {
			String text = ele2.getText();
			System.out.println("Popup is shown like: " + text);
		} else {
			System.out.println();
		}
	}

	@Test(priority = 13, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditCus)));
		driver.findElement(By.xpath(IPChMntPyEditCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditActBtn)));
		WebElement element1 = driver.findElement(By.xpath(IPChMntPyEditActBtn));
		Actions act1 = new Actions(driver);
		act1.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditBckBtn)));
		driver.findElement(By.xpath(IPChMntPyEditBckBtn)).click();
	}

	@Test(priority = 14, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException {
		TC10();
		String IPChMntPortName = PropertyFileReader.propertymap.get("IPChMntPortName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditCus)));
		driver.findElement(By.xpath(IPChMntPyEditCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyAddCusPort)));
		driver.findElement(By.xpath(IPChMntPyAddCusPort)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(IPChMntPyAddCusPortName)));
		driver.findElement(By.name(IPChMntPyAddCusPortName)).sendKeys(IPChMntPortName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyAddCusPortClr)));
		driver.findElement(By.xpath(IPChMntPyAddCusPortClr)).click();
	}

	@Test(priority = 15, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException {
		TC10();
		String IPChMntPortName = PropertyFileReader.propertymap.get("IPChMntPortName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditCus)));
		driver.findElement(By.xpath(IPChMntPyEditCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyAddCusPort)));
		driver.findElement(By.xpath(IPChMntPyAddCusPort)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(IPChMntPyAddCusPortName)));
		driver.findElement(By.name(IPChMntPyAddCusPortName)).sendKeys(IPChMntPortName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyAddCusPortSav)));
		driver.findElement(By.xpath(IPChMntPyAddCusPortSav)).click();
	}

	@Test(priority = 16, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC17() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditCus)));
		driver.findElement(By.xpath(IPChMntPyEditCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyAddCusPort)));
		driver.findElement(By.xpath(IPChMntPyAddCusPort)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyAddCusPortCls)));
		driver.findElement(By.xpath(IPChMntPyAddCusPortCls)).click();
	}

	@Test(priority = 17, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC18() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditCus)));
		driver.findElement(By.xpath(IPChMntPyEditCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEdtCusPort)));
		driver.findElement(By.xpath(IPChMntPyEdtCusPort)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEdtCusPortClr)));
		driver.findElement(By.xpath(IPChMntPyEdtCusPortClr)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEdtCusPortClr)));
		ele1 = driver.findElement(By.xpath(IPChMntPyEdtCusPortClr));
		String text = ele1.getAttribute("value");
		System.out.println(text);
		if (text.isEmpty()) {
			System.out.println("Clear button is not working");
		} else {
			System.out.println("Clear button is working properly");
		}
	}

	@Test(priority = 18, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditCus)));
		driver.findElement(By.xpath(IPChMntPyEditCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEdtCusPort)));
		driver.findElement(By.xpath(IPChMntPyEdtCusPort)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEdtCusPortSav)));
		driver.findElement(By.xpath(IPChMntPyEdtCusPortSav)).click();
	}

	@Test(priority = 19, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC20() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEditCus)));
		driver.findElement(By.xpath(IPChMntPyEditCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEdtCusPort)));
		driver.findElement(By.xpath(IPChMntPyEdtCusPort)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEdtCusPortCls)));
		driver.findElement(By.xpath(IPChMntPyEdtCusPortCls)).click();
	}

	@Test(priority = 20, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyViwCusBtn)));
		driver.findElement(By.xpath(IPChMntPyViwCusBtn)).click();
	}

	@Test(priority = 21, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyEdPySch)));
		driver.findElement(By.xpath(IPChMntPyEdPySch)).click();
		driver.findElement(By.xpath(IPChMntPyEdPySchUpd)).click();
	}

	@Test(priority = 22, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC23() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyMrgCus)));
		driver.findElement(By.xpath(IPChMntPyMrgCus)).click();
		driver.findElement(By.xpath(IPChMntPyMrgCusMan)).click();
		driver.findElement(By.xpath(IPChMntPyMrgeBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div/span")));
		ele1 = driver.findElement(
				By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div/span"));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
		} else {
			System.out.println("No mandatory message is displayed");
		}
	}

	@Test(priority = 23, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC24() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyMrgCus)));
		driver.findElement(By.xpath(IPChMntPyMrgCus)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyMrgeCusDD)));
		ele1 = driver.findElement(By.xpath(IPChMntPyMrgeCusDD));
		ele1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/input")));
		ele2 = driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/input"));
		ele2.sendKeys("TEST (TEEST)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div/div")));
		ele3 = driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div/div"));
		ele3.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyMrgCusMan)));
		driver.findElement(By.xpath(IPChMntPyMrgCusMan)).click();
		driver.findElement(By.xpath(IPChMntPyMrgeBtn)).click();
	}

	@Test(priority = 24, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyRcdPymts)));
		driver.findElement(By.xpath(IPChMntPyRcdPymts)).click();
		driver.findElement(By.xpath(IPChMntPyRcdPyPrnt)).click();
	}

	@Test(priority = 25, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC26() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyMonCRM)));
		driver.findElement(By.xpath(IPChMntPyMonCRM)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("crm")));
		ele1 = driver.findElement(By.id("crm"));
		Select sel = new Select(ele1);
		sel.selectByIndex(1);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("crmname")));
		ele4 = driver.findElement(By.id("crmname"));
		Select sel1 = new Select(ele4);
		sel1.selectByIndex(1);

		wait.until(ExpectedConditions.elementToBeClickable(By.name("productionescalation")));
		ele2 = driver.findElement(By.name("productionescalation"));
		String attribute = ele2.getAttribute("value");
		int length = attribute.length();
		for (int i = 0; i < length; i++) {
			ele2.sendKeys(Keys.BACK_SPACE);
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.name("firstyearproduction")));
		ele3 = driver.findElement(By.name("firstyearproduction"));
		String attribute1 = ele3.getAttribute("value");
		int length1 = attribute1.length();
		for (int i = 0; i < length1; i++) {
			ele3.sendKeys(Keys.BACK_SPACE);
		}
		driver.findElement(By.xpath(IPChMntPyMonCRMUpd)).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div[2]/button")));
		ele5 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div[2]/button"));

		if (ele5.isDisplayed()) {
			System.out.println("Mandatory alert message is displayed");
			ele6 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele6.getText();
			System.out.println("Alert message is displayed like: " + text);
			ele5.click();
		}

		else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(priority = 27, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC28() throws InterruptedException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyDocStup)));
		driver.findElement(By.xpath(IPChMntPyDocStup)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyDocStupAgree)));
		driver.findElement(By.xpath(IPChMntPyDocStupAgree)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyDocStupSav)));
		driver.findElement(By.xpath(IPChMntPyDocStupSav)).click();
		ele1 = driver
				.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[2]/div/div"));
		Thread.sleep(2000);
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			String text = ele1.getText();
			System.out.println("Alert message is displayed like: " + text);

		} else {
			System.out.println("Mandatory message is not shown");

		}
	}

	@Test(priority = 28, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC29() throws InterruptedException, AWTException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyDocStup)));
		driver.findElement(By.xpath(IPChMntPyDocStup)).click();
		driver.findElement(By.xpath(IPChMntPyDocStupUpld)).click();
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Blank.xlsx";
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
		driver.findElement(By.xpath(IPChMntPyDocStupAgree)).click();
		driver.findElement(By.xpath(IPChMntPyDocStupSav)).click();
	}

	@Test(priority = 29, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC30() throws InterruptedException, AWTException {
		TC10();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyActBtn)));
		WebElement element = driver.findElement(By.xpath(IPChMntPyActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPChMntPyBckBtn)));
		driver.findElement(By.xpath(IPChMntPyBckBtn)).click();
	}

	@Test(priority = 30, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC31() throws InterruptedException, AWTException {
		TC01();
		Thread.sleep(2000);
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusAct)));
		WebElement element = driver.findElement(By.xpath(IPEditCusAct));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusEditPy)));
		driver.findElement(By.xpath(IPEditCusEditPy)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusRob)));
		driver.findElement(By.xpath(IPEditCusRob)).click();
		driver.findElement(By.xpath(IPEditCusAgree)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusUpd)));
		driver.findElement(By.xpath(IPEditCusUpd)).click();
	}

	@Test(priority = 31, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC32() throws InterruptedException, AWTException {
		TC01();
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusAct)));
		WebElement element = driver.findElement(By.xpath(IPEditCusAct));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusChngInvDt)));
		driver.findElement(By.xpath(IPEditCusChngInvDt)).click();
		driver.findElement(By.xpath(IPEditCusChngPyDt)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusChngMan)));
		ele1 = driver.findElement(By.xpath(IPEditCusChngMan));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory Message is shown");
			ele2 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message is displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("No Mandatory Message is shown");
		}
	}

	@Test(priority = 32, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC33() throws InterruptedException, AWTException {
		TC32();
		String IPInvPyDte = PropertyFileReader.propertymap.get("IPInvPyDte");
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String EffectiveFromDate= scanner.nextLine();
		driver.findElement(By.name(IPEditCusChngInvEff)).sendKeys("Feb/2023");
		ele1 = driver.findElement(By.xpath(IPEditCusChngInvPyDte));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(IPInvPyDte);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusChngPyDt)));
		driver.findElement(By.xpath(IPEditCusChngPyDt)).click();
	}

	@Test(priority = 33, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC34() throws InterruptedException, AWTException {
		TC01();
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusAct)));
		WebElement element = driver.findElement(By.xpath(IPEditCusAct));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusStpPy)));
		driver.findElement(By.xpath(IPEditCusStpPy)).click();
		driver.findElement(By.name(IPEditCusStpPyCnfrm)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusStpPyCnfrmBtn)));
		driver.findElement(By.xpath(IPEditCusStpPyCnfrmBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusStpPyCnfrmBtn)));
		ele1 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/button"));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			ele2 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message is displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("No Mandatory Message is shown");
		}
	}

	@Test(priority = 34, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC35() throws InterruptedException, AWTException {
		TC34();
		String IPStpRsn = PropertyFileReader.propertymap.get("IPStpRsn");
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String StopFrom= scanner.nextLine();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.name(IPEditCusStpFrm)));
		driver.findElement(By.name(IPEditCusStpFrm)).sendKeys("Dec/2024");
		driver.findElement(By.name(IPEditCusStpRsn)).sendKeys(IPStpRsn);
		driver.findElement(By.name(IPEditCusStpPyCnfrm)).click();
		driver.findElement(By.name(IPEditCusStpPyCnfrm)).click();
		driver.findElement(By.xpath(IPEditCusStpPyCnfrmBtn)).click();
	}

	@Test(priority = 35, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC36() throws InterruptedException, AWTException {
		TC01();
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusAct)));
		WebElement element = driver.findElement(By.xpath(IPEditCusAct));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPQckUpld)));
		driver.findElement(By.xpath(IPQckUpld)).click();
		driver.findElement(By.xpath(IPQckUpldBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPQckUpldTost)));
		ele1 = driver.findElement(By.xpath(IPQckUpldTost));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory toast appears");
			String text = ele1.getText();
			System.out.println("Alert message displayed like: " + text);
		} else {
			System.out.println("No Mandatory Message is shown");
		}
	}

	@Test(priority = 36, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC37() throws InterruptedException, AWTException {
		TC01();
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusAct)));
		WebElement element = driver.findElement(By.xpath(IPEditCusAct));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPQckUpld)));
		driver.findElement(By.xpath(IPQckUpld)).click();
		driver.findElement(By.xpath(IPQckUpldSamFile)).click();
	}

	@Test(priority = 37, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC38() throws InterruptedException, AWTException {
		TC01();
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusAct)));
		WebElement element = driver.findElement(By.xpath(IPEditCusAct));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPQckUpld)));
		driver.findElement(By.xpath(IPQckUpld)).click();
		driver.findElement(By.xpath(IPQckUpldFile)).click();
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\Blank.xlsx";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@Test(priority = 38, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC39() throws InterruptedException, AWTException {
		TC01();
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusAct)));
		WebElement element = driver.findElement(By.xpath(IPEditCusAct));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPQckUpld)));
		driver.findElement(By.xpath(IPQckUpld)).click();
		driver.findElement(By.xpath(IPQckUpldMonth)).click();
	}

	@Test(priority = 39, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC40() throws InterruptedException, AWTException {
		TC38();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPQckUpldBtn)));
		driver.findElement(By.xpath(IPQckUpldBtn)).click();
	}

	@Test(priority = 40, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC41() throws InterruptedException, AWTException {
		TC01();
		driver.findElement(By.xpath(IPCusEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusAct)));
		WebElement element = driver.findElement(By.xpath(IPEditCusAct));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IPEditCusBckBtn)));
		driver.findElement(By.xpath(IPEditCusBckBtn)).click();
	}

	@Test(priority = 41, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC42() throws InterruptedException {
		CreateInvoiceClick();
		String CIBankDD = PropertyFileReader.propertymap.get("CIBankDD");
		String CIPayOpt = PropertyFileReader.propertymap.get("CIPayOpt");
		ele1 = driver.findElement(By.xpath(CIBnkDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(CIBankDD);
		ele2 = driver.findElement(By.xpath(CIPyOpt));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText(CIPayOpt);
		ele3 = driver.findElement(By.xpath(CISrchCus));
		ele3.click();
	}

	@Test(priority = 42, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC43() throws InterruptedException {
		TC42();
		Thread.sleep(2000);
		String CISrchCust = PropertyFileReader.propertymap.get("CISrchCust");
		ele3.sendKeys(CISrchCust);
	}

	@Test(priority = 43, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC44() throws InterruptedException {
		TC42();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CIViewCusBtn)));
		driver.findElement(By.xpath(CIViewCusBtn)).click();
	}

	@Test(priority = 44, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC44a() throws InterruptedException {
		TC44();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CIViewCusSavBtn)));
		ele1 = driver.findElement(By.xpath(CIViewCusSavBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CIViewCusSavBtn)));
		ele1 = driver.findElement(By.xpath(CIViewCusSavBtn));
		ele1.click();
	}

	@Test(priority = 45, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC45() throws InterruptedException {
		TC44();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CIViewCusMPBtn)));
		driver.findElement(By.xpath(CIViewCusMPBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CIViewCusMPSavBtn)));
		driver.findElement(By.xpath(CIViewCusMPSavBtn)).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/div/div[3]/button")));
		ele1 = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/div/div[3]/button"));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			ele2 = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("Mandatory message is not shsown");
		}
	}

	@Test(priority = 46, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC46() throws InterruptedException {
		TC45();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CIViewCusMPBtn)));
		driver.findElement(By.xpath(CIViewCusMPBtn)).click();
		String CIViewCustMPDes = PropertyFileReader.propertymap.get("CIViewCustMPDes");
		String CIViewCustMPAmt = PropertyFileReader.propertymap.get("CIViewCustMPAmt");
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String DueMonth= scanner.nextLine();
		driver.findElement(By.name(CIViewCusMPDueMnt)).sendKeys("Dec/2024");
		driver.findElement(By.xpath(CIViewCusMPDes)).sendKeys(CIViewCustMPDes);
		driver.findElement(By.name(CIViewCusMPAmt)).sendKeys(CIViewCustMPAmt);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CIViewCusMPClrBtn)).click();
	}

	@Test(priority = 47, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC47() throws InterruptedException {
		TC45();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CIViewCusMPBtn)));
		driver.findElement(By.xpath(CIViewCusMPBtn)).click();
		String CIViewCustMPDes = PropertyFileReader.propertymap.get("CIViewCustMPDes");
		String CIViewCustMPAmt = PropertyFileReader.propertymap.get("CIViewCustMPAmt");
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String DueMonth= scanner.nextLine();
		driver.findElement(By.name(CIViewCusMPDueMnt)).sendKeys("Dec/2024");
		driver.findElement(By.xpath(CIViewCusMPDes)).sendKeys(CIViewCustMPDes);
		driver.findElement(By.name(CIViewCusMPAmt)).sendKeys(CIViewCustMPAmt);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CIViewCusMPSavBtn)).click();
	}

	@Test(priority = 48, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC48() throws InterruptedException {
		TC45();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CIViewCusMPBtn)));
		driver.findElement(By.xpath(CIViewCusMPBtn)).click();
		String CIViewCustMPDes = PropertyFileReader.propertymap.get("CIViewCustMPDes");
		String CIViewCustMPAmt = PropertyFileReader.propertymap.get("CIViewCustMPAmt");
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String DueMonth= scanner.nextLine();
		driver.findElement(By.name(CIViewCusMPDueMnt)).sendKeys("Dec/2024");
		driver.findElement(By.xpath(CIViewCusMPDes)).sendKeys(CIViewCustMPDes);
		driver.findElement(By.name(CIViewCusMPAmt)).sendKeys(CIViewCustMPAmt);
		driver.findElement(By.name(CIViewCusMPChrgRadBtn)).click();
		driver.findElement(By.xpath(CIViewCusMPSavBtn)).click();
	}

	@Test(priority = 49, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC49() throws InterruptedException {
		TC44();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CIViewCusMPClsBtn)));
		driver.findElement(By.xpath(CIViewCusMPClsBtn)).click();
	}

}
