package allPages;

import static org.testng.Assert.fail;

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
import org.openqa.selenium.Dimension;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvestorSetup extends Locators {

	public static WebDriverWait wait;
	public static WebElement ele1, ele2, ele3, ele4, ele5;

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
	public void InvestorBtnClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SetupBtn)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SetupBtn)));
		driver.findElement(By.xpath(SetupBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvestorBtn)));
		ele1 = driver.findElement(By.xpath(InvestorBtn));
		ele1.click();
	}

	@Test(priority = 2, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		String InvstrDD = PropertyFileReader.propertymap.get("InvstrDD");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrStatusDD)));
		ele1 = driver.findElement(By.name(InvstrStatusDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(InvstrDD);
	}

	@Test(priority = 3, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException, AWTException {
		InvestorBtnClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddBtn)));
		driver.findElement(By.xpath(InvstrAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSaveBtn)));
		ele3 = driver.findElement(By.xpath(InvstrSaveBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSaveBtn)));
		driver.findElement(By.xpath(InvstrSaveBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrWarningMsg)));
		ele1 = driver.findElement(By.xpath(InvstrWarningMsg));
		if (ele1.isDisplayed()) {
			System.out.println("Alert message is shown");
			ele2 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message is displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(priority = 4, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		String InvestCntry = PropertyFileReader.propertymap.get("InvestCntry");
		String InvestState = PropertyFileReader.propertymap.get("InvestState");
		String InvestAdd1 = PropertyFileReader.propertymap.get("InvestAdd1");
		String InvestAdd2 = PropertyFileReader.propertymap.get("InvestAdd2");
		String InvestCity = PropertyFileReader.propertymap.get("InvestCity");
		String InvestZipcode = PropertyFileReader.propertymap.get("InvestZipcode");
		String InvestPhone = PropertyFileReader.propertymap.get("InvestPhone");
		String InvestEmail = PropertyFileReader.propertymap.get("InvestEmail");
		String InvestWeb = PropertyFileReader.propertymap.get("InvestWeb");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddBtn)));
		driver.findElement(By.xpath(InvstrAddBtn)).click();
		driver.findElement(By.name(InvstrName)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEnblBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrCntry)));
		ele1 = driver.findElement(By.name(InvstrCntry));
		Select country = new Select(ele1);
		country.selectByVisibleText(InvestCntry);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrState)));
		ele2 = driver.findElement(By.name(InvstrState));
		Select state = new Select(ele2);
		state.selectByVisibleText(InvestState);
		Thread.sleep(1000);
		driver.findElement(By.name(InvstrAdd1)).sendKeys(InvestAdd1);
		Thread.sleep(1000);
		driver.findElement(By.name(InvstrAdd2)).sendKeys(InvestAdd2);
		driver.findElement(By.name(InvstrCity)).sendKeys(InvestCity);
		driver.findElement(By.name(InvstrZipCode)).sendKeys(InvestZipcode);
		driver.findElement(By.name(InvstrPhone)).sendKeys(InvestPhone);
		driver.findElement(By.name(InvstrEmail)).sendKeys(InvestEmail);
		driver.findElement(By.name(InvstrWebsite)).sendKeys(InvestWeb);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(InvstrClrBtn)));
		driver.findElement(By.id(InvstrClrBtn)).click();
	}

	@Test(priority = 5, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException, AWTException {
		InvestorBtnClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddBtn)));
		driver.findElement(By.xpath(InvstrAddBtn)).click();
		driver.findElement(By.xpath(InvstrBackBtn)).click();
		driver.findElement(By.xpath(InvstrAddBtn)).click();
	}

	@Test(priority = 6, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		String InvestCntry = PropertyFileReader.propertymap.get("InvestCntry");
		String InvestState = PropertyFileReader.propertymap.get("InvestState");
		String InvestAdd1 = PropertyFileReader.propertymap.get("InvestAdd1");
		String InvestAdd2 = PropertyFileReader.propertymap.get("InvestAdd2");
		String InvestCity = PropertyFileReader.propertymap.get("InvestCity");
		String InvestZipcode = PropertyFileReader.propertymap.get("InvestZipcode");
		String InvestPhone = PropertyFileReader.propertymap.get("InvestPhone");
		String InvestEmail = PropertyFileReader.propertymap.get("InvestEmail");
		String InvestWeb = PropertyFileReader.propertymap.get("InvestWeb");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddBtn)));
		driver.findElement(By.xpath(InvstrAddBtn)).click();
		driver.findElement(By.name(InvstrName)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEnblBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrCntry)));
		ele1 = driver.findElement(By.name(InvstrCntry));
		Select country = new Select(ele1);
		country.selectByVisibleText(InvestCntry);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrState)));
		ele2 = driver.findElement(By.name(InvstrState));
		Select state = new Select(ele2);
		state.selectByVisibleText(InvestState);
		Thread.sleep(2000);
		driver.findElement(By.name(InvstrAdd1)).sendKeys(InvestAdd1);
		Thread.sleep(2000);
		driver.findElement(By.name(InvstrAdd2)).sendKeys(InvestAdd2);
		driver.findElement(By.name(InvstrCity)).sendKeys(InvestCity);
		driver.findElement(By.name(InvstrZipCode)).sendKeys(InvestZipcode);
		driver.findElement(By.name(InvstrPhone)).sendKeys(InvestPhone);
		driver.findElement(By.name(InvstrEmail)).sendKeys(InvestEmail);
		driver.findElement(By.name(InvstrWebsite)).sendKeys(InvestWeb);
		driver.findElement(By.xpath(InvstrSaveBtn)).click();
	}

	@Test(priority = 7, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		String InvestCity = PropertyFileReader.propertymap.get("InvestCity");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EditInvstrBtn)));
		driver.findElement(By.xpath(EditInvstrBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrCity)));
		ele1 = driver.findElement(By.name(InvstrCity));

		while (!ele1.getAttribute("value").isEmpty()) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrCity)));
		ele1.sendKeys(InvestCity);
		driver.findElement(By.xpath(InvstrSaveBtn)).click();
	}

	@Test(priority = 8, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EditInvstrBtn)));
		driver.findElement(By.xpath(EditInvstrBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(InvstrClrBtn)));
		driver.findElement(By.id(InvstrClrBtn)).click();
	}

	@Test(priority = 9, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EditInvstrBtn)));
		driver.findElement(By.xpath(EditInvstrBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrBackBtn)));
		driver.findElement(By.xpath(InvstrBackBtn)).click();
	}

	@Test(priority = 10, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		String InvestTranDate = PropertyFileReader.propertymap.get("InvestTranDate");
		String InvestAmt = PropertyFileReader.propertymap.get("InvestAmt");
		String InvestBankName = PropertyFileReader.propertymap.get("InvestBankName");
		String InvestAccNum = PropertyFileReader.propertymap.get("InvestAccNum");
		String InvestRmrk = PropertyFileReader.propertymap.get("InvestRmrk");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddTans)));
		driver.findElement(By.xpath(InvstrAddTans)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrTranDate)));
		driver.findElement(By.name(InvstrTranDate)).sendKeys(InvestTranDate);
		driver.findElement(By.name(InvstrTranAmt)).sendKeys(InvestAmt);
		driver.findElement(By.name(InvstrTranBank)).sendKeys(InvestBankName);
		driver.findElement(By.name(InvstrTranAccNum)).sendKeys(InvestAccNum);
		driver.findElement(By.name(InvstrTranRemarks)).sendKeys(InvestRmrk);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrAttachBtn)).click();
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
		driver.findElement(By.xpath(InvstrTranSavBtn)).click();
	}

	@Test(priority = 11, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException, AWTException {
		InvestorBtnClick();
		Thread.sleep(2000);
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		String InvestTranDate = PropertyFileReader.propertymap.get("InvestTranDate");
		String InvestAmt = PropertyFileReader.propertymap.get("InvestAmt");
		String InvestBankName = PropertyFileReader.propertymap.get("InvestBankName");
		String InvestAccNum = PropertyFileReader.propertymap.get("InvestAccNum");
		String InvestRmrk = PropertyFileReader.propertymap.get("InvestRmrk");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddTans)));
		driver.findElement(By.xpath(InvstrAddTans)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrTranDate)));
		driver.findElement(By.name(InvstrTranDate)).sendKeys(InvestTranDate);
		driver.findElement(By.name(InvstrTranAmt)).sendKeys(InvestAmt);
		driver.findElement(By.name(InvstrTranBank)).sendKeys(InvestBankName);
		driver.findElement(By.name(InvstrTranAccNum)).sendKeys(InvestAccNum);
		driver.findElement(By.name(InvstrTranRemarks)).sendKeys(InvestRmrk);
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrAttachBtn)).click();
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
		driver.findElement(By.xpath(InvstrTranClrBtn)).click();
	}

	@Test(priority = 12, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(EditInvstrBtn)).click();
		driver.findElement(By.xpath(InvstrBackBtn)).click();
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		act.click().build().perform();
		element1.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddTans)));
		driver.findElement(By.xpath(InvstrAddTans)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrTranBckBtn)));
		driver.findElement(By.xpath(InvstrTranBckBtn)).click();
	}

	@Test(priority = 13, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC12() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		String expectedUrl = driver.getCurrentUrl();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/ul/li[2]/div/div/span")));
		// Click Add Customers
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[2]/div/div/span")).click();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		if (!(currentUrl == expectedUrl)) {
			System.out.println("Page shows Customer Dropdown");
		} else {
			System.out.println("Page doesnot shows Customer Dropdown");
		}
	}

	@Test(priority = 14, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrTranExcelBtn)));
		driver.findElement(By.xpath(InvstrTranExcelBtn)).click();
	}

	@Test(priority = 15, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException, AWTException {
		InvestorBtnClick();
		Thread.sleep(2000);
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBckBtn)));
		driver.findElement(By.xpath(InvstrActBckBtn)).click();
	}

	@Test(priority = 16, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		String InvestInslrDD = PropertyFileReader.propertymap.get("InvestInslrDD");
		String InvestCusNam1 = PropertyFileReader.propertymap.get("InvestCusNam1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddCusBtn)));
		driver.findElement(By.xpath(InvstrAddCusBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSelInstlrDD)));
		ele1 = driver.findElement(By.xpath(InvstrSelInstlrDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(InvestInslrDD);
		// driver.findElement(By.xpath(InvstrCusName)).sendKeys(InvestCusNam1);
		driver.findElement(By.xpath(InvstrCusChckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element2 = driver.findElement(By.xpath(InvstrActBtn));
		act.click().build().perform();
		element2.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrCusSavBtn)));
		driver.findElement(By.xpath(InvstrCusSavBtn)).click();
	}

	@Test(priority = 17, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName = PropertyFileReader.propertymap.get("InvestName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(InvstrAddCusBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element2 = driver.findElement(By.xpath(InvstrActBtn));
		act.click().build().perform();
		element2.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBckBtn)));
		driver.findElement(By.xpath(InvstrActBckBtn)).click();
	}

	@Test(priority = 18, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC17() throws InterruptedException, AWTException {
		InvestorBtnClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/div/div/button")));
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/div/div/button")).click();
	}

	@Test(priority = 19, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestEmailId = PropertyFileReader.propertymap.get("InvestEmailId");
		String InvestPasswrd = PropertyFileReader.propertymap.get("InvestPasswrd");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SettingSymbol)));
		driver.findElement(By.xpath(SettingSymbol)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SignOutBtn)));
		driver.findElement(By.xpath(SignOutBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(Email)));
		driver.findElement(By.name(Email)).sendKeys(InvestEmailId);
		driver.findElement(By.name(Password)).sendKeys(InvestPasswrd);
		driver.findElement(By.id(LoginBtn)).click();
	}

	@Test(priority = 20, retryAnalyzer = ReRunFailedTestCase.class, description = "Attachment is not adding")
	public void TC20() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		String InvestTranDate = PropertyFileReader.propertymap.get("InvestTranDate");
		String InvestAmt = PropertyFileReader.propertymap.get("InvestAmt");
		String InvestBankName = PropertyFileReader.propertymap.get("InvestBankName");
		String InvestAccNum = PropertyFileReader.propertymap.get("InvestAccNum");
		String InvestRmrk = PropertyFileReader.propertymap.get("InvestRmrk");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrTransBtn)));
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrTranEditbtn)));
		driver.findElement(By.xpath(InvstrTranEditbtn)).click();
		driver.findElement(By.name(InvstrTranDate)).sendKeys(InvestTranDate);
		driver.findElement(By.name(InvstrTranAmt)).sendKeys(InvestAmt);
		driver.findElement(By.name(InvstrTranBank)).sendKeys(InvestBankName);
		driver.findElement(By.name(InvstrTranAccNum)).sendKeys(InvestAccNum);
		driver.findElement(By.name(InvstrTranRemarks)).sendKeys(InvestRmrk);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrTranUpdBtn)));
		driver.findElement(By.xpath(InvstrTranUpdBtn)).click();
	}

	@Test(priority = 21, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrTransBtn)));
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrTranEditbtn)));
		driver.findElement(By.xpath(InvstrTranEditbtn)).click();
		driver.findElement(By.xpath(InvstrTranEditBckBtn)).click();
	}

	@Test(priority = 22, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		driver.findElement(By.xpath(InvstrTransBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrDwldBtn)));
		ele1 = driver.findElement(By.xpath(InvstrDwldBtn));
		if (ele1.isDisplayed()) {
			System.out.println("\033[1m Transcation is found \033[0m");
			ele1.click();
		} else {
			System.out.println("\033[1m No transcation is found due to Attachment is not working \033[0m");
		}
	}

	@Test(enabled = true, retryAnalyzer = ReRunFailedTestCase.class, description = "update button is not working", priority = 23)
	public void TC23() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		String InvestCusName = PropertyFileReader.propertymap.get("InvestCusName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrCusEditBtn)));
		driver.findElement(By.xpath(InvstrCusEditBtn)).click();
		driver.findElement(By.xpath(InvstrCusSrch)).sendKeys(InvestCusName);
		driver.findElement(By.xpath(InvstrCusSelBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrCusUpdBtn)));
		ele1 = driver.findElement(By.xpath(InvstrCusUpdBtn));
		ele1.click();
