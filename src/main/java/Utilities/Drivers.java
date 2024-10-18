package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivers {

	private WebDriver driver;
	@BeforeClass
	public void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeDriver() {
		driver.close();
	}
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}
