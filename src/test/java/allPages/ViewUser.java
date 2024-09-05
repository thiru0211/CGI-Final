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
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import allPages.Locators;
import allPages.PropertyFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewUser extends Locators {
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
		String browserVersion = option.getBrowserVersion();
		System.out.println(browserVersion);
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
	public void ViewUsersClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId = PropertyFileReader.propertymap.get("EmailId");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AdminBtn)));
		ele1 = driver.findElement(By.xpath(AdminBtn));
		ele1.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserBtn)).click();
	}

	@Test(priority = 2, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException {
		ViewUsersClick();
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		String ViewUserSts1 = PropertyFileReader.propertymap.get("ViewUserSts1");
		String ViewUserSts2 = PropertyFileReader.propertymap.get("ViewUserSts2");
		String ViewUserSts3 = PropertyFileReader.propertymap.get("ViewUserSts3");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ViewUserStsDD)));
		ele1 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(ViewUserSts);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ViewUserStsDD)));
		sel.selectByVisibleText(ViewUserSts1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ViewUserStsDD)));
		sel.selectByVisibleText(ViewUserSts2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ViewUserStsDD)));
		sel.selectByVisibleText(ViewUserSts3);
	}

	@Test(priority = 3, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException {
		ViewUsersClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AddBtn)));
		driver.findElement(By.xpath(AddBtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TktViewBtnActBtn)));
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SaveBtn)));
		driver.findElement(By.xpath(SaveBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MandatoryPopUp)));
		ele1 = driver.findElement(By.xpath(MandatoryPopUp));
		if (ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			ele2 = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div"));
			String text = ele2.getText();
			System.out.println("Alert message displayed like: " + text);
			ele1.click();
		} else {
			System.out.println("Mandatory message is not shown");
		}
	}

	@Test(priority = 4, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException {
		ViewUsersClick();
		String Firstname = PropertyFileReader.propertymap.get("Firstname");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AddBtn)));
		driver.findElement(By.xpath(AddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(FirstName)));
		ele1 = driver.findElement(By.name(FirstName));
		ele1.sendKeys(Firstname);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TktViewBtnActBtn)));
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(ClearBtn)).click();

		if (ele1.getAttribute("value").isEmpty()) {
			System.out.println("Text field is cleared");
		} else {
			System.out.println("Text field is not cleared");
		}
	}

	@Test(priority = 5, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException {
		ViewUsersClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AddBtn)));
		driver.findElement(By.xpath(AddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TktViewBtnActBtn)));
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserBckBtn)).click();
	}

	@Test(priority = 6, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String Firstname = PropertyFileReader.propertymap.get("Firstname");
		String Lastname = PropertyFileReader.propertymap.get("Lastname");
		String ExtraMail = PropertyFileReader.propertymap.get("ExtraMail");
		String Userrole = PropertyFileReader.propertymap.get("Userrole");
		String VisibleTextPST = PropertyFileReader.propertymap.get("VisibleTextPST");
		String ManLoc = PropertyFileReader.propertymap.get("ManLoc");
		String PhoneNo = PropertyFileReader.propertymap.get("PhoneNo");
		String address1 = PropertyFileReader.propertymap.get("address1");
		String address2 = PropertyFileReader.propertymap.get("address2");
		String city = PropertyFileReader.propertymap.get("city");
		String zipCode = PropertyFileReader.propertymap.get("zipCode");
		ViewUsersClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AddBtn)));
		driver.findElement(By.xpath(AddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(FirstName)));
		driver.findElement(By.name(FirstName)).sendKeys(Firstname);
		driver.findElement(By.name(LastName)).sendKeys(Lastname);
		driver.findElement(By.name(EmailField)).sendKeys(ExtraMail);
		driver.findElement(By.name(UserRole)).sendKeys(Userrole);
		ele1 = driver.findElement(By.name("status"));
		Select select = new Select(ele1);
		select.selectByVisibleText(VisibleTextPST);

		ele2 = driver.findElement(By.name(ManLoc));
		if (!ele2.isSelected()) {
			ele2.click();
		} else {
			System.out.println("Checkbox is already selected");
		}

		Thread.sleep(2000);
		ele3 = driver.findElement(By.tagName("body"));
		ele3.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		ele3 = driver.findElement(By.tagName("body"));
		ele3.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.name(PhoneNum)).sendKeys(PhoneNo);
		driver.findElement(By.name(Address1)).sendKeys(address1);
		driver.findElement(By.name(Address2)).sendKeys(address2);
		driver.findElement(By.name(City)).sendKeys(city);
		driver.findElement(By.name(ZipCode)).sendKeys(zipCode);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TktViewBtnActBtn)));
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SaveBtn)));
		driver.findElement(By.xpath(SaveBtn)).click();
	}

	@Test(priority = 7, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String Firstname = PropertyFileReader.propertymap.get("Firstname");
		String Lastname = PropertyFileReader.propertymap.get("Lastname");
		String ExtraMail = PropertyFileReader.propertymap.get("ExtraMail");
		String Userrole = PropertyFileReader.propertymap.get("Userrole");
		String VisibleTextIU = PropertyFileReader.propertymap.get("VisibleTextIU");
		String ManLoc = PropertyFileReader.propertymap.get("ManLoc");
		String PhoneNo = PropertyFileReader.propertymap.get("PhoneNo");
		String address1 = PropertyFileReader.propertymap.get("address1");
		String address2 = PropertyFileReader.propertymap.get("address2");
		String city = PropertyFileReader.propertymap.get("city");
		String zipCode = PropertyFileReader.propertymap.get("zipCode");
		ViewUsersClick();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AddBtn)));
		driver.findElement(By.xpath(AddBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name(FirstName)));
		driver.findElement(By.name(FirstName)).sendKeys(Firstname);
		driver.findElement(By.name(LastName)).sendKeys(Lastname);
		driver.findElement(By.name(EmailField)).sendKeys(ExtraMail);
		driver.findElement(By.name(UserRole)).sendKeys(Userrole);
		ele1 = driver.findElement(By.name("status"));
		Select select = new Select(ele1);
		select.selectByVisibleText(VisibleTextIU);

		ele2 = driver.findElement(By.name(ManLoc));
		if (!ele2.isSelected()) {
			ele2.click();
		} else {
			System.out.println("Checkbox is already selected");
		}

		Thread.sleep(2000);
		ele3 = driver.findElement(By.tagName("body"));
		ele3.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		ele3 = driver.findElement(By.tagName("body"));
		ele3.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.name(PhoneNum)).sendKeys(PhoneNo);
		driver.findElement(By.name(Address1)).sendKeys(address1);
		driver.findElement(By.name(Address2)).sendKeys(address2);
		driver.findElement(By.name(City)).sendKeys(city);
		driver.findElement(By.name(ZipCode)).sendKeys(zipCode);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TktViewBtnActBtn)));
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SaveBtn)));
		driver.findElement(By.xpath(SaveBtn)).click();
		select.selectByVisibleText(VisibleTextIU);
	}

	@Test(priority = 7, retryAnalyzer = ReRunFailedTestCase.class, description = "change the ele1 mail id")
	public void TC07() throws InterruptedException {
		ViewUsersClick();
		String VUNewMailID = PropertyFileReader.propertymap.get("VUNewMailID");
		String VUNewMailID1 = PropertyFileReader.propertymap.get("VUNewMailID1");
		String VerificationCode = PropertyFileReader.propertymap.get("VerificationCode");
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele2.click();
		ele2.sendKeys(VUNewMailID);
//		ele1=driver.findElement(By.xpath(ViewUserStsDD));
//		Select sel=new Select(ele1);
//		sel.selectByVisibleText("ALL");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUEmailEditBtn)).click();
		ele3 = driver.findElement(By.xpath(VUNewEmailID));
		ele3.clear();
		Thread.sleep(2000);
		ele3 = driver.findElement(By.xpath(VUNewEmailID));
		ele3.sendKeys(VUNewMailID1);
		driver.findElement(By.xpath(VUNewEmailVerCode)).click();
		driver.findElement(By.xpath(VUNewEmailEtrOTP)).sendKeys(VerificationCode);
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUNewEmailUpdBtn)).click();
	}

	// Change mail id

	@Test(priority = 8, retryAnalyzer = ReRunFailedTestCase.class, description = "change the ele1 mail id")
	public void TC08() throws InterruptedException {
		ViewUsersClick();
		String VUNewMailID = PropertyFileReader.propertymap.get("VUNewMailID");
		String VUNewMailID2 = PropertyFileReader.propertymap.get("VUNewMailID2");
		String VerificationCode = PropertyFileReader.propertymap.get("VerificationCode");
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele2.click();
		ele2.sendKeys(VUNewMailID);
//		ele1=driver.findElement(By.xpath(ViewUserStsDD));
//		Select sel=new Select(ele1);
//		sel.selectByVisibleText("ALL");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUEmailEditBtn)).click();
		ele3 = driver.findElement(By.xpath(VUNewEmailID));
		ele3.clear();
		Thread.sleep(2000);
		ele3 = driver.findElement(By.xpath(VUNewEmailID));
		ele3.sendKeys(VUNewMailID2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUNewEmailVerCode)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUNewEmailEtrOTP)).sendKeys(VerificationCode);
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUNewEmailUpdBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div[3]/div[3]/img"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[1]/input"))
				.sendKeys("Thirumaran@55");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[2]/input"))
				.sendKeys("Thirumaran@55");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[3]/button"))
				.click();
	}

	@Test(priority = 9, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String VUNewMailID2 = PropertyFileReader.propertymap.get("VUNewMailID2");
		String VUNewPass = PropertyFileReader.propertymap.get("VUNewPass");
		driver.findElement(By.name(Email)).sendKeys(VUNewMailID2);
		driver.findElement(By.name(Password)).sendKeys(VUNewPass);
		driver.findElement(By.id(LoginBtn)).click();
	}

	@Test(priority = 10, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException {
		ViewUsersClick();
		String VUNewMailID = PropertyFileReader.propertymap.get("VUNewMailID");
		Thread.sleep(2000);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(VUNewMailID);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		driver.findElement(By.xpath(VUEmailEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUNewEmailClsBtn)).click();
	}

	@Test(priority = 11, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		String Passwrd = PropertyFileReader.propertymap.get("Passwrd");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(ViewUserEmailSrch);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		driver.findElement(By.xpath(VUPassEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUNewPassBtn)).sendKeys(Passwrd);
		driver.findElement(By.xpath(VUCnfrmPassBtn)).sendKeys(Passwrd);
		driver.findElement(By.xpath(VUNewPassUpdBtn)).click();
	}

	@Test(priority = 12, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC12() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String VUNewMailID2 = PropertyFileReader.propertymap.get("VUNewMailID2");
		String VUNewPass = PropertyFileReader.propertymap.get("VUNewPass");
		driver.findElement(By.name(Email)).sendKeys(VUNewMailID2);
		driver.findElement(By.name(Password)).sendKeys(VUNewPass);
		driver.findElement(By.id(LoginBtn)).click();
	}

	@Test(priority = 13, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		String VUOldpass = PropertyFileReader.propertymap.get("VUOldpass");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(ViewUserEmailSrch);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		driver.findElement(By.xpath(VUPassEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUNewPassBtn)).sendKeys(VUOldpass);
		driver.findElement(By.xpath(VUCnfrmPassBtn)).sendKeys(VUOldpass);
		driver.findElement(By.xpath(VUNewPassUpdBtn)).click();
	}

	@Test(priority = 14, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys("Thirumaran");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div/div[4]/div[2]"));
		String status = "Enabled";
		String text = ele1.getText();
		System.out.println(text);
		if (!(text == status)) {
			driver.findElement(By.xpath(VUStusEditBtn)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(VUStusEditRdoYes)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(VUStusUpdBtn)).click();
		} else {
			System.out.println("Status already in diabled state");
		}
	}

	@Test(priority = 15, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String VUDisMail1 = PropertyFileReader.propertymap.get("VUNewMailID1");
		String VUNewPass = PropertyFileReader.propertymap.get("VUNewPass");
		driver.findElement(By.name(Email)).sendKeys(VUDisMail1);
		driver.findElement(By.name(Password)).sendKeys(VUNewPass);
		driver.findElement(By.id(LoginBtn)).click();
		// getting error message
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("//*[@id=\"kt_login_signin_form\"]/div[3]/div/span"));
		String text = ele1.getText();
		System.out.println(text);
	}

	@Test(priority = 16, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC16() throws InterruptedException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(ViewUserEmailSrch);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		driver.findElement(By.xpath(VUPassEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUNewPassClsBtn)).click();
	}

	@Test(priority = 17, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC17() throws InterruptedException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(ViewUserEmailSrch);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		driver.findElement(By.xpath(VUEmailEditBtn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(VUNewEmailClsBtn)).click();
	}

	@Test(priority = 18, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC18() throws InterruptedException {
		ViewUsersClick();
		String VUDisMail1 = PropertyFileReader.propertymap.get("VUNewMailID1");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(VUDisMail1);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div/div[4]/div[2]"));
		String status = "Disabled";
		String text = ele1.getText();
		System.out.println(text);
		if (!(text == status)) {
			driver.findElement(By.xpath(VUStusEditBtn)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(VUStusEditRdoYes)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(VUStusUpdBtn)).click();
		} else {
			System.out.println("Status already in Enabled state");
		}
		Thread.sleep(3000);
		ele1.click();
	}

	@Test(priority = 19, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC19() throws InterruptedException {
		TC18();
		Thread.sleep(3000);
		String VUNewPass = PropertyFileReader.propertymap.get("VUNewPass");
		String VUNewMailID = PropertyFileReader.propertymap.get("VUNewMailID");
		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div[2]/div/div[2]/div[2]"));
		String text1 = ele1.getText();
		System.out.println(text1);
		driver.findElement(By.xpath("//a[@class='btn btn-icon btn-md btn-active-color-primary mt-n2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='menu-link px-5 bg-danger']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name(Email)).sendKeys(VUNewMailID);
		driver.findElement(By.name(Password)).sendKeys(VUNewPass);
		Thread.sleep(2000);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//*[@id=\"kt_login_signin_form\"]/div[3]/div/span"));
		if (ele2.isDisplayed()) {
			String text = ele2.getText();
			System.out.println("Alert message is shows like :" + text);
		} else {
			System.out.println("No alert messsage is shown after click login button");
		}
	}

	@Test(priority = 20, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC20() throws InterruptedException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(ViewUserEmailSrch);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		driver.findElement(By.xpath(VUStusEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUStsClsBtn)).click();
	}

	@Test(priority = 21, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC21() throws InterruptedException {
		ViewUsersClick();
		Thread.sleep(2000);
		String VUNewMailID1 = PropertyFileReader.propertymap.get("VUNewMailID1");
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
//		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div/input"))
//				.sendKeys(VUNewMailID1);
//		Thread.sleep(3000);
		driver.findElement(By.xpath(EditButtonSymbol)).click();
		Thread.sleep(2000);
		// edit button click
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[3]/div/div[3]/div[3]/img"))
				.click();
		Thread.sleep(2000);
		// No button click
		driver.findElement(
				By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[1]/div/div/span/input"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/div[4]/button")).click();
	}

	@Test(priority = 22, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC22() throws InterruptedException {
		ViewUsersClick();
		String VUNewMailID = PropertyFileReader.propertymap.get("VUNewMailID");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(VUNewMailID);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		driver.findElement(By.xpath(VU2FAEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VU2FAClsBtn)).click();
	}

	@Test(priority = 23, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC23() throws InterruptedException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		Thread.sleep(2000);
//		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
//		ele1.click();
//		ele1.sendKeys(ViewUserEmailSrch);
//		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUAccRgtsBtn)).click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.name(VUAccRgtsRepCB));
		if (!ele2.isSelected()) {
			ele2.click();
		} else {
			System.out.println("Checkbox is already selected");
		}
		Thread.sleep(4000);
		WebElement element = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/div[3]/div/div/div/button"));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUAccRgtsActSubBtn1)).click();
	}

	@Test(priority = 24, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC24() throws InterruptedException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(ViewUserEmailSrch);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUTimeShtAccBtn)).click();
		driver.findElement(By.name(VUTimeShtAccEnblBtn)).click();
		Thread.sleep(2000);
		// Reporting to
		ele3 = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/select"));
		Select sel1 = new Select(ele3);
		sel1.selectByVisibleText("Thirumaran R");
		WebElement element = driver.findElement(By.xpath(VUAccRgtsAct1));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUAccRgtsActSubBtn1)).click();
		Thread.sleep(2000);
		ele4 = driver.findElement(By.xpath("//div[text()='Updated Successfully']"));
		if (ele4.isDisplayed()) {
			System.out.println("Updated sucessfully");
		} else {
			System.out.println("Submit button is not working");
		}
	}

	@Test(priority = 25, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC25() throws InterruptedException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		Thread.sleep(2000);
//		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
//		ele1.click();
//		ele1.sendKeys(ViewUserEmailSrch);
//		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUTimeShtAccBtn)).click();
		driver.findElement(By.name(VUTimeShtAccDsblBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(VUAccRgtsAct1));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUAccRgtsActSubBtn1)).click();
	}

	@Test(priority = 26, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC26() throws InterruptedException, AWTException {
		ViewUsersClick();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div/input")).sendKeys("test@yopmail.com");
		driver.findElement(By.xpath(EditButtonSymbol)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_lblImage\"]/span")).click();
		Thread.sleep(2000);
		WebElement ele1 = driver
				.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]"));
		ele1.click();
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
		driver.findElement(By.xpath("//button[@title='Click here to upload/change image']")).click();
	}

	@Test(priority = 27, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC27() throws InterruptedException, AWTException, IOException {
		ViewUsersClick();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[1]/div/input")).sendKeys("test@yopmail.com");
		driver.findElement(By.xpath(EditButtonSymbol)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_lblImage\"]/span")).click();
		Thread.sleep(2000);
		WebElement ele1 = driver
				.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]"));
		ele1.click();
		Thread.sleep(2000);
		String InvalidFilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\Files\\blank.pdf";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(InvalidFilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(
				"C:\\Users\\thirumaran\\eclipse-workspace\\PowerFundOneeFinal\\ScreenShot\\InvalidUploadImg.png"));
	}

	@Test(priority = 28, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC28() throws InterruptedException, AWTException {
		ViewUsersClick();
		String ViewUserEmailSrch = PropertyFileReader.propertymap.get("ViewUserEmailSrch");
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(ViewUserEmailSrch);
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(VUAccRgtsAct1));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(VUAccRgtsActBckBtn1)).click();
	}

	@Test(priority = 29, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC29() throws InterruptedException, AWTException {
		ViewUsersClick();
		String VUNewMailID = PropertyFileReader.propertymap.get("VUNewMailID");
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(VUNewMailID);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUInstMap)).click();
		driver.findElement(By.name(VUInstMapSpcInst)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(VUInstMapSpcInst)).click();
		Thread.sleep(2000);
		// Test client checkbox click
		ele2 = driver.findElement(By.xpath(VUSpcInstTestCckbx));
		if (!ele2.isSelected()) {
			ele2.click();
		} else {
			System.out.println("Checkbox is already selected");
		}
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(VUAccRgtsAct1));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(VUAccRgtsActSubBtn1)).click();
	}

	@Test(priority = 30, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC30() throws InterruptedException, AWTException {
		ViewUsersClick();
		String VUNewMailID = PropertyFileReader.propertymap.get("VUNewMailID");
		String ViewUserSts = PropertyFileReader.propertymap.get("ViewUserSts");
		ele2 = driver.findElement(By.xpath(ViewUserStsDD));
		Select sel = new Select(ele2);
		sel.selectByVisibleText(ViewUserSts);
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(ViewUserSrchBtn));
		ele1.click();
		ele1.sendKeys(VUNewMailID);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ViewUserSrchEditBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(VUInstMap)).click();
		driver.findElement(By.name(VUInstMapSpcInst)).click();
		Thread.sleep(2000);
		driver.findElement(By.name(VUInstMapSpcInst)).click();
		Thread.sleep(2000);
		// Test client checkbox click
		ele2 = driver.findElement(By.xpath(VUSpcInstTestCckbx));
		if (!ele2.isSelected()) {
			ele2.click();
		} else {
			System.out.println("Checkbox is already selected");
		}
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(VUAccRgtsAct1));
		Actions act = new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(VUTestCckbxActEdtUsr1)).click();
	}
}
