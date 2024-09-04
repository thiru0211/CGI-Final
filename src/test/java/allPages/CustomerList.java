package allPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerList extends Locators {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9, ele;

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
	public void tearDown() throws IOException, InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void CustomerListClick() throws InterruptedException {
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
		ele = driver.findElement(By.xpath(CustomerBtn));
		ele.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusListBtn)));
		ele1 = driver.findElement(By.xpath(CusListBtn));
		ele1.click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void ACHFormClick() throws InterruptedException {
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ACHFormBtn)));
		driver.findElement(By.xpath(ACHFormBtn)).click();
	}

	@Test(priority = 1, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusBankDD)));
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(CusListNameBox)));
		driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
	}

	@Test(priority = 2, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException {
		CustomerListClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusListAddBtn)));
		driver.findElement(By.xpath(CusListAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddActBtn)));
		WebElement element1 = driver.findElement(By.xpath(CusAddActBtn));
		Actions act1 = new Actions(driver);
		act1.click().build().perform();
		element1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusListActSavBtn)));
		driver.findElement(By.xpath(CusListActSavBtn)).click();
		ele1 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div[10]/button"));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory alert message is displayed");
			ele2 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void CusAddDetailsFull() throws InterruptedException {
		CustomerListClick();
		PropertyFileReader.propertyRead();
		String CustPort = PropertyFileReader.propertymap.get("CustPort");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusListAddBtn)));
		driver.findElement(By.xpath(CusListAddBtn)).click();
		String CustmrId = PropertyFileReader.propertymap.get("CustmrId");
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CustID)));
		driver.findElement(By.name(CustID)).sendKeys(CustmrId);
		String CustmrName = PropertyFileReader.propertymap.get("CustmrName");
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CustName)));
		driver.findElement(By.name(CustName)).sendKeys(CustmrName);
		String CustInstDD = PropertyFileReader.propertymap.get("CustInstDD");
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusInstDD)));
		ele1 = driver.findElement(By.name(CusInstDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(CustInstDD);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusPort)));
		ele2 = driver.findElement(By.name(CusPort));
		Select sel2 = new Select(ele2);
		sel2.selectByIndex(2);

		// Getting Current Date
		// String CustPTODate=PropertyFileReader.propertymap.get("CustPTODate");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		driver.findElement(By.name(CusPTODate)).sendKeys(formattedDate);

		String CustCrdScre = PropertyFileReader.propertymap.get("CustCrdScre");
		driver.findElement(By.name(CusCrdScre)).sendKeys(CustCrdScre);
		String CustPrjSts = PropertyFileReader.propertymap.get("CustPrjSts");
		driver.findElement(By.name(CusPrjSts)).sendKeys(CustPrjSts);
		driver.findElement(By.name(CusStsYes)).click();
		driver.findElement(By.xpath(CusEnblStsYes)).click();
		driver.findElement(By.xpath(CusTypLTF)).click();
		String CustMonPay = PropertyFileReader.propertymap.get("CustMonPay");
		driver.findElement(By.name(CusMonPay)).sendKeys(CustMonPay);
		String CustTotYrs = PropertyFileReader.propertymap.get("CustTotYrs");
		driver.findElement(By.name(CusTotYrs)).sendKeys(CustTotYrs);
		String CustEscal = PropertyFileReader.propertymap.get("CustEscal");
		driver.findElement(By.name(CusEscal)).sendKeys(CustEscal);
		String CustTotConAmt = PropertyFileReader.propertymap.get("CustTotConAmt");
		driver.findElement(By.name(CusTotConAmt)).sendKeys(CustTotConAmt);
		String CustPhone = PropertyFileReader.propertymap.get("CustPhone");
		driver.findElement(By.name(CusPhone)).sendKeys(CustPhone);
		String CustEmail = PropertyFileReader.propertymap.get("CustEmail");
		driver.findElement(By.name(CusEmail)).sendKeys(CustEmail);
		String CustCntryDD = PropertyFileReader.propertymap.get("CustCntryDD");
		ele3 = driver.findElement(By.name(CusCntryDD));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(CustCntryDD);
		String CustStDD = PropertyFileReader.propertymap.get("CustStDD");
		ele4 = driver.findElement(By.id(CusStDD));
		Select sel4 = new Select(ele4);
		sel4.selectByVisibleText(CustStDD);
		String CustAdd1 = PropertyFileReader.propertymap.get("CustAdd1");
		driver.findElement(By.name(CusAdd1)).sendKeys(CustAdd1);
		String CustAdd2 = PropertyFileReader.propertymap.get("CustAdd2");
		driver.findElement(By.name(CusAdd2)).sendKeys(CustAdd2);
		String CustCity = PropertyFileReader.propertymap.get("CustCity");
		driver.findElement(By.name(CusCity)).sendKeys(CustCity);
		String CustZipCde = PropertyFileReader.propertymap.get("CustZipCde");
		driver.findElement(By.name(CusZipCde)).sendKeys(CustZipCde);
		String CustFinancing = PropertyFileReader.propertymap.get("CustFinancing");
		driver.findElement(By.name(CusFinancing)).sendKeys(CustFinancing);
		String CustProjCost = PropertyFileReader.propertymap.get("CustProjCost");
		driver.findElement(By.name(CusProjCost)).sendKeys(CustProjCost);
		String CustSysCost = PropertyFileReader.propertymap.get("CustSysCost");
		driver.findElement(By.name(CusSysCost)).sendKeys(CustSysCost);
		String CustSysSize = PropertyFileReader.propertymap.get("CustSysSize");
		driver.findElement(By.name(CusSysSize)).sendKeys(CustSysSize);
		String CustProd = PropertyFileReader.propertymap.get("CustProd");
		driver.findElement(By.name(CusProd)).sendKeys(CustProd);
		String CustPipLn = PropertyFileReader.propertymap.get("CustPipLn");
		driver.findElement(By.name(CusPipLn)).sendKeys(CustPipLn);
		String CustLeadPipLn = PropertyFileReader.propertymap.get("CustLeadPipLn");
		driver.findElement(By.name(CusLeadPipLn)).sendKeys(CustLeadPipLn);
		String CustPanels = PropertyFileReader.propertymap.get("CustPanels");
		driver.findElement(By.name(CusPanels)).sendKeys(CustPanels);
		String CustBatt = PropertyFileReader.propertymap.get("CustBatt");
		driver.findElement(By.name(CusBatt)).sendKeys(CustBatt);
		String CustWattPerPan = PropertyFileReader.propertymap.get("CustWattPerPan");
		driver.findElement(By.name(CusWattPerPan)).sendKeys(CustWattPerPan);
		String CustInvBrnd = PropertyFileReader.propertymap.get("CustInvBrnd");
		driver.findElement(By.name(CusInvBrnd)).sendKeys(CustInvBrnd);
	}

	@Test(priority = 3, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException {
		CusAddDetailsFull();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddClrBtn)));
		driver.findElement(By.xpath(CusAddClrBtn)).click();
	}

	@Test(priority = 4, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException {
		CusAddDetailsFull();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddSavBtn)));
		driver.findElement(By.xpath(CusAddSavBtn)).click();

	}

	@Test(priority = 5, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException {
		CustomerListClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddActBtn)));
		WebElement element1 = driver.findElement(By.xpath(CusAddActBtn));
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(CussAddActBackBtn)).click();
	}

	@Test(priority = 6, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException {
		CustomerListClick();
		String CustInstDD = PropertyFileReader.propertymap.get("CustInstDD");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusInstDD)));
		ele1 = driver.findElement(By.name(CusInstDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddSavBtn)));
		driver.findElement(By.xpath(CusAddSavBtn)).click();
		ele3 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
		if (ele3.isDisplayed()) {
			System.out.println("Mandatory message is showing");
			String text = ele3.getText();
			System.out.println("Alert message displayed liek: " + text);
			ele4 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div[9]/button"));
			ele4.click();
		} else {
			System.out.println("Mandatory Message is not showing");
		}
	}

	@Test(priority = 7, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException {
		CustomerListClick();
		String CustInstDD = PropertyFileReader.propertymap.get("CustInstDD");
		String CustAddPortName = PropertyFileReader.propertymap.get("CustAddPortName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusInstDD)));
		ele1 = driver.findElement(By.name(CusInstDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusPortAddBtn)));
		driver.findElement(By.xpath(CusPortAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusAddPortName)));
		driver.findElement(By.name(CusAddPortName)).sendKeys(CustAddPortName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddPortClrBtn)));
		ele2 = driver.findElement(By.xpath(CusAddPortClrBtn));
		ele2.click();
	}

	@Test(priority = 8, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException {
		CustomerListClick();
		String CustInstDD = PropertyFileReader.propertymap.get("CustInstDD");
		String CustAddPortName = PropertyFileReader.propertymap.get("CustAddPortName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[10]/div/div/a")));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		ele1 = driver.findElement(By.name(CusInstDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusPortAddBtn)));
		driver.findElement(By.xpath(CusPortAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusAddPortName)));
		driver.findElement(By.name(CusAddPortName)).sendKeys(CustAddPortName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddPortSavBtn)));
		ele2 = driver.findElement(By.xpath(CusAddPortSavBtn));
		ele2.click();
	}

	@Test(priority = 9, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException {
		CustomerListClick();
		String CustInstDD = PropertyFileReader.propertymap.get("CustInstDD");
		String CustAddPortName = PropertyFileReader.propertymap.get("CustAddPortName");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		ele1 = driver.findElement(By.name(CusInstDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusPortAddBtn)));
		driver.findElement(By.xpath(CusPortAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusAddPortName)));
		driver.findElement(By.name(CusAddPortName)).sendKeys(CustAddPortName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddPortClsBtn)));
		driver.findElement(By.xpath(CusAddPortClsBtn)).click();
	}

	@Test(priority = 10, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException {
		CustomerListClick();
		String CustInstDD = PropertyFileReader.propertymap.get("CustInstDD");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		ele1 = driver.findElement(By.name(CusInstDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusPort)));
		ele2 = driver.findElement(By.name(CusPort));
		Select sel1 = new Select(ele2);
		sel1.selectByIndex(2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddPortEditBtn)));
		driver.findElement(By.xpath(CusAddPortEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusAddPortName)));
		ele3 = driver.findElement(By.name(CusAddPortName));
		ele3.sendKeys("\b" + "a");
		driver.findElement(By.xpath(CusAddPortSavBtn)).click();
	}

	@Test(priority = 11, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException {
		CustomerListClick();
		String CustInstDD = PropertyFileReader.propertymap.get("CustInstDD");
		String CustPort = PropertyFileReader.propertymap.get("CustPort");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		ele1 = driver.findElement(By.name(CusInstDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CustInstDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusPort)));
		ele2 = driver.findElement(By.name(CusPort));
		Select sel1 = new Select(ele2);
		sel1.selectByIndex(2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddPortEditBtn)));
		driver.findElement(By.xpath(CusAddPortEditBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddPortClsBtn)));
		driver.findElement(By.xpath(CusAddPortClsBtn)).click();
	}

	// Repeat check
	@Test(priority = 12, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC12() throws InterruptedException {
		CusAddDetailsFull();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddSavBtn)));
		driver.findElement(By.xpath(CusAddSavBtn)).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[text()='Duplicate ID, Given Id already exists']")));
		ele1 = driver.findElement(By.xpath("//div[text()='Duplicate ID, Given Id already exists']"));
		if (ele1.isDisplayed()) {
			ele2 = driver.findElement(By.name(CustID));
			String ModifiedCusID = ele2.getAttribute("value");
			ele3 = driver.findElement(By.name(CustID));
			ele3.sendKeys(ModifiedCusID + "0");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddSavBtn)));
			driver.findElement(By.xpath(CusAddSavBtn)).click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[text()='Duplicate ID, Given Id already exists']")));
			ele4 = driver.findElement(By.xpath("//div[text()='Duplicate ID, Given Id already exists']"));
			if (ele4.isDisplayed()) {
				ele5 = driver.findElement(By.name(CustID));
				String ModifiedCusID1 = ele5.getAttribute("value");
				ele6 = driver.findElement(By.name(CustID));
				ele6.sendKeys("1");
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddSavBtn)));
				driver.findElement(By.xpath(CusAddSavBtn)).click();
			}
		} else {
			System.out.println("Details added sucessfully");
		}
	}

	@Test(priority = 13, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException {
		CustomerListClick();
		PropertyFileReader.propertyRead();
		String CustmrId = PropertyFileReader.propertymap.get("CustmrId");
		String CustmrName = PropertyFileReader.propertymap.get("CustmrName");
		String CustInstDD = PropertyFileReader.propertymap.get("CustInstDD");
		String CustPort = PropertyFileReader.propertymap.get("CustPort");
		String CustCrdScre = PropertyFileReader.propertymap.get("CustCrdScre");
		String CustPrjSts = PropertyFileReader.propertymap.get("CustPrjSts");
		String CustTotConAmt = PropertyFileReader.propertymap.get("CustTotConAmt");
		String CustPhone = PropertyFileReader.propertymap.get("CustPhone");
		String CustEmail = PropertyFileReader.propertymap.get("CustEmail");
		String CustCntryDD = PropertyFileReader.propertymap.get("CustCntryDD");
		String CustStDD = PropertyFileReader.propertymap.get("CustStDD");
		String CustAdd1 = PropertyFileReader.propertymap.get("CustAdd1");
		String CustAdd2 = PropertyFileReader.propertymap.get("CustAdd2");
		String CustCity = PropertyFileReader.propertymap.get("CustCity");
		String CustZipCde = PropertyFileReader.propertymap.get("CustZipCde");
		String CustFinancing = PropertyFileReader.propertymap.get("CustFinancing");
		String CustProjCost = PropertyFileReader.propertymap.get("CustProjCost");
		String CustSysCost = PropertyFileReader.propertymap.get("CustSysCost");
		String CustSysSize = PropertyFileReader.propertymap.get("CustSysSize");
		String CustProd = PropertyFileReader.propertymap.get("CustProd");
		String CustPipLn = PropertyFileReader.propertymap.get("CustPipLn");
		String CustLeadPipLn = PropertyFileReader.propertymap.get("CustLeadPipLn");
		String CustPanels = PropertyFileReader.propertymap.get("CustPanels");
		String CustBatt = PropertyFileReader.propertymap.get("CustBatt");
		String CustWattPerPan = PropertyFileReader.propertymap.get("CustWattPerPan");
		String CustInvBrnd = PropertyFileReader.propertymap.get("CustInvBrnd");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusLisActBtn)));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusListAddBtn)));
		driver.findElement(By.xpath(CusListAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CustID)));
		driver.findElement(By.name(CustID)).sendKeys(CustmrId);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CustName)));
		driver.findElement(By.name(CustName)).sendKeys(CustmrName);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusInstDD)));
		ele1 = driver.findElement(By.name(CusInstDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(CustInstDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusPort)));
		ele2 = driver.findElement(By.name(CusPort));
		Select sel2 = new Select(ele2);
		sel2.selectByIndex(2);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		driver.findElement(By.name(CusPTODate)).sendKeys(formattedDate);
		driver.findElement(By.name(CusCrdScre)).sendKeys(CustCrdScre);
		driver.findElement(By.name(CusPrjSts)).sendKeys(CustPrjSts);
		driver.findElement(By.name(CusStsYes)).click();
		driver.findElement(By.xpath(CusEnblStsYes)).click();
		driver.findElement(By.xpath(CusTypPre)).click();
		// driver.findElement(By.name(CusMonPay)).sendKeys(CustMonPay);
		// driver.findElement(By.name(CusTotYrs)).sendKeys(CustTotYrs);
		// driver.findElement(By.name(CusEscal)).sendKeys(CustEscal);
		driver.findElement(By.name(CusTotConAmt)).sendKeys(CustTotConAmt);
		driver.findElement(By.name(CusPhone)).sendKeys(CustPhone);
		driver.findElement(By.name(CusEmail)).sendKeys(CustEmail);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusCntryDD)));
		ele3 = driver.findElement(By.name(CusCntryDD));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(CustCntryDD);

		ele4 = driver.findElement(By.id(CusStDD));
		Select sel4 = new Select(ele4);
		sel4.selectByVisibleText(CustStDD);

		driver.findElement(By.name(CusAdd1)).sendKeys(CustAdd1);
		driver.findElement(By.name(CusAdd2)).sendKeys(CustAdd2);
		driver.findElement(By.name(CusCity)).sendKeys(CustCity);
		driver.findElement(By.name(CusZipCde)).sendKeys(CustZipCde);
		driver.findElement(By.name(CusFinancing)).sendKeys(CustFinancing);
		driver.findElement(By.name(CusProjCost)).sendKeys(CustProjCost);
		driver.findElement(By.name(CusSysCost)).sendKeys(CustSysCost);
		driver.findElement(By.name(CusSysSize)).sendKeys(CustSysSize);
		driver.findElement(By.name(CusProd)).sendKeys(CustProd);
		driver.findElement(By.name(CusPipLn)).sendKeys(CustPipLn);
		driver.findElement(By.name(CusLeadPipLn)).sendKeys(CustLeadPipLn);
		driver.findElement(By.name(CusPanels)).sendKeys(CustPanels);
		driver.findElement(By.name(CusBatt)).sendKeys(CustBatt);
		driver.findElement(By.name(CusWattPerPan)).sendKeys(CustWattPerPan);
		driver.findElement(By.name(CusInvBrnd)).sendKeys(CustInvBrnd);
		driver.findElement(By.xpath(CusAddSavBtn)).click();
		Thread.sleep(1000);
		ele5 = driver.findElement(By.xpath("(//div[text()='Duplicate ID, Given Id already exists'])"));
		if (ele5.isDisplayed()) {
			ele6 = driver.findElement(By.name(CustID));
			String ModifiedCusID = ele6.getAttribute("value");
			ele7 = driver.findElement(By.name(CustID));
			ele7.sendKeys(ModifiedCusID + "0");
			Thread.sleep(2000);
			driver.findElement(By.xpath(CusAddSavBtn)).click();
			Thread.sleep(2000);
			ele8 = driver.findElement(By.xpath("//div[text()='Duplicate ID, Given Id already exists']"));
			if (ele8.isDisplayed()) {
				ele9 = driver.findElement(By.name(CustID));
				String ModifiedCusID1 = ele9.getAttribute("value");
				WebElement elee = driver.findElement(By.name(CustID));
				elee.sendKeys("1");
				Thread.sleep(2000);
				driver.findElement(By.xpath(CusAddSavBtn)).click();
			}
		} else {
			System.out.println("No duplicate message is shown");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 14, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException {
		CustomerListClick();
		PropertyFileReader.propertyRead();
		String CustmrId = PropertyFileReader.propertymap.get("CustmrId");
		String CustmrName = PropertyFileReader.propertymap.get("CustmrName");
		String CustInstDD = PropertyFileReader.propertymap.get("CustInstDD");
		String CustPort = PropertyFileReader.propertymap.get("CustPort");
		String CustCrdScre = PropertyFileReader.propertymap.get("CustCrdScre");
		String CustPrjSts = PropertyFileReader.propertymap.get("CustPrjSts");
		String CustMonPay = PropertyFileReader.propertymap.get("CustMonPay");
		String CustTotYrs = PropertyFileReader.propertymap.get("CustTotYrs");
		String CustEscal = PropertyFileReader.propertymap.get("CustEscal");
		String CustTotConAmt = PropertyFileReader.propertymap.get("CustTotConAmt");
		String CustPhone = PropertyFileReader.propertymap.get("CustPhone");
		String CustEmail = PropertyFileReader.propertymap.get("CustEmail");
		String CustCntryDD = PropertyFileReader.propertymap.get("CustCntryDD");
		String CustStDD = PropertyFileReader.propertymap.get("CustStDD");
		String CustAdd1 = PropertyFileReader.propertymap.get("CustAdd1");
		String CustAdd2 = PropertyFileReader.propertymap.get("CustAdd2");
		String CustCity = PropertyFileReader.propertymap.get("CustCity");
		String CustZipCde = PropertyFileReader.propertymap.get("CustZipCde");
		String CustFinancing = PropertyFileReader.propertymap.get("CustFinancing");
		String CustProjCost = PropertyFileReader.propertymap.get("CustProjCost");
		String CustSysCost = PropertyFileReader.propertymap.get("CustSysCost");
		String CustSysSize = PropertyFileReader.propertymap.get("CustSysSize");
		String CustProd = PropertyFileReader.propertymap.get("CustProd");
		String CustPipLn = PropertyFileReader.propertymap.get("CustPipLn");
		String CustLeadPipLn = PropertyFileReader.propertymap.get("CustLeadPipLn");
		String CustPanels = PropertyFileReader.propertymap.get("CustPanels");
		String CustBatt = PropertyFileReader.propertymap.get("CustBatt");
		String CustWattPerPan = PropertyFileReader.propertymap.get("CustWattPerPan");
		String CustInvBrnd = PropertyFileReader.propertymap.get("CustInvBrnd");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[10]/div/div/a")));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		driver.findElement(By.name(CustID)).sendKeys(CustmrId);
		driver.findElement(By.name(CustName)).sendKeys(CustmrName);

		ele1 = driver.findElement(By.name(CusInstDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(CustInstDD);

		ele2 = driver.findElement(By.name(CusPort));
		Select sel2 = new Select(ele2);
		sel2.selectByIndex(2);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		driver.findElement(By.name(CusPTODate)).sendKeys(formattedDate);
		driver.findElement(By.name(CusCrdScre)).sendKeys(CustCrdScre);
		driver.findElement(By.name(CusPrjSts)).sendKeys(CustPrjSts);
		driver.findElement(By.name(CusStsYes)).click();
		driver.findElement(By.xpath(CusEnblStsYes)).click();
		driver.findElement(By.name(CusTypMP)).click();
		driver.findElement(By.name(CusMonPay)).sendKeys(CustMonPay);
		driver.findElement(By.name(CusTotYrs)).sendKeys(CustTotYrs);
		driver.findElement(By.name(CusEscal)).sendKeys(CustEscal);
		driver.findElement(By.name(CusTotConAmt)).sendKeys(CustTotConAmt);
		driver.findElement(By.name(CusPhone)).sendKeys(CustPhone);
		driver.findElement(By.name(CusEmail)).sendKeys(CustEmail);

		ele3 = driver.findElement(By.name(CusCntryDD));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(CustCntryDD);

		ele4 = driver.findElement(By.id(CusStDD));
		Select sel4 = new Select(ele4);
		sel4.selectByVisibleText(CustStDD);

		driver.findElement(By.name(CusAdd1)).sendKeys(CustAdd1);
		driver.findElement(By.name(CusAdd2)).sendKeys(CustAdd2);
		driver.findElement(By.name(CusCity)).sendKeys(CustCity);
		driver.findElement(By.name(CusZipCde)).sendKeys(CustZipCde);
		driver.findElement(By.name(CusFinancing)).sendKeys(CustFinancing);
		driver.findElement(By.name(CusProjCost)).sendKeys(CustProjCost);
		driver.findElement(By.name(CusSysCost)).sendKeys(CustSysCost);
		driver.findElement(By.name(CusSysSize)).sendKeys(CustSysSize);
		driver.findElement(By.name(CusProd)).sendKeys(CustProd);
		driver.findElement(By.name(CusPipLn)).sendKeys(CustPipLn);
		driver.findElement(By.name(CusLeadPipLn)).sendKeys(CustLeadPipLn);
		driver.findElement(By.name(CusPanels)).sendKeys(CustPanels);
		driver.findElement(By.name(CusBatt)).sendKeys(CustBatt);
		driver.findElement(By.name(CusWattPerPan)).sendKeys(CustWattPerPan);
		driver.findElement(By.name(CusInvBrnd)).sendKeys(CustInvBrnd);
		driver.findElement(By.xpath(CusAddSavBtn)).click();
		Thread.sleep(1000);
		ele5 = driver.findElement(By.xpath("(//div[text()='Duplicate ID, Given Id already exists'])"));
		if (ele5.isDisplayed()) {
			ele6 = driver.findElement(By.name(CustID));
			String ModifiedCusID = ele6.getAttribute("value");
			ele7 = driver.findElement(By.name(CustID));
			ele7.sendKeys(ModifiedCusID + "0");
			Thread.sleep(2000);
			driver.findElement(By.xpath(CusAddSavBtn)).click();
			Thread.sleep(2000);
			ele8 = driver.findElement(By.xpath("//div[text()='Duplicate ID, Given Id already exists']"));
			if (ele8.isDisplayed()) {
				ele9 = driver.findElement(By.name(CustID));
				String ModifiedCusID1 = ele9.getAttribute("value");
				WebElement elee = driver.findElement(By.name(CustID));
				elee.sendKeys("1");
				Thread.sleep(2000);
				driver.findElement(By.xpath(CusAddSavBtn)).click();
			}
		} else {
			System.out.println("No duplicate message is shown");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 15, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException {
		CustomerListClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[10]/div/div/a")));
		WebElement element = driver.findElement(By.xpath(CusLisActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusListAddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusAddActBtn)));
		WebElement element1 = driver.findElement(By.xpath(CusAddActBtn));
		act.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(CusActBckbtn)).click();
	}

	@Test(priority = 16, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		driver.findElement(By.xpath(CusAddNotesBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusNotesSavBtn)));
		driver.findElement(By.xpath(CusNotesSavBtn)).click();
	}

	@Test(priority = 18, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC18() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		driver.findElement(By.xpath(CusAddNotesBtn)).click();
		driver.findElement(By.xpath(CusNotesClsBtn)).click();
	}

	@Test(priority = 19, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException {
		CustomerListClick();
		Thread.sleep(2000);
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		String CusNotes = PropertyFileReader.propertymap.get("CusNotes");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		driver.findElement(By.xpath(CusAddNotesBtn)).click();
		ele1 = driver.findElement(By.xpath(CusNotesBtn));
		ele1.click();
		ele1.sendKeys(CusNotes);
		driver.findElement(By.xpath(CusNotesSavBtn)).click();
	}

	@Test(priority = 20, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC20() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditClrBtn)).click();
	}

	@Test(priority = 21, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		String CustCity = PropertyFileReader.propertymap.get("CustCity");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);

		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ele2 = driver.findElement(By.name(CusCity));
		js.executeScript("arguments[0].scrollIntoView(true);", ele2);
		Thread.sleep(2000);
		String InitialName = ele2.getAttribute("value");
		System.out.println(InitialName);
		for (int i = 0; i < InitialName.length(); i++) {
			ele2.sendKeys("\b"); // "/b" means give backspace to the text box
		}

		ele2.sendKeys(CustCity);
		driver.findElement(By.xpath(CusEditUpdBtn)).click();
	}

	@Test(priority = 22, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		act.click().build().perform();
		ele2.click();
		driver.findElement(By.xpath(CusEditBckBtn)).click();
	}

	@Test(priority = 23, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC23() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditInstAddBtn)).click();
		driver.findElement(By.xpath(CusEditPortSavBtn)).click();
	}

	@Test(priority = 24, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC24() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		String CustPort = PropertyFileReader.propertymap.get("CustPort");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditInstAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(CusEditPortName)).sendKeys(CustPort);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditPortClrBtn)).click();
	}

	@Test(priority = 25, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException {
		TC24();
		String CustPort = PropertyFileReader.propertymap.get("CustPort");
		driver.findElement(By.name(CusEditPortName)).sendKeys(CustPort);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditPortSavBtn)).click();
	}

	@Test(priority = 26, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC26() throws InterruptedException {
		TC24();
		driver.findElement(By.xpath(CusEditPortClseBtn)).click();
	}

	@Test(priority = 27, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC27() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditPortEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditPortSavBtn)).click();
	}

	@Test(priority = 28, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC28() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditPortEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditPortClseBtn)).click();
	}

	@Test(priority = 29, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC29() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditLTFBtn)).click();
		Thread.sleep(2000);
		WebElement ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
		Actions act1 = new Actions(driver);
		Thread.sleep(2000);
		act1.click().build().perform();
		Thread.sleep(2000);
		ele2.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditUpdBtn2)).click();
	}

	@Test(priority = 30, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC30() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By
				.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[11]/div[2]/label/div/span[1]/input"))
				.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		act.click().build().perform();
		ele2.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditUpdBtn2)).click();
	}

	@Test(priority = 31, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC31() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By
				.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[11]/div[2]/label/div/span[2]/input"))
				.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		act.click().build().perform();
		ele2.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditUpdBtn2)).click();
	}

	@Test(priority = 32, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC32() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		driver.findElement(By
				.xpath("//*[@id=\"kt_content_container\"]/div/form/div/div[2]/div[11]/div[2]/label/div/span[2]/input"))
				.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActBtn2));
		act.click().build().perform();
		ele2.click();
		driver.findElement(By.xpath(CusEditBckBtn2)).click();
	}

	@Test(priority = 71, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC33() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(CusEditCusBtn)).click();
		Thread.sleep(2000);
		ele = driver.findElement(By.name(CustName));
		String text = ele.getAttribute("value");
		System.out.println(text);
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele4 = driver.findElement(By.name(CustName));
			ele4.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(CustName));
		ele2.sendKeys(text);
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath(CusEditActBtn1));
		Actions act1 = new Actions(driver);
		act1.click().build().perform();
		element1.click();
		driver.findElement(By.xpath(CusEditUpdBtn1)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void CusEditActBtn() throws InterruptedException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		Thread.sleep(2000);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
	}

	@Test(priority = 33, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC34() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditPaySchBtn)).click();
		driver.findElement(By.xpath(CusEditPayUpdBtn)).click();
		Thread.sleep(2000);
		ele = driver.findElement(By.xpath(CusEditActPayBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele.click();
		driver.findElement(By.xpath(CusEditActPayBckBtn)).click();
	}

	@Test(priority = 34, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC35() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditActPayMergeBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(CusEditActPayBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele2.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditActMergeBckBtn)).click();
	}

	@Test(priority = 35, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC36() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditActPayMergeBtn)).click();
		driver.findElement(By.xpath(CusEditMrgeAgreBtn)).click();
		driver.findElement(By.xpath(CusEditMrgeBtn)).click();
		ele1 = driver.findElement(
				By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/div/div[3]/div[1]/div[2]/div/div/span"));
		if (ele1.isDisplayed()) {
			System.out.println("Select customer tab show alert toast");
			String text = ele1.getText();
			System.out.println("Alert message is displayed like: " + text);
		} else {
			System.out.println("Select customer tab doesnot show alert message");
		}
	}

	@Test(priority = 36, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC37() throws InterruptedException {
		CusEditActBtn();
		String CustChoseToMerge = PropertyFileReader.propertymap.get("CustChoseToMerge");
		driver.findElement(By.xpath(CusEditActPayMergeBtn)).click();
		ele1 = driver.findElement(By.xpath(CusEditChoseMrgDD));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div/div[1]"));
		ele2.click();
		driver.findElement(By.xpath(CusEditMrgeAgreBtn)).click();
		driver.findElement(By.xpath(CusEditMrgeBtn)).click();
	}

	@Test(priority = 37, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC38() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditViewRcdPaymtsBtn)).click();
		driver.findElement(By.xpath(CusEditRcdPymntPrntbtn)).click();
	}

	@Test(priority = 38, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC39() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditMntlyPymnBtn)).click();
		driver.findElement(By.xpath(CusEditMntlyPymnSavBtn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div/button"));
		if (ele1.isDisplayed()) {
			System.out.println("Page shows alert message");
		} else {
			System.out.println("Page doesnot show alert message");
		}
	}

	@Test(priority = 39, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC40() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditMntlyPymnBtn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(CusEditMnthlyPymnActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele1.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusEditMnthlyPymnBckBtn)));
		driver.findElement(By.xpath(CusEditMnthlyPymnBckBtn)).click();
	}

	@Test(priority = 40, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC41() throws InterruptedException {
		CusEditActBtn();
		String CustMonltyAmt = PropertyFileReader.propertymap.get("CustMonltyAmt");
		String CustMntlPayReason = PropertyFileReader.propertymap.get("CustMntlPayReason");
		driver.findElement(By.xpath(CusEditMntlyPymnBtn)).click();
		driver.findElement(By.name(CusEditMntlyPayTab)).sendKeys(CustMonltyAmt);
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String EffectiveDromDate= scanner.nextLine();

		// Get current date
		Calendar calendar = Calendar.getInstance();
		// Get month (0-based indexing) and year
		int month = calendar.get(Calendar.MONTH); // January = 0, December = 11
		int year = calendar.get(Calendar.YEAR);
		// Format month name and year
		SimpleDateFormat monthFormatter = new SimpleDateFormat("MMM"); // Abbreviated month name
		String formattedMonth = monthFormatter.format(calendar.getTime());
		// Combine month and year
		String formattedDate = formattedMonth + "/" + year;
		driver.findElement(By.xpath(CusEditMntlyEffFrom)).sendKeys(formattedDate);
		driver.findElement(By.name(CusEditMntlyRsonTab)).sendKeys(CustMntlPayReason);
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditMntlyPymnSavBtn)).click();
	}

	@Test(priority = 41, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC42() throws InterruptedException {
		CusEditActBtn();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditCRMMonitBtn)).click();
		Thread.sleep(2000);
		// //name in CRM error toast check
		// ele1=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/form/div/div[3]/div[2]/div[2]/div"));
		// //production escalation error toast check
		// ele3=driver.findElement(By.name("productionescalation"));
		// String text = ele3.getAttribute("value");
		// int length = text.length();
		// for(int i=0;i<length;i++) {
		// ele3.sendKeys(Keys.BACK_SPACE);
		// }
		// ele2=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[2]/form/div/div[3]/div[3]/div[2]/div"));
		// if(ele1.isDisplayed())
		// {
		// System.out.println("Error toast appears in Name in CRM field");
		// if(ele2.isDisplayed()) {
		// System.out.println("Error toast appears in Production escalation field");
		// }
		// else {
		// System.out.println("No error is appears in the page");
		// }
		// }
		ele1 = driver.findElement(By.id("crmname"));
		Select sel = new Select(ele1);
		sel.selectByIndex(0);
		ele2 = driver.findElement(By.name("productionescalation"));
		String attribute = ele2.getAttribute("value");
		int length = attribute.length();
		for (int i = 0; i < length; i++) {
			ele2.sendKeys(Keys.BACK_SPACE);
		}

		ele3 = driver.findElement(By.name("firstyearproduction"));
		String attribute1 = ele3.getAttribute("value");
		int length1 = attribute1.length();
		for (int i = 0; i < length1; i++) {
			ele3.sendKeys(Keys.BACK_SPACE);
		}
		driver.findElement(By.xpath(IPChMntPyMonCRMUpd)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div[4]/button")));
		ele4 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div/div[4]/button"));
		if (ele4.isDisplayed()) {
			System.out.println("Error Message is show");
			ele5 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele5.getText();
			System.out.println("Alert message displayed like: " + text);
			ele4.click();
		} else {
			System.out.println("Error message is not show");
		}
	}

	@Test(priority = 42, retryAnalyzer = ReRunFailedTestCase.class, description = "This function is not working properly in the webpage")
	public void TC43() throws InterruptedException {
		CusEditActBtn();
		String CustCRMDD = PropertyFileReader.propertymap.get("CustCRMDD");
		String CustEditCRMNameDD = PropertyFileReader.propertymap.get("CustEditCRMNameDD");
		String CustEditProdEsc = PropertyFileReader.propertymap.get("CustEditProdEsc");
		String CustEditFrstYrProd = PropertyFileReader.propertymap.get("CustEditFrstYrProd");
		driver.findElement(By.xpath(CusEditCRMMonitBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(CusEditCRMDD)));
		ele1 = driver.findElement(By.id(CusEditCRMDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CustCRMDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(CusEditCRMNameDD)));
		ele2 = driver.findElement(By.id(CusEditCRMNameDD));
		Select sel1 = new Select(ele2);
		sel1.selectByVisibleText(CustEditCRMNameDD);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(CusEditProdEsc)));
		driver.findElement(By.name(CusEditProdEsc)).sendKeys(CustEditProdEsc);
		driver.findElement(By.name(CusEditFrstYrProd)).sendKeys(CustEditFrstYrProd);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusEditCRMUpdBtn)));
		driver.findElement(By.xpath(CusEditCRMUpdBtn)).click();
	}

	@Test(priority = 43, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC44() throws InterruptedException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditCRMMonitBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusEditCRMActBtn)));
		ele1 = driver.findElement(By.xpath(CusEditCRMActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusEditCrmBckBtn)));
		driver.findElement(By.xpath(CusEditCrmBckBtn)).click();
	}

	@Test(priority = 44, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC45() throws InterruptedException {
		CusEditActBtn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusEditDocStup)));
		driver.findElement(By.xpath(CusEditDocStup)).click();
		driver.findElement(By.xpath(CusEditDocChckBox)).click();
		driver.findElement(By.xpath(CusEditDocStupSveBtn)).click();
		// mandatory toast check
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[2]/div/div")));
		ele1 = driver
				.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div[2]/form/div/div/div[2]/div/div"));
		if (ele1.isDisplayed()) {
			System.out.println("Attach document alert toast is shown");
			String text = ele1.getText();
			System.out.println("Alert message displayed like: " + text);

		} else {
			System.out.println("Alert toast is not shown");
		}
	}

	@Test(priority = 45, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC46() throws InterruptedException, AWTException {
		CusEditActBtn();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditDocStup)).click();
		driver.findElement(By.xpath(CusEditDocUpldBtn)).click();
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\blank.pdf";
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
		driver.findElement(By.xpath(CusEditDocChckBox)).click();
		driver.findElement(By.xpath(CusEditDocStupSveBtn)).click();
	}

	@Test(priority = 46, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC47() throws InterruptedException, AWTException {
		CusEditActBtn();
		driver.findElement(By.xpath(CusEditDocStup)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(CusEditDocActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele1.click();
		driver.findElement(By.xpath(CusEditDocBckBtn)).click();
	}

	@Test(priority = 47, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC48() throws InterruptedException, AWTException {
		CusEditActBtn();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditDocEscProg)).click();
		Thread.sleep(2000);
		driver.findElement(By.id("selectedDate")).sendKeys("01-01-2023");
		driver.findElement(By.xpath("(//button[text()='Calculate'])")).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(CusEditEscAgreBtn));
		driver.findElement(By.xpath(CusEditEscRobtBtn)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.click();
		driver.findElement(By.xpath(CusEditEscUpdBtn)).click();
	}

	@Test(priority = 48, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC49() throws InterruptedException, AWTException {
		CustomerListClick();
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CusBankNameDD);
		driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusEditActBtn)));
		ele1 = driver.findElement(By.xpath(CusEditActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CusEditBackBtn)));
		driver.findElement(By.xpath(CusEditBackBtn)).click();
	}

	@Test(priority = 49, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC50() throws InterruptedException, AWTException {
		CustomerListClick();
		Thread.sleep(2000);
		String CusBankNameDD = PropertyFileReader.propertymap.get("CusBankNameDD");
		String CusListName = PropertyFileReader.propertymap.get("CusListName");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(CusBankDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText("LA SOLAR");
		Thread.sleep(2000);
		// driver.findElement(By.id(CusListNameBox)).sendKeys(CusListName);
		driver.findElement(By.xpath(CusNameEditBtn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(CusEditViewBtn));
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CusEditViewClseBtn)).click();
	}

	@Test(priority = 50, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC51() throws InterruptedException, AWTException {
		ACHFormClick();
		String ACHBankDD = PropertyFileReader.propertymap.get("ACHBankDD");
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(ACHBankDD);
		ele2 = driver.findElement(By.xpath(ACHBnkSrch));
		ele2.click();
		boolean enabledCheck = ele2.isEnabled();
		if (enabledCheck) {
			System.out.println("Search Box is clicked");
		} else {
			System.out.println("Search Box is not clicked");
		}
	}

	@Test(priority = 51, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC52() throws InterruptedException, AWTException {
		ACHFormClick();
		String ACHBankDD = PropertyFileReader.propertymap.get("ACHBankDD");
		String ACHSrch = PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditManEtry)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHEditRobChckBox));
		ele4.click();
		driver.findElement(By.xpath(ACHCheckBox1)).click();
		driver.findElement(By.xpath(ACHCheckBox2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditUpdBtn1)).click();
		Thread.sleep(2000);
		ele5 = driver.findElement(By.xpath(ACHEditMandChck));
		if (ele5.isDisplayed()) {
			System.out.println("Mandatory popup is shown");
			ele6 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele6.getText();
			System.out.println("Alert message displayed like: " + text);
			ele5.click();
		} else {
			System.out.println("Mandatory popup is not shown");
		}
	}

	@Test(priority = 52, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC53() throws InterruptedException, AWTException {
		ACHFormClick();
		Thread.sleep(2000);
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch = PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditManEtry)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditBckBtn)).click();
	}

	@Test(priority = 53, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC54() throws InterruptedException, AWTException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch = PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHNameOnAcc = PropertyFileReader.propertymap.get("ACHNameOnAcc");
		String ACHBnkName = PropertyFileReader.propertymap.get("ACHBnkName");
		String ACHAccNumb = PropertyFileReader.propertymap.get("ACHAccNumb");
		String ACHAccRoutNumb = PropertyFileReader.propertymap.get("ACHAccRoutNumb");
		String ACHBankLoc = PropertyFileReader.propertymap.get("ACHBankLoc");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		driver.findElement(By.xpath(ACHEditManEtry)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(4000);
		ele4 = driver.findElement(By.name(ACHNamOnAcc));
		ele4.clear();
		ele4.sendKeys(ACHNameOnAcc);
		Thread.sleep(2000);
		ele5 = driver.findElement(By.name(ACHBnkNam));
		ele5.clear();
		ele5.sendKeys(ACHBnkName);
		Thread.sleep(2000);
		ele6 = driver.findElement(By.name(ACHAccNum));
		ele6.clear();
		ele6.sendKeys(ACHAccNumb);
		Thread.sleep(2000);
		ele7 = driver.findElement(By.name(ACHAccRoutNum));
		ele7.clear();
		ele7.sendKeys(ACHAccRoutNumb);
		Thread.sleep(2000);
		ele8 = driver.findElement(By.name(ACHBnkLoc));
		ele8.clear();
		ele8.sendKeys(ACHBankLoc);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHEditRobChckBox)).click();
		driver.findElement(By.xpath(ACHCheckBox1)).click();
		driver.findElement(By.xpath(ACHCheckBox2)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn1)).click();
	}

	@Test(priority = 54, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC55() throws InterruptedException, AWTException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch = PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		driver.findElement(By.xpath(ACHEditClsBtn)).click();
	}

	@Test(priority = 55, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC56() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch = PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(4000);
		ele4 = driver
				.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[2]/div[1]/div/input"));
		String text = ele4.getText();
		System.out.println(text);
		ele4.clear();
		Thread.sleep(2000);
		ele4.sendKeys("0211thiru@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndBtn)).click();
	}

	@Test(priority = 58, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC57() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(4000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHActSndToSls)).click();
	}

	@Test(priority = 57, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC58() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHActCngPayDte)).click();
		driver.findElement(By.xpath(ACHActCngPayDteBtn)).click();
		ele5 = driver.findElement(By.xpath(ACHActCngPayMandChk));
		Thread.sleep(2000);
		if (ele5.isDisplayed()) {
			System.out.println("Mandatory Field alert toast appears");
			ele6 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele6.getText();
			System.out.println("Alert message displayed like: " + text);
		} else {
			System.out.println("Mandatory Field alert toast is not appeared");
		}
		ele5.click();
	}

	@Test(priority = 58, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC59() throws InterruptedException {
		TC58();
		String ACHPayDate = PropertyFileReader.propertymap.get("ACHPayDate");
		// mandatory ok button click
		// driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div/div/button")).click();
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String EffectiveFromDate= scanner.nextLine();

		// Get current date
		Calendar calendar = Calendar.getInstance();
		// Get month (0-based indexing) and year
		int month = calendar.get(Calendar.MONTH); // January = 0, December = 11
		int year = calendar.get(Calendar.YEAR);
		// Format month name and year
		SimpleDateFormat monthFormatter = new SimpleDateFormat("MMM"); // Abbreviated month name
		String formattedMonth = monthFormatter.format(calendar.getTime());
		// Combine month and year
		String formattedDate = formattedMonth + "/" + year;
		driver.findElement(By.xpath(ACHCngPayDteEffFrm)).sendKeys(formattedDate);
		ele1 = driver.findElement(By.xpath(ACHCngpayDate));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(ACHPayDate);
		driver.findElement(By.xpath(ACHActCngPayDteBtn)).click();
	}

	@Test(priority = 59, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC60() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHSkipPay)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(ACHSkipPayAgreBtn)).click();
		driver.findElement(By.xpath(ACHSkipPymntBtn)).click();
		Thread.sleep(2000);
		ele5 = driver.findElement(By.xpath(ACHSkipPymntMandMsg));
		if (ele5.isDisplayed()) {
			System.out.println("Mandatory message is showing ");
			ele6 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele6.getText();
			System.out.println("Alert message displayed like: " + text);
			ele5.click();
		} else {
			System.out.println("Mandatory message is not showing ");
		}
	}

	@Test(priority = 60, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC61() throws InterruptedException {
		TC60();
		String ACHSkpPyReason = PropertyFileReader.propertymap.get("ACHSkpPyReason");
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String StartMntDate= scanner.next();
		// System.out.println("Please enter in the format like Mar/2024");
		// String EndMntDate= scanner.next();
//		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[2]/div/div[2]/div/div/button")).click();
		// Get current date
		Calendar calendar = Calendar.getInstance();
		// Get month (0-based indexing) and year
		int month = calendar.get(Calendar.MONTH); // January = 0, December = 11
		int year = calendar.get(Calendar.YEAR);
		// Format month name and year
		SimpleDateFormat monthFormatter = new SimpleDateFormat("MMM"); // Abbreviated month name
		String formattedMonth = monthFormatter.format(calendar.getTime());
		// Combine month and year
		String formattedDate = formattedMonth + "/" + year;
		driver.findElement(By.xpath(ACHSkpPyStrtMnth)).sendKeys(formattedDate);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSkpPyEndMnth)).sendKeys("Dec/2024");
		driver.findElement(By.name(ACHSkpPyRsn)).sendKeys(ACHSkpPyReason);
		driver.findElement(By.xpath(ACHSkipPymntBtn)).click();
	}

	@Test(priority = 61, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC62() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch = PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHScdToCusBckBtn)).click();
	}

	@Test(priority = 62, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC63() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2 = PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHSndToCusReq = PropertyFileReader.propertymap.get("ACHSndToCusReq");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCus)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(4000);
		ele4 = driver
				.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div[1]/div[2]/div[1]/div/input"));
		String text = ele4.getText();
		System.out.println(text);
		ele4.clear();
		Thread.sleep(2000);
		ele4.sendKeys("0211thiru@gmail.com");
		Thread.sleep(2000);
		// request box
		ele4 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/textarea"));
		ele4.clear();
		ele4.sendKeys(ACHSndToCusReq);
		// send button
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[8]/div/button"))
				.click();
	}

	@Test(priority = 63, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC64() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch = PropertyFileReader.propertymap.get("ACHSrch");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHScdToCusBckBtn)).click();
	}

	@Test(priority = 64, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC65() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2 = PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(4000);
		ele4 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[2]/div/div[2]/div[3]/div/input"));
		String text = ele4.getText();
		System.out.println(text);
		ele4.clear();
		Thread.sleep(2000);
		ele4.sendKeys("0211thiru@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsSndBtn)).click();
	}

	@Test(priority = 65, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC66() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2 = PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHScdToCusBckBtn)).click();
	}

	@Test(priority = 66, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC67() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2 = PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHPayDate = PropertyFileReader.propertymap.get("ACHPayDate");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHActCngPayDte)).click();
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String EffectiveFrom= scanner.next();
		// Get current date
		Calendar calendar = Calendar.getInstance();
		// Get month (0-based indexing) and year
		int month = calendar.get(Calendar.MONTH); // January = 0, December = 11
		int year = calendar.get(Calendar.YEAR);
		// Format month name and year
		SimpleDateFormat monthFormatter = new SimpleDateFormat("MMM"); // Abbreviated month name
		String formattedMonth = monthFormatter.format(calendar.getTime());
		// Combine month and year
		String formattedDate = formattedMonth + "/" + year;
		driver.findElement(By.xpath(ACHCngPayDteEffFrm)).sendKeys(formattedDate);
		ele5 = driver.findElement(By.xpath(ACHCngpayDate));
		Select sel = new Select(ele5);
		sel.selectByVisibleText(ACHPayDate);
		driver.findElement(By.xpath(ACHCngpayDateBtn)).click();
	}

	@Test(priority = 67, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC68() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD1 = PropertyFileReader.propertymap.get("ACHBankDD1");
		String ACHSrch2 = PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHPayDate = PropertyFileReader.propertymap.get("ACHPayDate");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD1);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele4.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToCusSkpPyBtn)).click();
		driver.findElement(By.name(ACHSkipPayAgreBtn)).click();
		driver.findElement(By.xpath(ACHSkipPymntBtn)).click();
		Thread.sleep(2000);
		ele5 = driver.findElement(By.xpath(ACHSndToCusSkpPyMan));
		if (ele5.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			ele6 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele6.getText();
			System.out.println("Alert message displayed like: " + text);
			ele5.click();
		} else {
			System.out.println("Mandatory message is not shown");
		}
	}

	@Test(priority = 68, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC69() throws InterruptedException {
		TC68();
		String ACHSkpPyRson = PropertyFileReader.propertymap.get("ACHSkpPyRson");
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String StartMonth= scanner.nextLine();
		// Get current date
		Calendar calendar = Calendar.getInstance();
		// Get month (0-based indexing) and year
		int month = calendar.get(Calendar.MONTH); // January = 0, December = 11
		int year = calendar.get(Calendar.YEAR);
		// Format month name and year
		SimpleDateFormat monthFormatter = new SimpleDateFormat("MMM"); // Abbreviated month name
		String formattedMonth = monthFormatter.format(calendar.getTime());
		// Combine month and year
		String formattedDate = formattedMonth + "/" + year;
		driver.findElement(By.name(ACHSndToCusSkpPySrtMnt)).sendKeys(formattedDate);
		Thread.sleep(3000);
		// Scanner scanner1 = new Scanner(System.in);
		// System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		// System.out.println("Please enter in the format like Feb/2024 (or) Mar/2024");
		// String EndMonth= scanner1.nextLine();
		driver.findElement(By.name(ACHSndToCusSkpPyEndMnt)).sendKeys("Feb/2023");
		driver.findElement(By.name(ACHSkpPyRsn)).sendKeys(ACHSkpPyRson);
		driver.findElement(By.xpath(ACHSkipPymntBtn)).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]")));
		ele = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]"));
		if (ele.isDisplayed()) {
			String text = ele.getText();
			System.out.println("Alert message displayed like: " + text);
		} else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(priority = 69, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC70() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD = PropertyFileReader.propertymap.get("ACHBankDD");
		String ACHSrch2 = PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		ele4.click();
		driver.findElement(By.xpath(ACHScdToCusBckBtn)).click();
	}

	@Test(priority = 70, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC71() throws InterruptedException {
		ACHFormClick();
		String ACHBankDD = PropertyFileReader.propertymap.get("ACHBankDD");
		String ACHSrch2 = PropertyFileReader.propertymap.get("ACHSrch2");
		String ACHAccType = PropertyFileReader.propertymap.get("ACHAccType");
		String ACHAccStus = PropertyFileReader.propertymap.get("ACHAccStus");
		String ACHToMailId = PropertyFileReader.propertymap.get("ACHToMailId");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ACHBankNameDD));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText(ACHBankDD);
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(ACHType));
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("ACH Pending");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(ACHStatus));
		Select sel3 = new Select(ele3);
		sel3.selectByVisibleText(ACHAccStus);
		Thread.sleep(2000);
		// driver.findElement(By.xpath(ACHBnkSrch)).sendKeys(ACHSrch2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHNameEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ACHSndToSlsPerBtn)).click();
		driver.findElement(By.xpath(ACHEditUpdBtn)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath(ACHSndToCusToMailId));
		ele4.clear();
		ele4.sendKeys(ACHToMailId);
		driver.findElement(By.xpath(ACHSndToSlsSndBtn)).click();
	}
}
