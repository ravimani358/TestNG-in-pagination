package Pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Browser {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static ExtentReports extent ;
	protected static ExtentSparkReporter Report;
	protected static ExtentTest test;

	
	@BeforeSuite
	public static WebDriver setupWebDriver(){
		Singleton singletonInstance = Singleton.getInstance();
		driver = singletonInstance.getDriver();		
		return driver;
	}
	
	@BeforeClass()
	public static void extendReport() {
		extent  = new ExtentReports();
		String value = System.getProperty("user.dir");
		Report = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReportResults.html");
		extent.attachReporter(Report);
		test = extent.createTest("MyFirstTest")
				  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
	}
	
	@BeforeMethod
	public static void launchURL(){
		driver.get("https://search.yahoo.com/");
		driver.navigate().refresh();
	}
	
	
	@BeforeTest
	public static WebDriverWait getWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}

    public static String TakesScreenshot(String screenshotType, String Description){
        File DestFile = null;
        try{
            File location = new File("/screenshots");
            if(!location.exists()){
                location.mkdir();
            }
            String timestamp = java.time.LocalDateTime.now().toString().replace(":", "-");;
            String fileName = String.format("screenshot_%s_%s_%s.png", timestamp, screenshotType, Description);
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            DestFile = new File("screenshots/"+fileName);
            FileUtils.copyFile(srcFile, DestFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        return DestFile.getAbsolutePath();
    }
	
	@AfterSuite
	public static void generateReport() {
		extent.flush();
	}
	
}