package Testcases;

import org.testng.annotations.Test;
import Pages.Browser;
import Pages.DB;
import Pages.homePage;
import Pages.wrapperclass;

public class Testcase01 extends Browser{
	
	
	@Test(dataProvider = "getdata", dataProviderClass = DB.class)
	public static void Sheet1(String username, String password) throws InterruptedException{
		System.out.println("Username: " + username + ", Password: " + password);	
		
		homePage homePage_Action = new homePage();
		homePage_Action.click_Searchbox();
		Thread.sleep(3000);
		homePage_Action.sendKeys_Searchbox(username);
		
	}
}