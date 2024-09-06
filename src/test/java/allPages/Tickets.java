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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tickets extends Locators{
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
	public void TicketsClick() throws InterruptedException {
		PropertyFileReader.propertyRead();
		String EmailId=PropertyFileReader.propertymap.get("EmailId");
		String Passwrd=PropertyFileReader.propertymap.get("Passwrd");
		driver.findElement(By.name(Email)).sendKeys(EmailId);
		driver.findElement(By.name(Password)).sendKeys(Passwrd);
		driver.findElement(By.id(LoginBtn)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(TicketsBtn)).click();
	}

	@Test(priority = 1, retryAnalyzer = ReRunFailedTestCase.class)
	public void TC01() throws InterruptedException {
		TicketsClick();
		String TktInstName=PropertyFileReader.propertymap.get("TktInstName");
		String TktCustName=PropertyFileReader.propertymap.get("TktCustName");
		ele1=driver.findElement(By.xpath(TktInstDD));
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText(TktInstName);
		//driver.findElement(By.xpath(TktCusName)).sendKeys(TktCustName);
	}

	@Test(priority =2 ,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC02() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktExpBtn)).click();
	}

	@Test(priority =3,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC03() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnAddCmt)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnAddCmtSave)).click();
		ele1=driver.findElement(By.xpath(TktViewBtnAddCmtMan));
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			ele2=driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div"));
			String text = ele2.getText();
			System.out.println("Alert message displayed like: "+text);
			ele1.click();
		}
		else {
			System.out.println("Mandatory message is not shown");
		}
	}


	@Test(priority =4,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC04() throws InterruptedException {
		TC03();
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnAddCmtCls)).click();
	}

	@Test(priority =5,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC05() throws InterruptedException {
		TC03();
		String TktViewBtnAddCmts=PropertyFileReader.propertymap.get("TktViewBtnAddCmts");
		ele1=driver.findElement(By.xpath(TktViewBtnAddCmtBox));
		ele1.sendKeys(TktViewBtnAddCmts);
		ele1.clear();
	}

	@Test(priority =6,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC06() throws InterruptedException {
		TC03();
		String TktViewBtnAddCmts=PropertyFileReader.propertymap.get("TktViewBtnAddCmts");
		ele1=driver.findElement(By.xpath(TktViewBtnAddCmtBox));
		ele1.sendKeys(TktViewBtnAddCmts);
		driver.findElement(By.xpath(TktViewBtnAddCmtSave)).click();
	}

	@Test(priority =7,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC07() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(TktViewBtnSndMail)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(TktViewBtnSndMailSav)).click();
		Thread.sleep(1000);
		ele1=driver.findElement(By.xpath(TktViewBtnSndMailMan));
		Thread.sleep(1000);
		if(ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			ele2=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[5]/div/div[2]/div/div[2]/div"));
			String text = ele2.getText();
			System.out.println("Alert message displayed like: "+text);
			ele1.click();
		}
		else {
			System.out.println("Mandatory message is not shown");
		}
	}

	@Test(priority =8,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC08() throws InterruptedException {
		TC07();
		String TktSndMailSubj=PropertyFileReader.propertymap.get("TktSndMailSubj");
		String TktSndMailMsg=PropertyFileReader.propertymap.get("TktSndMailMsg");
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnSndMailSubj)).sendKeys(TktSndMailSubj);
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnSndMailMsg)).sendKeys(TktSndMailMsg);
		driver.findElement(By.xpath(TktViewBtnSndMailSav)).click();
	}

	@Test(priority =9,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC09() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnSndMail)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnSndMailCls)).click();
	}

	@Test(priority =10,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC10() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnClsTkt)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnClsTktSav)).click();
		ele1=driver.findElement(By.xpath(TktViewBtnClsTktMan));
		Thread.sleep(2000);
		if(ele1.isDisplayed()) {
			System.out.println("Mandatory message is shown");
			ele2=driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[5]/div/div[2]/div/div[2]/div"));
			String text = ele2.getText();
			System.out.println("Alert message displayed like: "+text);
			ele1.click();
		}
		else {
			System.out.println("Mandatory message is not shown");
		}
	}

	@Test(priority =11,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC11() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnClsTkt)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnClsTktCls)).click();
	}

	@Test(priority =12,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC12() throws InterruptedException {
		TC01();
		String TktClsTktDes=PropertyFileReader.propertymap.get("TktClsTktDes");
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnClsTkt)).click();
		driver.findElement(By.xpath(TktViewBtnClsTktDes)).sendKeys(TktClsTktDes);
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnClsTktClr)).click();
	}

	@Test(priority =13,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC13() throws InterruptedException {
		TC01();
		String TktClsTktDes=PropertyFileReader.propertymap.get("TktClsTktDes");
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnClsTkt)).click();
		driver.findElement(By.xpath(TktViewBtnClsTktDes)).sendKeys(TktClsTktDes);
		Thread.sleep(2000);
		driver.findElement(By.xpath(TktViewBtnClsTktSav)).click();
	}

	@Test(priority =14,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC14() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		driver.findElement(By.xpath(TktViewBtnViewPyHstry)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/button")).click();
	}
	
	@Test(priority =14,retryAnalyzer = ReRunFailedTestCase.class)
	public void TC15() throws InterruptedException {
		TC01();
		driver.findElement(By.xpath(TktViewBtn)).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(TktViewBtnActBtn));
		Actions act=new Actions(driver);
		act.click().build().perform();
		element.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"simple-menu\"]/div[3]/ul/li[5]/div/div/i")).click();
	}
}




