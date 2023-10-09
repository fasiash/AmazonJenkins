package PageObject;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop;
import java.io.File;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utilities.ExcelUtility_Amazon;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Page_Objects_1 extends ExcelUtility_Amazon{
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	WebElement_xpaths a = new WebElement_xpaths();

	ExcelUtility_Amazon data = new ExcelUtility_Amazon();
	String path = "C://Users//Codetru//eclipse-workspace//SampleCodetruProject//AmazonJenkins//src//test//resources//TestData//Amazon.excel.xlsx";

	String mobile_number;
	String password;
	String firebolt_watch;

	String parentwindow;
	String parent1;
	String parent2;
	Set<String> windows ;
	Set<String> windows1;



	File file;
	ExtentReports ext;
	ExtentSparkReporter SparkReporter;
	SoftAssert softassert=new SoftAssert();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

	public void ExtentReportSetup() {
		ext=new ExtentReports();
		file = new File("AmazonReport.html");
		SparkReporter=new ExtentSparkReporter(file);
		ext.attachReporter(SparkReporter);
	}

	public void BrowserLaunch() throws Exception {
		
		SparkReporter.config().setTheme(Theme.DARK);
		SparkReporter.config().setDocumentTitle("AmazonReport");
		ext.attachReporter(SparkReporter);
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions opt = new ChromeOptions();
        //options.setBrowserVersion("117.0.5938.92");
        opt.addArguments("headless");
        opt.addArguments("disable-gpu");
        driver = new ChromeDriver(opt);
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(a.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		act = new Actions(driver);
		ExtentTest test = ext.createTest("1. User launched Amazon website ");
		WebElement main_page = driver.findElement(a.signin_page);

		if(main_page.getText().contains("Hello, sign in")) {
			test.pass("User successfully launched to Amazon Website");
			
		} else {
			test.fail("User unable to launch Amazon Website");
			test.addScreenCaptureFromPath(capturescreenshot(driver));
			//Assert.assertTrue(false);
			//Assert.assertTrue(false);
		}

	}
	public void Invalid_Login() throws Exception {
		ExtentTest test1 = ext.createTest("2. Sign in to the Amazon Account with Invalid Credentials ");
		try {
			driver.findElement(a.signin_btn).click();

			mobile_number = data.getCellData(path, 0,2, 0);
			password = data.getCellData(path, 0, 2, 1);

			driver.findElement(a.Email_field).sendKeys(mobile_number);
			driver.findElement(a.Continue_btn).click();
			driver.findElement(a.Password_field).sendKeys(password);
			driver.findElement(a.Login_btn).click();
			
			WebElement user_details = driver.findElement(By.id("glow-ingress-block"));


			if(user_details.getText().contains("Deliver to")) {
				test1.pass("User successfully login in to the Amazon Account");
			}
		}
		catch (Exception e) {
			test1.fail("User unable to login into the Amazon Account"+e.getMessage());
			test1.addScreenCaptureFromPath(capturescreenshot(driver));
		
		}
	}

	public void Login_into_Amazon() throws Exception {
		ExtentTest test2 = ext.createTest("3. Sign in to the Amazon Account ");
		try {
			driver.findElement(a.Email_field1).click();

			mobile_number = data.getCellData(path, 0, 1, 0);
			password = data.getCellData(path, 0, 1, 1);

			driver.findElement(a.Email_field).sendKeys(mobile_number);
			driver.findElement(a.Continue_btn).click();
			driver.findElement(a.Password_field).sendKeys(password);
			driver.findElement(a.Login_btn).click();

			WebElement user_details = driver.findElement(By.id("glow-ingress-block"));


			if(user_details.getText().contains("Delive")) {
				test2.pass("User successfully login in to the Amazon Account");
			}
		}
		catch (Exception e) {
			test2.fail("User unable to login into the Amazon Account"+e.getMessage());
			test2.addScreenCaptureFromPath(capturescreenshot(driver));
			
		}
	}


	public void Add_Watch_to_the_Cart() throws Exception {
		ExtentTest test3 = ext.createTest("4. Add the Watch to the Cart");

		try {
			firebolt_watch = data.getCellData(path, 0, 1, 2);

			driver.findElement(a.Search_bar).sendKeys(firebolt_watch);
			parentwindow = driver.getWindowHandle();
			driver.findElement(a.search_btn).click();
			driver.findElement(a.watch).click();

			Thread.sleep(3000);

			windows = driver.getWindowHandles();

			for( String window : windows) {
				if(!window.equals(parentwindow)) {
					driver.switchTo().window(window);
				}
			}

			Thread.sleep(3000);
			WebElement qty=driver.findElement(a.Quantity);

			Select qtydropdown= new Select(qty);

			qtydropdown.selectByValue("2");
			Thread.sleep(3000);

			driver.findElement(a.Add_to_cart_btn).click();
			WebElement cart1 = driver.findElement(a.Added_to_cart_text);

			Thread.sleep(3000);

			if(cart1.getText().contains("Added to Cart")) {
				test3.pass("Watch added to the cart successfully");
				driver.findElement(a.Cross_button).click();
				driver.close();
			}
		}
		catch (Exception e) {
			test3.fail("Unable to add Watch to the Cart"+e.getMessage());
			test3.addScreenCaptureFromPath(capturescreenshot(driver));
			
		}
	}

	public void Add_Mobile_to_the_Cart() throws Exception {

		ExtentTest test4 = ext.createTest("5. Add the Mobile to the Cart");
		try {
			driver.switchTo().window(parentwindow);

			driver.findElement(a.mobiles_tab).click();
			WebElement mobiles = driver.findElement(a.mobile_accessories);
			act.moveToElement(mobiles).perform();
			driver.findElement(a.Apple_tab).click();

			parent1= driver.getWindowHandle();

			driver.findElement(a.Apple_mobile).click();        

			Set<String> windows1=driver.getWindowHandles();
			for (String window1 : windows1) {
				if (!window1.equals(parent1)) {
					driver.switchTo().window(window1);
				}
			}

			Thread.sleep(3000);

			driver.findElement(a.Add_to_cart_btn).click();

			Thread.sleep(3000);
			WebElement cart2 = driver.findElement(a.Added_to_cart_text);
			if(cart2.getText().contains("Added to Cart")) {
				test4.pass("Mobile added to the cart successfully");
				driver.findElement(a.Cross_button).click();
				driver.close();
			}
		}
		catch (Exception e) {
			test4.fail("Unable to add Mobile to the Cart"+e.getMessage());
			test4.addScreenCaptureFromPath(capturescreenshot(driver));
			
		}
	}


	public void Add_Speaker_to_the_Cart() throws Exception {
		ExtentTest test5 = ext.createTest("6. Add the Boat Speaker to the Cart");

		try {

			driver.switchTo().window(parent1);
			driver.findElement(a.Cart).click();
			driver.findElement(a.Electronic_tab).click();
			WebElement audio = driver.findElement(a.Audio_btn);

			act.moveToElement(audio).perform();

			driver.findElement(a.Boat_brand).click();

			parent2 = driver.getWindowHandle();

			driver.findElement(a.Boat_Speaker).click();

			Set<String> windows2 = driver.getWindowHandles();

			for (String window2 : windows2) {
				if (!window2.equals(parent2)) {
					driver.switchTo().window(window2);
				}
			}
			driver.findElement(a.Add_to_cart_btn).click();
			Thread.sleep(3000);
			WebElement cart3 = driver.findElement(a.Add_to_cart_btn1);
			if(cart3.getText().contains("Added to Cart")) {
				test5.pass("Boat Speaker added to the cart successfully");
				driver.findElement(a.Cross_button).click();
				driver.close();
			}
		}
		catch (Exception e) {
			test5.fail("Unable to add Boat Speaker to the Cart"+e.getMessage());
			test5.addScreenCaptureFromPath(capturescreenshot(driver));
			
		}
	}

	public void Delete_products() throws Exception {

		ExtentTest test6 = ext.createTest("7.Delete products from cart ");

		try {
			driver.switchTo().window(parent2);
			driver.findElement(a.Cart).click();
			Thread.sleep(4000);
			driver.findElement(a.Delete_Apple_mobile).click();
			Thread.sleep(4000);
			driver.findElement(a.Delete_Boat_Speaker).click();
			WebElement cart4=driver.findElement(a.Added_to_cart_text);
			if(cart4.getText().contains("Added to Cart")) {
				test6.fail("Selected products are unable to removed");
				test6.addScreenCaptureFromPath(capturescreenshot(driver));
				
			}
		}catch (Exception e) {
			test6.pass("Selected products are removed from the cart");

		} 

	}
	public void Click_On_Checkout() throws Exception {
		ExtentTest test7 = ext.createTest("8.Check out successfully");
		try {
			driver.findElement(a.Checkout_Product).click();
			WebElement checkout_page=driver.findElement(a.Checkout_text);
			if(checkout_page.getText().contains("Checkout")) {
				test7.pass("Selected product checkout successfully");
			}
		}
		catch (Exception e) {
			test7.fail("Unable to checkout the selected products"+e.getMessage());
			test7.addScreenCaptureFromPath(capturescreenshot(driver));
			
		}
	}
	public void Return_to_cart() throws Exception {
		ExtentTest test8 = ext.createTest("9.Return to cart");
		try {
			driver.findElement(a.Logo).click();
			driver.findElement(a.Return_to_cart).click();
			driver.findElement(a.Delete_watch).click();
			WebElement cart=driver.findElement(a.Empty_cart);
			if(cart.getText().contains("Your Amazon Cart is empty.")) {
				test8.pass("Your cart is empty");
			}
		}catch (Exception e) {
			test8.fail("Your cart is not empty"+e.getMessage());
			test8.addScreenCaptureFromPath(capturescreenshot(driver));
		
		}
	}

	public void afterTest() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	public void teardown() throws Exception {
		ext.flush();
		Desktop.getDesktop().browse(new File("Spark.html").toURI());        
	}

	public static String capturescreenshot(WebDriver driver) throws Exception {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationfilepath=new File("C://Users//Codetru//Downloads//Amazon_in//Amazon_in//src//Screenshots"+System.currentTimeMillis()+".png");    
		String absolutepathlocation =destinationfilepath.getAbsolutePath();
		FileUtils.copyFile(srcfile, destinationfilepath);
		return absolutepathlocation;
	}

}
