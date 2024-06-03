package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Singleton {
	private static Singleton Instance;
	private static WebDriver driver;
	
	private Singleton() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
	}
	
	public static synchronized Singleton getInstance() {
		if(Instance == null) {
			Instance = new Singleton();
		}
		return Instance;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}