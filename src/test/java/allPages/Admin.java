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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin extends Locators {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6;

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

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void BankSetupClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankSetupBtn)).click();
		Thread.sleep(3000);
		ele1 = driver
				.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div/div[1]/div[1]/span[2]/div/select"));
		Select sel = new Select(ele1);
		sel.selectByVisibleText("ALL");
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void AuthorizedNetClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(AuthorizedNetClick)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void IPWhitelist() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(IPWhitelistBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void UserLog() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UsrLog)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void EventLog() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(EventLogBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void ExceptionLog() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ExceptionLogBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void Help() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(HelpBtn)).click();
	}

	@Test(retryAnalyzer = ReRunFailedTestCase.class)
	public void Subscription() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(SubscriptionBtn)).click();
	}

	@Test(priority = 1, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException {
		BankSetupClick();
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SaveBtnBankSetup)).click();
		WebElement ele1 = driver.findElement(By.xpath(WarningMsg));
		Thread.sleep(2000);
		if (ele1.isDisplayed()) {
			System.out.println("Warning message is displayed");
		} else {
			System.out.println("Warning message is not displayed");
		}
	}

	@Test(priority = 2, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException, AWTException {
		BankSetupClick();
		String Bankname = PropertyFileReader.propertymap.get("Bankname");
		String Accnum = PropertyFileReader.propertymap.get("Accnum");
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankAddBtn)).click();
		ele1 = driver.findElement(By.id(BankName));
		ele1.sendKeys(Bankname);
		ele2 = driver.findElement(By.name(AccNum));
		ele2.sendKeys(Accnum);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id(ClrBtn)).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		if (ele1.isSelected()) {
			System.out.println("Text box is cleared");
		} else {
			System.out.println("Text box is not cleared");
		}
	}

	@Test(priority = 3, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException, AWTException {
		BankSetupClick();
		String Bankname = PropertyFileReader.propertymap.get("Bankname");
		String Accnum = PropertyFileReader.propertymap.get("Accnum");
		String location = PropertyFileReader.propertymap.get("location");
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankAddBtn)).click();
		ele1 = driver.findElement(By.id(BankName));
		ele1.sendKeys(Bankname);
		ele2 = driver.findElement(By.name(AccNum));
		ele2.sendKeys(Accnum);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		WebElement ele3 = driver.findElement(By.id(DropDown));
		Select sel = new Select(ele3);
		sel.selectByIndex(1);
		driver.findElement(By.name(Location)).sendKeys(location);
		driver.findElement(By.xpath(BnkStpStsDsbl)).click();
		driver.findElement(By.xpath(BnkStpStsDsblSveBtn)).click();
	}

	@Test(priority = 4, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException, AWTException {
		BankSetupClick();
		String Bankname = PropertyFileReader.propertymap.get("Bankname");
		String Accnum = PropertyFileReader.propertymap.get("Accnum");
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankAddBtn)).click();
		ele1 = driver.findElement(By.id(BankName));
		ele1.sendKeys(Bankname);
		ele2 = driver.findElement(By.name(AccNum));
		ele2.sendKeys(Accnum);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath(AddAccntBtn)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(SaveAccntBtn)).click();
		ele3 = driver
				.findElement(By.xpath("//*[@id=\"kt_body\"]/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/button"));
		if (!ele3.isDisplayed()) {
			System.out.println("Warning message is showing");
		} else {
			System.out.println("waring messange is not shown");
		}
	}

	@Test(priority = 5, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException, AWTException {
		BankSetupClick();
		String Bankname = PropertyFileReader.propertymap.get("Bankname");
		String Accnum = PropertyFileReader.propertymap.get("Accnum");
		String Accntgrpname = PropertyFileReader.propertymap.get("Accntgrpname");
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankAddBtn)).click();
		ele1 = driver.findElement(By.id(BankName));
		ele1.sendKeys(Bankname);
		ele2 = driver.findElement(By.name(AccNum));
		ele2.sendKeys(Accnum);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath(AddAccntBtn)).click();
		Thread.sleep(1000);
		driver.findElement(By.name(AccntGrpName)).sendKeys(Accntgrpname);
		driver.findElement(By.xpath(SaveAccntBtn)).click();
		Thread.sleep(2000);
		ele3 = driver.findElement(By.name(DropDown));
		Select select = new Select(ele3);
		select.selectByVisibleText(Accntgrpname);
	}

	@Test(priority = 6, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException, AWTException {
		TC05();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AccntGrpEditBtn)).click();
	}

	@Test(priority = 7, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException, Exception {
		BankSetupClick();
		String Bankname1 = PropertyFileReader.propertymap.get("Bankname1");
		String Accnum = PropertyFileReader.propertymap.get("Accnum");
		String location = PropertyFileReader.propertymap.get("location");
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankAddBtn)).click();
		ele1 = driver.findElement(By.id(BankName));
		ele1.sendKeys(Bankname1 + "A");
		ele2 = driver.findElement(By.name(AccNum));
		ele2.sendKeys(Accnum);
		Thread.sleep(1000);
		WebElement ele3 = driver.findElement(By.id(DropDown));
		Select sel = new Select(ele3);
		sel.selectByIndex(1);
		driver.findElement(By.name(Location)).sendKeys(location);
		Thread.sleep(2000);
		driver.findElement(By.xpath(StatusDisable)).click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement ele4 = driver.findElement(By.xpath(UpdateBtn));
		jsExecutor.executeScript("arguments[0].scrollIntoView();", ele4);
		driver.findElement(By.xpath(AuthorizeNo)).click();
		Thread.sleep(2000);
		ele4.click();
	}

	@Test(priority = 8, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException, Exception {
		BankSetupClick();
		String Bankname2 = PropertyFileReader.propertymap.get("Bankname2");
		String Accnum = PropertyFileReader.propertymap.get("Accnum");
		String location = PropertyFileReader.propertymap.get("location");
		String AuthorizeName = PropertyFileReader.propertymap.get("AuthorizeName");
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankAddBtn)).click();
		ele1 = driver.findElement(By.id(BankName));
		ele1.sendKeys(Bankname2 + "B");
		ele2 = driver.findElement(By.name(AccNum));
		ele2.sendKeys(Accnum);
		Thread.sleep(1000);
		ele3 = driver.findElement(By.id(DropDown));
		Select sel = new Select(ele3);
		sel.selectByIndex(1);
		driver.findElement(By.name(Location)).sendKeys(location);
		Thread.sleep(2000);
		driver.findElement(By.xpath(StatusDisable)).click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ele4 = driver.findElement(By.xpath(UpdateBtn));
		jsExecutor.executeScript("arguments[0].scrollIntoView();", ele4);
		driver.findElement(By.xpath(AuthorizeYes)).click();
		Thread.sleep(2000);
		ele5 = driver.findElement(By.id("dropdownValuenew"));
		Select selet = new Select(ele5);
		selet.selectByValue("6");
		Thread.sleep(2000);
		ele4.click();
	}

	@Test(priority = 9, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException, Exception {
		BankSetupClick();
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/button")).click();
	}

	@Test(priority = 10, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException, Exception {
		BankSetupClick();
		Thread.sleep(2000);
		driver.findElement(By.xpath(BankAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AccntGrpEditBtn)).click();
	}

	@Test(priority = 11, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException, Exception {
		BankSetupClick();
		Thread.sleep(2000);
		String Bankname = PropertyFileReader.propertymap.get("Bankname");
		String ModifiedBankName = PropertyFileReader.propertymap.get("ModifiedBankName");
		driver.findElement(By.id(SearchBox)).sendKeys(Bankname);
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditBttn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(ModifiedBankname));
		ele1.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(2000);
		ele1.sendKeys(Keys.BACK_SPACE);
		ele1.sendKeys(ModifiedBankName);
		driver.findElement(By.xpath(UpdateBtn)).click();
	}

	@Test(priority = 12, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC12() throws InterruptedException, Exception {
		BankSetupClick();
		Thread.sleep(2000);
		String Bankname = PropertyFileReader.propertymap.get("Bankname");
		String ModifiedBankName = PropertyFileReader.propertymap.get("ModifiedBankName");
		driver.findElement(By.id(SearchBox)).sendKeys(Bankname);
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditBttn)).click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name(ModifiedBankname));
		ele1.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(2000);
		ele1.sendKeys(Keys.BACK_SPACE);
		ele1.sendKeys(ModifiedBankName);
		driver.findElement(By.id("reset")).click();
		boolean emptyCheck = ele1.getAttribute("value").isEmpty();
		System.out.println("Text box is cleared :" + emptyCheck);
	}

	@Test(priority = 13, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException, Exception {
		BankSetupClick();
		String Bankname = PropertyFileReader.propertymap.get("Bankname");
		Thread.sleep(2000);
		driver.findElement(By.id(SearchBox)).sendKeys(Bankname);
		Thread.sleep(2000);
		driver.findElement(By.xpath(EditBttn)).click();
		Thread.sleep(2000);
		driver.findElement(By.className("ant-modal-close")).click();
	}

	@Test(priority = 14, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException, Exception {
		AuthorizedNetClick();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AuthorizeAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AuthorizeSaveBtn)).click();
		WebElement ele1 = driver.findElement(By.xpath(AuthorizeWarningMsg));
		Thread.sleep(2000);
		if (ele1.isDisplayed()) {
			System.out.println("Warning message is displayed");
			ele = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele.getText();
			System.out.println("Alert message displayed like : " + text);
			ele1.click();
		} else {
			System.out.println("Warning message is not displayed");
		}
	}

	@Test(priority = 15, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException, Exception {
		AuthorizedNetClick();
		String AuthoName = PropertyFileReader.propertymap.get("AuthoName");
		String AuthoTKey = PropertyFileReader.propertymap.get("AuthoTKey");
		String AuthoLoginId = PropertyFileReader.propertymap.get("AuthoLoginId");
		String AuthoNotes = PropertyFileReader.propertymap.get("AuthoNotes");
		Thread.sleep(2000);
		driver.findElement(By.xpath(AuthorizeAddBtn)).click();
		driver.findElement(By.name(AuthorizeName)).sendKeys(AuthoName);
		driver.findElement(By.name(AuthorizeTKey)).sendKeys(AuthoTKey);
		driver.findElement(By.name(AuthorizeLoginID)).sendKeys(AuthoLoginId);
		driver.findElement(By.name(AuthorizeNotes)).sendKeys(AuthoNotes);
		driver.findElement(By.name(AuthoStatusRun)).click();
		driver.findElement(By.xpath(AuthoSave)).click();
	}

	@Test(priority = 16, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException, Exception {
		AuthorizedNetClick();
		String AuthoName = PropertyFileReader.propertymap.get("AuthoName");
		String AuthoTKey = PropertyFileReader.propertymap.get("AuthoTKey");
		String AuthoLoginId = PropertyFileReader.propertymap.get("AuthoLoginId");
		String AuthoNotes = PropertyFileReader.propertymap.get("AuthoNotes");
		Thread.sleep(2000);
		driver.findElement(By.xpath(AuthorizeAddBtn)).click();
		driver.findElement(By.name(AuthorizeName)).sendKeys(AuthoName);
		driver.findElement(By.name(AuthorizeTKey)).sendKeys(AuthoTKey);
		driver.findElement(By.name(AuthorizeLoginID)).sendKeys(AuthoLoginId);
		driver.findElement(By.name(AuthorizeNotes)).sendKeys(AuthoNotes);
		Thread.sleep(3000);
		driver.findElement(By.name(AuthoStatusStop)).click();
		driver.findElement(By.xpath(AuthoSave)).click();
	}

	@Test(priority = 17, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC17() throws InterruptedException, Exception {
		AuthorizedNetClick();
		String AuthoName = PropertyFileReader.propertymap.get("AuthoName");
		String AuthoTKey = PropertyFileReader.propertymap.get("AuthoTKey");
		String AuthoLoginId = PropertyFileReader.propertymap.get("AuthoLoginId");
		String AuthoNotes = PropertyFileReader.propertymap.get("AuthoNotes");
		Thread.sleep(2000);
		driver.findElement(By.xpath(AuthorizeAddBtn)).click();
		driver.findElement(By.name(AuthorizeName)).sendKeys(AuthoName);
		driver.findElement(By.name(AuthorizeTKey)).sendKeys(AuthoTKey);
		driver.findElement(By.name(AuthorizeLoginID)).sendKeys(AuthoLoginId);
		driver.findElement(By.name(AuthorizeNotes)).sendKeys(AuthoNotes);
		driver.findElement(By.name(AuthoStatusStop)).click();
		driver.findElement(By.xpath(AuthoClr)).click();
	}

	@Test(priority = 18, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC18() throws InterruptedException, Exception {
		AuthorizedNetClick();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AuthorizeAddBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AuthoBackBtn)).click();
	}

	@Test(priority = 19, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException, Exception {
		AuthorizedNetClick();
		String AuthoName = PropertyFileReader.propertymap.get("AuthoName");
		Thread.sleep(2000);
		driver.findElement(By.id(AuthoSearchBtn)).sendKeys(AuthoName);
		driver.findElement(By.xpath(AuthoEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AutExistBackBtn)).click();
	}

	@Test(priority = 20, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC20() throws InterruptedException, Exception {
		AuthorizedNetClick();
		String AuthoName = PropertyFileReader.propertymap.get("AuthoName");
		Thread.sleep(2000);
		driver.findElement(By.id(AuthoSearchBtn)).sendKeys(AuthoName);
		driver.findElement(By.xpath(AuthoEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AutExistClrBtn)).click();
	}

	@Test(priority = 21, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException, Exception {
		AuthorizedNetClick();
		String AuthoName = PropertyFileReader.propertymap.get("AuthoName");
		String AuthoExistName = PropertyFileReader.propertymap.get("AuthoExistName");
		String AuthoExistNotes = PropertyFileReader.propertymap.get("AuthoExistNotes");
		Thread.sleep(2000);
		driver.findElement(By.id(AuthoSearchBtn)).sendKeys(AuthoName);
		driver.findElement(By.xpath(AuthoEditBtn)).click();
		driver.findElement(By.name(AuthorizeExistName)).sendKeys(AuthoExistName);
		driver.findElement(By.name(AuthorizeExistNotes)).sendKeys(AuthoExistNotes);
		driver.findElement(By.name(AuthoExistRun)).click();
		driver.findElement(By.xpath(AutExistUpdBtn)).click();
	}

	@Test(priority = 22, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException, Exception {
		IPWhitelist();
		Thread.sleep(2000);
		String IpAllDropDown = PropertyFileReader.propertymap.get("IpAllDropDown");
		String IpAddress = PropertyFileReader.propertymap.get("IpAddress");
		ele1 = driver.findElement(By.name("status"));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(IpAllDropDown);
		Thread.sleep(2000);
		driver.findElement(By.id(IpSearchBtn)).sendKeys(IpAddress);

	}

	@Test(priority = 23, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC23() throws InterruptedException, Exception {
		IPWhitelist();
		Thread.sleep(2000);
		String IpAddres = PropertyFileReader.propertymap.get("IpAddres");
		String IpResPerName = PropertyFileReader.propertymap.get("IpResPerName");
		String IpLoc = PropertyFileReader.propertymap.get("IpLoc");
		String IpNote = PropertyFileReader.propertymap.get("IpNote");
		driver.findElement(By.xpath(IpAddBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(IpAddress)).sendKeys(IpAddres);
		driver.findElement(By.name(IpResPerson)).sendKeys(IpResPerName);
		driver.findElement(By.name(IpLocation)).sendKeys(IpLoc);
		driver.findElement(By.name(IpNotes)).sendKeys(IpNote);
		driver.findElement(By.name(IpNotes)).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.name(IpStatusEnbl)).click();
		driver.findElement(By.xpath(IpAdressSave)).click();
	}

	@Test(priority = 24, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC24() throws InterruptedException, Exception {
		IPWhitelist();
		Thread.sleep(2000);
		String IpAddres = PropertyFileReader.propertymap.get("IpAddres");
		String IpResPerName = PropertyFileReader.propertymap.get("IpResPerName");
		String IpLoc = PropertyFileReader.propertymap.get("IpLoc");
		String IpNote = PropertyFileReader.propertymap.get("IpNote");
		driver.findElement(By.xpath(IpAddBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(IpAddress)).sendKeys(IpAddres);
		driver.findElement(By.name(IpResPerson)).sendKeys(IpResPerName);
		driver.findElement(By.name(IpLocation)).sendKeys(IpLoc);
		driver.findElement(By.name(IpNotes)).sendKeys(IpNote);
		driver.findElement(By.name(IpNotes)).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.name(IpStatusDSbl)).click();
		driver.findElement(By.xpath(IpAdressSave)).click();
	}

	@Test(priority = 25, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException, Exception {
		IPWhitelist();
		Thread.sleep(2000);
		driver.findElement(By.xpath(IpAddBtn)).click();
		driver.findElement(By.xpath(IpCloseBtn)).click();
	}

	@Test(priority = 26, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC26() throws InterruptedException, Exception {
		IPWhitelist();
		Thread.sleep(2000);
		String IpAddres = PropertyFileReader.propertymap.get("IpAddres");
		String IpResPerName = PropertyFileReader.propertymap.get("IpResPerName");
		String IpLoc = PropertyFileReader.propertymap.get("IpLoc");
		String IpNote = PropertyFileReader.propertymap.get("IpNote");
		driver.findElement(By.xpath(IpAddBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(IpAddress)).sendKeys(IpAddres);
		driver.findElement(By.name(IpResPerson)).sendKeys(IpResPerName);
		driver.findElement(By.name(IpLocation)).sendKeys(IpLoc);
		driver.findElement(By.name(IpNotes)).sendKeys(IpNote);
		driver.findElement(By.name(IpNotes)).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.name(IpStatusDSbl)).click();
		driver.findElement(By.id(IpAdressClr)).click();
	}

	@Test(priority = 27, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC27() throws InterruptedException, Exception {
		UserLog();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UsrLogSrch)).sendKeys("Thirumaran R");
	}

	@Test(priority = 28, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC28() throws InterruptedException, Exception {
		UserLog();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UsrLogView)).click();
	}

	@Test(priority = 29, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC29() throws InterruptedException, Exception {
		TC28();
		driver.findElement(By.xpath("//*[@id=\"kt_table_users\"]/tbody/tr[1]/td[8]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[3]/div/div[2]/div/div[2]/div/button")).click();
		driver.findElement(By.xpath(UsrLogBackBtn)).click();
	}

	@Test(priority = 30, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC30() throws InterruptedException, Exception {
		EventLog();
		ele1 = driver.findElement(By.xpath(EventLogSearchBtn));
		ele1.click();
		boolean enabled = ele1.isEnabled();
		System.out.println("Search box is clickable:" + enabled);
	}

	@Test(priority = 31, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC31() throws InterruptedException, Exception {
		EventLog();
		driver.findElement(By.xpath(EventLogViewBtn)).click();
	}

	@Test(priority = 32, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC32() throws InterruptedException, Exception {
		TC31();
		driver.findElement(By.xpath(EventLogCloseBtn)).click();

	}

	@Test(priority = 33, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC33() throws InterruptedException, Exception {
		ExceptionLog();
		ele1 = driver.findElement(By.xpath(ExceSearchBtn));
		ele1.click();
		boolean enabled = ele1.isEnabled();
		System.out.println("Search box is clickable:" + enabled);
	}

	@Test(priority = 34, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC34() throws InterruptedException, Exception {
		Subscription();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		// Disable click
		wait.until(ExpectedConditions.elementToBeClickable(By.name("no")));
		driver.findElement(By.name("no")).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div/div[3]/div[2]/div[2]/textarea")));
		ele = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[2]/div[2]/textarea"));
		String text = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[2]/div[2]/textarea"));
		ele1.sendKeys(text);
		// Click save button
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[3]/div")));
		ele2 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[3]/div"));
		ele2.click();

	}

	@Test(priority = 34, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC35() throws InterruptedException, Exception {
		Subscription();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		// Enable click
		wait.until(ExpectedConditions.elementToBeClickable(By.name("yes")));
		driver.findElement(By.name("yes")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[2]/div[2]/textarea")));
		ele = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[2]/div[2]/textarea"));
		String text = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[2]/div[2]/textarea"));
		ele1.sendKeys(text);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[3]/div[2]/textarea")));
		ele4 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[3]/div[2]/textarea"));
		String text1 = ele4.getAttribute("value");
		ele.clear();
		ele3 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[3]/div[2]/textarea"));
		ele3.sendKeys(text1);

		// Click save button
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[3]/div")));
		ele2 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[3]/div[3]/div"));
		ele2.click();
	}

	@Test(priority = 36, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC36() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click add button in left side
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddBtn)));
		driver.findElement(By.xpath(HelpAddBtn)).click();

		// Click back button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddBackBtn)));
		driver.findElement(By.xpath(HelpAddBackBtn)).click();
	}

	@Test(priority = 37, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC37() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click add button in left side
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddBtn)));
		driver.findElement(By.xpath(HelpAddBtn)).click();

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div/button")));
		ele = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div[2]"));
		if (ele.isDisplayed()) {
			System.out.println("Alert message is displayed");
			String text = ele.getText();
			System.out.println("Alert message is displayed: " + text);
		} else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(priority = 38, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC38() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click add button in left side
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddBtn)));
		driver.findElement(By.xpath(HelpAddBtn)).click();

		// Click add button in group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddBtn)));
		driver.findElement(By.xpath(HelpAddGrpAddBtn)).click();

		// Click close button in group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddClsBtn)));
		driver.findElement(By.xpath(HelpAddGrpAddClsBtn)).click();
	}

	@Test(priority = 39, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC39() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click add button in left side
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddBtn)));
		driver.findElement(By.xpath(HelpAddBtn)).click();

		// Click add button in group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddBtn)));
		driver.findElement(By.xpath(HelpAddGrpAddBtn)).click();

		// Click save button in group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddGrpAddSaveBtn)).click();

		// Check alert message
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[1]/div/div[2]/button")));
		ele = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[1]/div/div[2]/button"));
		if (ele.isDisplayed()) {
			ele1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[1]/div/div[1]"));
			String text = ele1.getText();
			System.out.println("Alert message is displayed like: " + text);
		} else {
			System.out.println("No alert message is displayed");
		}
	}

	@Test(priority = 40, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC40() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click add button in left side
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddBtn)));
		driver.findElement(By.xpath(HelpAddBtn)).click();

		// Click add button in group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddBtn)));
		driver.findElement(By.xpath(HelpAddGrpAddBtn)).click();

		// Enter group name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddGrpTab)));
		driver.findElement(By.xpath(HelpAddGrpAddGrpTab)).sendKeys("Test");

		// Click clear button in group
		wait.until(ExpectedConditions.elementToBeClickable(By.id(HelpAddGrpAddClrBtn)));
		driver.findElement(By.id(HelpAddGrpAddClrBtn)).click();

		// Check data is cleared or not
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddGrpTab)));
		ele = driver.findElement(By.xpath(HelpAddGrpAddGrpTab));
		String tabData = ele.getAttribute("value");
		if (tabData.isEmpty()) {
			System.out.println("Clear button is working and Data is cleared");
		} else {
			System.out.println("Text button is not working");
		}
	}

	@Test(priority = 41, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC41() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click add button in left side
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddBtn)));
		driver.findElement(By.xpath(HelpAddBtn)).click();

		// Click add button in group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddBtn)));
		driver.findElement(By.xpath(HelpAddGrpAddBtn)).click();

		// Enter group name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddGrpTab)));
		driver.findElement(By.xpath(HelpAddGrpAddGrpTab)).sendKeys("Test");

		// Click save button in group
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddGrpAddSaveBtn)).click();
	}

	@Test(priority = 42, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC42() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click add button in left side
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddBtn)));
		driver.findElement(By.xpath(HelpAddBtn)).click();

		// Select valid group name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpBtn)));
		ele = driver.findElement(By.xpath(HelpAddGrpBtn));
		Select sel = new Select(ele);
		sel.selectByVisibleText("Test");

		// Enter valid title
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		driver.findElement(By.xpath(HelpAddTitleBtn)).sendKeys("Test");

		// Select inactive status
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddStatusInActBtn)));
		driver.findElement(By.xpath(HelpAddStatusInActBtn)).click();

		// Upload valid attachments
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddAttachmentBtn)));
		driver.findElement(By.xpath(HelpAddAttachmentBtn)).click();
		// Upload the file
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

		// Enter valid questions
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddQuestionBtn)));
		driver.findElement(By.xpath(HelpAddQuestionBtn)).sendKeys("Test Question");

		// Enter valid answer
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddAnswerBtn)));
		driver.findElement(By.xpath(HelpAddAnswerBtn)).sendKeys("Test Answer");

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 43, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC43() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click add button in left side
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddBtn)));
		driver.findElement(By.xpath(HelpAddBtn)).click();

		// Select valid group name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddGrpBtn)));
		ele = driver.findElement(By.xpath(HelpAddGrpBtn));
		Select sel = new Select(ele);
		sel.selectByVisibleText("Test");

		// Enter valid title
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		driver.findElement(By.xpath(HelpAddTitleBtn)).sendKeys("Test");

		// Select Active status
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddStatusActBtn)));
		driver.findElement(By.xpath(HelpAddStatusActBtn)).click();

		// Upload valid attachments
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddAttachmentBtn)));
		driver.findElement(By.xpath(HelpAddAttachmentBtn)).click();
		// Upload the file
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

		// Enter valid questions
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddQuestionBtn)));
		driver.findElement(By.xpath(HelpAddQuestionBtn)).sendKeys("Test Question");

		// Enter valid answer
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddAnswerBtn)));
		driver.findElement(By.xpath(HelpAddAnswerBtn)).sendKeys("Test Answer");

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 44, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC44() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click active button in user login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveBtn1)));
		driver.findElement(By.xpath(HelpActiveBtn1)).click();

		// Click edit button in Create User
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveEditBtn)));
		driver.findElement(By.xpath(HelpActiveEditBtn)).click();

		// Modify valid details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		ele = driver.findElement(By.xpath(HelpAddTitleBtn));
		String TitleValue = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath(HelpAddTitleBtn));
		ele1.sendKeys(TitleValue);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 45, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC45() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click active button in Un-Lock User Login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveBtn2)));
		driver.findElement(By.xpath(HelpActiveBtn2)).click();

		// Click edit button in user login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveEditBtn)));
		driver.findElement(By.xpath(HelpActiveEditBtn)).click();

		// Modify valid details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		ele = driver.findElement(By.xpath(HelpAddTitleBtn));
		String TitleValue = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath(HelpAddTitleBtn));
		ele1.sendKeys(TitleValue);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 46, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC46() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click active button in Un-Lock User Login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveBtn3)));
		driver.findElement(By.xpath(HelpActiveBtn3)).click();

		// Click edit button in user login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveEditBtn)));
		driver.findElement(By.xpath(HelpActiveEditBtn)).click();

		// Modify valid details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		ele = driver.findElement(By.xpath(HelpAddTitleBtn));
		String TitleValue = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath(HelpAddTitleBtn));
		ele1.sendKeys(TitleValue);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 47, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC47() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click active button in Un-Lock User Login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveBtn4)));
		driver.findElement(By.xpath(HelpActiveBtn4)).click();

		// Click edit button in user login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveEditBtn)));
		driver.findElement(By.xpath(HelpActiveEditBtn)).click();

		// Modify valid details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		ele = driver.findElement(By.xpath(HelpAddTitleBtn));
		String TitleValue = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath(HelpAddTitleBtn));
		ele1.sendKeys(TitleValue);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 48, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC48() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click active button in Un-Lock User Login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveBtn5)));
		driver.findElement(By.xpath(HelpActiveBtn5)).click();

		// Click edit button in user login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveEditBtn)));
		driver.findElement(By.xpath(HelpActiveEditBtn)).click();

		// Modify valid details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		ele = driver.findElement(By.xpath(HelpAddTitleBtn));
		String TitleValue = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath(HelpAddTitleBtn));
		ele1.sendKeys(TitleValue);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 49, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC49() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click active button in Un-Lock User Login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveBtn6)));
		driver.findElement(By.xpath(HelpActiveBtn6)).click();

		// Click edit button in user login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveEditBtn)));
		driver.findElement(By.xpath(HelpActiveEditBtn)).click();

		// Modify valid details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		ele = driver.findElement(By.xpath(HelpAddTitleBtn));
		String TitleValue = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath(HelpAddTitleBtn));
		ele1.sendKeys(TitleValue);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 50, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC50() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click active button in Un-Lock User Login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveBtn7)));
		driver.findElement(By.xpath(HelpActiveBtn7)).click();

		// Click edit button in user login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveEditBtn)));
		driver.findElement(By.xpath(HelpActiveEditBtn)).click();

		// Modify valid details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		ele = driver.findElement(By.xpath(HelpAddTitleBtn));
		String TitleValue = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath(HelpAddTitleBtn));
		ele1.sendKeys(TitleValue);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 51, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC51() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click active button in Un-Lock User Login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveBtn8)));
		driver.findElement(By.xpath(HelpActiveBtn8)).click();

		// Click edit button in user login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveEditBtn)));
		driver.findElement(By.xpath(HelpActiveEditBtn)).click();

		// Modify valid details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		ele = driver.findElement(By.xpath(HelpAddTitleBtn));
		String TitleValue = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath(HelpAddTitleBtn));
		ele1.sendKeys(TitleValue);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

	@Test(priority = 52, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC52() throws InterruptedException, Exception {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"kt_content_container\"]/div[1]/div/div/div[5]/span")));
		driver.findElement(By.xpath(AdminBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpBtn)));
		driver.findElement(By.xpath(HelpBtn)).click();

		Set<String> newWindow = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(newWindow);

		driver.switchTo().window(list.get(1));

		// Click active button in Un-Lock User Login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveBtn9)));
		driver.findElement(By.xpath(HelpActiveBtn9)).click();

		// Click edit button in user login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpActiveEditBtn)));
		driver.findElement(By.xpath(HelpActiveEditBtn)).click();

		// Modify valid details
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddTitleBtn)));
		ele = driver.findElement(By.xpath(HelpAddTitleBtn));
		String TitleValue = ele.getAttribute("value");
		ele.clear();
		ele1 = driver.findElement(By.xpath(HelpAddTitleBtn));
		ele1.sendKeys(TitleValue);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HelpAddSaveBtn)));
		driver.findElement(By.xpath(HelpAddSaveBtn)).click();
	}

}