//		try {
//		    // Click the button
//		    ele1.click();
//		  } catch (Exception e) {
//		    // Handle the exception and fail the test
//		    fail("Button click failed with exception: " + e.getMessage());
//		  }
	}

	@Test(priority = 24, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC24() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		String InvestInslrDD = PropertyFileReader.propertymap.get("InvestInslrDD");
		String InvestCusID1 = PropertyFileReader.propertymap.get("InvestCusID1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddCusBtn)));
		driver.findElement(By.xpath(InvstrAddCusBtn)).click();
		driver.findElement(By.xpath(InvstrSelInstlrDD)).sendKeys(InvestInslrDD);
		// driver.findElement(By.xpath(InvstrCusName)).sendKeys(InvestCusID1);
		driver.findElement(By.xpath(InvstrCusChckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element2 = driver.findElement(By.xpath(InvstrActBtn));
		act.click().build().perform();
		element2.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrCusSavBtn)));
		driver.findElement(By.xpath(InvstrCusSavBtn)).click();
	}

	@Test(priority = 25, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrDocuBtn)));
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddDocBtn)));
		driver.findElement(By.xpath(InvstrAddDocBtn)).click();
		driver.findElement(By.xpath(InvstrFileSaveBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrFileToast)));
		ele1 = driver.findElement(By.xpath(InvstrFileToast));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory alert message is displayed");
			ele2 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("No mandatory message is displayed");
		}
	}

	@Test(priority = 26, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC26() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrDocuBtn)));
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		driver.findElement(By.xpath(InvstrViewBtn)).click();
		driver.findElement(By.xpath(InvstrDocUpdBtn)).click();
	}

	@Test(priority = 27, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC27() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrDocuBtn)));
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		driver.findElement(By.xpath(InvstrViewBtn)).click();
		driver.findElement(By.xpath(InvstrDocBckBtn)).click();
	}

	@Test(priority = 28, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC28() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrDocuBtn)));
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrDocDwldBtn)));
		driver.findElement(By.xpath(InvstrDocDwldBtn)).click();
	}

	@Test(priority = 29, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC29() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		String InvestFileName = PropertyFileReader.propertymap.get("InvestFileName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrDocuBtn)));
		driver.findElement(By.xpath(InvstrDocuBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddDocBtn)));
		driver.findElement(By.xpath(InvstrAddDocBtn)).click();
		driver.findElement(By.name(InvstrFileName)).sendKeys(InvestFileName);
		driver.findElement(By.xpath(InvstrFileUpldBtn)).click();
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
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[3]/div[2]/div[1]/div/div/h6")));
		WebElement element3 = driver
				.findElement(By.xpath("//*[@id=\"kt_content_container\"]/form/div/div[3]/div[2]/div[1]/div/div/h6"));
		if (element3.isDisplayed()) {
			System.out.println("File uploaded sucessfully");
		} else {
			System.out.println("File not uploaded");
		}
		driver.findElement(By.name(InvstrShowDashBrdYes)).click();
		driver.findElement(By.xpath(InvstrShowToInvstrNo)).click();
		driver.findElement(By.xpath(InvstrFileAddSaveBtn)).click();
	}

	@Test(priority = 30, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC30() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrNewFeedBtn)));
		driver.findElement(By.xpath(InvstrNewFeedBtn)).click();
		driver.findElement(By.xpath(InvstrNewFeedViewIcon)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrNewFeedUpdBtn)));
		driver.findElement(By.xpath(InvstrNewFeedUpdBtn)).click();
	}

	@Test(priority = 31, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC31() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrNewFeedBtn)));
		driver.findElement(By.xpath(InvstrNewFeedBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddFeedBtn)));
		driver.findElement(By.xpath(InvstrAddFeedBtn)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddFeedSaveBtn)));
		driver.findElement(By.xpath(InvstrAddFeedSaveBtn)).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/div/div[3]/button")));
		ele1 = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/div/div[3]/button"));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory alert message is displayed");
			ele2 = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("No mandatory message is displayed");
		}
	}

	@Test(priority = 32, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC32() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrNewFeedBtn)));
		driver.findElement(By.xpath(InvstrNewFeedBtn)).click();
		driver.findElement(By.xpath(InvstrNewFeedViewIcon)).click();
		driver.findElement(By.xpath(InvstrFeedClsBtn)).click();
	}

	@Test(priority = 33, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC33() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		String InvestTitle = PropertyFileReader.propertymap.get("InvestTitle");
		String InvestNewsFeed = PropertyFileReader.propertymap.get("InvestNewsFeed");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrNewFeedBtn)));
		driver.findElement(By.xpath(InvstrNewFeedBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrAddFeedBtn)));
		driver.findElement(By.xpath(InvstrAddFeedBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(InvstrAddFeedTitBtn)));
		driver.findElement(By.name(InvstrAddFeedTitBtn)).sendKeys(InvestTitle);
		driver.findElement(By.name(InvstrAddNewsFeedBtn)).sendKeys(InvestNewsFeed);
		driver.findElement(By.name(InvstrDashBrdYes)).click();
		driver.findElement(By.xpath(InvstrAddShwYes)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(InvstrNewFeedSaveBtn)).click();
	}

	@Test(priority = 34, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC34() throws InterruptedException, AWTException {
		InvestorBtnClick();
		String InvestName1 = PropertyFileReader.propertymap.get("InvestName1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSrch)));
		driver.findElement(By.xpath(InvstrSrch)).sendKeys(InvestName1);
		driver.findElement(By.xpath(InvstrEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrRepBtn)));
		driver.findElement(By.xpath(InvstrRepBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrActBtn)));
		WebElement element1 = driver.findElement(By.xpath(InvstrActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(InvstrSubBtn)));
		driver.findElement(By.xpath(InvstrSubBtn)).click();
	}

}