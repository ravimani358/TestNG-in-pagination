package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class homePage extends Browser {

	public static WebElement search_box = driver.findElement(By.xpath("//input[contains(@placeholder,'Search the web')]"));
		
	public static void click_Searchbox(){
		boolean checking_isclickable = wrapperclass.WebElement_click(search_box);
		System.out.println(checking_isclickable);
		try{
			Assert.assertTrue(checking_isclickable);
			String screenshotPath = TakesScreenshot("png", "verify true getting capture image or not");
			 test.log(Status.PASS,"checking_isclickable passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}catch(AssertionError e){
			test.fail("Element are not clickable");
			throw e;
		}
	}
	
	public static void sendKeys_Searchbox(String value) {
		wrapperclass.WebElement_sendKeys(search_box,value);
	}
	
}