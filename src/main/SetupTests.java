package main;

import java.nio.file.Path;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test(suiteName = "browser")
public class SetupTests {
	public static ChromeDriver chrome;
	public static FirefoxDriver firefox;

	private static String TEST_URL = "https://www.google.tn";

	@BeforeSuite
	private void init() {

		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.gecko.driver",
				Path.of(System.getProperty("user.dir"), "drivers", "geckodriver.exe").toString());
		firefox = new FirefoxDriver();
		// comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver",
				Path.of(System.getProperty("user.dir"), "drivers", "chromedriver.exe").toString());
		chrome = new ChromeDriver();

	}

	public void webDriversCheck() {
		chrome.get("https://www.google.tn");
		System.out.println("Chrome Loaded ");
		firefox.get("https://www.google.tn");
		System.out.println("Firefox Loaded ");
	}

	@AfterSuite
	private void clear() {
		chrome.close();
		System.out.println("Chrome Closed ");
		firefox.close();
		System.out.println("Firefox Closed ");
	}
}
