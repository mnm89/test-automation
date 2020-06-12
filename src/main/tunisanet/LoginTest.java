package main.tunisanet;

import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import main.SetupTests;

@Test(suiteName = "browser", testName = "TunisiaNet login")
public class LoginTest {

	private ExtentTest test;
	private ExtentReports extent;

	private static String TEST_NAME = "TunisiaNet Login";

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
		driver.get("https://www.tunisianet.com.tn/connexion");
		test.log(LogStatus.PASS, "Page Loaded");
		WebElement password = driver.findElement(By.name("password"));
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("abcd@gmail.com");
		password.sendKeys("abcdefghlkjl");
		test.log(LogStatus.PASS, "Text Field Set");
		WebElement login = driver.findElement(By.id("submit-login"));
		login.click();
		test.log(LogStatus.PASS, "Login Done with Click");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password = driver.findElement(By.name("password"));
		email = driver.findElement(By.name("email"));
		if (email.getAttribute("value").contentEquals(""))
			test.log(LogStatus.PASS, "Email Field clear after login");
		else
			test.log(LogStatus.FAIL, "Email Field not clear after login");

		if (password.getAttribute("value").contentEquals(""))
			test.log(LogStatus.PASS, "Password Field clear after login");
		else
			test.log(LogStatus.FAIL, "Password Field not clear after login");
		email.sendKeys("abcd@gmail.com");
		password.sendKeys("abcdefghlkjl");
		login = driver.findElement(By.id("submit-login"));
		login.submit();
		test.log(LogStatus.PASS, "Login Done with Submit");
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
