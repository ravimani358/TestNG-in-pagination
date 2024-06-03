package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class wrapperclass extends Browser{

	
	public static boolean WebElement_click(WebElement element) {
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static void WebElement_sendKeys(WebElement element, String value) {
		try{
			Boolean iselement_Present = element.isDisplayed();
				wait.until(ExpectedConditions.visibilityOf(element));
				element.clear();
				element.sendKeys(value);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("you are getting error message");
		}
	}
}