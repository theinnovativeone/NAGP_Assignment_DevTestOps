package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.PropertyFileReader;

public class BasePage {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver = null;
	public static String browserName = null;
	public static String url = null;

	
	public WebDriver setupDriver(WebDriver tempDriver, ITestContext context) {
		driver = initializeDriver(tempDriver);
		context.setAttribute("WebDriver", driver);
		BasePage.navigateToUrl(driver);
		driver.manage().window().maximize();

		return driver;
	}
	
	
   public static WebDriver initializeDriver(WebDriver driver) {	
	   browserName = PropertyFileReader.getBaseData("browser");
	   
		switch(browserName) {
		case "chrome": 
			driver = new ChromeDriver();
		break;
		case "firefox":   //not working, need to check the path of browser/driver
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\snehagupta01\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			driver = new FirefoxDriver(options);
		break;
		case "edge": 
			driver = new EdgeDriver();
		}
		
		return driver;
	}

	public static void navigateToUrl(WebDriver driver) {
		url = PropertyFileReader.getBaseData("url");
		driver.get(url);
	}

	public static void tearDown() {
		if (null != driver) {
			driver.quit();
		}
	}

}