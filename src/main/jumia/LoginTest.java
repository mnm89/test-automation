package main.jumia;

import java.nio.file.Path;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import main.SetupTests;

@Test(suiteName = "browser", testName = "Jumia login")
public class LoginTest {

	private ExtentTest test;
	private ExtentReports extent;

	private static String TEST_NAME = "Jumia Login";

	@BeforeTest
	private void init() {

		// declaration and instantiation of objects/variables
		// System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		extent = new ExtentReports(Path
				.of(System.getProperty("user.dir"), "reports", TEST_NAME + "-" + System.currentTimeMillis() + ".html")
				.toString(), true);
		test = extent.startTest(TEST_NAME);
	}

	@AfterTest
	private void clear() {
		extent.endTest(test);
		extent.flush();

	}

	private void run(WebDriver driver) {
		driver.get("https://www.jumia.com.tn/customer/account/login/");
		test.log(LogStatus.PASS, "Page Loaded");
		test.log(LogStatus.FATAL, "TODO");
	}

	public void chrome() {
		test.log(LogStatus.INFO, "Using chrome");
		run(SetupTests.chrome);
	}

	public void firefox() {
		test.log(LogStatus.INFO, "Using firefox");
		run(SetupTests.firefox);
	}
}
